package View;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

// 첫 화면 - 로그인 화면
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
	
	// 프로그램 진입점(시작점)
	public static void main(String[] args) {
		launch(args);
	}
}
