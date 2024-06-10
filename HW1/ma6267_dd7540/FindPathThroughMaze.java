/*
 * FindPathThroughMaze.java
 *
 * Version:
 *     1.0
 *
 * Revisions:
 *     0
 */
/**
 * This program helps to find a path through a maze.
 *
 * @author      Mariam Abidi
 * @author      Dhruv Dave
 */

//	-9 == outside of maze
//	-1 == wall
//	 0 == no wall

public class  FindPathThroughMaze {
    /*		---> column
     *		|
     *		|
     *		v
     *		row
     * The maze has no circles
     */
static int[][] maze =
                    {
                    {-9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 },
                    {-9, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -9 },
                    {-9, -1, -1,  0,  0,  0,  0, -1,  0,  0,  0, -1, -9 },
                    {-9, -1, -1,  0, -1, -1, -1, -1,  0, -1,  0, -1, -9 },
                    {-9, -1, -1,  0,  0,  0,  0,  0,  0, -1,  0, -1, -9 },
                    {-9, -1,  0, -1, -1, -1,  0, -1,  0,  0,  0, -1, -9 },
                    {-9, -1,  0, -1, -1, -1,  0, -1, -1, -1, -1, -1, -9 },
                    {-9, -1,  0, -1, -1,  0,  0, -1, -1, -1, -1, -1, -9 },
                    {-9, -1,  0, -1, -1,  0, -1, -1, -1, -1, -1, -1, -9 },
                    {-9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9 }
                                                                        };
    static int entryRow = 1;
    static int entryColumn = 3;
    static int[] fromWhere = new int[2];

    /**
     * The printMaze method produces the maze in the output which helps to
     * understand the traversed path better.
     *
     * @param       maze [][]    A 2D Array named maze is initialized to help
     *                          print the maze with correct object for the
     *                          correct symbol.
     *
     * @return              void
     *
     */

    public static void printMaze(int[][] maze)	{

     /* The nested for loop is used to traverse the whole maze coordinate
        by coordinate to provide a better representation of the path through
        the maze.  */

        for ( int row = 0; row < maze.length; row++ ){
            String test = "";
            for ( int column = 0; column < maze[0].length; column++ ){
                if (maze[row][column] > 0){
                    test += ": ";
                }
                else {
                    test += "* ";
                }
            }
            System.out.println(test);
        }
    }

    /**
     * This findNextFree method is used to find the next free spot in the maze
     * by checking the adjacent spots from the current location to traverse to.
     *
     * @param       row       This parameter is used to store the row
     *                        coordinates of the maze.
     * @param       column    This parameter is used to store the column
     *                        coordinates of the maze.
     *
     * @return              void
     */

    public static void findNextFree( int row, int column ) {

         /* fromWhere is an array to store the coordinates of the original
         location. */

        fromWhere[0] = row;
        fromWhere[1] = column;

        /* This if-elseif loop is used to check the adjacent sides to find a
           path. */

        if ( maze[row + 1][column] == 0 ){
            findNextFree(row + 1, column, maze[row][ column], fromWhere);}
        else if ( maze[row][column - 1] == 0 ){
            findNextFree(row , column - 1 , maze[row][column], fromWhere);}
        else if ( maze[row][column + 1] == 0 ){
            findNextFree(row , column + 1 , maze[row][column], fromWhere);}
        else if ( maze[row - 1][column] == 0 ){
            findNextFree(row - 1, column, maze[row][column], fromWhere);}

        /* This else if condition checks for an exit on the adjacent sides and
        prints the maze and path length if an exit is found. */

        else if ( maze[row + 1][column] == -9 || maze[row][column - 1] == -9
                || maze[row][column + 1] == -9 || maze[row - 1][column] == -9 ){
            printMaze(maze);
            System.out.println("Path Length: " + (maze[row][column]));
            return ;
        }

        /* These else-if loops helps in checking the adjacent sides for
        backtracking if you reach a dead end. */

        else if ( maze[row + 1][column] > 0 ){
            findNextFree(row + 1, column, maze[row][column], fromWhere); }
        else if ( maze[row][column - 1 ] > 0 ){
            findNextFree(row , column - 1 , maze[row][column], fromWhere); }
        else if ( maze[row][column + 1 ] > 0 ){
            findNextFree(row , column + 1 , maze[row][column], fromWhere); }
        else if ( maze[row - 1][column] > 0 ){
            findNextFree(row - 1, column, maze[row][column], fromWhere); }
    }

    /**
     * This findNextFree method is used to leave breadcrumbs by incrementing
     * the mazeValue to help denote that we have been to those coordinates
     * before. It is also used to backtrack after a dead end and change the
     * mazeValue of the dead end to -1(wall).
     *
     * @param row               A variable to store the row coordinates.
     * @param column            A variable to store the column coordinates.
     * @param mazeValue         A variable to store the value of the specified
     *                          coordinates.
     * @param fromWhere         An array to store the coordinates of the
     *                          original position.
     *
     * @return                  void
     *
     **/

    private static void findNextFree(int row, int column, int mazeValue, int[] fromWhere) {

        /* This if loop changes the maze value of the specified coordinate to
        signify that it has been traversed before else if a dead end is found
        then it backtracks to the previous coordinate and changes the maze
        value of the dead end to wall value (-1)*/

        if ( maze[row][column] == 0 ) {
            maze[row][column] = mazeValue + 1;
        } else if ( maze[row][column] == mazeValue - 1 ) {
            maze[fromWhere[0]][fromWhere[1]] = -1;
        }
        findNextFree(row, column);
    }

    /**
     * The main program.
     *
     * @param    args    command line arguments
     */

    public static void main(String[] args){
        maze[entryRow][entryColumn] = 1;
        findNextFree(entryRow, entryColumn);
    }
}