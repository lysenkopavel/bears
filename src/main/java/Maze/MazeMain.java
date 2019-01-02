package Maze;

import EntiyСreature.Direction;

import java.util.Arrays;

public class MazeMain {

    private final int sizeX;

    private final int sizeY;

    private Wall[][] walls;

    private int endCell[] = null;

    //private Location[][] locations;

    public MazeMain(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    /**
     * Сделал структуру по-типу, трехмерного массива. Первый параметр - кол-во строк. Второй - кол-во стобцов. Третий - размер ячейки(всегда 4)
     * В каждой ячейке хранится инф об одной ячейке лабиринта
     * {up, down, left, right} - что находится с каждой стороны
     *
     *  __ __ __ __
     * |__   |__   |
     * |   __   |  |
     * |  |  |__   |
     * |__|__ __ __|
     *
     */
    private int[][][] maze = {
            {
                {1,1,1,0}, {1,0,0,1}, {1,1,1,0}, {1,0,0,1}
                },
            {
                {1,0,1,0}, {0,1,0,0}, {1,0,0,1}, {0,0,1,1}
                },
            {
                {0,0,1,1}, {1,0,1,1}, {0,1,1,0}, {0,0,0,1}
                },
            {
                {0,1,1,1}, {0,1,1,0}, {1,0,0,0}, {0,1,0,1}
            }
    };

    public int[][][] getMaze() {
        return maze;
    }

    /**
     * Метод возвращаюий по заданному направлению, элемент перечисления @see Wall
     * @param direction - направление, в котором хочет действовать игрок
     * @param positionCreatureX - текущая позиция игрока по X
     * @param positionCreatureY - текущая позиция игрока по Y
     * @return элемент перечисления @see Wall
     */
    public Wall getIsWall(Direction direction, int positionCreatureX, int positionCreatureY) {
        int[] cell = maze[positionCreatureX][positionCreatureY];
        switch (direction) {
            case NORTH:
                if(cell[0]==1)
                    return Wall.WALL;
                else
                    return Wall.NO;
            case SOUTH:
                if(cell[1]==1)
                    return Wall.WALL;
                else
                    return Wall.NO;
            case WEST:
                if(cell[2]==1)
                    return Wall.WALL;
                else
                    return Wall.NO;
            case EAST:
                if(cell[3]==1)
                    return Wall.WALL;
                else
                    return Wall.NO;
                default:
                    return null;
        }
    }

    /**
     * Метод, который вызывается в случае если игрок стреляет и там нету стены.
     * Метод идет в заданном направлении, пока не наткнется на стену.
     * //TODO В МЕТОД НАДО ВСТАВИТЬ МЕТОД ОБНАРУЖЕНИЯ ИГРОКА НА ПУТИ И УБИЙСТВО
     * @param direction - направления действия
     * @param positionX - текущая позиция игрока X
     * @param positionY - текущая позиция игрока Y
     */
    public int[] moveUpToWall(Direction direction, int positionX, int positionY) {
        int cell[];
        int nextPositionX;
        int nextPositionY;
        //int i=1;
        switch (direction) {
            case NORTH:
                nextPositionX = positionX - 1;
                nextPositionY = positionY;
                cell = maze[nextPositionX][nextPositionY];
                if(cell[0]==0)
                    moveUpToWall(direction,nextPositionX,nextPositionY);
                else
                    endCell = cell;
                break;
            case SOUTH:
                nextPositionX = positionX + 1;
                nextPositionY = positionY;
                cell = maze[nextPositionX][nextPositionY];
                if(cell[1]==0)
                    moveUpToWall(direction,nextPositionX,nextPositionY);
                else
                    endCell = cell;
                break;
            case WEST:
                nextPositionX = positionX;
                nextPositionY = positionY - 1;
                cell = maze[nextPositionX][nextPositionY];
                if(cell[2]==0)
                    moveUpToWall(direction,nextPositionX,nextPositionY);
                else
                    endCell = cell;
                break;
            case EAST:
                nextPositionX = positionX;
                nextPositionY = positionY + 1;
                cell = maze[nextPositionX][nextPositionY];
                if(cell[3]==0)
                    moveUpToWall(direction,nextPositionX,nextPositionY);
                else
                    endCell = cell;
                break;
        }
        return endCell;
    }

    public static void main(String[] args) {
        MazeMain mazeMain = new MazeMain(4,4);
        int[] mas = mazeMain.moveUpToWall(Direction.WEST,0,3);
        for(int i : mas) {
            System.out.print(i);
        }
    }
}
