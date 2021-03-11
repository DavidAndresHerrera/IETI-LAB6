package edu.escuelaing.ieti.taskPlanner.components.persistence;

import edu.escuelaing.ieti.taskPlanner.components.model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserPersistence {

    void addUser(User user) throws PlannerException;

    void deleteUser(String username) throws PlannerException;

    void updateUser(User user) throws PlannerException;

    User getUserByUsername(String username) throws PlannerException;

    List<User> getAllUsers();
}
