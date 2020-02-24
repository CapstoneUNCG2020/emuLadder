package com.uncg.emuLadder.model.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class EventPoints {
    @Id
    private int eventPointsId;

    private int eventId;

    private int playerId;

    private int points;

    public int getEventPointsId() {
        return eventPointsId;
    }

    public void setEventPointsId(int eventPointsId) {
        this.eventPointsId = eventPointsId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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

        EventPoints that = (EventPoints) o;
        return eventPointsId == that.eventPointsId &&
                eventId == that.eventId &&
                playerId == that.playerId &&
                points == that.points;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventPointsId, eventId, playerId, points);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EventPoints{");
        sb.append("eventPointsId=").append(eventPointsId);
        sb.append(", eventId=").append(eventId);
        sb.append(", playerId=").append(playerId);
        sb.append(", points=").append(points);
        sb.append('}');
        return sb.toString();
    }
}
