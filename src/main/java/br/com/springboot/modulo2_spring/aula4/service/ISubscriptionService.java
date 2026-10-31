package br.com.springboot.modulo2_spring.aula4.service;

import br.com.springboot.modulo2_spring.aula4.model.Session;
import br.com.springboot.modulo2_spring.aula4.model.Subscription;
import br.com.springboot.modulo2_spring.aula4.model.User;

import java.util.List;

public interface ISubscriptionService {
    Subscription addSubscription(Subscription subscription);
    List<Subscription> getAllByUser(User user);
    List<Subscription> getAllBySession(Session session);
}
