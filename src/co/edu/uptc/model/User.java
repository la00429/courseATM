package co.edu.uptc.model;

import java.io.Serializable;

public class User implements Serializable {
	private String code;
	private String name;
	private String gender;
	private String password;
	private String styleLearning;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String code, String name, String gender, String password, String styleLearning) {
		super();
		this.code = code;
		this.name = name;
		this.gender = gender;
		this.password = password;
		this.styleLearning = styleLearning;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStyleLearning() {
		return styleLearning;
	}

	public void setStyleLearning(String styleLearning) {
		this.styleLearning = styleLearning;
	}

}
