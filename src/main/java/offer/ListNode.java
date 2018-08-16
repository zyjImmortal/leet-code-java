package offer;

import linked.LinkedList;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur = head;
//        while (cur != null) {
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (ListNode cur = this; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NUll");
        return res.toString();
    }
}
