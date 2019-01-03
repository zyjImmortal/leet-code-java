package algorithmbook.find;

public class Merge extends Sort {

    private Comparable[] aux;

    @Override
    public void sort(Comparable[] array) {
        int lo = 0, hi = array.length - 1;
        aux = new Comparable[array.length];
        sort(array, lo, hi);

    }

    private void sort(Comparable[] array, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (lo + hi) / 2;
        sort(array, lo, mid);
        sort(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }

    private void merge(Comparable[] array, int lo, int mid, int hi) {
        // 确定两个有序数组A，B的开始索引,两个数组的索引范围lo-mid,mid+1-hi
        int i = lo, j = mid + 1;
        for (int k = lo; k < hi; k++) {
            aux[k] = array[k];
        }
        // 对两个有序数组A，B进行合并
        for (int k = lo; k < hi; k++) {
            if (i > mid) array[k] = array[j++];  // 如果A已经遍历完，取B数组的元素
            else if (j > hi) array[k] = array[i++]; // 如果B已经遍历完，取A数组的元素
            else if (less(aux[i], aux[j])) array[k] = aux[i++];  // 如果对应A的元素小于B，取A的元素
            else array[k] = aux[j++];  // 如果对应B的元素小于A，取B的元素
        }
    }
}
