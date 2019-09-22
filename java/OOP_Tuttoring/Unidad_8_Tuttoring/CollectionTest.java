/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_8_Tuttoring;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author User
 */
public class CollectionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
       Map<String, Integer> counts = new TreeMap();
       counts.put("a", 1);
       counts.put("b", 2);
       counts.put("f", 3);   
       counts.put("g", 3);
       counts.put("d", 3);                   
        System.out.println(Collections.frequency(counts.keySet(), "d"));
       /*
       for(Map.Entry<String,Integer> m :counts.entrySet()){
           System.out.println(m);
       }*/
       
        System.out.println(counts.toString());
    }
    
}
