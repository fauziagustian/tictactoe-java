public class Board {
    private char[][] grid;
    private int size;

    public Board(int size) {
        this.size = size;
        grid = new char[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean placeMark(int row, int col, char mark) {
        if (row < 0 || row >= size || col < 0 || col >= size || grid[row][col] != '-') {
            return false;
        }
        grid[row][col] = mark;
        return true;
    }

    public char checkForWin(int winCondition) {
        // Check rows
        for (int i = 0; i < size; i++) {
            if (grid[i][0] != '-' && allEqual(grid[i], winCondition)) {
                return grid[i][0];
            }
        }

        // Check columns
        for (int j = 0; j < size; j++) {
            if (grid[0][j] != '-' && allEqual(getColumn(j), winCondition)) {
                return grid[0][j];
            }
        }

        // Check diagonals
        if (grid[0][0] != '-' && allEqual(getDiagonal(true), winCondition)) {
            return grid[0][0];
        }
        if (grid[0][size - 1] != '-' && allEqual(getDiagonal(false), winCondition)) {
            return grid[0][size - 1];
        }

        // No winner
        return '-';
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private char[] getColumn(int col) {
        char[] column = new char[size];
        for (int i = 0; i < size; i++) {
            column[i] = grid[i][col];
        }
        return column;
    }

    private char[] getDiagonal(boolean leftToRight) {
        char[] diagonal = new char[size];
        if (leftToRight) {
            for (int i = 0; i < size; i++) {
                diagonal[i] = grid[i][i];
            }
        } else {
            for (int i = 0; i < size; i++) {
                diagonal[i] = grid[i][size - 1 - i];
            }
        }
        return diagonal;
    }

    private boolean allEqual(char[] array, int winCondition) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[0] || array[0] == '-') {
                return false;
            }
        }
        return true;
    }
}
