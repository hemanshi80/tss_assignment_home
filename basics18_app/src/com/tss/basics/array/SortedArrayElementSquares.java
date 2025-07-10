package com.tss.basics.array;

import java.util.Scanner;

public class SortedArrayElementSquares {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int n;
        int[] nums;

        System.out.print("Enter number of elements: ");
        n = scanner.nextInt();

        while (true) {
            nums = new int[n];
            System.out.println("Enter " + n + " array element in sorted order:");
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            if (isSorted(nums)) {
                break; 
            } else {
                System.out.println(" The array is not sorted. Please enter the elements again.");
            }
        }

        int[] squaredSorted = sortedSquares(nums);
        printArray(squaredSorted);

        scanner.close();
	
	}
	
	public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
	
	public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int pos = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[pos--] = leftSquare;
                left++;
            } else {
                result[pos--] = rightSquare;
                right--;
            }
        }

        return result;
    }
	
    public static void printArray(int[] arr) {
        System.out.print("Sorted Squares: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
   
	
}
