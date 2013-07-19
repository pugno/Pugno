package source.resource;

import java.util.ArrayList;

import source.resource.execution.Task;

public class TaskFactory {
	private ArrayList<Task> tasks;
	private Task task;
	
	public TaskFactory(){
		tasks = new ArrayList<Task>();
	}
	
	public void launch(){
		if(task != null && task.validate()){
			task.execute();
		} else {
			setTask(getState());
		}
	}
	
	Task getState(){
		for(Task task : tasks){
			if(task != null && task.validate()){
				return task;
			}
		}
		return null;
	}
	
	public ArrayList<Task> submit(Task...tasks){
		for(Task task : tasks){
			if(task != null){
				if(!(this.tasks.contains(task))){
					this.tasks.add(task);
				}
			}
		}
		return this.tasks;
	}
	
	public ArrayList<Task> getTasks(){
		return tasks;
	}
	
	public Task setTask(Task task){
		return this.task = task;
	}
	
	public Task getTask(){
		return task;
	}

}
