public class AtoI {
    static int myAtoi(String s) {
         int i = 0, n = s.length();
    int sign = 1;
    long num = 0;

    // 1. Skip leading spaces
    while (i < n && s.charAt(i) == ' ') i++;

    // 2. Handle sign
    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
        sign = (s.charAt(i) == '-') ? -1 : 1;
        i++;
    }

    // 3. Read digits
    while (i < n && Character.isDigit(s.charAt(i))) {
        num = num * 10 + (s.charAt(i) - '0');

        // 4. Clamp overflow
        if (sign * num > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (sign * num < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        i++;
    }

    return (int)(sign * num);
    }
    public static void main(String[] args) {
        String s = "21474836460";
        System.out.println(myAtoi(s));
    }
}
