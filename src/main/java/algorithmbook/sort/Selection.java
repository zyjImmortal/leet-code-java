package algorithmbook.sort;

/**
 * 选择排序的特点：
 *  1、运行时间和输入无关，如果输入的数组是已经排序的或者各个元素是相等，并不会减少运行时间
 *  2、数据移动是最少的：每次交换都会改变两个数组元素的值，因此排序用了N次交换-交换次数和数组的大小是线性关系
 */

public class Selection extends Sort {

    /**
     *
     * @param array
     */
    @Override
    public void sort(Comparable[] array) {

        for (int i = 0; i < array.length ; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], array[min])) min=j;
            }
            exch(array, i, min);
        }
    }

    public static void main(String[] args) {
        Comparable[] array = {3,2,6,72,4};
        Selection selection = new Selection();
        System.out.println(selection.isSorted(array));
        selection.sort(array);
        System.out.println(selection.isSorted(array));
        selection.show(array);
    }
}
