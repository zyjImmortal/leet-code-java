package algorithmbook.sort;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v; // 在末尾添加新的元素，然后上浮到合适的位置
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1]; // 从根节点取得最大元素
        exch(1, N--); // 最大元素和最后一个元素进行交换，总数减一
        pq[N+1] = null;  // 将最后一个元素指向null，释放King阿金
        sink(1); // 将根节点元素下沉
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[i]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /**
     * 上浮
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 下沉
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
}
