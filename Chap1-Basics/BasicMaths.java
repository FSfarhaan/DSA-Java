import java.util.ArrayList;

class BasicMaths {
    static int countDigit(int n) {
        int digits = 0;
        while(n != 0) {
            digits++;
            n /= 10;
        }

        return digits;
    }

    static int reverseDigit(int n) {
        long revDigit = 0;
        while(n != 0) {
            int digit = n % 10;
            revDigit = revDigit * 10 + digit;
            System.out.println("Currently: " + n + " " + revDigit);
            n = n / 10;
        }

        if(revDigit > Integer.MAX_VALUE || revDigit < Integer.MIN_VALUE) return 0;

        return (int) revDigit;
    }

    static boolean isPalindrome(int x) {
        if(x < 0) return false;
        int num = x;
        int sum = 0;
        while(x != 0) {
            int digit = x % 10;
            if(sum > Integer.MAX_VALUE / 10) return false;
            sum = sum * 10 + digit;
            x /= 10;
        }

        if(num == sum) return true;
        return false;
    }
    
    static int findGCD (int n1, int n2) {
        // Brute Force method;
        int GCD = 1;
        int min = n1 < n2 ? n1 : n2;

        for(int i = min; i > 1; i--) {
            if(n1 % i == 0 && n2 % i == 0) {
                GCD = i;
                break;
            }
        }
        return GCD;
    }

    static int findGCDb(int n1, int n2) {
        // Euclidean Algorithm
        while (n1 > 0 && n2 > 0) {
            if(n1 > n2) n1 = n1 % n2;
            else n2 = n2 % n1;
        }

        return n1 == 0 ? n2 : n1;
    }

    static boolean armStrongNo (int x) {
        int num = x;
        int result = 0;

        while(x != 0) {
            int digit = x % 10;
            result += digit * digit * digit;
            x = x / 10;
        }

        if(result == num) return true;
        return false;
    }

    static int[] getDivisors (int n, int [] size) {
        int [] divisors = new int[n];
        int count = 0;

        for(int i = 1; i < n; i ++) {
            if(n % i == 0) divisors[count++] = i;
        }

        size[0] = count;
        
        return divisors;
    }

    static ArrayList<Integer> getDivisorsB (int n) {
        ArrayList<Integer> divisors = new ArrayList<>();

        for(int i = 1; i < Math.sqrt(n); i++) {
            if(n % i == 0) {
                divisors.add(i);

                if(i != n / i) {
                    divisors.add(n / i);
                }
            }
        }

        return divisors;
    }

    static boolean isPrime (int n) {
        if(n < 0 || n % 2 == 0) return false;
        for(int i = 3; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // int num = countDigit(17994);
        // System.out.println(countDigit(1776));
        // System.out.println(reverseDigit(1534236469));
        // System.out.println(isPalindrome(1234567899));
        // System.out.println(findGCDb(15, 20));
        // System.out.println(armStrongNo(372));

        // int [] size = new int[1];
        // int [] divisors = getDivisors(72, size);
        // for(int i = 0; i < size[0]; i++) {
        //     System.out.print(divisors[i] + " ");
        // }

        // ArrayList<Integer> divisors = getDivisorsB(16);
        // for(int div: divisors) {
        //     System.out.print(div + " ");
        // }
        System.out.println(isPrime(53));


    }
}