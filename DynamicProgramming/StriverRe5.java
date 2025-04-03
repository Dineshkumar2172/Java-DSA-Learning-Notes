package DynamicProgramming;

public class StriverRe5 {
    // reference: https://youtu.be/kvRjNm4rVBE?list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9

    // 1. Write a function to calculate nth number in fibonacci series.
    public static int calculateFibonacci(int n) {
        if (n <= 1) return n;

        int left = calculateFibonacci(n-1);
        int right = calculateFibonacci(n-2);
        return left + right;
    }

    public static void main(String[] args) {
        System.out.println(calculateFibonacci(6));
    }
}
