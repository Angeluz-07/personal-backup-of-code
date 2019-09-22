/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

/*
    The problem is very similar to Knapsack 01 Problem, so
    we start from it to solve the Lazy Student problem.
*/
import java.util.Scanner;
 
public class LazyStudent
{
    public void solve(int[] wt, int[] val, int W, int N)
    {
        int NEGATIVE_INFINITY = Integer.MIN_VALUE;
        int[][] m = new int[N + 1][W + 1];
        int[][] sol = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++)
        {
            for (int j = 0; j <= W; j++)
            {
                int m1 = m[i - 1][j];
                int m2 = NEGATIVE_INFINITY; 
                if (j >= wt[i])
                    m2 = m[i - 1][j - wt[i]] + val[i];
                m[i][j] = Math.max(m1, m2);
                sol[i][j] = m2 > m1 ? 1 : 0;
            }
        }        
        int[] selected = new int[N + 1];
        for (int n = N, w = W; n > 0; n--)
        {
            if (sol[n][w] != 0)
            {
                selected[n] = 1;
                w = w - wt[n];
            }
            else
                selected[n] = 0;
        }
        System.out.print("\nItems with weight ");
        for (int i = 1; i < N + 1; i++)
            if (selected[i] == 1)
                System.out.print(val[i] +" ");
        System.out.println("are selected by knapsack algorithm.");
    }
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        LazyStudent ks = new LazyStudent();
 
        System.out.println("Enter number of elements ");
        
        //number of items
        //int n = scan.nextInt();
        int n=5;
 
        //int[] wt = new int[n + 1];
        //int[] val = new int[n + 1];        
        int[] wt={0,3,2,1,4,5};
        int[] val={0,25,20,15,40,50};
        /*
        System.out.println("Enter weight for "+ n +" elements");                
        for (int i = 1; i <= n; i++)
            wt[i] = scan.nextInt();
        System.out.println("Enter value for "+ n +" elements");
        for (int i = 1; i <= n; i++)
            val[i] = scan.nextInt();
 
        System.out.println("Enter knapsack weight ");
        */
        //max weight
        //int W = scan.nextInt();
        int W=6;
        ks.solve(wt, val, W, n);
        //scan.close();
    }
}