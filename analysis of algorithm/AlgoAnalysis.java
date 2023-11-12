/*****************************************************************************************************************************************/
/******************************************************* ANALYSIS OF ALGORITHM ***********************************************************/
/*****************************************************************************************************************************************/
class AlgoAnalysis {
    /*
     * 1. An algorithm is a set of instructions to perform a task or to solve a given problem.
     * 2. There can be several different algorithms than can be used to solve any given problems.
     * 3. Analysis of algorithm deals in finding best algorithm which runs fast and consumes less memory.
     * 4. For example: 
     *      Let's say we have two functions to find sum of first n natural numbers. (numbers start from 1....infinity)
     *          1. findSumFunction1 - uses direct formula to find the sum value.
     *          2. findSumFunction2 - uses for loop to find the sum value.
     * 5. Now, in order to determine the best algorithm in above two functions, we use two checks.
     *      1. Time complexity - measures the time it takes for each algorithm to finish the task.
     *      2. Space complexity - measures the amount of memory it consumes to do the specific task.
     * 
     * 6. TIME COMPLEXITY
     *      1. Its the amount of time taken by algorithm to run.
     *      2. The input processed by an algorithm helps in determining the time complexity of an algorithm.
     *      3. For example: findSumFunction1 uses static formula to find the sum, meanwhile findSumFunction2 uses
     *         a for loop which run n number of iteration to find the same sum value. Hence, the time complexity is
     *         best in findSumFunction1 comparing to findSumFunction2 which iterates over n times to solve the same problem.
     *              a. Time taken by findSumFunction1 to finish the task : 2.0 milliseconds
     *              b. Time taken by findSumFunction2 to finish the task : 0.0 milliseconds
     *  
     * 7. SPACE COMPLEXITY
     *      1. It's the amount of space/memory taken up by the algorithm to run.
     *      2. The memory required to process the input by an algorithm helps in determining the space complexity.
     * 
     * 8. While calculating the time and space complexities, we won't go for the exact numbers like I mentioned in above time
     *    complexity section, instead we go with a certain mathematical tool called asymptotic analysis that will help us in determining
     *    time and space complecity of an algorithm.
     */

     public static void main(String[] args) {
        AlgoAnalysis algoAnalysis = new AlgoAnalysis();             // creating object instance for the class AlgoAnalysis
        double function1StartTime = System.currentTimeMillis();     // start time to keep track of function1 processing time
        int sumdata = algoAnalysis.findSumFunction1(999999);      // calling findSumFunction1
        System.out.println("Time taken by findSumFunction1 to finish the task : " + (System.currentTimeMillis() - function1StartTime));
        double function2StartTime = System.currentTimeMillis();     // start time to keep track of function2 processing time
        sumdata = algoAnalysis.findSumFunction2(999999);          // calling findSumFunction2
        System.out.println("Time taken by findSumFunction2 to finish the task : " + (System.currentTimeMillis() - function2StartTime));
        System.out.println("Sum of first 999999 natural numbers are : " + sumdata);
     }


    public int findSumFunction1(int n) {
        int sum = 0;                        // creating a variable sum and initialising it with 0.
        for(int i = 1; i <= n; i ++) {      // n number of iterations. (runtime)
            sum = sum + i;                  // updating the variable sum (incrementing it during every iteration)
        }
        return sum;                         // returns the resulted sum
    }

    public int findSumFunction2(int n) {
        return n*(n+1)/2;                   // direct formula to find the sum instead of using formula.
    }
}
