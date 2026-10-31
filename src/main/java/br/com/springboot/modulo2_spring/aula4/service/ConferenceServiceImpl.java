package br.com.springboot.modulo2_spring.aula4.service;

import br.com.springboot.modulo2_spring.aula4.exception.NotFoundException;
import br.com.springboot.modulo2_spring.aula4.model.Conference;
import br.com.springboot.modulo2_spring.aula4.repo.ConferenceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceServiceImpl implements IConferenceService {

    private final ConferenceRepo repo;

    public ConferenceServiceImpl(ConferenceRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Conference> listAll() {
        return repo.findAll();
    }

    @Override
    public Conference add(Conference conference) {
        return repo.save(conference);
    }

    @Override
    public Conference findById(Integer id) {
        return repo
                .findConferenceById(id)
                .orElseThrow(
                        () -> new NotFoundException("Conferência não encontrada, id: " + id)
                );
    }
}
