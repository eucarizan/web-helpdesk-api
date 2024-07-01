package dev.nj.api.services;

import dev.nj.api.entities.Employee;
import dev.nj.api.exceptions.EmployeeNotFoundException;
import dev.nj.api.web.dto.EmployeeDto;
import dev.nj.api.web.dto.NewEmployeeDto;
import dev.nj.api.web.dto.TicketDto;

import java.util.List;

public interface EmployeeService {
    /**
     * find and retrieve an employee with the given id
     *
     * @param id employee id
     * @return employee
     * @throws EmployeeNotFoundException if employee does not exist
     */
    EmployeeDto getById(long id) throws EmployeeNotFoundException;

    /**
     * get all employees
     *
     * @return list of employees
     */
    List<EmployeeDto> getAll();

    /**
     * add new employee
     *
     * @param newEmployeeDto employee details
     * @return employee
     */
    EmployeeDto addEmployee(NewEmployeeDto newEmployeeDto);

    /**
     * update an existing employee
     *
     * @param id employee id
     * @param employeeDto employee details
     * @throws EmployeeNotFoundException if employee does not exist
     */
    void updateEmployee(long id, NewEmployeeDto employeeDto) throws EmployeeNotFoundException;

    /**
     * delete an existing employee
     * @param id employee id
     * @throws EmployeeNotFoundException if employee does not exist
     */
    void deleteEmployee(long id) throws EmployeeNotFoundException;

    // TODO: add ticket endpoints
    List<TicketDto> getAssignedTickets(long id) throws EmployeeNotFoundException;

    List<TicketDto> getWatchedTickets(long id) throws EmployeeNotFoundException;
}
