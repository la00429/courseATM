package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.HashMap;

import co.edu.uptc.presenter.Contracts;

public class SystemPrincipal implements Contracts.IModel {

	private ArrayList<Course> courses;
	private HashMap<String, User> users;

	public SystemPrincipal() {
		courses = new ArrayList<Course>();
		users = new HashMap<String, User>();
	}

	@Override
	public void showData() {
		// TODO Auto-generated method stub

	}

	public void addCourse(String infoCourse) {
		String[] info = infoCourse.split("_");
		Course course = new Course(info[0], info[1]);
		courses.add(course);
	}

	public void addUser(String code, String name, String gender, String password, String styleLearning) {
		User user = new User(code, name, gender, password, styleLearning);
		users.put(code, user);
	}

	public Boolean verificationUser(String code, String password) {
		Boolean verification = false;
		for (String codeUser : users.keySet()) {
			if (codeUser.equals(code)) {
				if (users.get(code).getPassword().equals(password)) {
					verification = true;
				}
			}
		}
		return verification;
	}

	public String selectCourse(String nameCourse) {
		String courseSelect = new String();
		for (Course course : courses) {
			if (course.getName().equals(nameCourse)) {
				courseSelect = course.getInfo();
			}
		}
		return courseSelect;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public HashMap<String, User> getUsers() {
		return users;
	}

	public void setUsers(HashMap<String, User> users) {
		this.users = users;
	}

}
