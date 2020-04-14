package com.uncg.emuLadder.enums;

public enum LeagueScoring {
    KILL(3),
    ASSIST(2),
    DEATH(-1),
    CREEP_SCORE(0.02),
    TURRETS(1),
    DRAGONS(2),
    BARONS(3),
    KA_BONUS(2),
    WIN(2),
    GAME_NOT_PLAYED(20);

    private double value;

    LeagueScoring(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
