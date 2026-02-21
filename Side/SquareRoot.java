public class SquareRoot {
    // Brute force
    static int mySqrt(int x) {
        int ans = 1;
        for(int i = 1; i < x / 2; i++) {
            if(i * i > x) {
                break;
            }
            ans = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 39;
        System.out.println(mySqrt(x));
    }
}
