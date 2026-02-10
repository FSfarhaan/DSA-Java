import java.util.*;

public class MajorityElement {

    // Brute force (TC -> n2, SC -> 1)
    static void findMajority(int arr[]) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(arr[i] == arr[j]) count++;

                if(count > (n / 2)) {
                    
                    System.out.println(count + " Majority Element: " + arr[j]);
                    return;
                }
            }
        }
    }

    // Better Approach (TC -> nlogn + n, SC -> n)
    static void betMajority (int arr[]) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> num: hashMap.entrySet()) {
            if(num.getValue() > n / 2 ) System.out.println("Majority element: " + num.getKey());
        }
    }

    // Optimal Approach (Moore's Algorithm) (TC -> 2n, SC -> 1)
    static void optMajority (int arr[]) {
        int count = 0, el = 0, n = arr.length;

        for(int i = 0; i < n; i++) {
            if(count == 0) {
                count = 1;
                el = arr[i];
            }
            else if(arr[i] == el) count++;
            else count--;
        }

        int check = 0;
        for(int j = 0; j < n; j++) {
            if(arr[j] == el) check++;
        }

        if(check > n / 2) System.out.println("Majority element: " + el);
    }

    public static void main(String[] args) {
        int arr[] = {2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 4, 4};
        optMajority(arr);
    }
}
