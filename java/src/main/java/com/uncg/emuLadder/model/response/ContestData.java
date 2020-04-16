package com.uncg.emuLadder.model.response;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class ContestData {
    /**
     * The name of the contest.
     */
    private String name;

    /**
     * Head-to-Head, Public, or Private
     */
    private String contestType;

    /**
     * Amount of spaces left in the contest to join.
     */
    private int remainingSpaces;

    /**
     * Total amount of spaces in the contest to join.
     */
    private int totalSpaces;

    /**
     * Amount it costs to join the contest
     */
    private double entryFee;

    /**
     * Amount that is received if contest is won.
     */
    private double prizeAmount;

    /**
     * Date and time the contest starts.
     */
    private Date startTime;

    private List<Player> players;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContestType() {
        return contestType;
    }

    public void setContestType(String contestType) {
        this.contestType = contestType;
    }

    public int getRemainingSpaces() {
        return remainingSpaces;
    }

    public void setRemainingSpaces(int remainingSpaces) {
        this.remainingSpaces = remainingSpaces;
    }

    public int getTotalSpaces() {
        return totalSpaces;
    }

    public void setTotalSpaces(int totalSpaces) {
        this.totalSpaces = totalSpaces;
    }

    public double getEntreeFee() {
        return entryFee;
    }

    public void setEntreeFee(double entreeFee) {
        this.entryFee = entreeFee;
    }

    public double getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(double prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContestData)) return false;
        ContestData that = (ContestData) o;
        return remainingSpaces == that.remainingSpaces &&
                totalSpaces == that.totalSpaces &&
                Double.compare(that.entryFee, entryFee) == 0 &&
                Double.compare(that.prizeAmount, prizeAmount) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(contestType, that.contestType) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, contestType, remainingSpaces, totalSpaces, entryFee, prizeAmount,
                startTime, players);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContestData{");
        sb.append("name='").append(name).append('\'');
        sb.append(", contestType='").append(contestType).append('\'');
        sb.append(", remainingSpaces=").append(remainingSpaces);
        sb.append(", totalSpaces=").append(totalSpaces);
        sb.append(", entreeFee=").append(entryFee);
        sb.append(", prizeAmount=").append(prizeAmount);
        sb.append(", startTime=").append(startTime);
        sb.append(", players=").append(players);
        sb.append('}');
        return sb.toString();
    }
}
