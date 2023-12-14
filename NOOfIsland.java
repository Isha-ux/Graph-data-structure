
public class NOOfIsland {// O(ROW*COL)

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
            DFS(grid, i + 1, j + 1, ROW, COL);// upward-right side traversal
            DFS(grid, i - 1, j - 1, ROW, COL);// downward-left side traversal
            DFS(grid, i + 1, j - 1, ROW, COL);// downward-right side traversal
            DFS(grid, i - 1, j + 1, ROW, COL);// upward-left side traversal
        }

    }

    public static int countIsland(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        int count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    DFS(grid, i, j, ROW, COL);// traversal starts from the current cell
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };

        System.out.println("Number of islands are: " + countIsland(grid));
    }
}
