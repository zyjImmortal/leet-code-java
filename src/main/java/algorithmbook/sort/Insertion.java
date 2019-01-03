package algorithmbook.find;

public class Insertion extends Sort {

    @Override
    public void sort(Comparable[] array) {
        for (int i = 1; i < array.length ; i++) {
            for (int j = i; j >= 1 && less(array[j], array[j-1]) ; j--) {
                exch(array, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] array = {3,2,6,72,4};
        Insertion insertion = new Insertion();
        insertion.sort(array);
        insertion.show(array);
    }
}
