package DynamicProgramming;

public class StriverRe2 {

    // 1. Print name n times using recursion
    public static void printName(String name, int i, int limit) {
        if (i >= limit) return;

        System.out.println(name);
        printName(name, i + 1, limit);
    }

    public static void main(String[] args) {
        printName("Dinesh", 0, 5);
    }
}
