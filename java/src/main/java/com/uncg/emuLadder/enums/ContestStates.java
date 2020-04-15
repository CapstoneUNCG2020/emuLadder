package com.uncg.emuLadder.enums;

public enum ContestStates {
    NOT_STARTED(0),
    IN_PROGRESS(1),
    FINISHED(2);

    private final int value;

    ContestStates(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
