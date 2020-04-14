package com.uncg.emuLadder.enums;

public enum ContestTypes {
    HEAD_TO_HEAD(0),
    PUBLIC(1),
    PRIVATE(2);

    private final int value;

    ContestTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}