/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_6_Tuttoring;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PersonTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        Person p= new Person("ale",120,"ecuador");
        }catch(Exception e){
            System.out.println(e);
        }
        /*
        try{
            Person p= new Person("ale",10,"ecuador");
            p.setAge(101);
        }catch(IllegalArgumentException e){
            System.out.println(e);
        } catch (AException ex) {
            Logger.getLogger(PersonTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BException ex) {
            Logger.getLogger(PersonTest.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
}
