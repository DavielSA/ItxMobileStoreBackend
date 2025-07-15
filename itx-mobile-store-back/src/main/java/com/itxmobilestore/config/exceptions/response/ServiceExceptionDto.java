package com.itxmobilestore.config.exceptions.response;

import java.time.OffsetDateTime;
import java.util.List;

public class ServiceExceptionDto {
    private OffsetDateTime date;
    private String key;
    private String message;
    private List<String> messages;

    private String detail;
    private List<String> details;
    private Boolean singleResponse;

    public void setDate(OffsetDateTime date) { this.date = date; }

    public OffsetDateTime getDate() { return date; }

    public void setKey(String key) { this.key = key; }
    public String getKey() { return this.key; }

    public void setMessage(String message) { this.message = message; }
    public String getMessage() { return this.message; }

    public void setMessages(List<String> messages) { this.messages = messages; }
    public List<String> getMessages() { return this.messages; }

    public void setDetail(String detail) { this.detail = detail; }
    public String getDetail() { return this.detail; }

    public void setDetails(List<String> details) { this.details = details; }
    public List<String> getDetails() { return this.details; }

    public void setSingleResponse(Boolean singleResponse) { this.singleResponse = singleResponse; }
    public Boolean getSingleResponse() { return this.singleResponse; }

    public ServiceExceptionDto() {}
    public ServiceExceptionDto(
            String key,
            String message,
            String detail
    ) {
        this.key = key;
        this.message = message;
        this.detail = detail;
        this.singleResponse = true;
        this.date = OffsetDateTime.now();
    }
    public ServiceExceptionDto(
            String key,
            List<String> messages,
            List<String> details
    ) {
        this.key = key;
        this.messages = messages;
        this.details = details;
        this.singleResponse = false;
        this.date = OffsetDateTime.now();
    }
}
