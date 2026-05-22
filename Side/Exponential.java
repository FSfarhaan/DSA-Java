public class Exponential {
    // Brute force (TC -> n, SC -> 1);
    static int pow(int x, int n) {
        int ans = 1;
        for(int i = 1; i <= n; i++) {
            ans = ans * x;
        }
        return ans;
    }

    // Optimal approach (TC -> logn, SC -> 1);
    static int OptPow(int x, int n) {
        int ans = 1;
        while (n > 0) {
            if(n % 2 == 1) {
                n--;
                ans *= x;
            }
            else {
                n = n / 2;
                x *= x;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 2, n = 21;
        System.out.println(OptPow(x, n));
    }
}