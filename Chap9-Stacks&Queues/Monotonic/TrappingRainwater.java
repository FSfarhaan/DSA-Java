public class TrappingRainwater {

    static int getLeftMax(int[] arr, int end) {
        int leftMax = 0;
        for(int i = 0; i <= end; i++) {
            leftMax = Math.max(leftMax, arr[i]);
        }
        return leftMax;
    }

    static int getRightMax(int[] arr, int start) {
        int rightMax = 0;
        for(int i = start; i < arr.length; i++) {
            rightMax = Math.max(rightMax, arr[i]);
        }
        return rightMax;
    }

    // Brute force (TC -> n2, SC -> 1);
    static int getWater(int[] arr) {
        int water = 0;
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            int leftMax = getLeftMax(arr, i);
            int rightMax = getRightMax(arr, i);
            water += Math.min(leftMax, rightMax) - arr[i]; 
        }

        return water;
    }

    // Optimal approach
    static int OptGetWater(int[] arr) {
        int n = arr.length;
        int maxLeft = 0, maxRight = 0;
        int left = 0, right = n - 1;
        int water = 0;

        while (left <= right) {
            if(arr[left] <= arr[right]) {
                if(arr[left] < maxLeft) water += maxLeft - arr[left];
                else maxLeft = arr[left];
                left++;
            } else {
                if(arr[right] < maxRight) water += maxRight - arr[right];
                else maxRight = arr[right];
                right--;
            }
        }
        return water;
    }
    
    public static void main(String[] args) {
        int[] arr = { 4,2,0,3,2,5 };
        System.out.println(OptGetWater(arr));
    }
}
