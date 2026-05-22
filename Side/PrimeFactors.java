import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrimeFactors {

    // Brute force (TC -> n, SC -> 1);
    static ArrayList<Integer> pf(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) ans.add(i);
        }
        return ans;
    }

    static boolean isPrime(int n) {
        if(n == 2) return true;
        if(n % 2 == 0 || n == 1) return false;
        for(int i = 3; i * i <= n; i = i + 2) {
            if(n % i == 0) return false;
        }
        return true;
    }

    // Better (TC -> /n*/n)
    static ArrayList<Integer> BetPf(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i * i <= n; i++) {
            if(n % i == 0) {
                if(isPrime(i)) ans.add(i);
                if(i != n / i && isPrime(n/i)) ans.add(n / i);
            }
        }
        return ans;
    }

    // Better 2 (TC -> n, SC -> 1);
    static ArrayList<Integer> OptPf(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 2; i <= n; i++) {
            if(n % i == 0) {
                while (n % i == 0) {
                    ans.add(i);
                    n = n / i;
                }
            }
        }
        return ans;
    }

    // Optimal (TC -> logn, SC -> 1);
    static ArrayList<Integer> OptPf(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                ans.add(i);
                while (n % i == 0) {
                    n = n / i;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 39;
        ArrayList<Integer> ans = OptPf(n);

        for(int k: ans) {
            System.out.print(k + " ");
        }
    }
}
