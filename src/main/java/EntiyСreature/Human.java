package EntiyСreature;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Класс-сущность игрок
 */
@Entity
@Table(name = "Human")
public class Human extends Creature implements Serializable {

    /**
     * id игрока
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /**
     * Поле, отвечающие за имя игрока
     */
    @Column(name = "NAME")
    private String name;

    /**
     * Поле, отвечающие за количество пулей у игрока
     */
    @Column(name = "BULLETS")
    private int bullets;

    /**
     * Поле, отвечающие за количество гранат у игрока
     */
    @Column(name = "GRENADES")
    private int grenades;

    /**
     * Поле, отвечающие за наличие мешка цемента у игрока
     *
     */
    @Column(name = "BAG_CEMENT")
    private boolean bagOfCement;

    //CONSTRUCTORS---------------------------------------------------------------------------------------------------------------------------------

    public Human(String name,int bullets,int grenades,boolean bagOfCement) {
        this.name=name;
        this.bullets=bullets;
        this.grenades=grenades;
        this.bagOfCement=bagOfCement;
        setLiveStage(true);
    }

    public Human(String name) {
        this(name,20,2,true);
        setLiveStage(true);
    }

    public Human() {
    }

    //GETTERS AND SETTERS-------------------------------------------------------------------------------------------------------------------------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    /**
     * Метод, вызываемый при смерти игрока
     *
     * @return список, содержащий инвентарь игрока, в следующим порядке: кол-во пуль, кол-во гранат, 1/0 в зависимости от наличия мешка цемента
     */
    public List<Integer> deadHuman() {
        List<Integer> equipmentHuman = new ArrayList<Integer>();
        equipmentHuman.add(getBullets());
        equipmentHuman.add(getGrenades());
        if(bagOfCement)
            equipmentHuman.add(1);
        else
            equipmentHuman.add(0);

        setLiveStage(false);
        setBullets(0);
        setGrenades(0);
        setBagOfCement(false);

        return equipmentHuman;
    }

    /**
     * Метод, вызываемый при воскрешение игрока.
     * Выдает воскрешаемому игроку 10 пуль и 1 гранату.
     */
    public void resurrection() {
        setLiveStage(true);
        setBullets(10);
        setGrenades(1);
        setBagOfCement(false);
    }

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
