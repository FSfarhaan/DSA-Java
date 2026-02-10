import java.util.HashMap;

public class SubarraysWithXorK {

    // Brute force (TC -> n2, SC -> 1)
    static void subarrays(int arr[], int k) {
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            int xor = 0;
            for(int j = i; j < n; j++) {
                xor = xor ^ arr[j];
                if(xor == k) count++;
            }
        }

        System.out.println(count);
    }

    // Optimal Approach (TC -> nlogn, SC -> n)
    static void OptSubarrays(int arr[], int k) {
        int n = arr.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        int count = 0;
        int xor = 0;
        for(int i = 0; i < n; i++) {
            xor = xor ^ arr[i];

            int rem = xor ^ k;

            if(hashMap.containsKey(rem)) {
                count += hashMap.get(rem);
            } 
            
            if(hashMap.containsKey(xor)) {
                hashMap.put(xor, hashMap.get(xor) + 1);
            } else {
                hashMap.put(xor, 1);
            }
        }

        System.out.println(count);
    }
    public static void main(String[] args) {
        int arr[] = {4, 2, 2, 6, 4};
        // subarrays(arr, 6);/
        OptSubarrays(arr, 6);
    }
}
