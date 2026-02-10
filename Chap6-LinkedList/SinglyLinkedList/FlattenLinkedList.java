import java.util.*;

// Definition of special linked list
class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode child1) {
        val = data1;
        next = next1;
        child = child1;
    }
}

// Logic class
class Solution {
    // Merge two sorted linked lists (by child pointers)
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
    ListNode temp = dummy;

    while (l1 != null && l2 != null) {

        if (l1.val <= l2.val) {
            ListNode next = l1.child;  // save
            temp.child = l1;           // attach
            l1.child = null;           // detach
            temp = temp.child;
            l1 = next;
        } else {
            ListNode next = l2.child;
            temp.child = l2;
            l2.child = null;
            temp = temp.child;
            l2 = next;
        }

        temp.next = null; // always
    }

    if (l1 != null) temp.child = l1;
    else temp.child = l2;

    return dummy.child;
    }

    // Flatten a multi-level linked list
    public ListNode flattenLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mergedHead = flattenLinkedList(head.next);
        return merge(head, mergedHead);
    }
}

// Main class for running the program
public class FlattenLinkedList {
    // Print linked list in flattened form
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.child;
        }
        System.out.println();
    }

    // Print original linked list in grid format
    public static void printOriginalLinkedList(ListNode head, int depth) {
        while (head != null) {
            System.out.print(head.val);

            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // Create a linked list with child pointers
        ListNode head = new ListNode(5);
        head.child = new ListNode(14);

        head.next = new ListNode(10);
        head.next.child = new ListNode(4);

        head.next.next = new ListNode(12);
        head.next.next.child = new ListNode(20);
        head.next.next.child.child = new ListNode(13);

        head.next.next.next = new ListNode(7);
        head.next.next.next.child = new ListNode(17);

        // Print original structure
        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);

        // Flatten list
        Solution sol = new Solution();
        ListNode flattened = sol.flattenLinkedList(head);

        // Print flattened version
        System.out.print("\nFlattened linked list: ");
        printLinkedList(flattened);
    }
}
