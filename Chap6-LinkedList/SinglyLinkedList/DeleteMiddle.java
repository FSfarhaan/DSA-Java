public class DeleteMiddle {
    static Node middleNode(Node head) {
        if(head == null  || head.next == null) return head;
        Node fast = head.next, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // Optimal direct
    static Node deleteMiddle(Node head) {        
        if(head == null || head.next == null) return null;
        Node middleNode = middleNode(head);
        middleNode.next = middleNode.next.next;
        return head;
    }
    public static void main(String[] args) {
        int arr[]  = { 1,2,3 };
        Solution sol = new Solution();
        Node head = sol.convertArrToLL(arr);
        head = deleteMiddle(head);
        // System.out.println(middNode.data);
        sol.print(head);
    }
}
