package lee.java.test02;
import java.io.*;

public class IdNumberCheck {
	public static void main(String[] ar) throws IOException {

		int unNormalInput = 0; // 비정상 입력 건수
		int normalIdNum = 0; // 정상 주민번호 건수
		int errorIdNum = 0; // 오류 주민번호 건수
		
		System.out.println("===============================================\n" 
				+ "미래크립토 주민번호 검증 및 집계 프로그램\n\t- 홍길동\n"
				+ "===============================================");
		System.out.println("* 주민번호 입력 (OOOOOO-OOOOOOO 하이픈 포함 14자리, exit 입력시 종료)");

		while(true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			boolean isOk = true; // 정상 입력 여부
			String[] idNum = new String[14];; // 주민번호 저장할 배열 : 하이픈 포함 총 14자리
			int[] intIdNum = new int[13]; // 하이픈을 제외한 주민번호만 담은 배열 : 총 13자리
			
			// 입력 받기
			System.out.print(">> 데이터 입력 : ");
			String strIdNum = br.readLine();
			// exit를 입력받으면 종료, while문 break
			if (strIdNum.equals("exit")) {
				break;
			} 
			// br.readLine()으로 받은 문자열을 숫자와 하이픈 구별을 위해 문자 배열로 쪼갠다(split함수 사용)
			idNum = strIdNum.split("");

			// 배열을 사용하기 때문에 
			// 입력 값에 있어서 정해진 주민번호 형식보다 많은 자리 수를 입력하거나(ArrayIndexOutOfBoundsException)
			// -을 제외한 숫자 이외의 특수문자를 입력하게 되는 것(NumberFormatException)은 예외 처리
			try {
				// 숫자와 하이픈 구별을 위해 하이픈을 제외한 숫자(주민번호)만을 저장하기 위한 배열 intIdNum
				for (int i = 0; i < idNum.length; i++) {
					// for문을 사용해 idNum 배열에서 intIdNum 배열로 하나씩 넘기는 때 String에서 Integer로 형 변환이 필요하므로 형 변환 진행
					// 여기서 하이픈을 제외하고, 숫자가 입력되지 않으면 형 변환 과정에서 NumberFormatException 예외가 생기므로 그 때는 
					// 아래 catch에 있는  문구를 출력
					if (i < 6) intIdNum[i] = Integer.parseInt(idNum[i]);
					else if (i == 6) continue; 	// idNum[6]이 하이픈이기 때문에 i가 6일 때는  skip
					// idNum 기준으로 i=6 일때 skip했으므로  intIdNum의 인덱스를 하나 감소시킴(i-1)
					else intIdNum[i-1] = Integer.parseInt(idNum[i]);
				}
			} catch (ArrayIndexOutOfBoundsException e) { // 하이픈 포함 14자리 보다 작거나 크게 입력받는 경우의 예외 처리
				System.out.println("주민번호는 OOOOOO-OOOOOOO 하이픈 포함 14자리입니다.\n");
				unNormalInput++; // 비정상 입력 건수 + 1
				isOk = false; // 정상 입력 X
				continue; // 아래 수행하지 않고 바로 조건문으로 
			} catch (NumberFormatException e) {
				System.out.println("-을 제외하고 모두 0 ~ 9 숫자이어야합니다.\n");
				unNormalInput++; // 비정상 입력 건수 + 1
				isOk = false; // 정상 입력 X
				continue; // 아래 수행하지 않고 바로 조건문으로 
			}
			if(strIdNum.length() != 14) { // 모두 걸러내고 마지막으로 입력한 문자 수가 14가 아닌 경우 아래 문구 출력
				System.out.println("주민번호는 OOOOOO-OOOOOOO 하이픈 포함 14자리입니다.\n");
				unNormalInput++; // 비정상 입력 건수 + 1
				isOk = false; // 정상 입력 X
				continue; // 아래 수행하지 않고 바로 조건문으로 
			}
						
			if(isOk) {
				// 입력이 올바르다면 
				// 주민번호 체크
				// 공식을 나타내는 for문 : 마지막 자리를 제외한 나머지 자릿수들에 대한 연산 적용
				int checkNum = 0;
				int check = 2;
				// 예를 들어 9909099123459 입력 시
				// 2*9 + 3*9 + 4*0 + 5*9 + 6*0 + 7*9 + 8*9 + 9*1 + 2*2 + 3*3 + 4*4 + 5*5 .. 하는 과정
				for(int i=0; i<intIdNum.length-1; i++) {
					if(i == 8) check = 2;
					checkNum += check * intIdNum[i];
					check++;
				}
				// 검증 번호
				int verify = 11 - checkNum % 11;
				// 주민번호 13번째(마지막) 값이 오류 검증번호와 같으면 올바른 주민번호
				if(verify == intIdNum[intIdNum.length-1]) {
					normalIdNum++; // 정상 주민번호 건수 + 1
					System.out.println("[검증 성공] 정상적인 주민번호이며 오류가 없습니다!\n");
				}
				else {
					errorIdNum++; // 오류 주민번호 건수 + 1
					System.out.println("[검증 실패] 주민 번호 수치상의 오류가 있습니다!\n");
				}
			}
		}
		
		// 최종 결과 출력
		int total = unNormalInput + normalIdNum + errorIdNum; // 총 입력 건수
		System.out.println("-----------------------------------------------\n* 최종 결과");
		System.out.println("- 총 입력 건수 : " + total + "건");
		System.out.println("- 정상 주민번호  : " + normalIdNum + "건 (" + String.format("%.2f", (float)normalIdNum/total*100) + "%)");
		System.out.println("- 오류 주민번호  : " + errorIdNum + "건 (" + String.format("%.2f", (float)errorIdNum/total*100) + "%)");
		System.out.println("- 비정상 입력 : " + unNormalInput + "건 (" + String.format("%.2f", (float)unNormalInput/total*100) + "%)");
		System.out.println("===============================================");		

	}
}









