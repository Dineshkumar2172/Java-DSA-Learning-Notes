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

    public void printArrayElements(int[] arr){
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

}
