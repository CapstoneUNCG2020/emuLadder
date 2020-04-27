package com.uncg.emuLadder.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ContestEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contestEventsId;

    private int contestId;

    private String eventId;

    public int getContestEventsId() {
        return contestEventsId;
    }

    public void setContestEventsId(int contestEventsId) {
        this.contestEventsId = contestEventsId;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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

        ContestEvents that = (ContestEvents) o;
        return contestEventsId == that.contestEventsId &&
                contestId == that.contestId &&
                Objects.equals(eventId, that.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contestEventsId, contestId, eventId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContestEvents{");
        sb.append("contestEventsId=").append(contestEventsId);
        sb.append(", contestId=").append(contestId);
        sb.append(", eventId=").append(eventId);
        sb.append('}');
        return sb.toString();
    }
}