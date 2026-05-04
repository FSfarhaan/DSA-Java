public class CheckNumberIsOdd {

    // Brute
    static boolean checkOdd(int num) {
        return num % 2 != 0;
    }

    // Optimal
    static boolean OptCheckOdd(int num) {
        return (num & 1) != 0;
    }
    public static void main(String[] args) {
        int num = 9;
        System.out.println(OptCheckOdd(num));
    }
}
