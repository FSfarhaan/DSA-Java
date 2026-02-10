public class SearchInRotated {
    static int getRotation(int arr[], int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) {
                return mid;
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

        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        System.out.println("No of rotations are: " + getRotation(arr, 3));
    }
}
