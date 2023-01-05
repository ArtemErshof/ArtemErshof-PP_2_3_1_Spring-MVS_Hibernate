package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    void create(User user);
    void delete(long id);
    void update(User user);
    User getById(long id);
}
