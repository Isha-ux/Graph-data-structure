
import java.util.*;

//using 1]adjacency list----->>
public class DFSforSingleEntityGraph {
    static class Edge {
        int src;
        int dest;
        // int wt

        public Edge(int s, int d /* ,int w */) {
            this.src = s;
            this.dest = d;
            // this.wt=w;

        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();

        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));

    }

    // function for breadth first search O(V+E)
    public static void bfs(ArrayList<Edge> graph[], int V, boolean vis[], int start) {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        System.out.print("The Breadth First Search Sequence is: ");
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (vis[curr] == false) {
                System.out.print(curr + " ");
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // function for DFS depth first algorithm----->>>

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (vis[e.dest] == false) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);// using adjacency list
        /*
         * System.out.println("The neighbours and weight of the vertex 2 are:");
         * // print 2's neighbours
         * for (int i = 0; i < graph[2].size(); i++) {
         * Edge e = graph[2].get(i);
         * System.out.println(e.dest + "," + e.wt);
         * }
         */
        boolean vis[] = new boolean[V];

        /*
         * for (int i = 0; i < V; i++) {
         * if (vis[i] == false) {
         * bfs(graph, V, vis, i);
         * }
         * }
         * System.out.println();
         */

        // for disconnected components of graph oor singleton entity graph for dfs -->
        System.out.print("The depth First Search Sequence is: ");
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                dfs(graph, i, vis);

            }
        }
        // System.out.print("The depth First Search Sequence is: ");
        // dfs(graph, 0, vis);

        System.out.println();

    }
}
