package datastructures;

import java.util.EmptyStackException;

public class ZMyStack {

    private class Node {
        public Node next;
        public String data;

        public Node(String data) {
            this.data = data;
        }
    }

        private Node head;
        private int size;

        public void push(String value) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
            size++;
        }

        public String pop() {
            if (head == null) throw new EmptyStackException();

            String data = head.data;
            head = head.next;
            size --;
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
            Node currentNode = head;
            while (currentNode.next != null) {
                System.out.println(currentNode.data);
            }
        }

}
