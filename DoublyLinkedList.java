public class DoublyLinkedList<T> {
    private Node<T> base;
    private Node<T> top;
    private int size;

    public DoublyLinkedList() {
        this.base = null;
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return false;
    }

    public int getSize() {
        return size;
    }

    public void add(int pos, T value) {
        Node<T> newNode = new Node<>(value);
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if (pos == 0) {
            newNode.next = base;
            if (base != null) {
                base.prev = newNode;
            }
            base = newNode;
            if (top == null) {
                top = newNode;
            }
        } else if (pos == size) {
            newNode.prev = top;
            if (top != null) {
                top.next = newNode;
            }
            top = newNode;
        } else {
            Node<T> current = base;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            if (current.prev != null) {
                current.prev.next = newNode;
            }
            current.prev = newNode;
        }
        size++;
    }

    public T remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        Node<T> current;
        if (pos == 0) {
            current = base;
            base = base.next;
            if (base != null) {
                base.prev = null;
            }
            if (current == top) {
                top = null;
            }
        } else if (pos == size - 1) {
            current = top;
            top = top.prev;
            if (top != null) {
                top.next = null;
            }
        } else {
            current = base;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        return current.data;
    }

    public Node<T> getNode(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        Node<T> current = base;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        return current;
    }

    public T get(int pos) {
        return getNode(pos).data;
    }

    public void set(int pos, T value) {
        Node<T> node = getNode(pos);
        node.data = value;
    }

    public int find(T value) {
        Node<T> current = base;
        int index = 0;
        while (current != null) {
            if (current.data.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
}
