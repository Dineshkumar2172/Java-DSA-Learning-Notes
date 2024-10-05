public class BigONotation2 {
    
    public static void main(String[] args) {

        /**
         * 1. assignment operation takes 1 unit of time
         * 2. return statement takes 1 unit of time
         * 2. arithmetical operation takes 1 unit of time
         * 4. logical operation takes 1 unit of time
         * 5. other small/single operations take 1 unit of time
         * 6. drop lower order terms
         * 7. drop constant multipliers
         * 
         * assume T = n2 + 3n + 1 = O(n2) ==> here, 3n and 1 are lower order terms comparing to n2, hence we can drop them and consider only n2 hence T becomes O(n2)
         * assume T = 3n2 + 6n + 1 = O(n2) ==> here, 6n and 1 are lower order terms, hence droped and result is 3n2 and 3 is dropped since its constant, hence result is O(n2)
         * 
         * 
         */

        BigONotation2 demo = new BigONotation2();
        demo.print(10);
        
    }


    // constant time complexity algorithm
    public int sum(int x, int y){
        // accessing x, accessing y, adding x and y, assigning it to result = 1 + 1 + 1 + 1 = 4
        int result = x + y;

        // accessing result, returning result = 1 + 1 = 2
        return result;

        // T = 2 + 4 = 6 = C (constant)
    }


    // linear time complexity algorithm
    public int findSum(int n){
        // creating integer sum with 0
        int sum = 0; // 1 step

        for(int i = 1; i <= n; i++){
            sum = sum + i; // n steps
        }

        return sum; // 1 step

        // T = O(n)
    }


    // polynomial time complexity algorithm
    public void print(int n){
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.println("i = " + i + ", j = " + j);
            }
            System.out.println("End of inner loop");
        }
        System.out.println("End of outer Loop");

        // T = O(n2)
    }

}
