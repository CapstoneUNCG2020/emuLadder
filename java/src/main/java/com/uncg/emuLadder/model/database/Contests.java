package com.uncg.emuLadder.model.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Contests {
    @Id
    private int contestId;

    private String createdBy;

    private Date startTime;

    private String name;

    private int currentState;

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        Contests contests = (Contests) o;
        return currentState == contests.currentState &&
                contestId == contests.contestId &&
                Objects.equals(createdBy, contests.createdBy) &&
                Objects.equals(startTime, contests.startTime) &&
                Objects.equals(name, contests.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contestId, createdBy, startTime, name, currentState);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contests{");
        sb.append("contestId='").append(contestId).append('\'');
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", name='").append(name).append('\'');
        sb.append(", currentState=").append(currentState);
        sb.append('}');
        return sb.toString();
    }
}
