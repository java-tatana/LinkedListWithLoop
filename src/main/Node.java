package main;

public class Node<E> {

     E element;
     Node<E> next;

    public E getElement() {
        return element;
    }

    public Node<E> getNext() {
        return next;
    }

    public Node(E element) {
        this.element = element;
    }
}
