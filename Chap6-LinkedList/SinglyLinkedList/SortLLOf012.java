public class SortLLOf012 {

    //Brute force (TC -> 2n, SC -> 1);
    static Node sortLL(Node head) {
        int count0 = 0, count1 = 0, count2 = 0;
        Node temp = head;

        while (temp != null) {
            if(temp.data == 0) count0++;
            else if(temp.data == 1) count1++;
            else count2++;
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            if(count0 > 0) {
                temp.data = 0;
                count0--;
            } else if(count1 > 0) {
                temp.data = 1;
                count1--;
            } else {
                temp.data = 2;
                count2--;
            }

            temp = temp.next;
        }

        return head;
    }

    // Optimal Approach
    static Node OptSortLL(Node head) {
        Node dummy0 = new Node(-1);
        Node dummy1 = new Node(-1);
        Node dummy2 = new Node(-1);

        Node zero = dummy0;
        Node one = dummy1;
        Node two = dummy2;

        Node temp = head;

        while (temp != null) {
            if(temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } 
            else if(temp.data == 1)  {
                one.next = temp;
                one = one.next;
            }
            else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        zero.next = dummy1.next != null ? dummy1.next : dummy2.next;
        one.next = dummy2.next;
        two.next = null;

        return dummy0.next;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 0, 0, 2, 2, 1, 0, 1, 0, 0};
        Solution sol = new Solution();
        Node head = sol.convertArrToLL(arr);
        // head = sortLL(head);
        head = OptSortLL(head);
        
        sol.print(head);
        
    }
}
