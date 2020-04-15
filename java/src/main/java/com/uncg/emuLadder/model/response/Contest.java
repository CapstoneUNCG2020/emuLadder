package com.uncg.emuLadder.model.response;

import java.sql.Date;
import java.util.Objects;

public class Contest {
    private String name;

    private Date start;

    private String contestType;

    private int currentEntries;

    private int totalEntries;

    private double entreeFee;

    private double prizeAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public String getContestType() {
        return contestType;
    }

    public void setContestType(String contestType) {
        this.contestType = contestType;
    }

    public int getCurrentEntries() {
        return currentEntries;
    }

    public void setCurrentEntries(int currentEntries) {
        this.currentEntries = currentEntries;
    }

    public int getTotalEntries() {
        return totalEntries;
    }

    public void setTotalEntries(int totalEntries) {
        this.totalEntries = totalEntries;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contest)) return false;
        Contest contest = (Contest) o;
        return currentEntries == contest.currentEntries &&
                totalEntries == contest.totalEntries &&
                Double.compare(contest.entreeFee, entreeFee) == 0 &&
                Double.compare(contest.prizeAmount, prizeAmount) == 0 &&
                Objects.equals(name, contest.name) &&
                Objects.equals(start, contest.start) &&
                Objects.equals(contestType, contest.contestType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, start, contestType, currentEntries, totalEntries, entreeFee, prizeAmount);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", start=").append(start);
        sb.append(", contestType='").append(contestType).append('\'');
        sb.append(", currentEntries=").append(currentEntries);
        sb.append(", totalEntries=").append(totalEntries);
        sb.append(", entreeFee=").append(entreeFee);
        sb.append(", prizeAmount=").append(prizeAmount);
        sb.append('}');
        return sb.toString();
    }
}
