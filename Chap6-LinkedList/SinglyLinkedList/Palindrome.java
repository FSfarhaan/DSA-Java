import java.util.Stack;

public class Palindrome {

    // Brute force (TC -> 2n, SC -> n);
    static boolean isPalindrome(Node head) {
        if(head == null || head.next == null) return true;
        Node temp = head;
        Stack<Integer> st = new Stack<>();
        
        while (temp != null) {
            st.add(temp.data);
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            if(temp.data != st.pop()) return false;
            temp = temp.next;
        }

        return true;
    }

    static Node middleNode(Node head) {
        Node fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static Node reverseLLIt(Node head) {
        if(head == null || head.next == null) return head;
        Node prev = null;
        Node temp = head;
        
        while (temp != null) {
            Node forw = temp.next;
            temp.next = prev;
            prev = temp;
            temp = forw;
        }

        return prev;
    }

    // Optimal approach
    // Intution -> Find the m1 of LL, reverse m1.next. Then manually check by iterating. Lastly connect after doing re reverse.
    static boolean OptIsPalindrome(Node head) {
        if(head == null || head.next == null) return true;
        Node middleNode = middleNode(head);
        
        // 1->2->4-> 1->2->4->X
        // 1->2->4-> 4->2->1->X
        
        // 1->2->4-> 1->2->X
        // 1->2->4-> 2->1->X
        Node newHead = reverseLLIt(middleNode.next);

        Node temp = head;
        Node temp2 = newHead;

        while (temp2 != null) {
            if(temp.data != temp2.data) {
                reverseLLIt(newHead);
                return false;
            } 
            temp = temp.next;
            temp2 = temp2.next;
        }

        reverseLLIt(newHead);
        return true;

    }

    public static void main(String[] args) {
        int arr[] = { 1,2,4,2,1 };
        Solution sol = new Solution();

        Node head = sol.convertArrToLL(arr);
        System.out.println("Linkedlist is palindrome? " + OptIsPalindrome(head));
        sol.print(head);
    }
}
