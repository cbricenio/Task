package com.bootcamp.Task.controller;

import com.bootcamp.Task.model.Task;
import com.bootcamp.Task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Task> listTasks = taskService.fetchTaskList();
        model.addAttribute("listTasks", listTasks);

        return "index";
    }
    @RequestMapping("/new")
    public String showNewTaskForm(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);

        return "new_task";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);

        return "redirect:/";
    }
    @RequestMapping("/edit/{taskId}")
    public ModelAndView showEditTaskForm(@PathVariable(name = "taskId") Long taskId) {
        ModelAndView mav = new ModelAndView("edit_task");
        Task task = taskService.fetchTaskById(taskId);
        mav.addObject("task", task);

        return mav;
    }
    @RequestMapping(value = "/edit/{taskId}", method = RequestMethod.POST)
    public String updateTask(@PathVariable(name = "taskId") Long taskId, @ModelAttribute("task") Task task) {
        taskService.updateTask(taskId, task);

        return "redirect:/";
    }

    @RequestMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable(name = "taskId") Long taskId) {
        taskService.deleteTaskById(taskId);

        return "redirect:/";
    }

}
