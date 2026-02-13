import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    static void getSubsets(int index, int arr[], List<Integer> ds, List<List<Integer>> ans) {
        if(index == arr.length) {
            if(ds.size() == 0) ans.add(new ArrayList<>());

            else {
                if(!ans.contains(ds)) ans.add(new ArrayList<>(ds));
            }
            return;
        }

        ds.add(arr[index]);
        getSubsets(index+1, arr, ds, ans);

        ds.remove(ds.size() - 1);
        getSubsets(index+1, arr, ds, ans);
    }

    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        getSubsets(0, nums, new ArrayList<>(), ans);
        
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 4,4,4,1,4 };
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
