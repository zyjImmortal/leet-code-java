
package linked;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * Solution
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null)
            cur.next = l1;
        if (l2 != null)
            cur.next = l2;
        return head.next;
    }

    /**
     * cur只想头部节点，
     */
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode next = null, cur = head, pre = null;  // 三个指针
        while (cur != null) {
            next = cur.next;
            cur.next = pre;  // 先把头结点单独取出来，赋值给pre
            pre = cur;   // 每次循环都把单独的头结点的next渎职复制pre
            cur = next;
        }
        return pre;
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头
     * 示例：
     *     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     *     输出：7 -> 0 -> 8
     *     原因：342 + 465 = 807
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int mod = 0;
        while (l1 != null && l2 != null) {
            cur.next = new ListNode((l1.val + l2.val) % 10 + mod);
            mod = (l1.val + l2.val) / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        if (l1 != null) {
            while (l1 != null) {
                cur.next = new ListNode((l1.val) % 10 + mod);
                mod = (l1.val) / 10;
                l1 = l1.next;
                cur = cur.next;
            }
        }
        if (l2 != null) {
            while (l1 != null) {
                cur.next = new ListNode((l2.val) % 10 + mod);
                mod = (l2.val) / 10;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if (mod == 1) {
            cur.next = new ListNode(mod);
        }
        return head.next;
    }

    /**
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     */
    public ListNode sortList(ListNode head) {
        return null;
    }
}