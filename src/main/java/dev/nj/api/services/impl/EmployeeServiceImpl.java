package dev.nj.api.services.impl;

import dev.nj.api.dictionaries.Department;
import dev.nj.api.entities.Employee;
import dev.nj.api.exceptions.EmployeeNotFoundException;
import dev.nj.api.repositories.EmployeeRepository;
import dev.nj.api.services.EmployeeService;
import dev.nj.api.web.dto.EmployeeDto;
import dev.nj.api.web.dto.NewEmployeeDto;
import dev.nj.api.web.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto getById(long id) throws EmployeeNotFoundException {
        return employeeMapper.toDto(getEmployeeById(id));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDto addEmployee(NewEmployeeDto newEmployeeDto) {
        Employee employee = employeeRepository.save(employeeMapper.toEntity(newEmployeeDto));
        employee.setEmployeeNumber(employee.getId());
        employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

    @Override
    public void updateEmployee(long id, NewEmployeeDto employeeDto) throws EmployeeNotFoundException {
        Employee employee = getEmployeeById(id);

        employee.setFirstName(employeeDto.firstName());
        employee.setMiddleName(employeeDto.middleName());
        employee.setLastName(employeeDto.lastName());
        employee.setDepartment(Department.valueOf(employeeDto.department()));
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long id) throws EmployeeNotFoundException {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }

    private Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }
}
