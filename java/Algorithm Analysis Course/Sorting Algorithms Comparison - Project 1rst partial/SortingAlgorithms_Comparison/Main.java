/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SortingAlgorithms_Comparison;

import java.util.Arrays;

/**
 *
 * @author User
 */
public class Main {

    /*
       bubble sort
       shell sort
       heapsort
       quicksort
       radix sort.      
       
        generar 1.000.000 de enteros aleatorios de 10 cifras 
       (similar a cédulas de identidad).  Luego los separará en 
        las siguientes configuraciones:

        Configuración A: 100.000 arreglos de 10 elementos
        Configuración B: 10.000 arreglos de 100 elementos
        Configuración C: 1.000 arreglos de 1.000 elementos
        Configuración D: 100 arreglos de 10.000 elementos
        Configuración E: 10 arreglos de 100.000 elementos
        Configuración F: 1 arreglo de 1.000.000 elementos
        Usted deberá conseguir implementaciones de esos algoritmos
        en el lenguaje de su elección y utilizarlos para 
        ordenar todas las configuraciones creadas.
    */
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int k=1,n=100000000;   
	long[][] array=new long[k][n];            	
        
	long sum=0;    
	for(int i=0;i<k;i++){      
            for(int j=0;j<n;j++){        
                array[i][j]=rand_10dig();      
            }      
            //System.out.println(Arrays.toString(array[i]));
      
            //long time_1 = System.currentTimeMillis();      
            //long time_1 = System.nanoTime();       
            
            // ##### SORTING METHOD HERE #####
            
            /*
            int last = array[i].length;         
            Long[] arrayRef = new Long[last];
            for (int m=0;m<last;m++) arrayRef[m] = array[i][m];
            //System.out.println(Arrays.toString(arrayRef));                        
            BubbleSort.BS(arrayRef, last);//BUBBLE SORT
            */
            
            /*
            int last = array[i].length;
            Long[] arrayRef = new Long[last];
            for (int m=0;m<last;m++) arrayRef[m] = array[i][m];                                 
            //System.out.println(Arrays.toString(arrayRef));
            ShellSort.shellSort(arrayRef);//SHELL SORT  
            */
            
            
            /*
            int last = array[i].length;
            Long[] arrayRef = new Long[last];
            for (int m=0;m<last;m++) arrayRef[m] = array[i][m];
            //System.out.println(Arrays.toString(arrayRef));
            QuickSort.QS(arrayRef, 0, arrayRef.length-1);//QUICK SORT  
            */
            
            //System.out.println(Arrays.toString(array[i]));
            
            long time_1 = System.nanoTime();                         
            
            //HeapSort.heap(array[i]);
            RadixSort.radixSort(array[i]);        
            checkSorted(array[i]);
	
            //long time_2 = System.currentTimeMillis();            
            long time_2 = System.nanoTime();      
            long difference = time_2 - time_1;            
            sum+=difference;      
            //System.out.println( difference);    
            //System.out.println(Arrays.toString(array[i]) + "\n" + i);                  
            //System.out.println(Arrays.toString(arrayRef) + "\n" + i);             
            //System.out.println();    
	}    		
        System.out.println( "\nall arrays (suming) " + sum + " nanoseconds" );                                 
    }
    
    //random number of ten digits
    public static long rand_10dig(){
        long random=(long) ( 1000000000L + (Math.random()* (10000000000L - 1000000000L) ) );
        return random;
    }
    
    private static final void checkSorted(long[] data) {
		for (int i = 1; i < data.length; ++i) {
			if (data[i - 1] > data[i]) {
				throw new IllegalStateException("Not sorted!");
			}
		}
	}
    
    
}
