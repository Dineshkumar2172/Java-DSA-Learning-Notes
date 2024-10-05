public class TimeComplexity {
    // asymptotic notagtions - used to analyse the performance of an algorithm based on input size
    // 1. Omega notation - to find lower bound, find best case of an algorithm
    // 2. Big O - to find the upper bound, find worst case of an algorithm (most commonly used notation to find time and space complexity)
    // 3. Theta notation - use to express both upper bound and lower bound. basically average running time of an algorithm - avg of best and worst case

    public static void main(String[] args) {
        double now = System.currentTimeMillis();
        TimeComplexity demo = new TimeComplexity();
        // demo.findSum(999999);
        demo.findSumIterative(999999);
        System.out.println("Time taken : " + (System.currentTimeMillis() - now) + " milliseconds");
    }

    // constant time - take constant time for any input size
    public int findSum(int n){
        return n * (n + 1) / 2;
    }

    // lienar time - runtime increases based on input size proportionally
    public int findSumIterative(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        return sum;
    }
}
