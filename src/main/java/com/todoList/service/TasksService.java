package com.todoList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.todoList.model.Task;
import com.todoList.repo.TaskRepo;

@Service
public class TasksService {
	
	@Autowired
	private TaskRepo repo;

	public List<Task> getAllTasks() {
		Sort sort=Sort.by(Direction.ASC,"expectedTime");
		
		List<Task> tlist=repo.findAll(sort);
		return tlist;
	}

	public void insertTask(Task task2) {
		task2.setCompleted(false);
		repo.save(task2);
	}

	public void deleteTask(Long id) {
		repo.deleteById(id);	
	}
	
	public void toggle(Long id) {
		Optional<Task> opt=repo.findById(id);
		Task task=opt.get();
	task.setCompleted(!task.getCompleted());
     repo.save(task);	      
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
