import java.util.ArrayList;

class PrintDivisors {
    public static void main(String[] args) {
        int n = 36;
        ArrayList<Integer> divisors = printDivisors(n);
        for (int divisor : divisors) {
            System.out.print(divisor + " ");
        }
    }

    // Brute force (TC -> Sqrt(n), SC -> 1);
    private static ArrayList<Integer> printDivisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        return divisors;
    }
}