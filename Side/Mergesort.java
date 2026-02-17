package Side;

import java.util.ArrayList;

public class Mergesort {
    static void merge(int [] nums, int start, int mid, int end) {
        int left = start, right = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= end) {
            if(nums[left] < nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while (left <= mid) {
            temp.add(nums[left++]);
        }

        while (right <= end) {
            temp.add(nums[right++]);
        }

        for(int i = start; i <= end; i++) {
            nums[i] = temp.get(i - start);
        }

    }
    static void partition(int[] nums, int start, int end) {
        if(start >= end) return;

        int mid = (start + end) / 2;
        partition(nums, start, mid);
        partition(nums, mid+1, end);

        merge(nums, start, mid, end);
    }

    static int[] sortArray(int[] nums) {
        partition(nums, 0, nums.length - 1);
        return nums;
    }
    
    public static void main(String[] args) {
        int arr[] = { 1, 4, 12, 14, 5, 8, 10 };
        sortArray(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
