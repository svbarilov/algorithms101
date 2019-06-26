package algorithms;

public class ZMyBinarySearchTree {

    public class Node {
        int key;
        String value;
        Node left, right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    Node root;

    public ZMyBinarySearchTree() {

    }

    public void insert(int key, String value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, int key, String value) {
        if (node == null) {
            Node newNode = new Node(key, value);
            return newNode;
        }

        if (node.key > key) {
            node.right = insert(node.right, key, value);
        } else if (node.key < key) {
            node.left = insert(node.left, key, value);
        }

        return node;
    }

    public String find(int key) {
        Node node = find(root, key);
        return node == null ? null : node.value;
    }

    private Node find(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        } else if (node.key < key) {
           return  find(node.left, key);
        } else if (node.key > key){
            return find(node.right, key);
        }
        return null;
    }

    public String findMin() {
        Node node = findMin(root);
        return node.value;
    }

    public Node findMin(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }



}
