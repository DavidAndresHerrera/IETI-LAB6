package edu.escuelaing.ieti.taskPlanner.components.persistence;

public class PlannerException extends Exception{

    public PlannerException(String message) {
        super(message);
    }

    public PlannerException(String message, Throwable cause) {
        super(message, cause);
    }
}
