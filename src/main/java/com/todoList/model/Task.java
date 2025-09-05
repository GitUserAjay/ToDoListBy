package com.todoList.model;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name="task")
@Data
@Getter
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private String taskname; 
	
	private String taskDescription;
	
	private LocalTime expectedTime;
	
	private Boolean completed;
	

}
