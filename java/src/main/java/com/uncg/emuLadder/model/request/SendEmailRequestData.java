package com.uncg.emuLadder.model.request;

import java.util.Objects;

public class SendEmailRequestData {

    private String recipient;

    private String subject;

    private String content;

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SendEmailRequestData)) return false;
        SendEmailRequestData that = (SendEmailRequestData) o;
        return Objects.equals(recipient, that.recipient) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipient, subject, content);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SendEmailRequestData{");
        sb.append("recipient='").append(recipient).append('\'');
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
