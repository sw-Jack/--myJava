package Controller;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ManagerMainController implements Initializable {

	@FXML
	private Label labelManagerId; // 접속 관리자 ID 출력 라벨
	@FXML
	private Button btnServerOn; // 서버 ON 버튼
	@FXML
	private Button btnLogout; // 로그아웃 버튼
	@FXML
	private ImageView mainImageView; // 메인 로고 이미지
	

    @Override
    public void initialize(URL location, ResourceBundle resources) {
		File mainFile = new File("src/image/felix_main.png");
		Image mainImage = new Image(mainFile.toURI().toString());
		mainImageView.setImage(mainImage);
    }
 
    // 서버 작동 버튼
    public void btnServerOnEvent(ActionEvent event) {
    	if(btnServerOn.getText().equals("서버 ON")) {
        	labelManagerId.setText("관리자 ID : test");
    		btnServerOn.setText("서버 OFF");
    	}else {
        	labelManagerId.setText("");
    		btnServerOn.setText("서버 ON");
    	}
    }
    
    // 로그아웃 버튼
    public void btnLogoutEvent() {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText(null);
    	alert.setTitle("로그아웃 확인");
    	alert.setContentText("정말 로그아웃하시겠습니까?");

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		alert = new Alert(AlertType.INFORMATION);
        	alert.setHeaderText(null);
        	alert.setTitle("로그아웃");
        	alert.setContentText("로그아웃되었습니다.");
        	alert.showAndWait();
    	   	Stage stage = (Stage)btnLogout.getScene().getWindow();
        	stage.close();
        	toLogin(); // 로그인 창으로
    	} 
    }
    
    // 로그아웃해서 로그인창으로 이동하기 위한 메서드
    public void toLogin() {
		try {
			// 관리자 메인 창 fxml 파일 로드 , scene 설정
			Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
			Stage loginStage = new Stage();
			loginStage.setTitle("매장 관리 프로그램 MYS(Manage Your Store)");
			loginStage.setResizable(false);
			loginStage.setScene(new Scene(root));
			loginStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}
    }
}

