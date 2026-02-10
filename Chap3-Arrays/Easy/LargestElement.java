import java.util.Arrays;

public class LargestElement {
    // Brute force
    static void brutLargest(int [] arr) {
        Arrays.sort(arr);    
        System.out.println("The largest element is: " + arr[arr.length - 1]);
    }

    // Optimal
    static void optLargest(int [] arr) {
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i]) max = arr[i];
        }
        System.out.println("The largest element is: " + max);
        
    }

    public static void main(String[] args) {
        int [] arr = new int[]{ 2, 5, 1, 3, 0 };
        // brutLargest(arr);
        optLargest(arr);
    }
}
