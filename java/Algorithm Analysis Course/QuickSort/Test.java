/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;


public class Test {
  
    public static void main(String args[]){       
       Scanner input;
       Formatter output;
       
       String pathDir="C:\\Users\\User\\Documents\\NetBeansProjects\\OOP_Tuttoring\\test\\Test\\";                
       String randomIntegers="randomIntegers.txt";
       String sortedIntegers="sortedIntegers.txt";
       
       String inputPath=pathDir+randomIntegers;
       String outputPath=pathDir+sortedIntegers;
       try{
           input=new Scanner(new File(inputPath));           
           output=new Formatter(outputPath);   
           
           ArrayList<Integer> array=new ArrayList();
           
           Integer k;
           while(input.hasNextInt()){
               k=input.nextInt();
               array.add(k);
           }
           input.close();
            
           //sort the array
           quickSort(array);
           
           for(Integer m:array) output.format("%s%n",m);
           
           output.close();           
           
       }catch(FileNotFoundException e){
           System.out.println(e);
       }
    }
    
    /**
     * Sorts an ArrayList in ascending order using insertion sort
     */
    private static void quickSort( ArrayList<Integer> arr )
    {
        quickSort( arr, 0, arr.size()-1 );
    }

    /**
     * Recursive quickSort
     */
    private static void quickSort( ArrayList<Integer> arr, int lo, int hi )
    {
        int pivot;

        if( lo >= hi )
            return;

        pivot = partition( arr, lo, hi );
        quickSort( arr, lo, pivot-1 );
        quickSort( arr, pivot+1, hi );
    }

    /**
     * Partition the array segment around a pivot point
     * 
     * @param arr The array containing ints
     * @param lo The index of the first element in the partition range
     * @param hi The index of the last element in the partition range
     * 
     * @return The index containing the pivot point.  All elements of arr[lo..pivot-1] will
     *  be <= arr[pivot] and all elements in arr[pivot+1..hi] will be > arr[pivot]
     */
    private static int partition( ArrayList<Integer> arr, int lo, int hi )
    {
        int pivotVal = arr.get( lo );
        int right = hi;
        int left = lo + 1;

        while( left <= right )
        {
            // move left toward the right until it gets to the first value
            // greater than pivot
            while( left <= hi && arr.get(left) <= pivotVal )
                left++;

            // move right toward the left until it gets to the first value
            // less than or equal to the pivot
            while( arr.get(right) > pivotVal )
                right--;

            // if left and right haven't crossed, swap the elements and increment/decrement
            // left and right
            if( left < right )
            {
                swap( arr, left, right );
                left++;
                right--;
            }
        }

        // the pivit position is where right points right now, so swap the pivot value there
        swap( arr, lo, right );
        
        // right contains the pivot value
        return right;
    }

    /**
     * Swaps two elements of an ArrayList
     */
    private static void swap( ArrayList<Integer> arr, int i, int j )
    {
        int temp = arr.get(i);
        arr.set( i, arr.get(j) );
        arr.set( j, temp );
    }
}
