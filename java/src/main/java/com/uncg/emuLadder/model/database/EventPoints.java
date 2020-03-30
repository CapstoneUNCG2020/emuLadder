package com.uncg.emuLadder.model.database;

import com.uncg.emuLadder.model.database.compositekeys.EventPointsId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

@Entity
@IdClass(EventPointsId.class)
public class EventPoints {
    @Id
    private EventPointsId eventPointsId;

    private String teamId;

    private String playerId;

    private int points;

    public EventPointsId getEventPointsId() {
        return eventPointsId;
    }

    public void setEventPointsId(EventPointsId eventPointsId) {
        this.eventPointsId = eventPointsId;
    }

    public String getEventId() {
        return eventPointsId.getEventId();
    }

    public void setEventId(String eventId) {
        if (eventPointsId == null) eventPointsId = new EventPointsId();

        eventPointsId.setEventId(eventId);
    }

    public String getMatchId() {
        return eventPointsId.getMatchId();
    }

    public void setMatchId(String matchId) {
        if (eventPointsId == null) eventPointsId = new EventPointsId();

        eventPointsId.setMatchId(matchId);
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getParticipantNumber() {
        return eventPointsId.getParticipantNumber();
    }

    public void setParticipantNumber(int participantNumber) {
        if (eventPointsId == null) eventPointsId = new EventPointsId();

        eventPointsId.setParticipantNumber(participantNumber);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventPoints)) return false;
        EventPoints that = (EventPoints) o;
        return points == that.points &&
                Objects.equals(eventPointsId, that.eventPointsId) &&
                Objects.equals(teamId, that.teamId) &&
                Objects.equals(playerId, that.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventPointsId, teamId, playerId, points);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EventPoints{");

        if (eventPointsId != null) {
            sb.append("eventId='").append(eventPointsId.getEventId()).append('\'');
            sb.append(", matchId='").append(eventPointsId.getMatchId()).append('\'');
            sb.append(", participantNumber=").append(eventPointsId.getParticipantNumber());
        } else {
            sb.append("eventPointsId='").append(eventPointsId).append('\'');
        }

        sb.append(", teamId='").append(teamId).append('\'');
        sb.append(", playerId='").append(playerId).append('\'');
        sb.append(", points=").append(points);
        sb.append('}');
        return sb.toString();
    }
}