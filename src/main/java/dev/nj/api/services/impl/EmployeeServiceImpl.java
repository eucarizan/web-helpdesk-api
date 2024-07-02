package dev.nj.api.services.impl;

import dev.nj.api.dictionaries.Department;
import dev.nj.api.entities.Employee;
import dev.nj.api.exceptions.EmployeeHasAssignedTicketException;
import dev.nj.api.exceptions.EmployeeNotFoundException;
import dev.nj.api.repositories.EmployeeRepository;
import dev.nj.api.services.EmployeeService;
import dev.nj.api.web.dto.EmployeeDto;
import dev.nj.api.web.dto.NewEmployeeDto;
import dev.nj.api.web.dto.TicketDto;
import dev.nj.api.web.mapper.EmployeeMapper;
import dev.nj.api.web.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    TicketMapper ticketMapper;

    @Override
    public EmployeeDto getById(long id) throws EmployeeNotFoundException {
        return employeeMapper.toDto(getEmployeeById(id));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return employeeRepository.findAll().stream().map(employeeMapper::toDto).toList();
    }

    @Override
    public EmployeeDto addEmployee(NewEmployeeDto newEmployeeDto) {
        Employee newEmployee = employeeMapper.toEntity(newEmployeeDto);
        newEmployee.setEmployeeNumber(1);
        Employee employee = employeeRepository.save(newEmployee);
        employee.setEmployeeNumber(employee.getId());
        employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

    @Override
    public void updateEmployee(long id, NewEmployeeDto employeeDto) {
        Employee employee = getEmployeeById(id);

        employee.setFirstName(employeeDto.firstName());
        employee.setMiddleName(employeeDto.middleName());
        employee.setLastName(employeeDto.lastName());
        employee.setDepartment(Department.valueOf(employeeDto.department()));
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        Employee employee = getEmployeeById(id);
        if (!employee.getAssignedTickets().isEmpty()) {
            throw new EmployeeHasAssignedTicketException(id);
        }
        employeeRepository.delete(employee);
    }

    @Override
    public List<TicketDto> getAssignedTickets(long id) {
        Employee employee = getEmployeeById(id);
        return employee.getAssignedTickets().stream()
                .map(ticketMapper::toDto).toList();
    }

    @Override
    public List<TicketDto> getWatchedTickets(long id) {
        Employee employee = getEmployeeById(id);
        return employee.getWatchedTickets().stream()
                .map(ticketMapper::toDto).toList();
    }

    Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }
}
