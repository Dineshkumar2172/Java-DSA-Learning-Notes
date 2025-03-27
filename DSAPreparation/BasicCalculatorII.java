package DSAPreparation;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        char sign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                continue;
            }

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
