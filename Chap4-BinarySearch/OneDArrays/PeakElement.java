public class PeakElement {

    // Brute Force
    static void getPeak(int arr[]) {
        int n = arr.length;
        int peak = -1;
        for(int i = 0; i < n; i++) {
            if((i < n - 1 && arr[i] > arr[i+1]) && (i > 0 && arr[i] > arr[i-1])) {
                peak = i;
            }
        }

        System.out.println("The peak is: " + peak);
    }

    // Optimal Approach
    static void OptGetPeak(int arr[]) {
        int low = 0, high = arr.length - 1;
        if(arr.length == 1) return;

        while (low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] > arr[mid + 1]) {
                high = mid - 1;
            } else low = mid + 1;
        }

        System.out.println("The peak issss: " + arr[low]);
    }
    public static void main(String[] args) {
        int arr[] = {3,1,2};
        // getPeak(arr);
        OptGetPeak(arr);
    }
}
