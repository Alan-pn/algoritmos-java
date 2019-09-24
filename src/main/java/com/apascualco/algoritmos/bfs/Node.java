package com.apascualco.algoritmos.bfs;

import java.util.Arrays;

public final class Node {

    private int[] state;
    private Node parent;

    @SuppressWarnings("unused")
    private Node() { }

    private Node(final int[] state) {
        this.state = state;
    }

    static Node of(final int[] dato) {
        return new Node(dato);
    }

    int[] getState() {
        return state;
    }

    Node getParent() {
        return parent;
    }

    void setParent(final Node parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Node node = (Node) object;
        return Arrays.equals(this.state, node.state);

    }

    @Override
    public String toString() {
        return Arrays.toString(this.getState());
    }
}
