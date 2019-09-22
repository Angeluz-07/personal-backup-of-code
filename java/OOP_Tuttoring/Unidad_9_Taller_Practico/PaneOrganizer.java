/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_9_Taller_Practico;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author User
 */
public class PaneOrganizer {
    Pane root;    
    Label greeting,userLabel,passwordLabel;
    TextField userTextField,passwordTextField;
    Button registerButton,loginButton;
    GridPane form;
    
    public PaneOrganizer(){
        root=new BorderPane();         
        
        form=new GridPane();        
        
        greeting=new Label("Welcome");
        form.add(greeting, 0, 0);
        
        userLabel=new Label("User :");
        userTextField=new TextField("");       
        form.add(userLabel,0,1);
        form.add(userTextField,1,1);
                
        
        passwordTextField=new TextField("");                  
        passwordLabel=new Label("Password :");        
        form.add(passwordLabel,0,2);
        form.add(passwordTextField,1,2);
       
        HBox buttonsContainer=new HBox();
        registerButton=new Button("Register");
        registerButton.setOnAction(e->{
           String name=userTextField.getText();
           String password=passwordTextField.getText();
           User u=new User(name,password); 
           User.users.add(u);
           System.out.println("The user "+
                              u.toString() +
                              " has been added.");
           userTextField.setText("");
           passwordTextField.setText("");
        });
        loginButton= new Button("Log in");
        loginButton.setOnAction(e->{
           String name=userTextField.getText();
           String password=passwordTextField.getText();
           User userEntered=new User(name,password); 
           if(User.users.contains(userEntered)){                            
               System.out.println("The user is registered");
           }else{               
               System.out.println("The user is not registered");
           }
           userTextField.setText("");
           passwordTextField.setText("");
        });
        buttonsContainer.getChildren().addAll(registerButton,loginButton);
        buttonsContainer.setSpacing(10);
        form.add(buttonsContainer,1,3);
       
         
        form.setPadding(new Insets(10,10,10,10));
        form.setHgap(10);
        form.setVgap(10);
        ((BorderPane)root).setCenter(form);
    }

    public Pane getRoot() {
        return root;
    }
    
}
