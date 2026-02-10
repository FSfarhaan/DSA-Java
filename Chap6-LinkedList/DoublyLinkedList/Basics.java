class Node {
    int data;
    Node next;
    Node back;

    public Node (int data1, Node next1, Node back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    public Node(int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
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

    // 1. Convert arr into DLL
    Node convertArrToDLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;
        
        for(int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i], null, temp);
            temp.next = newNode;
            temp = temp.next;
        }
        return head;
    }

    // 2. Search an element in the linkedList;
    boolean isPresent(Node head, int ele) {
        Node temp = head;
        while (temp != null) {
            if(temp.data == ele) return true;
            temp = temp.next;
        }
        return false;
    }

    // 3. Insert at the head;
    Node insertAtHead(Node head, int ele) {
        Node temp = new Node(ele, head, null);
        head.back = temp;
        return temp;
    }

    // 4. Insert at tail;
    Node insertAtTail(Node head, int ele) {
        if (head == null) {
            return new Node(ele);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(ele, null, temp);
        temp.next = newNode;

        return head;
    }

    // 5. Insert at kth position
    Node insertAtKthPosition(Node head, int pos, int ele) {
        if(head == null && pos > 1 && pos < 0) return null;
        if(pos == 1) return insertAtHead(head, ele);

        int counter = 0;
        Node temp = head;
        while (temp.next != null) {
            counter ++;
            if(counter == pos - 1) {
                Node newNode = new Node(ele, temp.next, temp);
                temp.next.back = newNode;
                temp.next = newNode;
            }
            temp = temp.next;
        }

        if(temp.next == null && counter + 1 == pos - 1) return insertAtTail(head, ele);
        return head;
    }

    // 6. Insert after an element;
    Node insertAfterEle(Node head, int ele, int afterEle) {
        if(head == null) return null;
        
        Node temp = head;
        while (temp.next != null  && temp.data != afterEle) {
            temp = temp.next;
        }

        if(temp.next == null && temp.data == afterEle) return insertAtTail(head, ele);
        if(temp.next == null) return head;

        Node newNode = new Node(ele, temp.next, temp);
        temp.next.back = newNode;
        temp.next = newNode;

        return head;
    }

    // 7. Insert before an element;
    Node insertBeforeEle(Node head, int ele, int beforeEle) {
        if (head == null) return null;
        if (head.data == beforeEle) return insertAtHead(head, ele);

        Node temp = head;
        while (temp.next != null && temp.next.data != beforeEle) {
            temp = temp.next;
        }
        if(temp.next == null && temp.data != beforeEle) return head;

        Node newNode = new Node(ele, temp.next, temp);
        temp.next.back = newNode;
        temp.next = newNode;

        return head;
    }

    // 8. Delete the head;
    Node deleteHead(Node head) {
        if (head == null || head.next == null) return null;

        Node temp = head;
        head = head.next;
        head.back = null;
        temp.next = null;
        return head;
    }

    // 9. Delete the tail;
    Node deleteTail(Node head) {
        if (head == null || head.next == null) return null;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.back.next = null;
        temp.next = null;
        return head;
    }       

    // 10. Delete at kth position
    Node deleteAtKthPosition(Node head, int pos) {
        if(head == null) return null;
        if(pos == 1) return deleteHead(head);
        
        Node temp = head;
        int counter = 0;
        while (temp.next != null) {
            counter++;
            if(counter == pos) {
                temp.back.next = temp.next;
                temp.next.back = temp.back;
            }   
            temp = temp.next;
        }
        if(counter == pos - 1) return deleteTail(head);
        return head;
    }

    // 11. Delete after an element
    Node deleteAfterEle(Node head, int ele) {
        if(head == null || head.next == null) return null;
        
        Node temp = head;
        while (temp.next.next != null) {
            if(temp.data == ele) {
                temp.next = temp.next.next;
                temp.next.back = temp;
            }
            temp = temp.next;
        }
        if(temp.data == ele) return deleteTail(head);
        if(temp.next.data == ele) return head;

        return head;
    }

    // 12. Delete before an element
    Node deleteBeforeEle(Node head, int beforeEle) {
        if(head == null || head.next == null) return null;
        if(head.next.data == beforeEle) return deleteHead(head);

        Node temp = head.next;
        while (temp.next != null) {
            if(temp.next.data == beforeEle) {
                temp.back.next = temp.next;
                temp.next.back = temp.back;
            }
            temp = temp.next;
        }

        return head;
    }

    // 13. Reverse a DLL
    Node reverseDLL(Node head) {
        if (head == null || head.next == null) return head;

        // N -> 1 -> 4 -> 14 -> 12 -> N
        //   <-   <-   <-    <-    <- 

        Node prev = null;
        Node temp = head;
        while (temp != null) {
            Node forw = temp.next;
            temp.next = prev;
            temp.back = forw;
            
            prev = temp;
            temp = forw;
        }

        return prev;

    }
}

public class Basics {
    public static void main(String[] args) {
        int arr[] = {1, 4, 14, 12, 78, 5, 10};
        Solution sol = new Solution();
        Node head = sol.convertArrToDLL(arr);

        // if (sol.isPresent(head, 10)) System.out.println("The element is present in the linkedList");
        // else System.out.println("The element is not present in the linkedList");

        // head = sol.insertAtHead(head, 60);
        // head = sol.insertAtTail(head, 26);
        // head = sol.insertAtKthPosition(head, 5, 100);
        // head = sol.insertAfterEle(head, 25, 100);
        // head = sol.insertBeforeEle(head, 230, 20);
        // head = sol.deleteHead(head);
        // head = sol.deleteTail(head);
        // head = sol.deleteAtKthPosition(head,10);
        // head = sol.deleteAfterEle(head, 5);
        // head = sol.deleteBeforeEle(head, 4);
        head = sol.reverseDLL(head);
        sol.print(head);
    }
}
