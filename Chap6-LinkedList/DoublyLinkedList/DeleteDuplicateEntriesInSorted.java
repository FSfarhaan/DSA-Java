public class DeleteDuplicateEntriesInSorted {

    static Node deleteDuplicated(Node head) {
        if(head == null || head.next == null) return head;
        Node temp = head;

        while (temp != null && temp.next != null) {
            Node nextNode = temp.next;
            System.out.println(temp.data + " " + nextNode.data);
            while (nextNode != null && temp.data == nextNode.data) {
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if(nextNode != null) nextNode.back = temp;

            temp = nextNode;
        }

        return head;
    }
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 5};
    
        Solution sol = new Solution();
        Node head = sol.convertArrToDLL(arr);
        head = deleteDuplicated(head);
        sol.print(head);
    }
}
