package dev.nj.api.entities;

import dev.nj.api.dictionaries.Severity;
import dev.nj.api.dictionaries.Status;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
//    @JsonIgnoreProperties({"assignedTickets, watchedTickets"})
    private Employee assignee;

    @ManyToMany
    @JoinTable(
            name = "ticket_watcher",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
//    @JsonIgnoreProperties({"assignedTickets, watchedTickets"})
    private Set<Employee> watchers = new HashSet<>();

    public Ticket() {}

    public Ticket(String title, String description, Severity severity, Status status) {
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAssignee(Employee employee) {
        if (employee == null) {
            throw new NullPointerException("Can't set null employee");
        }
        if (this.assignee != null) {
            throw new IllegalStateException("Ticket with id %d is already assigned".formatted(id));
        }
        this.assignee = employee;
        this.assignee.addAssignedTicket(this);
    }

    public Employee getAssignee() {
        return assignee;
    }

    public void addWatcher(Employee employee) {
        if (employee == null) {
            throw new NullPointerException("Can't set null employee");
        }
        if (employee.getWatchedTickets().contains(this)) {
            throw new IllegalStateException("Ticket with id %d is already watched by employee with id %s".formatted(id, employee.getEmployeeNumber()));
        }
        watchers.add(employee);
        employee.addWatchedTicket(this);
    }

    public Set<Employee> getWatchers() {
        return Collections.unmodifiableSet(watchers);
    }
}
