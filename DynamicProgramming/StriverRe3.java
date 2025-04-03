package DynamicProgramming;

public class StriverRe3 {

    /*********************************** PARAMETERISED AND FUNCTIONAL RECURSION ***********************************/
   
    // There are two types of recursions.
    //      1. Parameterised recursion
    //      2. Functional recursion
    
    // 1. Summation of first n numbers - parameterised construction
    public static void firstNNumbers(int n, int summ) {
        // Time complexity - 0(n) - we are calling same function n times
        // Space complexity - 0(n)- there will be n new stacks created.
        if (n <= 0) {
            System.out.println(summ);
            return;
        };

        summ += n;
        firstNNumbers(n-1, summ);
    }

    // 2. Summation of first n numbers - using functional recursion
    //
    // first stack  - 5 + f(4)  --> return 5 + 10 = 15
    // second stack - 4 + f(3)  --> return 4 + 6 = 10
    // third stack  - 3 + f(2)  --> return 3 + 3 = 6
    // fourth stack - 2 + f(1)  --> return 2 + 1 = 3
    // fifth stack  - 1 + f(0)  --> return 1 + 0 = 1
    //
    // f(0) - base case hit ==> return
    public static int firstNNumbers(int n) {
        // Time complexity - 0(n) - we are calling same function n times
        // Space complexity - 0(n)- there will be n new stacks created.
        if (n < 1) return 0;

        return n + firstNNumbers(n - 1);
    }

    // 3. Factorial of n - (factorial of 5 = 5 * 4 * 3 * 2 * 1)
    public static int factorialOfN(int n) {
        // Time complexity - 0(n) - we are calling same function n times
        // Space complexity - 0(n)- there will be n new stacks created.
        if (n == 0) return 1;
        
        return n * factorialOfN(n - 1);
    }

    // using parameterised recursion
    public static void factorialOfN(int n, int curr) {
        // Time complexity - 0(n) - we are calling same function n times
        // Space complexity - 0(n)- there will be n new stacks created.
        if (n == 0) {
            System.out.println(curr);
            return;
        }

        curr *= n;
        factorialOfN(n-1, curr);
    }

    public static void main(String[] args) {
        firstNNumbers(5, 0); // parameterised recursion - we passed state from one stack to another as parameter
        System.out.println(firstNNumbers(5)); // functional recursion - where instead of passing some state as parameters, we make function to return something.
        System.out.println(factorialOfN(5)); // using functional recursion
        factorialOfN(5, 1);
    }
}
