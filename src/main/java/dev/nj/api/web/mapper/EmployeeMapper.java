package dev.nj.api.web.mapper;

import dev.nj.api.dictionaries.Department;
import dev.nj.api.entities.Employee;
import dev.nj.api.web.dto.EmployeeDto;
import dev.nj.api.web.dto.NewEmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EmployeeMapper {
    @Autowired
    BasicMapper basicMapper;

    public EmployeeDto toDto(Employee employee) {
        return new EmployeeDto(
                employee.getEmployeeNumber(),
                employee.getFirstName(),
                employee.getMiddleName(),
                employee.getLastName(),
                employee.getDepartment().toString(),
                employee.getAssignedTickets().stream().map(basicMapper::toTicketBasicDto).collect(Collectors.toSet()),
                employee.getWatchedTickets().stream().map(basicMapper::toTicketBasicDto).collect(Collectors.toSet())
        );
    }

    public Employee toEntity(NewEmployeeDto dto) {
        return new Employee(
                dto.firstName(),
                dto.middleName(),
                dto.lastName(),
                Department.valueOf(dto.department())
        );
    }
}
