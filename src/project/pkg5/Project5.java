package project.pkg5;

import java.util.Scanner;

/**
 * Test class for the Maze Class
 * @author harmanjeetdhillon
 */
public class Project5
{
    public static void main(String[] args)
    {
        Scanner sn = new Scanner(System.in);
        menu(); // user menu
        int choice = sn.nextInt(); // user input
        
        // while loop for going through the menu
        while (choice != 4)
        {
            if (choice == 1) // Allows users to input a new maze
            {
                System.out.println("Enter number of Rows:");
                int userRows = sn.nextInt();
                System.out.println("Enter number of Columns:");
                int userCols = sn.nextInt();
                String[][] maze = new String[userRows][userCols];
                
                System.out.println(" ");
                System.out.println("Enter in a Maze with " + userRows
                    + " Rows and " + userCols + " Columns.");
                System.out.println("");
                System.out.println("DISCLAIMER : Only one Beginning, "
                        + "and any number Exits!");
                
                System.out.println(" ");
                System.out.println("Add a \"b\" for the Beginning, \"e\" for "
                        + "the Exits,\"0\" \nfor the path and any character "
                        + "for the walls.");
                for (int i = 0; i < userRows; i++)
                {
                    for (int j = 0; j < userCols; j++)
                    {
                        maze[i][j] = sn.next();
                        
                    }
                }
                // solving the user entered maze
                System.out.println(" ");
                printoutMaze(maze, userRows, userCols);
                System.out.println("---------------");
                Maze mSolver = new Maze(userRows, userCols, maze);
                mSolver.solve(userRows, userCols); // solving
                mSolver.totalSolutions(); // showing total number of solutions
                
                
            }
            if (choice == 2) // solving the generic small maze
            {
                String[][] maze = new String[5][5];
                fillSmallMaze(maze); // filling the maze
                System.out.println(" ");
                System.out.println("SMALL GENERIC MAZE");
                printoutMaze(maze, 5, 5);
                System.out.println("---------------");
                Maze mSolver = new Maze(5, 5, maze);
                mSolver.solve(5, 5); // solving
                mSolver.totalSolutions(); // showing total number of solutions
            }
            if (choice == 3) // solving the generic small maze
            {
                System.out.println("");
                String[][] maze = new String[11][11];
                fillLargeMaze(maze); // filling the maze
                System.out.println(" ");
                System.out.println("LARGE GENERIC MAZE");
                printoutMaze(maze, 11, 11);
                System.out.println("---------------");
                Maze mSolver = new Maze(11, 11, maze);
                mSolver.solve(11, 11); // solving
                mSolver.totalSolutions(); // showing total number of solutions
            }

            System.out.println(" ");
            menu();
            choice = sn.nextInt();
        }
    }

    /**
     * Method fills a maze with the generic 5 by 5 maze
     * @param n 2d array of strings thats 5 by 5 to fill
     */
    public static void fillSmallMaze(String[][] n)
    {
        n[0][0] = "1";
        n[0][1] = "1";
        n[0][2] = "1";
        n[0][3] = "1";
        n[0][4] = "1";
        n[1][0] = "b";
        n[1][1] = "0";
        n[1][2] = "1";
        n[1][3] = "0";
        n[1][4] = "1";
        n[2][0] = "1";
        n[2][1] = "0";
        n[2][2] = "1";
        n[2][3] = "0";
        n[2][4] = "e";
        n[3][0] = "0";
        n[3][1] = "0";
        n[3][2] = "0";
        n[3][3] = "0";
        n[3][4] = "1";
        n[4][0] = "1";
        n[4][1] = "1";
        n[4][2] = "1";
        n[4][3] = "1";
        n[4][4] = "1";

    }

