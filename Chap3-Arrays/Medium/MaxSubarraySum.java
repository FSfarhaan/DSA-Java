public class MaxSubarraySum {

    // Brute force (TC -. n2, SC -> 1)
    static void getMaxSum (int arr[]) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += arr[j];
                System.out.println(sum);
                maxSum = Math.max(maxSum, sum);
            }

        }

        System.out.println("Max of subarray is: " + maxSum);
    }

    // Optimal approach (Kadane's Algorithm) (TC -> n, SC -> 1)
    static void OptiGetMax(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(sum > maxSum) maxSum = sum;

            if(sum < 0) sum = 0;

        }

        if(maxSum < 0) maxSum = 0;

        System.out.println("Maxsum is: " + maxSum);

    }
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        // getMaxSum(arr);

        OptiGetMax(arr);
    }
}
