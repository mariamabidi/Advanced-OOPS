/*
 * Maze.java
 *
 * Version:
 *     1.0
 *
 * Revisions:
 *     0
 */
/**
 * This program helps to find the shortest path by removing just one wall block.
 *
 * @author      Mariam Abidi
 * @author      Dhruv Dave
 */

public class Maze {
    /*		---> column
     *		|
     *		|
     *		v
     *		row
     * The maze has no circles
     */
//	-9 == outside of maze
//	-1 == wall
//	 0 == no wall
    static int WALL = -1;
    static int[][] originalMaze =
                  { {-9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 },
                    {-9, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -9 },
                    {-9, -1, -1,  0,  0,  0,  0, -1, -1, -1, -1, -1, -9 },
                    {-9, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -9 },
                    {-9, -1,  0,  0, -1,  0,  0,  0,  0, -1, -1, -1, -9 },
                    {-9, -1,  0, -1, -1, -1,  0, -1,  0, -1, -1, -1, -9 },
                    {-9, -1,  0, -1, -1, -1,  0, -1, -1, -1, -1, -1, -9 },
                    {-9, -1,  0, -1,  0,  0,  0, -1, -1, -1, -1, -1, -9 },
                    {-9, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -9 },
                    {-9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 } };
    static int destroyedWall = 99;
    static int entryRow = 1;
    static int entryColumn = 3;
    static int exitRow = 8;
    static int exitColumn = 4;

    /**
     * The printMaze method produces the maze in the output which helps to
     * represent the maze properly.
     *
     * @param       maze [][]    A 2D Array named maze is initialized to help
     *                           print the maze with correct object for the
     *                           correct symbol.
     *
     * @return              void
     *
     */

    public static void printMaze(int maze[][])	{

        /* The nested for loop is used to represent the whole maze with symbols
        and the connected paths */

        for ( int row = 0; row < maze.length; row++ ) {
            String test = "";
            for (int column = 0; column < maze[0].length; column++) {
                if (originalMaze[row][column] == -1 ||originalMaze[row][column] == -9 ) {
                    test +="* ";
                }
                else {
                    test+="^ ";
                }
            }
            System.out.println(test);
        }
    }

    /**
     * The analyzeMaze method checks for the positive values present in the
     * maze and traverses to the bottom (i.e. the shortest path). After which
     * it calculates the distance from both start to wall and end to the wall
     * and then adds them both to produce the total path length.
     *
     * @return              void
     *
     */

    public static void analyzeMaze() {
        boolean flag = true;
        int row = entryRow;
        int column = entryColumn;
        int pathLength = 0;
        /* The while loop helps to traverse to the bottom */
        while (flag) {
            if (originalMaze[row + 1][column] > originalMaze[row][column]) {
                row += 1;
            } else if (originalMaze[row][column - 1] > originalMaze[row][column]) {
                column -= 1;
            } else if (originalMaze[row][column + 1] > originalMaze[row][column]) {
                column += 1;
            } else if (originalMaze[row - 1][column] > originalMaze[row][column]) {
                row -= 1;
            } else {
                flag = false;
            }
        }

        //Next we calculate the path or show the error message if there are no paths available.
        int reversePath = -1 * calculatePath(row, column);
        if (reversePath == 0) {
            System.out.println("Path Length: No path Found!!");
        } else {
           pathLength = originalMaze[row][column] + (reversePath - 9) + 1;
           printMaze(originalMaze);
           System.out.println("Path Length: " + pathLength);
        }
    }

    /**
     * The calculatePath method checks if it is possible to break the adjacent
     * wall to find the shortest path.
     *
     * @param     row       A variable to store the row coordinate.
     * @param     column    A variable to store the column coordinate.
     *
     * @return              int
     *
     */

    private static int calculatePath(int row, int column) {

        /* This if-else if loop is used to check the block next to adjacent
        block if it contains is value less than -9, which means it is a path
        traversed through the exit. And breaks the wall if the shortest path is found */

        if ( originalMaze[row + 2][column] < -9  )
        {   originalMaze[row+1][column] = destroyedWall;
            return originalMaze[row+2][column];   }
        else if ( column >= 2 && originalMaze[row][column - 2 ] < -9 )
        {   originalMaze[row][column-1] = destroyedWall;
            return originalMaze[row][column-2];   }
        else if ( originalMaze[row][column + 2 ] < -9 )
        {   originalMaze[row][column+1] = destroyedWall;
            return originalMaze[row][column+2];   }
        else if ( row >= 2 && originalMaze[row - 2][column] < -9 )
        {   originalMaze[row-1][column] = destroyedWall;
            return originalMaze[row-2][column];   }
        return 0;
    }

    /**
     * This findNextFree method is used to find the next free spot in the maze
     * by checking the adjacent spots from the current location to traverse to.
     *
     * @param     row         A variable to store the row coordinate.
     * @param     column      A variable to store the column coordinate.
     * @param   pathLength    A variable to store the length of the path.
     * @param   fromWhere     A variable to store the value of the original
     *                        position.
     *
     * @return              void
     *
     */

    public static void findNextFree(int row, int column, int pathLength, int fromWhere) {

        /* Initialised the first spot of the entry with 1 and first spot of the
         exit with -1 */
        if(row == entryRow && column == entryColumn){
            originalMaze[row][column] = 1; }
        else if(row == exitRow && column == exitColumn){
            originalMaze[row][column] = -10; }

        /* This loop is used to check the adjacent free sides. */
        if ( originalMaze[row + 1][column] == 0 ){
            originalMaze[row+1][column] = originalMaze[row][column] + fromWhere;
            findNextFree(row + 1, column, pathLength + 1, fromWhere);}
        else if ( originalMaze[row][column - 1 ] == 0 ){
            originalMaze[row][column-1] = originalMaze[row][column] + fromWhere;
            findNextFree(row , column - 1 , pathLength + 1, fromWhere);}
        else if ( originalMaze[row][column + 1 ] == 0 ){
            originalMaze[row][column+1] = originalMaze[row][column] + fromWhere;
            findNextFree(row , column + 1 , pathLength + 1, fromWhere);}
        else if ( originalMaze[row - 1][column] == 0 ){
            originalMaze[row-1][column] = originalMaze[row][column] + fromWhere;
            findNextFree(row - 1, column, pathLength + 1, fromWhere);}
        else if(fromWhere == -1)
            analyzeMaze();
    }

    /**
     * The main program.
     *
     * @param    args    command line arguments
     */

    public static void main(String[] args){
        findNextFree(entryRow, entryColumn, 1, 1);
        findNextFree(exitRow, exitColumn, 1, -1);
    }
}