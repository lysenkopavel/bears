package EntiyСreature;

/**
 * Класс-сущность призрак.
 * Состояние, в которое попадает игрок при смерти.
 */
public class Ghost extends Human {

    public Ghost(Human human) {
        super(human.getName(),0,0,false);
        setLiveStage(false);
    }

    /**
     * Метод, отвещающий за воскрешение призрака
     *
     * @return Воскресший игрок, с 10 пулями в инвентаре, с 1 гранатой и без мешка цемента
     */
    public Human resurrection() {
        return new Human(this.getName(),10,1,false);
    }
}
