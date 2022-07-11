package kz.inspiredsamat.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.inspiredsamat.todolist.model.ToDo;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDo, Long> {
}