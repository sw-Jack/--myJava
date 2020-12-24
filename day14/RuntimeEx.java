// Runtime Ŭ���� �ǽ�
public class RuntimeEx {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		long fm = rt.freeMemory();
		System.out.println("free Memory : " + fm/1024 + "KB");

		long tm = rt.totalMemory();
		System.out.println("total Memory : " + tm/1024 + "KB");
		try {
			rt.exec("C:\\windows\\system32\\calc.exe"); // �ܺ� ���α׷� ���� : ���� ����
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}