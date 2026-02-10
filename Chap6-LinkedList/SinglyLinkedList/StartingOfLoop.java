import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class StartingOfLoop {

    // Brute force (TC -> n, SC -> n);
    static Node findStart(Node head) {
        ArrayList<Node> arr = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            if(arr.contains(temp)) return temp;
            arr.add(temp);
            temp = temp.next;
        }
        return null;
    }

    // Optimal (TC -> n, SC -> 1);
    static Node OptFindStart(Node head) {
        if(head == null || head.next == null) return null;
        
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next; slow = slow.next;
                }
                return fast;
            }
        }

        return null;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);        
        head.next.next.next.next.next = head.next.next;

        Node ans = OptFindStart(head);
        if(ans != null) System.out.println("The starting point is: "+ ans.data);
    }
}
