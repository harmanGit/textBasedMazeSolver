package project.pkg5;

/**
 * The class requires a maze (2d Array of strings), 
 * and the dimensions of the maze(Rows and Columns).
 * The has a solve method that will solve any maze with one beginning. Places a
 * P where the path to the exit is. Also class will display all possible 
 * solutions.
 * @author harmanjeetdhillon
 */
public class Maze
{
    private final String[][] maze; // 2d array as the Maze
    private final int rows; 
    private final int cols;
    private int beginningRow; // The beginning row of the maze
    private int beginningCols; // The beginning column of the maze
    private boolean hasBeginning; // Does the maze have a beginning
    private boolean hasExit; // Does the maze have a Exit
    // beginOnce is used to insure the rows and cols dont get reset more that
    // once
    private boolean beginOnce; 
    private int solCount; // Counter for number of solutions

    /**
     * Constructor
     * @param r integer value for the number of rows in the maze
     * @param c integer value for the number of columns in the maze
     * @param m 2d array which is the maze to be solved
     */
    Maze(int r, int c, String[][] m)
    {
        rows = r;
        cols = c;
        maze = m;
        solCount = 0;
        beginOnce = false;
        hasBeginning = false;
        hasExit = false;
    }

    /**
     * This solve method, solves the user entered maze via recursion and
     * backtracking. Also allows multi solutions.
     * @param r integer value for the row position in the maze
     * @param c integer value for the columns position in the maze
     */
    public void solve(int r, int c)
    {

        // If statement makes sure that the rows and columns only get set once
        // with the position of the beginning, and not everytime recurision
        // happens.
        if (!beginOnce) // Only runs once
        {
            // Solvable method sets the beginning Row and Col and makes sure
            // there is a beginning position and ending position. 
            solvable();  
            r = beginningRow;
            c = beginningCols;
        }

        // If statement makes sure the maze has a beginning and a exit before
        // looking for the paths
        if (hasBeginning && hasExit)
        {
            // Finds the exit
            if (eCheck(r, c))
            {
                // If statement makes sure that exit and beginning aren't
                // over rewritten with a Path
                if (!maze[r][c].equals("e") && !maze[r][c].equals("b"))
                {
                    maze[r][c] = "P";
                }
                solCount++; // increments solutions
                System.out.println(" ");
                System.out.println("- Completed -");
                System.out.println("Solution #" + solCount);
                printMaze(); // Prints maze with the solution out
            }

            //Checks Above for a path
            if (checkAbove(r, c))
            {
                // If statement makes sure the beginning doesn't get overwritten
                if (!maze[r][c].equals("b"))
                {
                    maze[r][c] = "P";
                }
                solve(r - 1, c);
            }

            //Checks Below for a path
            if (checkBelow(r, c))
            {
                // If statement makes sure the beginning doesn't get overwritten
                if (!maze[r][c].equals("b"))
                {
                    maze[r][c] = "P";
                }
                solve(r + 1, c);
            }

            // Checks Left for a path
            if (checkLeft(r, c))
            {
                // If statement makes sure the beginning doesn't get overwritten
                if (!maze[r][c].equals("b"))
                {
                    maze[r][c] = "P";
                }
                solve(r, c - 1);
            }

            // Checks Right for a path
            if (checkRight(r, c))
            {
                // If statement makes sure the beginning doesn't get overwritten
                if (!maze[r][c].equals("b"))
                {
                    maze[r][c] = "P";
                }
                solve(r, c + 1);
            }
            // BackTracking, only if there is no path up, down,left or right
            maze[r][c] = "0"; 
        } else
        {
            // Outputs to user that there is no beginning
            if (!hasBeginning)
            {
                System.out.println("This Maze has no Beginning!");
            }
            // Outouts to user that there is no exit
            if (!hasExit)
            {
                System.out.println("This Maze has no Exit!");
            }
        }
    }
    
