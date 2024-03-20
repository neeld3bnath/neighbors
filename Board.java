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
        int score = 0;
        for (int i = 0; i < rowAndCol; i++) {
            int currentNum = grid[i][0];
            int count = 0;
            for (int j = 1; j < rowAndCol; j++) {
                if (grid[i][j] == currentNum) {
                    count++;
                } else {
                    if (count >= 2) {
                        score += currentNum * count;
                    }
                    currentNum = grid[i][j];
                    count = 1;
                }
            }
            if (count >= 2) {
                score += currentNum * count;
            }
        }
        return score;
    }

    public int scoreCol(int[][] grid) {
        int score = 0;
        for (int j = 0; j < rowAndCol; j++) {
            int currentNum = grid[0][j];
            int count = 1;
            for (int i = 1; i < rowAndCol; i++) {
                if (grid[i][j] == currentNum) {
                    count++;
                } else {
                    if (count >= 2) {
                        score += currentNum * count;
                    }
                    currentNum = grid[i][j];
                    count = 1;
                }
            }
            if (count >= 2) {
                score += currentNum * count;
            }
        }
        return score;
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
