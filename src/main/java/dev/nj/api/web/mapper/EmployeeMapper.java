package dev.nj.api.web.mapper;

import dev.nj.api.dictionaries.Department;
import dev.nj.api.entities.Employee;
import dev.nj.api.web.dto.EmployeeDto;
import dev.nj.api.web.dto.NewEmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeDto toDto(Employee employee) {
        return new EmployeeDto(
                employee.getEmployeeNumber().toString(),
                employee.getFirstName(),
                employee.getMiddleName(),
                employee.getLastName(),
                employee.getDepartment().toString()
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
