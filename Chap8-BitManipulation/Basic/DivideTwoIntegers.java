public class DivideTwoIntegers {

    // Brute force (TC -> dividend / divisor, SC -> 1);
    static int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        if(divisor == 1) return dividend;
        
        boolean isPos = true;
        if((dividend > 0 && divisor < 0) || dividend < 0 && divisor > 0) isPos = false;

        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);

        System.out.println("d: " + d + " n: " + n);

        long sum = 0, ans = 0;
        while (sum + d <= n) {
            ans++;
            sum += d;
        }

        System.out.println("Ans to ye raha " + ans);

        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        
        if(!isPos && ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return isPos ? (int) ans : (int) (-1 * ans);
    }

    // Optimal Approach
    static int OptDivide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        if(divisor == 1) return dividend;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        boolean isPos = true;
        if((dividend > 0 && divisor < 0) || dividend < 0 && divisor > 0) isPos = false;

        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);

        long ans = 0;
        while(n >= d) {
            int count = 0;
            while (n >= (d << (count+1))) {
                count++;
            }
            ans += 1 << count;

            n -= d * (1 << count);
        }

        if(ans > Integer.MAX_VALUE && isPos) return Integer.MAX_VALUE;
        if(ans > Integer.MAX_VALUE && !isPos) return Integer.MIN_VALUE;

        return isPos ? (int)ans : (int) (-1 * ans);
        
    }
    
    public static void main(String[] args) {
        int dividend = -2147483648, divisor = 2;
        System.out.println(OptDivide(dividend, divisor));
    }
}
