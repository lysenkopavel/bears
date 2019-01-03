package Maze;

import java.util.Arrays;

public class Maze {

    private final int sizeX;

    private final int sizeY;

    private Wall[][] wallsStr;
    private Wall[][] wallsCol;
    private Cell[][] cells;

    public Maze(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        wallsStr = new Wall[sizeY][sizeX+1];
        wallsCol = new Wall[sizeY+1][sizeX];
        cells = new Cell[sizeY][sizeX];
    }

    public Wall[][] getWallsStr() {
        return wallsStr;
    }

    public void setWallsStr(Wall[][] wallsStr) {
        this.wallsStr = wallsStr;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Wall[][] getWallsCol() {
        return wallsCol;
    }

    public void setWallsCol(Wall[][] wallsCol) {
        this.wallsCol = wallsCol;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < sizeX; j++) {
            sb.append("  ");
            sb.append(checkWallCol(wallsCol[0][j]));
        }
        sb.append("\n");
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                sb.append(checkWallStr(wallsStr[i][j]));
                sb.append(checkWallCol(wallsCol[i+1][j]));
            }
            sb.append(checkWallStr(wallsStr[i][sizeX]));
            sb.append("\n");
        }
        return sb.toString();
    }


    private String checkWallStr(Wall w){
        switch (w) {
            case NO:
                return "  ";
            case WALL:
                return "|";
            case MAZE_EXIT:
                return "/";
            case INDESTRUCTIBLE_WALL:
                return "||";
        }
        return "";
    }

    private String checkWallCol(Wall w){
        switch (w) {
            case NO:
                return "     ";
            case WALL:
                return "___";
            case MAZE_EXIT:
                return "_/  _";
            case INDESTRUCTIBLE_WALL:
                return "==";
        }
        return "";
    }



}
