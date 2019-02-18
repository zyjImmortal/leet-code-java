package algorithmbook.find;

/**
 * 基于无需链表的查找
 *
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key, Value> {

    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node node = first; node != null; node = node.next) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node node = first; node != null; node = node.next) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }
}
