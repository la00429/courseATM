package co.edu.uptc.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import javafx.scene.web.WebView;
import javafx.stage.Screen;


public class WebCourse extends JFXPanel{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WebView webView;
	private Button zoomInButton;
	private Button zoomOutButton;

	private void initializeWebView(String path) {
		
		webView = new WebView();
		webView.getEngine().load(path);

		zoomInButton = new Button("Zoom In");
		zoomOutButton = new Button("Zoom Out");
		zoomInButton.setOnAction(e -> changeZoom(webView, 0.1));
		zoomOutButton.setOnAction(e -> changeZoom(webView, -0.1));

		webView = new WebView();
		webView.getEngine().load(path);

		zoomInButton = new Button("Zoom In");
		zoomOutButton = new Button("Zoom Out");
		zoomInButton.setOnAction(e -> changeZoom(webView, 0.1));
		zoomOutButton.setOnAction(e -> changeZoom(webView, -0.1));

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(webView);
		borderPane.setBottom(new FlowPane(zoomInButton, zoomOutButton));

		// Set the preferred size of the BorderPane
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screen.getWidth();
		double height = screen.getHeight();
		borderPane.setPrefSize(width, height);

		Scene scene = new Scene(borderPane);
		this.setScene(scene);
	}

	private static void changeZoom(WebView webView, double zoomIncrement) {
		double currentZoom = webView.getZoom();
		double newZoom = currentZoom + zoomIncrement;
		if (newZoom >= 0.1 && newZoom <= 3.0) {
			webView.setZoom(newZoom);
		}
	}

	public void loadPage(String path) {
		Platform.runLater(() -> initializeWebView(path));
	}
}
