package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void create(User user);
    void delete(long id);
    void update(User user);
    User getById(long id);
}
