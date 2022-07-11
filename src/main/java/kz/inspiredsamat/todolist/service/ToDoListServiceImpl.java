package kz.inspiredsamat.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kz.inspiredsamat.todolist.exception.ResourceNotFoundException;
import kz.inspiredsamat.todolist.model.ToDo;
import kz.inspiredsamat.todolist.repository.ToDoListRepository;

@Service
public class ToDoListServiceImpl implements ToDoListService {

    ToDoListRepository toDoListRepository;

    public ToDoListServiceImpl(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public ToDo saveToDo(ToDo toDo) {
        return toDoListRepository.save(toDo);
    }

    @Override
    public ToDo getToDoById(long id) {
        return toDoListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo", "Id", id));
    }

    @Override
    public List<ToDo> getAllToDo() {
        return toDoListRepository.findAll();
    }

    @Override
    public ToDo updateToDo(ToDo toDo, long id) {
        return toDoListRepository.save(toDo);
    }

    @Override
    public void deleteToDo(long id) {
        toDoListRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ToDo", "Id", id));
        toDoListRepository.deleteById(id);
    }
}