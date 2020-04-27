package com.uncg.emuLadder.model.request;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Request data sent to create a new contest.
 */
public class CreateContestRequestData {
    /**
     * The date that the contest starts
     */
    private Timestamp start;

    /**
     * The price to enter contest
     */
    private int entreeFee;

    /**
     * The type of contest { 1. HEAD-TO-HEAD, 2. PUBLIC, 3. PRIVATE }
     */
    private int contestType;

    /**
     * Name of the contest.
     */
    private String name;

    /**
     * Email of person who created the event.
     */
    private String createdBy;

    /**
     * Region for the event.
     */
    private String region;

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public int getEntreeFee() {
        return entreeFee;
    }

    public void setEntreeFee(int entreeFee) {
        this.entreeFee = entreeFee;
    }

    public int getContestType() {
        return contestType;
    }

    public void setContestType(int contestType) {
        this.contestType = contestType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateContestRequestData)) return false;
        CreateContestRequestData that = (CreateContestRequestData) o;
        return entreeFee == that.entreeFee &&
                contestType == that.contestType &&
                Objects.equals(start, that.start) &&
                Objects.equals(name, that.name) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(region, that.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, entreeFee, contestType, name, createdBy, region);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateContestRequestData{");
        sb.append("start=").append(start);
        sb.append(", entreeFee=").append(entreeFee);
        sb.append(", contestType=").append(contestType);
        sb.append(", name='").append(name).append('\'');
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append(", region='").append(region).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
