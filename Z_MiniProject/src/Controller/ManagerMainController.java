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
	private Label labelManagerId; // ���� ������ ID ��� ��
	@FXML
	private Button btnServerOn; // ���� ON ��ư
	@FXML
	private Button btnLogout; // �α׾ƿ� ��ư
	@FXML
	private ImageView mainImageView; // ���� �ΰ� �̹���
	

    @Override
    public void initialize(URL location, ResourceBundle resources) {
		File mainFile = new File("src/image/felix_main.png");
		Image mainImage = new Image(mainFile.toURI().toString());
		mainImageView.setImage(mainImage);
    }
 
    // ���� �۵� ��ư
    public void btnServerOnEvent(ActionEvent event) {
    	if(btnServerOn.getText().equals("���� ON")) {
        	labelManagerId.setText("������ ID : test");
    		btnServerOn.setText("���� OFF");
    	}else {
        	labelManagerId.setText("");
    		btnServerOn.setText("���� ON");
    	}
    }
    
    // �α׾ƿ� ��ư
    public void btnLogoutEvent() {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText(null);
    	alert.setTitle("�α׾ƿ� Ȯ��");
    	alert.setContentText("���� �α׾ƿ��Ͻðڽ��ϱ�?");

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		alert = new Alert(AlertType.INFORMATION);
        	alert.setHeaderText(null);
        	alert.setTitle("�α׾ƿ�");
        	alert.setContentText("�α׾ƿ��Ǿ����ϴ�.");
        	alert.showAndWait();
    	   	Stage stage = (Stage)btnLogout.getScene().getWindow();
        	stage.close();
        	toLogin(); // �α��� â����
    	} 
    }
    
    // �α׾ƿ��ؼ� �α���â���� �̵��ϱ� ���� �޼���
    public void toLogin() {
		try {
			// ������ ���� â fxml ���� �ε� , scene ����
			Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
			Stage loginStage = new Stage();
			loginStage.setTitle("���� ���� ���α׷� MYS(Manage Your Store)");
			loginStage.setResizable(false);
			loginStage.setScene(new Scene(root));
			loginStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}
    }
}

