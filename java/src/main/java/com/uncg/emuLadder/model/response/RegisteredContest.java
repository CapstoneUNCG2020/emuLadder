package com.uncg.emuLadder.model.response;

import java.util.List;
import java.util.Objects;

public class RegisteredContest {
    private Contest contest;

    private List<Player> players;

    private int rank;

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisteredContest)) return false;
        RegisteredContest that = (RegisteredContest) o;
        return rank == that.rank &&
                Objects.equals(contest, that.contest) &&
                Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contest, players, rank);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RegisteredContest{");
        sb.append("contest=").append(contest);
        sb.append(", players=").append(players);
        sb.append(", rank=").append(rank);
        sb.append('}');
        return sb.toString();
    }
}
