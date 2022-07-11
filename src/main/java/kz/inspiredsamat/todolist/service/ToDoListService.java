package kz.inspiredsamat.todolist.service;

import java.util.List;

import kz.inspiredsamat.todolist.model.ToDo;

public interface ToDoListService {
    ToDo saveToDo(ToDo toDo);

    ToDo getToDoById(long id);

    List<ToDo> getAllToDo();

    ToDo updateToDo(ToDo toDo, long id);

    void deleteToDo(long id);
}