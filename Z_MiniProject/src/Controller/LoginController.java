package Controller;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import DB.ConnectionUtil;
import DB.MemberDAO;
import DB.MemberVO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

// �α��� ȭ�� GUI + Event
public class LoginController implements Initializable {
	@FXML
	private Button btnLogin; // �α��� ��ư
	@FXML
	private Button btnRegister; // ȸ������ ��ư
	@FXML
	private Button btnCancle; // ��� ��ư
	@FXML
	private Label labelLoginMessage; // �α��� �޼��� ��
	@FXML
	private ImageView brandingImageView; // ���� ���� ĳ���� �̹���
	@FXML
	private ImageView lockImageView; // �ڹ��� �̹���
	@FXML
	private TextField userInputId; // ����� �Է� ���̵�
	@FXML
	private TextField userInputPw; // ����� �Է� ��й�ȣ
	
	MemberDAO memberDAO;
	
 	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		File brandingFile = new File("src/image/felix.jpg");
		Image brandingImage = new Image(brandingFile.toURI().toString());
		brandingImageView.setImage(brandingImage);
		
		File lockFile = new File("src/image/lock.jpg");
		Image lockImage = new Image(lockFile.toURI().toString());
		lockImageView.setImage(lockImage);
	}
	
	// �α��� ��ư �̺�Ʈ
	public void btnLoginEvent(ActionEvent event) {
		if(userInputId.getText().isEmpty() == false && userInputPw.getText().isEmpty() == false) { // id�� password ��� �Է� �Ǿ��ٸ�
			validateLogin();
		} else { 
			if(userInputId.getText().isEmpty()) // id�� �Էµ��� ���� ���
				labelLoginMessage.setText("���̵� �Է��ϼ���.");
			else // password�� �Էµ��� ���� ���
				labelLoginMessage.setText("��й�ȣ�� �Է��ϼ���.");
		}
	}
		
	// ȸ������ ��ư �̺�Ʈ
	public void btnRegisterEvent(ActionEvent event) {
		userInputId.setText("");
		userInputPw.setText("");
		createAccountForm();
	}
	
	// ��� ��ư �̺�Ʈ
	public void btnCancleEvent(ActionEvent event) {
		// ��� ��ư�� ���� â ��������
		Stage stage = (Stage)btnCancle.getScene().getWindow();
		// ���� â �ݱ�
		stage.close();
	}
	
	
	// �α��� ����
	public void validateLogin() {
		memberDAO = new MemberDAO(); // DAO ��ü ����
		Stage stage = (Stage)btnLogin.getScene().getWindow();
		// DAO�� �α��� �㰡 ���� �޼��� 
		// �α��ο� �����ϸ� true, �׷��� ������ false ��ȯ ����
		boolean result = memberDAO.login(userInputId.getText(), userInputPw.getText());
		if(result) { // �α��� ����
			toManagerMain();
			stage.close(); // �α����ϸ� �α����� â�� ���ֱ�
		}
		else labelLoginMessage.setText("���̵�� ��й�ȣ�� Ȯ���ϼ���."); // �α��� ����

	}
	
	// ȸ������ â���� �̵��ϱ� ����(â ����) �޼���
	public void createAccountForm() {
		try {
			// ȸ������ â fxml ���� �ε� , scene ����
			Parent root = FXMLLoader.load(getClass().getResource("/View/Register.fxml"));
			Stage registerStage = new Stage();
			registerStage.setTitle("ManageYourStore - Registration");
			registerStage.setResizable(false);
			registerStage.setScene(new Scene(root));
			registerStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
	
	// �α��� �� ������ ���� â�� �̵��ϱ� ����(â ����) �޼���
	public void toManagerMain() {
		try {
			// ������ ���� â fxml ���� �ε� , scene ����
			Parent root = FXMLLoader.load(getClass().getResource("/View/ManagerMain.fxml"));
			Stage managerMainStage = new Stage();
			managerMainStage.setTitle("���� ���� ���α׷� MYS(Manage Your Store)");
			managerMainStage.setResizable(false);
			managerMainStage.setScene(new Scene(root));
			managerMainStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
}




















