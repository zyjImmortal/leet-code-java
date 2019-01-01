package algorithm;

/**
 * UF
 */
public class UF {

    private int count;
    private int[] id;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        return id[p];
    }

    public int findV2(int p) {
        while (p != id[p]) { // 当p等于id[P]的时候说明，某个点指向了自己即是根节点
            p = id[p]; // 如果不相等，就把p指向自己的父节点，依次往上寻找
        }
        return p;
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID)
            return; // 如果pID和qID相同则说明p和q在一个连接总
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID)
                id[i] = qID; // 将p所在连接里的所有数据的标识都设置为q的连接标识
        }
        count--; // 如果pID和qID相同则说明p和q在一个连接总
    }

    public void unionV2(int p, int q) {

    }

}