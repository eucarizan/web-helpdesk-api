package dev.nj.api.repositories;

import dev.nj.api.entities.Employee;
import dev.nj.api.entities.Ticket;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends ListCrudRepository<Ticket, Long> {
    List<Ticket> findByAssignee(Employee employee);
}
