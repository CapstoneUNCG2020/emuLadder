package com.uncg.emuLadder.model.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ContestPlayers {
    @Id
    private int contestPlayersId;

    private int contestId;

    private String playerId;

    public int getContestPlayersId() {
        return contestPlayersId;
    }

    public void setContestPlayersId(int contestPlayersId) {
        this.contestPlayersId = contestPlayersId;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        ContestPlayers that = (ContestPlayers) o;
        return contestPlayersId == that.contestPlayersId &&
                contestId == that.contestId &&
                Objects.equals(playerId, that.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contestPlayersId, contestId, playerId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContestPlayers{");
        sb.append("contestPlayersId=").append(contestPlayersId);
        sb.append(", contestId=").append(contestId);
        sb.append(", playerId=").append(playerId);
        sb.append('}');
        return sb.toString();
    }
}
