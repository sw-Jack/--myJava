import java.awt.*;
import java.awt.event.*;
import java.applet.*;

// 계산기 Frame -> "Applet"
public class Calculator extends Applet//Frame ----1
                  implements ActionListener {

   private static final long serialVersionUID = 1L;
   
   //멤버필드
   private String[] sustr = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "+/-", "."};
   private Button[] subt = new Button[sustr.length];
   private String[] funstr = {"BackSpace", "CE", "C"};
   private Button[] funbt = new Button[funstr.length];
   private String[] operstr = {"+", "-", "*", "/"};
   private Button[] operbt = new Button[operstr.length];
   private Button equbt = new Button("=");
   private Label disp = new Label("0.", Label.RIGHT);
   
   private boolean first = true; // true 첨이다. false 첨이 아니다.
   private boolean jumcheck = false; // false 소수점을 누른적 없다.  true 소수점을 눌렀다.
   private char operator = '+';
   private double result = 0;
   
   //생성자
   
   public void init(){// Calculator()  { ----2 프레임때문에 나온것 삭제.
      // super("Calculator");
      buildGUI();
      
   }

   //메서드
   public void start(){//----3
      setEvent();
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      for(int i=0; i<subt.length-2; i++) {
         if(e.getSource() == subt[i]) {
            if(first) {// 처음으로 눌렀다
               if(disp.getText().equals("0.") && subt[i].getLabel().equals("0")) return;
               disp.setText(subt[i].getLabel() + ".");
               first = false;
            }else {// 처음 아니다.
               String imsi = disp.getText();
               if(jumcheck) {// 점을 누른적 있다.
                  disp.setText(imsi + subt[i].getLabel());
               }else {// 점을 누른적 없다.
                  imsi = imsi.substring(0, imsi.length()-1); // 마지막 점을 빼겠다.
                  disp.setText(imsi + subt[i].getLabel() + ".");
               }
            }
            return;
         }
      }//end subt
      
      if(e.getSource() == subt[subt.length-2]) {// 부호
         String imsi = disp.getText();
         
         if(imsi.equals("0.")) return;
         
         if(imsi.charAt(0) == '-') {
            disp.setText(imsi.substring(1));
         }else {
            disp.setText("-" + imsi);
         }
         return;
      }
      
      if(e.getSource() == subt[subt.length-1]) {// 소수점.
         first = false;
         jumcheck = true;
         return;
      }
      
      for(int i=0; i<operbt.length; i++) {// 연산자 누름.  
         if(e.getSource() == operbt[i]) {
            calc();
            operator = operbt[i].getLabel().charAt(0);
            first = true;
            jumcheck = false;
            return;
         }
      }
      
      if(e.getSource() == equbt) {// = 버튼
         calc();
         first = true;
         jumcheck = false;
         operator = '+';
         result = 0;
         return;
      }
      
      if(e.getSource() == funbt[0]) {// BackSpace
         String imsi = disp.getText();
                  
         if(imsi.length() == 2) { // 2. or 5.
            disp.setText("0.");
            first = true;
            jumcheck = false;
            return;
         }
         
         if(imsi.length() == 3 && imsi.charAt(0) == '-') {// -4.
            disp.setText("0.");
            first = true;
            jumcheck = false;
            return;
         }
         
         if(imsi.length() == 3 && imsi.charAt(0) == '0') {// 0.5
            disp.setText("0.");
            first = true;
            jumcheck = false;
            return;
         }
         
         if(imsi.charAt(imsi.length()-1) == '.') {
            imsi = imsi.substring(0, imsi.length()-2);
            disp.setText(imsi + ".");
         }else {
            disp.setText(imsi.substring(0, imsi.length()-1));
         }
         return;
      }
      
      if(e.getSource() == funbt[1]) {// CE
         disp.setText("0.");
         first = true;
         jumcheck = false;
         return;
      }
      
      if(e.getSource() == funbt[2]) {// C
         disp.setText("0.");
         first = true;
         jumcheck = false;
         operator = '+';
         result = 0;
         return;
      }
   }// end Action
   
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
   
   public void setEvent() {// 이벤트 연결
      for(int i=0; i<subt.length; i++)
         subt[i].addActionListener(this);
      
      for(int i=0; i<funbt.length; i++)
         funbt[i].addActionListener(this);
      
      for(int i=0; i<operbt.length; i++) 
         operbt[i].addActionListener(this);
      
      equbt.addActionListener(this);
      
      /*addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });*/
   }
   
   public void buildGUI() {//화면구성
      setBackground(Color.cyan);
      add("North", new Label());
      add("South", new Label());
      add("West", new Label());
      add("East", new Label());
      Panel mainPanel = new Panel(new BorderLayout(3,3));
         disp.setBackground(Color.white);
         disp.setFont(new Font("Serif", Font.BOLD, 15));
         mainPanel.add("North", disp);
         
         Panel cPanel = new Panel(new GridLayout(1,2,3,3));
            Panel cleftPanel = new Panel(new GridLayout(4,3,3,3));
               for(int i=0; i<subt.length; i++) {
                  subt[i] = new Button(sustr[i]);
                  subt[i].setFont(new Font("Serif", Font.BOLD, 15));
                  cleftPanel.add(subt[i]);
               }
            cPanel.add(cleftPanel);
            
            Panel crightPanel = new Panel(new GridLayout(4,1,3,3));
               Panel cr1Panel = new Panel(new GridLayout(1,3,3,3));
                  for(int i=0; i<funbt.length; i++) {
                     funbt[i] = new Button(funstr[i]);
                     funbt[i].setFont(new Font("Serif", Font.BOLD, 15));
                     cr1Panel.add(funbt[i]);
                  }
               crightPanel.add(cr1Panel);
               
               Panel cr2Panel = new Panel(new GridLayout(1,2,3,3));
               Panel cr3Panel = new Panel(new GridLayout(1,2,3,3));
                  for(int i=0; i<operstr.length; i++) {
                     operbt[i] = new Button(operstr[i]);
                     operbt[i].setFont(new Font("Serif", Font.BOLD, 15));
                     if(i<2) cr2Panel.add(operbt[i]);
                     else cr3Panel.add(operbt[i]);
                  }
               crightPanel.add(cr2Panel);
               crightPanel.add(cr3Panel);
               
               equbt.setFont(new Font("Serif", Font.BOLD, 15));
               crightPanel.add(equbt);
            cPanel.add(crightPanel);
         mainPanel.add("Center", cPanel);
      add("Center", mainPanel);
      
      //pack();
      
      //Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
      //Dimension my = getSize();
      //setLocation(scr.width/2 - my.width/2, scr.height/2 - my.height/2);
      
      //setResizable(false);
      //setVisible(true);
   }
   
   /*public static void main(String[] args) { ---- 4
      new Calculator();
   }*/
}