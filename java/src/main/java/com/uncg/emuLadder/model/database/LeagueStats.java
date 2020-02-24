package com.uncg.emuLadder.model.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class LeagueStats {
    @Id
    private int eventPointsId;

    private int deaths;

    private int assists;

    private int kills;

    private int creepScore;

    public int getEventPointsId() {
        return eventPointsId;
    }

    public void setEventPointsId(int eventPointsId) {
        this.eventPointsId = eventPointsId;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getCreepScore() {
        return creepScore;
    }

    public void setCreepScore(int creepScore) {
        this.creepScore = creepScore;
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

        LeagueStats that = (LeagueStats) o;
        return eventPointsId == that.eventPointsId &&
                deaths == that.deaths &&
                assists == that.assists &&
                kills == that.kills &&
                creepScore == that.creepScore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventPointsId, deaths, assists, kills, creepScore);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LeagueStats{");
        sb.append("eventPointsId=").append(eventPointsId);
        sb.append(", deaths=").append(deaths);
        sb.append(", assists=").append(assists);
        sb.append(", kills=").append(kills);
        sb.append(", creepScore=").append(creepScore);
        sb.append('}');
        return sb.toString();
    }
}
