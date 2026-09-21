package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
	@FXML
	private MenuItem menuItemVendedor;
	@FXML
	private MenuItem menuItemDepartamento;
	@FXML
	private MenuItem menuItemAssunto;

	@FXML
	public void onMenuItemVendedorAction() {
		System.out.println("onMenuItemVendedorAction");

	}

	@FXML
	public void onMenuItemDepartamentoAction() {
		System.out.println("onMenuItemDepartamentoAction");

	}

	@FXML
	public void onMenuItemAssuntoAction() {
		loadView("/gui/Assunto.fxml");
	}

	@Override
	public void initialize(URL url, ResourceBundle rdb) {

	}

	private synchronized void loadView(String absolutaName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutaName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBox =  (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			
			
		} catch(IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
}
