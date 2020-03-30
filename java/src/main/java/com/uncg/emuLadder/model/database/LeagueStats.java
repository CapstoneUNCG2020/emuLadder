package com.uncg.emuLadder.model.database;

import com.uncg.emuLadder.model.database.compositekeys.LeagueStatsId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Objects;

@Entity
@IdClass(LeagueStatsId.class)
public class LeagueStats {
    @Id
    private String matchId;

    @Id
    private int participantNumber;

    private int kills;

    private int deaths;

    private int assists;

    private int creepScore;

    private String teamId;

    private int turrets;

    private int dragons;

    private int barons;

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public int getParticipantNumber() {
        return participantNumber;
    }

    public void setParticipantNumber(int participantNumber) {
        this.participantNumber = participantNumber;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
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

    public int getCreepScore() {
        return creepScore;
    }

    public void setCreepScore(int creepScore) {
        this.creepScore = creepScore;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public int getTurrets() {
        return turrets;
    }

    public void setTurrets(int turrets) {
        this.turrets = turrets;
    }

    public int getDragons() {
        return dragons;
    }

    public void setDragons(int dragons) {
        this.dragons = dragons;
    }

    public int getBarons() {
        return barons;
    }

    public void setBarons(int barons) {
        this.barons = barons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeagueStats)) return false;
        LeagueStats that = (LeagueStats) o;
        return participantNumber == that.participantNumber &&
                kills == that.kills &&
                deaths == that.deaths &&
                assists == that.assists &&
                creepScore == that.creepScore &&
                turrets == that.turrets &&
                dragons == that.dragons &&
                barons == that.barons &&
                Objects.equals(matchId, that.matchId) &&
                Objects.equals(teamId, that.teamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, participantNumber, kills, deaths, assists, creepScore, teamId, turrets, dragons, barons);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LeagueStats{");
        sb.append("matchId='").append(matchId).append('\'');
        sb.append(", participantNumber=").append(participantNumber);
        sb.append(", kills=").append(kills);
        sb.append(", deaths=").append(deaths);
        sb.append(", assists=").append(assists);
        sb.append(", creepScore=").append(creepScore);
        sb.append(", teamId='").append(teamId).append('\'');
        sb.append(", turrets=").append(turrets);
        sb.append(", dragons=").append(dragons);
        sb.append(", barons=").append(barons);
        sb.append('}');
        return sb.toString();
    }
}
