public class BasicRecursion {
    static void printRec(int n) {
        if(n == 0) return;
        printRec(n-1);
        System.out.println(n);
    }

    static void printRecRev(int n) {
        if(n == 0) return;
        System.out.println(n);
        printRecRev(n - 1);
    }

    static int sumOfNum(int n) {
        if(n == 1) return 1;
        return n + sumOfNum(n - 1);
    }

    static int fact(int n) {
        if(n == 1) return 1;
        return n * fact(n - 1);
    }

    static int reverse(int n, int sum) {
        if(n == 0) return sum;

        int digit = n % 10;
        return reverse(n / 10, sum * 10 + digit);
    }

    static boolean isPalindrome(String str, int index) {
        // ABCCBA
        // A -> 0, 4 Correct
        // B -> 1, 3 Correct
        // C -> 2, 2 Correct
        // if(index == index - 1) return true;
        if(index == str.length() / 2) return true;
        if(str.charAt(index) != str.charAt(str.length() - index - 1)) return false;
        return isPalindrome(str, index + 1);        
    }

    static int fibo(int n) {
        if(n <= 1) return n;
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        // printRec(5);
        // printRecRev(5);
        // System.out.println(sumOfNum(6));
        // System.out.println(isPalindrome("1221221", 0));
        System.out.println(fibo(3));
    }
}
