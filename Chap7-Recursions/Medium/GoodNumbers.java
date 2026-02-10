public class GoodNumbers {
    static long MOD = 1000000007;
    // Brute Force
    static long countGoodNumbers(long n) {
        if(n == 1) return 5;
        if(n == 2) return 20;
        if(n % 2 == 0) return  ((countGoodNumbers(n/2) % MOD) * (countGoodNumbers(n/2) % MOD))% MOD ;
        else return ((countGoodNumbers(n/2) % MOD ) * (countGoodNumbers(n/2 + 1) % MOD)) % MOD;
    }

    static long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if(exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp = exp / 2;
        }
        return result;
    }

    // Optimal approach
    static int OptCountGoodNumbers(long n) {
        long evenPos = (n + 1)/ 2;
        long oddPos = n / 2;
        
        return (int) ((modPow(5, evenPos) * modPow(4, oddPos)) % MOD);

    }
    public static void main(String[] args) {
        long n = 3;
        // System.out.println(countGoodNumbers(n));
        System.out.println(OptCountGoodNumbers(n));
    }
}
