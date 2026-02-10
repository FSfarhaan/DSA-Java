import java.util.HashMap;

public class CountSubarray {

    // Brute Force (TC -> n2, SC -> 1);
    static void countSubarray(int arr[], int k) {
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i ++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += arr[j];
                if(sum == k) count++;
            }
        }

        System.out.println(count);
    }

    // Optimal Approach (TC -> nlogn + n, SC -> n);
    static void OptCount(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int count = 0;
        int prefixSum = 0;
        map.put(0, 1);
        
        for(int i = 0; i < n; i++) {
            prefixSum += arr[i];

            int rem = prefixSum - k;
            count += map.getOrDefault(rem, 0);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);       
        }

        System.out.println(count);
    }
    public static void main(String[] args) {
        int arr[] = {1,2, 3};
        // countSubarray(arr, 6);
        OptCount(arr, 3);
    }
}
