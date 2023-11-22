package co.edu.uptc.view;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

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

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(webView);
		borderPane.setBottom(new FlowPane(zoomInButton, zoomOutButton));

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
