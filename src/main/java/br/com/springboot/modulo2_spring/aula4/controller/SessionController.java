package br.com.springboot.modulo2_spring.aula4.controller;

import br.com.springboot.modulo2_spring.aula4.model.Session;
import br.com.springboot.modulo2_spring.aula4.service.SessionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionController {

    private final SessionServiceImpl service;

    public SessionController(SessionServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/events/sessions")
    public ResponseEntity<Session> add(@RequestBody Session session) {
        return ResponseEntity.ok(service.addSession(session));
    }

    @GetMapping("/events/sessions/{id}")
    public ResponseEntity<Session> finById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getSessionById(id));
    }

    @GetMapping("/events/sessions")
    public ResponseEntity<List<Session>> listAll() {
        return ResponseEntity.ok(service.getAllSessions());
    }
}
