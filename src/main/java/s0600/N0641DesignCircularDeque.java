package s0600;

public class N0641DesignCircularDeque {
    Object[] elements;
    int head;
    int tail;
    int size;

    public N0641DesignCircularDeque(int k) {
        elements = new Object[k];
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (isEmpty()) return insertLast(value);

        elements[head = (head - 1 + elements.length) % elements.length] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;

        elements[tail] = value;
        tail = (tail + 1 + elements.length) % elements.length;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;

        head = (head + 1 + elements.length) % elements.length;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;

        tail = (tail - 1 + elements.length) % elements.length;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;

        return (int) elements[head];
    }

    public int getRear() {
        if (isEmpty()) return -1;

        return (int) elements[(tail - 1 + elements.length) % elements.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }
}
