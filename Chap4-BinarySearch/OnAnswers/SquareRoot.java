public class SquareRoot {

    // Brute Force   (TC -> n, SC -> 1)
    public int getSqRoot(int num) {

        for(int i = 1; i < num; i++) {
            if(i * i == num) return i;
            if(i * i > num) return i - 1; 
        }
        return -1;
    }

    // Optimal Approach (TC -> logn, SC -> 1);
    static int OptGetSqRoot(int num) {
        int ans = 1;

        int low = 1, high = num;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(mid * mid == num) return mid;
            else if (mid * mid <= num) {
                low = mid + 1;
                ans = mid;
            } 
            else high = mid - 1;
        }

        return ans;
    }
    public static void main(String[] args) {
        int num = 29;
        // System.out.println("The square root of " + num  + " is " + (new SquareRoot()).getSqRoot(num));
        System.out.println("The square root of " + num  + " is " + OptGetSqRoot(num));
        
    }
}
