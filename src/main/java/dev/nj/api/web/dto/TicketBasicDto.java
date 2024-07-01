package dev.nj.api.web.dto;

public class TicketBasicDto {

    long id;
    String title;
    String description;
    String severity;
    String status;

    public TicketBasicDto(long id, String title, String description, String severity, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSeverity() {
        return severity;
    }

    public String getStatus() {
        return status;
    }
}
