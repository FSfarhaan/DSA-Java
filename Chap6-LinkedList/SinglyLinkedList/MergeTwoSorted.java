import java.util.ArrayList;

public class MergeTwoSorted {
    // brute force (TC -> n1+n2 + (n1+n2)log(n1+n2) + n1+n2, SC -> n1+n2);
    static Node merge(Node l1, Node l2) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (l1 != null) {
            arr.add(l1.data);
            l1 = l1.next;
        }

        while (l2 != null) {
            arr.add(l2.data);
            l2 = l2.next;
        }

        arr.sort(null);
        int i = 0;
        Node head = new Node(arr.get(0));
        Node temp = head;

        for(i = 1; i < arr.size(); i++) {
            Node newNode = new Node(arr.get(i));
            temp.next = newNode;
            temp = temp.next;
        }

        return head;
    }
    
    // Optimal approach
    static Node OptMerge(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (l1 != null && l2 != null) {
            if(l1.data <= l2.data) {
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            }
            else {
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
        }

        if(l1 != null) temp.next = l1;
        else temp.next = l2;

        return dummy.next;

    }
    public static void main(String[] args) {
        int num1[] = { 1, 2, 4, 3};
        int num2[] = { 5, 6, 4, 7, 10};
        // Solution sol = new Solution();
        // Node l1 = sol.convertArrToLL(num1);
        // Node l2 = sol.convertArrToLL(num2);

        // Node head = OptMerge(num1, num2);
        // sol.print(head);
    }
}
