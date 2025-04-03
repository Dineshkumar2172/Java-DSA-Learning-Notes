package DynamicProgramming.Recursion;

public class StriverRe5 {
    // reference: https://youtu.be/kvRjNm4rVBE?list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9

    // 1. Write a function to calculate nth number in fibonacci series.
    public static int calculateFibonacci(int n) {
        // Time complexity - (2^n) exponential
        if (n <= 1) return n;

        int left = calculateFibonacci(n-1);
        int right = calculateFibonacci(n-2);
        return left + right;
    }

    // we can write the above code like this as well.
    // calculateFibonacci(n-1) will get executed at first
    // calculateFibonacci(n-2) will get executed after
    // these recursive function won't get executed simultaneously
    // public static int calculateFibonacci(int n) {
    //     // Time complexity - (2^n) exponential
    //     if (n <= 1) return n;

    //     return calculateFibonacci(n-1) + calculateFibonacci(n-2);
    // }

    public static void main(String[] args) {
        System.out.println(calculateFibonacci(6));
    }
}
