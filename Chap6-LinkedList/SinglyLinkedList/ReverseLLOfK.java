public class ReverseLLOfK {
    static Node findKthNode(Node head, int k) {
        Node temp = head;
        while (temp != null) {
           k--;
           if(k == 0) return temp;
           temp = temp.next; 
        }
        return null;
    }

    static Node reverseKNodes(Node head) {
        // { 2, 1, 3, 5, 6, 4, 7 };
        Node temp = head;
        Node prev = null;

        while (temp.next != null) {
            Node front = temp.next;
            temp.next = prev;

            prev = temp;
            temp = front;
        }
        temp.next = prev;
        return temp;
    }

    static Node reverseOfK(Node head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        Node temp = head, prev = null;

        while (temp != null) {
            // 1. Find the kth node
            Node kthNode = findKthNode(temp, k);
            
            
            if(kthNode == null) {
                if(temp == head) return temp;
                prev.next = temp;
                break;
            }   
            // { 2, 1, 3, 5, 6, 4, 7 };

            // 2. Store the next node, so that the kth node's next be null;
            Node nextNode = kthNode.next;
            kthNode.next = null;

            // 3. Reverse k nodes
            kthNode = reverseKNodes(temp);

            if(head == temp) head = kthNode;

            if(prev != null) prev.next = kthNode;

            prev = temp;
            temp = nextNode;
        }

        return head;

        // { 2, 1, 3, 5, 6, 4, 7 };
        // { 3, 1, 2    5, 6, 4, 7 };
        // { 3, 1, 2, 4, 6, 5,    7 };
        
    }
    public static void main(String[] args) {
        int arr[]  = { 2, 1, 3, 5, 6, 4, 7 };
        Solution sol = new Solution();
        Node head = sol.convertArrToLL(arr);
        head = reverseOfK(head, 3);
        sol.print(head);
    }
}
