public class PowerOfTwo {

    // Optimal
    static boolean checkPowerTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    public static void main(String[] args) {
        int num = 7;
        System.out.println(checkPowerTwo(num));
    }
}
