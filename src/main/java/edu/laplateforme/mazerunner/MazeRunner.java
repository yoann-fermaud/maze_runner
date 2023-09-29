package edu.laplateforme.mazerunner;

import edu.laplateforme.mazerunner.maze.MazeHandler;

public class MazeRunner {

    public static void main(String[] args) {
        int width, height;
        String algorithm = args[2].toLowerCase() + args[3].toLowerCase();

        try {
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.out.println("""
                    Erreur: Veuillez fournir une largeur et une hauteur valides supérieurs à 5.
                    Java(1):
                    java -jar MazeRunner.jar [largeur] [hauteur] [perfect/imperfect] [simple/graph/optimized]
                    """);
            return;
        }

        if (width < 5 || height < 5) {
            System.out.println("""
                    Erreur: Veuillez fournir une largeur et une hauteur valides supérieurs à 5.
                    Java(1):
                    java -jar MazeRunner.jar [largeur] [hauteur] [perfect/imperfect] [simple/graph/optimized]
                    """);
        } else if (args.length != 4) {
            System.out.println("""
                    Erreur: Veuillez fournir un type de labyrinthe et une méthode de génération valides
                    Java(1):
                    java -jar MazeRunner.jar [largeur] [hauteur] [perfect/imperfect] [simple/graph/optimized]
                    """);
        } else {
            MazeHandler.optionArg(width, height, algorithm);
        }
    }
}
