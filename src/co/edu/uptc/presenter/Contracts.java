package co.edu.uptc.presenter;

public interface Contracts {
	public interface IView {
		public void showData();
	}

	public interface IPresenter {

		public void verificationLogin();

		public void selectCourse(String codeUser);

		public void showData(String codeUser);
	}

	public interface IModel {
		public void showData();
	}

}
