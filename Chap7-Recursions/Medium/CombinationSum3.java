import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    static void getCombinations(int arr[], int index, int k, int sum, List<Integer> ds, List<List<Integer>> ans) {
        if(index == arr.length) {
            if(sum == 0 && ds.size() == k) ans.add(new ArrayList<>(ds));
            return;
        }

        if(sum - arr[index] >= 0) {
            ds.add(arr[index]);
            getCombinations(arr, index+1, k, sum - arr[index], ds, ans);
            ds.remove(ds.size() - 1);
        }

        getCombinations(arr, index+1, k, sum, ds, ans);
    }
    
    static List<List<Integer>> combinationSum3(int k, int n) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<List<Integer>> ans = new ArrayList<>();
        getCombinations(arr, 0, k, n, new ArrayList<>(), ans);
        return ans;
    }
    public static void main(String[] args) {
        
        int k = 2, n = 9;
        List<List<Integer>> ans = combinationSum3(k, n);
        // System.out.println(ans.size());
        for(List<Integer> list: ans) {
            for(int it: list) {
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }
}
