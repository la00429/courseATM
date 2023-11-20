package co.edu.uptc.model;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String password;
	private String styleLearning;

	public User(String name, String password, String stylelearning) {
		super();
		this.name = name;
		this.password = password;
		this.styleLearning=stylelearning;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setStyleLearning(String styleLearning) {
		this.styleLearning = styleLearning;
	}

	public String getStyleLearning() {
		return styleLearning;
	}

}
