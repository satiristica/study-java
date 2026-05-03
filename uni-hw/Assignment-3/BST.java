import java.util.ArrayList;
import java.util.List;

public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.Node> {
    private Node root;
    private int size;

    public class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }
    }

    public int size() {
        return size;
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node current, K key, V val) {
        if (current == null) {
            size++;
            return new Node(key, val);
        }

        int cmp = key.compareTo(current.key);

        if (cmp < 0) {
            current.left = put(current.left, key, val);
        } else if (cmp > 0) {
            current.right = put(current.right, key, val);
        } else {
            current.val = val;
        }

        return current;
    }

    public V get(K key) {
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current.val;
            }
        }

        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node current, K key) {
        if (current == null) {
            return null;
        }

        int cmp = key.compareTo(current.key);

        if (cmp < 0) {
            current.left = delete(current.left, key);
        } else if (cmp > 0) {
            current.right = delete(current.right, key);
        } else {
            size--;

            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

            Node temp = current;
            current = min(temp.right);
            current.right = deleteMin(temp.right);
            current.left = temp.left;
        }

        return current;
    }

    private Node min(Node current) {
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    private Node deleteMin(Node current) {
        if (current.left == null) {
            return current.right;
        }

        current.left = deleteMin(current.left);
        return current;
    }

    @Override
    public java.util.Iterator<Node> iterator() {
        List<Node> nodes = new ArrayList<>();
        inOrder(root, nodes);
        return nodes.iterator();
    }

    private void inOrder(Node current, List<Node> nodes) {
        if (current == null) {
            return;
        }

        inOrder(current.left, nodes);
        nodes.add(current);
        inOrder(current.right, nodes);
    }
}