package br.com.springboot.modulo2_spring.controller;

import br.com.springboot.modulo2_spring.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

@RestController
public class ProdutoController {

    private static List<Produto> database = new ArrayList<>() {{
        add(new Produto(1, "Computador", 1500.0));
        add(new Produto(2, "Mouse", 80.0));
        add(new Produto(3, "Teclado", 150.0));
        add(new Produto(4, "Monitor", 800.0));
        add(new Produto(5, "Impressora", 350.0));
    }};

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(database);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> recuperarPorId(@PathVariable Integer id) {
        Produto produto = database.stream().filter(p -> p.getId().equals(id)).findAny().orElse(null);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    @PostMapping("/produtos")
    public ResponseEntity<Void> adicionarProduto(@RequestBody Produto p) {
        database.add(p);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> alterarProduto(@PathVariable int id,
                                                  @RequestBody Produto produto) {
        int idx = getIdx(id);

        if (idx < 0) {
            return ResponseEntity.notFound().build();
        }

        database.set(idx, produto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable int id) {
        int idx = getIdx(id);

        if (idx < 0) {
            return ResponseEntity.notFound().build();
        }

        database.remove(idx);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/produtos/sort")
    public ResponseEntity<List<Produto>> listarProdutosOrdenados(
            @RequestParam(name = "order", required = false) String order) {
        if (order == null) {
            return ResponseEntity.ok(database);
        } else if (order.equals("asc")) {
            return ResponseEntity.ok(
                    database.stream().sorted(Comparator.comparing(Produto::getPreco)).toList()
            );
        } else if (order.equals("desc")) {
            return ResponseEntity.ok(
                    database.stream().sorted(Comparator.comparing(Produto::getPreco).reversed()).toList()
            );
        }
        return ResponseEntity.badRequest().build();
    }

    private int getIdx(int id) {
        return IntStream
                .range(0, database.size())
                .filter(i -> database.get(i).getId().equals(id))
                .findFirst().orElse(-1);
    }
}
