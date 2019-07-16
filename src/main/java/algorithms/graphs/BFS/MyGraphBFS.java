package algorithms.graphs.BFS;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class MyGraphBFS {

    private int V; // num of verticies

    private LinkedList<Integer> adj[]; // Adj List

    MyGraphBFS (int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int one, int two) {
        adj[one].add(two);
    }

    // BFS traversal from a given source s
    // create visited array
    // create queue to keep order of traversal
    // add first vertex to queue nad mark visited
    // go through queue one by one and process element of queue
    // for every element in the queue check adj vertecies if they are visited and if not add them to queue

//    public void BFS(int s) {
//        boolean[] visited = new boolean[V];
//
//        LinkedList<Integer> queue = new LinkedList<>();
//        queue.add(s);
//        visited[s] = true;
//
//        while(!queue.isEmpty()) {
//            int node = queue.poll();
//            System.out.println(node);
//
//            Iterator<Integer> iterator = adj[node].listIterator();
//            while(iterator.hasNext()) {
//                int n = iterator.next();
//                if (!visited[n]) {
//                    queue.add(n);
//                    visited[n] = true;
//                }
//            }
//        }
//    }




    public void BFS(int s) {
        // for each node in frontier get nodes into next (nodes reachable from current level)
        // do it if node has not been visited
        // after that is done frontier = next

        int i = 1;

        HashMap<Integer, Integer> parent = new HashMap<>();
        parent.put(s, null);

        HashMap<Integer, Integer> level = new HashMap<>();
        level.put(s, 0);

        ArrayList<Integer> frontier = new ArrayList(s);
        frontier.add(s);

        while (!frontier.isEmpty()) {
            ArrayList<Integer> next = new ArrayList();

            Iterator<Integer> it = frontier.listIterator();
            while (it.hasNext()) {
                Integer node = it.next();
                Iterator<Integer> iterator = adj[node].listIterator();
                while (iterator.hasNext()) {
                    Integer nextNode = iterator.next();
                    if (!parent.containsKey(nextNode)) {
                        next.add(nextNode);
                        parent.put(nextNode, node);
                        level.put(nextNode, i);
                    }
                }
            }
            frontier = next;
            i += 1;

        }
        System.out.println(parent.toString() + level.toString());
    }



}
