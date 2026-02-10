import java.util.HashSet;

public class FindIntersection {

    // Brute force (TC -> n + m, SC -> n)
    static Node findPoint(Node ll1, Node ll2) {
        Node temp = ll1;
        HashSet<Node> set = new HashSet<>();
        
        while (temp != null) {   
            set.add(temp);
            temp = temp.next;
        }

        temp = ll2;
        while (temp != null) {
            if(set.contains(temp)) break;
            temp = temp.next;
        }
        return temp;
    }

    // Better approach (TC -> n + 2m, SC -> 1);
    static Node BetFindPoint(Node ll1, Node ll2) {
        int n = 0, m = 0;
        Node temp = ll1;

        while (temp != null) {
            n++;
            temp = temp.next;
        }
        temp = ll2;
        while (temp != null) {
            m++;
            temp = temp.next;
        }

        int d = n - m;
        if(d > 0) {
            while (d-- != 0) {
                ll1 = ll1.next;
            }
        } else {
            while (d++ != 0) {
                ll2 = ll2.next;
            }
        }
        while (ll1 != null) {
            if(ll1 == ll2) return ll1;
            ll1 = ll1.next;
            ll2 = ll2.next;
        }
        return null;
    }

    // Optimal approach (TC -> n + m, SC -> 1);
    static Node OptFindPoint(Node ll1, Node ll2) {
        Node temp1 = ll1, temp2 = ll2;
        while (temp1 != temp2) {
            temp1 = temp1 == null ? ll2 : temp1.next;
            temp2 = temp2 == null ? ll1 : temp2.next;
        }
        return temp1;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(4);        
        
        Node head1 = new Node(3);
        head1.next = head.next.next.next;
        // head1.next = new Node(5);
        head1.next.next = new Node(4);

        // Solution sol = new Solution();
        // sol.print(head);
        // System.out.println();
        // sol.print(head1);
        Node intersection = OptFindPoint(head, head1);
        if(intersection != null) System.out.println("The intersection point is " + intersection.data);
        else System.out.println("No intersection point");
    }
}
