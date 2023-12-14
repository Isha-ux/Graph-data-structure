import java.util.*;

public class CourseSchedule {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> prerequisite[]) {
        for (int i = 0; i < prerequisite.length; i++) {
            prerequisite[i] = new ArrayList<Edge>();
        }

        /*
         * prerequisite[1].add(new Edge(1, 2));
         * prerequisite[2].add(new Edge(2, 4));
         * prerequisite[4].add(new Edge(4, 1));
         * prerequisite[4].add(new Edge(4, 3));
         */

        prerequisite[1].add(new Edge(1, 0));
        prerequisite[2].add(new Edge(2, 1));
        prerequisite[2].add(new Edge(2, 3));

        // prerequisite[1].add(new Edge(1, 0));
        // prerequisite[0].add(new Edge(0, 1));

    }

    // modified dfs-->>
    // for directed graph using dfs
    static boolean dfs_Cycle(ArrayList<Edge> prerequisite[], int curr, boolean rec[], boolean vis[]) {

        if (vis[curr]) {
            return false;
        }

        rec[curr] = vis[curr] = true;
        for (int i = 0; i < prerequisite[curr].size(); i++) {
            Edge e = prerequisite[curr].get(i);
            if (rec[e.dest]) {
                return true;
            } else if (!vis[e.dest]) {
                if (dfs_Cycle(prerequisite, e.dest, rec, vis)) {
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }

    static boolean CanFinish(int numCourses, ArrayList<Edge> prerequisite[], boolean rec[], boolean vis[]) {
        // boolean rec[] = new boolean[numCourses];
        // boolean vis[] = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i] && dfs_Cycle(prerequisite, i, new boolean[numCourses], new boolean[numCourses])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 5;
        ArrayList<Edge> prerequisite[] = new ArrayList[numCourses];
        createGraph(prerequisite);
        // int prerequisite[][] = { { 1, 2 }, { 4, 3 }, { 2, 4 }, { 4, 1 } };
        // System.out.println(canFinish(prerequisite, numCourses));
        if (CanFinish(numCourses, prerequisite, new boolean[numCourses], new boolean[numCourses])) {
            System.out.println("Courses can finish all");
        } else {
            System.out.println("OOPS! Can't finish all courses!!");
        }
    }
}
