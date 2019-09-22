/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTracking;


import java.util.*;
import java.lang.*;
import java.io.*;

public class WordBreak{
    
    public static void main(String args[]){
        Set<String> dict= new HashSet(
            Arrays.asList("i","like","sam","sumg","samsumg")); 
        String S="ilikesamsumg";
        List<String> result=wordBreak(S,dict);
        System.out.println(result.toString());
    }
    public static List<String> wordBreak(String s, Set<String> wordDict) {
    ArrayList<String> [] pos = new ArrayList[s.length()+1];
    pos[0]=new ArrayList<String>();
 
    for(int i=0; i<s.length(); i++){
        if(pos[i]!=null){
            for(int j=i+1; j<=s.length(); j++){
                String sub = s.substring(i,j);
                if(wordDict.contains(sub)){
                    if(pos[j]==null){
                        ArrayList<String> list = new ArrayList<String>();
                        list.add(sub);
                        pos[j]=list;
                    }else{
                        pos[j].add(sub);
                    }
 
                }
            }
        }
    }
 
    if(pos[s.length()]==null){
        return new ArrayList<String>();
    }else{
        ArrayList<String> result = new ArrayList<String>();
        dfs(pos, result, "", s.length());
        return result;
    }
}
 
public static void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
    if(i==0){
        result.add(curr.trim());
        return;
    }
 
    for(String s: pos[i]){
        String combined = s + " "+ curr;
        dfs(pos, result, combined, i-s.length());
    }
}

}