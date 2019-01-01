package algorithmbook.sort;

public class Shell extends Sort {
    @Override
    public void sort(Comparable[] array) {
        int n = array.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;
        while (h >= 1){
            for (int i = h; i < n ; i++) {
                for (int j = i; j >= h && less(array[j], array[j - h]) ; j-=h) {
                    exch(array, j, j -h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Comparable[] array = {3,2,6,72,4,100,2,3,99,2,0,3,55,2,32,445,12,12,3123,14};
        Shell shell = new Shell();
        shell.sort(array);
        shell.show(array);
    }
}
