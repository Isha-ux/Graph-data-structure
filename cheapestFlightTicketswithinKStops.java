
import java.util.*;

public class cheapestFlightTicketswithinKStops {

    static class Edge {
        int src;
        int wt;

        public Edge(int s, int w) {
            this.src = s;
            this.wt = w;
        }
    }

    static class Tuple {
        int stops;
        int node;
        int cost;

        public Tuple(int s, int n, int c) {
            this.stops = s;
            this.node = n;
            this.cost = c;
        }
    }

    public static int cheapestFlight(int V, int flight[][], int src, int dest, int k) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        int n = flight.length;
        for (int i = 0; i < n; i++) {
            graph.get(flight[i][0]).add(new Edge(flight[i][1], flight[i][2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = (int) (1e9);
        }
        dist[src] = 0;
        while (!q.isEmpty()) {
            Tuple tu = q.peek();
            q.remove();
            int stops = tu.stops;
            int node = tu.node;
            int cost = tu.cost;
            if (stops > k) {
                continue;
            }

            for (Edge e : graph.get(node)) {
                int u = e.src;
                int v = e.wt;
                if (cost + v < dist[u] && stops <= k) {
                    dist[u] = cost + v;
                    q.add(new Tuple(stops + 1, u, cost + v));
                }
            }
        }

        if (dist[dest] == (int) (1e9)) {
            return -1;
        }

        return dist[dest];
    }

    public static void main(String[] args) {
        int V = 4, src = 0, dest = 3, k = 1;
        int[][] flight = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        System.out.print("The cheaapest flights cost is: " + cheapestFlight(V, flight, src, dest, k));
    }
}
