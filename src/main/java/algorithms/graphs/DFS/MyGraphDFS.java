package algorithms.graphs.DFS;

import java.util.*;

public class MyGraphDFS {

    private int V;
    private LinkedList[] adj;

    MyGraphDFS(int v) {
        this.V = v;
        this.adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int one, int two) {
        adj[one].add(two);
    }


    // DFS using Stack
//    public void DFS(int s) {
//        // create visited DS
//        // add s to stack
//        // pop off stack and process
//        // while stack is not empty add adj nodes to s to stack if not visited
//
//        boolean[] visited = new boolean[this.V];
//        ArrayDeque<Integer> stack = new ArrayDeque<>();
//        stack.push(s);
//        visited[s] = true;
//
//        while (!stack.isEmpty()) {
//            Integer node = stack.pop();
//            System.out.println(node);
//            Iterator<Integer> iterator = adj[node].listIterator();
//            while (iterator.hasNext()) {
//                Integer next = iterator.next();
//                if (!visited[next]) {
//                    stack.push(next);
//                    visited[next] = true;
//                }
//            }
//        }
//    }




    // DFS using Recursion, for all nodes, Topological sort
    public void DFS() {
        // create DS for visited, hash to keep track of parent
        // for every node is the Graph run DFSvisit if not visited
        HashMap<Integer, Integer> parent = new HashMap<>();
        for (int i = 0; i < adj.length; i++) {
            if (!parent.containsKey(i)) {
                DFSvisit(i, parent);
            }


        }

    }



    private void DFSvisit(int s, HashMap<Integer, Integer> parent) {
        // if not visited recursively visit all adj nodes
        if (!parent.containsKey(s)) {
            parent.put(s, null);
            System.out.println(s);
            Iterator<Integer> iterator = adj[s].listIterator();
            while (iterator.hasNext()) {
                Integer node = iterator.next();
                DFSvisit(node, parent);
            }
        }


    }


}
