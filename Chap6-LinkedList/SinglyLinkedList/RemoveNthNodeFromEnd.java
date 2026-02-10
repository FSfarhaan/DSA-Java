public class RemoveNthNodeFromEnd {

    static Node deleteHead(Node head) {
        if(head == null) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        return head;
    }

    static Node deleteTail(Node head) {
        if(head == null || head.next == null) return null;

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;   
    }

    // Brute force
    static Node removeNth(Node head, int n) {
        if(n == 1) return deleteTail(head);
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if(length == n) return deleteHead(head);
        int node = length - n - 1;

        temp = head;

        while (node != 0 && temp != null) {
            node--;
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    // Optimal approach
    static Node OptRemoveNth(Node head, int n) {
        if(n == 1) return deleteTail(head);
        Node dummy = new Node(-1, head);

        Node fast = dummy;
        Node slow = dummy;

        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2 };
        Solution sol = new Solution();
        Node head = sol.convertArrToLL(arr);
        // head = removeNth(head, 6);
        head = OptRemoveNth(head, 2);
        sol.print(head);
    }
}
