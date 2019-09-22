/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_9_Tuttoring.PacmanJavaFx;

import Unidad_9_Tuttoring.PacmanJavaFx.Pacman.Constants;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;

/**
 *
 * @author User
 */
public class PaneOrg {
    private BorderPane root;
    private Pacman pacman;
    private Pane container;
    
    //private ShadowPacman shadowPacman;
    public PaneOrg(){
        root=new BorderPane();        
        container=new Pane();
        container.setMaxSize(Constants.CONTAINER_WITDH, Constants.CONTAINER_HEIGHT);                                   
        container.setStyle("-fx-background-color:#de4918");        
                

        //shadowPacman=new ShadowPacman(container);
        pacman=new Pacman(container);
        //Thread t1 = new Thread(shadowPacman);
        //Thread t2 = new Thread(pacman);
        //t1.start();
        //t2.start();
        root.setCenter(container);
    }

    public Pane getRoot() {
        return root;
    }   

    public Pane getContainer() {
        return container;
    }
    
}
