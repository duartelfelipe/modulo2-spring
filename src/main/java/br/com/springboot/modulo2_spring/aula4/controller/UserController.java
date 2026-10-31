package br.com.springboot.modulo2_spring.aula4.controller;

import br.com.springboot.modulo2_spring.aula4.model.User;
import br.com.springboot.modulo2_spring.aula4.service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/events/users")
    public ResponseEntity<User> add(@RequestBody User user) {
        return ResponseEntity.ok(
                service.addUser(user)
        );
    }

    @GetMapping("/events/users")
    public ResponseEntity<List<User>> listAll() {
        return ResponseEntity.ok(
                service.getAllUsers()
        );
    }

    @GetMapping("/events/users/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                service.getUserById(id)
        );
    }

    @GetMapping("/events/users/find-by-email")
    public ResponseEntity<User> getByEmail(@RequestParam String email) {
        return ResponseEntity.ok(
                service.getUserByEmail(email)
        );
    }
}
