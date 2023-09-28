package edu.laplateforme.mazerunner;


import edu.laplateforme.mazerunner.generator.simple.SimpleImperfectMazeGenerator;
import edu.laplateforme.mazerunner.generator.simple.SimplePerfectMazeGenerator;
import edu.laplateforme.mazerunner.maze.Maze;
import edu.laplateforme.mazerunner.maze.MazePrinter;

public class MazeRunner {
    public static void main(String[] args) {
        Maze maze = generateMaze(10, 10);
        MazePrinter.printMaze(maze);
    }

    private static Maze generateMaze(int width, int height) {
//        SimpleImperfectMazeGenerator simpleImperfectMazeGenerator = new SimpleImperfectMazeGenerator();
//        return simpleImperfectMazeGenerator.generateMaze(width, height);
        SimplePerfectMazeGenerator simplePerfectMazeGenerator = new SimplePerfectMazeGenerator();
        return simplePerfectMazeGenerator.generateMaze(width, height);
    }
}
