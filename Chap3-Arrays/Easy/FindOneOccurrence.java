import java.util.HashMap;
import java.util.Map;

public class FindOneOccurrence {

    // Brute Force (TC -> n2, SC -> 1)
    static void findOccurence(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            int occ = 0;
            for(int j = 0; j < arr.length; j++) {
                if(arr[i] == arr[j]) occ++;
            }

            if(occ == 1) {
                System.out.println(arr[i]);
                break;
            } 
        }
    }

    // Better approac (TC -> 3n, SC -> n)
    static void BetFindOccurence (int arr[]) {
        int max = 1;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int hash[] = new int[max + 1];
        for(int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for(int i = 1; i < arr.length; i++) {
            if(hash[arr[i]] ==1 ) {
                System.out.println(arr[i]);
                break;
            }
        }
    }

    // Better Approach 2 (TC -> n log m + m, SC -> m)
    static void BetFindOccurence2 (int arr[]) {
        HashMap <Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            int occurence = hashMap.getOrDefault(arr[i], 0);
            hashMap.put(arr[i], occurence + 1);
        }

        for(Map.Entry<Integer, Integer> it: hashMap.entrySet()) {
            if(it.getValue() == 1) {
                System.out.println(it.getKey());
                break;
            }
        }
    }

    // Optimal Approach (TC -> n, SC -> 1)
    static void OptFindOccurrence (int arr[]) {
        int xor = 0;
        
        for(int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        System.out.println(xor);
    }
    public static void main(String[] args) {
        int arr[] = {  1, 2, 4, 1, 2};
        OptFindOccurrence(arr);
    }
}
