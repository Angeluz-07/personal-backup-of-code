/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTracking;

/**
 *
 * @author User
 */
public class PrintAllPermutations_String {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s="ABC";
        
        for(int i=0;i<s.length();i++){            
            System.out.print(s.charAt(i));
        }
        // TODO code application logic here
    }
    
}
