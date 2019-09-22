/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_6_Tuttoring;

/**
 *
 * @author User
 */
public class TicTacToe {
    private Sign[][] board;
    
    public TicTacToe(){                     
        board = new Sign[3][3];
        for(int i=0; i<board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Sign.E;
            }            
        }
        
    }
    public void printBoard(){
        System.out.println("  *****");
        System.out.println("  Board");
        System.out.println("  *****");        
        for(int i=0; i<board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" "+board[i][j]+" ");
            }            
            System.out.println("");
        }        
    }
    
    public void mark(Sign s,int i, int j){      
        if(!indexIsValid(i)||!indexIsValid(j)){
            throw new IllegalArgumentException("los valores de i,j deben estar entre 0 y 2");
        }
        if(board[i][j]!=Sign.E){
            throw new IllegalArgumentException("Esa casilla ya esta ocupada");
        }
        board[i][j]=s;
        
        boolean makeLine=checkLine(board,s,i,j);
        System.out.printf( makeLine ? "You make a line!\n":"");
        
    }    
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
    public static boolean indexIsValid(int index){
        return (index>=0&&index<=2);       
    }
    
    public static boolean isLine(Sign[] line,Sign s){
        for(Sign sTemp:line){
            if(sTemp!=s) return false;
        }
        return true;
    }
    
}
