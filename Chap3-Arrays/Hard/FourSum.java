import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {

    // Brute force (TC > n4, SC -> 2 * unique quadruplets)
    static void fourSum(int arr[], int target) {
        // simply loop over
        int n = arr.length;
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    for(int l = k + 1; l < n; l++) {
                        if(arr[i] + arr[j] + arr[k] + arr[l] == target) {
                            List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            list.sort(null);
                            set.add(list);
                        }
                    }
                }
            }
        }

        for(List<Integer> list : set) {
            for(int k: list) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    // Better approach (TC -> n3 logm, SC -> 2 * unique quadruplets + n)
    // Intution: Remove the lth loop and make it to n3
    static void BetFourSum(int arr[], int target) {
        int n = arr.length;
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                HashSet<Integer> unique = new HashSet<>();
                for(int k = j + 1; k < n; k++) {
                    int fourth = target - (arr[i] + arr[j] + arr[k]);
                    if(unique.contains(fourth)) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], fourth);
                        temp.sort(null);
                        set.add(temp);
                    }
                    unique.add(arr[k]);

                }
            }
        }

        for(List<Integer> list : set) {
            for(int k: list) {
                System.out.print(k + " ");
            }
            System.out.println();
        }        
    }

    // Optimal Approach
    // Fix i, j. Move k, l Same with three sum
    static void OptFourSum(int arr[], int target) {

        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(i > 0 && arr[i] == arr[i - 1]) continue;
            for(int j = i + 1; j < n; j++) {
                if(j > i + 1 && arr[j] == arr[j - 1]) continue;
                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = arr[i]+ arr[j];
                    sum += arr[k] + arr[l];
                    if(sum > target) l--;
                    else if(sum < target) k++;
                    else {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                        ans.add(temp);
                        k++; l--;
                        while(k < l && arr[k] == arr[k - 1]) k++;
                        while(k < l && l < n -1 && arr[l] == arr[l + 1]) l--;
                    }
                }
            }
        }

        for(List<Integer> k: ans) {
            for(int l : k) {
                System.out.print(l + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = {4,3,3,4,4,2,1,2,1,1};
        int target = 9;
        // fourSum(arr, target);
        BetFourSum(arr, target);
    }
}
