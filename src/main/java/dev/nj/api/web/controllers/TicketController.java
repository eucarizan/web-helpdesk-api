package dev.nj.api.web.controllers;

import dev.nj.api.services.TicketService;
import dev.nj.api.web.dto.NewTicketDto;
import dev.nj.api.web.dto.TicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping
    public List<TicketDto> getAll() {
        return ticketService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(ticketService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TicketDto> addTicket(@RequestBody NewTicketDto newTicketDto) {
        return ResponseEntity.ok(ticketService.addTicket(newTicketDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTicket(@PathVariable long id, @RequestBody NewTicketDto updateTicketDto) {
        ticketService.updateTicket(id, updateTicketDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}
