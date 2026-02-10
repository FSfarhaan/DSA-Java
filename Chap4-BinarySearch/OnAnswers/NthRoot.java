public class NthRoot {

    // Brute Force (TC -> n2, SC -> 1);
    static int getNthRoot(int n, int x) {
        // Return n ^ x; Or -1 if it does not exis

        // n = 8, x = 3;
        // n = 64, 6
        for(int i = 1; i <= n; i++) {
            int ans = 1;
            for(int j = 1; j <= x; j++) {
                ans = ans * i;
            }
            if(ans == n) return i;
        }  

        return -1;
    }

    static int checkRoot(int num, int mid, int x)  {
        int ans = 1;    
        for(int i = 1; i <= x; i++) {
            if(ans > num) return -1;
            ans = ans * mid;
        }
        return ans;
    }

    // Optimal Approach 
    static int OptGetNthRoot(int num, int x) {
        int low = 1, high = num;    

        while (low <= high) {
            int mid = low + (high - low) / 2;      

            int val = checkRoot(num, mid, x);

            if(val == num) return mid;
            else if(val == -1 || val > num) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int num = 81;
        int x = 4;
        // System.out.println("The answer is: " + getNthRoot(num, x));
        System.out.println("The answer is: " + OptGetNthRoot(num, x));
    }

}
