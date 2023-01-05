package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {

        return userDAO.getAllUsers();
    }

    @Override
    public void create(User user) {
        userDAO.create(user);
    }

    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public User getById(long id) {
        return userDAO.getById(id);
    }
}
