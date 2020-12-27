import java.io.*;
import java.util.*;	// for Vector Class

public class MemManager {
	private BufferedReader br;
	private Vector<MyMember> members; // MyMember�� members��� �̸��� ���� Ŭ������ ����
	private int status; // ȸ�� �˻� ���� = �α��� ����
	
	// ������
	public MemManager() {
		br = new BufferedReader(new InputStreamReader(System.in));
		members = new Vector<MyMember> (); 
		status = -1;
	}

	// �޼���
	public void Run() throws IOException {
		int menu = -1;
		boolean isStop = false;
		
		while(!isStop) {
			menuPrint(); // �޴�â
			try {
				menu = Integer.parseInt(br.readLine());// �޴��� �Է� �ޱ�
			} catch(NumberFormatException e) {
				menu = -1; // switch���� default�� ����
			}

			switch(menu) {
				case 0 :	// ���α׷� ����
					System.out.println("\n[���α׷� ����]");
					System.out.print("���α׷��� �����Ͻðڽ��ϱ�? (y/n) : ");
					String reply = br.readLine();
					if(reply.equals("y") || reply.equals("Y")) {
						isStop = true;
						System.out.println("���α׷��� �����մϴ�...\n");
					} else
						System.out.println("���α׷� ���Ḧ ����մϴ�...\n");
					break;
				case 1 :	// ȸ������
					addMember();
					break;
				case 2 :	// �α���
					logIn();
					break;
				case 3 :    // �α׾ƿ�
					logOut();
					break;
				case 4 :	// ��������
					editMember();
					break;
				case 5 :	// ȸ��Ż��
					deleteMember();
					break;
				case 6 :	// ��ü���
					if(members.size() == 0) 
						System.out.println("\n��ϵ� ȸ���� �����ϴ�.\n");
					else 
						showAllMember();
					break;
				default : 
					System.out.println("[Error] �޴�(0 ~ 6)�� �ٽ� �����ϼ��� ...\n"); 
					break;
			}
		}
	} 

	// �޴� ��� �޼���
	public void menuPrint() {
		System.out.println("<ȸ������ ���α׷�>");
		System.out.println("1.ȸ������");
		System.out.println("2.�α���");
		System.out.println("3.�α׾ƿ�");
		System.out.println("4.��������");
		System.out.println("5.ȸ��Ż��");
		System.out.println("6.��ü���");
		System.out.println("0.���α׷�����");
		System.out.print("* �޴� ����: ");
	}
	// ȸ������(�߰�) �޼���
	public void addMember() throws IOException {
		System.out.println("\n[ȸ������]");
		System.out.print("��    �� : ");
		String name = br.readLine();
		System.out.print("��    �� : ");
		int age = Integer.parseInt(br.readLine());
		System.out.print("��ȭ��ȣ : ");
		String phone = br.readLine();
		System.out.print("��    �� : ");
		String addr = br.readLine();

		MyMember myMember = new MyMember(name, age, phone, addr);
		members.add(myMember); // �Էµ� ȸ�������� ���Ϳ� ����
		System.out.println("[" + myMember.getName() + "] ���� ȸ�������� �Ϸ�Ǿ����ϴ�! ȯ���մϴ�!^^");
		System.out.println();
	}
	// �α��� �޼���
	public void logIn() throws IOException {
		int cnt = -1; // �α��� ���� ���� ����
		System.out.println("\n[�α���]");
		System.out.print("�α��� �̸� : ");
		String searchName = br.readLine();
		for(int i=0; i<members.size();  i++) {
			if(members.elementAt(i).getName().equals(searchName)) {
				status = i;
				cnt += 1;
				break;
			} 
		}
		if(cnt < 0) // �˻��� ȸ���� ã�� ���� ���
			System.err.println("�ش� ȸ���� �������� �ʽ��ϴ�...\n");
		else 
			System.out.println("[" + searchName + "] �� �ȳ��ϼ���^^\n");
	}
	// �α׾ƿ� �޼���
	public void logOut() {
		if(status < 0) {
			System.out.print("�α��� ���� �������ּ���...\n");
		} else {
			status = -1;
			System.out.println("[�α׾ƿ�]\n�α׾ƿ��Ǿ����ϴ�...\n");
		}
	}
	// �������� �޼���
	public void editMember() throws IOException {
		System.out.println("\n[��������]");
		if(status < 0) {// ������ ȸ�� �˻��� �������� ���� ���
			System.err.println("�α��� ���� �������ּ���...\n");
			return;
		}
		
		boolean isStop = false;
		int menu = -1;
		while(!isStop) {
			System.out.println("[" + members.elementAt(status).getName() + "���� ��������]");
			System.out.println("1.��ȭ��ȣ����");
			System.out.println("2.�ּҼ���");
			System.out.println("0.�������/������");
			System.out.print("* �޴� ����: ");
			try { 
				menu = Integer.parseInt(br.readLine());
			} catch(NumberFormatException e) {
				menu = -1; // switch���� default�� ����
			}

			switch(menu) {
				case 1 : 
					System.out.println("\n[��ȭ��ȣ����]");
					System.out.print("������ ��ȭ��ȣ : ");
					String phone = br.readLine();
					members.elementAt(status).setPhone(phone); // ���� ���� ��ȭ��ȣ�� ����
					System.out.println("��ȭ��ȣ�� ���������� ����Ǿ����ϴ�.\n");
					break;
				case 2 : 
					System.out.println("\n[�ּҼ���]");
					System.out.print("������ �ּ� : ");
					String addr = br.readLine();
					members.elementAt(status).setAddr(addr); // ���� ���� �ּҰ� ����
					System.out.println("�ּҰ� ���������� ����Ǿ����ϴ�.\n");
					break;
				case 0 : 
					isStop = true;
					System.out.println("\n[�������/������]");
					System.out.println("������ ����մϴ�...\n");
					break;
				default : 
					System.err.println("[Error] �޴�(0 ~ 2)�� �ٽ� �����ϼ��� ...\n");
					break;
			} // end switch
		} // end while


	}
	// ȸ��Ż�� �޼���
	public void deleteMember() throws IOException {
		System.out.println("\n[ȸ��Ż��]");
		if(status < 0) {
			System.out.print("�α��� ���� �������ּ���...\n");
			return;
		}
		System.out.print(members.elementAt(status).getName() + "��, ���� ȸ��Ż�� �����Ͻðڽ��ϱ�? (y/n) : ");
		String reply = br.readLine();
		if(reply.equals("y") || reply.equals("Y")) {
			System.out.println(members.elementAt(status).getName() + "���� ȸ��Ż�� �����մϴ�...");
			members.remove(status);
			status = -1; // �α��� ���� ���� �ʱ�ȭ 
			System.out.println("ȸ��Ż�� �Ϸ�Ǿ����ϴ�. �����մϴ�.\n");
		} else {
			System.out.println("ȸ��Ż�� ����մϴ�...\n");
		}
	}
	// ��ü��� ���� �޼���
	public void showAllMember() {
		int i = 1;
		System.out.println("\n[ȸ�����]");
		for(MyMember member : members) {
			System.out.println("*" + i + "�� ȸ������");
			member.printAll();
			i++;
		}
	}
}
