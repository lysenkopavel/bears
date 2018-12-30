package EntiyСreature;

public abstract class Creature {

    public boolean isLiveStage() {
        return liveStage;
    }

    public void setLiveStage(boolean liveStage) {
        this.liveStage = liveStage;
    }

    /**
     * Поле, отвечающие за состояния существа.
     * Может принимать два значения: true - существо живо, false - существо мертво
     */
    protected boolean liveStage;

    public int moveIncrement(int coord) {
        return coord + 1;
    }

    public int moveDecrement(int coord) {
        return coord - 1;
    }
}
