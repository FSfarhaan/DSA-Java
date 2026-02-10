import java.util.ArrayList;

public class SortLL {
    static Node getMiddle(Node head) {
        if(head.next == null) return head;
        Node fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next; slow = slow.next;
        }
        return slow;
    }

    // Brute force (TC -> 2n, SC -> n);
    static Node sort(Node head) {
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;

        while (temp != null) {
            arr.add(temp.data);
            temp = temp.next;
        }

        arr.sort(null);

        temp = head;
        int i = 0;
        while (temp != null) {
            temp.data = arr.get(i++);
            temp = temp.next;
        }
        return head;
    }

    // Optimal approach
    static Node mergeLL(Node l1, Node l2) {
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

    // Optimal approach (TC -> n/2 + logn + n, SC -> n)
    static Node OptSort(Node head) {
        if(head == null || head.next == null) return head;
        
        Node middle = getMiddle(head);

        Node right = OptSort(middle.next);
        middle.next = null;
        Node left = OptSort(head);

        Node newHead = mergeLL(left, right);

        return newHead;
    }
    public static void main(String[] args) {
        int arr[] = { 5, 10, 3, 8, 6, 4, 7, 1 };
        Solution sol = new Solution();

        Node head = sol.convertArrToLL(arr);
        head = OptSort(head);
        sol.print(head);
        // sol.print(head);
    }
}
