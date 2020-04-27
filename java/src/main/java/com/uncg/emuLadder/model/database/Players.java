package com.uncg.emuLadder.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Players {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String playerId;

    private String firstName;

    private String lastName;

    private String displayName;

    private String image;

    private int salary;

    private String teamId;

    private String teamName;

    private String teamCode;

    private String role;

    private String region;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        if (!(o instanceof Players)) return false;
        Players players = (Players) o;
        return Objects.equals(playerId, players.playerId) &&
                salary == players.salary &&
                Objects.equals(firstName, players.firstName) &&
                Objects.equals(lastName, players.lastName) &&
                Objects.equals(displayName, players.displayName) &&
                Objects.equals(image, players.image) &&
                Objects.equals(teamId, players.teamId) &&
                Objects.equals(teamName, players.teamName) &&
                Objects.equals(teamCode, players.teamCode) &&
                Objects.equals(role, players.role) &&
                Objects.equals(region, players.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, firstName, lastName, displayName, image, salary, teamId, teamName, teamCode,
                role, region);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Players{");
        sb.append("playerId=").append(playerId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", displayName='").append(displayName).append('\'');
        sb.append(", image='").append(image).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", teamId='").append(teamId).append('\'');
        sb.append(", teamName='").append(teamName).append('\'');
        sb.append(", teamCode='").append(teamCode).append('\'');
        sb.append(", role='").append(role).append('\'');
        sb.append(", region='").append(region).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
