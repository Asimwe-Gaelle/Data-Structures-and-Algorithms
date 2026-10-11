
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // Each node stores a key-value pair
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;

    // Sentinel nodes for the doubly linked list
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be greater than zero"
            );
        }

        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Return the value if the key exists; otherwise return -1
    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) {
            return -1;
        }

        // This entry has now been used, so move it to the end
        moveToMostRecent(node);

        return node.value;
    }

    // Add a new entry or update an existing entry
    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node != null) {
            // Update the existing value
            node.value = value;

            // Mark it as the most recently used
            moveToMostRecent(node);
            return;
        }

        // If full, remove the least recently used entry
        if (cache.size() == capacity) {
            Node leastRecent = head.next;

            removeNode(leastRecent);
            cache.remove(leastRecent.key);
        }

        // Create and insert the new entry
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addToEnd(newNode);
    }

    // Remove a node from its current position
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add a node immediately before tail
    private void addToEnd(Node node) {
        Node last = tail.prev;

        last.next = node;
        node.prev = last;

        node.next = tail;
        tail.prev = node;
    }

    // Move an existing node to the most recently used position
    private void moveToMostRecent(Node node) {
        removeNode(node);
        addToEnd(node);
    }

    // Display entries from least to most recently used
    public void display() {
        Node current = head.next;

        System.out.print("LRU -> ");

        while (current != tail) {
            System.out.print(
                    "[" + current.key + "=" + current.value + "]"
            );

            current = current.next;

            if (current != tail) {
                System.out.print(" -> ");
            }
        }

        System.out.println(" <- MRU");
    }
}
