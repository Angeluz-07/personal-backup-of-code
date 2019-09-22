/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author User
 */
public class WordBreakString {
    public static void main(String[] args){
        List<String> dict= new ArrayList(
            Arrays.asList("i","like","sam","sumg","samsumg","ilikesamsumg","ice","cream","icecream","man","go","mango"));        
        
         //Arrays.asList("i","dlike","ssam","sumg","samsumg"));        
        
        List<String> list=new ArrayList();
        String s="ilikesamsumg";        
        String w="";        
        for(int i=0;i<s.length();i++){
            for(int j=s.length();j>=i;j--){
                if(dict.contains(s.substring(i,j))){
                    System.out.println(s.substring(i,j));
                }
            }
        }       
        //System.out.println(s.substring(0, s.length()-1));
        //f1(s,dict);
    }  
    
    public static void f1(String w,List<String> d){        
        if (d.contains(w)){
            System.out.println(w);                       
        }
        else{
            //System.out.println(w.substring(0, w.length()-1));
            f1(w.substring(0, w.length()-1),d);            
        }
    }
}

