package edu.laplateforme.mazerunner.maze;

import edu.laplateforme.mazerunner.generator.optimized.OptimizedImperfectMazeGenerator;
import edu.laplateforme.mazerunner.generator.optimized.OptimizedPerfectMazeGenerator;
import edu.laplateforme.mazerunner.generator.simple.SimpleImperfectMazeGenerator;
import edu.laplateforme.mazerunner.generator.simple.SimplePerfectMazeGenerator;

public class MazeHandler {
    public static void optionArg(int width, int height, String algorithm) {
        try {
            switch (algorithm) {
                case "perfectsimple":
                    SimplePerfectMazeGenerator simplePerfectMazeGenerator = new SimplePerfectMazeGenerator();
                    MazePrinter.printMaze(simplePerfectMazeGenerator.generateMaze(width, height));
                    break;
                case "imperfectsimple":
                    SimpleImperfectMazeGenerator simpleImperfectMazeGenerator = new SimpleImperfectMazeGenerator();
                    MazePrinter.printMaze(simpleImperfectMazeGenerator.generateMaze(width, height));
                    break;
                case "perfectoptimized":
                    OptimizedPerfectMazeGenerator optimizedPerfectMazeGenerator = new OptimizedPerfectMazeGenerator();
                    MazePrinter.printMaze(optimizedPerfectMazeGenerator.generateMaze(width, height));
                    break;
                case "imperfectoptimized":
                    OptimizedImperfectMazeGenerator optimizedImperfectMazeGenerator = new OptimizedImperfectMazeGenerator();
                    MazePrinter.printMaze(optimizedImperfectMazeGenerator.generateMaze(width, height));
                    break;
                default:
                    System.out.println("java -jar MazeRunner.jar " +
                            "[largeur] [hauteur] " +
                            "[perfect/imperfect] " +
                            "[simple/graph/optimized]");
                    break;
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Erreur inattendue lors de la génération du labyrinthe. Veuillez réessayer.");
        }
    }
}
