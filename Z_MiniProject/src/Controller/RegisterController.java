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

// 회원가입 화면 GUI + Event
public class RegisterController implements Initializable {

	@FXML
	private ImageView regImageView; // 좌측 메인 캐릭터 이미지
	@FXML
	private Button btnRegApply; // 회원가입 버튼
	@FXML
	private Button btnRegCancle; // 취소 버튼
	@FXML
	private Button btnIdDupCheck; // 아이디 중복 체크 버튼
	@FXML
	private TextField tfName; // 이름 텍스트 
	@FXML
	private TextField tfId; // 아이디 텍스트
	@FXML
	private TextField tfPw; // 비밀번호 텍스트
	@FXML
	private TextField tfConfirmPw; // 비밀번호 확인 텍스트
	@FXML
	private TextField tfPhoneNum; // 전화번호 텍스트
	@FXML
	private TextField tfStoreCode; // 가게코드 텍스트
	@FXML
	private Label labelConfirmPw; // 비밀번호 확인 라벨
	
	 // 중복 체크 확인 변수 : 아이디 중복 체크 수행했는지 여부
	// 0이면 수행 X
	// 0보다 작은 값이면 체크 수행했으나 중복 아이디로 판명된 경우
	// 1보다 큰 값이면 체크 수행했고 사용 가능한 아이디로 판명된 경우
	private int idCheck = 0;
	
	
 	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		File regFile = new File("src/image/felix_register.jpg");
		Image regImage = new Image(regFile.toURI().toString());
		regImageView.setImage(regImage);
	}

 	// 회원가입 버튼 이벤트
 	public void btnRegApplyEvent(ActionEvent event) {
 		Alert alert = new Alert(AlertType.INFORMATION);
 		alert.setHeaderText(null);
 		if(idCheck > 0) // 중복 체크를 했고 조건을 통과한 경우
 			createAccount(); // 회원가입
 		else { // 중복 체크를 하지 않은 경우 or 중복 체크를 진행했으나 아이디 중복이 발생한 경우
 				alert.setContentText("아이디 중복 체크를 먼저 진행하세요.");
 				alert.show();
 		}
 		idCheck = 0; // 다시 중복 체크 변수 초기화
 	}
 	
 	// 취소 버튼 이벤트
 	public void btnRegCancleEvent(ActionEvent event) {
 		// 취소 버튼이 속한 창 가져오기 
 		Stage stage = (Stage)btnRegCancle.getScene().getWindow();
 		// 현재 창 닫기
 		stage.close();
 	}
 	
 	// 아이디 중복 체크 버튼 이벤트
 	public void btnIdDupCheckEvent(ActionEvent event) {
 		isDupId(); // 아이디 중복 체크 수행 
 	}
 	
 	
 	// 회원가입 메서드
 	public void createAccount() {
 		MemberDAO memberDAO = new MemberDAO(); // DAD 객체 생성
 		Stage stage = (Stage)btnRegApply.getScene().getWindow(); // 회원가입 버튼이 속한 창 가져오기
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null); 	
		confirmPassword();
		boolean result = memberDAO.memberInsert( 
 				// 사용자 입력 값 DAO 객체로 전송해 회원가입 진행
 				// 회원가입에 성공했으면 true 반환받고 그렇지 않으면 false 반환받음
 				tfName.getText(), 
 				tfId.getText(), 
 				tfConfirmPw.getText(), 
 				tfPhoneNum.getText(), 
 				tfStoreCode.getText());
 		if(result) { // 회원가입 성공
			alert.setContentText("회원가입을 축하드립니다.");
			alert.show();
			stage.close();
 		} else { // 회원가입 실패
			alert.setContentText("입력 정보를 확인하세요. 모든 정보를 입력하셔야 합니다.");
			alert.show();
 		}
 	}
 	
 	// 아이디 중복 체크수행 메서드
 	public int isDupId() {
 		Alert alert = new Alert(AlertType.INFORMATION);
 		alert.setHeaderText(null);
 		idCheck = 1; // 체크 수행
 		MemberDAO memberDAO = new MemberDAO();
 		if(tfId.getText().equals("")) {
 			alert.setContentText("아이디를 입력하세요.");
 			alert.show();
 		} else {
	 		boolean result = memberDAO.isDupId(tfId.getText()); // 중복이면 true, 아니면 false 반환 받음
	 		if(result) { // DB에 해당 아이디가 이미 존재하는 경우, 즉 중복 아이디이면
	 			idCheck = -1; // 중복 아이디로 판명
	 			tfId.setText("");
	 			alert.setContentText("해당 아이디가 이미 존재합니다.");
	 		} else { // 중복 아이디가 아니라면
	 			alert.setContentText("사용 가능한 아이디입니다.");
	 			idCheck++; // 사용 가능한 아이디로 판명 (idCheck > 1)
	 		}
 			alert.show();
	 	}
 		return idCheck;
 	}
 	
 	// 비밀번호 확인 수행 메서드
 	public void confirmPassword() {
 		if(!tfPw.getText().equals("")) {
	 		if(!tfConfirmPw.getText().equals(tfPw.getText())) { // 비밀번호와 확인 비밀번호가 일치하지 않는 경우
	 			tfConfirmPw.setText("");
	 			labelConfirmPw.setText("비밀번호가 일치하지 않습니다.");
	 		} else {
	 			labelConfirmPw.setText("비밀번호가 일치합니다."); // 사실상 출력되지 않는 문구
	 		}
	 	}
 	}
}



























