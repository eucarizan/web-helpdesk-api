package dev.nj.api.web.dto;

import java.util.HashSet;
import java.util.Set;

public class TicketDto extends TicketBasicDto {
    EmployeeBasicDto assignee;
    Set<EmployeeBasicDto> watchers;

    public TicketDto(long id, String title, String description, String severity, String status) {
        super(id, title, description, severity, status);
        this.assignee = null;
        this.watchers = new HashSet<>();
    }

    public TicketDto(long id, String title, String description, String severity, String status, EmployeeBasicDto assignee, Set<EmployeeBasicDto> watchers) {
        this(id, title, description, severity, status);
        this.assignee = assignee;
        this.watchers = watchers;
    }

    public EmployeeBasicDto getAssignee() {
        return assignee;
    }

    public Set<EmployeeBasicDto> getWatchers() {
        return watchers;
    }
}
