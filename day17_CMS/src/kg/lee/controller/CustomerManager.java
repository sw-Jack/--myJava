package kg.lee.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import kg.lee.vo.Customer;

public class CustomerManager {
	// 멤버
	private boolean isStop;
	private BufferedReader br;
	private ArrayList<Customer> data; // 모든 고객의 정보들을 저장할 ArrayList
	private int position; // 검색한 고객의 인덱스 위치
	// 생성자
	public CustomerManager() { 
		isStop = false;
		br = new BufferedReader(new InputStreamReader(System.in));
		data = new ArrayList<Customer>();
		position = -1;
	}
	
	// 메서드
	public void start() throws IOException {
		int menu = -1;
		
		while(!isStop) {
			System.out.println("<고객관리프로그램>");
			System.out.println("1.고객등록");
			System.out.println("2.고객검색");
			System.out.println("3.고객정보수정");
			System.out.println("4.고객정보삭제");
			System.out.println("5.고객전체목록보기");
			System.out.println("0.프로그램종료");
			System.out.print("[메뉴선택] : ");
			
			try {
				menu = Integer.parseInt(br.readLine());
			} catch(NumberFormatException e) {
				menu = -1; // switch 문의 default로 가서 메뉴 입력 오류로 처리, 다시 입력하도록 유도
			}
			switch(menu) {
			case 1 : addCustomer(); break;
			case 2 : searchCustomer(); break;
			case 3 : updateCustomer(); break;
			case 4 : deleteCustomer(); break;
			case 5 : showAll(); break;
			case 0 : stop(); break;
			default :
				System.err.println("[Error : 메뉴입력오류] 메뉴를 확인하고 다시 입력하세요...\n");
				break;
			} // end switch
		} // end while
	}
	
	// 고객등록
	public void addCustomer() throws IOException {
		System.out.println("\n[고객등록]");
		System.out.print("이    름 : ");
		String name = br.readLine();
		 
		System.out.print("나    이 : ");
		int age = Integer.parseInt(br.readLine());
		
		System.out.print("전화번호 : ");
		String phone = br.readLine();
		
		System.out.print("주    소 : ");
		String address = br.readLine();
		
		Customer customer = new Customer(name, age, phone, address); // vo 이용
		data.add(customer); // 등록 고객 정보를 ArrayList에 저장
		System.out.println(customer.getName() + "님의 정보가 성공적으로 등록되었습니다.\n");
	}

	// 고객검색
	public void searchCustomer() throws IOException {
		System.out.println("\n[고객검색]");	
		System.out.print("검색할 고객 이름 : ");
		String name = br.readLine();
		
		position = -1;
		
		for(int i=0; i<data.size(); i++) {
			Customer customer = data.get(i);
			if(name.equals(customer.getName())) {
				position = i;
				break;
			}
		}
		
		if(position < 0) { // 입력한 고객을 못 찾은 경우
			System.err.println(name + "님은 등록된 고객이 아닙니다. 고객등록을 먼저 진행하세요...\n");
		} else { // 찾은 경우
			System.out.println(name + "님의 정보 검색 성공...\n");
		}
	}

	// 고객정보수정
	public void updateCustomer() throws IOException {
		System.out.println("\n[고객정보수정]");
		if(position < 0) {
			System.err.println("수정할 고객 정보 검색을 먼저 진행하세요...\n");
			return;
		}
		
		Customer customer =  data.get(position);
		int menu = -1;
		boolean isLoop = true;
		
		while(isLoop) {
			System.out.println("[" + customer.getName() + "님의 정보 수정]");
			System.out.println("1.전화번호수정");
			System.out.println("2.주소수정");
			System.out.println("0.수정취소");
			System.out.print("[메뉴선택] : ");
			try {
				menu = Integer.parseInt(br.readLine());
			} catch(NumberFormatException e) {
				menu = -1;
			}
			
			switch(menu) {
			case 1 : 
				System.out.print("\n수정할 전화번호 : ");
				String phone = br.readLine();
				customer.setPhone(phone);
				System.out.println("전화번호가 성공적으로 수정되었습니다.\n");
				isLoop = false;
				break;
			case 2 : 
				System.out.print("\n수정할 주소 : ");
				String address = br.readLine();
				customer.setPhone(address);
				System.out.println("주소가 성공적으로 수정되었습니다.\n");
				isLoop = false;
				break;
			case 0 : 
				System.out.println("\n" + customer.getName() + "님의 정보 수정을 취소합니다...\n");
				isLoop = false;
				break;
			default : 
				System.err.println("[Error : 메뉴입력오류] 메뉴를 확인하고 다시 입력하세요...\n");
				isLoop = true;
				break;
			} // end switch
		} // end while
	}
	
	// 고객정보삭제
	public void deleteCustomer() throws IOException {
		System.out.println("\n[고객정보삭제]");
		if(position < 0) {
			System.err.println("삭제할 고객 정보 검색을 먼저 진행하세요...\n");
			return;
		}
		
		Customer customer =  data.get(position);
		
		System.out.print(customer.getName() + "님의 정보를 삭제하시겠습니까? (y/n) : ");
		String result = br.readLine();
		if(result.equals("y") || result.equals("Y")) {
			System.out.println(customer.getName() + "님의 정보삭제 성공...\n");
			data.remove(position);
			position = -1; // 삭제된 인덱스 초기화
		} else {
			System.out.println(customer.getName() + "님의 정보 삭제를 취소합니다...\n");
		}
		
	}

	// 고객전체목록보기
	public void showAll() {
		int i = 0;
		System.out.println("\n[고객전체목록보기]");
		if(data.size() == 0) 
			System.out.println("등록된 고객이 존재하지 않습니다...\n");
		else {
			for(Customer customer : data) {
				// System.out.println(customer.toString());
				System.out.println("[" + (i+1) + "번 고객 정보]");
				customer.printAll();
				i++;
			}
			System.out.println();
		}
	}

	// 프로그램종료
	public void stop() throws IOException {
		System.out.print("\n프로그램을 종료하시겠습니까? (y/n) : ");
		String result = br.readLine();
		if(result.equals("y") || result.equals("Y")) {
			System.out.println("프로그램을 종료합니다...");
			isStop = true;
		} else {
			System.out.println("프로그램 종료를 취소합니다...\n");
			isStop = false;
		}
	}

	// main
	public static void main(String[] args) {
		CustomerManager cmanager = new CustomerManager();
		try {
			cmanager.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
