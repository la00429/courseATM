package co.edu.uptc.persistence;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;

import co.edu.uptc.model.User;

public class LoadData {

	public ArrayList<String> readLibraryCollec() {
		ArrayList<String> fileAll = new ArrayList<String>();
		File file = new File("data/sites.txt");
		String line;
		try (FileReader fileReader = new FileReader(file);
				BufferedReader process = new BufferedReader(fileReader)) {

			while ((line = process.readLine()) != null) {
				if (!line.isEmpty()) {
					fileAll.add(line);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return fileAll;

	}

	public void writeUsersJSON(HashMap<String, User> users) {
		try {
			createResources();
			JsonObjectBuilder objectConstructor = Json.createObjectBuilder();
			JsonArrayBuilder usersList = Json.createArrayBuilder();

			for (User user : users.values()) {
				JsonObjectBuilder userObject = Json.createObjectBuilder();
				userObject.add("code", user.getCode());
				userObject.add("name", user.getName());
				userObject.add("gender", user.getGender());
				userObject.add("password", user.getPassword());
				userObject.add("styleLearning", user.getStyleLearning());
				usersList.add(userObject);
			}
			objectConstructor.add("users", usersList);

			JsonObject rutJsonObject = objectConstructor.build();
			OutputStream output = new FileOutputStream("data/users.json");
			JsonWriter jsonWriter = Json.createWriter(output);
			jsonWriter.writeObject(rutJsonObject);
			jsonWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, User> readUsersJSON() {
		HashMap<String, User> users = new HashMap<String, User>();
		try {
			JsonReader jsonReader = Json.createReader(new FileReader("data/users.json"));
			JsonObject jsonObject = jsonReader.readObject();
			jsonReader.close();
			JsonArray usersArray = jsonObject.getJsonArray("users");
			for (JsonObject userObject : usersArray.getValuesAs(JsonObject.class)) {
				User user = new User();
				user.setCode(userObject.getString("code"));
				user.setName(userObject.getString("name"));
				user.setGender(userObject.getString("gender"));
				user.setPassword(userObject.getString("password"));
				user.setStyleLearning(userObject.getString("styleLearning"));
				users.put(user.getCode(), user);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	private void createResources() {
		File dataFolder = new File("data");
		if (!dataFolder.exists()) {
			dataFolder.mkdirs();
		}
	}

}
