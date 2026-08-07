import java.util.HashMap;
import java.util.PriorityQueue;

class TopKFrequents {
    
    static int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 1) return nums;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (var entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] ans = new int[k];

        for(int j = 0; j < k; j++) {
            ans[j] = pq.poll()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1,1,1,2,2,3 };
        int k = 2;

        int[] ans = topKFrequent(arr, k);

        for(int o: ans) {
            System.out.print(o + " ");
        }
    }
}