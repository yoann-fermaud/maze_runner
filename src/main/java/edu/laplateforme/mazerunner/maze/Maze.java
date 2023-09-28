package edu.laplateforme.mazerunner.maze;

public class Maze {
    private boolean[][] cells;
    private boolean[][] visited; // Ajoutez cette matrice

    public Maze(int width, int height) {
        int cellWidth = width * 3;
        int cellHeight = height * 3;
        cells = new boolean[cellWidth][cellHeight];
        for (int i = 0; i < cellWidth; i++) {
            for (int j = 0; j < cellHeight; j++) {
                cells[i][j] = true;
            }
        }

        visited = new boolean[cellWidth][cellHeight];
        for (int i = 0; i < cellWidth; i++) {
            for (int j = 0; j < cellHeight; j++) {
                visited[i][j] = false; // Toutes les cellules sont initialement non visitées
            }
        }
    }

    public int getWidth() {
        return cells.length;
    }

    public int getHeight() {
        return cells[0].length;
    }

    public boolean isValidCell(int i, int j) {
        return i >= 0 && i < cells.length && j >= 0 && j < cells[0].length;
    }

    public void setWall(int i, int j, boolean b) {
        if (isValidCell(i, j)) {
            cells[i][j] = b;
        }
    }

    public boolean isWall(int i, int j) {
        if (isValidCell(i, j)) {
            return cells[i][j];
        }
        return false;
    }

    public void setVisited(int x, int y, boolean value) {
        visited[x][y] = value;
    }

    public boolean isVisited(int x, int y) {
        return visited[x][y];
    }
}
