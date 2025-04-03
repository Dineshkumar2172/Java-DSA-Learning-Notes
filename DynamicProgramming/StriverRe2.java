package DynamicProgramming;

public class StriverRe2 {

    // 1. Print name n times using recursion
    public static void printName(String name, int i, int limit) {
        // Time complexity - 0(n) - we are calling same function n times
        // Space complexity - 0(n)- there will be n new stacks created.
        if (i >= limit) return;

        System.out.println(name);
        printName(name, i + 1, limit);
    }

    // 2. Print linearly from 1 to n
    public static void printLinearN(int i, int n) {
        // Time complexity - 0(n) - we are calling same function n times
        // Space complexity - 0(n)- there will be n new stacks created.
        if (i > n) return;

        System.out.println(i);
        printLinearN(i+1, n);
    }

    // 2. Print linearly in reverse order n to 1
    public static void printNReverse(int i) {
        // Time complexity - 0(n) - we are calling same function n times
        // Space complexity - 0(n)- there will be n new stacks created.
        if (i <= 1) return;

        System.out.println(i);
        printNReverse(i - 1);
    }

    // 3. Print from 1 to n, but using +1 is not allowed (use backtracking)
    public static void print1Restricted(int n) {
        if (n < 1) return;
        
        
        print1Restricted(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        printName("Dinesh", 0, 5);
        printLinearN(1, 5);
        printNReverse(5);

        // backtracking
        print1Restricted(5);
    }
}


