import java.util.ArrayList;
import java.util.PriorityQueue;

class BinaryHeap {
    int capacity;
    int size;
    int[] arr;

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[this.capacity];
    }

    int Parent(int i) {
        return (i - 1) / 2;
    }

    int Left(int i) {
        return 2 * i + 1;
    }

    int Right(int i) {
        return 2 * i + 2;
    }


    int extractMin() {
        if (size == 0) {
            return -1;
        }

        int min = arr[0];
        arr[0] = arr[size - 1];
        size--;

        int i = 0;

        while (true) {
            int left = Left(i);
            int right = Right(i);
            int smallest = i;

            if (left < size && arr[left] < arr[smallest])
                smallest = left;

            if (right < size && arr[right] < arr[smallest])
                smallest = right;

            if (smallest == i)
                break;

            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            i = smallest;
        }

        return min;
}

    void Insert(int x) {
        if(size == capacity) {
            System.out.println("Heap size is full cannot add more elements");
            return;
        }

        arr[size] = x;

        int k = size;
        size++;

        while (k != 0 && arr[Parent(k)] > arr[k]) {
            int temp = arr[Parent(k)];
            arr[Parent(k)] = arr[k];
            arr[k] = temp;

            k = Parent(k);
        }
    }

    int[] getArr() {
        return arr;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {

    static ListNode sort2LL(ListNode ll1, ListNode ll2) {
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        while (ll1 != null && ll2 != null) {
            if(ll1.val <= ll2.val) {
                temp.next = ll1;
                temp = ll1;
                ll1 = ll1.next;
            } else {
                temp.next = ll2;
                temp = ll2;
                ll2 = ll2.next;
            }
        }

        if(ll1 != null) temp.next = ll1;
        else temp.next = ll2;

        return ans.next;
    }

    // Sol 1 (TC -> nk, SC -> 1);
    static ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        if (lists.length == 1)
            return lists[0];

        ListNode newHead = lists[0];

        for(int i = 1; i < lists.length; i++) {
            newHead = sort2LL(newHead, lists[i]);
        }

        return newHead;
    }

    static ListNode convertArrToLL (int arr[]) {
        if(arr.length == 0) return new ListNode();

        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;

        for(int i = 1; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            temp.next = newNode;
            temp = temp.next;
        }

        return head;
    }




    // Sol 2
    static ListNode mergekLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        ArrayList<Integer> arr = new ArrayList<>();

        // Collect all values
        for (ListNode head : lists) {
            while (head != null) {
                arr.add(head.val);
                head = head.next;
            }
        }

        if (arr.size() == 0)
            return null;

        // Build Min Heap
        BinaryHeap heap = new BinaryHeap(arr.size());

        for (int x : arr) {
            heap.Insert(x);
        }

        // Create sorted linked list using extractMin()
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (heap.size > 0) {
            temp.next = new ListNode(heap.extractMin());
            temp = temp.next;
        }

        return dummy.next;
    }

    // Sol 3 (Optimal solution) (TC -> nlogk, SC -> k);
    static ListNode mergeKLists3(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
            (a, b) -> a.val - b.val 
        );

        for(ListNode node: lists) {
            if(node != null) queue.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (!queue.isEmpty()) {
            ListNode smallest = queue.poll();
            temp.next = smallest;
            temp = temp.next;

            if(smallest.next != null) {
                queue.add(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 4, 5 };
        int[] arr2 = { 1, 3, 4 };
        int[] arr3 = { 2, 6 };

        ListNode node1 = convertArrToLL(arr1);
        ListNode node2 = convertArrToLL(arr2);
        ListNode node3 = convertArrToLL(arr3);

        ListNode[] lists = { node1, node2, node3 };

        ListNode ans = mergeKLists3(lists);

        ListNode temp = ans;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        
    }
}
