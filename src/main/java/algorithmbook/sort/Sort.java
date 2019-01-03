package algorithmbook.find;

public abstract class Sort {
    public void sort(Comparable[] array) {

    }

    /**
     * 比较大小，如果v小于w返回true，大于返回false
     *
     * @param v
     * @param w
     * @return
     */
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组中元素位置
     *
     * @param array
     * @param i
     * @param j
     */
    public void exch(Comparable[] array, int i, int j) {
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public void show(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * 判断数组是否排序
     *
     * @param array
     * @return
     */
    public boolean isSorted(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            if (less(array[i], array[i - 1])) return false;
        }
        return true;
    }
}
