package dev.nj.api.repositories;

import dev.nj.api.entities.Employee;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends ListCrudRepository<Employee, Long> {
}
