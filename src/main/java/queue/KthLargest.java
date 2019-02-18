package queue;

import java.util.PriorityQueue;

/**
 * 问题：
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素
 *
 * @author zhouyajun
 * @date 2019/2/18
 */
public class KthLargest {
    /**
     * PriorityQueue优先队列通过数组使用小顶堆实现
     */
    private PriorityQueue<Integer> q;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int a : nums) {
            add(a);
        }
    }

    /**
     * 思路：
     * 用一个优先队列维护前k大的元素， PriorityQueue优先队列通过数组使用小顶堆实现
     * 对顶元素刚好是第k大元素
     * PriorityQueue操作
     * 添加元素：
     * add()和offer()，前者抛出异常，后者返回false
     * 获取元素：
     * element()和peek()，前者抛出异常，后者返回null
     * 删除元素：
     * remove()和poll()，前者抛出异常，后者返回null
     *
     * @param val
     * @return int
     */
    public int add(int val) {
        if (q.size() < k) {
            q.offer(val);
            // 如果添加的值大于堆顶元素的值，则删除堆顶元素，插入最新值，保证队列中存储数据流中前k大的元素
        } else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }

    /**
     * 查找数组中第k大元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums == null || nums.length < k) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int n : nums) {
            if (queue.size() < k) {
                queue.offer(n);
            } else if (queue.peek() < n) {
                queue.poll();
                queue.offer(n);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 8, 5, 7, 1};
//        KthLargest kthLargest = new KthLargest();
        System.out.println();
    }
}
