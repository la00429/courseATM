package co.edu.uptc.model;

// TODO: Auto-generated Javadoc
/**
 * Clase que representa un curso con un nombre y su informaci�n asociada.
 */
public class Course {

	/** The name. */
	private String name; // Nombre del curso
	
	/** The info. */
	private String info; // Informaci�n del curso

	/**
	 * Constructor de la clase Course.
	 *
	 * @param name Nombre del curso.
	 * @param info Informaci�n asociada al curso.
	 */
	public Course(String name, String info) {
		this.name = name;
		this.info = info;
	}

	/**
	 * Obtiene el nombre del curso.
	 *
	 * @return El nombre del curso.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre del curso.
	 *
	 * @param name El nombre a establecer para el curso.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene la informaci�n asociada al curso.
	 *
	 * @return La informaci�n del curso.
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * Establece la informaci�n asociada al curso.
	 *
	 * @param info La informaci�n a establecer para el curso.
	 */
	public void setInfo(String info) {
		this.info = info;
	}
}