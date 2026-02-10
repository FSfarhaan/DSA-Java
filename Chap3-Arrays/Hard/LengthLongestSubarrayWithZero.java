import java.util.HashMap;

public class LengthLongestSubarrayWithZero {

    // Brute force (TC -> n2, SC -> 1);
    static void longestSubarr(int arr[]) {
        int max = 1;
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += arr[j];

                if(sum == 0) {
                    max = Math.max(max, j - i + 1);
                    System.out.println("For i: " + i + " and j: " + j + " Max is: " + max);
                }
            }
        }

        System.out.println("Longest: " + max);
    }

    // Optimal Approach (TC -> nlogn + n, SC -> n);
    static void OptLongest(int arr[]) {
        int n = arr.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int sum = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum == 0) {
                max = i + 1;
            } else  {
                if(hashMap.containsKey(sum)) {
                    max = Math.max(max, i - hashMap.get(sum));
                } else {
                    hashMap.put(sum, i);
                }
            }
   
        }
        System.out.println("Max is: " + max);
    }

    public static void main(String[] args) {
        int arr[] =  {1, 0, -5};
        // longestSubarr(arr);
        OptLongest(arr);
    }
}