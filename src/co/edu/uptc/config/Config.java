package co.edu.uptc.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Properties;

public class Config {

	private Message message;

	public Message loadMessages() {
		message = new Message();
		try {
			Class<?> classMyObj = message.getClass();
			Field[] fields = classMyObj.getDeclaredFields();
			// Properties como un arreglo de cadenas.F
			String[] messagesAll = loadProperties();
			// for (Field field : fields) {
//		fields.
			// }Revisar sintaxis de los forEach.
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				fields[i].set(message, messagesAll[i]);
			}
		} catch (IllegalArgumentException e) {
			e.getMessage();
		} catch (IllegalAccessException e) {
			e.getMessage();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

// reflejo del objeto message;

		return message;

	}

	private String[] loadProperties() {
		String[] messagesAll = new String[0];
		try {
			Properties file = new Properties();
			file.load(new FileReader("resources/messages.properties")); /// Cargar lista de atributos
			// Ordenar file
			ArrayList<String> fileOrder = keysOrder(file);
			// añadirle a cada atributo del objeto message un dato del archivo que ya se
			// encuentra en fileOrder.
			messagesAll = new String[fileOrder.size()];
			for (int i = 0; i < fileOrder.size(); i++) {
				messagesAll[i] = file.getProperty((String) fileOrder.get(i));
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return messagesAll;
	}

	private ArrayList<String> keysOrder(Properties file) {
		Hashtable<Object, Object> messagesOrder = file;
		Object[] valores = messagesOrder.keySet().toArray();
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < valores.length; i++) {
			list.add((String) valores[i]);
		}
		Collections.sort(list);
		return list;
	}

}
