package br.com.springboot.modulo2_spring.aula4.service;

import br.com.springboot.modulo2_spring.aula4.exception.NotFoundException;
import br.com.springboot.modulo2_spring.aula4.model.Session;
import br.com.springboot.modulo2_spring.aula4.repo.SessionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements ISessionService {

    private final SessionRepo repo;

    public SessionServiceImpl(SessionRepo repo) {
        this.repo = repo;
    }

    @Override
    public Session addSession(Session session) {
        return repo.save(session);
    }

    @Override
    public Session getSessionById(Integer id) {
        return repo
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Sessão não encontrada, id: " + id)
                );
    }

    @Override
    public List<Session> getAllSessions() {
        return repo.findAll();
    }
}
