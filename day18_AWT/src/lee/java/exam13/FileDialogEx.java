package lee.java.exam13;
import java.awt.FileDialog;
import java.awt.Frame;

// AWT - FileDialog
public class FileDialogEx extends Frame {
	// [���]
	FileDialog fileDialog = new FileDialog(this, "�����ϱ� �׽�Ʈ", FileDialog.SAVE);
	
	// [������]
	public FileDialogEx() {
		super("FileDialogEx");
		setSize(200,300);
		setVisible(true);
		fileDialog.setVisible(true);
		
		System.out.println(fileDialog.getFile());
		System.out.println(fileDialog.getDirectory());
	}
	
	// [�޼���]
	public static void main(String[] args) {
		FileDialogEx fileDialogEx = new FileDialogEx();
	}
}
