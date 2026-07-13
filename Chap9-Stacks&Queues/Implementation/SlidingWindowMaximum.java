import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    // Brute force (TC -> n*k, SC -> 1);
    static int[] maxSlidingWindow(int[] arr, int k) {
        if(k == 1) return arr;

        int n = arr.length;
        int[] ans = new int[n - k + 1];
        int index = 0;

        for(int i = 0; i <= n - k; i++) {
            int max = arr[i];
            for(int j = i; j < i + k; j++) {
                max = Math.max(max, arr[j]);
            }
            ans[index++] = max;
        }
        return ans;
    }

    // Optimal approach
    static int[] OptMaxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> qDeque = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            while (!qDeque.isEmpty() && arr[qDeque.peekLast()] < arr[i]) {
                qDeque.removeLast();
            }
            qDeque.addLast(i);

            if(i >= k - 1) ans.add(arr[qDeque.peekFirst()]);


            if(qDeque.peekFirst() <= i - k + 1) {
                qDeque.removeFirst();
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = { 4,0,-1,3,5,3,6,8 };
        int k = 3;
        
        int[] ans = OptMaxSlidingWindow(arr, k);

        for(int p: ans) {
            System.out.print(p + " ");
        }
    }
}
