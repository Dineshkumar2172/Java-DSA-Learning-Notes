public class DynamicProgramming {
    public static void main(String[] args) {
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
        System.out.println(dynamicProgramming.fibonacci(4)); // calculate fibonacci number in a series
    }

    public int fibonacci(int n){
        int[] table = new int[n + 1]; // using tabular method instead of recursion
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i-1] + table[i-2];   
        }

        return table[n];
    }
}
