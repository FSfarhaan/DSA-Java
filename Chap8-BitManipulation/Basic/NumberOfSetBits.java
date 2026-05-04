public class NumberOfSetBits {
    
    // Brute force (TC -> nlogn, SC -> 1);
    static int setBits(int n) {
        String bin = Integer.toBinaryString(n);
        int count = 0;

        for(int i = 0; i < bin.length(); i++) {
            if(bin.charAt(i) == '1') count++;
        }
        return count;
    }

    // Better (TC -> logn, SC -> 1);
    static int BetSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >> 1;
        }
        return count;
    }

    // Optimal (TC -> k (no of 1s), SC -> 1);
    // Approach: To turn off a bit, basically the rightmost, you do n & n - 1 => This will turn off the rigthmost set bit. So here we are turning off set bits, and counting how many times we are doing it... It will give us total number of 1s in it.
    static int OptSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(OptSetBits(n));
    }
}
