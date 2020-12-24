// Runtime 클래스 실습
public class RuntimeEx {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		long fm = rt.freeMemory();
		System.out.println("free Memory : " + fm/1024 + "KB");

		long tm = rt.totalMemory();
		System.out.println("total Memory : " + tm/1024 + "KB");
		try {
			rt.exec("C:\\windows\\system32\\calc.exe"); // 외부 프로그램 실행 : 계산기 실행
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}