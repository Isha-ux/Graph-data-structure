package practiseJavaprogram.Graphs;

import java.util.*;

public class CycleDetectionInUndirectedGraph {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    // creating graph---->>
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        // graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        // graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
    }

    // O(V+E)-->
    public static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean vis[], int curr, int parent) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);// e.dest
            if (vis[e.dest] && e.dest != parent) {
                return true;// 1st condition
            } else if (!vis[e.dest]) {
                if (isCycleUndirected(graph, vis, e.dest, curr)) {
                    return true;// 3rd condition
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // System.out.println(isCycleUndirected(graph, new boolean[V], 0, -1));
        if (isCycleUndirected(graph, new boolean[V], 0, -1)) {
            System.out.println("True. Cycle exists in this graph!!");
        } else {
            System.out.println("False. Cycle doesn't exists in this graph");
        }

    }
}
