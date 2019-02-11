package algorithm;

import java.util.HashMap;


/**
 * Solution，，leetcode今日头条算法题
 */
public class Solution {

    private HashMap<Integer, Integer> map = new HashMap<>();
    private HashMap<Integer, Integer> count = new HashMap<>();
    private HashMap<Integer, Integer> position = new HashMap<>();
    private int res = 1;

    // 最长连续子序列
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(cur)) {
                continue;
            }
            map.put(cur, cur);
            count.put(cur, 1);
            if (map.containsKey(cur - 1)) {
                union(cur, cur - 1);
            }
            if (map.containsKey(cur + 1)) {
                union(cur, cur + 1);
            }
        }
        return res;
    }

    private int find(int p) {
        if (p == map.get(p))
            return p;
        int parent = find(map.get(p));
        map.put(p, parent);
        return parent;
    }

    private void union(int p, int q) {
        int px = find(p);
        int qx = find(q);
        int rawCount = count.get(px) + count.get(qx);
        if (count.get(px) < count.get(qx)) {
            map.put(px, qx); // 将px指向qx
            count.put(qx, rawCount);
        } else {
            map.put(qx, px);
            count.put(px, rawCount);
        }
        res = Math.max(res, rawCount);
    }

    private int binaryResearch(int[] nums, int target) {
        int left = 0, right = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 思路：先用二分查找出旋转点的位置，将序列分成两个正常的已排序的序列，然后再分别用二分查找找到target
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (right + left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int targetPosition = binaryResearch(nums, target);
        return 1;
    }

    /**
     * 岛屿最大面积，深度优先算法
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int raw = grid.length, column = grid[0].length;
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < column; j++) {
                // 如果岛屿的面积不等于0，进入查找递归算法中
                if (grid[i][j] != 0) maxArea = Math.max(maxArea, findArea(grid, i, j));
            }
        }
        return maxArea;
    }

    private int findArea(int[][] grid, int i, int j) {
        // 边界条件
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != 0) {
            grid[i][j] = 0; // 计算过的岛屿面积置为0
            // 岛屿自己的面积为1，总面积为附属四个点和自己面积的总和
            return 1 + findArea(grid, i, j + 1) + findArea(grid, i, j - 1) + findArea(grid, i + 1, j) + findArea(grid, i - 1, j);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(nums));
    }
}