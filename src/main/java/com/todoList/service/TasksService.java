package com.todoList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoList.model.Task;
import com.todoList.repo.TaskRepo;

@Service
public class TasksService {
	
	@Autowired
	private TaskRepo repo;

	public List<Task> getAllTasks() {
		
		List<Task> tlist=repo.findAll();
		return tlist;
	}

	public void insertTask(String taskname) {
		Task task=new Task();
		task.setTaskname(taskname);
		task.setCompleted(false);
		repo.save(task);
	}

	public void deleteTask(Long id) {
		repo.deleteById(id);	
	}
	
	public void toggle(Long id) {
		Optional<Task> opt=repo.findById(id);
		Task t=opt.get();
	t.setCompleted(!t.getCompleted());
     repo.save(t);	      
	}

	public Task getTaskById(Long id) {
		Task t=repo.findById(id).orElseThrow();
		return t;
	}

	public boolean  updateTask(Task t) {
		Optional<Task> opt=repo.findById(t.getId());
		if(opt.isEmpty()) {
			return false;
		}
		else {
			repo.save(t);
			return true;
		}
		
		
	}
	

}
