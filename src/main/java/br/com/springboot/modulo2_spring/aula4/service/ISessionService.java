package br.com.springboot.modulo2_spring.aula4.service;

import br.com.springboot.modulo2_spring.aula4.model.Session;

import java.util.List;

public interface ISessionService {
    public Session addSession(Session session);
    public Session getSessionById(Integer id);
    public List<Session> getAllSessions();
}
