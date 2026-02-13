import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    static void generateSSWithSumk(int arr[], int index, List<Integer> ds, List<List<Integer>> ans, int target) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = index; i < arr.length; i++) {
            if(i > index && arr[i] == arr[i-1]) continue;

            if(arr[i] > target) break;

            ds.add(arr[i]);
            generateSSWithSumk(arr, i+1, ds, ans, target - arr[i]);
            ds.remove(ds.size() - 1);
        }
    }


    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        generateSSWithSumk(candidates, 0, new ArrayList<>(), ans, target);
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2,5,2,1,2 };

        // System.out.println(arr.length);
        int target = 5;
        List<List<Integer>> ans = combinationSum2(arr, target);

        for(List<Integer> list: ans) {
            for(int it: list) {
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }
}
