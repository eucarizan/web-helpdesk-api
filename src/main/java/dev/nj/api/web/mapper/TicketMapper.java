package dev.nj.api.web.mapper;

import dev.nj.api.dictionaries.Severity;
import dev.nj.api.dictionaries.Status;
import dev.nj.api.entities.Ticket;
import dev.nj.api.web.dto.NewTicketDto;
import dev.nj.api.web.dto.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TicketMapper {
    @Autowired
    BasicMapper basicMapper;

    public TicketDto toDto(Ticket ticket) {
        if (ticket.getAssignee() == null) {
            return new TicketDto(
                    ticket.getId(),
                    ticket.getTitle(),
                    ticket.getDescription(),
                    ticket.getSeverity().toString(),
                    ticket.getStatus().toString());
        }

        return new TicketDto(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getSeverity().toString(),
                ticket.getStatus().toString(),
                basicMapper.toEmployeeBasicDto(ticket.getAssignee()),
                ticket.getWatchers().stream().map(basicMapper::toEmployeeBasicDto).collect(Collectors.toSet())
        );
    }

    public Ticket toEntity(NewTicketDto dto) {
        return new Ticket(
                dto.title(),
                dto.description(),
                Severity.valueOf(dto.severity()),
                Status.valueOfString(dto.status())
        );
    }

}
