package com.uncg.emuLadder.model.response;

import java.sql.Timestamp;
import java.util.Objects;

public class EventData {
    /**
     * Unique ID for the event.
     */
    private int eventId;

    /**
     * The name of the contest the event is in
     */
    private String name;

    /**
     * Time when the event starts.
     */
    private Timestamp startTime;

    /**
     * current state of event represented by integer.
     */
    private int currentState;

    /**
     * link within event
     */
    private String link;

    /**
     * Team name of first team
     */
    private String teamName;

    /**
     * Team code of first team
     */
    private String teamCode;

    /**
     * Team name of second team
     */
    private String teamName2;

    /**
     * Team name of first team
     */
    private String teamCode2;

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
        if (!(o instanceof EventData)) return false;
        EventData eventData = (EventData) o;
        return currentState == eventData.currentState &&
                Objects.equals(eventId, eventData.eventId) &&
                Objects.equals(name, eventData.name) &&
                Objects.equals(startTime, eventData.startTime) &&
                Objects.equals(link, eventData.link) &&
                Objects.equals(teamName, eventData.teamName) &&
                Objects.equals(teamCode, eventData.teamCode) &&
                Objects.equals(teamName2, eventData.teamName2) &&
                Objects.equals(teamCode2, eventData.teamCode2);
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
