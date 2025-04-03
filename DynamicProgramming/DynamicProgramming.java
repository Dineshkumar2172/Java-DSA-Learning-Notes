package DynamicProgramming;

public class DynamicProgramming {

    // Dynamic Programming
    //      Part 1: Memorization
    //      Part 2: Tabulation


    // overlapping sub problems - whenever we end up solving same problems again and again.
    // For example: in the below finbonacci function, assume we are calculating fibonacci of 8, here we perform f(2) multiple times within it.

    public static int getFibonacciN(int n) {
        if (n <= 1) return 1;
        return getFibonacciN(n-1) + getFibonacciN(n-2);
    }

    // public static int getFibonacciN(int n) {
    //     if (n <= 1) return 1;
    //     int left = getFibonacciN(n-1);
    //     int right = getFibonacciN(n-2);
    //     return left + right;
    // }

    public static void main(String[] args) {
        System.out.println(getFibonacciN(5));
    }
}
