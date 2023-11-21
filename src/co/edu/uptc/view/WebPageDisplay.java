package co.edu.uptc.view;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

public class WebPageDisplay extends JFXPanel {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Web Page Example");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800, 600);

			JPanel swingPanel = new JPanel(new BorderLayout());

			WebPageDisplay jfxPanel = new WebPageDisplay();
			swingPanel.add(jfxPanel, BorderLayout.CENTER);

			jfxPanel.loadPage("https://sites.google.com/uptc.edu.co/aprendeatumanera/convergente");
			frame.add(swingPanel);
			frame.setVisible(true);

			
			
		});
	}

	private void initializeWebView(String path) {
		WebView webView = new WebView();
		webView.getEngine().load(path);

		Button zoomInButton = new Button("Zoom In");
		Button zoomOutButton = new Button("Zoom Out");

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
