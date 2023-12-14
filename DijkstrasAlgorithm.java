

import java.util.PriorityQueue;
import java.util.ArrayList;

public class DijkstrasAlgorithm {

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

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static class Pair implements Comparable<Pair> {// interface//to tell the pq to sort the nodes based on the
                                                          // distance used Compareble<Pair> and created its constructor
        int node;
        int dist;

        public Pair(int n, int d) {
            this.node = n;
            this.dist = d;
        }

        @Override // we have override the the properties of [interface comparable] through class
                  // [compareTo()]
        public int compareTo(Pair p2) {// this function returns 1]positive value---greater Pair 2]0 value--equal pair
                                       // 3]negative value--small pair
            return this.dist - p2.dist;// ascending order sorting
            // return p2.dist-this.dist;//for descending order sorting
        }
    }

    // O(E + ElogV)->1] ElogV by pq and 2] E-> by traversing on all edges
    public static void dijkstras(ArrayList<Edge> graph[], int src, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;// infinity
            }
        }
        boolean vis[] = new boolean[V];
        pq.add(new Pair(0, 0));
        System.out.print("The shortest distance from source '0' to all vertices is:-->");
        // bfs
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();// shortest
            if (!vis[curr.node]) {
                vis[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if (dist[u] + e.wt < dist[v]) {
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }

        }
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        dijkstras(graph, 0, V);
    }
}
