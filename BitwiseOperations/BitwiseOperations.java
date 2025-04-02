package BitwiseOperations;

public class BitwiseOperations {
    public static void main(String[] args) {

        // reference - https://youtu.be/igIjGxF2J-w

        /*
         * 1. Bitwise operators work on individual bits - it's useful whem working with binary numbers.
         * 
         * 2. There are 7 bitwise operators - &, |, ^, ~, <<, >>
         */

        // & - AND operator
        // 1. assume we are doing bitwise and & on 6 (110) and 7(111) (6 & 7) - it's output will be 110 (6 in decimal). (refer below for how its done)
        //             1  --  1  -> 1
        //             1  --  1  -> 1
        //             0  --  1  -> 0
        //          (operation is performd on individual bits of each operands)

        // | - OR operator
        // 1. assume we are doing bitwise or on 5 (101) and 6 (110) (5 | 6) - it's output will be 111 (7 i decimal). (refer below for how its done)
        //             1  --  1  -> 1
        //             0  --  1  -> 1
        //             1  --  0  -> 1

        // ^ - XOR operator (it's exclusive or operator)
        // 1. Here if one of the operand's bits is 0, then it corresponding bit from other operand should be 1.
        // 2. Assume we are doing XOR on 5 (101) and 6 (110) (5 ^ 6) - it's output will be 011 (3 in decimal). (refer below for how its done)
        //             1  --  1  -> 0 (since both are 1)
        //             0  --  1  -> 1
        //             1  --  0  -> 1

        // ~ - NOT operator
        // 1. It works on one value - it takes a number - take its bits - flip the value of each of those bits in a number.
        // 2. For example: assume 5 (101) ==> ~5 will give (010), it flips the 0's and 1's.

        // (<<, >>) - Left & Right Shift Operators
        // 1. Similar to NOT operator - these operators works only on one number. Assume 5 << 2 - here right value indicates how many bits we have to shift number by.
        // 2. for 5 (0000 0101) << 2  - after shifting left 2 steps (2 bits inwards) it'll become (0001 0100 - equivalent to 20)
        // 3. if we do shift right operation on 20 >> 2, it'll become 5 again. 



    }
}
