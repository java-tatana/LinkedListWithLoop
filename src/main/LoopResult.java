package main;

public class LoopResult<E> {
    boolean cycleExists;
    Node<E> node;

    public LoopResult(boolean cycleExists, Node<E> node) {
        this.cycleExists = cycleExists;
        this.node = node;
    }

    public boolean isCycleExists() {
        return cycleExists;
    }

    public Node<E> getNode() {
        return node;
    }

    @Override
    public String toString() {
        return "LoopResult{" +
                "cycleExists=" + cycleExists +
                ", node=" + node.element +
                '}';
    }
}
