public class WriteEx {
	public static void main(String[] args) {
		// write(int), write(byte[]), write(byte[], start, length)
		System.out.write(65); // 대문자 A, 1byte

		// 자바에서 버퍼란 8KByte짜리 버퍼!
		// 8KByte = 8 * 1024 Byte
		System.out.flush(); // 버퍼에 있는 것을 '싹다' 출력해라. 
		System.out.println(); 

		// 바이트 배열 사용의 경우에는 오토 플러시 기능이 있다.
		byte [] by = {'J', 'A', 'V', 'A'};
		System.out.write(by, 0, 4);
		System.out.println();
	}
}
