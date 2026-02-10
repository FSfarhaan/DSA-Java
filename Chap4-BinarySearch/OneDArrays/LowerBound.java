class LowerBound {

    // Brute force (TC -> n, SC -> 1)
    static void getLowerBound(int arr[], int target) {
        int n = arr.length;
        int ans = -1;
        for(int i = n - 1; i > 0; i--) {
            if(arr[i] >= target) {
                ans = i;
            }
        }

        System.out.println("Lower bound is: " + ans);
    }

    // Optimal Approach (TC -> logn, SC -> 1)
    static void OptgetLowerBound(int arr[], int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] >= target)  {
                high = mid - 1;
                ans = mid;
            }
            else low = mid + 1;
        }

        System.out.println("Lower bound is: " + ans);
    }
    public static void main(String[] args) {
        int nums[] = {3, 5, 8, 8, 8, 15, 19};
        // getLowerBound(nums, 9);
        OptgetLowerBound(nums, 8);
    }
}