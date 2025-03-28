package DSAPreparation;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // iterating till we find element < 9 in the given array
            if (digits[i] < 9) {
                digits[i]++; // increment the <9 value to 1
                return digits; // return the result
            }

            digits[i] = 0; // if the current element is 9, then update it to 0
        }

        // if we couldn't handle the increment within above operation
        // it basically means that we didn't encounter any value less than 9
        // because array must be containing all 9 values as elements.
        // in such scenario - we have increase the size of array by 1 and add 1 at percedence.
        // example: 999 will become 1000, 9999 will become 10000 having one additional element
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
