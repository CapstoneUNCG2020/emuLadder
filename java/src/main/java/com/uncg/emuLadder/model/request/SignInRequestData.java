package com.uncg.emuLadder.model.request;

import java.util.Objects;

public class SignInRequestData {
    private String userId;
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        SignInRequestData that = (SignInRequestData) obj;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, password);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SignInRequestData{");
        sb.append("userId='").append(userId).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
