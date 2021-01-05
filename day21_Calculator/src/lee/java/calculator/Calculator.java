package lee.java.calculator;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// <���� on Windows>
public class Calculator extends Frame implements ActionListener {
   private static final long serialVersionUID = 1L;
   
   // [���]
   private String[] strNum = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "+/-", "."};
   private Button[] btNum = new Button[strNum.length];
   private String[] strFunc = {"BackSpace", "CE", "C"};
   private Button[] btFunc = new Button[strFunc.length];
   private String[] strOp = {"+", "-", "*", "/"};
   private Button[] btOp = new Button[strOp.length];
   private Button btEqual = new Button("=");
   private Label disp = new Label("0.", Label.RIGHT);
   
   private boolean isFirst = true; // true ÷�̴�. false ÷�� �ƴϴ�.
   private boolean dotClicked = false; // false �Ҽ����� ������ ����.  true �Ҽ����� ������.
   private char operator = '+';
   private double result = 0;
   
   // [������]
   public Calculator()  {
      super("����");
      buildGUI();
      setEvent();
   }

   // [�޼���]
   @Override
   public void actionPerformed(ActionEvent e) {
      for(int i=0; i<btNum.length-2; i++) {
         if(e.getSource() == btNum[i]) {
            if(isFirst) { // ó�� ���� ���
               if(disp.getText().equals("0.") && btNum[i].getLabel().equals("0")) return;
               disp.setText(btNum[i].getLabel() + ".");
               isFirst = false;
            }else { // ó�� ���� ���� �ƴ� ���
               String temp = disp.getText();
               if(dotClicked) { // ���� Ŭ���� �� �ִ� ���
                  disp.setText(temp + btNum[i].getLabel());
               }else { // ���� Ŭ���� ���� ���� ���
                  temp = temp.substring(0, temp.length()-1); // ������ ���� ���ڴ�.
                  disp.setText(temp + btNum[i].getLabel() + ".");
               }
            }
            return;
         }
      } //end btNum
      
      if(e.getSource() == btNum[btNum.length-2]) {// ��ȣ
         String temp = disp.getText();
         
         if(temp.equals("0.")) return;
         
         if(temp.charAt(0) == '-') {
            disp.setText(temp.substring(1));
         }else {
            disp.setText("-" + temp);
         }
         return;
      }
      
      if(e.getSource() == btNum[btNum.length-1]) { // �Ҽ���
         isFirst = false;
         dotClicked = true;
         return;
      }
      
      for(int i=0; i<btOp.length; i++) {// ������ ����
         if(e.getSource() == btOp[i]) {
            calc();
            operator = btOp[i].getLabel().charAt(0);
            isFirst = true;
            dotClicked = false;
            return;
         }
      }
      
      if(e.getSource() == btEqual) { // = ��ư
         calc();
         isFirst = true;
         dotClicked = false;
         operator = '+';
         result = 0;
         return;
      }
      
      if(e.getSource() == btFunc[0]) { // BackSpace
         String temp = disp.getText();
                  
         if(temp.length() == 2) { // 2. or 5.
            disp.setText("0.");
            isFirst = true;
            dotClicked = false;
            return;
         }
         
         if(temp.length() == 3 && temp.charAt(0) == '-') { // -4.
            disp.setText("0.");
            isFirst = true;
            dotClicked = false;
            return;
         }
         
         if(temp.length() == 3 && temp.charAt(0) == '0') { // 0.5
            disp.setText("0.");
            isFirst = true;
            dotClicked = false;
            return;
         }
         
         if(temp.charAt(temp.length()-1) == '.') {
            temp = temp.substring(0, temp.length()-2);
            disp.setText(temp + ".");
         }else {
            disp.setText(temp.substring(0, temp.length()-1));
         }
         return;
      }
      
      if(e.getSource() == btFunc[1]) { // CE
         disp.setText("0.");
         isFirst = true;
         dotClicked = false;
         return;
      }
      
      if(e.getSource() == btFunc[2]) { // C
         disp.setText("0.");
         isFirst = true;
         dotClicked = false;
         operator = '+';
         result = 0;
         return;
      }
   } // end Action
   
   // ���
   public void calc() {
      double value = Double.parseDouble(disp.getText());
      switch(operator) {
      case '+' : result = result + value; break;
      case '-' : result = result - value; break;
      case '*' : result = result * value; break;
      case '/' : result = result / value; break;
      }
      
      double val = result - (int)result;
      if(val > 0) {
         disp.setText(String.valueOf(result));
      }else {
         disp.setText(String.valueOf((int)result) + ".");
      }
   }
   
   // �̺�Ʈ
   public void setEvent() { 
      for(int i=0; i<btNum.length; i++)
         btNum[i].addActionListener(this);
      
      for(int i=0; i<btFunc.length; i++)
         btFunc[i].addActionListener(this);
      
      for(int i=0; i<btOp.length; i++) 
         btOp[i].addActionListener(this);
      
      btEqual.addActionListener(this);
      
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }
   
   // ȭ�鱸��
   public void buildGUI() { 
      setBackground(Color.cyan);
      add("North", new Label());
      add("South", new Label());
      add("West", new Label());
      add("East", new Label());
      Panel mainPanel = new Panel(new BorderLayout(15,15));
         disp.setBackground(Color.white);
         disp.setFont(new Font("Serif", Font.BOLD, 15));
         mainPanel.add("North", disp);
         
         Panel cPanel = new Panel(new GridLayout(1,2,3,3));
            Panel cleftPanel = new Panel(new GridLayout(4,3,3,3));
               for(int i=0; i<btNum.length; i++) {
                  btNum[i] = new Button(strNum[i]);
                  btNum[i].setFont(new Font("Serif", Font.BOLD, 15));
                  cleftPanel.add(btNum[i]);
               }
            cPanel.add(cleftPanel);
            
            Panel crightPanel = new Panel(new GridLayout(4,1,3,3));
               Panel cr1Panel = new Panel(new GridLayout(1,3,3,3));
                  for(int i=0; i<btFunc.length; i++) {
                     btFunc[i] = new Button(strFunc[i]);
                     btFunc[i].setFont(new Font("Serif", Font.BOLD, 15));
                     cr1Panel.add(btFunc[i]);
                  }
               crightPanel.add(cr1Panel);
               
               Panel cr2Panel = new Panel(new GridLayout(1,2,3,3));
               Panel cr3Panel = new Panel(new GridLayout(1,2,3,3));
                  for(int i=0; i<strOp.length; i++) {
                     btOp[i] = new Button(strOp[i]);
                     btOp[i].setFont(new Font("Serif", Font.BOLD, 15));
                     if(i<2) cr2Panel.add(btOp[i]);
                     else cr3Panel.add(btOp[i]);
                  }
               crightPanel.add(cr2Panel);
               crightPanel.add(cr3Panel);
               
               btEqual.setFont(new Font("Serif", Font.BOLD, 15));
               crightPanel.add(btEqual);
            cPanel.add(crightPanel);
         mainPanel.add("Center", cPanel);
      add("Center", mainPanel);
      
      pack();
      
      Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension my = getSize();
      setLocation(scr.width/2 - my.width/2, scr.height/2 - my.height/2);
      
      setResizable(false);
      setVisible(true);
   }
   
   // ����
   public static void main(String[] args) {
      new Calculator();
   }
}