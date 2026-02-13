import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    // Optimized solution using backtracking with duplicate handling
    static void getSubsets(int index, int[] arr, List<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds));
        
        for(int i = index; i < arr.length; i++) {
            if(i > index && arr[i] == arr[i-1]) continue;
            ds.add(arr[i]);
            getSubsets(i + 1, arr, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }

    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        getSubsets(0, nums, new ArrayList<>(), ans);
        
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1,2,2 };
        List<List<Integer>> ans = subsets(nums);

        System.out.println(ans.size());
        for(List<Integer> list: ans) {
            for(int it: list) {
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }
}
