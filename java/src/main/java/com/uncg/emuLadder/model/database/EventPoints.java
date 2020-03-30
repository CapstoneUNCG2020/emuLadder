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
    private String eventId;

    @Id
    private String matchId;

    private String teamId;

    private String playerId;

    @Id
    private int participantNumber;

    private int points;

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
        return participantNumber;
    }

    public void setParticipantNumber(int participantNumber) {
        this.participantNumber = participantNumber;
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
        return participantNumber == that.participantNumber &&
                points == that.points &&
                Objects.equals(eventId, that.eventId) &&
                Objects.equals(matchId, that.matchId) &&
                Objects.equals(teamId, that.teamId) &&
                Objects.equals(playerId, that.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, matchId, teamId, playerId, participantNumber, points);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EventPoints{");
        sb.append("eventId='").append(eventId).append('\'');
        sb.append(", matchId='").append(matchId).append('\'');
        sb.append(", teamId='").append(teamId).append('\'');
        sb.append(", playerId='").append(playerId).append('\'');
        sb.append(", participantNumber=").append(participantNumber);
        sb.append(", points=").append(points);
        sb.append('}');
        return sb.toString();
    }
}