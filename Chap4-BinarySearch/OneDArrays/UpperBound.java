class UpperBound {

    // Brute force (TC -> n, SC -> 1)
    static void getUpperBound(int arr[], int target) {
        int n = arr.length;
        int ans = -1;
        for(int i = n - 1; i > 0; i--) {
            if(arr[i] > target) {
                ans = i;
            }
        }

        System.out.println("Upper bound is: " + ans);
    }

    // Optimal Approach (TC -> logn, SC -> 1)
    static void OptGetUpperBound(int arr[], int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] > target)  {
                high = mid - 1;
                ans = mid;
            }
            else low = mid + 1;
        }

        System.out.println("Upper bound is: " + low);
    }
    public static void main(String[] args) {
        int nums[] = {3,5,8,9,15,19};
        // getUpperBound(nums, 8);
        OptGetUpperBound(nums, 9);
    }
}