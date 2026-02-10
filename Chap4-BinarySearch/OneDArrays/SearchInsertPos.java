public class SearchInsertPos {
    static int searchInsert(int nums[], int target) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target)  {
                high = mid - 1;
                ans = mid;
            }
            else low = mid + 1;
        }

        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,3,5,6};
        System.out.println("The position would be: " + searchInsert(nums, 7));        
    }
}
