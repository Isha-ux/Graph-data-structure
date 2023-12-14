package practiseJavaprogram.Graphs;

import java.util.*;

public class EventualSafeStates {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[4].add(new Edge(4, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 1));

        /*
         * graph[0].add(new Edge(0, 1));
         * graph[0].add(new Edge(0, 2));
         *
         * graph[1].add(new Edge(1, 2));
         * graph[1].add(new Edge(1, 3));
         *
         * graph[2].add(new Edge(2, 5));
         *
         * graph[3].add(new Edge(3, 0));
         *
         * graph[4].add(new Edge(4, 5));
         */

        /*
         * graph[0].add(new Edge(0, 1));
         * graph[1].add(new Edge(1, 2));
         * graph[2].add(new Edge(2, 0));
         * graph[2].add(new Edge(2, 3));
         */

    }

    public static boolean dfs_Cycle(ArrayList<Edge> graph[], int curr, int vis[], int rec[]) {
        vis[curr] = 1;
        rec[curr] = 1;
        // check[curr] = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[i] == 0) {
                if (dfs_Cycle(graph, i, vis, rec))
                    return true;

            } else if (rec[i] == 1) {
                return true;
            }
        }
        // check[curr] = 1;
        rec[curr] = 0;
        return false;
    }

    public static ArrayList<Integer> eventualSafeNodes(ArrayList<Edge> graph[], int V) {// O(V^2)
        int vis[] = new int[V];
        int rec[] = new int[V];
        // int check[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs_Cycle(graph, i, vis, rec);
            }
        }
        ArrayList<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 1 && rec[i] == 0)
                safeNodes.add(i);

        }

        return safeNodes;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        ArrayList<Integer> safeNodes = eventualSafeNodes(graph, V);
        System.out.print("The safe nodes are: " + safeNodes);
    }

}
