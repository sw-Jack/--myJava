package Controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import DB.MemberDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// ȸ������ ȭ�� GUI + Event
public class RegisterController implements Initializable {

	@FXML
	private ImageView regImageView; // ���� ���� ĳ���� �̹���
	@FXML
	private Button btnRegApply; // ȸ������ ��ư
	@FXML
	private Button btnRegCancle; // ��� ��ư
	@FXML
	private Button btnIdDupCheck; // ���̵� �ߺ� üũ ��ư
	@FXML
	private TextField tfName; // �̸� �ؽ�Ʈ 
	@FXML
	private TextField tfId; // ���̵� �ؽ�Ʈ
	@FXML
	private TextField tfPw; // ��й�ȣ �ؽ�Ʈ
	@FXML
	private TextField tfConfirmPw; // ��й�ȣ Ȯ�� �ؽ�Ʈ
	@FXML
	private TextField tfPhoneNum; // ��ȭ��ȣ �ؽ�Ʈ
	@FXML
	private TextField tfStoreCode; // �����ڵ� �ؽ�Ʈ
	@FXML
	private Label labelConfirmPw; // ��й�ȣ Ȯ�� ��
	
	 // �ߺ� üũ Ȯ�� ���� : ���̵� �ߺ� üũ �����ߴ��� ����
	// 0�̸� ���� X
	// 0���� ���� ���̸� üũ ���������� �ߺ� ���̵�� �Ǹ�� ���
	// 1���� ū ���̸� üũ �����߰� ��� ������ ���̵�� �Ǹ�� ���
	private int idCheck = 0;
	
	
 	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		File regFile = new File("src/image/felix_register.jpg");
		Image regImage = new Image(regFile.toURI().toString());
		regImageView.setImage(regImage);
	}

 	// ȸ������ ��ư �̺�Ʈ
 	public void btnRegApplyEvent(ActionEvent event) {
 		Alert alert = new Alert(AlertType.INFORMATION);
 		alert.setHeaderText(null);
 		if(idCheck > 0) // �ߺ� üũ�� �߰� ������ ����� ���
 			createAccount(); // ȸ������
 		else { // �ߺ� üũ�� ���� ���� ��� or �ߺ� üũ�� ���������� ���̵� �ߺ��� �߻��� ���
 				alert.setContentText("���̵� �ߺ� üũ�� ���� �����ϼ���.");
 				alert.show();
 		}
 		idCheck = 0; // �ٽ� �ߺ� üũ ���� �ʱ�ȭ
 	}
 	
 	// ��� ��ư �̺�Ʈ
 	public void btnRegCancleEvent(ActionEvent event) {
 		// ��� ��ư�� ���� â �������� 
 		Stage stage = (Stage)btnRegCancle.getScene().getWindow();
 		// ���� â �ݱ�
 		stage.close();
 	}
 	
 	// ���̵� �ߺ� üũ ��ư �̺�Ʈ
 	public void btnIdDupCheckEvent(ActionEvent event) {
 		isDupId(); // ���̵� �ߺ� üũ ���� 
 	}
 	
 	
 	// ȸ������ �޼���
 	public void createAccount() {
 		MemberDAO memberDAO = new MemberDAO(); // DAD ��ü ����
 		Stage stage = (Stage)btnRegApply.getScene().getWindow(); // ȸ������ ��ư�� ���� â ��������
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null); 	
		confirmPassword();
		boolean result = memberDAO.memberInsert( 
 				// ����� �Է� �� DAO ��ü�� ������ ȸ������ ����
 				// ȸ�����Կ� ���������� true ��ȯ�ް� �׷��� ������ false ��ȯ����
 				tfName.getText(), 
 				tfId.getText(), 
 				tfConfirmPw.getText(), 
 				tfPhoneNum.getText(), 
 				tfStoreCode.getText());
 		if(result) { // ȸ������ ����
			alert.setContentText("ȸ�������� ���ϵ帳�ϴ�.");
			alert.show();
			stage.close();
 		} else { // ȸ������ ����
			alert.setContentText("�Է� ������ Ȯ���ϼ���. ��� ������ �Է��ϼž� �մϴ�.");
			alert.show();
 		}
 	}
 	
 	// ���̵� �ߺ� üũ���� �޼���
 	public int isDupId() {
 		Alert alert = new Alert(AlertType.INFORMATION);
 		alert.setHeaderText(null);
 		idCheck = 1; // üũ ����
 		MemberDAO memberDAO = new MemberDAO();
 		if(tfId.getText().equals("")) {
 			alert.setContentText("���̵� �Է��ϼ���.");
 			alert.show();
 		} else {
	 		boolean result = memberDAO.isDupId(tfId.getText()); // �ߺ��̸� true, �ƴϸ� false ��ȯ ����
	 		if(result) { // DB�� �ش� ���̵� �̹� �����ϴ� ���, �� �ߺ� ���̵��̸�
	 			idCheck = -1; // �ߺ� ���̵�� �Ǹ�
	 			tfId.setText("");
	 			alert.setContentText("�ش� ���̵� �̹� �����մϴ�.");
	 		} else { // �ߺ� ���̵� �ƴ϶��
	 			alert.setContentText("��� ������ ���̵��Դϴ�.");
	 			idCheck++; // ��� ������ ���̵�� �Ǹ� (idCheck > 1)
	 		}
 			alert.show();
	 	}
 		return idCheck;
 	}
 	
 	// ��й�ȣ Ȯ�� ���� �޼���
 	public void confirmPassword() {
 		if(!tfPw.getText().equals("")) {
	 		if(!tfConfirmPw.getText().equals(tfPw.getText())) { // ��й�ȣ�� Ȯ�� ��й�ȣ�� ��ġ���� �ʴ� ���
	 			tfConfirmPw.setText("");
	 			labelConfirmPw.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
	 		} else {
	 			labelConfirmPw.setText("��й�ȣ�� ��ġ�մϴ�."); // ��ǻ� ��µ��� �ʴ� ����
	 		}
	 	}
 	}
}



























