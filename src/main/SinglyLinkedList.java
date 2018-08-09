package main;

import java.util.HashMap;
import java.util.Map;

public class SinglyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private LoopResult<E> loopResult = new LoopResult<>(false, null);


    public void add(E element) {
        final Node<E> l = tail;
        final Node<E> newNode = new Node<E>(element);
        tail = newNode;
        if (head == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
    }

    public void addNode(Node<E> node, Node<E> nextNode) {
        final Node<E> l = tail;
        if (head == null) {
            head = node;
        } else {
            l.next = node;
        }
        node.next = nextNode;
    }

    public Node<E> getNode(int i){
        Node<E> result = head;
        int j=0;
        while (j!=i){
           result = result.next;
           j++;
        }
        return result;
    }

    public LoopResult<E> findLoop() {
        if (head == null) {
            loopResult.node = null;
            loopResult.cycleExists = false;
            return  loopResult;
        }

        Node<E> fast = head;
        Node<E> slow = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                fast = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                loopResult.node = fast;
                loopResult.cycleExists = true;
                return  loopResult;
            }
        }
        loopResult.node = null;
        loopResult.cycleExists = false;
        return  loopResult;
    }

    public Node<E> findNextNodeAfterLoop(){
        if (head == null) {
            return  null;
        }

        if (!loopResult.cycleExists){
            return null;
        }

        Node<E> result = head;
        Node<E> nextAfterLoop = head;

        while(true){
            if(loopResult.node.equals(result)){
              break;
            }
            nextAfterLoop = result;
            result = result.next;
        }

        return nextAfterLoop;
    }
}


