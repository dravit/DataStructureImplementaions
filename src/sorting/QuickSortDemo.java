package sorting;

import java.util.Arrays;

/**
 * Created by Dravit on 6/8/2015.
 * Quick sort is an In-place sorting algorithm that means it takes constant amount of extra memory
 * Average case time complexity of Quick Sort is O(nlogn) and in worst case it is O(n2).
 * Worst case time complexity of quick sort can be improved by using Randomized version of Quick Sort
 * In most of the practical scenarios quick sort gives O(nlogn)
 * Most of the pre-defined function of language libraries use quick sort. E.g. In java Arrays class use
 * DualPivotQuickSort.java to sort integer array.
 * Steps:
 * <b>1.</b> First we take a pivot element and then put all elements less than the pivot to its left and
 * greater than the pivot to its right.
 * <b>2.</b> After this we will have a pIndex i.e the pivot index
 * <b>3.</b> Now take elements on left of pivot index and perform same operation on them and take elements
 * on right of pivot and perform same operation on them.
 * <b>4.</b> Exit point of recursive subsets of array will be when start >= end.
 */
public class QuickSortDemo {
    public void quickSort(int [] inputArr, int start, int end) {
        if(start < end) {
            int pIndex = partition(inputArr, start, end);
            quickSort(inputArr, start, pIndex - 1);
            quickSort(inputArr, pIndex + 1, end);
        }
    }

    /**
     * This function calculates the pivot index and arrange all elements lesser than pivot to its left
     * and other to its right.
     * For this it will take a pIndex which will track position of the last placed element.
     * After all the operations are complete swap element of pIndex with pivot element.
     * @param inputArr
     * @param start
     * @param end
     * @return
     */
    public int partition(int []inputArr, int start, int end) {
        int pIndex = start;
        int pivot = inputArr[end];
        for(int i = start; i < end ; i++) {
            if(inputArr[i] <= pivot) {
                swap(inputArr, i, pIndex);
                pIndex = pIndex + 1;
            }
        }
        swap(inputArr, pIndex, end);
        return pIndex;
    }
    public void swap(int [] inputArr, int pIndex, int end) {
        int temp = inputArr[pIndex];
        inputArr[pIndex] = inputArr[end];
        inputArr[end] = temp;
    }

    public static void main(String[] args) {
        QuickSortDemo quickSortDemo = new QuickSortDemo();
        int [] inputArr = new int[]{7,8,5,2,9,6,1,3,4};
        quickSortDemo.quickSort(inputArr, 0 , 8 );
        System.out.println(Arrays.toString(inputArr));
    }
}
