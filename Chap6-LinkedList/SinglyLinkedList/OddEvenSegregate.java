import java.util.ArrayList;

class Node {
    int data;
    Node next;
    public Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    public Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

class Solution {
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

public class OddEvenSegregate {

    // Brute force (TC -> n + n, SC -> n);
    static Node oddEvenList(Node head) {
        if(head == null || head.next == null) return head;

        ArrayList<Integer> arrayList = new ArrayList<>();
        Node temp = head;

        while (temp != null && temp.next != null) {
            arrayList.add(temp.data);

            if (temp.next == null) break;
            temp = temp.next.next;
        }

        if(temp != null) arrayList.add(temp.data);

        temp = head.next;

        while (temp != null && temp.next != null) {
            arrayList.add(temp.data);
            temp = temp.next.next;
        }
        if(temp != null) arrayList.add(temp.data);

        temp = head;
        int i = 0;

        while (temp != null) {
            temp.data = arrayList.get(i++);
            temp = temp.next;
        }        

        return head;
    }

    // Optimal Approach
    static Node OptOddEvenList (Node head) {
        if(head == null || head.next == null) return head;

        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
    public static void main(String[] args) {
        int arr[] = { 2, 1, 3, 5, 6, 4, 7 };
        Solution sol = new Solution();

        Node head = sol.convertArrToLL(arr);
        // head = oddEvenList(head);
        head = OptOddEvenList(head);
        sol.print(head);
    }
}
