package lee.java.test02;
import java.io.*;

public class IdNumberCheck {
	public static void main(String[] ar) throws IOException {

		int unNormalInput = 0; // ������ �Է� �Ǽ�
		int normalIdNum = 0; // ���� �ֹι�ȣ �Ǽ�
		int errorIdNum = 0; // ���� �ֹι�ȣ �Ǽ�
		
		System.out.println("===============================================\n" 
				+ "�̷�ũ���� �ֹι�ȣ ���� �� ���� ���α׷�\n\t- ȫ�浿\n"
				+ "===============================================");
		System.out.println("* �ֹι�ȣ �Է� (OOOOOO-OOOOOOO ������ ���� 14�ڸ�, exit �Է½� ����)");

		while(true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			boolean isOk = true; // ���� �Է� ����
			String[] idNum = new String[14];; // �ֹι�ȣ ������ �迭 : ������ ���� �� 14�ڸ�
			int[] intIdNum = new int[13]; // �������� ������ �ֹι�ȣ�� ���� �迭 : �� 13�ڸ�
			
			// �Է� �ޱ�
			System.out.print(">> ������ �Է� : ");
			String strIdNum = br.readLine();
			// exit�� �Է¹����� ����, while�� break
			if (strIdNum.equals("exit")) {
				break;
			} 
			// br.readLine()���� ���� ���ڿ��� ���ڿ� ������ ������ ���� ���� �迭�� �ɰ���(split�Լ� ���)
			idNum = strIdNum.split("");

			// �迭�� ����ϱ� ������ 
			// �Է� ���� �־ ������ �ֹι�ȣ ���ĺ��� ���� �ڸ� ���� �Է��ϰų�(ArrayIndexOutOfBoundsException)
			// -�� ������ ���� �̿��� Ư�����ڸ� �Է��ϰ� �Ǵ� ��(NumberFormatException)�� ���� ó��
			try {
				// ���ڿ� ������ ������ ���� �������� ������ ����(�ֹι�ȣ)���� �����ϱ� ���� �迭 intIdNum
				for (int i = 0; i < idNum.length; i++) {
					// for���� ����� idNum �迭���� intIdNum �迭�� �ϳ��� �ѱ�� �� String���� Integer�� �� ��ȯ�� �ʿ��ϹǷ� �� ��ȯ ����
					// ���⼭ �������� �����ϰ�, ���ڰ� �Էµ��� ������ �� ��ȯ �������� NumberFormatException ���ܰ� ����Ƿ� �� ���� 
					// �Ʒ� catch�� �ִ�  ������ ���
					if (i < 6) intIdNum[i] = Integer.parseInt(idNum[i]);
					else if (i == 6) continue; 	// idNum[6]�� �������̱� ������ i�� 6�� ����  skip
					// idNum �������� i=6 �϶� skip�����Ƿ�  intIdNum�� �ε����� �ϳ� ���ҽ�Ŵ(i-1)
					else intIdNum[i-1] = Integer.parseInt(idNum[i]);
				}
			} catch (ArrayIndexOutOfBoundsException e) { // ������ ���� 14�ڸ� ���� �۰ų� ũ�� �Է¹޴� ����� ���� ó��
				System.out.println("�ֹι�ȣ�� OOOOOO-OOOOOOO ������ ���� 14�ڸ��Դϴ�.\n");
				unNormalInput++; // ������ �Է� �Ǽ� + 1
				isOk = false; // ���� �Է� X
				continue; // �Ʒ� �������� �ʰ� �ٷ� ���ǹ����� 
			} catch (NumberFormatException e) {
				System.out.println("-�� �����ϰ� ��� 0 ~ 9 �����̾���մϴ�.\n");
				unNormalInput++; // ������ �Է� �Ǽ� + 1
				isOk = false; // ���� �Է� X
				continue; // �Ʒ� �������� �ʰ� �ٷ� ���ǹ����� 
			}
			if(strIdNum.length() != 14) { // ��� �ɷ����� ���������� �Է��� ���� ���� 14�� �ƴ� ��� �Ʒ� ���� ���
				System.out.println("�ֹι�ȣ�� OOOOOO-OOOOOOO ������ ���� 14�ڸ��Դϴ�.\n");
				unNormalInput++; // ������ �Է� �Ǽ� + 1
				isOk = false; // ���� �Է� X
				continue; // �Ʒ� �������� �ʰ� �ٷ� ���ǹ����� 
			}
						
			if(isOk) {
				// �Է��� �ùٸ��ٸ� 
				// �ֹι�ȣ üũ
				// ������ ��Ÿ���� for�� : ������ �ڸ��� ������ ������ �ڸ����鿡 ���� ���� ����
				int checkNum = 0;
				int check = 2;
				// ���� ��� 9909099123459 �Է� ��
				// 2*9 + 3*9 + 4*0 + 5*9 + 6*0 + 7*9 + 8*9 + 9*1 + 2*2 + 3*3 + 4*4 + 5*5 .. �ϴ� ����
				for(int i=0; i<intIdNum.length-1; i++) {
					if(i == 8) check = 2;
					checkNum += check * intIdNum[i];
					check++;
				}
				// ���� ��ȣ
				int verify = 11 - checkNum % 11;
				// �ֹι�ȣ 13��°(������) ���� ���� ������ȣ�� ������ �ùٸ� �ֹι�ȣ
				if(verify == intIdNum[intIdNum.length-1]) {
					normalIdNum++; // ���� �ֹι�ȣ �Ǽ� + 1
					System.out.println("[���� ����] �������� �ֹι�ȣ�̸� ������ �����ϴ�!\n");
				}
				else {
					errorIdNum++; // ���� �ֹι�ȣ �Ǽ� + 1
					System.out.println("[���� ����] �ֹ� ��ȣ ��ġ���� ������ �ֽ��ϴ�!\n");
				}
			}
		}
		
		// ���� ��� ���
		int total = unNormalInput + normalIdNum + errorIdNum; // �� �Է� �Ǽ�
		System.out.println("-----------------------------------------------\n* ���� ���");
		System.out.println("- �� �Է� �Ǽ� : " + total + "��");
		System.out.println("- ���� �ֹι�ȣ  : " + normalIdNum + "�� (" + String.format("%.2f", (float)normalIdNum/total*100) + "%)");
		System.out.println("- ���� �ֹι�ȣ  : " + errorIdNum + "�� (" + String.format("%.2f", (float)errorIdNum/total*100) + "%)");
		System.out.println("- ������ �Է� : " + unNormalInput + "�� (" + String.format("%.2f", (float)unNormalInput/total*100) + "%)");
		System.out.println("===============================================");		

	}
}









