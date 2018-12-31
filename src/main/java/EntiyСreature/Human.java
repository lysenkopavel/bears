package EntiyСreature;

public class Human extends Creature{

    /**
     * Поле, отвечающие за имя игрока
     */
    private String name;
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

    public Human(String name) {
        this.name=name;
        this.bullets=20;
        this.grenades=2;
        this.bagOfCement=true;
    }

    //GETTERS AND SETTERS-------------------------------------------------------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isBagOfCement() {
        return bagOfCement;
    }

    public void setBagOfCement(boolean bagOfCement) {
        this.bagOfCement = bagOfCement;
    }

    //ACTION HUMAN----------------------------------------------------------------------------------------------------------------------------------

    public boolean swingKnife(boolean isOtherHuman) {
        if(isOtherHuman)
            return true;
        return false;
    }

    public ShootResult shoot(Direction direction) {
        switch (direction) {
            case NORTH:
                return ShootResult.KILL;
            case SOUTH:
                return ShootResult.KILL;
            case WEST:
                return ShootResult.WALLL;
            case EAST:
                return ShootResult.EMPTY;
                default:
                    return null;
        }
    }

    private enum ShootResult {
        KILL("Убийство"), WALLL("Стена"), EMPTY("Пусто");

        private String name;
        ShootResult(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
