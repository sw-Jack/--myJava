package lee.java.controller;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import lee.java.vo.Customer;

public class CustomerManager extends Frame implements ActionListener, KeyListener, ItemListener{
   
   //멤버필드
   //--------------------------------------------------------------------메인화면
   private static final long serialVersionUID = 1L;
   
   private TextField nametf = new TextField(20);
   
   private TextField jumin1tf = new TextField(7);
   private TextField jumin2tf = new TextField(8);
   
   private Choice telch = new Choice();
   private String[] tstr = {"010", "011", "016", "017", "018", "019"};
   private TextField tel1tf = new TextField(4);
   private TextField tel2tf = new TextField(4);
   
   private CheckboxGroup cg = new CheckboxGroup();
   private Checkbox man = new Checkbox("남성", cg, true);
   private Checkbox woman = new Checkbox("여성", false, cg);
   
   private String[] hstr = {"독서", "영화", "음악", "게임", "쇼핑"};
   private Checkbox[] hobby = new Checkbox[hstr.length];
   
   private Button addbt = new Button("등록");
   private Button dispbt = new Button("분석");
   private Button updatebt = new Button("수정");
   private Button delbt = new Button("삭제");
   private Button initbt = new Button("입력모드");
   
   private List listli = new List();
   
   private TextArea infota = new TextArea();
   
   //-------------------------------------------------------------------------- 메뉴
   private MenuBar mb = new MenuBar();
   
   private Menu mfile = new Menu("File");
      private MenuItem mfnew = new MenuItem("새파일");
      private MenuItem mfopen = new MenuItem("불러오기");
      private MenuItem mfsave = new MenuItem("저장하기");
      private MenuItem mfsaveas = new MenuItem("새이름으로저장하기");
      private MenuItem mfexit = new MenuItem("종료");
   private Menu mhelp = new Menu("Help");
      private MenuItem mhver = new MenuItem("버전정보");
   
   //--------------------------------------------------------------------------- 다이알로그
   private Dialog dialog = new Dialog(this, "버전정보", true);
   
   private Label dlabel = new Label("CustomerManager V1.0", Label.CENTER);
   private Button dbt = new Button("확인");
   
   //---------------------------------------------------------------------------- 구성요소
   private ArrayList<Customer> data = new ArrayList<Customer>();
   private File myfile = null;
   private FileDialog fildDialog = null;
      
   //생성자
   public CustomerManager() {
      super("고객관리프로그램");
      setMenu();
      setDialog();
      setEvent();
      buildGUI();
   }

   //메서드
   private void setButton(boolean state) { // 버튼 설정
      addbt.setEnabled(state);
      dispbt.setEnabled(!state);
      updatebt.setEnabled(!state);
      delbt.setEnabled(!state);
      initbt.setEnabled(!state);
   }
   
   public void clrscr() {// 화면 초기화
      nametf.setText("");
      jumin1tf.setText("");
      jumin2tf.setText("");
      telch.select(0);
      tel1tf.setText("");
      tel2tf.setText("");
      man.setState(true);
      for(int i=0; i<hobby.length; i++)
         hobby[i].setState(false);
      infota.setText("");
      nametf.requestFocus();
   }
   
   public void setForm(boolean state) {
      nametf.setEditable(state);
      jumin1tf.setEditable(state);
      jumin2tf.setEditable(state);
      man.setEnabled(state);
      woman.setEnabled(state);
   }
   
