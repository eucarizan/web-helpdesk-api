package dev.nj.api.entities;

import dev.nj.api.dictionaries.Department;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "employee_number")
    private String employeeNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "department")
    private Department department;

    @OneToMany(mappedBy = "assignee")
//    @JsonIgnoreProperties({"assignee", "watchers"})
    private Set<Ticket> assignedTickets = new HashSet<>();

    @ManyToMany(mappedBy = "watchers")
//    @JsonIgnoreProperties({"assignee", "watchers"})
    private Set<Ticket> watchedTickets = new HashSet<>();

    public Employee() {}

    public Employee(String firstName, String middleName, String lastName, Department department) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(long id) {
        this.employeeNumber = String.format("emp-%06d", id).replace(' ', '0');
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    void addAssignedTicket(Ticket ticket) {
        assignedTickets.add(ticket);
    }

    public Set<Ticket> getAssignedTickets() {
        return Collections.unmodifiableSet(assignedTickets);
    }

    void addWatchedTicket(Ticket ticket) {
        watchedTickets.add(ticket);
    }

    public Set<Ticket> getWatchedTickets() {
        return Collections.unmodifiableSet(watchedTickets);
    }
}
