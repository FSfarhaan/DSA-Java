import java.io.ObjectInputFilter;

public class MyPow {
    static double posPow(double x, int n) {
        if(n == 1) return x;
        return x * posPow(x, n-1);
    }

    static double negPow(double x, int n) {
        if(n == 1) return (1/x);
        return (1/x) * negPow(x, n-1);
    }

    // Brute force -> Linear recursion. (TC -> n, SC -> n); Fails for larger values of n
    static double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(n > Integer.MAX_VALUE || n < Integer.MIN_VALUE) return 0;

        if(n > 0) return posPow(x, n);
        else return negPow(x, -n);
    }

    static double OptGetPow(double x, long n) {
        if(n == 0) return 1.0;
        
        double half = OptGetPow(x, n/2);
        if (n % 2 == 0) return half * half;
        else return half * half * x;
    }

    // Optimal approach -> Log recursion
    static double OptMyPow(double x, int n) {
        long N = n;
        if(N < 0) {
            x = 1/x;
            N = -N;
        }
        return OptGetPow(x, N);
    }
    public static void main(String[] args) {
        double x = 2.00;
        int n = 200000000;
        System.out.println(OptMyPow(x, n));
    }
}
