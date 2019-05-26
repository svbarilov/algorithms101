package datastructures;

public class ZMyQueue {
    private class Node {
        public Node next;
        public String data;

        public Node(String data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;


    public void enqueue(String value) {
        Node newNode = new Node(value);
        if (tail != null) {
            tail.next = newNode;
        }
        tail  = newNode;
        if (head == null) {
            head = tail;
        }
    }

    public String dequeue() {
        String data = head.data;
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
        return data;

    }

    public String peek() {
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void traverse() {
        Node current = head;
        while (current.next != null) {
            System.out.println(current.data);
        }
    }
}
