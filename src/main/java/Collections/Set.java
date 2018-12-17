package Collections;

public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains();
    int getSize();
    boolean isEmpty();
}
