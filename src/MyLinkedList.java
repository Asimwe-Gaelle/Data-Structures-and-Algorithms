
public class MyLinkedList<T> {

    // Each node stores data and a link to the next node
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Constructor
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // 1. Add an element at the beginning
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    // 2. Add an element at the end
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    // 3. Remove and return the first element
    public T removeFirst() {
        if (head == null) {
            throw new IllegalStateException(
                    "Cannot remove from an empty list."
            );
        }

        T removedData = head.data;
        head = head.next;
        size--;

        // If the list becomes empty, update tail too
        if (head == null) {
            tail = null;
        }

        return removedData;
    }

    // 4. Get an element at a particular index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Invalid index: " + index
            );
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    // 5. Return the number of elements
    public int size() {
        return size;
    }

    // 6. Reverse the list in place
    public void reverse() {
        Node<T> previous = null;
        Node<T> current = head;

        // The old head will become the new tail
        tail = head;

        while (current != null) {
            Node<T> nextNode = current.next;

            current.next = previous;

            previous = current;
            current = nextNode;
        }

        // Previous is now the new head
        head = previous;
    }

    // 7. Find the middle element in one pass
    public T findMiddle() {
        if (head == null) {
            return null;
        }

        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    // Display the list (useful for testing)
    public void display() {
        Node<T> current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }
}
