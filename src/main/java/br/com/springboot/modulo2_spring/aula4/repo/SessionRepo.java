package br.com.springboot.modulo2_spring.aula4.repo;

import br.com.springboot.modulo2_spring.aula4.model.Session;
import org.springframework.data.repository.ListCrudRepository;

public interface SessionRepo extends ListCrudRepository<Session, Integer> {
 }
