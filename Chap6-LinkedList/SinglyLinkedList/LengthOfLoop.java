import java.util.HashMap;

public class LengthOfLoop {

    // Brute force (TC -> n, SC -> n);
    static int findLength(Node head) {
        HashMap<Node, Integer> map = new HashMap<>();
        int timer = 1;
        Node temp = head;

        while (temp != null) {
            if(map.containsKey(temp)) {
                int val = map.get(temp);
                return timer - val;
            }
            System.out.println(timer);
            map.put(temp, timer++);
            
            temp = temp.next;
        }

        return 0;
    }

    // Optimal (TC -> 2n, SC -> 1)
    static int OptGetLength(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next; slow = slow.next;

            if(fast == slow) {
                int count = 1;
                fast = fast.next;
                while (fast != slow) {
                    fast = fast.next;
                    count++;
                }
                return count;
            };
        }
        return 0;

    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);        
        head.next.next.next.next.next = head.next.next;

        // System.out.println("The length of the loop is: " + findLength(head));
        System.out.println("The length of the loop is: " + OptGetLength(head));
    }
}
