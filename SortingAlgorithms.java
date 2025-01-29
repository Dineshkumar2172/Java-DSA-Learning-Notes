public class SortingAlgorithms {
    public static void main(String[] args) {
        // BUBBLE SORT Algorithm
        //      1. It is also called as sinking sort
        //      2. While applying this sorting algorithm on unsorted array, the largest elements tends to sink at the end of the array.
        //      3. It repeatedly compares pair of adjacent elements and swap them if they are in wrong order
        //      4. reference - https://youtu.be/2ZLl8GAk1X4?t=87325
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        int[] arr = {7,6,5,4,3,2,1,0};
        sortingAlgorithms.bubbleSort(arr, arr.length);
        sortingAlgorithms.printArrayElements(arr);

        // INSERTION SORT Algorithm
        //      1. Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.
        //      2. In insertion sort, we divide the given array into two parts - sorted part and unsorted part.
        //      3. From unsorted part, we take first element and place at its correct position in sorted array . This is
        //         done by shifting all the elements which are larger than first element by one position.
        //      4. Its repeated till unsorted array is not empty.
        int[] arr2 = {7,6,5,4,3,2,1,0};
        sortingAlgorithms.insertionSort(arr2, arr2.length);
        sortingAlgorithms.printArrayElements(arr2);

        // SELECTION SORT Algorithm
        

    }

    public void bubbleSort(int[] arr, int n){
        boolean isSwapped;
        for (int i = 0; i < n; i++) {
            isSwapped = false;
            for (int j = 0; j < n-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }

            // if no swap is performed during previous iteration
            // then the array is already sorted, so no need to do more checks
            if (!isSwapped) {
                break;
            }
        }
    }

    public void insertionSort(int[] arr, int n){
        for (int i = 1; i < n; i++) {
            int temp = arr[i]; // taking the first element
            int j = i - 1; // index for the last element of sorted array

            // traversal should continue till the first element in sorted array
            // traveral should continue till the current element in sorted list is smaller than than first element
            while (j >= 0 && arr[j] > temp) {
                // if index >= 0 and the current element is greater than the first element
                arr[j + 1] = arr[j]; // shift current element one index right
                j--; // decrement j to point to previous element in the sorted array
            }
            // update current index with the first element
            arr[j + 1] = temp;
        }
    }

    public void printArrayElements(int[] arr){
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

}
