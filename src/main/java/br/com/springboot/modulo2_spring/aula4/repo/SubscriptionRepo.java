package br.com.springboot.modulo2_spring.aula4.repo;

import br.com.springboot.modulo2_spring.aula4.model.Session;
import br.com.springboot.modulo2_spring.aula4.model.Subscription;
import br.com.springboot.modulo2_spring.aula4.model.SubscriptionId;
import br.com.springboot.modulo2_spring.aula4.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface SubscriptionRepo extends ListCrudRepository<Subscription, SubscriptionId> {
    List<Subscription> findByIdUser(User user);
    List<Subscription> findByIdSession(Session session);
 }
