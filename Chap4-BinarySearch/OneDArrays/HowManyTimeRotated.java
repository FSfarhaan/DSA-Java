public class HowManyTimeRotated {

    static void getTimes(int nums[]) {
        // Initialize low and high pointers
        int low = 0, high = nums.length - 1;

        // Binary search loop
        while (low < high) {

            // Calculate mid index
            int mid = low + (high - low) / 2;

            // Check which half to discard
            if (nums[mid] > nums[high]) {

                // Minimum lies in right half
                low = mid + 1;

            } else {

                // Minimum lies in left half (including mid)
                high = mid;
            }
        }

        // Return the minimum element
        System.out.println("Number of times array rotated is: " + low);
    }
    public static void main(String[] args) {
        int arr[] = { 5, 6, 7, 0, 1, 2, 3 };
        getTimes(arr);
    }
}
