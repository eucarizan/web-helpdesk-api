package dev.nj.api.services.impl;

import dev.nj.api.dictionaries.Severity;
import dev.nj.api.dictionaries.Status;
import dev.nj.api.entities.Ticket;
import dev.nj.api.exceptions.TicketNotFoundException;
import dev.nj.api.repositories.TicketRepository;
import dev.nj.api.services.TicketService;
import dev.nj.api.web.dto.NewTicketDto;
import dev.nj.api.web.dto.TicketDto;
import dev.nj.api.web.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TicketMapper ticketMapper;

    @Override
    public TicketDto getById(long id) throws TicketNotFoundException {
        return ticketMapper.toDto(getTicketById(id));
    }

    private Ticket getTicketById(long id) {
        return ticketRepository.findById(id).orElseThrow(TicketNotFoundException::new);
    }

    @Override
    public List<TicketDto> getAll() {
        return ticketRepository.findAll().stream().map(ticketMapper::toDto).toList();
    }

    @Override
    public TicketDto addTicket(NewTicketDto newTicketDto) {
        return ticketMapper.toDto(ticketRepository.save(ticketMapper.toEntity(newTicketDto)));
    }

    @Override
    public void updateTicket(long id, NewTicketDto updateTicketDto) throws TicketNotFoundException {
        Ticket ticket = getTicketById(id);

        ticket.setTitle(updateTicketDto.title());
        ticket.setDescription(updateTicketDto.description());
        ticket.setSeverity(Severity.valueOf(updateTicketDto.severity()));
        ticket.setStatus(Status.valueOf(updateTicketDto.status()));
        ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(long id) throws TicketNotFoundException {
        Ticket ticket = getTicketById(id);
        ticketRepository.delete(ticket);
    }
}
