package br.com.springboot.modulo2_spring.aula4.repo;

import br.com.springboot.modulo2_spring.aula4.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepo extends ListCrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
