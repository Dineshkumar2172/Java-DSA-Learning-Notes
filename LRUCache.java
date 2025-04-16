import java.util.HashMap;

class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private HashMap<Integer, ListNode> keyvalStore;
    private final int MAX_CAPACITY;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.keyvalStore = new HashMap<>();
        this.MAX_CAPACITY = capacity;
        this.head = new ListNode(-1, -1); // dummy head
        this.tail = new ListNode(-1, -1); // dummy tail
        this.head.next = tail; // head will be pointing to tail
        this.tail.prev = head; // tail will be pointing to head
    }
    
    public int get(int key) {
        if (!this.keyvalStore.containsKey(key)) return -1;

        ListNode node = this.keyvalStore.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (this.keyvalStore.containsKey(key)) {
            ListNode oldNode = this.keyvalStore.get(key);
            remove(oldNode);
        }

        ListNode newNode = new ListNode(key, value);
        this.keyvalStore.put(key, newNode);
        add(newNode);

        if (this.keyvalStore.size() > this.MAX_CAPACITY) {
            ListNode nodetoDelete = this.head.next;
            remove(nodetoDelete);
            this.keyvalStore.remove(nodetoDelete.key);
        }
    }
    
    public void add(ListNode node) {
        ListNode previousNode = tail.prev;
        previousNode.next = node;
        node.prev = previousNode;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

