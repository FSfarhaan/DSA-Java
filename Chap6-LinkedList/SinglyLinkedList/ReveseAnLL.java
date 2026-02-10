public class ReveseAnLL {
    // Optimal (Iterative) (TC -> n, SC -> 1);
    static Node reverseLLIt(Node head) {
        Node prev = null;
        Node temp = head;
        
        while (temp != null) {
            Node forw = temp.next;
            temp.next = prev;
            prev = temp;
            temp = forw;
        }

        return prev;
    }

    // Optimal (Recursive) (TC -> n, SC -> n (function stack));
    static Node reverseLLRec(Node head) {
        if(head == null || head.next == null) return head;

        Node temp = head.next;
        Node newHead = reverseLLRec(head.next);
        temp.next = head;
        head.next = null;

        return newHead;
    }
    public static void main(String[] args) {
        int arr[]  = { 2, 1, 3, 5, 6, 4, 7 };
        Solution sol = new Solution();
        Node head = sol.convertArrToLL(arr);
        // head = reverseLLIt(head);
        head = reverseLLRec(head);
        sol.print(head);

    }
}
