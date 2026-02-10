import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPairsWithSum {

    // Brute force (TC -> n2, SC -> 1);
    static List<List<Integer>> getPairs(Node head, int sum) {
        // [ [1, 4], [0, 5], [2, 3]]
        List<List<Integer>> ans = new ArrayList<>();
        
        Node temp1 = head;
        while (temp1 != null) {
            int val1 = temp1.data;
            Node temp2 = temp1.next;
            while (temp2 != null) {
                int totalSum = val1 + temp2.data;
                if(totalSum == sum) {
                    List<Integer> newPair = Arrays.asList(val1, temp2.data);
                    ans.add(newPair);
                }
                temp2 = temp2.next;
            }

            temp1 = temp1.next;
        }

        return ans;
    }

    static Node getTail(Node head) {
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        return temp;
    }

    // Optimal Appraoch (TC -> n, SC -> 1);
    static List<List<Integer>> OptGetPairs(Node head, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        Node temp1 = head, temp2 = getTail(head);
        // System.out.println(temp2.data);

        while (temp1 != null && temp1.data < temp2.data) {
            int totalSum = temp1.data + temp2.data;
            if(totalSum == sum) {
                List<Integer> newPair= Arrays.asList(temp1.data, temp2.data);
                ans.add(newPair);
                temp1 = temp1.next;
                temp2 = temp2.back;
            }
            else if(totalSum > sum) temp2 = temp2.back;
            else temp1 = temp1.next;
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 5, 12};
    
        Solution sol = new Solution();
        Node head = sol.convertArrToDLL(arr);

        // List<List<Integer>> ans = getPairs(head, 5);
        List<List<Integer>> ans = OptGetPairs(head, 5);
        for(List<Integer> li: ans) {
            for(int k : li) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        // sol.print(head);
    }
}