    /**
     * Method fills a maze with the generic 11 by 11 maze
     * @param n 2d array of strings thats 11 by 11 to fill
     */
    public static void fillLargeMaze(String[][] n)
    {
        n[0][0] = "1";
        n[0][1] = "1";
        n[0][2] = "1";
        n[0][3] = "1";
        n[0][4] = "1";
        n[0][5] = "1";
        n[0][6] = "1";
        n[0][7] = "1";
        n[0][8] = "1";
        n[0][9] = "1";
        n[0][10] = "1";

        n[1][0] = "1";
        n[1][1] = "0";
        n[1][2] = "0";
        n[1][3] = "0";
        n[1][4] = "0";
        n[1][5] = "0";
        n[1][6] = "1";
        n[1][7] = "0";
        n[1][8] = "0";
        n[1][9] = "0";
        n[1][10] = "1";

        n[2][0] = "1";
        n[2][1] = "0";
        n[2][2] = "1";
        n[2][3] = "0";
        n[2][4] = "0";
        n[2][5] = "0";
        n[2][6] = "1";
        n[2][7] = "0";
        n[2][8] = "1";
        n[2][9] = "0";
        n[2][10] = "1";

        n[3][0] = "e";
        n[3][1] = "0";
        n[3][2] = "1";
        n[3][3] = "0";
        n[3][4] = "0";
        n[3][5] = "0";
        n[3][6] = "0";
        n[3][7] = "0";
        n[3][8] = "1";
        n[3][9] = "0";
        n[3][10] = "1";

        n[4][0] = "1";
        n[4][1] = "0";
        n[4][2] = "1";
        n[4][3] = "1";
        n[4][4] = "1";
        n[4][5] = "1";
        n[4][6] = "1";
        n[4][7] = "0";
        n[4][8] = "1";
        n[4][9] = "0";
        n[4][10] = "1";

        n[5][0] = "1";
        n[5][1] = "0";
        n[5][2] = "1";
        n[5][3] = "0";
        n[5][4] = "1";
        n[5][5] = "0";
        n[5][6] = "0";
        n[5][7] = "0";
        n[5][8] = "1";
        n[5][9] = "0";
        n[5][10] = "1";

        n[6][0] = "1";
        n[6][1] = "0";
        n[6][2] = "0";
        n[6][3] = "0";
        n[6][4] = "1";
        n[6][5] = "0";
        n[6][6] = "1";
        n[6][7] = "0";
        n[6][8] = "0";
        n[6][9] = "0";
        n[6][10] = "1";

        n[7][0] = "1";
        n[7][1] = "1";
        n[7][2] = "1";
        n[7][3] = "1";
        n[7][4] = "1";
        n[7][5] = "0";
        n[7][6] = "1";
        n[7][7] = "0";
        n[7][8] = "0";
        n[7][9] = "0";
        n[7][10] = "1";

        n[8][0] = "1";
        n[8][1] = "0";
        n[8][2] = "1";
        n[8][3] = "b";
        n[8][4] = "1";
        n[8][5] = "0";
        n[8][6] = "1";
        n[8][7] = "0";
        n[8][8] = "0";
        n[8][9] = "0";
        n[8][10] = "1";

        n[9][0] = "1";
        n[9][1] = "0";
        n[9][2] = "0";
        n[9][3] = "0";
        n[9][4] = "0";
        n[9][5] = "0";
        n[9][6] = "1";
        n[9][7] = "0";
        n[9][8] = "0";
        n[9][9] = "0";
        n[9][10] = "1";

        n[10][0] = "1";
        n[10][1] = "1";
        n[10][2] = "1";
        n[10][3] = "1";
        n[10][4] = "1";
        n[10][5] = "1";
        n[10][6] = "1";
        n[10][7] = "1";
        n[10][8] = "1";
        n[10][9] = "1";
        n[10][10] = "1";
    }

    /**
     * Menu for the users input.
     */
    public static void menu()
    {
        System.out.println("1. Add a new Maze");
        System.out.println("2. Run a Generic 5 by 5 Maze");
        System.out.println("3. Run a Generic 11 by 11 Maze");
        System.out.println("4. Exit");
    }

    /**
     * Method prints out the a maze
     * @param maze 2d Array of strings (maze) to print
     * @param row integer value for the number of rows in the maze
     * @param cols integer value for the number of columns in the maze
     */
    public static void printoutMaze(String[][] maze, int row, int cols)
    {
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(maze[i][j]);
            }
            System.out.println("");
        }
    }

}
