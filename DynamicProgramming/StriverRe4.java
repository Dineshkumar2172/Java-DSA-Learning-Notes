package DynamicProgramming;

public class StriverRe4 {
    // 1. function reverse an integer
    public static void reverseArray(int[] arr, int l, int r) {
        // Time complexity -  0(log n) - we are calling same function n/2 times
        // Space complexity - 0(n)- there will be n new stacks created.
        if (l >= r) return;

        int temp = arr[l];
        arr[l] =  arr[r];
        arr[r] = temp;
        reverseArray(arr, l+1, r-1);
    }

    // can also implement the same function using single pointer
    // tradeoff is we need to calculate the corresponding pointer ourselves using n - i - 1 with base condition i < n/2.

    // 2. String is a palindrome of not.
    // return true - if given input is a palindrome
    // return false - if given input is not a palindrome
    public static boolean isPalindrome(int left, int right, String word) {
        // Time complexity - 0(log n) - we are calling same function n/2 times
        // Space complexity - 0(n)- there will be n new stacks created.
        if (left >= right) return true;
        if (word.charAt(left) != word.charAt(right)) return false;

        return isPalindrome(left+1, right-1, word);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        reverseArray(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + ", ");
        System.out.println();

        // String word = "mom";
        String word = "ranoonar";
        // String word = "mnsenm";
        System.out.println(isPalindrome(0, word.length() - 1, word));
    }
}
