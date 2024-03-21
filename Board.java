public class Board {
    private int[][] grid;
    private int rowAndCol;
    private int gridSize;

    public Board(int rowAndCol) {
        this.rowAndCol = rowAndCol;
        this.gridSize = rowAndCol * rowAndCol;
        this.grid = new int[rowAndCol][rowAndCol];
    }

    public int getGridSize() {
        return gridSize;
    }

    public boolean isLegalMove(int x, int y) {
        // Adjust x and y to be 0-based for the grid
        int gridX = x - 1;
        int gridY = y - 1;

        if (gridX >= 0 && gridX < rowAndCol && gridY >= 0 && gridY < rowAndCol && grid[gridX][gridY] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValid(int x, int y) {
        if (x >= 0 && x < rowAndCol && y >= 0 && y < rowAndCol) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isGridFull() {
        for (int i = 0; i < rowAndCol; i++) {
            for (int j = 0; j < rowAndCol; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void addNumberToBoard(int x, int y, int randomNum) {
        if (isLegalMove(x, y)) {
            grid[x - 1][y - 1] = randomNum;
        }
    }

    public int scoreRow(int[][] grid) {
        int sum = 0;
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j<grid[0].length; j++) {
                if ((isValid(i-1, j) && grid[i-1][j] == grid[i][j]) || (isValid(i+1, j) && grid[i+1][j] == grid[i][j])){
                    sum += grid[i][j];
                }
            }
        }
        return sum;
    }

    public int scoreCol(int[][] grid) {
        int sum = 0;
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j<grid[0].length; j++) {
                if ((isValid(i, j-1) && grid[i][j-1] == grid[i][j]) || (isValid(i, j+1) && grid[i][j+1] == grid[i][j])) {
                    sum += grid[i][j];
                }
            }
        }
        return sum;
    }

    public int finalScore() {
        return scoreRow(grid) + scoreCol(grid);
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < rowAndCol; i++) {
            for (int j = 0; j < rowAndCol; j++) {
                output += grid[i][j] + " ";
            }
            output += "\n";
        }
        return output;
    }
}
