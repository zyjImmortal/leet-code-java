package algorithmbook.find;

/**
 *
 * @param <Key>
 * @param <Value>
 *
 * @author zhouyajun
 *
 */

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        //        private Node right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
//        if (node == null) return 0;
//        return node.N;
        return node == null ? 0 : node.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) return null;
        int cmp = node.key.compareTo(key);
        if (cmp > 0) return get(node.left, key);
        else if (cmp < 0) return get(node.right, key);
        else return node.value;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, 1);
        int cmp = node.key.compareTo(key);
        if (cmp < 0) node.right = put(node.right, key, value);
        else if (cmp > 0) node.left = put(node.left, key, value);
        else node.value = value;
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key max(){
        return max(root);
    }

    /**
     *最大键
     * @param node
     * @return {@code Key}
     */
    private Key max(Node node){
        // 如果结点的右结点为空，那么最大的key就是根节点的key
        if (node.right == null) return node.key;
        return max(node.right);
    }

    public Key min(){
        return min(root);
    }

    /**
     * 最小键
     * @param node
     * @return
     */
    private Key min(Node node){
        // 如果根节点的左节点为空，那么最小的key就是根节点的key
        if (node.left == null) return node.key;
        return min(node.left);
    }
}
