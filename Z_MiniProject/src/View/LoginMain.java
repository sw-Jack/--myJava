package View;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

// ù ȭ�� - �α��� ȭ��
public class LoginMain extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		//primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setTitle("ManageYourStore - Login");
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	// ���α׷� ������(������)
	public static void main(String[] args) {
		launch(args);
	}
}
