public class Big0Notation {

    /**********************************************************************************************************************************************************************
     * 
     * 1. This notation is used to express the upper bound of an algorithm's running time.
     * 2. Rules of Big O Notation.
     *      a. It's a single processor.
     *      b. It performs sequential execution of statments.
     *      c. Assignment operation takes 1 unit of time.
     *      d. Return statement takes 1 unit of time.
     *      e. Arithmetical operation takes 1 unit of time.
     *      f. Logical operation of takes 1 unit of time.
     *      g. Other small/single operation takes 1 unit of time.
     *      h. Drop lower order terms.
     *      i. drop constant multipliers.
     *          
     *         // Polynomial equaltion
     *         T = n^2 + 3n + 1     =====> time complexity is O(n^2) after dropping lower order terms (3n, 1).
     *         T = 3n^2 + 6n + 1    =====> time complexity is O(n^2) after dropping lower order terms (6n, 1) and constant multipliers (3).
     * 
     **********************************************************************************************************************************************************************/


    /****************************************************** CALCULATING TIME COMPLEXITY OF CONSTANT ALGORITHM *************************************************************
     * 
     * sumConstantAlgorithm - function represents constant time algorithm
     * only those two lines inside the above mentioned function needs to be taken into consideration for calculating time complexity.
     * if you take the total time taken by the sumConstantAlgorithm (T = 4 + 2 = 6) => 6 is nothing but a constant.
     * hence sumConstantAlgorithm is a constant time complexity.
     * 
     **********************************************************************************************************************************************************************/


    /******************************************************  CALCULATING TIME COMPLEXITY OF LINEAR ALGORITHM **************************************************************
     * 
     * findSumLinearAlgorithm - function represents linear time algorithm
     * only those 5 lines inside the above mentioned function needs to be taken into consideration for calculating time complexity.
     * 7 + 10n is time taken => And n is the time complexity of this function.
     * time complexity became n because ==> we dropped lower order terms (7), we dropped constant multipliers (10)
     * ultimately the time complexity taken by the above mentioned function is O(n)
     * 
     * NOTE: execution time is directly proportional to the input size n.
     * 
     **********************************************************************************************************************************************************************/


    /****************************************************** CALCULATING THE COMPLEXITY OF POLYNOMIAL ALGORITHM ************************************************************
     * 
     * printPolynomialAlgorithm -  function which represents polynomial time complexity calculation.
     * 
     * 5 + 11n + 9n^2 is the time taken by a function to execute.
     * time complexity becomes n^2 because ==> we drop lower orders (5, 11n), we removed constant multiplier (9)
     * ultimately the time complexity of an above mentioned function is O(n^2)
     * 
     * NOTE: execution time will increase n^2 times the number of input size n.
     * 
     **********************************************************************************************************************************************************************/
    
    public static void main(String[] args) {
        System.out.println("sample print statement");
    }

    public int sumConstantAlgorithm(int x, int y) {
        int result = x + y;     // accesing x, accessing y, performing sum opeartion, assigning it to result variable (1+1+1+1) => it takes 4 unit of time.
        return result;          // accessing result, returning result (1+1) ==> it takes 2 unit of it.
    }

    public int findSumLinearAlgorithm(int n){
        int sum = 0;    // 1 step // one operation ==> assigning 0 to sum ==> 1 operation ==> 1 unit time
        
        /******************************************** FOR THE BELOW FOR LOOP EXPLANATION IF YOU ARE NEW TO JAVA ***********************************************************
         * 
         * just a note for folks who hasn't worked on java
         * in the following for loop,
         *      STEP 1. First we are initialising i with 1.
         *      STEP 2. The we are keeping a condition to check if i <= n.
         *      STEP 3. Then the logic inside for loop will get executed.
         *      STEP 4. Then we are incrementing i with 1.
         * the above four steps gets executed iteratively until the condition is True.
         * 
         ******************************************************************************************************************************************************************/

        for(int i = 1; i <= n; i++){
            /**********************************************  FOR ABOVE FOR LOOP LINE AND CONDITIONS INSIDE IT *************************************************************
             *
             * assigning 1 to variable i (1 operation)
             * condition gets executed n + 1 times and during each execution it peform three opearations. ==> 3(n+1) operations
             *    operation 1: accesses value of i.
             *    operation 2: accesses value of n.
             *    operation 3: checks if i less than or equal to n.
             * access value of i, increments i with 1, assign updated value back to i. This incrementation operation is being done for n number of times. ==> 3n operations
             * Hence the above for loop becomes
             *    number of operations = 1 + 3(n+1) + 3n
             *    unit time = 1 + 3(n+1) + 3n
             *            = 1 + 3n + 3 + 3n
             *    unit time = 4 + 6n unit time
             * 
             **************************************************************************************************************************************************************/

            sum = sum + i;      // accessing value of sum, accessing value of i, adding both the values, assigning it to sum ==> (1 + 1 + 1 + 1) 
                                // the above operation gets executed n number of times. Hence number of operation is ==> n(1+1+1+1)
                                // 4n is the unit time taken by the above line
        }
    
        return sum;             // accessing value of sum, retuns the value of sum ==> hence it performs 1 + 1 operation ===> it takes 2 unit time

        /******************************************************************************************************************************************************************
         *
         * time taken by a function can be calculated by summing up unit time taken by each operations inside a function.
         * hence the total time taken by this current function is: 
         *         T = 1 + 4 + 6n + 4n + 2
         *         T = 7 + 10n
         * 
         ******************************************************************************************************************************************************************/
    }


    public void printPolynomialAlgorithm(int n) {
        for(int i = 1; i <= n; i++) {                               // 1 + 3(n+1) + 3n number of operations and 4 + 6n unit time (refer above function for explanation of calc)
            for(int j = 0; j <= n; j++) {                           // n(1 + 3(n+1) + 3n) number of operations and 6n^2 + 4n unit time
                System.out.println("i = " + i + ", j = " + j);      // access i n^2 times, access j n^2 times, print it n^2 times ==> n^2(1 + 1 + 1) ops and 3n^2 unit time
            }
            System.out.println("End of inner loop!");             // printing a string (1), print n number of times, hence n(1) operations ==> n unit time 
        }
        System.out.println("End of outer loop!");                 // printing a string (1), operations 1 and 1 unit time, 

        /******************************************************************************************************************************************************************
         *
         * time taken by a function can be calculated by summing up unit time taken by each operations inside a function.
         * hence the total time taken by this current function is: 
         *         T = 4 + 6n + 6n^2 + 4n + 3n^2 + n + 1
         *         T = 5 + 11n + 9n^2
         * 
         ******************************************************************************************************************************************************************/
    }
}
