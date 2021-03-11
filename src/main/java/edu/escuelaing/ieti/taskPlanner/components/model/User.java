package edu.escuelaing.ieti.taskPlanner.components.model;

public class User {

    String username, pass, email;


    public User(){

    }

    public User(String name, String pass, String email){
        this.username = name;
        this.pass = pass;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}