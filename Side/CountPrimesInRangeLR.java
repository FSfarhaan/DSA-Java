public class CountPrimesInRangeLR {

    // Optimal approach (Sieve of Eratosthenes)
    static int countPrimes(int l, int r) {
        if(r <= 2) return 0;

        int[] isPrime = new int[r+1];
        for(int i = 0; i <= r; i++) {
            isPrime[i] = 1;
        }
        isPrime[0] = isPrime[1] = 0;

        for (int p = 2; p * p <= r; p++) {
            if (isPrime[p] == 1) {
                for (int i = p * p; i <= r; i += p) {
                    isPrime[i] = 0;
                }
            }
        }

        int count = 0;
        for(int i = 0; i <= r; i++) {
            count += isPrime[i];
            isPrime[i] = count;
        }

        return isPrime[r] - isPrime[l];

    }
    public static void main(String[] args) {
        int L = 10, R = 100;
        System.out.println(countPrimes(L, R));
    }
}
