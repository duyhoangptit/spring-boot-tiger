package vn.hoangptit.tiger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("todo-list")
public class TodoController {

    @GetMapping("/add-todo")
    public String addTodoList(Model model) {
        return "addTodo";
    }

    @PostMapping("/add-todo-list")
    public String doAddTodo(Model model) {
        return "success";
    }

    @GetMapping("/get-todo-list")
    public String getTodoList(Model model) {
        return "todo-list";
    }
}
