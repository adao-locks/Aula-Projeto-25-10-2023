package br.com.taskapp;

import java.util.List;

public class TaskController {
	
	private Task currentTask = new Task();
	private TaskRepository repository = new TaskRepository();
	private ActionBarListener listener;
	
	public void setActionBarListener(ActionBarListener newlistener) {
		listener = newlistener;
	}
	
	public void changeDescription(String text) {
		if (currentTask != null) {
			currentTask.setDescription(text);
		}
	}

	public void save() {
		if (currentTask != null) {
			if (currentTask.getCode() == null) {
				repository.insert(currentTask);
			} else {
				repository.update(currentTask);
			}
			currentTask = new Task();
		}
		listener.onSave();
	}
	
	public void delete() {
		if (currentTask != null) {
			repository.delete(currentTask.getCode());
			currentTask = new Task();
		}
	}

	public String getCode() {
		if (currentTask != null && currentTask.getCode() != null) {
			return currentTask.getCode().toString();
		}
		return "";
	}
	
	public String getDescription() {
		if (currentTask != null && currentTask.getDescription() != null) {
			return currentTask.getDescription().toString();
		}
		return "";
	}

	public int getTotalTask() {
		return repository.findAll().size();
	}

	public String getValueAt(int rowIndex, int columnIndex) {
		List<Task> tasks = repository.findAll();
		if (rowIndex > -1 && rowIndex < tasks.size()) {
			Task task = repository.findAll().get(rowIndex);
			if (columnIndex == 0) {
				return task.getCode().toString();
			} else if (columnIndex == 1) {
				return task.getDescription();
			}
		}
		return "";
	}

	public void selectTask(int index) {
		currentTask = repository.findAll().get(index);
	}
}