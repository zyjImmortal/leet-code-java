package linked;

public class LinkedList<E> {
    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        head = new Node(e, head);
        size++;
    }

    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add Failed, required index is index < 0 || index > size");
        }
        Node dumpyHead = new Node(null, null); // 虚拟头结点
        dumpyHead.next = head;

        // 插入位置的前一个节点，从dumpyHead开始遍历
        Node pre = dumpyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
//            Node node = new Node(e);
//            node.next = pre.next;
//            pre.next = node;
        pre.next = new Node(e, pre.next);
        size++;
    }

    public void addLast(E e) {
        add(e, size);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add Failed, required index is index < 0 || index > size");
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public boolean contain(E e) {
        Node cur = head;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur = head;
//        while (cur != null) {
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = head; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NUll");
        return res.toString();
    }

    public E remove(int index) {
        Node dumpyhead = new Node(null, null);
        dumpyhead.next = head;
        Node pre = dumpyhead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public E removeFirst(){
        return remove(0);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(44, 3);
        System.out.println(linkedList);
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList);
    }
}
