package DSAPreparation;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // check if the ch is a digit? from 0 - 9
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // if ch is not a digit and it's not a space
            // same code has to be executed even if the use reaches the last index of the string
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = ch;
                num = 0;
            }
        }

        

        while (!stack.isEmpty()) {
            num += stack.pop();
        }

        return num;
    }
}
