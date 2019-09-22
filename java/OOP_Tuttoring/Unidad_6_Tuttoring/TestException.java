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
public class TestException {
    public static void main(String[] args){
        try{
            if(args.length==1){
                throw IllegalArgumentException();
            }
        }catch(Exception e){
            
        }catch(IllegalArgumentException e){
            
        }
    }

    private static Exception IllegalArgumentException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
