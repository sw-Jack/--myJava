// System Ŭ���� �ǽ�
public class SystemEx {
	public static void main(String[] args) {
		long startLoopTime = System.currentTimeMillis();
		for(int i=0; i<1000000; i++) {
			for(int j=0; j<100; j++) {
				int k = i * j;
			}
		}
		
		long endLoopTime = System.currentTimeMillis() - startLoopTime;
		System.out.println("�ҿ�ð� : " + endLoopTime + "msec");

		byte buffer[] = new byte[255];
		System.out.println("\nType a line of text");
		try {
			System.in.read(buffer, 0, 255);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		System.out.println(new String(buffer)); // byte[] --> String
	}
}
