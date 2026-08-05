import java.util.PriorityQueue;

class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int ka, int[] nums) {
        this.k = ka;
        pq = new PriorityQueue<>();

        for(int i: nums) {
            pq.offer(i);
            if(pq.size() > k) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k) pq.poll();
        return pq.peek();
    }
}

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 8, 2 };
        KthLargest kth = new KthLargest(3, nums);
        System.out.println(kth.add(3)); // return 4
        System.out.println("Ye kyu nahi aa raha ");
        System.out.println(kth.add(5)); // return 5
        System.out.println(kth.add(10)); // return 5
        System.out.println(kth.add(9)); // return 8
        System.out.println(kth.add(4)); // return 8
    }
}
