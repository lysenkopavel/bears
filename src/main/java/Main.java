import Maze.*;
import Service.ServiceMaze;

public class Main {

    public static void main(String[] args) {
        ServiceMaze serviceMaze = new ServiceMaze();
        Maze maze = serviceMaze.createMaze();

        maze.getWallsCol()[2][3] = Wall.NO;
        maze.getWallsCol()[0][2] = Wall.MAZE_EXIT;
        maze.getWallsStr()[2][3] = Wall.NO;
        maze.getWallsStr()[4][2] = Wall.NO;



        System.out.println(maze.toString());
    }

}
