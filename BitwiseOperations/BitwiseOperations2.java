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
     }
}
