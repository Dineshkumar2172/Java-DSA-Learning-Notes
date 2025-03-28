package DSAPreparation;

import java.util.Stack;

public class BasiCalulator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0; // to track overall result
        int num = 0; // to build current num be reading each digits
        int sign = 1; // since all our operations start with 1
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            // if current character is a digit - from 0 to 9
            if (Character.isDigit(chr)) {
                // num * 10 to add one more space behind the current digit to add addition integer
                // chr - '0' it perform ASCII based subtraction where '0' is equal to 48
                num = num * 10 + (chr - '0');
                continue;
            }

            // once we finish building the integer
            if (chr == '+' || chr == '-') {
                result += sign * num;
                sign = (chr == '+') ? 1 : -1; // 1 for addition and -1 for subtraction
                num = 0; // now it's time building next digit based on above updated sign
                continue;
            }

            // if we encounter '(' - then we first need to clean up current state of result and sign
            if (chr == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
                num = 0;
                continue;
            }

            if (chr == ')') {
                result += sign * num; // processing latest num and it's associate sign to get final sub result
                result *= stack.pop(); // assume sub result = -10 and it's overall operation is -, then we have +10
                result += stack.pop(); // building final result by combining overall and sub result;
                sign = 1;
                num = 0;
            }
        }

        result += sign * num;

        return result;
    }
}
