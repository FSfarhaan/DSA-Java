import java.util.ArrayList;
import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node (int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
public class CloneLLWithRandomAndNext {

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    // Brute force (TC -> 4nlogn, SC -> n);
    static Node createClone(Node head) {
        HashMap<Node, Node> arr = new HashMap<>();
        Node temp = head;
        Node newHead = new Node(-1);
        

        while (temp != null) {
            Node dummyNode = new Node(temp.val);
            arr.put(temp, dummyNode);
            temp = temp.next;
        }

        temp = head;
        Node res = newHead;

        while (temp != null) {
            Node dummy = arr.get(temp);
            dummy.next = arr.get(temp.next);
            dummy.random = arr.get(temp.random);
            res.next = dummy;
            res = res.next;
            temp = temp.next;
        }

        return newHead.next;
    }
    
    static Node OptiCreateClone(Node head) {
        Node temp = head;
        Node dummy = new Node(-1);
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        temp = head;
        Node res = temp.next;
        dummy.next = res;

        while (temp != null) {
            res.random = temp.random.next;
            temp = temp.next.next;
            if(res.next != null) res = res.next.next;
        }

        temp = head;
        res = temp.next;
        while (temp != null) {
            temp.next = res.next;
            if(res.next != null && temp.next != null) res.next = temp.next.next;
            temp = temp.next;
            res = res.next;
        }

        return dummy.next;

    }
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(14);
        head.next.next = new Node(21);
        head.next.next.next = new Node(28);

        // Assigning random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        Node newNode = OptiCreateClone(head);
        print(newNode);

    }
}
