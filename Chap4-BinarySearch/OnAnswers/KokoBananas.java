import java.util.Arrays;

public class KokoBananas {

    public static long totalHours(int arr[], int i) {
        // 17, 7;
        int totalHrs = 0;
        for(int ele: arr) {
            totalHrs += (int)Math.ceil((double)ele / i);
        }
        return totalHrs;
    }
    // Brute force (TC -> max(arr)* n, SC -> 1)
    public static int getKokoHours(int arr[], int h) {
        // find max number;
        int maxVal = Arrays.stream(arr).max().getAsInt();
        

        for(int i = 1; i <= maxVal; i++) {
            long hours = totalHours(arr, i);
            if(hours == h) return i;
        }

        return maxVal;
    }

    // Optimal Approach (TC -> n*log(max(arr)), SC -> 1);
    static int OptGetKokoHours(int arr[], int h) {
        int maxVal = Arrays.stream(arr).max().getAsInt();
        if(arr.length == h) return maxVal;

        int low = 1, high = maxVal;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hours = totalHours(arr, mid);

            if (hours <= h) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }

    public static void main(String[] args) {
        int arr[] = {30,11,23,4,20};
        int h = 6;
        // System.out.println("The answer is: " + getKokoHours(arr, h));
        System.out.println("The answer is: " + OptGetKokoHours(arr, h));
        
    }
}
