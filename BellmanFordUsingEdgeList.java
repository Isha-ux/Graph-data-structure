
import java.util.ArrayList;
//import java.util.List;

public class BellmanFordUsingEdgeList {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph) {

        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        graph.add(new Edge(1, 2, -4));

        graph.add(new Edge(2, 3, 2));

        graph.add(new Edge(3, 4, 4));

        graph.add(new Edge(4, 1, -10));
    }

    public static void bellmanFord(ArrayList<Edge> graph, int src, int V) {
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for (int k = 0; k < V - 1; k++) {// O(V)

            for (int j = 0; j < graph.size(); j++) {// O(E)
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {
                    dist[v] = dist[u] + e.wt;
                }
            }
        }

        // detect negative wt cycle-->
        for (int j = 0; j < graph.size(); j++) {// O(V)
            Edge e = graph.get(j);
            int u = e.src;
            int v = e.dest;
            // int wt = e.wt;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {
                System.out.println("Negative weight cycle found!!");
                break;
            }
        }

        System.out.print("The shortest path distance for this graph is: ");
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);
        bellmanFord(graph, 0, V);
    }

}
