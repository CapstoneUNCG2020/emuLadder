package com.uncg.emuLadder.model.database.compositekeys;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LeagueStatsId implements Serializable {
    private String matchId;

    private int participantNumber;

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public int getParticipantNumber() {
        return participantNumber;
    }

    public void setParticipantNumber(int participantNumber) {
        this.participantNumber = participantNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeagueStatsId)) return false;
        LeagueStatsId that = (LeagueStatsId) o;
        return participantNumber == that.participantNumber &&
                Objects.equals(matchId, that.matchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, participantNumber);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LeagueStatsId{");
        sb.append("matchId='").append(matchId).append('\'');
        sb.append(", participantNumber=").append(participantNumber);
        sb.append('}');
        return sb.toString();
    }
}
