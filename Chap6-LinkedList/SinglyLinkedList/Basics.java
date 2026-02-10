class Node {
    int data;
    Node next;

    public Node (int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    public Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

class Solution {
    // Traverse and print all the elements
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

    // 2. Search an element in the linkedList;
    boolean isPresent(Node head, int element) {
        Node temp = head;
        while (temp != null) {
            if(temp.data == element) return true;
            temp = temp.next;
        }
        return false;
    }

    // 3. Insert at the head;
    Node insertAtHead(Node head, int element) {
        Node temp = new Node(element, head);
        return temp;
    }
    
    // 4. Insert at tail;
    Node insertAtTail(Node head, int element) {
        if(head == null) {
            Node tail = new Node(element);
            return tail;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        Node newNode = new Node(element);
        temp.next = newNode;

        return head;
    }

    // 5. Insert at kth position
    Node insertAtKthPosition(Node head, int pos, int ele) {
        if(head == null && pos > 1 && pos < 0) return null;
        if(head == null) return new Node(ele);

        if(pos == 1) return insertAtHead(head, ele);

        int counter = 0;
        Node temp = head;
        while (temp != null) {
            counter++;
            if(counter == pos - 1) {
                Node newNode = new Node(ele);
                newNode.next = temp.next;
                temp.next = newNode;
            }
            temp = temp.next;
        }

        return head;

    }

    // 6. Insert after an element;
    Node insertAfterEle(Node head, int afterEle, int ele) {
        if(head == null) return null;

        Node temp = head;
        while (temp.next != null && temp.data != afterEle) {
            temp = temp.next;
        }
        Node newNode = new Node(ele);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    // 7. Insert before an element;
    Node insertBeforeEle(Node head, int beforeEle, int ele) {
        if(head == null) return null;
        if(head.data == beforeEle) return insertAtHead(head, ele);

        Node temp = head;
        while (temp.next.next != null && temp.next.data != beforeEle) {
            temp = temp.next;
        }
        // if(temp)
        Node newNode = new Node(ele);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    // 8. Delete the head;
    Node deleteHead(Node head) {
        if(head == null) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        return head;
    }

    // 9. Delete the tail;
    Node deleteTail(Node head) {
        if(head == null || head.next == null) return null;

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;   
    }

    // 10. Delete at kth position
    Node deleteAtKthPosition(Node head, int pos) {
        if(head == null || head.next == null) return null;
        if(pos == 1) return deleteHead(head);

        
        int counter = 1;
        Node temp = head;
        while (temp.next.next != null && counter != pos - 1) {
            counter++;
            temp = temp.next;    
        }
        if(counter != pos - 1) return head;
        temp.next = temp.next.next;
        return head;
    }

    // 11. Delete after an element
    Node deleteAfterEle(Node head, int ele) {
        if(head == null || head.next == null) return null;

        Node temp = head;
        while (temp.next.next != null && temp.data != ele) {
            temp = temp.next;    
        }
        if(temp.data != ele) return head;
        temp.next = temp.next.next;
        return head;
    }

    // 12. Delete before an element
    Node deleteBeforeEle(Node head, int ele) {
        if (head == null || head.next == null) 
            return head; // nothing to delete

        // Case: head contains ele → nothing before head
        if (head.data == ele) 
            return head;

        // Case: second node contains ele → delete head
        if (head.next.data == ele) 
            return deleteHead(head);

        Node temp = head;

        // Move temp until temp.next.next is the node with ele
        while (temp.next != null && temp.next.next != null 
            && temp.next.next.data != ele) {
            temp = temp.next;
        }

        // If we didn’t find ele
        if (temp.next == null || temp.next.next == null) 
            return head;

        // Delete temp.next (node before ele)
        temp.next = temp.next.next;
        return head;
    }

    // 13. Reverse a linkedList
    Node reverseLL(Node head) {
        if(head == null || head.next == null) return head;

        Node prev = null;
        Node temp = head;

        while(temp != null) {
            Node forw = temp.next;
            temp.next = prev;
            prev = temp;
            temp = forw;
        }

        return prev;
    }
    
    // Leetcode question 237
    void deleteNode(Node node) {   
        node.data = node.next.data;
        while (node.next.next != null) {
            node = node.next;
            node.data = node.next.data;
        }
        // node.next = null;
        // print(head);
    }

}



public class Basics {
    public static void main(String[] args) {
        int arr[] = {1, 4, 14, 12, 78, 5, 10};
        // 1 -> 4 -> 14 -> 12 -> 78 -> 5 -> 10
        // 1 <- 4   14 -> 12 -> 78 -> 5 -> 10
        // 
        Solution sol = new Solution();

        Node head = sol.convertArrToLL(arr);
        // if (sol.isPresent(head, 20)) System.out.println("The element is present in the linkedList");
        // else System.out.println("The element is not present in the linkedList");
        
        // head = sol.insertAtHead(head, 15);
        // head = sol.insertAtTail(head, 45);
        // head = sol.insertAtKthPosition(head, 12, 20);
        // head = sol.insertAfterEle(head, 10, 25);
        // head = sol.insertBeforeEle(head, 100, 25);
        // head = sol.deleteTail(head);
        // head = sol.deleteAtKthPosition(head, 10);
        // head = sol.deleteAfterEle(head, 10);
        // head = sol.deleteBeforeEle(head, 100);
        // sol.deleteNode(head.next.next);
        head = sol.reverseLL(head);

        sol.print(head);
    }
}
