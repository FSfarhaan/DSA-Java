import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    // Brute force (TC -> n3, SC -> 2 * no of unique triplets)
    static void threeSum(int arr[]) {
        int n= arr.length;
        HashSet<List<Integer>> list = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j ++) {
                for(int k = j + 1; k < n; k++) {
                    if(arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null);
                        list.add(temp);
                    }
                }
            }
        }

        for(List<Integer> k: list) {
            for(int l : k) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }

    // Better approach (TC -> n2, SC -> n + 2 * unique triplets)
    static void BetThreeSum(int arr[]) {
        // Intution is to bring the time from n3 to n2, by eliminating the kth loop.
        // arr[k] = - (arr[i] + arr[j]);

        int n = arr.length;
        // Elements, Occurrences.
        // We will get k by storing i and j in hashmap and searching whether k = - (i + j)  exists or not
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for(int j = i + 1; j < n; j++) {
                int target = - (arr[i] + arr[j]);
                if(hashSet.contains(target)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], target);
                    temp.sort(null);
                    set.add(temp);
                }
                hashSet.add(arr[j]);
            }
        }

        for(List<Integer> list : set) {
            for(int k : list) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    // Optimal approach (TC -> n2 + nlogn, SC -> 2* unique triplets)
    static void OptThreeSum(int arr[]) {
        // use i, j, k. Fix i. Move j, k. 
        // Sort the arr
        // i + j + k == 0? Consider. Greater ? k--. Smaller ? j++

        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        
        for(int i = 0; i < n; i++) {
            if(i > 0 && arr[i] == arr[i - 1]) continue;
            int j = i + 1, k = n - 1;

            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == 0 ) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    k--; j++;
                    while(j < k && arr[j] == arr[j - 1]) j++;
                    while(j < k && arr[k] == arr[k+1]) k--;

                } 
                else if (sum > 0) k--;
                else j++;

            }
        }

        for(List<Integer> list : ans) {
            for(int k: list) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 0, 0};
        // threeSum(arr);
        // BetThreeSum(arr);
        OptThreeSum(arr);
    }
}
