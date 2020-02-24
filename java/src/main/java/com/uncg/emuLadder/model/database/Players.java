package com.uncg.emuLadder.model.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Players {
    @Id
    private int playerId;

    private String firstName;

    private String lastName;

    private String displayName;

    private String image;

    private int salary;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
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

        Players players = (Players) o;
        return playerId == players.playerId &&
                salary == players.salary &&
                Objects.equals(firstName, players.firstName) &&
                Objects.equals(lastName, players.lastName) &&
                Objects.equals(displayName, players.displayName) &&
                Objects.equals(image, players.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, firstName, lastName, displayName, image, salary);
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
        sb.append('}');
        return sb.toString();
    }
}
