public class KthMissingNumber {

    // Brute force (TC -> n, SC -> 1);
    static int getMissingNumber(int arr[], int k) {
        if(k < arr[0]) return k;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= k) k++;
            else break;
        }
        return k;
    }

    // Optimal approach
    static int OptGetMissingNumber(int arr[], int k) {
        if(k < arr[0]) return k;
        
        int low = 0, high = arr.length - 1;
        int rem = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            rem = arr[mid] - (mid + 1);

            if(rem < k) low = mid + 1;
            else high = mid - 1;

            // System.out.println("Low is: " + low + " high is: " + high);
        }

        return k + high + 1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int k = 5;
        // System.out.println("The missing number is: " + getMissingNumber(arr, k));
        System.out.println("The missing number is: " + OptGetMissingNumber(arr, k));
    }
}
