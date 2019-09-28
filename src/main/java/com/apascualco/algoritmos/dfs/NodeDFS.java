package com.apascualco.algoritmos.dfs;

import java.util.Arrays;

public final class NodeDFS {

    private int[] state;
    private NodeDFS parent;

    @SuppressWarnings("unused")
    private NodeDFS() { }

    private NodeDFS(final int[] state) {
        this.state = state;
    }

    static NodeDFS of(final int[] dato) {
        return new NodeDFS(dato);
    }

    int[] getState() {
        return state;
    }

    NodeDFS getParent() {
        return parent;
    }

    void setParent(final NodeDFS parent) {
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
        NodeDFS nodeBFS = (NodeDFS) object;
        return Arrays.equals(this.state, nodeBFS.state);

    }

    @Override
    public String toString() {
        return Arrays.toString(this.getState());
    }
}
