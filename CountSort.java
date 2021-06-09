package com.index.On;

import java.util.Arrays;

public class CountSort {

  
    void countSort(int arr[]) {
      int size=arr.length;
      
      int[] output = new int[size];

      int max = arr[0];
      for (int i = 1; i < size; i++) {
        if (arr[i] > max)
          max = arr[i];
      }
      int[] count = new int[max + 1];  // index +1

      for (int i = 0; i < max; ++i) {
        count[i] = 0;
      }

      for (int i = 0; i < size; i++) {
        count[arr[i]]++;
      }

      // Store the cummulative count of each arr
      for (int i = 1; i <= max; i++) {
        count[i] += count[i - 1];
      }

      // Find the index of each element of the original arr in count arr, and
      // place the elements in output arr
      for (int i = size - 1; i >= 0; i--) {
        output[count[arr[i]] - 1] = arr[i];
        count[arr[i]]--;
      }

      // Copy the sorted elements into original arr
      for (int i = 0; i < size; i++) {
        arr[i] = output[i];
      }
    }

    // Driver code
    public static void main(String args[]) {
      CountSort countSort=new CountSort();
      int[] arr = { 4, 2, 2, 8, 3, 3, 1};
      countSort.countSort(arr);
      System.out.println("Sorted Array in Ascending Order: ");
      System.out.println(Arrays.toString(arr));
    }
  }

