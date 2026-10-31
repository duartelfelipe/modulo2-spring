package br.com.springboot.modulo2_spring.aula4.controller;

import br.com.springboot.modulo2_spring.aula4.model.Conference;
import br.com.springboot.modulo2_spring.aula4.service.ConferenceServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConferenceController {

    private final ConferenceServiceImpl service;

    public ConferenceController(ConferenceServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/events/conferences")
    public ResponseEntity<Conference> add(@RequestBody Conference conference) {
        return ResponseEntity
                .ok(
                        service.add(conference)
                );
    }

    @GetMapping("/events/conferences")
    public ResponseEntity<List<Conference>> listAll() {
        return ResponseEntity
                .ok(
                        service.listAll()
                );
    }

    @GetMapping("/events/conferences/{id}")
    public ResponseEntity<Conference> findById(@PathVariable Integer id) {
        return ResponseEntity
                .ok(
                        service.findById(id)
                );
    }
}
