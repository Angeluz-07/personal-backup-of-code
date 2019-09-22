/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_9_Tuttoring.TicTacToeJavafx;

import Unidad_6_Tuttoring.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
// package includes Pane class and its subclasses
import javafx.scene.layout.*;
//package includes Label, Button classes
import javafx.scene.control.*;



public class TicTacToe {
    private Sign[][] board;
    private Button[][] boardButton;
    private BorderPane root;
    private Label turnoLabel;//shows the current turn    
    private Sign turnoSign=Sign.X; //a enum that holds the current turn
    
    public enum Sign {O,X,E};

    public TicTacToe(){                     
        root=new BorderPane();
        GridPane table=new GridPane();
        
        board = new Sign[3][3];                        
        boardButton=new Button[3][3];               
        
        for(int i=0; i<board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Sign.E;
                
                boardButton[i][j] =new Button();               
                boardButton[i][j].setMinSize(50,50);
                              
                //each button has a handler associated with its position
                boardButton[i][j].setOnAction(new MarkHandler(i,j));
                
                //add each button to the GridPane
                table.add(boardButton[i][j],j,i);  
            }            
        }                        
        
        table.setAlignment(Pos.CENTER);
        table.setHgap(10);
        table.setVgap(10);
        root.setCenter(table);
                
        turnoLabel=new Label(turnoSign.toString()+" starts!!");               
        turnoLabel.setMinHeight(25);
        
        //this HBox is to align turnoLabel
        HBox alignTurnLabel= new HBox();               
        alignTurnLabel.getChildren().add(turnoLabel);
        alignTurnLabel.setAlignment(Pos.CENTER);
        
        root.setTop(alignTurnLabel);        
    }

    private class MarkHandler implements EventHandler<ActionEvent>{
        int i,j;
        public MarkHandler(int i, int j){
            this.i=i;
            this.j=j;
        }
        @Override
        public void handle(ActionEvent event){                      
            boolean did_mark=mark(turnoSign,this.i,this.j);            
            if(!did_mark) return;                                                                          
            
            boolean didLine=checkLine(board,turnoSign,i,j);            
            if(didLine){
                System.out.println("The Winner is "+turnoSign.toString()+" !!");
                emptyBoards();
            }                       
            //printBoard(); this is to check the mapping
            changeTurn();
            turnoLabel.setText("The current turn is : "+turnoSign);
        }
    }
    
    public Pane getRoot() {
        return root;
    }

    private void changeTurn(){
        switch(turnoSign){
            case X:
                turnoSign=Sign.O;
                return;
            case O:
                turnoSign=Sign.X;                
        }                
    }
    
    private void emptyBoards(){
        for(int i=0; i<board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Sign.E;                              
                boardButton[i][j].setText("");
            }            
        }           
    }
    /*
    public void printBoard(){                
        for(int i=0; i<board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" "+board[i][j]+" ");
            }            
            System.out.println("");
        }        
        System.out.println("");
    }
    */
    private boolean mark(Sign s,int i, int j){      
        if(!indexIsValid(i)||!indexIsValid(j)){
            throw new IllegalArgumentException("los valores de i,j deben estar entre 0 y 2");
        }
        if(board[i][j]!=Sign.E){
           return false; 
        }
        board[i][j]=s;        
        
        boardButton[i][j].setText(s.toString());       
        return true;        
    }
    
    public static boolean indexIsValid(int index){
        return (index>=0&&index<=2);       
    }
    
    //checks if there's a winner,if the last movement made a line
    public static boolean checkLine(Sign[][] b,Sign s,int i, int j){
   
        /* the curent row and column */               
        Sign[] row={b[i][0],b[i][1],b[i][2]};    
        Sign[] column={b[0][j],
                       b[1][j],
                       b[2][j]};        
        /* left and right  diagonal */
        Sign[] leftDiagonal={b[0][0],b[1][1],b[2][2]};
        Sign[] rightDiagonal={b[0][2],b[1][1],b[2][0]};
        
        if(isLine(row,s)) return true;
        else if(isLine(column,s)) return true;
        else if(isLine(leftDiagonal,s)) return true;
        else if(isLine(rightDiagonal,s)) return true;                
        return false;        
    }
    
    public static boolean isLine(Sign[] line,Sign s){
        for(Sign sTemp:line){
            if(sTemp!=s) return false;
        }
        return true;
    }  
    
}
