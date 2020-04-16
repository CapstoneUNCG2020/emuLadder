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

    private int contestType;

    private int contestSize;

    private double entreeFee;

    private double prizeAmount;

    private String region;

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

    public int getContestType() {
        return contestType;
    }

    public void setContestType(int contestType) {
        this.contestType = contestType;
    }

    public int getContestSize() {
        return contestSize;
    }

    public void setContestSize(int contestSize) {
        this.contestSize = contestSize;
    }

    public double getEntreeFee() {
        return entreeFee;
    }

    public void setEntreeFee(double entreeFee) {
        this.entreeFee = entreeFee;
    }

    public double getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(double prizeAmount) {
        this.prizeAmount = prizeAmount;
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
        if (!(o instanceof Contests)) return false;
        Contests contests = (Contests) o;
        return contestId == contests.contestId &&
                currentState == contests.currentState &&
                contestType == contests.contestType &&
                contestSize == contests.contestSize &&
                Double.compare(contests.entreeFee, entreeFee) == 0 &&
                Double.compare(contests.prizeAmount, prizeAmount) == 0 &&
                Objects.equals(createdBy, contests.createdBy) &&
                Objects.equals(startTime, contests.startTime) &&
                Objects.equals(name, contests.name) &&
                Objects.equals(region, contests.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contestId, createdBy, startTime, name, currentState, contestType, contestSize, entreeFee, prizeAmount, region);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contests{");
        sb.append("contestId=").append(contestId);
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", name='").append(name).append('\'');
        sb.append(", currentState=").append(currentState);
        sb.append(", contestType=").append(contestType);
        sb.append(", contestSize=").append(contestSize);
        sb.append(", entreeFee=").append(entreeFee);
        sb.append(", prizeAmount=").append(prizeAmount);
        sb.append(", region='").append(region).append('\'');
        sb.append('}');
        return sb.toString();
    }
}