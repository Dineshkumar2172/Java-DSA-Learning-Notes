public class SearchAlgorithms {
    public static void main(String[] args) {
        // Linear Search Algorithm
        int[] arr = {5, 1, 9, 2, 10, 15, 20};
        int searchResult = linearSearch(arr, arr.length, 10);
        if (searchResult >= 0) {
            System.out.println("search element found at index : " + searchResult);
        } else {
            System.out.println("search element not found in the array");
        }

        // Binary Search Algorithm - input array should be sorted
        // It's a divide and conquer algorith which splits the array into two during each iteration reducing our searcn time n/2
        int[] arr2 = {1,2,3,6,8,9,10,45,78};
        searchResult = binarySearch(arr2, arr2.length, 9);
        if (searchResult >= 0) {
            System.out.println("search element found at index : " + searchResult);
        } else {
            System.out.println("search element not found in the array");
        }

        // Given a sorted array of distinct integers and a target value, return the index if the target is found.
        // If not, return the index where it would be if it were inserted in order. The algorithm should run in O(log n) time.
        // Example Input                target              output
        // {1, 3, 5, 7}                 5                     2
        // {1, 3, 5, 7}                 2                     1
        // {1, 3, 5, 7}                 8                     4
        // {1, 3, 5, 7}                 0                     0
        // TODO: Yet to be done.

    }


    public static int linearSearch(int[] arr, int n, int x){
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int n, int x){
        int low = 0; // start index
        int high = n - 1; // last index

        while (low <= high) {
            int mid = (low + high)/2; // calculate mid index
            if (arr[mid] == x) { // if search element is in the middle of the array
                // return the mid index as output
                return mid;
            }

            // if the element in middle index is less than the search element
            if (arr[mid] < x) {
                // update the lower index to mid+1, so that next search will happen only on second half
                low = mid + 1; // updating lower index
            } else {
                // else update the high index to mid-1, so that next search will happen only in first half
                high = mid - 1; // updating high index
            }
        }

        return -1;
    }
}
