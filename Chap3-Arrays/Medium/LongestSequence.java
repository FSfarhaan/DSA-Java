import java.util.Arrays;
import java.util.HashSet;

public class LongestSequence {

    // Brute Force (TC -> n2, SC -> 1)
    static void longestSequence(int arr[]) {
        int n = arr.length;
        int max = 1;
        for(int i = 0; i < n; i++) {
            int count = 1;
            int curr = arr[i];
            // i = 2. curr = 1;
            // curr = 2; j = 0; count = 2;
            // curr = 3; j = 0; count = 3;
            // curr = 4; j = 0; count = 4;
            for(int j = 0; j < n; j++) {
                if(curr + 1 == arr[j]) {
                    curr = arr[j];
                    j = 0;
                    count++;
                }
            }

            max = Math.max(max, count);
        }

        System.out.println("Longest: " + max);
        
    }

    // Better Approach (My code)
    static void BetLongest(int arr[]) {
        Arrays.sort(arr);
        int n = arr.length;

        int max = 1;
        // { 1, 2, 3, 4, 5, 6, 100, 200 };
    

        int count = 1;
        for(int i = 0; i < n - 1; i++) {
            if(arr[i] + 1 == arr[i+1]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }

        System.out.println("Longest: " + max);
        
    }

    // Better (Striver) (TC -> nlogn + n; SC -> 1)
    static void BetLongest2(int arr[]) {
        Arrays.sort(arr);
        int n = arr.length;

        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;
        int longest = 1;

        for(int i = 0; i < n; i++) {
            if(arr[i] - 1 == lastSmaller) {
                count++;
                lastSmaller = arr[i];
            } else if (arr[i] != lastSmaller) {
                lastSmaller = arr[i];
                count = 1;
            }

            longest = Math.max(longest, count);
        }

        System.out.println("Longest: " + longest);
    }   

    // Optimal Approach (TC -> nlogn + 2n, SC -> n)
    static void OptLongest(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        int n = arr.length;
        if(n == 0) return;
        int max = 1;

        for(int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        for(int it: set) {
            if(!set.contains(it - 1)) {
                int count = 1;
                int x = it;
                while(set.contains(x + 1)) {
                    count++;
                    x++;
                }
                max = Math.max(max, count);
            }
        }

        System.out.println("Longest: " + max);
    }
    public static void main(String[] args) {
        int arr[] = { 0,3,7,2,5,8,4,6,0,1 };
        // longestSequence(arr);
        BetLongest(arr);
        // OptLongest(arr);
    }
}
