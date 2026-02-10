public class AddOneNumber {

    static Node reverseLL(Node head) {
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

    // Not brute force but less optimal (TC -> 3n, SC -> 1);
    static Node addOne(Node head) {    
        head = reverseLL(head);
        Node temp = head;
        int carry = 1;

        while (temp != null) {
            temp.data = temp.data + carry;
            if(temp.data < 10) carry = 0;
            else {
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }
        head = reverseLL(head);

        if(carry == 1) {
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode;
        }

        return head;
    }

    static int addOneUtil(Node head) {
        if(head == null) return 1;

        int carry = addOneUtil(head.next);
        int sum = head.data + carry;
        head.data = head.data % 10;

        // Return new carry
        return sum / 10;
    }

    // Optimal approach (TC -> n, SC -> n (Stack space));
    static Node OptAddOne(Node head) {
        int carry = addOneUtil(head);

        if(carry == 1) {
            Node newNode = new Node(carry, head);
            head = newNode;
        }

        return head;
    }

    public static void main(String[] args) {
        int num1[] = { 9, 9, 9};
        Solution sol = new Solution();
        Node head = sol.convertArrToLL(num1);

        head = addOne(head);
        sol.print(head);
    }
}
