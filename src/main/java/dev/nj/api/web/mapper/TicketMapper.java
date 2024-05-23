package dev.nj.api.web.mapper;

import dev.nj.api.dictionaries.Severity;
import dev.nj.api.dictionaries.Status;
import dev.nj.api.entities.Ticket;
import dev.nj.api.web.dto.NewTicketDto;
import dev.nj.api.web.dto.TicketDto;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    public TicketDto toDto(Ticket ticket) {
        return new TicketDto(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getSeverity().toString(),
                ticket.getStatus().toString()
        );
    }

    public Ticket toEntity(NewTicketDto dto) {
        return new Ticket(
                dto.title(),
                dto.description(),
                Severity.valueOf(dto.severity()),
                Status.valueOf(dto.status())
        );
    }
}
