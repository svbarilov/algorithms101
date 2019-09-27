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
        root = null;

    }

///////////////////////////////////////////////////////////////////////////////
    public String find(int key) {
        // First find the node
        Node node = find(key,  root);

        // Then return the value
        return node == null ? null : node.value;
    }

    private Node find(int key, Node node) {
        if (node == null) {
            return null;
        }
        if (node.key == key) {
            return node;
        } else if (key > node.key) {
            return find(key, node.right);
        } else if (key <= node.key) {
            return find(key, node.left);
        }
        return null;
    }

    public void insert(int key, String value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, int key, String value) {
        if (node == null) {
            return new Node(key, value);
        }
        if (key > node.key) {
            node.right = insert(node.right, key, value);
        } else if (key <= node.key) {
            node.left = insert(node.left, key, value);
        }
        return node;
    }

    public int findMinKey() {
        return findMinKey(root).key;
    }

    private Node findMinKey(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

//    public Node delete(Node node, int key) {
//        // 1. No Children => Just set to null
//        // 2. One Child => Replace Node do del with that child
//        // 3. Two Children => Find min to the right and replace node to del with it
//
//        Node toDel = find(key, node);
//        if (toDel.left == null && toDel.right == null) {
//            toDel = null;
//        } else if (toDel.left == null) {
//            toDel = toDel.right;
//        } else if (toDel.right == null) {
//            toDel = toDel.left;
//        } else {
//            Node min = findMinKey(toDel);
//            toDel.key = min.key;
//            toDel.value = min.value;
//            delete(min.key);
//        }
//        return node;
//    }



    public Node delete(Node node, int key) {
        if (node == null) {
            return null;
        } else if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else { // Woohoo! Found you. This is the node we want to delete.

            // Case 1: No child
            if (node.left == null && node.right == null) {
                node = null;
            }

            // Case 2: One child
            else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            }

            // Case 3: Two children
            else {
                // Find the minimum node on the right (could also max the left...)
                Node minRight = findMinKey(node.right);

                // Duplicate it by copying its values here
                node.key = minRight.key;
                node.value = minRight.value;

                // Now go ahead and delete the node we just duplicated (same key)
                node.right = delete(node.right, node.key);
            }
        }

        return node;
    }









    public void prettyPrint() {
        // Hard coded print out of binary tree depth = 3

        int rootLeftKey = root.left == null ? 0 : root.left.key;
        int rootRightKey = root.right == null ? 0 : root.right.key;

        int rootLeftLeftKey = 0;
        int rootLeftRightKey = 0;

        if (root.left != null) {
            rootLeftLeftKey = root.left.left == null ? 0 : root.left.left.key;
            rootLeftRightKey = root.left.right == null ? 0 : root.left.right.key;
        }

        int rootRightLeftKey = 0;
        int rootRightRightKey = 0;

        if (root.right != null) {
            rootRightLeftKey = root.right.left == null ? 0 : root.right.left.key;
            rootRightRightKey = root.right.right == null ? 0 : root.right.right.key;
        }

        System.out.println("     " + root.key);
        System.out.println("   /  \\");
        System.out.println("  " + rootLeftKey + "    " + rootRightKey);
        System.out.println(" / \\  / \\");
        System.out.println(rootLeftLeftKey + "  " + rootLeftRightKey + " " + rootRightLeftKey + "   " + rootRightRightKey);
    }
}
