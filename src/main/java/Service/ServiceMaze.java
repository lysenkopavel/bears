package Service;

import Maze.*;

import static Maze.Wall.WALL;


public class ServiceMaze {

    public Maze createMaze(){
        Maze maze = new Maze(5, 5);
        fillWalls(maze);
        return maze;
    }

    private void fillWalls(Maze maze){

        Wall[][] wallsStr= maze.getWallsStr();
        Wall[][] wallsCol= maze.getWallsCol();

        for (int i = 0; i < wallsStr.length; i++) {
            for (int j = 0; j < wallsStr[i].length ; j++) {
                wallsStr[i][j] = WALL;
            }
        }

        for (int i = 0; i < wallsCol.length; i++) {
            for (int j = 0; j < wallsCol[i].length ; j++) {
                wallsCol[i][j]  = WALL;
            }
        }

        maze.setWallsStr(wallsStr);
        maze.setWallsCol(wallsCol);
    }

}
