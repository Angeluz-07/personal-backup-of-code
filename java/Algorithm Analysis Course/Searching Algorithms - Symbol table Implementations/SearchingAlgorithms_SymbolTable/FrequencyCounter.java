/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package SearchingAlgorithms_SymbolTable;

import java.io.File;
import java.util.Scanner;


public class FrequencyCounter
{
public static void main(String[] args)
{
    int minlen =3 ; // key-length cutoff
    
    String pathDir="C:\\Users\\User\\Documents\\NetBeansProjects\\Algorithm_Analysis\\src\\SearchingAlgorithms_SymbolTable\\";
    String tinyTale="tinyTale.txt";
    String tale="tale.txt";    
    String leipzig="leipzig1M.txt";
    String finalPath=pathDir+leipzig;
    try{
        Scanner input=new Scanner(new File(finalPath));        
        
        //here i take the time of creation of symbol table
        long time_1,time_2,difference=0,sum=0;
        
        time_1 = System.nanoTime(); 
        //BST<String, Integer> st = new BST<>();               
        //RedBlackBST<String, Integer> st = new RedBlackBST<>();        
        LinearProbingHashST<String, Integer> st =new LinearProbingHashST<>();
        time_2= System.nanoTime();
        
        difference=time_2 - time_1 ;
        sum+=difference;
        while (input.hasNext())
        {// Build symbol table and count frequencies.
            String word = input.next();
            if (word.length() < minlen) continue; // Ignore short keys.
            
            time_1 = System.nanoTime(); 
            
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
            
            time_2= System.nanoTime();        
            difference=time_2 - time_1 ;
            sum+=difference;
        }                         
        System.out.println("The difference is: " +sum);
        input.close();
        // Find a key with the highest frequency count.
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()){
            //System.out.println(word+ " " + st.get(word));
            if (st.get(word) > st.get(max)){
                max = word;//the first max                
            }
        }
        StdOut.println(max + " " + st.get(max));
    }catch(Exception e){        
    }
    
}
}
