package com.todoList.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todoList.model.Task;
import com.todoList.service.TasksService;

@Controller
public class TodoListController {
	
	@Autowired
	private  TasksService service;
	
	@GetMapping("/")
	public String getTasks(Model model) {
		List<Task> taskList=service.getAllTasks();
		model.addAttribute("taskList",taskList);
		return "tasks";
	}
	
	@PostMapping("/")
	public String insertTask(@ModelAttribute Task task) {
		service.insertTask(task);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteTask(@PathVariable Long id) {
		service.deleteTask(id);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/toggle")
	public String toggleTask(@PathVariable Long id) {
		service.toggle(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/{id}/edit")     //to get edit form 
	public String getEditForm(Model model ,@PathVariable Long id) {
	 Task t=service.getTaskById(id);	
	 model.addAttribute("task", t);
	 return "updateForm";
	}
	
	@PostMapping("/updateTask")
	public String updatTask(@ModelAttribute Task t) {
	  service.updateTask(t);
	  return "redirect:/";
	}
	
	

}
