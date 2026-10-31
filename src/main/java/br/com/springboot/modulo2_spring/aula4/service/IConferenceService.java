package br.com.springboot.modulo2_spring.aula4.service;

import br.com.springboot.modulo2_spring.aula4.model.Conference;

import java.util.List;

public interface IConferenceService {
    List<Conference> listAll();
    Conference add(Conference conference);
    Conference findById(Integer id);
}
