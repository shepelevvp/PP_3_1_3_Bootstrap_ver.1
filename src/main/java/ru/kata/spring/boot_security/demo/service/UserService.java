package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    void save(User user);
    List<User> listUsers();
    User show(Long id);
    void update(User user);
    void delete(long id);
    User findByName(String name);
    User findByEmail(String email);

}