    /**
     * Method prints out the total number of solutions, if there aren't any
     * method prints out no solutions
     */
    public void totalSolutions(){
        if(solCount > 0){ // Checking if there are any solutions
            System.out.println(" ");
            System.out.println("Total Number Solutions: " + solCount);
        } else {
            System.out.println("No Solutions Found!");
        }
    }

    /**
     * Method checks if the maze is solvable, by looking for the beginning and 
     * exit. If there is a beginning and a exit then the method 
     * modifies the attribute hasBeginning to true if the maze has an beginning 
     * and hasExit to true if the maze has any exits. The method also finds the
     * beginning position; then modifies the attribute beginningRow and
     * beginningCols to the beginning position rows and columns. Also method,
     * sets beginOnce to true.
     */
    private void solvable()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (maze[i][j].equals("b"))
                {
                    beginningRow = i;
                    beginningCols = j;
                    hasBeginning = true;
                }
                if (maze[i][j].equals("e"))
                {
                    hasExit = true;
                }
            }
        }
        beginOnce = true;
    }

    /**
     * Method checks if there is a path above and if its not out bounds for
     * the array (maze); returns true if it can move there and false if it cant.
     * @param r integer value for the row to look above from
     * @param c integer value for the column to look above from
     * @return a boolean true if it can move, otherwise false
     */
    private boolean checkAbove(int r, int c)
    {
        // Checking out of bounds
        if (r > 0)
        {
            if (maze[r - 1][c].equals("0")) // Checking for a path
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Method checks if there is a path down and if its not out bounds for
     * the array (maze); returns true if it can move there and false if it cant.
     * @param r integer value for the row to look down from
     * @param c integer value for the column to look down from
     * @return a boolean true if it can move, otherwise false
     */
    private boolean checkBelow(int r, int c)
    {
         // Checking out of bounds
        if (rows > r + 1) // The user inputs rows, without 0 based counting
        {
            if (maze[r + 1][c].equals("0")) // Checking for a path
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Method checks if there is a path left and if its not out bounds for
     * the array (maze); returns true if it can move there and false if it cant.
     * @param r integer value for the row to look left from
     * @param c integer value for the column to look left from
     * @return a boolean true if it can move, otherwise false
     */
    private boolean checkLeft(int r, int c)
    {
         // Checking out of bounds
        if (c > 0)
        {
            if (maze[r][c - 1].equals("0")) // Checking for a path
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Method checks if there is a path right and if its not out bounds for
     * the array (maze); returns true if it can move there and false if it cant.
     * @param r integer value for the row to look right from
     * @param c integer value for the column to look right from
     * @return a boolean true if it can move, otherwise false
     */
    private boolean checkRight(int r, int c)
    {
         // Checking out of bounds
        if (cols > c + 1) // The user inputs cols, without 0 based counting
        {
            if (maze[r][c + 1].equals("0")) // Checking for a path
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Method checks up, down, left, right in the maze to see if its next to an
     * exit "e".
     *
     * @param r integer value for the row to around from
     * @param c integer value for the column to around from
     * @return true if its next to a exit, otherwise false
     */
    private boolean eCheck(int r, int c)
    {
        // Check Up
        if (r > 0)  // Checking out of bounds
        {
            if (maze[r - 1][c].equals("e")) // Checking for the exit
            {
                return true;
            }
        }
        //Check Down
        if (rows > r + 1)  // Checking out of bounds
        {
            if (maze[r + 1][c].equals("e")) // Checking for the exit
            {
                return true;
            }
        }
        //Checking left
        if (c > 0)
        {
            if (maze[r][c - 1].equals("e")) // Checking for the exit
            {
                return true;
            }
        }
        // Checking Right
        if (cols > c + 1)  // Checking out of bounds
        {
            if (maze[r][c + 1].equals("e")) // Checking for the exit
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Method is used to print out a Maze.
     */
    private void printMaze()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(maze[i][j]);
            }
            System.out.println("");
        }
    }
}
