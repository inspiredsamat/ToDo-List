package kz.inspiredsamat.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kz.inspiredsamat.todolist.model.ToDo;
import kz.inspiredsamat.todolist.service.ToDoListService;

@Controller
@RequestMapping("/todolist")
public class ToDoListController {

    ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping
    public String getToDoList(Model model) {
        model.addAttribute("to_do_list", toDoListService.getAllToDo());
        return "to_do_list";
    }

    @GetMapping("/new")
    public String createToDo(Model model) {
        ToDo toDo = new ToDo();
        model.addAttribute("toDo", toDo);
        return "create_to_do";
    }

    @PostMapping()
    public String createNewToDo(@ModelAttribute("toDo") ToDo toDo) {
        toDoListService.saveToDo(toDo);
        return "redirect:/todolist";
    }

    @GetMapping("/edit/{id}")
    public String updateToDoById(@PathVariable long id, Model model) {
        model.addAttribute("toDo", toDoListService.getToDoById(id));
        return "edit_to_do";
    }

    @PostMapping("{id}")
    public String updateToDo(@PathVariable long id, @ModelAttribute("toDo") ToDo toDo) {
        ToDo toDoToUpdate = toDoListService.getToDoById(id);

        toDoToUpdate.setName(toDo.getName());
        toDoToUpdate.setPriority(toDo.getPriority());
        toDoToUpdate.setDeadlineDate(toDo.getDeadlineDate());
        toDoToUpdate.setDeadlineTime(toDo.getDeadlineTime());

        toDoListService.updateToDo(toDo, id);
        return "redirect:/todolist";
    }

    @GetMapping("/{id}")
    public String deleteToDoById(@PathVariable long id) {
        toDoListService.deleteToDo(id);
        return "redirect:/todolist";
    }
}