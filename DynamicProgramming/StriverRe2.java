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

    public static void main(String[] args) {
        printName("Dinesh", 0, 5);
        printLinearN(1, 5);
    }
}


