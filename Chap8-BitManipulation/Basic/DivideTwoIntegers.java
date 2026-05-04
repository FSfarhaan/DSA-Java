public class DivideTwoIntegers {

    // Brute force (TC -> dividend / divisor, SC -> 1);
    static int divide(int dividend, int divisor) {
        // Base cases;
        if(dividend == divisor) return 1;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 1) return dividend;

        int isPositive = 1;

        if(dividend > 0 && divisor < 0) isPositive = -1;
        if(dividend < 0 && divisor > 0) isPositive = -1;

        int n = dividend;
        int d = divisor;

        n = Math.abs(n);
        d = Math.abs(d);

        int sum = 0, ans = 0;

        while (sum + d <= n) {
            sum += d;
            ans++;
        }

        if(ans > Integer.MAX_VALUE && isPositive == 1) return Integer.MAX_VALUE;
        if(ans > Integer.MAX_VALUE && isPositive == 0) return Integer.MIN_VALUE;

        return isPositive * ans;
    }

    // Optimal Approach
    
    public static void main(String[] args) {
        int dividend = 8, divisor = -3;
        System.out.println(divide(dividend, divisor));
    }
}
