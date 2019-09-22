/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

/*
    El problema es similar al problema KnapSack 01.
    En cambio que aqui se debe obtener minimo esfuerzo como contraparte
    a mayor beneficio y tener una nota mayor que la minima para pasar como 
    contraparte al peso maximo soportado por la maleta.
*/
public class LazyStudent21{
    
    public static void main(String[] args) throws Exception {
        int efforts[] = {25,20,15};
        int grades[] = {3,2,1};
        int minGradeToPass = 3;
        System.out.println(minEffortTask(efforts, grades, minGradeToPass)+" is min effort.");
    }
    
    public static int minEffortTask(int[] efforts, int[] grades, int minGradeToPass) {
        int N = grades.length; // Get the total number of items. 
        int[][] V = new int[N + 1][minGradeToPass + 1]; //Create a matrix. Task are in rows and grades at in columns +1 on each side
        
        for (int col = 0; col <= minGradeToPass; col++) {
            V[0][col] = 0;
        }
        //Fill the first row with 0
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
        //K stands for the k-th item
        for (int k=1;k<=N;k++){
            //Let's fill the values row by row
            for (int g=1;g<=minGradeToPass;g++){                
                //if first task, just set the effort                    
                if(k==1){
                    V[k][g]=efforts[k-1];
                }               
                else if (grades[k-1]>=g){                    
                    if((g-grades[k-1])<=0){
                        V[k][g]=Math.min (efforts[k-1], V[k-1][g]);                                                                                      
                    }else{
                        V[k][g]=Math.min (efforts[k-1]+V[k-1][g-grades[k-1]], V[k-1][g]);                                   
                    }  
                }
                else {                 
                    V[k][g]=V[k-1][g];
                }
            }
        }
        //Printing the matrix
        for (int[] rows : V) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }
        
        //Print path      
        System.out.println("Task in the list: ");        
        int i=N,k=minGradeToPass;
        while(i>0&&k>0){
            if( V[i][k] != V[i-1][k]){
                System.out.printf("Task %d is in the list\n",i);
                i-=1;
                k=k-grades[i];            
            }else{
                i-=1;
            }
        }        
        return V[N][minGradeToPass];
    }
}