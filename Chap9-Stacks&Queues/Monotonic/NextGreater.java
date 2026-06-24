import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class NextGreater {
    
    // Brute force (TC -> n*m, SC -> n)
    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) { 
            int j;
            for(j = 0; j < nums2.length; j++) {
                if(nums2[j] == nums1[i]) break;
            }

            while (j < nums2.length) {
                if(nums1[i] < nums2[j]) {
                    ans[i] = nums2[j];
                    break;
                }
                j++;
            }
            ans[i] = ans[i] == 0 ? -1 : ans[i];
        }
        return ans;
    }

    // Optimal approach (TC -> nums2.length)
    static int[] OptNextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < nums2[i]) {
                st.pop();
            }
            if(st.isEmpty()) map.put(nums2[i], -1);
            else map.put(nums2[i], st.peek());
            
            st.push(nums2[i]);
        }

        for(int j = 0; j < nums1.length; j++) {
            ans[j] = map.get(nums1[j]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};

        int[] ans = OptNextGreaterElement(nums1, nums2);

        for(int k: ans) {
            System.out.print(k + " ");
        }

        // Stack<Integer> ans = new Stack<>();
        // System.out.println(ans.peek());
    }
}
