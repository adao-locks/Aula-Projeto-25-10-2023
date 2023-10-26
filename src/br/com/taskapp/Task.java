package br.com.taskapp;

import java.util.Objects;

public class Task {
	private Integer code;
	private String description;
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Task(Integer code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(code, other.code);
	}

	@Override
	public String toString() {
		return "Task [code=" + code + ", description=" + description + "]";
	}

}
