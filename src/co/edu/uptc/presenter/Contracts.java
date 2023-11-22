package co.edu.uptc.presenter;

// TODO: Auto-generated Javadoc
/**
 * Esta interfaz define los contratos (interfaces) para las vistas,
 * presentadores y modelos.
 */
public interface Contracts {
	/**
	 * Interfaz que define los m�todos que debe implementar una vista.
	 */
	public interface IView {
		/**
		 * Muestra un mensaje en la vista.
		 *
		 * @param message El mensaje a mostrar.
		 */
		public void showData(String message);

		/**
		 * Establece el nombre del curso en la vista.
		 *
		 * @param course El nombre del curso a establecer.
		 */
		public void setCourse(String course);

		/**
		 * Accede al inicio de sesi�n.
		 */
		public void accessLogin();

		/**
		 * Accede al sesi�n desde el cambio de contrase�a.
		 */
		public void accessLoginChange();

		/**
		 * Accede al curso.
		 */
		public void accessCourse();

		/**
		 * Accede al panel de creaci�n de usuario.
		 */
		public void accessCreate();

		/**
		 * Accede al curso desde la ruta de paneles para crear un usuario.
		 */
		public void accessCourseCreate();

		/**
		 * Accede al cambio de contrase�a.
		 */
		public void accessChange();

		/**
		 * Accede al formulario de estilos de aprendizaje.
		 */
		public void accessForm();
	}

	/**
	 * Interfaz que define los m�todos que debe implementar un presentador.
	 */
	public interface IPresenter {

		/**
		 * Realiza la verificaci�n del inicio de sesi�n.
		 */
		public void verificationLogin();

		/**
		 * Realiza la acci�n para olvido de contrase�a.
		 */
		public void forgotPassword();

		/**
		 * m�todo para navegar en la creaci�n de usuario.
		 */
		public void createUserData();

		/**
		 * Cargar los datos correspondientes al curso.
		 */
		public void loadDataCourse();

		/**
		 * Actualiza el cambio de contrase�a.
		 */
		public void updatePanelChangePasswaord();

		/**
		 * Navegaci�n entre el panel login y el de creaci�n de usuario.
		 */
		public void changeToCreateUser();

		/**
		 * Navega entre el panel del curso y vuelve a login.
		 */
		public void logOutSystem();

		/**
		 * M�todo para mostrar mensajes dentro de los JDialogs.
		 *
		 * @param message el mensaje qu quiero que se muestre.
		 */
		public void showData(String message);

	}

	/**
	 * Muestra informaci�n de un usuario basado en su c�digo.
	 *
	 * @return El objeto que representa al usuario.
	 */
	public interface IModel {

		  /**
         * Muestra informaci�n de un usuario basado en su c�digo.
         *
         * @param codeUser El c�digo del usuario.
         * @return El objeto que representa al usuario.
         */
		public Object showUser(String codeUser);

		/**
		 * Agrega un nuevo usuario.
		 *
		 * @param code          El c�digo del usuario.
		 * @param name          El nombre del usuario.
		 * @param gender        El g�nero del usuario.
		 * @param password      La contrase�a del usuario.
		 * @param styleLearning El estilo de aprendizaje del usuario.
		 */
		public void addUser(String code, String name, String gender, String password, String styleLearning);

		/**
		 * Agrega un nuevo curso.
		 *
		 * @param infoCourse La informaci�n del curso a agregar.
		 */
		public void addCourse(String infoCourse);

		/**
		 * Verifica la existencia de un usuario basado en su c�digo y contrase�a.
		 *
		 * @param code     El c�digo del usuario.
		 * @param password La contrase�a del usuario.
		 * @return Verdadero si el usuario existe, falso en caso contrario.
		 */
		public Boolean verificationUser(String code, String password);

		/**
		 * Cambia la contrase�a de un usuario.
		 *
		 * @param codeUser    El c�digo del usuario.
		 * @param passwordNew La nueva contrase�a del usuario.
		 */
		public void changePassword(String codeUser, String passwordNew);

		/**
		 * Selecciona un curso basado en su nombre.
		 *
		 * @param nameCourse El nombre del curso.
		 * @return El curso seleccionado.
		 */
		public String selectCourse(String nameCourse);

	}

}
