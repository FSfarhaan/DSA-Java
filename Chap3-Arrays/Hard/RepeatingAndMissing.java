import java.util.HashMap;
import java.util.Map;

public class RepeatingAndMissing {

    // Brute force (TC -> n2, SC -> 1);
    static void findNumbers(int arr[]) {
        int n = arr.length;
        int repeating = -1, missing = -1;

        for(int i = 1; i <= n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(arr[j]  == i) count++;
            }
            if(count == 0) missing = i;
            else if(count == 2) repeating = i;

            if(repeating != -1 && missing != -1) break;
        }

        System.out.println("Repeating is: " + repeating + " Missing is: " + missing);
    }

    // Better Approach 
    static void betFindNumbers(int arr[]) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int val = hashMap.getOrDefault(arr[i], 0);
            hashMap.put(arr[i], val + 1);
        }

        for(Map.Entry<Integer, Integer> it: hashMap.entrySet()) {
            System.out.println(it.getKey() + " " + it.getValue());
        }

        int missing = -1, repeating = -1;
        for (int i = 1; i <= n; i++) {
            int freq = hashMap.getOrDefault(i, 0);
            if (freq == 0) {
                missing = i;
            } else if (freq == 2) {
                repeating = i;
            }
        }

        System.out.println("Repeating is: " + repeating + " Missing is: " + missing);
    }

    // Optimal Approach
    static void OptFindNumbers(int arr[]) {
        int n = arr.length;

        // Getting the sum of all the numbers from 1 to n
        int Sn = n * (n + 1) / 2 ; 
        // Getting Squares of all the numbers from 1 to n;
        int S2n = n * (n + 1) * (2 * n + 1) / 6;
        int S = 0;
        int S2 = 0;

        // Getting sum of present numbers
        for(int i = 0; i < n; i++) {
            S += arr[i];
            S2 += arr[i] * arr[i];
        }

        // X - Y
        int val1 = Sn - S;

        // X2 - Y2
        int val2 = S2n - S2;

        // To get X + Y = X2 - Y2 / X - Y
        val2 = val2 / val1;

        // 2x = some number;
        int x = (val1 + val2) / 2;
        int y = x - val1;

        System.out.println("Repeating is: " + x + " Missing is: " + y);
    
    }
    public static void main(String[] args) {
        int arr[] = {3,1,2,5,4,6,7,5};
        // findNumbers(arr);
        // betFindNumbers(arr);
        OptFindNumbers(arr);
    }
}
