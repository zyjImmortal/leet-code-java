package stack;

import linked.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<E>();

    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }
    @Override
    public E pop() {
        return linkedList.removeLast();
    }
    @Override
    public E peek() {
        return linkedList.get(0);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top");
        res.append(linkedList);
        return res.toString();
    }

    public static void main(String[] args){
        LinkedListStack<Integer> linkedList = new LinkedListStack<Integer>();
        for (int i = 0; i < 10; i++) {
            linkedList.push(i);
            System.out.println(linkedList);
        }
        linkedList.push(44);
        System.out.println(linkedList);
        linkedList.pop();
        System.out.println(linkedList);
    }
}
