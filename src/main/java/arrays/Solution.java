package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class Solution {

    private HashMap<Integer, Integer> map = new HashMap<>(); // map存储每个数的连同节点即父节点
    private HashMap<Integer, Integer> count = new HashMap<>(); // count存储每个连同的大小，key为标识节点，value为连同中的节点数
    private int res = 1;

    /**
     * 给定一个包含 n 个整数的数组 numss，判断 numss 中是否存在三个元素 a，b，c ，使得 a + b + c
     *  = 0
     * ？找出所有满足条件且不重复的三元组。 注意：答案中不可以包含重复的三元组。 例如, 给定数组 numss =
     * 
     * 
     * 
     * [-1, 0, 1, 2, -1, -4]， 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
     * 
     * 
     * 
     *
     * 思路： 排序后数组 [-4,-1,-1,0,1,2
     * ,对原数组操作会出现，[-1,0,1], [-1, 1,0]这种情况，但是这是两种情况是相
     *  的 排序后，两个-1 挨着，0、1就只会被利
     *  一次
     *
     * 下面这种解法时间复杂度O(n3)太高了
     * 
     * @param numss
     * @return
     */
    public List<List<Integer>> threeSum(int[] numss) {
        Arrays.sort(numss); // 让后面可能出现满足条件的数字排除掉，比如说[-1,0,1], [-1, 1,0]
                            // 
                            //
                            //
        HashSet<List<Integer>> array = new HashSet<>();
        for (int i = 0; i < numss.length - 2; i++) {
            for (int j = i + 1; j < numss.length - 1; j++) {
                for (int p = j + 1; p < numss.length; p++) {
                    if ((numss[i] + numss[j] + numss[p]) == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(numss[i]);
                        temp.add(numss[j]);
                        temp.add(numss[p]);
                        array.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (List list : array) {
            lists.add(list);
        }
        return lists;
    }

    /**
     * 对排序后的进行操作的好出，就是当某三个位置的书和如果大于0，就让低指针右移，这样和就会变大就会接近于0，如果大于0，
     * 高指针就左移让和变小，，如果为0，那就是低的右移高德左移
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumV2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3 || nums == null)
            return res;
        HashSet<List<Integer>> hs = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    List<Integer> unit = new ArrayList<>();
                    unit.add(nums[i]);
                    unit.add(nums[low]);
                    unit.add(nums[high]);

                    // if(!hs.contains(unit)){
                    // hs.add(unit);
                    // res.add(unit);
                    // }
                    hs.add(unit);

                    low++;
                    high--;
                } else if (sum > 0)
                    high--;
                else
                    low++;
            }
        }
        res.addAll(hs);
        return res;
    }

    public int maxAreaOfIsland(int[][] grid) {
        return -1;
    }

    /**
     * 最长连续递增数列
     * 
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int maxLength = 1;
        int start = 0, cur = 0, end = 1;
        while (end < nums.length) {
            if (nums[end] > nums[cur]) {
                int length = end - start + 1;
                maxLength = Math.max(length, maxLength);
                end++;
                cur++;
            } else {
                start = cur = end;
                end++;
            }

        }
        return maxLength;
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // public int longestConsecutive(int[] nums) {
    // return 1;
    // }

    public void moveZeroes(int[] nums) {
        int start = 0, end = nums.length - 1;
        // ArrayList<Integer> list = new ArrayList<>();
        // for (int i = 0; i < nums.length; i++) {
        // list.add(nums[i]);
        // }

        while (start <= end) {
            if (nums[start] == 0) {
                ArrayUtils.add(nums, nums[start]);
                end--;
                ArrayUtils.remove(nums, start);
            } else {
                start++;
            }
        }
    }

    public int maxProfit(int[] prices) {

        return 0;
    }

    public int longestConsecutive(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        for (int i = 0; i < a.length; i++) {
            int cur = a[i];
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
            return p; // 如果某个点的值等于自己，那就是标识节点，满足并查集的自反性
        int parent = find(map.get(p)); // 递归查找，一级级往上查找
        map.put(p, parent); // 路径压缩，将每个节点的父节点都指向标识节点，这样在以后的查找中很省时
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
            count.put(qx, rawCount);
        }
        res = Math.max(res, rawCount);
    }

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        // int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        // System.out.println(nums[-3]);
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(nums));
    }
}
