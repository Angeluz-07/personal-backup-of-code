/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

import java.nio.file.Paths;
import java.util.Scanner;

/* Dynamic Programming Java implementation of LCS problem */
public class LongestCommonSubsequence
{
 
  /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
  int lcs( char[] X, char[] Y, int m, int n )
  {
    int L[][] = new int[m+1][n+1];
 
    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
    for (int i=0; i<=m; i++)
    {
      for (int j=0; j<=n; j++)
      {
        if (i == 0 || j == 0)
            L[i][j] = 0;
        else if (X[i-1] == Y[j-1])
            L[i][j] = L[i-1][j-1] + 1;
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]);
      }
    }
  return L[m][n];
  }
 
  /* Utility function to get max of 2 integers */
  int max(int a, int b)
  {
    return (a > b)? a : b;
  }
 
  public static void main(String[] args)
  {
    Scanner input;

        String pathDir="C:\\Users\\User\\Documents\\NetBeansProjects\\Algorithm_Analysis\\src\\DynamicProgramming\\";                
        String homosapiens10="HomoSapiens10.txt";
        String musmuscula10="MusMuscula10.txt";                
       
        String chro_human="",chro_mouse="";
        try{            
            //get chromosome  of human
            input=new Scanner(Paths.get(pathDir+homosapiens10));            
            while(input.hasNext()){                                                                                                                  
                chro_human+=input.next();                                                                        
            }                                  
            input.close();
            
            //get chromosome of mouse
            input=new Scanner(Paths.get(pathDir+musmuscula10));            
            while(input.hasNext()){                                                                                                                  
                chro_mouse+=input.next();                                                                        
            }                                  
            input.close();
           
            System.out.println("Chromosome human: \n"+chro_human);
            System.out.println("Chromosome mouse: \n"+chro_mouse);
        
        }catch(Exception e){
            System.out.println(e);              
        }  
      
    
    LongestCommonSubsequence lcs = new LongestCommonSubsequence();
    String s1 = chro_human;
    String s2 = chro_mouse;
 
    char[] X=s1.toCharArray();
    char[] Y=s2.toCharArray();
    int m = X.length;
    int n = Y.length;
 
    System.out.println("Length of LCS is" + " " +
                                  lcs.lcs( X, Y, m, n ) );
  }
 
}
