package io.github.tivecs.thinmail.model;

import java.util.Date;

public class Mail {

    private Long id;

    private final String senderId;

    private final String receiverId;

    private final String subject;

    private final String body;

    private final Date sendAt;

    public Mail(Long id, String senderId, String receiverId, String subject, String body, Date sendAt) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.subject = subject;
        this.body = body;
        this.sendAt = sendAt;
    }

    public Mail(String senderId, String receiverId, String subject, String body) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.subject = subject;
        this.body = body;
        this.sendAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public Date getSendAt() {
        return sendAt;
    }
}
