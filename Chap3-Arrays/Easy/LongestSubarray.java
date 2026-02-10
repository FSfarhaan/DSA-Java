import java.util.HashMap;

public class LongestSubarray {

    // Brute force (TC -> n2, SC -> 1)
    static void getLongestSubarray(int arr[], int key) {
        int n = arr.length;

        int len = 0;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < n; j++) {
                sum += arr[j];
                if(sum == key){
                    len = Math.max(len, j - 1 + 1);
                }
            }
        }

        System.out.println(len);
    }

    // Better 1 (Optimal if Array has negatives as well) (TC -> nlogn, SC -> n);
    static void BetLongest(int arr[], int key) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = arr.length;
        int maxLen = 0;
        int sum = 0;

        // {2, 3, 5, 1, 9};
        // i = 0; sum = 2;... Hm -> 2, 0

        // i = 1; sum = 5;... Hm -> 5, 1
        // i = 2; sum = 10; len = 3; rem = 0; ... Hm -> 10, 2
        // i = 3; sum = 11; rem = 10; ... Hm -> 11, 3
        // i = 3; sum = 12; rem = 2; len = 3 - 0;
        // i = 4; sum = 20 rem = 10; len = 4 - 2 = 2


        for(int i = 0; i < n; i++) {
            sum += arr[i];
            
            if(sum == key) {
                maxLen = Math.max(maxLen, i + 1);
            }

            int rem = sum - key;

            if(hashMap.containsKey(rem)) {
                int len = i - hashMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if(!hashMap.containsKey(sum)) {
                hashMap.put(sum, i);
            }
        }


        System.out.println(maxLen);
    }

    // Optimal (For positives and 0s only) (TC -> 2N, SC -> 1)
    static void OptiLongestSub(int arr[], int key) {
        int left = 0, right = 0;
        int sum = arr[0];
        int n = arr.length;
        int maxLen = 0;

        while(right < n) {
            
            while(left <= right && sum > key) {
                sum -= arr[left];
                left++;
            }
            
            if(sum == key) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
            if(right < n) sum += arr[right];
        }

        System.out.println(maxLen);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 9};
        int k = 10;
        OptiLongestSub(arr, k);
    }
}
