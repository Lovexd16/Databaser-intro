package com.javatodo.javatodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
    
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public String getIndex(Model model) {

        model.addAttribute("todos", todoRepository.findByNotDeleted());

        return "index";
    }

    @PostMapping("/new-item")
    public String addNew(@RequestParam("item") String itemName) {

        System.out.println("Nytt item från form: " + itemName);
        Todo todo = new Todo();
        todo.setItem(itemName);
        todoRepository.save(todo);

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {

        System.out.println("Delete mapping: " + id);
        todoRepository.deleteTodo(id);

        return "redirect:/";
    }
}
