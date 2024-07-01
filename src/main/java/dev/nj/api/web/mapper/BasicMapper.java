package dev.nj.api.web.mapper;

import dev.nj.api.entities.Employee;
import dev.nj.api.entities.Ticket;
import dev.nj.api.web.dto.EmployeeBasicDto;
import dev.nj.api.web.dto.TicketBasicDto;
import org.springframework.stereotype.Component;

@Component
public class BasicMapper {
    public EmployeeBasicDto toEmployeeBasicDto(Employee employee) {
        return new EmployeeBasicDto(
                employee.getEmployeeNumber(),
                employee.getFirstName(),
                employee.getMiddleName(),
                employee.getLastName(),
                employee.getDepartment().toString()
        );
    }

    public TicketBasicDto toTicketBasicDto(Ticket ticket) {
        return new TicketBasicDto(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getSeverity().toString(),
                ticket.getStatus().toString()
        );
    }
}
