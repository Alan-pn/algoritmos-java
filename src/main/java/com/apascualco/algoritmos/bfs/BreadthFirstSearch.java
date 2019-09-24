package com.apascualco.algoritmos.bfs;

import java.util.*;

import static java.util.Objects.isNull;

public class BreadthFirstSearch {

    private final Queue<Node> nodes = new LinkedList<>();
    private final List<Node> visited = new LinkedList<>();

    Optional<Node> search(final int[] initialState, final int[] finalState) {
        if(isNull(initialState)) {
            throw new NullPointerException("initialState shouldn't be null");
        }
        if(isNull(finalState)) {
            throw new NullPointerException("finalState shouldn't be null");
        }
        boolean foundFinalState = false;
        Optional<Node> foundNode = Optional.empty();
        final Node root = Node.of(initialState);
        nodes.add(root);
        
        while(!foundFinalState && nodes.size() != 0) {
            final Node node = nodes.poll();
            visited.add(node);
            if(Arrays.equals(node.getState(), finalState)) {
                foundFinalState = true;
                foundNode = Optional.of(node);
            } else {
                int[] nodeState = node.getState();
                this.processChild(new int[]{nodeState[1],nodeState[0],nodeState[2],nodeState[3]}, node);
                this.processChild(new int[]{nodeState[0],nodeState[2],nodeState[1],nodeState[3]}, node);
                this.processChild(new int[]{nodeState[0],nodeState[1],nodeState[3],nodeState[2]}, node);
            }
        }
        return foundNode;
    }

    private void processChild(final int[] state, final Node node) {
        final Node nodeChild = Node.of(state);
        nodeChild.setParent(node);
        if(!nodes.contains(nodeChild) && !visited.contains(nodeChild)) {
            nodes.add(nodeChild);
        }
    }

    public static void main(String[] args) {
        int[] estadoInicial = new int[]{4,2,3,1};
        int[] estadoFinal = new int[]{1,2,3,4};
        final BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        long initialTime = System.currentTimeMillis();
        final Node nodeSolucion = breadthFirstSearch.search(estadoInicial, estadoFinal).orElseThrow(NullPointerException::new);
        breadthFirstSearch.printSolution(nodeSolucion, (System.currentTimeMillis()-initialTime));

    }

    private void printSolution(final Node solution, long timeElapsed) {
        boolean parentNull = false;
        Node actualNode = solution;
        final List<String> estados = new LinkedList<>();
        while(!parentNull) {
            estados.add(actualNode.toString());
            if(isNull(actualNode.getParent())) {
                parentNull = true;
            }
            actualNode = actualNode.getParent();
        }
        Collections.reverse(estados);
        System.out.println("Solution in: " + estados.size() + " levels [" + String.join(",", estados) + "] time: " + timeElapsed + "ms");
    }
}
