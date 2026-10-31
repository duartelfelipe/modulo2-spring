package br.com.springboot.modulo2_spring.aula4.service;

import br.com.springboot.modulo2_spring.aula4.model.Session;
import br.com.springboot.modulo2_spring.aula4.model.Subscription;
import br.com.springboot.modulo2_spring.aula4.model.User;
import br.com.springboot.modulo2_spring.aula4.repo.SubscriptionRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService {

    private final SubscriptionRepo repo;

    public SubscriptionServiceImpl(SubscriptionRepo repo) {
        this.repo = repo;
    }

    @Override
    public Subscription addSubscription(Subscription subscription) {
        subscription.setCreatedAt(LocalDateTime.now());
        subscription.setUniqueId(UUID.randomUUID().toString());
        return repo.save(subscription);
    }

    @Override
    public List<Subscription> getAllByUser(User user) {
        return repo.findByIdUser(user);
    }


    @Override
    public List<Subscription> getAllBySession(Session session) {
        return repo.findByIdSession(session);
    }
}
