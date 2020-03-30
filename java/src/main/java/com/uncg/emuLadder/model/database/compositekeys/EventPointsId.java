package com.uncg.emuLadder.model.database.compositekeys;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EventPointsId implements Serializable {
    private String eventId;

    private String matchId;

    private int participantNumber;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

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
        if (!(o instanceof EventPointsId)) return false;
        EventPointsId that = (EventPointsId) o;
        return participantNumber == that.participantNumber &&
                Objects.equals(eventId, that.eventId) &&
                Objects.equals(matchId, that.matchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, matchId, participantNumber);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EventPointsId{");
        sb.append("eventId='").append(eventId).append('\'');
        sb.append(", matchId='").append(matchId).append('\'');
        sb.append(", participantNumber=").append(participantNumber);
        sb.append('}');
        return sb.toString();
    }
}