/*****************************************************************************************************************************************/
/********************************************************* ASYMPTOTIC ANALYSIS ***********************************************************/
/*****************************************************************************************************************************************/
class AysmptoticAnalysis {
    /*
     * 1. We use asymptotic analysis in evaluating the performance of an algorithm in terms of input size and its increase.
     * 2. Using asymptotic analysis, we don't measure actual running time of an algorithm.
     * 3. It helps in determing how time and space taken by algorithm increase with input size.
     * note: if the input size of an algorithm is less, them time and space used by an algorithm will also be less. If we increase
     * the input size, time and space used by an algorithm will also increase. This asymptotic analysis is used to determine that.
     * 4. Usually this asymptotic analysis is being done by asymptotic notations.
     * 
     * 5. ASYMPTOTIC NOTATIONS:
     *      a. Asymptotic notations are the mathematical tools used to describe the running time of an algorithm in terms of input size.
     *      b. Example: Performance of a car in 1 litre of petrol.
     *              i) Highway (min traffic) - 25km/litre               ===> (best case)
     *             ii) City (Max traffic) - 15km/litre                  ===> (worst case)
     *            iii) City + Highway (Avg traffic) - 20km/litre        ===> (avg case)
     *      c. In short, asymptotic notations will help us in determining best case, average case and worst case scenario of an algorithm.
     * 
     * 6. TYPES OF ASYMPTOTIC NOTATIONS:
     *      a. OMEGA NOTATION:
     *              i) It is the formal way to express/represent the lower bound of an algorithm's running time.
     *             ii) Here lower bound means, for any given input, this notation determines the best amount of time an algorithm can take to complete.
     *            iii) For example: If we say a certain algorithm takes 100 secs as best amount of time. So, 100 secs will be the lower bound of that 
     *                 algorithm. The algorithm can take more than 100 secs but it will not take less than 100 secs.
     *             iv) In short, omega notation basically provides an information about what's the minimum resource we need to run an algorithm.
     * 
     *      b. BIG 0 NOTATION:
     *              i) This notation is used to express the upper bound of an algorithm's running time.
     *             ii) Here upper bound mean, for any given input size, this notation determines the longest amount of time an algorithm can take to complete.
     *            iii) For example: If we say a certain algorithm takes 100 secs as the longest amount of time. So, 100 seconds will be the upper bound of that
     *                 algorithm. The algorithm can take less than 100 secs but it will not take more than 100 secs.
     *             iv) In short, big o notation basically provides an information about what's the maximum amount of time an algorithm may take to execute - using
     *                 this we can optimize the algorithm to its lowest possible time we can.
     * 
     *      c. THETA NOTATION:
     *              i) This notation is used to express both the upper bound and lower bound of an algorithm's running time.
     *             ii) Here lower bound and upper bound means, for any given input, this notation determines the average amount of time an algorithm can take to complete.
     *            iii) For example: If we run certain algorithm and it takes 100 secs for first run and 120 secs for second run, 110 secs for third run and so on. So, theta
     *                 notations gives an average of running time of that algorithm.
     */

    public static void main(String[] args) {
        System.out.println("empty run");   
    }
}
