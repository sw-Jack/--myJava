package lee.java.exam01;
import java.io.File;

public class FileEx1 {
	public static void main(String[] args) {
		                      // 파일 경로 입력 ↓
		File file = new File("[input file's full path]");
		System.out.println("파일 여부 : " + file.isFile());
		System.out.println("디렉토리 여부 : " + file.isDirectory());
		System.out.println("상대 경로 : " + file.getPath());
		System.out.println("절대 경로 : " + file.getAbsolutePath());
		System.out.println("디렉토리 혹은 파일의 이름 : " + file.getName());
		System.out.println("파일의 길이 : " + file.length());
		System.out.println("파일의 최종 수정 날짜 : " + file.lastModified());
	}
}
