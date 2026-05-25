import java.util.ArrayList;

public class CountPrimesTillN {
    static boolean isPrime(int n) {
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    // Brute force (TC -> n * /n; SC -> 1);
    static ArrayList<Integer> countPrimes(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            if(isPrime(i)) ans.add(i);
        }
        return ans;
    }

    // Better Approach (Sieve of Eratosthenes) (TC -> 2n, SC -> 1);
    static ArrayList<Integer> BetCountPrimes(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] isPrime = new int[n+1];
        for(int i = 0; i <= n; i++) {
            isPrime[i] = 1;
        }
        isPrime[0] = isPrime[1] = 0;

        for(int i = 2; i <= n; i++) {
            if(isPrime[i] == 1) {
                ans.add(i);
                for(int j = 2 * i; j <= n; j += i) {
                    isPrime[j] = 0;
                }
            }
        }

        return ans;
    }

    // Optimal Approach
    static int OptCountPrimes(int n) {
        if(n <= 2) return 0;
        boolean[] isPrime = new boolean[n];
        // ArrayList<Integer> ans = new ArrayList<>();
        int ans = 0;

        for(int i = 0; i < n; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i < n; i++) {
            if(isPrime[i]) {
                ans++;
                // System.out.println(i + " pe ");
                // ans++;
                for(long j = 1L * i * i; j < n && j > 0; j += i) {
                    isPrime[(int)j] = false;
                }
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int n = 499979;
        System.out.println(OptCountPrimes(n));
        // ArrayList<Integer> ans = OptCountPrimes(n);

        // for(int k: ans) {
        //     System.out.print(k + " ");
        // }

    }
}