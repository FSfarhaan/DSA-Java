
public class Solution {
    void print(Node head) {
        
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // 1. Convert arr to LinkedList
    Node convertArrToLL (int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = temp.next;
        }

        return head;
    }

}
