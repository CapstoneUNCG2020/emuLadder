package com.uncg.emuLadder.model.database;

import com.uncg.emuLadder.model.database.compositekeys.LeagueStatsId;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import static com.uncg.emuLadder.enums.LeagueScoring.*;

@Entity
public class LeagueStats {
    @Id
    private LeagueStatsId leagueStatsId;

    private int kills;

    private int deaths;

    private int assists;

    private int creepScore;

    private String teamId;

    private int turrets;

    private int dragons;

    private int barons;

    public LeagueStatsId getLeagueStatsId() {
        return leagueStatsId;
    }

    public void setLeagueStatsId(LeagueStatsId leagueStatsId) {
        this.leagueStatsId = leagueStatsId;
    }

    public String getMatchId() {
        return leagueStatsId.getMatchId();
    }

    public void setMatchId(String matchId) {
        if (leagueStatsId == null) leagueStatsId = new LeagueStatsId();

        leagueStatsId.setMatchId(matchId);
    }

    public int getParticipantNumber() {
        return leagueStatsId.getParticipantNumber();
    }

    public void setParticipantNumber(int participantNumber) {
        if (leagueStatsId == null) leagueStatsId = new LeagueStatsId();

        leagueStatsId.setParticipantNumber(participantNumber);
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
        return kills == that.kills &&
                deaths == that.deaths &&
                assists == that.assists &&
                creepScore == that.creepScore &&
                turrets == that.turrets &&
                dragons == that.dragons &&
                barons == that.barons &&
                Objects.equals(leagueStatsId, that.leagueStatsId) &&
                Objects.equals(teamId, that.teamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leagueStatsId, kills, deaths, assists, creepScore, teamId, turrets, dragons, barons);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LeagueStats{");

        if (leagueStatsId != null) {
            sb.append("matchId='").append(leagueStatsId.getMatchId()).append('\'');
            sb.append(", participantNumber=").append(leagueStatsId.getParticipantNumber());
        } else {
            sb.append("leagueStatsId='").append(leagueStatsId).append('\'');
        }

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

    /**
     * Return the point value for the league match.
     *
     * @return - int value of the sum of points
     */
    public int calculate() {
        int points = 0;

        points += kills * KILL.getValue();
        points += deaths * DEATH.getValue();
        points += assists * ASSIST.getValue();
        points += creepScore * CREEP_SCORE.getValue();
        points += TURRETS.getValue();
        points += DRAGONS.getValue();
        points += BARONS.getValue();

        return points;
    }
}
