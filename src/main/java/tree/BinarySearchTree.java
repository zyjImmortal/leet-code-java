package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 二分搜索树
 * 二分搜索树的每个节点的值：
 * 大于其左子树的所有节点的值
 * 小于其右子树的所有节点的值
 * 每一颗子树也是二分搜索树
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    // 以node为根的二分搜索树种插入元素e，递归
//    public void add(Node node, E e) {
//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//        }
//
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else if (e.compareTo(node.e) > 0) {
//            add(node.left, e);
//
//        }
//    }

    public Node add(Node node, E e) {
        // 递归结束条件
        if (node == null) {
            node = new Node(e);
        }
        // 递归部分
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.left, e);

        }
        return node;
    }

    public void add(E e) {
        root = add(root, e);
    }

    public boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        }
        return false;
    }


    /**
     * 利用队列实现树的层序遍历
     * @param root
     */
    public void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.isEmpty()){
            Node cur = q.remove();
            if (cur.left != null){
                q.add(cur.left);
            }
            if (cur.right != null){
                q.add(cur.right);
            }
        }
    }

    public static void main(String[] args) {

    }

}
