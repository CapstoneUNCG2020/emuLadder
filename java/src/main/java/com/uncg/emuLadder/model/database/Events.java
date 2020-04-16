package com.uncg.emuLadder.model.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Events {
    @Id
    private String eventId;

    private String name;

    private Timestamp startTime;

    private int currentState;

    private String link;

    private String teamName;

    private String teamCode;

    private String teamName2;

    private String teamCode2;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getTeamName2() {
        return teamName2;
    }

    public void setTeamName2(String teamName2) {
        this.teamName2 = teamName2;
    }

    public String getTeamCode2() {
        return teamCode2;
    }

    public void setTeamCode2(String teamCode2) {
        this.teamCode2 = teamCode2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Events)) return false;
        Events events = (Events) o;
        return currentState == events.currentState &&
                Objects.equals(eventId, events.eventId) &&
                Objects.equals(name, events.name) &&
                Objects.equals(startTime, events.startTime) &&
                Objects.equals(link, events.link) &&
                Objects.equals(teamName, events.teamName) &&
                Objects.equals(teamCode, events.teamCode) &&
                Objects.equals(teamName2, events.teamName2) &&
                Objects.equals(teamCode2, events.teamCode2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, name, startTime, currentState, link, teamName, teamCode, teamName2, teamCode2);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Events{");
        sb.append("eventId=").append(eventId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", currentState=").append(currentState);
        sb.append(", link='").append(link).append('\'');
        sb.append(", teamName='").append(teamName).append('\'');
        sb.append(", teamCode='").append(teamCode).append('\'');
        sb.append(", teamName2='").append(teamName2).append('\'');
        sb.append(", teamCode2='").append(teamCode2).append('\'');
        sb.append('}');
        return sb.toString();
    }
}