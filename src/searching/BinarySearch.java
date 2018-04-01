package searching;

/**
 * Created by Dravit on 6/9/2015.
 * The pre-requisite of BinarySearch is that the input array must be in sorted order
 */
public class BinarySearch {
    /**
     * The average case time complexity of this search function is O(logn)
     * In worst case its O(n)
     * @param inputArr : Array in which element is to be searched
     * @param elementToSearch : Element which we want to find
     * @return index at which element exists, if it does not than return -1.
     */
    public int basicBinarySearch(int [] inputArr, int elementToSearch) {
        int low = 0;
        int high = inputArr.length - 1;
        int mid = (low + high) / 2;
        while(low <= high) {
            if(inputArr[mid] == elementToSearch) {
                return mid;
            } else if(inputArr[mid] < elementToSearch) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * This method is a modified version of basicBinarySearch. We can use this method to find first or last
     * occurrence of element in the sorted array, which was not possible through basicBinarySearch function,
     * as it exist as soon as it finds a match for the specified element.
     * In modified version we do not exit from searching after finding the element, we just change the low or
     * index to find or last occurrence respectively.
     * To keep track of the occurrence we will keep a variable result which will store the location of occurrence
     * This function finds occurrence of element in O(logn) in all cases.
     * @param inputArr : Array in which element is to be searched
     * @param elementToSearch : Element which we want to find
     * @param findFirst : Flag to find first or last occurrence
     * @return index at which element exists, if it does not than return -1.
     */
    public int modifiedBinarySearch(int [] inputArr, int elementToSearch, boolean findFirst) {
        int low = 0;
        int high = inputArr.length - 1;
        int mid = (low + high) / 2;
        int result = -1;
        while(low <= high) {
            if(inputArr[mid] == elementToSearch) {
                result = mid;
                if(findFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if(inputArr[mid] < elementToSearch) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    /**
     * This function finds occurrence count of element in a sorted Array with worst case complexity as O(logn)
     * @param inputArr
     * @param elementToSearch
     * @return
     */
    public int countOccurrence(int [] inputArr, int elementToSearch) {
        int firstIndex = modifiedBinarySearch(inputArr, elementToSearch, true);
        if(firstIndex == -1) {
            System.out.println("Element does not exists in Array");
            return -1;
        }
        int lastIndex = modifiedBinarySearch(inputArr, elementToSearch, false);
        int occurrence = firstIndex - lastIndex + 1;
        return occurrence;
    }
    /**
     * This function is used to find how many times the sorted array is rotated, with a worst time complexity
     * of O(logn). The basic idea behind the search is to find the minimum element in the rotated array
     * and return its position. So, the index at which it is, will be the number of times the array is
     * rotated.
     * This function has four cases
     * <b>Case 1:</b> If low i.e array start element is less than high i.e array last element than array is
     * already sorted and its not rotated. So return the low index
     * <b>Case 2:</b> For this case we have considered a pivot and in rotated array the pivot i.e the smallest
     * element has a property that is lesser than its previous element and next element and their will be only
     * one such element that will follow this property in a rotated array.
     * So for this we will calculate prev and next. We have taken modulo for the case when mid is the last element.
     * <b>Case 3:</b> If mid element is less than the high element than ignore the elements to right of mid and
     * consider the left array
     * <b>Case 4:</b> If mid element is greater than the low element than ignore the left of array and consider
     * the right part of array.
     */
    public int findRotationCount(int [] inputArr) {
        int low = 0;
        int length = inputArr.length;
        int high = length - 1;
        while(low <= high) {
            if(inputArr[low] <= inputArr[high]) {
                return low;
            }
            int mid = (low + high) / 2;
            int next = (mid + 1) % length;
            int prev = (mid+length - 1) % length;
            if(inputArr[mid] < inputArr[next] && inputArr[mid] < inputArr[prev]) {
                return mid;
            }
            else if(inputArr[mid] <= inputArr[high]) {
                high = mid - 1;
            } else if(inputArr[mid] >= inputArr[low]) {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * This method is used to find maximum sum sub array from the given array.
     * This method uses recursion technique which gives solution in O(nlogn).
     * This uses divide and conquer approach for finding the sum of smallest possible arrays.
     * Their can be three cases in this:
     * <b>Case 1:</b> The maximum possible sum can be the left subArray.
     * <b>Case 2:</b> The maximum possible sum can be the right subArray.
     * <b>Case 3:</b> The maximum possible sum subArray can lie between left and right subArray.
     * @param inputArr
     * @param length
     * @return
     */
    public int maxSubArraySum(int [] inputArr, int length) {
        if(length == 1) {
            return inputArr[0];
        }
        int mid = length / 2;
        int [] leftArr = new int[mid];
        int rightArr[] = new int[length - mid];
        for(int i=0; i < mid; i++) {
            leftArr[i] = inputArr[i];
        }
        for(int i = mid; i < length - mid; i++) {
            rightArr[i-mid] = inputArr[i];
        }
        int leftMSS = maxSubArraySum(leftArr, leftArr.length);
        int rightMSS = maxSubArraySum(rightArr, rightArr.length);
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE, sum = 0;
        for(int i = mid; i < length; i++) {
            sum += inputArr[i];
            rightSum = rightSum > sum ? rightSum : sum;
        }
        sum = 0;
        for(int i = (mid-1); i >= 0; i--) {
            sum += inputArr[i];
            leftSum = leftSum > sum ? leftSum : sum;
        }
        int ans = leftMSS > rightMSS ? leftMSS : rightMSS;
        return (ans > (leftSum + rightSum) ? ans : (leftSum + rightSum));
    }

    /**
     * Kadane's Algorithm
     * This method is used to find maximum sum sub array from the given array.
     * This method gives solution in O(n).
     * Atleast  One element must be positive
     */
    public int maxSubArraySumUsingKadane(int [] inputArr, int length) {
        int ans = 0, sum = 0;
        for(int i= 0; i <inputArr.length; i++) {
            if(sum + inputArr[i] > 0) {
                sum += inputArr[i];
            } else {
                sum = 0;
            }
            ans = ans > sum ? ans : sum;
        }
        return  ans;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.maxSubArraySumUsingKadane(new int[]{3, -2, 5, -1}, 4));
    }
}
