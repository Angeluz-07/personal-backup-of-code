/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_9_Tuttoring.PacmanJavaFx;

//App class imports
import Unidad_9_Tuttoring.PaneOrganizer.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.scene.Scene;
import javafx.application.*;
// package includes Pane class and its subclasses
import javafx.scene.layout.*; 
//package includes Label, Button classes
import javafx.scene.control.*;
//package includes ActionEvent, EventHandler classes
import javafx.event.*;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.util.Duration;
import javafx.animation.*;
import javafx.scene.Cursor;
import javafx.beans.property.*;
public class Pacman implements Runnable {    
    private Ellipse head;
    private Ellipse eye;
    private Polygon mouth;      
        
    @Override
    public void run(){        
      Platform.runLater(()->{
                System.out.println("hi friend");
      });       
    }
    public static class Constants{
        static double CONTAINER_WITDH=300;
        static double CONTAINER_HEIGHT=300;
        
        static double RADIUS_EYE=5;        
        public static double RADIUS_HEAD=30;       
        /* START_X and START_Y should 
           have the same value as radius */
        static double START_X=30;
        static double START_Y=30;
        
        /* offset the eye, consistent with
           the position of the head */
        static double EYE_X_OFFSET=10;        
        static double EYE_Y_OFFSET=15;
        
        static double DISTANCE_X=20;
        static double DISTANCE_Y=10;                
    }
    
    public Pacman(Pane container){                      
        head=new Ellipse(Constants.RADIUS_HEAD,Constants.RADIUS_HEAD);             
        head.setFill(Color.YELLOW);
        head.setStroke(Color.BLACK);
        
        eye=new Ellipse(Constants.RADIUS_EYE,Constants.RADIUS_EYE);                    
        eye.setFill(Color.BLACK);               
        
        //mouth=new Polygon(30,30,60,40,60,20);
        //mouth.setStroke(Color.BLACK);
        
        this.setXLoc(Constants.START_X);    
        this.setYLoc(Constants.START_Y);   
        //this.setupTimeLine();                         
        
        //head.setCursor(Cursor.WAIT);    
        head.setOnMouseReleased(e->{            
            head.setFill(Color.color(Math.random(), Math.random(), Math.random()));                                  
            System.out.println("released");
        });
        
        head.setOnMouseDragged(e->{
            Bounds bounds = container.getLayoutBounds();                      
            setXLoc(e.getX(),bounds.getMaxX());
            setYLoc(e.getY(),bounds.getMaxY());
            System.out.println(e.getX()+" "+e.getY());
            //Node n = (Node)e.getSource();   
            //n.setTranslateX(n.getTranslateX() + e.getX());
            //n.setTranslateY(n.getTranslateY() + e.getY());
        });           
        container.getChildren().add(head);
        //container.setFocusTraversable(true);
        container.setOnKeyPressed(new MoveHandler(container));       
    }
    
    public void setXLoc(double x) {           
        head.setCenterX(x);
        eye.setCenterX(x+Constants.EYE_X_OFFSET);
        System.out.println("newX="+x);
    }
    
    public void setYLoc(double y) {
        head.setCenterY(y);  
        eye.setCenterY(y-Constants.EYE_Y_OFFSET);
        System.out.println("newY="+y);
    }
    
    //Overloading methods!!!!
    public void setXLoc(double newX,double maxX) {           
        boolean xIsValid;
        xIsValid=(Constants.RADIUS_HEAD<=newX) && (newX<=(maxX-Constants.RADIUS_HEAD));                                        
        if(!xIsValid) return;      
        setXLoc(newX);
    }
    public void setYLoc(double newY,double maxY) {
        boolean yIsValid;
        yIsValid=(Constants.RADIUS_HEAD<=newY) && (newY<=(maxY-Constants.RADIUS_HEAD));                   
        if(!yIsValid) return;
        setYLoc(newY);
    }
    
    public double getXLoc(){        
        return head.getCenterX();
    }
    public double getYLoc(){
        return head.getCenterY();
    }
            
    public void setupTimeLine(){
        KeyFrame kf=new KeyFrame(Duration.seconds(1),new TimeHandler());
        Timeline timeline=new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();   
    }
    private class TimeHandler implements EventHandler<ActionEvent>{
        boolean visibility;
        public TimeHandler(){
            visibility=true;
        }
        @Override
        public void handle(ActionEvent e){            
            visibility=!visibility;
            head.setOpacity(Math.random());
            head.setVisible(visibility);
            head.setFill(Color.color(Math.random(), Math.random(), Math.random()));                      
            //System.out.println(e.getSource().toString());
        }
    }
    
    private class MoveHandler  implements EventHandler<KeyEvent> {
        Pane container;
        public MoveHandler(Pane container){
            this.container=container;
        }       
        @Override        
        public void handle(KeyEvent e){                
            Bounds bounds = container.getLayoutBounds();                                             
            double newX,newY,maxX,maxY;
            //get the witdh and the height of the container pane
            maxX=bounds.getMaxX();
            maxY=bounds.getMaxY();
            double HL=maxX-2*Constants.RADIUS_HEAD;
            double VL=maxY-2*Constants.RADIUS_HEAD;            
            //creating the transition
            TranslateTransition tt=new TranslateTransition();
            tt.setNode(head);
            
            //speed of my transition
            tt.setDuration(Duration.millis(2000));
            //amount of times i want this transition to be done
            tt.setCycleCount(1);            
            //Line line=new Line();                                 
            //tt.setFromX(bounds.get);
            switch(e.getCode()){
                 case DOWN:                     
                    newY=head.getCenterY()+Constants.DISTANCE_Y;                    
                    setYLoc(newY,maxY);                 
                    //if(head.getCenterY()<(bounds.getMaxY()-head.getRadiusY())) setYLoc(newY);                    
                    break;
                case UP:               
                    newY=head.getCenterY()-Constants.DISTANCE_Y;                   
                    setYLoc(newY,maxY);                                       
                    //if(head.getCenterY()>(bounds.getMinY()+head.getRadiusY())) setYLoc(newY);                    
                    break;                
                case RIGHT:                                        
                    newX=head.getCenterX()+Constants.DISTANCE_X;                                                        
                    setXLoc(newX,maxX);                 
                    //if(head.getCenterX() < (bounds.getMaxX() - head.getRadiusX())) setXLoc(newX);                                       
                    break;
                case LEFT:                  
                    newX=head.getCenterX()-Constants.DISTANCE_X;                     
                    setXLoc(newX,maxX);                    
                    //if(head.getCenterX() > (bounds.getMinX() + head.getRadiusX())) setXLoc(newX);                    
                    break;                              
            }           
            //transition.setPath(line);   
            //tt.play();
            tt.setOnFinished(e1->{
                System.out.println(head.getCenterY());
                System.out.println(bounds.getMaxX()+" "+bounds.getMaxY());
            });
            //just to see the object bounds
            //System.out.println(bounds.toString());
        }
    }

}
