import java.util.Arrays;

public class AggressiveCows {
    static int getDistance(int arr[], int minDistance) {
        int cows = 1;
        int lastIndex = 0;
        // 1, 2, 3, 4, 5, 6
        // 0,3,4,7,9,10
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - arr[lastIndex] >= minDistance) {
                cows++;
                lastIndex = i;
            }
        }
        return cows;
    }
    
    // Brute force (TC -> n * max, SC -> 1);
    static int getMaxOfMinDistance(int arr[], int cows) {
        Arrays.sort(arr);
        int n = arr.length;
        int max = arr[n - 1];
        int ans = -1;

        for(int i = 1; i <= max; i++) {
            if(getDistance(arr, i) < cows) {
                ans = i - 1;
                break;
            }
        }

        return ans;
    }

    // Optimal approach
    static int OptGetMaxOfMinDistance(int arr[], int cows) {
        Arrays.sort(arr);
        int low = 1, high = arr[arr.length - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(getDistance(arr, mid) < cows) high = mid - 1;
            else low = mid + 1;
        }
        return high;
    }
    public static void main(String[] args) {
        int arr[] = {4,2,1,3,6};
        // 1, 2, 3, 4, 5, 6
        int k = 2;
        // System.out.println("The answer is: " + getMaxOfMinDistance(arr, k));
        System.out.println("The answer is: " + OptGetMaxOfMinDistance(arr, k));
    }
}
