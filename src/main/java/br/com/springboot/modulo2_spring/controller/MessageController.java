package br.com.springboot.modulo2_spring.controller;

import br.com.springboot.modulo2_spring.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final IMessageService service;


    public MessageController(@Qualifier("v2")IMessageService service) {
        this.service = service;
    }

    @GetMapping("/message")
    public ResponseEntity<String> getCustomMessage(@RequestParam(required = true) String message) {
        return ResponseEntity.ok(
                service.getCustomMessage(message)
        );
    }

}
