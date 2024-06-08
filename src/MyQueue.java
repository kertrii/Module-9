public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return head.value;
    }

    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T firstValue = head.value;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return firstValue;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
