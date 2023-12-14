
public class RottenOrangesUsingDFS {
    public static void DFS(int grid[][], int i, int j, int ROW, int COL) {
        if (i < 0 || j < 0 || i > (ROW - 1) || j > COL - 1 || grid[i][j] != 1) {
            return;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = 2;
            DFS(grid, i + 1, j, ROW, COL);// right side traversal
            DFS(grid, i - 1, j, ROW, COL);// left side traversal
            DFS(grid, i, j + 1, ROW, COL);// upward side traversal
            DFS(grid, i, j - 1, ROW, COL);// downward side traversal

        }

    }

    public static int countIsland(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int time = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1) {
                    time++;
                    DFS(grid, i, j, ROW, COL);// traversal starts from the current cell
                }
            }
        }
        return time;
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 },
                { 1, 1, 0 },
                { 1, 1, 1 } };

        System.out.println("minimum time required to rotten all oranges is: " + countIsland(grid) + "sec");
    }
}