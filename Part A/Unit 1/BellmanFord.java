// Computer Network Laboratory - CS58L
// 5th Sem 2020-21
// https://github.com/jssstu-lab/computer-networks

// Java program to find the shortest path between vertices using bellman-ford algorithm.

import java.util.*;

class BellmanFord {

    // Input a graph and store it as an adjacency matrix
    static ArrayList<ArrayList<Integer[]>> readGraph(Scanner sc) {
        
        int n = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Integer[]>> graph = new ArrayList<ArrayList<Integer[]>>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer[]>());
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            Integer[] edge = {v, w};
            graph.get(u).add(edge);
        }

        return graph;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Integer[]>> graph = readGraph(sc);

        int n = graph.size();

        int s = sc.nextInt();
        sc.close();

        int[] dist = new int[n];
        Integer[] prev = new Integer[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = null;
        }

        dist[s] = 0;

        // Relax all edges of the graph V-1 times
        for (int i = 1; i < n; i++) {
            for (int source = 0; source < n; source++) {
                for (Integer[] edge: graph.get(source)) {
                    if (dist[edge[0]] > dist[source] + edge[1]) {
                        dist[edge[0]] = dist[source] + edge[1];
                        prev[edge[0]] = source;
                    } 
                }
            }
        }

        boolean nCycle = false;
        
        // If an edge can be relaxed, negative weight cycle detected in graph.
        for (int source = 0; source < n; source++) {
            for (Integer[] edge: graph.get(source)) {
                if (dist[edge[0]] > dist[source] + edge[1]) {
                    nCycle = true;
                    dist[edge[0]] = dist[source] + edge[1];
                    prev[edge[0]] = source;
                }
            }
        }

        if (nCycle) {
            System.out.println("The graph contains negative weight cycle.");
        }
        else {
            System.out.println("The graph does not contain negative weight cycle.");
        }
        
        System.out.println(Arrays.toString(dist));
        System.out.println(Arrays.toString(prev));
    }
}