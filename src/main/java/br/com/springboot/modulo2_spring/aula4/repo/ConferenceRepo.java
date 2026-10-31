package br.com.springboot.modulo2_spring.aula4.repo;

import br.com.springboot.modulo2_spring.aula4.model.Conference;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface ConferenceRepo extends ListCrudRepository<Conference, Integer> {
    Optional<Conference> findConferenceById(Integer id);
}
