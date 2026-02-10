public class RotateLLbyK {

    // Apply tortoise hare method instead of 
    static Node getLastNode(Node head, int k) {
        Node temp = head;
        while (temp != null) {
            k--;
            if(k == 0) return temp;
            temp = temp.next;
        }
        return null;
    }
    static Node rotateLL(Node head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        int n = 1;
        
        Node tail = head;
        while (tail.next != null) {
            n++;
            tail = tail.next;
        }

        if(n == k) return head;
        k = k % n;

        tail.next = head;

        Node lastNode = getLastNode(head, n-k);
        head = lastNode.next;
        lastNode.next = null;

        return head;
    }
    public static void main(String[] args) {
        int arr[]  = { 2, 1, 3, 5, 6, 4, 7 };
        Solution sol = new Solution();
        Node head = sol.convertArrToLL(arr);
        // head = reverseLLIt(head);
        head = rotateLL(head, 0);
        sol.print(head);
    }
}
