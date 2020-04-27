package com.uncg.emuLadder.model.response;

import java.util.Objects;

public class Player {
    /**
     * URL location for the image of the player.
     */
    private String image;

    /**
     * Display name of the player.
     */
    private String name;

    /**
     * Role of the player.
     */
    private String role;

    /**
     * Current rank of the player for the contest.
     */
    private int rank;

    /**
     * Amount the player costs to draft.
     */
    private double salary;

    /**
     * The unique ID for the player.
     */
    private String playerId;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return rank == player.rank &&
                Double.compare(player.salary, salary) == 0 &&
                Objects.equals(image, player.image) &&
                Objects.equals(name, player.name) &&
                Objects.equals(role, player.role) &&
                Objects.equals(playerId, player.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, name, role, rank, salary, playerId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player{");
        sb.append("image='").append(image).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", role='").append(role).append('\'');
        sb.append(", rank=").append(rank);
        sb.append(", salary=").append(salary);
        sb.append(", playerId='").append(playerId).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
