/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_7_Tuttoring;

import java.io.FileReader;
import java.io.BufferedReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author User
 */
public class Trying {
    /*
       Read the file, count the frec of the file
    */
    public static void main(String[] args){        
        Scanner input;

        String pathDir="C:\\Users\\User\\Documents\\NetBeansProjects\\OOP_Tuttoring\\src\\Unidad_7_Tuttoring\\";                
        String poem="poema.txt";    
        String finalPath=pathDir+poem;
        
        BufferedReader br;
        //ArrayList<String> words=new ArrayList();
        //Map<String,Integer[]> my_map=new TreeMap();
        try{
            br=new BufferedReader(new FileReader(finalPath));
            Scanner sc;
            
            String line="";
            String word="";
            while((line=br.readLine())!=null){                                                                       
                line=line.replaceAll("[^A-Za-z ]", "");                                                
                //line=line.replaceAll("[^\\w+]", " ");
                /*
                sc=new Scanner(line);                
                while(sc.hasNext()){
                    word=sc.next();
                    if(my_map.containsKey(word)){
                        my_map.get(word)[0]+=1;
                    }else{         
                        //ff-> frecuency on file,fl-> frecuency by line
                        Integer[] ff_fl=new Integer[]{1,1};                  
                        my_map.put(word,ff_fl);
                    }
                }*/
                System.out.println(line);
            }
            br.close();
            /*
            System.out.println(my_map.toString());
            for(String w:my_map.keySet()){
                        System.out.print(w+" ");
                        for(int v: my_map.get(w)){
                            System.out.print(v+";");
                        }
                        System.out.println("");                 
            } */
        }catch(Exception e){
            System.out.println(e);              
        }                       
    }
}
