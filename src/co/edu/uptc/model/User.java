package co.edu.uptc.model;

import java.io.Serializable;

/**
 * Clase que representa un usuario en el sistema. Implementa Serializable para
 * permitir la serialización de objetos.
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code; // Código del usuario
	private String name; // Nombre del usuario
	private String gender; // Género del usuario
	private String password; // Contraseña del usuario
	private String styleLearning; // Estilo de aprendizaje del usuario

	/**
	 * Constructor vacío de la clase User.
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase User que recibe parámetros para inicializar los
	 * atributos.
	 *
	 * @param code          Código del usuario.
	 * @param name          Nombre del usuario.
	 * @param gender        Género del usuario.
	 * @param password      Contraseña del usuario.
	 * @param styleLearning Estilo de aprendizaje del usuario.
	 */
	public User(String code, String name, String gender, String password, String styleLearning) {
		super();
		this.code = code;
		this.name = name;
		this.gender = gender;
		this.password = password;
		this.styleLearning = styleLearning;
	}

	// Métodos para acceder y modificar los atributos de la clase User

	/**
	 * Obtiene el código del usuario.
	 *
	 * @return El código del usuario.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Establece el código del usuario.
	 *
	 * @param code El código del usuario a establecer.
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Obtiene el nombre del usuario.
	 *
	 * @return El nombre del usuario.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre del usuario.
	 *
	 * @param name El nombre del usuario a establecer.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene el género del usuario.
	 *
	 * @return El género del usuario.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Establece el género del usuario.
	 *
	 * @param gender El género del usuario a establecer.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Obtiene la contraseña del usuario.
	 *
	 * @return La contraseña del usuario.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Establece la contraseña del usuario.
	 *
	 * @param password La contraseña del usuario a establecer.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Obtiene el estilo de aprendizaje del usuario.
	 *
	 * @return El estilo de aprendizaje del usuario.
	 */
	public String getStyleLearning() {
		return styleLearning;
	}

	/**
	 * Establece el estilo de aprendizaje del usuario.
	 *
	 * @param styleLearning El estilo de aprendizaje del usuario a establecer.
	 */
	public void setStyleLearning(String styleLearning) {
		this.styleLearning = styleLearning;
	}
}
