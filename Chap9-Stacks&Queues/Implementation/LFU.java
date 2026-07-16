import java.util.HashMap;

class LFUCache {
    class Node {
        int key, value, freq;
        Node next, prev;
        
        public Node(int key, int value) {
            this.key = key; this.value = value; this.freq = 1;
        }
    }

    int cap;
    HashMap<Integer, Node> map;

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public void deleteNode(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }

    public void insertAfterHead(Node node) {
        Node currHead = head.next;

        node.next = currHead;
        currHead.prev = node;

        head.next = node;
        node.prev = head;
    }

    public LFUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        node.freq++;

        deleteNode(node);
        insertAfterHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            node.freq++;
            deleteNode(node);
            insertAfterHead(node);
            return;
        }

        Node node = new Node(key, value);
        map.put(key, node);
        insertAfterHead(node);

        if(map.size() >  cap) {
            Node delNode = tail.prev;
            int delKey = delNode.key;

            deleteNode(delNode);
            map.remove(delKey);
        }
    }
}
public class LFU {
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(3);

        lfu.put(2, 2);   // cache=[2,_], cnt(2)=1
        lfu.put(1, 1);   // cache=[1,2], cnt(1)=1, cnt(2)=1
        System.out.println(lfu.get(2));      // return 2
        System.out.println(lfu.get(1));      // return 1
        System.out.println(lfu.get(2));      // return 2
                        // cache=[2,1], cnt(2)=3, cnt(1)=2

        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                        // cache=[3,2], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
                        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
                        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4));      // return 4
                        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
} 