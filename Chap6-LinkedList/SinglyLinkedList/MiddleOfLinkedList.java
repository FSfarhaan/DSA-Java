public class MiddleOfLinkedList {
    //Brute force (TC -> 2n, SC -> 1);
    static Node middleNode(Node head) {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        int mid = count / 2 + 1;

        temp = head;
        while (temp != null) {
            mid--;
            if(mid == 0) break;
            temp = temp.next;
        }
        return temp;
    }

    // Optimal (Tortoise hare metod) (TC -> n/2, SC -> 1);
    static Node OptMiddleNode(Node head) {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        int arr[]  = { 1,2,3,4,5 };
        Solution sol = new Solution();
        Node head = sol.convertArrToLL(arr);
        Node middle = OptMiddleNode(head);
        System.out.println(middle.data);
        // sol.print(head);

    }
}
