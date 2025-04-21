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
     }
}
