public class SearchAlgorithms {
    public static void main(String[] args) {
        // 1. Linear Search Algorithm
        // 2. Binary Search Algorithm
        int[] arr = {5, 1, 9, 2, 10, 15, 20};
        int searchResult = linearSearch(arr, arr.length, 10);
        if (searchResult >= 0) {
            System.out.println("search element found at index : " + searchResult);
        } else {
            System.out.println("search element not found in the array");
        }
    }


    public static int linearSearch(int[] arr, int n, int x){
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
