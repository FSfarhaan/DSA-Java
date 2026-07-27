// Unsolved
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class LFUCache {
    class Node {
        int key, val, freq;
        Node next, prev;

        public Node(int key, int value) {
            this.key = key;
            this.val = value;
            freq = 1;
        }
    }

    int size;
    HashMap<Integer, Node> freqMap;
    Deque<Node> queue;
    Node head, tail;
    int maxFreq;

    // Constructor
    public LFUCache(int capacity) {
        size = capacity;
        freqMap = new HashMap<>();
        queue = new LinkedList<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;

        maxFreq = 0;
    }
    
    // Method to get the value of key from LFU cache
    public int get(int key) {
        return 1;
    }
    
    // Method to insert key-value pair in LFU cache
    public void put(int key, int value) {
        if(freqMap.isEmpty()) maxFreq = 1;
        
        if(freqMap.containsKey(key)) {
            Node node = freqMap.get(key);
            node.freq++;

            // maxFreq = Math.max(maxFreq, node.freq);
            if(node.freq >= maxFreq) {
                maxFreq = node.freq;

                queue.addFirst(queue.pollLast());
            }
            node.val = value;
        }

        Node newNode = new Node(key, value);
        freqMap.put(key, newNode);

        // if()

    }
}

public class LFU {
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1);      // return 1
                        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2);      // return -1 (not found)
        lfu.get(3);      // return 3
                        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);      // return -1 (not found)
        lfu.get(3);      // return 3
                        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);      // return 4
                        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
}