package com.uncg.emuLadder.model.request;

import java.util.Objects;

public class ResetPasswordRequestData {
    private String email;

    private String oldPassword;

    private String newPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResetPasswordRequestData)) return false;
        ResetPasswordRequestData that = (ResetPasswordRequestData) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(oldPassword, that.oldPassword) &&
                Objects.equals(newPassword, that.newPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, oldPassword, newPassword);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResetPasswordRequestData{");
        sb.append("email='").append(email).append('\'');
        sb.append(", oldPassword='").append(oldPassword).append('\'');
        sb.append(", newPassword='").append(newPassword).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
