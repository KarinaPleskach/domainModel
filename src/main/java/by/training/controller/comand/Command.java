package by.training.controller.comand;

import by.training.exception.ControllerException;

public interface Command {
    String execute(String request) throws ControllerException;
}
