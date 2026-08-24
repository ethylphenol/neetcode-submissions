class LRUCache {
    private Map<Integer, Node> cache;
    private Node LRU = new Node(0, 0);
    private Node MRU = new Node(0, 0);
    private int capacity;

    private static class Node {
        Node prev, next;
        int key, val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void appendNode(Node node) {
        MRU.prev.next = node;
        node.prev = MRU.prev;
        MRU.prev = node;
        node.next = MRU;
    }

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
        LRU.next = MRU;
        MRU.prev = LRU;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node n = cache.get(key);
            deleteNode(n);
            appendNode(n);
            return n.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node n = cache.get(key);
            n.val = value;
            deleteNode(n);
            appendNode(n);
            return;
        }
        if (cache.size() == capacity) {
            cache.remove(LRU.next.key);
            deleteNode(LRU.next);
        }
        Node n = new Node(key, value);
        cache.put(key, n);
        appendNode(n);
    }
}