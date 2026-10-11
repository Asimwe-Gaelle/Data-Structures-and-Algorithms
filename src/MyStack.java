
public class MyStack<T> {
    private final MyLinkedList<T> list = new MyLinkedList<>();

    // Add an element to the top
    public void push(T value) {
        list.addFirst(value);
    }

    // Remove and return the top element
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.removeFirst();
    }

    // Return the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
