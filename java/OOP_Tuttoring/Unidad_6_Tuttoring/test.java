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
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        //asuma que s ya esta definida
            Person u = new Person("persona",1,"pais");
        
            Person v= new Person("Persona",2,"PAis");
            System.out.println("Success");       
        }
        catch(AException e){
            System.out.println("Bad URL");
        }
        catch(BException e){
            System.out.println("Bad file contents");
        }
        catch (Exception e){
        System.out.println("General exception");
        }
        finally {
            System.out.println("Doing finally part");
        }
    System.out.println("Carrying on");

    }
    
}
