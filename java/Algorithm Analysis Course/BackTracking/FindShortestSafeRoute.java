/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackTracking;
import java.io.*;
import java.util.*;

public class FindShortestSafeRoute {   
    static Integer minCount = null;
    public static void display(int[][] matrix){
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0; j<matrix[0].length;j++){
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println("");
        }
    }
    
    public static int findPath(int[][] matrix,boolean[][] possiblePath1){
        
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==1){
                boolean[][] possiblePath = possiblePath1;
                dfs(matrix,i,0,0, possiblePath);
                if(minCount!=null && minCount==matrix[0].length-1){
                    break;
                }
            }
        }
        
        //No route found
        if(minCount==null){
            minCount = 0;
        }
        return minCount;
    }
    
    public static void dfs(int[][] matrix, int x, int y, int count, boolean[][] possiblePath){
        
        //checking boundary conditions
        if(x<0 || y<0 || x==matrix.length || y==matrix[0].length){
            return;
        }
        if(minCount!=null && count > minCount){
            return;
        }
        
        if(possiblePath[x][y]==false){
            return;
        }

        //if last column
        if(y==matrix[0].length-1){
            System.out.println("Found path minCount="+minCount+" count="+count);
            if(minCount==null){
                minCount = count;
            }
            else{
                minCount = Math.min(minCount,count);
            }
            return;
        }

        possiblePath[x][y]=false;
        dfs(matrix,x,y+1,count+1,possiblePath);
        dfs(matrix,x,y-1,count+1,possiblePath);
        dfs(matrix,x+1,y,count+1,possiblePath);
        dfs(matrix,x-1,y,count+1,possiblePath);
        possiblePath[x][y]=true;
    }
    
    public static void preFillMap(int[][] matrix,boolean[][] possiblePath){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                possiblePath[i][j] = true;
            }
        }
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                //landmines found
                if(matrix[i][j]==0){
                    if(isValidCell(matrix,i,j+1)) possiblePath[i][j+1] = false;
                    if(isValidCell(matrix,i,j-1)) possiblePath[i][j-1] = false;
                    if(isValidCell(matrix,i+1,j)) possiblePath[i+1][j] = false;
                    if(isValidCell(matrix,i-1,j)) possiblePath[i-1][j] = false;
                }
            }
        }
    }
    
    public static boolean isValidCell(int[][] matrix,int x,int y){
        if(x<0 || y<0 || x==matrix.length || y==matrix[0].length){
            return false;
        } 
        return true;
    }

    public static void main (String[] args) {
	    
    int[][] matrix = 
        {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
            { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }
        };
    
    
    boolean[][] possiblePath = new boolean[matrix.length][matrix[0].length];
    preFillMap(matrix,possiblePath);	
    //display(matrix);
    System.out.println(findPath(matrix,possiblePath));
	
    }

}
