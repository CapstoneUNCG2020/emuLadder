package com.uncg.emuLadder.model.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Events {
    @Id
    private int eventId;

    private String name;

    private Date startTime;

    private int currentState;

    private String link;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

        Events events = (Events) o;
        return eventId == events.eventId &&
                currentState == events.currentState &&
                Objects.equals(name, events.name) &&
                Objects.equals(startTime, events.startTime) &&
                Objects.equals(link, events.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, name, startTime, currentState, link);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Events{");
        sb.append("eventId=").append(eventId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", currentState=").append(currentState);
        sb.append(", link='").append(link).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
