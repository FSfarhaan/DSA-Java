import java.util.Arrays;

public class PaintersProblem {

    static int getPainters(int arr[], int k) {
        int painters = 1;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(sum + arr[i] > k) {
                painters++;
                sum = arr[i];
            } else sum += arr[i];
        }
        return painters;
    }

    static int OptGetPainters(int arr[], int k) {
        if(k > arr.length) return -1;

        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int painters = getPainters(arr, mid);
            if(painters <= k) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5}; 
        int painters = 2;

        System.out.println("The answer is: " + OptGetPainters(arr, painters));
    }
}
