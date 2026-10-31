package br.com.springboot.modulo2_spring.aula4.service;

import br.com.springboot.modulo2_spring.aula4.exception.NotFoundException;
import br.com.springboot.modulo2_spring.aula4.model.User;
import br.com.springboot.modulo2_spring.aula4.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepo repo;

    public UserServiceImpl(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public User addUser(User user) {
        return repo.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return repo
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("User não encontrado, id: " + id)
                );
    }

    @Override
    public User getUserByEmail(String email) {
        return repo
                .findByEmail(email)
                .orElseThrow(
                        () -> new NotFoundException("User não encontrado, email: " + email)
                );
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
