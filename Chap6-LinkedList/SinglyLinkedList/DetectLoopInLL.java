import java.util.HashMap;

public class DetectLoopInLL {

    // Brute force (TC -> n * 2logn, SC -> n)
    static boolean isLoopPresent(Node head) {
        HashMap<Node, Integer> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            if(map.containsKey(temp)) {
                return true;
            }
            map.put(temp, 1);
            temp = temp.next;
        }

        return false;
    }

    // Optimal approach (TC -> n, SC -> 1);
    static boolean OptIsLoopPresent(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }

        return false;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        // fifth.next = third;

        System.out.println(OptIsLoopPresent(head));

    }
}
