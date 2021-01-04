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
   
   //����ʵ�
   //--------------------------------------------------------------------����ȭ��
   private static final long serialVersionUID = 1L;
   
   private TextField nametf = new TextField(20);
   
   private TextField jumin1tf = new TextField(7);
   private TextField jumin2tf = new TextField(8);
   
   private Choice telch = new Choice();
   private String[] tstr = {"010", "011", "016", "017", "018", "019"};
   private TextField tel1tf = new TextField(4);
   private TextField tel2tf = new TextField(4);
   
   private CheckboxGroup cg = new CheckboxGroup();
   private Checkbox man = new Checkbox("����", cg, true);
   private Checkbox woman = new Checkbox("����", false, cg);
   
   private String[] hstr = {"����", "��ȭ", "����", "����", "����"};
   private Checkbox[] hobby = new Checkbox[hstr.length];
   
   private Button addbt = new Button("���");
   private Button dispbt = new Button("�м�");
   private Button updatebt = new Button("����");
   private Button delbt = new Button("����");
   private Button initbt = new Button("�Է¸��");
   
   private List listli = new List();
   
   private TextArea infota = new TextArea();
   
   //-------------------------------------------------------------------------- �޴�
   private MenuBar mb = new MenuBar();
   
   private Menu mfile = new Menu("File");
      private MenuItem mfnew = new MenuItem("������");
      private MenuItem mfopen = new MenuItem("�ҷ�����");
      private MenuItem mfsave = new MenuItem("�����ϱ�");
      private MenuItem mfsaveas = new MenuItem("���̸����������ϱ�");
      private MenuItem mfexit = new MenuItem("����");
   private Menu mhelp = new Menu("Help");
      private MenuItem mhver = new MenuItem("��������");
   
   //--------------------------------------------------------------------------- ���̾˷α�
   private Dialog dialog = new Dialog(this, "��������", true);
   
   private Label dlabel = new Label("CustomerManager V1.0", Label.CENTER);
   private Button dbt = new Button("Ȯ��");
   
   //---------------------------------------------------------------------------- �������
   private ArrayList<Customer> data = new ArrayList<Customer>();
   private File myfile = null;
   private FileDialog fildDialog = null;
      
   //������
   public CustomerManager() {
      super("���������α׷�");
      setMenu();
      setDialog();
      setEvent();
      buildGUI();
   }

   //�޼���
   private void setButton(boolean state) { // ��ư ����
      addbt.setEnabled(state);
      dispbt.setEnabled(!state);
      updatebt.setEnabled(!state);
      delbt.setEnabled(!state);
      initbt.setEnabled(!state);
   }
   
   public void clrscr() {// ȭ�� �ʱ�ȭ
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
      if(e.getSource() == addbt) {//��Ϲ�ư 
         String name = nametf.getText().trim();
         if(name == null || name.length() == 0) {
            infota.setText("\n\t�̸��� �ݵ�� �Է��ϼž� �մϴ�.");
            nametf.setText("");
            nametf.requestFocus();
            return;
         }
         
         StringBuffer jumin = new StringBuffer(jumin1tf.getText());
         jumin.append("-");   jumin.append(jumin2tf.getText());
         if(jumin1tf.getText().trim().length() != 6 || jumin2tf.getText().trim().length() != 7) {
            infota.setText("\n\t�ֹι�ȣ�� �� 6�ڸ� �� 7�ڸ��� �����˴ϴ�.");
            jumin1tf.setText("");
            jumin2tf.setText("");
            jumin1tf.requestFocus();
            return;
         }
         
         StringBuffer tel = new StringBuffer(telch.getSelectedItem());
         tel.append("-");   tel.append(tel1tf.getText());
         tel.append("-");   tel.append(tel2tf.getText());
         if(tel1tf.getText().trim().length() == 0 || tel2tf.getText().trim().length() == 0) {
            infota.setText("\n\t��ȭ��ȣ�� �ݵ�� �Է� �ϼž� �մϴ�.");
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
         if(myHobby.length() == 0) {//�ϳ��� ��̸� üũ���� �ʾҴ�.
            myHobby.append("����");
         }else {// �ϳ��̻� üũ�ߴ�.
            // myHobby.delete(myHobby.length()-1, myHobby.length());
            myHobby.deleteCharAt(myHobby.length()-1);
         }
         
         Customer myCustomer = new Customer(name, jumin.toString(), tel.toString(), gender, myHobby.toString());
         
         infota.setText("\n\t���������� ��� �Ǿ����ϴ�.");
         data.add(myCustomer);
         listli.add(myCustomer.toString());
         
         try {
            Thread.sleep(500); // ���α׷��� 0.5�� �����.
         }catch(InterruptedException ir) { }
         
         clrscr();//ȭ�������
      }//end ���
      if(e.getSource() == dispbt) { // �м���ư
         // �ֹι�ȣ ������ �����ؼ� infota���ٰ� ������ ����� �ݴϴ�.
      }
      if(e.getSource() == updatebt) {//������ư
         
         Customer myCustomer = data.get(listli.getSelectedIndex());
         
         StringBuffer tel = new StringBuffer(telch.getSelectedItem());
         tel.append("-");   tel.append(tel1tf.getText());
         tel.append("-");   tel.append(tel2tf.getText());
         if(tel1tf.getText().trim().length() == 0 || tel2tf.getText().trim().length() == 0) {
            infota.setText("\n\t��ȭ��ȣ�� �ݵ�� �Է� �ϼž� �մϴ�.");
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
         if(myHobby.length() == 0) {//�ϳ��� ��̸� üũ���� �ʾҴ�.
            myHobby.append("����");
         }else {// �ϳ��̻� üũ�ߴ�.
            // myHobby.delete(myHobby.length()-1, myHobby.length());
            myHobby.deleteCharAt(myHobby.length()-1);
         }
         
         infota.setText("\n\t���������� �����Ǿ����ϴ�.");
         myCustomer.setPhone(tel.toString());
         myCustomer.setHobby(myHobby.toString());
         
         try {
            Thread.sleep(500); // ���α׷��� 0.5�� �����.
         }catch(InterruptedException ir) { }
         
         setButton(true);
         setForm(true);
         clrscr();
         return;
      }//end ����
      if(e.getSource() == delbt) {//������ư
         int index = listli.getSelectedIndex();
         
         infota.setText("\n\t���������� ���� �Ǿ����ϴ�.");
         
         listli.remove(index);
         data.remove(index);
         
         try {
            Thread.sleep(500); // ���α׷��� 0.5�� �����.
         }catch(InterruptedException ir) { }
         
         setForm(true);
         setButton(true);
         clrscr();
         return;
      }//end ����
      if(e.getSource() == initbt) {//�Է¸��
         setForm(true);
         setButton(true);
         clrscr();
         return;
      }//end �Է¸��
      if(e.getSource() == mhver) {//��������
         Point pt = getLocation();
         Dimension my = getSize();
         Dimension dsize = dialog.getSize();
         
         dialog.setLocation((int)pt.getX() + my.width/2-dsize.width/2, (int)pt.getY() + my.height/2-dsize.height/2);
         dialog.setVisible(true);
      }//end ��������
      if(e.getSource() == mfexit) {//����޴�
         System.exit(0);
      }//end ����޴�
      if(e.getSource() == dbt) {//���̾˷α� �ȿ� ��ư
         dialog.setVisible(false);
      }
      if(e.getSource() == mfnew) {//������
         listli.removeAll();
         data.clear();
         myfile = null;
         setButton(true);
         setForm(true);
         clrscr();
      }//end ������
      if(e.getSource() == mfopen) {//�ҷ�����
         fildDialog = new FileDialog(this, "�ҷ�����", FileDialog.LOAD);
         fildDialog.setVisible(true);
         String fileName = fildDialog.getFile();
         String directory = fildDialog.getDirectory();
         if(fileName == null || directory == null) {
            return;
         }
         myfile = new File(directory, fileName);
         dataLoad();
      }//end �ҷ�����
      if(e.getSource() == mfsave) {//�����ϱ�
         if(myfile == null) {
            fildDialog = new FileDialog(this, "�� �̸����� �����ϱ�", FileDialog.SAVE);
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
      }//end �����ϱ�
      if(e.getSource() == mfsaveas) {//���̸����� �����ϱ�
         fildDialog = new FileDialog(this, "�� �̸����� �����ϱ�", FileDialog.SAVE);
         fildDialog.setVisible(true);
         String fileName = fildDialog.getFile();
         String directory = fildDialog.getDirectory();
         if(fileName == null || directory == null) {
            return;
         }
         myfile = new File(directory, fileName);
         dataSave();
      }//end ���̸����� �����ϱ�
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
            if(mydata[3].equals("����")) gender = true;
            Customer myCustomer = new Customer(mydata[0], mydata[1], mydata[2], gender, mydata[4]);
            listli.add(myCustomer.toString());
            data.add(myCustomer);
         }
         infota.setText("\n\t���������� �����͸� �ε��Ͽ����ϴ�.");
      }catch(FileNotFoundException fnfe) {
         System.err.println(myfile.getName() + " ������ ã�� �� �����ϴ�.");
      }catch(IOException ioe) {
         ioe.printStackTrace();
      }finally {
         try { if(br != null) br.close(); }catch(IOException ioe) { }
         try { if(fr != null) fr.close(); }catch(IOException ioe) { }
      }
      
      try {
         Thread.sleep(500); // ���α׷��� 0.5�� �����.
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
            sb.append(myCustomer.isSex() ? "����" : "����"); sb.append("/");
            sb.append(myCustomer.getHobby());
            pw.println(sb.toString());
         }
         infota.setText("\n\t���������� ����Ǿ����ϴ�");
      }catch(FileNotFoundException fnfe) {
         System.err.println(myfile.getName() + " ������ ã�� �� �����ϴ�.");
      }catch(IOException ioe) {
         ioe.printStackTrace();
      }finally {
         if(pw != null) pw.close();
         try { if(bw != null) bw.close(); }catch(IOException ioe) { }
         try { if(fw != null) fw.close(); }catch(IOException ioe) { }
      }
      
      try {
         Thread.sleep(500); // ���α׷��� 0.5�� �����.
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
      if(e.getSource() == listli) {//��Ͽ��� ����
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
   
   private void setDialog() {//���̾˷α� ����
      dialog.setLayout(new BorderLayout(3,3));
      dlabel.setFont(new Font("Serif", Font.BOLD, 15));
      dialog.add("Center", dlabel);
      dialog.add("South", dbt);
      dialog.setSize(200, 150);
   }
   
   private void setMenu() {//�޴�����
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
   
   private void buildGUI() {//ȭ�鱸��
      setBackground(Color.CYAN);
      add("North", new Label());
      add("South", new Label());
      add("West", new Label());
      add("East", new Label());
      
      Panel mainPanel = new Panel(new BorderLayout(5,5));
         Panel centerPanel = new Panel(new BorderLayout(5,5));
            centerPanel.add("North", new Label("�� �� �� �� �� ��", Label.CENTER));
            
            Panel cwPanel = new Panel(new GridLayout(5,1,5,5));
               cwPanel.add(new Label("��      �� : ", Label.RIGHT));
               cwPanel.add(new Label("�ֹι�ȣ : ", Label.RIGHT));
               cwPanel.add(new Label("��ȭ��ȣ : ", Label.RIGHT));
               cwPanel.add(new Label("��      �� : ", Label.RIGHT));
               cwPanel.add(new Label("��      �� : ", Label.RIGHT));
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
            eastPanel.add("North", new Label("�� ü �� ��", Label.CENTER));
            eastPanel.add("Center", listli);
         mainPanel.add("East", eastPanel);
         
         Panel southPanel = new Panel(new BorderLayout(5,5));
            southPanel.add("North", new Label("�� �� �� �� �� �� �� �� �� �� ��", Label.CENTER));
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