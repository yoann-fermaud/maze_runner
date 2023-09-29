package edu.laplateforme.mazerunner.generator.optimized;

import edu.laplateforme.mazerunner.generator.MazeGenerator;
import edu.laplateforme.mazerunner.maze.Maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class OptimizedImperfectMazeGenerator implements MazeGenerator {

    private static final Random random = new Random();

    @Override
    public Maze generateMaze(int width, int height) {
        Maze maze = new Maze(width, height);
        Stack<Cell> stack = new Stack<>();

        // -----------------------------------------------------------------------
        maze.setWall(0, 1, false);
        stack.push(new Cell(0, 1));

        int endX = maze.getWidth() - 1;
        int endY = maze.getHeight() - 2;
        maze.setWall(endX, endY, false);
        stack.push(new Cell(endX, endY));
        // -----------------------------------------------------------------------
        maze.setWall(1, 1, false);
        stack.push(new Cell(1, 1));
        // -----------------------------------------------------------------------
        while (!stack.isEmpty()) {
            Cell current = stack.pop();

            int x = current.x;
            int y = current.y;
            Cell[] neighbors = getUnvisitedNeighbors(maze, x, y);

            if (neighbors.length > 0) {
                stack.push(current);
                Cell next = neighbors[random.nextInt(neighbors.length)];
                // -----------------------------------------------------------------------
                if (x == next.x && y < next.y) {
                    maze.setWall((x + next.x) / 2, (y + next.y) / 2, false);
                    maze.setWall(next.x, next.y - 1, false);
                    maze.setWall(next.x, next.y, false);
                } else if (x == next.x && y > next.y) {
                    maze.setWall(next.x, next.y + 1, false);
                    maze.setWall(next.x, next.y + 2, false);
                    maze.setWall(next.x, next.y, false);
                }
                // -----------------------------------------------------------------------
                if (y == next.y && x < next.x) {
                    maze.setWall((x + next.x) / 2, (y + next.y) / 2, false);
                    maze.setWall(next.x - 1, next.y, false);
                    maze.setWall(next.x, next.y, false);
                } else if (y == next.y && x > next.x) {
                    maze.setWall(next.x + 1, next.y, false);
                    maze.setWall(next.x + 2, next.y, false);
                    maze.setWall(next.x, next.y, false);
                }
                stack.push(next);
            }
        }
        return maze;
    }


    private Cell[] getUnvisitedNeighbors(Maze maze, int x, int y) {
        int[][] directions = {{3, 0}, {-3, 0}, {0, 3}, {0, -3}};
        int width = maze.getWidth();
        int height = maze.getHeight();

        List<Cell> neighbors = new ArrayList<>();
        int i = 0;
        while (i < directions.length) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];

            if (isWithinBounds(nx, ny, width, height) && maze.isWall(nx, ny)) {
                neighbors.add(new Cell(nx, ny));
            }
            i++;
        }
        return neighbors.toArray(new Cell[0]);
    }


    private boolean isWithinBounds(int x, int y, int width, int height) {
        return x >= 1 && x < width - 1 && y >= 1 && y < height - 1;
    }

    private class Cell {
        int x;
        int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
