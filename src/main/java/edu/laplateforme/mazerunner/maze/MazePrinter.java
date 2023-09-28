package edu.laplateforme.mazerunner.maze;

public class MazePrinter {
    public static void printMaze(Maze maze) {
        for (int i = 0; i < maze.getWidth(); i++) {
            for (int j = 0; j < maze.getHeight(); j++) {
                System.out.print(maze.isWall(i, j) ? "█" : "0");
            }
            System.out.println();
        }
    }
}
