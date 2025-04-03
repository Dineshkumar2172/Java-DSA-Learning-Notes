package DynamicProgramming;

public class StriverRe4 {
    // 1. function reverse an integer
    public static void reverseArray(int[] arr, int l, int r) {
        if (l >= r) return;

        int temp = arr[l];
        arr[l] =  arr[r];
        arr[r] = temp;
        reverseArray(arr, l+1, r-1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        reverseArray(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + ", ");
    }
}
