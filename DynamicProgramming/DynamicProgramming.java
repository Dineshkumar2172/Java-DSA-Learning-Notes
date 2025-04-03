package DynamicProgramming;

public class DynamicProgramming {

    // Dynamic Programming
    //      Part 1: Memorization
    //      Part 2: Tabulation


    // overlapping sub problems - whenever we end up solving same problems again and again.
    // For example: in the below finbonacci function, assume we are calculating fibonacci of 8, here we perform f(2) and others multiple times within it.
    // why to calculate again if we already have calculated it? This is where memoization comes in - we tend to store the values of sub problems in some map/table.

    // what is memoization? we make use of dp array to store intermediate results instead of recalculating it again and again.

    public static int getFibonacciN(int n) {
        // Time complexity - O(2^n)
        // Space complexity - O(N) - there will be maximum of n stacks at a time.
        if (n <= 1) return 1;
        return getFibonacciN(n-1) + getFibonacciN(n-2);
    }

    // converted fibonacci to DP solution - used dp array for memoization to prevent recomputing same data again and again.
    public static int getFibonacciDynamic(int n, int[] dp) {
        // Time complexity - O(n)
        // Space complexity - O(N) for stack + 0(N) for array
        if (n <= 1) return n;

        if (dp[n] != 0) return dp[n];

        dp[n] = getFibonacciDynamic(n - 1, dp) + getFibonacciDynamic(n - 2, dp);

        return dp[n];
    }

    // public static int getFibonacciN(int n) {
    //     if (n <= 1) return 1;
    //     int left = getFibonacciN(n-1);
    //     int right = getFibonacciN(n-2);
    //     return left + right;
    // }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(getFibonacciN(n));

        int[] dp = new int[n + 1];
        System.out.println(getFibonacciDynamic(n, dp));
    }
}
