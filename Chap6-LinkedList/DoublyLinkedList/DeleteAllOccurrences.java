class Node {
    int data;
    Node next;
    Node back;

    public Node (int data1, Node next1, Node back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    public Node(int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}

class Solution {
    // Traverse and print all the elements
    void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // 1. Convert arr into DLL
    Node convertArrToDLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;
        
        for(int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i], null, temp);
            temp.next = newNode;
            temp = temp.next;
        }
        return head;
    }
}
class DeleteAllOccurrences {

    // TC -> n, SC -> 1
    static Node deleteKey(Node head, int key) {
        if(head == null) return null;

        Node temp = head;
        Node prev = null, forw = temp.next;

        // if(temp.data == key)

        while (forw != null) {
            if(temp.data == key) {
                if(temp != head) prev.next = forw;
                if(forw != null) {
                    forw.back = prev;
                    if(prev == null) head = forw;
                } 
            }
            temp = forw;
            forw = forw.next;
            prev = temp.back;
        }
        if(temp.data == key) prev.next = null;

        return head;
    }
    public static void main(String[] args) {
        int arr[] = {10, 4, 10, 12, 12, 5, 10};
        Solution sol = new Solution();
        Node head = sol.convertArrToDLL(arr);
        sol.print(head);
        System.out.println();
        head = deleteKey(head, 12);
        sol.print(head);
    }
}