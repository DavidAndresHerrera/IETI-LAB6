package edu.escuelaing.ieti.taskPlanner.components.service;

import edu.escuelaing.ieti.taskPlanner.components.model.User;
import edu.escuelaing.ieti.taskPlanner.components.persistence.PlannerException;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getByIdName(String userId) throws PlannerException;

     void create(User user) throws PlannerException;

    void update(User user) throws PlannerException;

    void remove(String userId) throws PlannerException;
}