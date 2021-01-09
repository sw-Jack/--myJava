package lee.java.exam09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComboBoxEx extends JFrame {
	private static final long serialVersionUID = 1L;

	public JComboBoxEx() {
		super("JComboBox Å×½ºÆ®");
		setLayout(new FlowLayout());
		String[] citems = {"One", "Two", "Three", "Four", "Five"};
		JComboBox<String> combo = new JComboBox<String>(citems);
		add(combo);
		DefaultComboBoxModel cmodel = new DefaultComboBoxModel();
		cmodel.addElement("Chicken");
		cmodel.addElement("Potato");
		combo = new JComboBox();
		combo.setModel(cmodel);
		DefaultComboBoxModel cxmodel = (DefaultComboBoxModel)combo.getModel();
		cxmodel.addElement("Coke");
		cxmodel.addElement("Coffee");
		cxmodel.addElement("Juice");
		add(combo);
		setBounds(300, 200, 300, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JComboBoxEx();
	}
}
