package edu.escuelaing.ieti.taskPlanner.components.controller;


import edu.escuelaing.ieti.taskPlanner.components.model.User;
import edu.escuelaing.ieti.taskPlanner.components.persistence.PlannerException;
import edu.escuelaing.ieti.taskPlanner.components.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/user")
public class UserController {
    @Autowired
    private UserService us;

    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public ResponseEntity<?> getUserByUsername(@PathVariable String name){
        try{
            User user = us.getByIdName(name);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            us.create(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (PlannerException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(){
        try {
            return new ResponseEntity<>(us.getAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/removeUser",method = RequestMethod.DELETE)
    public ResponseEntity<?> removeUser(@RequestBody User user){
        try {
            us.remove(user.getUsername());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody User user){
        try {
            us.update(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}


