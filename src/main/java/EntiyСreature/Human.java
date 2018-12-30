package EntiyСreature;

public class Human extends Creature{

    /**
     * Поле, отвечающие за количество пулей у игрока
     */
    private int bullets;

    /**
     * Поле, отвечающие за количество гранат у игрока
     */
    private int grenades;

    /**
     * Поле, отвечающие за наличие мешка цемента у игрока
     *
     */
    private boolean bagOfCement;


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

    public boolean isBagOfCement() {
        return bagOfCement;
    }

    public void setBagOfCement(boolean bagOfCement) {
        this.bagOfCement = bagOfCement;
    }
}
