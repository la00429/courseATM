package co.edu.uptc.runnable;

import java.util.function.Consumer;

import co.edu.uptc.presenter.Presenter;

public class Run {
	public static void main(String[] args) {
		Consumer<Presenter> presenterConsumer = presenter -> presenter.loadData();
		presenterConsumer.accept(new Presenter());
	}

}
