package lee.java.exam13;
import java.awt.FileDialog;
import java.awt.Frame;

// AWT - FileDialog
public class FileDialogEx extends Frame {
	// [멤버]
	FileDialog fileDialog = new FileDialog(this, "저장하기 테스트", FileDialog.SAVE);
	
	// [생성자]
	public FileDialogEx() {
		super("FileDialogEx");
		setSize(200,300);
		setVisible(true);
		fileDialog.setVisible(true);
		
		System.out.println(fileDialog.getFile());
		System.out.println(fileDialog.getDirectory());
	}
	
	// [메서드]
	public static void main(String[] args) {
		FileDialogEx fileDialogEx = new FileDialogEx();
	}
}
