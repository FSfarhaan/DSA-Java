public class SearchInRotated2 {

    // Optimal Approach
    static boolean getRotation(int arr[], int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) {
                return true;
            } 

            // Edge case
            if(arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++; high--;
                continue;
            }

            // left half is sorted
            if(arr[low] <= arr[mid]) {

                if(arr[low] <= target && target <= arr[mid]) high = mid - 1;
                else low = mid + 1;
            } 
            // Right half is sorted
            else {
                if(arr[mid] <= target && target <= arr[high]) low = mid + 1;
                else high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int arr[] = {2,5,6,0,0,1,2};
        System.out.println("Element present: " + getRotation(arr, 3));
    }
}
