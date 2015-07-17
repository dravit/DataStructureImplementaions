package sorting;import java.util.Arrays;

/**
 * Created by Dravit on 5/15/2015.
 * Merge Sort is not an <i>In-Place</i> sorting algorithm, that means it does not take constant amount of
 * memory.
 * Merge Sort has O(nlogn) time complexity in worst case.
 * It's a divide and conquer technique based algorithm.
 * Its' also a stable sorting algorithm, that means the relative order of records remains preserved
 * when we have two same sorting keys.
 * Space complexity is O(n).
 * Steps:
 * <b>1.</b> Divide the array in two possible equal half and find some middle position.
 * <b>2.</b> After this take thw two arrays as two separate problems (left array and right array-
 * <b>3.</b> Again break each of these arrays in two possible equal half and do it so on.
 * <b>4.</b> Exit point of this recursion process will be the case when array has left with one element.
 */
public class MergeSortDemo {
    public static void main(String[] args) {
        MergeSortDemo m = new MergeSortDemo();
        System.out.println("Running Merge Sort");
        int [] inputArr = new int[]{7,8,5,2,4,6,1,3,9};
        m.mergeSort(inputArr);
        System.out.println(Arrays.toString(inputArr));

    }

    /**
     * This function is dividing the array in two parts by:
     * <b>1.</b> Calculating the mid of array
     * <b>2.</b> Creating left array of size mid
     * <b>3.</b> Creating right array of size length - mid.
     * <b>4.</b> Assigning elements from 0 to mid to left array and from mid to length to right array.
     * <b>5.</b> Again calling the mergeSort function on these two arrays until and unless the array is divided
     * in such a way that it's size is 1
     * <b>6.</b> Finally calling merge function for the left and right arrays
     * @param A : Array that need to be sorted
     */
    public void mergeSort(int A[]) {
        int length = A.length;
        if(length > 1) {
            int mid = length / 2;
            int left[] = new int[mid];
            int right[] = new int[length - mid];
            for(int i=0; i < mid; i++) {
                left[i] = A[i];
            }
            for(int i = mid; i < length; i++) {
                right[i - mid] = A[i];
            }
            mergeSort(left);
            mergeSort(right);
            merge(left, right, A);
        }
    }

    /**
     * This function merge the two sub-arrays to form a sorted array.
     * It takes three arguments left array, right array, and original array of this call of this call
     * which need to be sorted.
     * This function makes four counters
     * left_length : Length of left array
     * right_length : Length of right array
     * leftCounter : To check till where we have scanned the left array
     * rightCounter : To check till where we have scanned the right array
     * aCounter : A counter to track the position on which last scanned element was placed in
     * original array of this call
     * In first loop we scan over both left and right sub arrays and check if elements of left and right
     * sub arrays
     * This loop exists if any of the counter i.e leftCounter or rightCounter becomes equals to their
     * arrays length
     * After this loops one of the counter will be exhausted and one will have few elements remaining
     * Put remaining elements of the other loop in original array of this call
     * @param left : left array
     * @param right : right array
     * @param A : original array of this call
     */
    public void merge(int [] left, int [] right, int [] A) {
        int left_length = left.length;
        int right_length = right.length;
        int leftCounter = 0;
        int rightCounter = 0;
        int aCounter = 0;
        while(leftCounter < left_length && rightCounter < right_length) {
            if(left[leftCounter] <= right[rightCounter]) {
                A[aCounter] = left[leftCounter];
                leftCounter++;
            } else {
                A[aCounter] = right[rightCounter];
                rightCounter++;
            }
            aCounter++;
        }
        while(leftCounter < left_length) {
            A[aCounter] = left[leftCounter];
            aCounter++;
            leftCounter++;
        }
        while(rightCounter < right_length) {
            A[aCounter] = right[rightCounter];
            aCounter++;
            rightCounter++;
        }
    }
}
