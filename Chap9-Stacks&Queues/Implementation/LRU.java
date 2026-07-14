import java.util.HashMap;

class LRUCache {
    class Node {
        int key; int value;
        Node next; Node prev;
        
        public Node(int key, int value) {
            this.key = key; this.value = value;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    
    int cap;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.head.next = tail;
        this.tail.prev = head;
        this.map = new HashMap<>();
        System.out.println("Init karte waqt " + map.size());
        this.cap = capacity;
    }

    public void deletNode(Node node) {
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
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            deletNode(node);
            insertAfterHead(node);

            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // System.out.println("Add karne se pehle for key " + key + " " + map.size());
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            deletNode(node);
            insertAfterHead(node);

            // System.out.println("Add karne ke baad for key (inside if) " + key + " " + map.size());
            return;
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAfterHead(newNode);
        // System.out.println("Add karne ke baad for key " + key + " " + map.size());

        if(map.size() > cap) {
            Node delNode = tail.prev;
            int delKey = delNode.key;
            map.remove(delKey);
            deletNode(delNode);
        }

    }
}

public class LRU {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1

        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}
