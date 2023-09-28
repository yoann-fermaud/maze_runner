package edu.laplateforme.mazerunner.generator;

import edu.laplateforme.mazerunner.maze.Maze;

public interface MazeGenerator {
    Maze generateMaze(int width, int height);
}
