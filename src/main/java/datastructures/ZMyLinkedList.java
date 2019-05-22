package datastructures;

public class ZMyLinkedList {

    public class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

  public void addFront(int value) {
      if (head == null) {
          head = new Node(value);
          size = 1;
          return;
      } else {
          Node first = new Node(value);
          first.next = head;
          head = first;
          size++;
      }
  }

  public void addBack(int value) {
      if (head == null) {
          head = new Node(value);
          size = 1;
          return;
      }
      Node node = head;
      while (node.next != null) {
          node = node.next;
      }
      node.next = new Node(value);
      size++;
  }

  public int getFirst() {
      return head.data;
  }

  public int getLast() {
      if (head == null) {
          throw new IllegalStateException("Empty list!");
      }
      Node node = head;
      while (node.next != null) {
          node = node.next;
      }
      return node.data;
  }

  public int size() {
      return size;
  }

  public void clear() {
      head = null;
      size = 0;
  }

  public void deleteValue(int value) {
      if (head == null) {
          return;
      }
      if (head.data == value) {
          head = head.next;
          return;
      }
      Node node = head;
      while (node.next != null) {
          if (node.next.data == value) {
              node.next = node.next.next;
              size--;
              return;
          }
          node = node.next;
      }
  }

  public boolean contains(int value) {
      Node node = head;
      while (node.next != null) {
          if (node.data == value) {
              return true;
          }
          node = node.next;
      }
      return false;
  }

  public void traverse() {
      Node node = head;
      while (node.next != null) {
          System.out.println(node.data);
      }
  }

  public void removeFront() {
      head = head.next;
      size--;
  }

  public void removeBack() {
      Node node = head;
      while (node.next.next != null) {
          node = node.next;
      }
      node.next = null;
      size--;
  }

  
}
