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

    // Optimal
    static int mySqrt2(int x) {
        int low = 0, high = x;
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if(mid <= x / mid) low = mid + 1; 
            else high = mid - 1;
        }
        return high;
    }

    public static void main(String[] args) {
        int x = 9;
        System.out.println(mySqrt2(x));
    }
}
