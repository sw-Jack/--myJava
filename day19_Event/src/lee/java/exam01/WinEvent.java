package lee.java.exam01;
import java.awt.*;
import java.awt.event.*;

public class WinEvent extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
