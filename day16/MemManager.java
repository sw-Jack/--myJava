import java.io.*;
import java.util.*;	// for Vector Class

public class MemManager {
	private BufferedReader br;
	private Vector<MyMember> members; // MyMember를 members라는 이름의 벡터 클래스로 선언
	private int status; // 회원 검색 유무 = 로그인 상태
	
	// 생성자
	public MemManager() {
		br = new BufferedReader(new InputStreamReader(System.in));
		members = new Vector<MyMember> (); 
		status = -1;
	}

	// 메서드
	public void Run() throws IOException {
		int menu = -1;
		boolean isStop = false;
		
		while(!isStop) {
			menuPrint(); // 메뉴창
			try {
				menu = Integer.parseInt(br.readLine());// 메뉴값 입력 받기
			} catch(NumberFormatException e) {
				menu = -1; // switch문의 default로 유도
			}

			switch(menu) {
				case 0 :	// 프로그램 종료
					System.out.println("\n[프로그램 종료]");
					System.out.print("프로그램을 종료하시겠습니까? (y/n) : ");
					String reply = br.readLine();
					if(reply.equals("y") || reply.equals("Y")) {
						isStop = true;
						System.out.println("프로그램을 종료합니다...\n");
					} else
						System.out.println("프로그램 종료를 취소합니다...\n");
					break;
				case 1 :	// 회원가입
					addMember();
					break;
				case 2 :	// 로그인
					logIn();
					break;
				case 3 :    // 로그아웃
					logOut();
					break;
				case 4 :	// 정보수정
					editMember();
					break;
				case 5 :	// 회원탈퇴
					deleteMember();
					break;
				case 6 :	// 전체목록
					if(members.size() == 0) 
						System.out.println("\n등록된 회원이 없습니다.\n");
					else 
						showAllMember();
					break;
				default : 
					System.out.println("[Error] 메뉴(0 ~ 6)를 다시 선택하세요 ...\n"); 
					break;
			}
		}
	} 

	// 메뉴 출력 메서드
	public void menuPrint() {
		System.out.println("<회원관리 프로그램>");
		System.out.println("1.회원가입");
		System.out.println("2.로그인");
		System.out.println("3.로그아웃");
		System.out.println("4.정보수정");
		System.out.println("5.회원탈퇴");
		System.out.println("6.전체목록");
		System.out.println("0.프로그램종료");
		System.out.print("* 메뉴 선택: ");
	}
	// 회원가입(추가) 메서드
	public void addMember() throws IOException {
		System.out.println("\n[회원가입]");
		System.out.print("이    름 : ");
		String name = br.readLine();
		System.out.print("나    이 : ");
		int age = Integer.parseInt(br.readLine());
		System.out.print("전화번호 : ");
		String phone = br.readLine();
		System.out.print("주    소 : ");
		String addr = br.readLine();

		MyMember myMember = new MyMember(name, age, phone, addr);
		members.add(myMember); // 입력된 회원정보를 벡터에 저장
		System.out.println("[" + myMember.getName() + "] 님의 회원가입이 완료되었습니다! 환영합니다!^^");
		System.out.println();
	}
	// 로그인 메서드
	public void logIn() throws IOException {
		int cnt = -1; // 로그인 성공 유무 변수
		System.out.println("\n[로그인]");
		System.out.print("로그인 이름 : ");
		String searchName = br.readLine();
		for(int i=0; i<members.size();  i++) {
			if(members.elementAt(i).getName().equals(searchName)) {
				status = i;
				cnt += 1;
				break;
			} 
		}
		if(cnt < 0) // 검색한 회원을 찾기 못한 경우
			System.err.println("해당 회원이 존재하지 않습니다...\n");
		else 
			System.out.println("[" + searchName + "] 님 안녕하세요^^\n");
	}
	// 로그아웃 메서드
	public void logOut() {
		if(status < 0) {
			System.out.print("로그인 먼저 진행해주세요...\n");
		} else {
			status = -1;
			System.out.println("[로그아웃]\n로그아웃되었습니다...\n");
		}
	}
	// 정보수정 메서드
	public void editMember() throws IOException {
		System.out.println("\n[정보수정]");
		if(status < 0) {// 사전에 회원 검색을 진행하지 않은 경우
			System.err.println("로그인 먼저 진행해주세요...\n");
			return;
		}
		
		boolean isStop = false;
		int menu = -1;
		while(!isStop) {
			System.out.println("[" + members.elementAt(status).getName() + "님의 정보수정]");
			System.out.println("1.전화번호수정");
			System.out.println("2.주소수정");
			System.out.println("0.수정취소/나가기");
			System.out.print("* 메뉴 선택: ");
			try { 
				menu = Integer.parseInt(br.readLine());
			} catch(NumberFormatException e) {
				menu = -1; // switch문의 default로 유도
			}

			switch(menu) {
				case 1 : 
					System.out.println("\n[전화번호수정]");
					System.out.print("수정할 전화번호 : ");
					String phone = br.readLine();
					members.elementAt(status).setPhone(phone); // 벡터 저장 전화번호값 수정
					System.out.println("전화번호가 성공적으로 변경되었습니다.\n");
					break;
				case 2 : 
					System.out.println("\n[주소수정]");
					System.out.print("수정할 주소 : ");
					String addr = br.readLine();
					members.elementAt(status).setAddr(addr); // 벡터 저장 주소값 수정
					System.out.println("주소가 성공적으로 변경되었습니다.\n");
					break;
				case 0 : 
					isStop = true;
					System.out.println("\n[수정취소/나가기]");
					System.out.println("수정을 취소합니다...\n");
					break;
				default : 
					System.err.println("[Error] 메뉴(0 ~ 2)를 다시 선택하세요 ...\n");
					break;
			} // end switch
		} // end while


	}
	// 회원탈퇴 메서드
	public void deleteMember() throws IOException {
		System.out.println("\n[회원탈퇴]");
		if(status < 0) {
			System.out.print("로그인 먼저 진행해주세요...\n");
			return;
		}
		System.out.print(members.elementAt(status).getName() + "님, 정말 회원탈퇴를 진행하시겠습니까? (y/n) : ");
		String reply = br.readLine();
		if(reply.equals("y") || reply.equals("Y")) {
			System.out.println(members.elementAt(status).getName() + "님의 회원탈퇴를 진행합니다...");
			members.remove(status);
			status = -1; // 로그인 상태 변수 초기화 
			System.out.println("회원탈퇴가 완료되었습니다. 감사합니다.\n");
		} else {
			System.out.println("회원탈퇴를 취소합니다...\n");
		}
	}
	// 전체목록 보기 메서드
	public void showAllMember() {
		int i = 1;
		System.out.println("\n[회원목록]");
		for(MyMember member : members) {
			System.out.println("*" + i + "번 회원정보");
			member.printAll();
			i++;
		}
	}
}
