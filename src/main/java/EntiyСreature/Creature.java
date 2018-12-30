package EntiyСreature;

public abstract class Creature {

    /**
     * Поле, отвечающие за состояния существа.
     * Может принимать два значения: true - существо живо, false - существо мертво
     */
    protected boolean liveStage;

    public boolean isLiveStage() {
        return liveStage;
    }

    public void setLiveStage(boolean liveStage) {
        this.liveStage = liveStage;
    }



}
