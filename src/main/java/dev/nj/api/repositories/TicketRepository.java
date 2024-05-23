package dev.nj.api.repositories;

import dev.nj.api.entities.Ticket;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends ListCrudRepository<Ticket, Long> {
}
