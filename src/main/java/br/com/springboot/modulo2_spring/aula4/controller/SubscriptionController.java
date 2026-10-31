package br.com.springboot.modulo2_spring.aula4.controller;

import br.com.springboot.modulo2_spring.aula4.model.Session;
import br.com.springboot.modulo2_spring.aula4.model.Subscription;
import br.com.springboot.modulo2_spring.aula4.model.User;
import br.com.springboot.modulo2_spring.aula4.service.SubscriptionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {

    private final SubscriptionServiceImpl service;

    public SubscriptionController(SubscriptionServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/events/subscriptions")
    public ResponseEntity<Subscription> add(@RequestBody Subscription subscription) {
        return ResponseEntity.ok(
                service.addSubscription(subscription)
        );
    }

    @GetMapping("/events/subscriptions/users/{id}")
    public ResponseEntity<List<Subscription>> findByUser(@PathVariable Integer id) {
        return ResponseEntity.ok(
                service.getAllByUser(new User(id))
        );
    }

    @GetMapping("/events/subscriptions/sessions/{id}")
    public ResponseEntity<List<Subscription>> findBySession(@PathVariable Integer id) {
        return ResponseEntity.ok(
                service.getAllBySession(new Session(id))
        );
    }



 }
