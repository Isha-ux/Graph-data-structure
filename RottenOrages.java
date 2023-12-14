
import java.util.*;

public class RottenOrages {// this solution using BFS can be done using DFS also
    static class Pair {
        int row;
        int col;
        int tm;

        public Pair(int r, int c, int t) {
            this.row = r;
            this.col = c;
            this.tm = t;
        }

        // function for rotten oranges-->>
        public static int RottingOranges(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            Queue<Pair> q = new LinkedList<>();
            int[][] vis = new int[n][m];
            int cntFresh = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 2) {
                        q.add(new Pair(i, j, 0));
                        vis[i][j] = 2;

                    } else {
                        vis[i][j] = 0;
                    }
                    if (grid[i][j] == 1) {
                        cntFresh++;
                    }
                }
            }
            int tm = 0;
            int drow[] = { -1, 0, 1, 0 };
            int dcol[] = { 0, 1, 0, -1 };
            int count = 0;
            while (!q.isEmpty()) {
                int r = q.peek().row;
                int c = q.peek().col;
                int t = q.peek().tm;
                tm = Math.max(tm, t);
                q.remove();
                for (int i = 0; i < 4; i++) {
                    int nrow = r + drow[i];
                    int ncol = c + dcol[i];
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                            && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                        q.add(new Pair(nrow, ncol, t + 1));
                        vis[nrow][ncol] = 1;
                        count++;
                    }

                }
            }
            if (count != cntFresh) {
                return -1;
            }
            return tm;
        }

        public static void main(String[] args) {
            int grid[][] = { { 0, 1, 2 },
                    { 0, 1, 1 },
                    { 2, 1, 1 } };
            int ans = RottingOranges(grid);
            if (ans == -1) {
                System.out.println("All oranges cannot rot.");
            } else {
                System.out.println("Time required for all oranges to rot is :=>" + ans + "sec");
            }
        }
    }
}
