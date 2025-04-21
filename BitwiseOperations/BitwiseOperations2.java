package BitwiseOperations;

public class BitwiseOperations2 {
    /*
     *      AND (&) - returns bit 1 if both corresponding bits are 1
     *      OR  (|) - returns bit 1 if one of corresponding bits are 1
     *      XOR (^) - returns bit 1 if both the corresponding bits are different.
     *      NOT (~) - perform bitwise NOT operation. Flip all the bits (0 becomes 1 and 1 becomes 0)
     *      Left Shift  (<<) - shifts bits of the number to the left by a specified number of positions.
     *                         It is equivalent to multiplying a number by 2 for each shift.
     *      Right Shift (>>) - shifts bits of the number to the right by a specified number of positions.
     *                         It is equivalent to dividing a number by 2 for each shift.
     *      Unsigned Right Shift (>>>) - shifts the bits towards right, filling the leftmost bits with zeros, 
     *                                   irrespective of the sign of number.
     */

    

     public static void main(String[] args) {
        System.out.println(4<<3); // becomes 32 - shit left three times - equivalent to multiplying by 2 at a time, 4 -> 8 -> 16 -> 32
        System.out.println(32>>4); // becomes 4 - shtft right three times - equivalent to dividing by 2 each time, 32 -> 16 -> 8 -> 4 -> 2
        System.out.println(-32>>>2); // distinction between >> and >>> happens when number is negative.
        
        System.out.println();
        System.out.println("exercise section : ");
        System.out.println(5&3);
        System.out.println(10|6);
        System.out.println(7^12);


        // expression x & -x - used to get lowest set bit (bits are 0s and 1s - 1s are considered as set bits)
        // example - binary representation of 10 is 1010 - its sequence is calculated from right to left 3,2,1,0 (<---)
        // lowest set but mean the first set bit (1) occurs in a binary representation of a number.
        System.out.println(6 & -6); // keeping x = 6
        System.out.println(40 & -40); // keeping x = 40
        // assume we need to count number of set bits in a given number, we can get LSB and remove it from main bit each time until it becomes bit having only 0's
        int x = 42; // binary representation of an integer - 101010 - has 3 set bits
        int count = 0;
        while (x > 0) {
            x -= x & (-x);
            count++;
        }
        System.out.println(count);
        
        // BITMASK - A bitmask is a number where certain bits are set (i.e., they are 1), and others may be cleared (i.e., they are 0).
        // SUBMASK - A submask refers to any number that has some of the bits set to 1 from the original bitmask, and the other bits set to 0.
        // assume we have a number - 20
        // it's binary representation or bitmask is 10100
        // it's submasks are -> 00100 (4), 10000 (16), 10100 (20), 00000 (0)
        // in simple terms - submask must always have some or all of the 1 bits from the original bitmask, but it doesn't add any extra 1 bits.
        System.out.println();
        int number = 7;
        int submask = number;
        while (submask > 0) {
            // it's a submask - portions of 1's or LSB's from bitmask
            System.out.println(Integer.toBinaryString(submask));
            submask = (submask - 1) & number;
        }

        // find the last set bit
        int bitmask = 6; // (0110) - LST is 0010 - 2
        int lastSetBit = bitmask & (-bitmask);
        System.out.println("last set bit for 6 : " + lastSetBit);
        bitmask = 40; // (101000) - LSB is 001000 - 8
        lastSetBit = bitmask & (-bitmask);
        System.out.println("last set bit for 40 : " + lastSetBit);

        // count set bits in a given integer
        bitmask = 13; // 1101
        count = 0;
        while (bitmask > 0) {
            bitmask -= (bitmask & -bitmask);
            count++;
        }

        System.out.println("number set bits in a given number 13 : " + count);

        System.out.println(3 << 2);  // 3 * 2^2 = ? - We multiple 3 by 2 two times, hence the output will be 12
        System.out.println(16 >> 2); // 16 / 2^2 = ? - We divide 16 by 2 two times, henc the output will be 4
        System.out.println(-2 >>> 1); // What happens to the sign? sign will get removed and return a larger integer number

        // Use Bitmask to Toggle a Bit - Given a number x = 42 → 101010 - Toggle the 1st and 3rd bit (0-indexed from right).


        /*************************************************** EXERCISE ***************************************************/
        // 1. Checking if a number is odd or even
        // Even number: Least significatn bit is 0
        // Odd number: Least significant bit is 1
        int checkNum = 10;
        if ((checkNum & 1) == 1) System.out.println("entered number is odd");
        else System.out.println("entered number is even");

        // 2. Counting the number of set bits (1s) in a number
        int checkNum2 = 29; // 11101 in binary
        int countNum2 = 0;
        while (checkNum2 > 0) {
            checkNum2 -= checkNum2 & -checkNum2;
            countNum2++;
        }
        System.out.println("number of set bits in a given number is : " + countNum2);

        // 3. Swap two numbers without using temproary variable
        int swap1 = 5;
        int swap2 = 10;

        swap1 = swap1^swap2;
        swap2 = swap1^swap2;
        swap1 = swap1^swap2;

        System.out.println("after swap swap1 = " + swap1 + ", swap2 = " + swap2);
     }
}
