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

// 로그인 화면 GUI + Event
public class LoginController implements Initializable {
	@FXML
	private Button btnLogin; // 로그인 버튼
	@FXML
	private Button btnRegister; // 회원가입 버튼
	@FXML
	private Button btnCancle; // 취소 버튼
	@FXML
	private Label labelLoginMessage; // 로그인 메세지 라벨
	@FXML
	private ImageView brandingImageView; // 좌측 메인 캐릭터 이미지
	@FXML
	private ImageView lockImageView; // 자물쇠 이미지
	@FXML
	private TextField userInputId; // 사용자 입력 아이디
	@FXML
	private TextField userInputPw; // 사용자 입력 비밀번호
	
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
	
	// 로그인 버튼 이벤트
	public void btnLoginEvent(ActionEvent event) {
		if(userInputId.getText().isEmpty() == false && userInputPw.getText().isEmpty() == false) { // id와 password 모두 입력 되었다면
			validateLogin();
		} else { 
			if(userInputId.getText().isEmpty()) // id가 입력되지 않은 경우
				labelLoginMessage.setText("아이디를 입력하세요.");
			else // password가 입력되지 않은 경우
				labelLoginMessage.setText("비밀번호를 입력하세요.");
		}
	}
		
	// 회원가입 버튼 이벤트
	public void btnRegisterEvent(ActionEvent event) {
		userInputId.setText("");
		userInputPw.setText("");
		createAccountForm();
	}
	
	// 취소 버튼 이벤트
	public void btnCancleEvent(ActionEvent event) {
		// 취소 버튼이 속한 창 가져오기
		Stage stage = (Stage)btnCancle.getScene().getWindow();
		// 현재 창 닫기
		stage.close();
	}
	
	
	// 로그인 검증
	public void validateLogin() {
		memberDAO = new MemberDAO(); // DAO 객체 생성
		Stage stage = (Stage)btnLogin.getScene().getWindow();
		// DAO의 로그인 허가 여부 메서드 
		// 로그인에 성공하면 true, 그렇지 않으면 false 반환 받음
		boolean result = memberDAO.login(userInputId.getText(), userInputPw.getText());
		if(result) { // 로그인 성공
			toManagerMain();
			stage.close(); // 로그인하면 로그인은 창은 없애기
		}
		else labelLoginMessage.setText("아이디와 비밀번호를 확인하세요."); // 로그인 실패

	}
	
	// 회원가입 창으로 이동하기 위한(창 띄우기) 메서드
	public void createAccountForm() {
		try {
			// 회원가입 창 fxml 파일 로드 , scene 설정
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
	
	// 로그인 후 관리자 메인 창을 이동하기 위한(창 띄우기) 메서드
	public void toManagerMain() {
		try {
			// 관리자 메인 창 fxml 파일 로드 , scene 설정
			Parent root = FXMLLoader.load(getClass().getResource("/View/ManagerMain.fxml"));
			Stage managerMainStage = new Stage();
			managerMainStage.setTitle("매장 관리 프로그램 MYS(Manage Your Store)");
			managerMainStage.setResizable(false);
			managerMainStage.setScene(new Scene(root));
			managerMainStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
}




















