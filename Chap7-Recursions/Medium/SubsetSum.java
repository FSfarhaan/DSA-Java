import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    static void solveSubsetSum(int arr[], int index, int sum, List<Integer> ans) {
        if(index == arr.length) {
            ans.add(sum);
            return;
        }

        solveSubsetSum(arr, index+1, sum+arr[index], ans);

        solveSubsetSum(arr, index+1, sum, ans);
    }

    // TC -> 2^n log2^n, SC -> 2^n + n
    static List<Integer> getSubsetSum(int arr[]) {
        List<Integer> ans = new ArrayList<>();
        solveSubsetSum(arr, 0, 0, ans);
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {3,1,2};
        List<Integer> ans = getSubsetSum(arr);
        ans.sort(null);

        for(int it: ans) {
            System.out.print(it + " ");
        }
    }
}
