package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<Integer> result = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result ;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = null;
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.inorderTraversal(node));
    }
}
