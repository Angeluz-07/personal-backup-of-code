/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTracking;

import java.util.LinkedList;

/**
 *
 * @author User
 */
public class PalindromeSubstrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s="geeks";
        LinkedList<String> l=new LinkedList();
        
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                l.add(j, s);
                l.add(String.valueOf(s.charAt(j)));//add 1 char
            }                        
            System.out.println(s.charAt(i));
            System.out.println(l.toString());
        }
    }
    
}
