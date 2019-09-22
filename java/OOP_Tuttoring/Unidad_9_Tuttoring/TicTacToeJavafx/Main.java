/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_9_Tuttoring.TicTacToeJavafx;

import Unidad_6_Tuttoring.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

/**
 *
 * @author User
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage){
        TicTacToe gameJavaFx=new TicTacToe();
        Scene scene=new Scene(gameJavaFx.getRoot(),310,310);              
        
        //uncomment this line and test the program to see the magic...
        //scene.getStylesheets().add(getClass().getResource("GreatStyle.css").toExternalFo‌​rm());
        
        primaryStage.setTitle("Tic Tac Toe!");
        primaryStage.setScene(scene);       
        primaryStage.show();
    }
    
   
    public static void main(String args[]){      
        launch(args);
    }
}
