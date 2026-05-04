import java.util.ArrayList;
import java.util.List;

public class Subset {

    // Brute force (TC -> k*2^n, SC -> n*2^n);
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int subsets = 1 << n;

        for(int i = 0; i < subsets; i++) {
            String bin = Integer.toBinaryString(i);
            List<Integer> res = new ArrayList<>();
            for(int j = 0; j < bin.length(); j++) {
                System.out.println("Is char ki baat hori " + bin.charAt(j) + " for bin: " + bin);
                if(bin.charAt(j) == '1') res.add(nums[bin.length() - j - 1]);
            }
            ans.add(res);
        }

        return ans;

    }

    // Optimal approach (TC -> n*2^n, SC -> n*2^n);
    static List<List<Integer>> OptSubsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int subsets = 1 << n;

        for(int num = 0; num < subsets; num++) {

            List<Integer> res = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                if((num & (1 << i)) != 0) res.add(nums[i]);
            }
            ans.add(res);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3};
        List<List<Integer>> ans = OptSubsets(nums);

        for(List<Integer> li: ans) {
            for(int k: li) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
