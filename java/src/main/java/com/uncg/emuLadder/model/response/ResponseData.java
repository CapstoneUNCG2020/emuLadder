package com.uncg.emuLadder.model.response;

import java.util.Map;
import java.util.Objects;

public class ResponseData<T> {
    private String status;

    private Map<String, String> errors;

    private T response;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseData)) return false;
        ResponseData<?> that = (ResponseData<?>) o;
        return Objects.equals(status, that.status) &&
                Objects.equals(errors, that.errors) &&
                Objects.equals(response, that.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, errors, response);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResponseData{");
        sb.append("status='").append(status).append('\'');
        sb.append(", errors=").append(errors);
        sb.append(", response=").append(response);
        sb.append('}');
        return sb.toString();
    }
}
