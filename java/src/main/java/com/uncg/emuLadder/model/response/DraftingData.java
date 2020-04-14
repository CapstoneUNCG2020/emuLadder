package com.uncg.emuLadder.model.response;

import java.util.Arrays;
import java.util.Objects;

public class DraftingData {
    private Player[] availablePlayers;

    private Contest contest;

    public Player[] getAvailablePlayers() {
        return availablePlayers;
    }

    public void setAvailablePlayers(Player[] availablePlayers) {
        this.availablePlayers = availablePlayers;
    }

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DraftingData)) return false;
        DraftingData that = (DraftingData) o;
        return Arrays.equals(availablePlayers, that.availablePlayers) &&
                Objects.equals(contest, that.contest);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(contest);
        result = 31 * result + Arrays.hashCode(availablePlayers);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DraftingData{");
        sb.append("availablePlayers=").append(Arrays.toString(availablePlayers));
        sb.append(", contest=").append(contest);
        sb.append('}');
        return sb.toString();
    }
}
