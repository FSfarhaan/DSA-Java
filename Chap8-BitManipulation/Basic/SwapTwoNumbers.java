public class SwapTwoNumbers {
    public static void main(String[] args) {
        int a = 5, b = 7;

        // Normally:
        // temp = a; a = b; b = temp;

        // Or:
        // a = a + b; b = a - b; a = a - b;

        // Using bits:
        // a = a ^ b;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a: " + a + " b: " + b);
    }
}
