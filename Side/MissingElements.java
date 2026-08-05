import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingElements {

    static List<Integer> findMissingElements(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;    

        
        for(int i: nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        } 
        
        int[] freq = new int[max+1];

        for(int i: nums) {
            freq[i]++;
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = min; i < max; i++) {
            if(freq[i] == 0) ans.add(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 1 };

        List<Integer> ans = findMissingElements(nums);

        for(int k: ans) {
            System.out.print(k + " ");
        }
    }
}
