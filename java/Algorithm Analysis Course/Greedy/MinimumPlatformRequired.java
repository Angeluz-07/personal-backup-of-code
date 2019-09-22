/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;
public class MinimumPlatformRequired {
 public static void main(String args[])
 {
 // arr[] = {1:00, 1:40, 1:50, 2:00, 2:15, 4:00}
 int arr[] = {900,  940, 950,  1100, 1500, 1800};
 // dep[] = {1:10, 3:00, 2:20, 2:30, 3:15, 6:00}
 int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
 System.out.println("Minimum platforms needed : "+findPlatformsRequiredForStation(arr,dep,6));
 }
 
 static int findPlatformsRequiredForStation(int arr[], int dep[], int n)
 {
 int platform_needed = 0, maxPlatforms = 0;
 int i = 0, j = 0; 
 // Similar to merge in merge sort
 while (i < n && j < n){
 if (arr[i] < dep[j])
 {
    platform_needed++;
    i++;
    if (platform_needed > maxPlatforms) 
    maxPlatforms = platform_needed;
    }
    else 
    {
    platform_needed--;
    j++;
    }
 }
 return maxPlatforms;
 }
}
