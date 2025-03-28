package DSAPreparation;

public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        long num = 0;
        int sign = 1, i = 0;

        // what if we start seeing non numeric characters before numeric?
        // traversing through initial set of white spaces if any
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }

            break;
        }

        if (i < s.length()) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                sign = (s.charAt(i) == '+') ? 1 : -1;
                i++;
            }

            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');

                if (num * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                if (num * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                i++;
            }
        }

        return (int)(num * sign);


    }
}
