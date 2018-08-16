package offer;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if (stack1.empty()) {
            if (stack2.empty()) {
                stack1.push(node);
            } else {
                while (!stack2.empty()) {
                    stack1.push(stack2.pop());
                }
            }
        } else {
            stack1.push(node);
        }
    }

    public int pop() {
        if (!stack1.isEmpty()) {
            if (!stack2.empty()) {
                return stack2.pop();
            } else {
                while (!stack1.empty()) {
                    Integer tempNode = stack1.pop();
                    stack2.push(tempNode);
                }
                return stack1.pop();
            }

        } else {
            return stack2.pop();
        }
    }

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int minValue = array[0];
        for (int s = 1; s < array.length; s++) {
            if (array[s] < array[s - 1]) {
                minValue = array[s];
                break;
            }
        }
        return minValue;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
            if (p1 != p2) {
                if (p1 != null) {
                    p1 = pHead2;
                }
                if (p2 != null) {
                    p2 = pHead1;
                }
            }
        }
        return p1;
    }

    /**
     * 查找字符串B的字符任意一种组合是否是字符串A的子串
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean isFound(String str1, String str2) {
        if (str1 == null || str2 == null || str2.length() == 0) {
            return false;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str2.length(); i++) {
            set.add(str2.charAt(i));
        }
        HashSet<Character> setBak = new HashSet<>(set);
        for (int i = 0; i < str1.length(); i++) {
            char currentChar = str1.charAt(i);
            if (!set.isEmpty()) {
                if (set.contains(currentChar)) {
                    set.remove(currentChar);
                    if (set.isEmpty()) {
                        return true;
                    }
                } else {
                    set = new HashSet<>(setBak);
                }
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找AB字符串中最长公共子串，连续的
     *
     * @param strOne
     * @param strTwo
     * @return
     */
    public String maxSubString(String strOne, String strTwo) {
        if (strOne == null || strTwo == null || strOne.equals("") || strTwo.equals("")) {
            return null;
        }
        String max = "";
        String min = "";
        if (strOne.length() > strTwo.length()) {
            max = strOne;
            min = strTwo;
        } else {
            max = strTwo;
            min = strOne;
        }
        String current = "";
        String maxString = "";
        for (int i = 0; i < min.length(); i++) {
            for (int begin = 0, end = min.length() - i; end <= min.length(); begin++, end++) {
                current = min.substring(begin, end);
                if (max.contains(current)) {
//                    if (current.length() > maxString.length()){
//                        maxString = current;
//                    }
                    return current;
                }
            }
        }
        return maxString;
    }

    public ListNode deleteDuplicateNode(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next!=null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String a = "as0dcssdasewaa";
//        String b = "ppdcssewa";
//        System.out.println(solution.maxSubString(a, b));
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head = solution.deleteDuplicateNode(head);
        System.out.println(head);
    }

}
