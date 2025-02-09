public class DynamicProgramming {
    public static void main(String[] args) {
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
        System.out.println(dynamicProgramming.fibonacci(4)); // calculate fibonacci number in a series
        int[] arr = {4, 3, -2, 6, -12, 7, -1, 6};
        System.out.println(dynamicProgramming.maxSumSubarray(arr));
    }

    public int fibonacci(int n){
        int[] table = new int[n + 1]; // using tabular method instead of recursion
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i-1] + table[i-2];   
        }

        return table[n];
    }

    // reference - https://youtu.be/2ZLl8GAk1X4?t=149173
    public int maxSumSubarray(int[] arr){
        // two checks
        //      1. Should I become part of current subarray?
        //      2. Should I start a new subarray?
        int maxSoFar = arr[0];
        int currentMax = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            currentMax = currentMax + arr[i]; // check 1 - element become part of the current subarray
            if (currentMax < arr[i]) {
                currentMax = arr[i]; // check 2 - element decides to start its own subarray
            }

            if (maxSoFar < currentMax) {
                maxSoFar = currentMax;
            }
        }

        return maxSoFar;
    }
}
