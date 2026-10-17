package br.com.springboot.modulo2_spring.controller;

import br.com.springboot.modulo2_spring.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    private String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/produto")
    private Produto getProduto() {
        Produto p = new Produto();
        p.setId(1);
        p.setNome("Copo Stanley");
        p.setPreco(189.9);
        return p;
    }

    @PostMapping("/produto")
    private String addProduto(@RequestBody Produto p) {
        String log = String.format("Produto recebido: id:%d, nome:%s, preço:%.2f",
                p.getId(), p.getNome(), p.getPreco());
        IO.println(log);
        return "ok";
    }
}
