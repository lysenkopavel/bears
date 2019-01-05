package EntiyСreature;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Абстракный класс, отвечающий за абстракное живое существо.
 *
 * Имеет два состояния: true и false.
 * true - сущесиво живое
 * false - существо мертвое либо призрак
 */

@MappedSuperclass
public abstract class Creature {

    /**
     * Поле, отвечающие за состояния существа.
     * Может принимать два значения: true - существо живо, false - существо мертво
     */
    @Column(table = "Human", name = "liveStage")
    protected boolean liveStage;

    public boolean isLiveStage() {
        return liveStage;
    }

    public void setLiveStage(boolean liveStage) {
        this.liveStage = liveStage;
    }

    /**
     * Метод, отвечающий за перемещение существа с увелечением координаты
     * @param coord - текущая координата существа
     * @return текущая координата существа увеличенная на единицу
     */
    public int moveIncrement(int coord) {
        return coord + 1;
    }

    /**
     * Метод, отвечающий за перемещение существа с уменьшением координаты
     * @param coord - текущая координата существа
     * @return текущая координата существа уменьшенная на единицу
     */
    public int moveDecrement(int coord) {
        return coord - 1;
    }


}
