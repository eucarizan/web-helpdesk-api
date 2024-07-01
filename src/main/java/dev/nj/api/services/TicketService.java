package dev.nj.api.services;

import dev.nj.api.entities.Employee;
import dev.nj.api.exceptions.EmployeeNotFoundException;
import dev.nj.api.exceptions.TicketNotFoundException;
import dev.nj.api.web.dto.NewTicketDto;
import dev.nj.api.web.dto.TicketDto;

import java.util.List;

public interface TicketService {
    TicketDto getById(long id) throws TicketNotFoundException;

    List<TicketDto> getAll();

    TicketDto addTicket(NewTicketDto newTicketDto);

    void updateTicket(long id, NewTicketDto updateTicketDto) throws TicketNotFoundException;

    void deleteTicket(long id) throws TicketNotFoundException;

    void addAssignee(long ticketId, long employeeId) throws TicketNotFoundException, EmployeeNotFoundException;

    void addWatcher(long ticketId, long employeeId) throws TicketNotFoundException, EmployeeNotFoundException;

    List<TicketDto> getByEmployee(long employeeId);
}
