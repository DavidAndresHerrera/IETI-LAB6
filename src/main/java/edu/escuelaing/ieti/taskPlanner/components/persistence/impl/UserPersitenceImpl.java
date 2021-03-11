package edu.escuelaing.ieti.taskPlanner.components.persistence.impl;

import edu.escuelaing.ieti.taskPlanner.components.model.User;
import edu.escuelaing.ieti.taskPlanner.components.persistence.PlannerException;
import edu.escuelaing.ieti.taskPlanner.components.persistence.UserPersistence;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.concurrent.CopyOnWriteArrayList;


@Service
public class UserPersitenceImpl implements UserPersistence {

    private  CopyOnWriteArrayList<User> users = new CopyOnWriteArrayList<>();
    @Override
    public void addUser(User user) throws PlannerException {
        for (User i: users){
            if(i.getUsername().equals(user.getUsername())){
                throw new PlannerException("El usuario con nombre : " + user.getUsername()+ " ya existe");
            }
        }
        users.add(user);
    }

    @Override
    public void deleteUser(String name) throws PlannerException {
        boolean existe = false;
        for (int i= 0; i< users.size();i++){
            if(users.get(i).getUsername().equals(name)){
                users.remove(i);
                existe = true;
                break;
            }
        }
        if (!existe){
            throw new PlannerException("El usuario con nombre : " + name + " no existe");
        }
    }

    @Override
    public void updateUser(User user) throws PlannerException {
        boolean existe = false;
        for (User i: users){
            if(i.getUsername().equals(user.getUsername())) {
                i.setEmail(user.getEmail());
                i.setPass(user.getPass());
                existe = true;
            }
        }
        if (!existe){
            throw new PlannerException("El usuario con nombre : " + user.getUsername() + " no existe");
        }
    }

    @Override
    public User getUserByUsername(String name) throws PlannerException {

        User temp = null;
        boolean existe = false;
        for (User i: users){
            if(i.getUsername().equals(name)) {
                temp = i;
                existe = true;
            }
        }
        if (!existe){
            throw new PlannerException("El usuario con nombre : " + name  + " no existe");
        }
        else{
            return temp;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
