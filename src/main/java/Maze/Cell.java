package Maze;

import EntiyСreature.Creature;

import java.util.List;

public class Cell {

    private List<Creature> creatures;

    private List<ObjectsInMaze> objectsInMazeList;

    private int bullets = 0;
    private int grenades = 0;
    private int bagOfCement = 0;


    public List<Creature> getCreatures() {
        return creatures;
    }

    public void setCreatures(List<Creature> creatures) {
        this.creatures = creatures;
    }

    public List<ObjectsInMaze> getObjectsInMazeList() {
        return objectsInMazeList;
    }

    public void setObjectsInMazeList(List<ObjectsInMaze> objectsInMazeList) {
        this.objectsInMazeList = objectsInMazeList;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }

    public int getGrenades() {
        return grenades;
    }

    public void setGrenades(int grenades) {
        this.grenades = grenades;
    }

    public int getBagOfCement() {
        return bagOfCement;
    }

    public void setBagOfCement(int bagOfCement) {
        this.bagOfCement = bagOfCement;
    }
}
