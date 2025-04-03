package DynamicProgramming;

public class StriverRe3 {

    /*********************************** PARAMETERISED AND FUNCTIONAL RECURSION ***********************************/
   
    // There are two types of recursions.
    //      1. Parameterised recursion
    //      2. Functional recursion
    
    // 1. Summation of first n numbers - parameterised construction
    public static void firstNNumbers(int n, int summ) {
        if (n <= 0) {
            System.out.println(summ);
            return;
        };

        summ += n;
        firstNNumbers(n-1, summ);
    }

    public static void main(String[] args) {
        firstNNumbers(5, 0);
    }
}
