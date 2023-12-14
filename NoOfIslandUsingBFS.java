import java.util.LinkedList;
import java.util.Queue;

//import java.util.*;
public class NoOfIslandUsingBFS {
    static int R = 5;
    static int C = 5;

    static class Pair {
        int row;
        int col;

        public Pair(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    public static boolean isSafe(int grid[][], int i, int j, boolean vis[][]) {
        if (i >= 0 && i < R && j >= 0 && j < C && grid[i][j] == 1 && !vis[i][j]) {
            return true;
        }
        return false;
    }

    public static void BFS(int grid[][], boolean vis[][], int s, int d) {
        int ROW[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int COL[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(s, d));
        vis[s][d] = true;
        while (!q.isEmpty()) {
            int i = q.peek().row;
            int j = q.peek().col;
            q.remove();
            for (int k = 0; k < 8; k++) {
                if (isSafe(grid, i + ROW[k], j + COL[k], vis)) {
                    vis[i + ROW[k]][j + COL[k]] = true;
                    q.add(new Pair(i + ROW[k], j + ROW[k]));
                }
            }
        }
    }

    public static int countIsland(int grid[][]) {
        boolean vis[][] = new boolean[R][C];
        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    BFS(grid, vis, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int grid[][] = { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        int ans = countIsland(grid);
        System.out.println("No.OF island are: " + ans);
    }
}
