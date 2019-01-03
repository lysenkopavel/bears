import Maze.Maze;
import Service.ServiceMaze;

public class Main {

    public static void main(String[] args) {
        ServiceMaze serviceMaze = new ServiceMaze();
        Maze maze = serviceMaze.createMaze();
        System.out.println(maze.toString());
    }

}
