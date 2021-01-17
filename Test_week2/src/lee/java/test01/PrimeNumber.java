package lee.java.test01;
import java.util.Random;

public class PrimeNumber {
	public static void main(String[] args) {
		int count = 100; // 난수 생성 개수 
		int arr[] = new int[count]; // 난수 저장할 배
		int minRandNum = 1; // 냔수 범위의 최소값 : 변수로 둔 이유 -> 최대 소수를 쉽게 구하기 위함
		int maxRandNum = 1000; // 냔수 범위의 최대값 : 변수로 둔 이유 -> 최소 소수를 쉽게 구하기 위함
		Random random = new Random();
		
		// 중복 없는 난수 생성
		for(int i=0; i<count; i++) {
			arr[i] = random.nextInt(maxRandNum) + minRandNum; // 난수 범위 : 1 ~ 1000
			for(int j=0; j<i; j++) { // i번째 값을 0~(i-1)번째 값들과 비교해 
				if(arr[i] == arr[j]) // 같다면 
					i--;// 인덱스 뒤로, 즉 다시 난수 재생성
			}
		}
		
		System.out.println("===========================\n"
					+ "미래크립토 소수 판단 프로그램\n\t- 홍길동\n" 
					+ "===========================");
		
		int primeNumCnt = 0; // 출력된 소수 개수
		int maxPrimeNum = minRandNum; // 최대 소수 -> 초기값은 발생 난수 범위의 최소값으로 설정
		int minPrimeNum = maxRandNum; // 최소 소수 -> 초기값은 발생 난수 범위의 최대값으로 설정
		// 생성된 난수 100개 중에서 소수 출력하기
		for(int i=0; i<count; i++) {
			int divisorCnt = 0; // 약수의 개수 초기화
			for(int j=arr[i]; j>=1; j--) {
				// 1부터 자기자신까지 나눠보았을 때 나머지가 0인 경우, 즉 약수일 때, 약수 개수 +1
				if(arr[i]%j == 0) divisorCnt++; 
			}
			if(divisorCnt == 2) { // 약수의 개수가 2개(1과 자신)이면 소수로 판단
				System.out.println("소수 발견 : " + arr[i]); // 해당 소수 출력
				primeNumCnt++; // 소수 개수 +1
				// 뽑은 소수가 max 값보다 크면 해당 소수를 max값으로 설정
				if(arr[i] > maxPrimeNum) maxPrimeNum = arr[i]; 
				// 뽑은 소수가 min 값보다 작으면 해당 소수를 min값으로 설정
				if(arr[i] < minPrimeNum) minPrimeNum = arr[i];
			}
		}
		// 최종 결과 출력
		System.out.println("---------------------------\n최종 결과 :");
		System.out.println("소수 개수 : " + primeNumCnt);
		System.out.println("최소 소수 : " + minPrimeNum);
		System.out.println("최대 소수 : " + maxPrimeNum);
		System.out.println("===========================");
	}
}


