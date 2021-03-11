package edu.escuelaing.ieti.taskPlanner.components.service;


import edu.escuelaing.ieti.taskPlanner.components.model.User;
import edu.escuelaing.ieti.taskPlanner.components.persistence.PlannerException;
import edu.escuelaing.ieti.taskPlanner.components.persistence.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPersistence userPersistence;

    @Override
    public List<User> getAll() {
        return userPersistence.getAllUsers();
    }

    @Override
    public User getByIdName(String userId) throws PlannerException {
        return userPersistence.getUserByUsername(userId);
    }

    @Override
    public void create(User user) throws PlannerException {
        userPersistence.addUser(user);
    }

    @Override
    public void update(User user) throws PlannerException {
        userPersistence.updateUser(user);
    }

    @Override
    public void remove(String userId) throws PlannerException {
        userPersistence.deleteUser(userId);
    }
}
