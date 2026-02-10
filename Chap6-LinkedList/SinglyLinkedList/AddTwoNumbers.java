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

    Node addTwoNumbers (Node l1, Node l2) {
        int carry = 0;
        Node tempNode = new Node(-1);
        Node head = tempNode;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;

            Node newNode = new Node(sum % 10);
            tempNode.next = newNode;
            tempNode = newNode;
        }

        if(carry == 1) {
            Node lastNode = new Node(carry);
            tempNode.next = lastNode;
        }

        return head.next;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        int num1[] = { 2, 4, 3};
        int num2[] = { 5, 6, 4};
        Solution sol = new Solution();
        Node l1 = sol.convertArrToLL(num1);
        Node l2 = sol.convertArrToLL(num2);

        Node head = sol.addTwoNumbers(l1, l2);
        sol.print(head);
    }
}
