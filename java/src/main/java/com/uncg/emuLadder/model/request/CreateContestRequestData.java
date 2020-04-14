package com.uncg.emuLadder.model.request;

import java.sql.Date;
import java.util.Objects;

/**
 * Request data sent to create a new contest.
 */
public class CreateContestRequestData {
    /**
     * The date that the contest starts
     */
    private Date start;

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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateContestRequestData)) return false;
        CreateContestRequestData that = (CreateContestRequestData) o;
        return entreeFee == that.entreeFee &&
                contestType == that.contestType &&
                Objects.equals(start, that.start) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, entreeFee, contestType, name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateContestRequestData{");
        sb.append("start=").append(start);
        sb.append(", entreeFee=").append(entreeFee);
        sb.append(", contestType=").append(contestType);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