   public void setEvent() {
      mfsaveas.addActionListener(this);
      mfsave.addActionListener(this);
      mfopen.addActionListener(this);
      mfnew.addActionListener(this);
      dbt.addActionListener(this);
      mfexit.addActionListener(this);
      mhver.addActionListener(this);
      initbt.addActionListener(this);
      delbt.addActionListener(this);
      updatebt.addActionListener(this);
      dispbt.addActionListener(this);
      listli.addItemListener(this);
      addbt.addActionListener(this);
      tel1tf.addActionListener(this);
      telch.addItemListener(this);
      jumin2tf.addKeyListener(this);
      jumin1tf.addKeyListener(this);
      nametf.addActionListener(this);
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == nametf) {
         jumin1tf.requestFocus();
         return;
      }
      if(e.getSource() == tel1tf) {
         tel2tf.requestFocus();
         return;
      }
      if(e.getSource() == addbt) {//등록버튼 
         String name = nametf.getText().trim();
         if(name == null || name.length() == 0) {
            infota.setText("\n\t이름은 반드시 입력하셔야 합니다.");
            nametf.setText("");
            nametf.requestFocus();
            return;
         }
         
         StringBuffer jumin = new StringBuffer(jumin1tf.getText());
         jumin.append("-");   jumin.append(jumin2tf.getText());
         if(jumin1tf.getText().trim().length() != 6 || jumin2tf.getText().trim().length() != 7) {
            infota.setText("\n\t주민번호는 앞 6자리 뒷 7자리로 구성됩니다.");
            jumin1tf.setText("");
            jumin2tf.setText("");
            jumin1tf.requestFocus();
            return;
         }
         
         StringBuffer tel = new StringBuffer(telch.getSelectedItem());
         tel.append("-");   tel.append(tel1tf.getText());
         tel.append("-");   tel.append(tel2tf.getText());
         if(tel1tf.getText().trim().length() == 0 || tel2tf.getText().trim().length() == 0) {
            infota.setText("\n\t전화번호는 반드시 입력 하셔야 합니다.");
            tel1tf.setText("");
            tel2tf.setText("");
            tel1tf.requestFocus();
            return;
         }
         
         boolean gender = man.getState();
         
         StringBuffer myHobby = new StringBuffer();
         for(int i=0; i<hobby.length; i++) {
            if(hobby[i].getState()) {
               myHobby.append(hobby[i].getLabel());
               myHobby.append("-");
            }
         }
         if(myHobby.length() == 0) {//하나도 취미를 체크하지 않았다.
            myHobby.append("없음");
         }else {// 하나이상 체크했다.
            // myHobby.delete(myHobby.length()-1, myHobby.length());
            myHobby.deleteCharAt(myHobby.length()-1);
         }
         
         Customer myCustomer = new Customer(name, jumin.toString(), tel.toString(), gender, myHobby.toString());
         
         infota.setText("\n\t성공적으로 등록 되었습니다.");
         data.add(myCustomer);
         listli.add(myCustomer.toString());
         
         try {
            Thread.sleep(500); // 프로그램을 0.5간 멈춘다.
         }catch(InterruptedException ir) { }
         
         clrscr();//화면지우기
      }//end 등록
      if(e.getSource() == dispbt) { // 분석버튼
         // 주민번호 검증을 수행해서 infota에다가 정보를 출력해 줍니다.
      }
      if(e.getSource() == updatebt) {//수정버튼
         
         Customer myCustomer = data.get(listli.getSelectedIndex());
         
         StringBuffer tel = new StringBuffer(telch.getSelectedItem());
         tel.append("-");   tel.append(tel1tf.getText());
         tel.append("-");   tel.append(tel2tf.getText());
         if(tel1tf.getText().trim().length() == 0 || tel2tf.getText().trim().length() == 0) {
            infota.setText("\n\t전화번호는 반드시 입력 하셔야 합니다.");
            tel1tf.setText("");
            tel2tf.setText("");
            tel1tf.requestFocus();
            return;
         }
         
         StringBuffer myHobby = new StringBuffer();
         for(int i=0; i<hobby.length; i++) {
            if(hobby[i].getState()) {
               myHobby.append(hobby[i].getLabel());
               myHobby.append("-");
            }
         }
         if(myHobby.length() == 0) {//하나도 취미를 체크하지 않았다.
            myHobby.append("없음");
         }else {// 하나이상 체크했다.
            // myHobby.delete(myHobby.length()-1, myHobby.length());
            myHobby.deleteCharAt(myHobby.length()-1);
         }
         
         infota.setText("\n\t성공적으로 수정되었습니다.");
         myCustomer.setPhone(tel.toString());
         myCustomer.setHobby(myHobby.toString());
         
         try {
            Thread.sleep(500); // 프로그램을 0.5간 멈춘다.
         }catch(InterruptedException ir) { }
         
         setButton(true);
         setForm(true);
         clrscr();
         return;
      }//end 수정
      if(e.getSource() == delbt) {//삭제버튼
         int index = listli.getSelectedIndex();
         
         infota.setText("\n\t성공적으로 삭제 되었습니다.");
         
         listli.remove(index);
         data.remove(index);
         
         try {
            Thread.sleep(500); // 프로그램을 0.5간 멈춘다.
         }catch(InterruptedException ir) { }
         
         setForm(true);
         setButton(true);
         clrscr();
         return;
      }//end 삭제
      if(e.getSource() == initbt) {//입력모드
         setForm(true);
         setButton(true);
         clrscr();
         return;
      }//end 입력모드
      if(e.getSource() == mhver) {//버전정보
         Point pt = getLocation();
         Dimension my = getSize();
         Dimension dsize = dialog.getSize();
         
         dialog.setLocation((int)pt.getX() + my.width/2-dsize.width/2, (int)pt.getY() + my.height/2-dsize.height/2);
         dialog.setVisible(true);
      }//end 버전정보
      if(e.getSource() == mfexit) {//종료메뉴
         System.exit(0);
      }//end 종료메뉴
      if(e.getSource() == dbt) {//다이알로그 안에 버튼
         dialog.setVisible(false);
      }
      if(e.getSource() == mfnew) {//새파일
         listli.removeAll();
         data.clear();
         myfile = null;
         setButton(true);
         setForm(true);
         clrscr();
      }//end 새파일
      if(e.getSource() == mfopen) {//불러오기
         fildDialog = new FileDialog(this, "불러오기", FileDialog.LOAD);
         fildDialog.setVisible(true);
         String fileName = fildDialog.getFile();
         String directory = fildDialog.getDirectory();
         if(fileName == null || directory == null) {
            return;
         }
         myfile = new File(directory, fileName);
         dataLoad();
      }//end 불러오기
      if(e.getSource() == mfsave) {//저장하기
         if(myfile == null) {
            fildDialog = new FileDialog(this, "새 이름으로 저장하기", FileDialog.SAVE);
            fildDialog.setVisible(true);
            String fileName = fildDialog.getFile();
            String directory = fildDialog.getDirectory();         
            if(fileName == null || directory == null) {
               return;
            }
            myfile = new File(directory, fileName);
         }
         dataSave();
         // saveData();
      }//end 저장하기
      if(e.getSource() == mfsaveas) {//새이름으로 저장하기
         fildDialog = new FileDialog(this, "새 이름으로 저장하기", FileDialog.SAVE);
         fildDialog.setVisible(true);
         String fileName = fildDialog.getFile();
         String directory = fildDialog.getDirectory();
         if(fileName == null || directory == null) {
            return;
         }
         myfile = new File(directory, fileName);
         dataSave();
      }//end 새이름으로 저장하기
   }

   
   public void dataLoad() {
      FileReader fr = null;
      BufferedReader br = null;
      
      listli.removeAll();
      data.clear();
      
      try {
         fr = new FileReader(myfile);
         br = new BufferedReader(fr);
         
         String readData = "";
         while((readData = br.readLine()) != null) {
            String[] mydata = readData.split("/");
            boolean gender = false;
            if(mydata[3].equals("남성")) gender = true;
            Customer myCustomer = new Customer(mydata[0], mydata[1], mydata[2], gender, mydata[4]);
            listli.add(myCustomer.toString());
            data.add(myCustomer);
         }
         infota.setText("\n\t성공적으로 데이터를 로딩하였습니다.");
      }catch(FileNotFoundException fnfe) {
         System.err.println(myfile.getName() + " 파일을 찾을 수 없습니다.");
      }catch(IOException ioe) {
         ioe.printStackTrace();
      }finally {
         try { if(br != null) br.close(); }catch(IOException ioe) { }
         try { if(fr != null) fr.close(); }catch(IOException ioe) { }
      }
      
      try {
         Thread.sleep(500); // 프로그램을 0.5간 멈춘다.
      }catch(InterruptedException ir) { }
      
      setForm(true);
      setButton(true);
      clrscr();
   }
   
   public void dataSave() {
      FileWriter fw = null;
      BufferedWriter bw = null;
      PrintWriter pw = null;
      
      try {
         fw = new FileWriter(myfile);
         bw = new BufferedWriter(fw);
         pw = new PrintWriter(bw, true);
         
         for(int i=0; i<data.size(); i++) {
            Customer myCustomer = data.get(i);
            StringBuffer sb = new StringBuffer(myCustomer.getName());
            sb.append("/");
            sb.append(myCustomer.getIdNum()); sb.append("/");
            sb.append(myCustomer.getPhone()); sb.append("/");
            sb.append(myCustomer.isSex() ? "남성" : "여성"); sb.append("/");
            sb.append(myCustomer.getHobby());
            pw.println(sb.toString());
         }
         infota.setText("\n\t성공적으로 저장되었습니다");
      }catch(FileNotFoundException fnfe) {
         System.err.println(myfile.getName() + " 파일을 찾을 수 없습니다.");
      }catch(IOException ioe) {
         ioe.printStackTrace();
      }finally {
         if(pw != null) pw.close();
         try { if(bw != null) bw.close(); }catch(IOException ioe) { }
         try { if(fw != null) fw.close(); }catch(IOException ioe) { }
      }
      
      try {
         Thread.sleep(500); // 프로그램을 0.5간 멈춘다.
      }catch(InterruptedException ir) { }
      
      setButton(true);
      setForm(true);
      clrscr();
   }
   
   
   @Override
   public void itemStateChanged(ItemEvent e) {
      if(e.getSource() == telch) {
         tel1tf.requestFocus();
         return;
      }
      if(e.getSource() == listli) {//목록에서 선택
         int index = listli.getSelectedIndex();
         
         Customer myCustomer = data.get(index);
         
         nametf.setText(myCustomer.getName());
         jumin1tf.setText(myCustomer.getIdNum().split("-")[0]);
         jumin2tf.setText(myCustomer.getIdNum().split("-")[1]);
         telch.select(myCustomer.getPhone().split("-")[0]);
         tel1tf.setText(myCustomer.getPhone().split("-")[1]);
         tel2tf.setText(myCustomer.getPhone().split("-")[2]);
         man.setState(myCustomer.isSex());
         
         for(int i=0; i<hobby.length; i++)
            hobby[i].setState(false);
         
         String[] myHobby = myCustomer.getHobby().split("-");
         for(int i=0; i<myHobby.length; i++) {
            for(int j=0; j<hobby.length; j++) {
               if(myHobby[i].equals(hobby[j].getLabel())) {
                  hobby[j].setState(true);
                  break;
               }
            }
         }
         
         setForm(false);
         setButton(false);
         telch.requestFocus();
      }
   }
   
   @Override
   public void keyTyped(KeyEvent e) {
      
   }

   @Override
   public void keyPressed(KeyEvent e) {
      
   }

   @Override
   public void keyReleased(KeyEvent e) {
      if(e.getSource() == jumin1tf) {
         if(jumin1tf.getText().trim().length() == 6) {
            jumin2tf.requestFocus();
            return;
         }
      }
      if(e.getSource() == jumin2tf) {
         if(jumin2tf.getText().trim().length() == 7) {
            telch.requestFocus();
            return;
         }
      }
   }
   
   private void setDialog() {//다이알로그 구성
      dialog.setLayout(new BorderLayout(3,3));
      dlabel.setFont(new Font("Serif", Font.BOLD, 15));
      dialog.add("Center", dlabel);
      dialog.add("South", dbt);
      dialog.setSize(200, 150);
   }
   
   private void setMenu() {//메뉴구성
      setMenuBar(mb);
      
      mb.add(mfile);
      mfile.add(mfnew);
      mfile.addSeparator();
      mfile.add(mfopen);
      mfile.add(mfsave);
      mfile.add(mfsaveas);
      mfile.addSeparator();
      mfile.add(mfexit);
      
      mb.add(mhelp);
      mhelp.add(mhver);
   }
   
   private void buildGUI() {//화면구성
      setBackground(Color.CYAN);
      add("North", new Label());
      add("South", new Label());
      add("West", new Label());
      add("East", new Label());
      
      Panel mainPanel = new Panel(new BorderLayout(5,5));
         Panel centerPanel = new Panel(new BorderLayout(5,5));
            centerPanel.add("North", new Label("고 객 정 보 등 록", Label.CENTER));
            
            Panel cwPanel = new Panel(new GridLayout(5,1,5,5));
               cwPanel.add(new Label("이      름 : ", Label.RIGHT));
               cwPanel.add(new Label("주민번호 : ", Label.RIGHT));
               cwPanel.add(new Label("전화번호 : ", Label.RIGHT));
               cwPanel.add(new Label("성      별 : ", Label.RIGHT));
               cwPanel.add(new Label("취      미 : ", Label.RIGHT));
            centerPanel.add("West", cwPanel);
            
            centerPanel.add("East", new Label()); 
            
            Panel csPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
               csPanel.add(addbt);
               csPanel.add(dispbt);
               csPanel.add(updatebt);
               csPanel.add(delbt);
               csPanel.add(initbt);
            centerPanel.add("South", csPanel);
            
            Panel ccPanel = new Panel(new GridLayout(5,1,5,5));
               Panel p1 = new Panel(new FlowLayout(FlowLayout.LEFT));
                  p1.add(nametf);
               ccPanel.add(p1);
               
               Panel p2 = new Panel(new FlowLayout(FlowLayout.LEFT));
                  p2.add(jumin1tf);
                  p2.add(new Label("-", Label.CENTER));
                  p2.add(jumin2tf);
               ccPanel.add(p2);
               
               Panel p3 = new Panel(new FlowLayout(FlowLayout.LEFT));
                  for(int i=0; i<tstr.length; i++)
                     telch.add(tstr[i]);
                  p3.add(telch);
                  p3.add(new Label("-", Label.CENTER));
                  p3.add(tel1tf);
                  p3.add(new Label("-", Label.CENTER));
                  p3.add(tel2tf);
               ccPanel.add(p3);
               
               Panel p4 = new Panel(new FlowLayout(FlowLayout.LEFT));
                  p4.add(man);
                  p4.add(woman);
               ccPanel.add(p4);
               
               Panel p5 = new Panel(new FlowLayout(FlowLayout.LEFT));
                  for(int i=0; i<hstr.length; i++) {
                     hobby[i] = new Checkbox(hstr[i]);
                     p5.add(hobby[i]);
                  }
               ccPanel.add(p5);
            centerPanel.add("Center", ccPanel);
         mainPanel.add("Center", centerPanel);
         
         Panel eastPanel = new Panel(new BorderLayout(5,5));
            eastPanel.add("North", new Label("전 체 목 록", Label.CENTER));
            eastPanel.add("Center", listli);
         mainPanel.add("East", eastPanel);
         
         Panel southPanel = new Panel(new BorderLayout(5,5));
            southPanel.add("North", new Label("고 객 정 보 분 석 결 과 및 정 보", Label.CENTER));
            southPanel.add("Center", infota);
         mainPanel.add("South", southPanel);
      add("Center", mainPanel);
      
      pack();
      
      Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension my = getSize();
      setLocation(scr.width/2 - my.width/2, scr.height/2 - my.height/2);
      
      setForm(true);
      setButton(true);
      nametf.requestFocus();
      
      setResizable(false);
      setVisible(true);
   }

   public static void main(String[] args) {
      new CustomerManager();
   }

   
}