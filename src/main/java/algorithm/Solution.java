package algorithm;

import java.util.HashMap;

/**
 * Solution
 */
public class Solution {

    private HashMap<Integer, Integer> map = new HashMap<>();
    private HashMap<Integer, Integer> count = new HashMap<>();
    private int res = 1;

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

    public int maxAreaOfIsland(int[][] grid) {
        return 1;
    }

    private int binaryResearch(int[] nums, int target) {
        int left = 0, right = 0;
        while (left < right) {

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

        return 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 100, 4, 200, 1, 3, 2 };
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(nums));
    }
}