package kg.lee.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import kg.lee.vo.Customer;

public class CustomerManager {
	// ���
	private boolean isStop;
	private BufferedReader br;
	private ArrayList<Customer> data; // ��� ���� �������� ������ ArrayList
	private int position; // �˻��� ���� �ε��� ��ġ
	// ������
	public CustomerManager() { 
		isStop = false;
		br = new BufferedReader(new InputStreamReader(System.in));
		data = new ArrayList<Customer>();
		position = -1;
	}
	
	// �޼���
	public void start() throws IOException {
		int menu = -1;
		
		while(!isStop) {
			System.out.println("<���������α׷�>");
			System.out.println("1.�����");
			System.out.println("2.���˻�");
			System.out.println("3.����������");
			System.out.println("4.����������");
			System.out.println("5.����ü��Ϻ���");
			System.out.println("0.���α׷�����");
			System.out.print("[�޴�����] : ");
			
			try {
				menu = Integer.parseInt(br.readLine());
			} catch(NumberFormatException e) {
				menu = -1; // switch ���� default�� ���� �޴� �Է� ������ ó��, �ٽ� �Է��ϵ��� ����
			}
			switch(menu) {
			case 1 : addCustomer(); break;
			case 2 : searchCustomer(); break;
			case 3 : updateCustomer(); break;
			case 4 : deleteCustomer(); break;
			case 5 : showAll(); break;
			case 0 : stop(); break;
			default :
				System.err.println("[Error : �޴��Է¿���] �޴��� Ȯ���ϰ� �ٽ� �Է��ϼ���...\n");
				break;
			} // end switch
		} // end while
	}
	
	// �����
	public void addCustomer() throws IOException {
		System.out.println("\n[�����]");
		System.out.print("��    �� : ");
		String name = br.readLine();
		 
		System.out.print("��    �� : ");
		int age = Integer.parseInt(br.readLine());
		
		System.out.print("��ȭ��ȣ : ");
		String phone = br.readLine();
		
		System.out.print("��    �� : ");
		String address = br.readLine();
		
		Customer customer = new Customer(name, age, phone, address); // vo �̿�
		data.add(customer); // ��� �� ������ ArrayList�� ����
		System.out.println(customer.getName() + "���� ������ ���������� ��ϵǾ����ϴ�.\n");
	}

	// ���˻�
	public void searchCustomer() throws IOException {
		System.out.println("\n[���˻�]");	
		System.out.print("�˻��� �� �̸� : ");
		String name = br.readLine();
		
		position = -1;
		
		for(int i=0; i<data.size(); i++) {
			Customer customer = data.get(i);
			if(name.equals(customer.getName())) {
				position = i;
				break;
			}
		}
		
		if(position < 0) { // �Է��� ���� �� ã�� ���
			System.err.println(name + "���� ��ϵ� ���� �ƴմϴ�. ������� ���� �����ϼ���...\n");
		} else { // ã�� ���
			System.out.println(name + "���� ���� �˻� ����...\n");
		}
	}

	// ����������
	public void updateCustomer() throws IOException {
		System.out.println("\n[����������]");
		if(position < 0) {
			System.err.println("������ �� ���� �˻��� ���� �����ϼ���...\n");
			return;
		}
		
		Customer customer =  data.get(position);
		int menu = -1;
		boolean isLoop = true;
		
		while(isLoop) {
			System.out.println("[" + customer.getName() + "���� ���� ����]");
			System.out.println("1.��ȭ��ȣ����");
			System.out.println("2.�ּҼ���");
			System.out.println("0.�������");
			System.out.print("[�޴�����] : ");
			try {
				menu = Integer.parseInt(br.readLine());
			} catch(NumberFormatException e) {
				menu = -1;
			}
			
			switch(menu) {
			case 1 : 
				System.out.print("\n������ ��ȭ��ȣ : ");
				String phone = br.readLine();
				customer.setPhone(phone);
				System.out.println("��ȭ��ȣ�� ���������� �����Ǿ����ϴ�.\n");
				isLoop = false;
				break;
			case 2 : 
				System.out.print("\n������ �ּ� : ");
				String address = br.readLine();
				customer.setPhone(address);
				System.out.println("�ּҰ� ���������� �����Ǿ����ϴ�.\n");
				isLoop = false;
				break;
			case 0 : 
				System.out.println("\n" + customer.getName() + "���� ���� ������ ����մϴ�...\n");
				isLoop = false;
				break;
			default : 
				System.err.println("[Error : �޴��Է¿���] �޴��� Ȯ���ϰ� �ٽ� �Է��ϼ���...\n");
				isLoop = true;
				break;
			} // end switch
		} // end while
	}
	
	// ����������
	public void deleteCustomer() throws IOException {
		System.out.println("\n[����������]");
		if(position < 0) {
			System.err.println("������ �� ���� �˻��� ���� �����ϼ���...\n");
			return;
		}
		
		Customer customer =  data.get(position);
		
		System.out.print(customer.getName() + "���� ������ �����Ͻðڽ��ϱ�? (y/n) : ");
		String result = br.readLine();
		if(result.equals("y") || result.equals("Y")) {
			System.out.println(customer.getName() + "���� �������� ����...\n");
			data.remove(position);
			position = -1; // ������ �ε��� �ʱ�ȭ
		} else {
			System.out.println(customer.getName() + "���� ���� ������ ����մϴ�...\n");
		}
		
	}

	// ����ü��Ϻ���
	public void showAll() {
		int i = 0;
		System.out.println("\n[����ü��Ϻ���]");
		if(data.size() == 0) 
			System.out.println("��ϵ� ���� �������� �ʽ��ϴ�...\n");
		else {
			for(Customer customer : data) {
				// System.out.println(customer.toString());
				System.out.println("[" + (i+1) + "�� �� ����]");
				customer.printAll();
				i++;
			}
			System.out.println();
		}
	}

	// ���α׷�����
	public void stop() throws IOException {
		System.out.print("\n���α׷��� �����Ͻðڽ��ϱ�? (y/n) : ");
		String result = br.readLine();
		if(result.equals("y") || result.equals("Y")) {
			System.out.println("���α׷��� �����մϴ�...");
			isStop = true;
		} else {
			System.out.println("���α׷� ���Ḧ ����մϴ�...\n");
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
