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
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.*;

import lee.java.vo.Customer;

// <������ ���α׷� on Windows>
// Controller
public class CustomerManager extends Frame implements ActionListener, KeyListener, ItemListener{
   
   // [����ʵ�]
   //-------------------------------------------------------------------- ����ȭ��
   private static final long serialVersionUID = 1L;
   
   private TextField tfName = new TextField(20);
  
   private TextField tfIdNumFront = new TextField(7);
   private TextField tfIdNumRear = new TextField(8);
   
   private Choice chPhone = new Choice();
   private String[] strPhone = {"010", "011", "016", "017", "018", "019"};
   private TextField tfPhoneFront = new TextField(4);
   private TextField tfPhoneRear = new TextField(4);
   
   private CheckboxGroup cg = new CheckboxGroup();
   private Checkbox chMan = new Checkbox("����", cg, true);
   private Checkbox chWoman = new Checkbox("����", false, cg);
   
   private String[] strHobby = {"����", "��ȭ", "����", "����", "����"};
   private Checkbox[] chHobby = new Checkbox[strHobby.length];
   
   private Button btAdd = new Button("���");
   private Button btAnalysis = new Button("�м�");
   private Button btUpdate = new Button("����");
   private Button btDelete = new Button("����");
   private Button btInit = new Button("�ʱ�ȭ");
   
   private List listCustomer = new List();
   
   private TextArea taInfo = new TextArea();
   
   //-------------------------------------------------------------------------- �޴�
   private MenuBar menuBar = new MenuBar();
   
   private Menu menuFile = new Menu("File");
      private MenuItem newFile = new MenuItem("������");
      private MenuItem openFile = new MenuItem("�ҷ�����");
      private MenuItem saveFile = new MenuItem("�����ϱ�");
      private MenuItem saveasFile = new MenuItem("���̸����������ϱ�");
      private MenuItem closeFile = new MenuItem("����");
   private Menu menuHelp = new Menu("Help");
      private MenuItem versionInfo = new MenuItem("��������");
   
   //--------------------------------------------------------------------------- ���̾�α�
   private Dialog dialog = new Dialog(this, "��������", true);
   
   private Label labVersion = new Label("CustomerManager V1.0", Label.CENTER);
   private Button btConfirm = new Button("Ȯ��");
   
   //---------------------------------------------------------------------------- �������
   private ArrayList<Customer> data = new ArrayList<Customer>();
   private File myFile = null;
   private FileDialog fileDialog = null;
      
   // [������]
   public CustomerManager() {
      super("���������α׷�");
      setMenu();
      setDialog();
      setEvent();
      buildGUI();
   }

   // [�޼���]
   // ��ư ����
   private void setButton(boolean state) { 
      btAdd.setEnabled(state);
      btAnalysis.setEnabled(!state);
      btUpdate.setEnabled(!state);
      btDelete.setEnabled(!state);
      btInit.setEnabled(!state);
   }
   
   // ȭ�� �ʱ�ȭ
   public void cls() {
      tfName.setText("");
      tfIdNumFront.setText("");
      tfIdNumRear.setText("");
      chPhone.select(0);
      tfPhoneFront.setText("");
      tfPhoneRear.setText("");
      chMan.setState(true);
      for(int i=0; i<chHobby.length; i++)
         chHobby[i].setState(false);
      taInfo.setText("");
      tfName.requestFocus();
   }
   
   public void setForm(boolean state) {
      tfName.setEditable(state);
      tfIdNumFront.setEditable(state);
      tfIdNumRear.setEditable(state);
      chMan.setEnabled(state);
      chWoman.setEnabled(state);
   }
   
   // �̺�Ʈ ������ ����
   public void setEvent() {
      saveasFile.addActionListener(this);
      saveFile.addActionListener(this);
      openFile.addActionListener(this);
      newFile.addActionListener(this);
      btConfirm.addActionListener(this);
      closeFile.addActionListener(this);
      versionInfo.addActionListener(this);
      btInit.addActionListener(this);
      btDelete.addActionListener(this);
      btUpdate.addActionListener(this);
      btAnalysis.addActionListener(this);
      listCustomer.addItemListener(this);
      btAdd.addActionListener(this);
      tfPhoneFront.addActionListener(this);
      chPhone.addItemListener(this);
      tfIdNumRear.addKeyListener(this);
      tfIdNumFront.addKeyListener(this);
      tfName.addActionListener(this);
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == tfName) {
         tfIdNumFront.requestFocus();
         return;
      }
      
      if(e.getSource() == tfPhoneFront) {
         tfPhoneRear.requestFocus();
         return;
      }
      
      // ��� ��ư 
      if(e.getSource() == btAdd) {
         String name = tfName.getText().trim();
         if(name == null || name.length() == 0) {
            taInfo.setText("\n\t�̸��� �ݵ�� �Է��ϼž� �մϴ�.");
            tfName.setText("");
            tfName.requestFocus();
            return;
         }
         
         StringBuffer jumin = new StringBuffer(tfIdNumFront.getText());
         jumin.append("-");   jumin.append(tfIdNumRear.getText());
         if(tfIdNumFront.getText().trim().length() != 6 || tfIdNumRear.getText().trim().length() != 7) {
            taInfo.setText("\n\t�ֹι�ȣ�� �� 6�ڸ� �� 7�ڸ��� �����˴ϴ�.");
            tfIdNumFront.setText("");
            tfIdNumRear.setText("");
            tfIdNumFront.requestFocus();
            return;
         }      
         
         StringBuffer tel = new StringBuffer(chPhone.getSelectedItem());
         tel.append("-");   tel.append(tfPhoneFront.getText());
         tel.append("-");   tel.append(tfPhoneRear.getText());
         if(tfPhoneFront.getText().trim().length() == 0 || tfPhoneRear.getText().trim().length() == 0) {
            taInfo.setText("\n\t��ȭ��ȣ�� �ݵ�� �Է� �ϼž� �մϴ�.");
            tfPhoneFront.setText("");
            tfPhoneRear.setText("");
            tfPhoneFront.requestFocus();
            return;
         }  
          
         boolean gender = chMan.getState();
         
         StringBuffer myHobby = new StringBuffer();
         for(int i=0; i<chHobby.length; i++) {
            if(chHobby[i].getState()) {
               myHobby.append(chHobby[i].getLabel());
               myHobby.append("-");
            }
         }
         if(myHobby.length() == 0) { // ��̸� üũ���� ���� ���
            myHobby.append("����");
         } else { // �ϳ� �̻� üũ�� ���
            // myHobby.delete(myHobby.length()-1, myHobby.length());
            myHobby.deleteCharAt(myHobby.length()-1);
         }
         
         Customer myCustomer = new Customer(name, jumin.toString(), tel.toString(), gender, myHobby.toString());
         
         taInfo.setText("\n\t���������� ��� �Ǿ����ϴ�.");
         data.add(myCustomer);
         listCustomer.add(myCustomer.toString());
         
         try {
            Thread.sleep(500); // 0.5�ʰ� ���α׷� ����
         } catch(InterruptedException ir) { }
         
         cls(); // ȭ�� �ʱ�ȭ
      } //end ���
      
      // �м� ��ư (2020�� ������ ���)
      if(e.getSource() == btAnalysis) {
          StringBuffer idNum = new StringBuffer(tfIdNumFront.getText());
          idNum.append(tfIdNumRear.getText());
    	  String[] tempIdNum = new String[13];
    	  int[] intIdNum = new int[tempIdNum.length];
    	  for(int i=0; i<tempIdNum.length; i++) {
    		  tempIdNum[i] = idNum.substring(i,i+1);
    		  intIdNum[i] = Integer.parseInt(tempIdNum[i]);
    	  }
    	  
    	  float sum = 0; float temp = 0; float total = 0;
    	  float cre = 2.f;
    	  for(int i=0; i<intIdNum.length; i++) {
    		  if(cre == 10.f) cre = 2.f;
    		  sum += intIdNum[i] * cre;
    		  cre++;
    	  } 
          temp = 11.f * (int)(sum/11.f) + 11.f - sum;
          total = temp - 10.f * (int)(temp/10.f);
 
          if(total != intIdNum[intIdNum.length-1]){
              taInfo.setText("\n\t�߸��� �ֹι�ȣ�Դϴ�.");
              return;
           }

          Customer myCustomer = data.get(listCustomer.getSelectedIndex());
          
          int year = 1900;
          switch(intIdNum[6]){
             case 3 :
             case 4 : year = 2000; break;
             case 9 :
             case 0 : year = 1800; break;
             default : year = 1900; break;
          }
          year += intIdNum[0]*10 + intIdNum[1];
          int month = intIdNum[2]*10 + intIdNum[3];
          int day = intIdNum[4]*10 + intIdNum[5];
          String where = "";
          switch(intIdNum[7]){
          case 0 : where = "����"; break;
          case 1 : where = "���"; break;
          case 2 : where = "����"; break;
          case 3 : where = "���"; break;
          case 4 : where = "�泲"; break;
          case 5 : where = "����"; break;
          case 6 : where = "����"; break;
          case 7 : where = "���"; break;
          case 8 : where = "�泲"; break;
          case 9 : where = "����"; break;
       }
          taInfo.setText("\n\t[" + myCustomer.getName() + "] ���� �������� �м����\n\t-> ������� : " 
        		  	+ year + "�� " + month + "�� " + day + "��\n\t-> ��    �� : " 
        		  	+ (Calendar.getInstance().get(Calendar.YEAR) - year) + "��\n\t-> ��    �� : " 
        		  	+ (intIdNum[6] % 2 == 0 ? "����" : "����")
        		    + "\n\t-> ������� : " + where);
      } // end �м�
      
      // ���� ��ư
      if(e.getSource() == btUpdate) { 
         Customer myCustomer = data.get(listCustomer.getSelectedIndex());
         
         StringBuffer tel = new StringBuffer(chPhone.getSelectedItem());
         tel.append("-");   tel.append(tfPhoneFront.getText());
         tel.append("-");   tel.append(tfPhoneRear.getText());
         if(tfPhoneFront.getText().trim().length() == 0 || tfPhoneRear.getText().trim().length() == 0) {
            taInfo.setText("\n\t��ȭ��ȣ�� �ݵ�� �Է� �ϼž� �մϴ�.");
            tfPhoneFront.setText("");
            tfPhoneRear.setText("");
            tfPhoneFront.requestFocus();
            return;
         }
         
         StringBuffer myHobby = new StringBuffer();
         for(int i=0; i<chHobby.length; i++) {
            if(chHobby[i].getState()) {
               myHobby.append(chHobby[i].getLabel());
               myHobby.append("-");
            }
         }
         if(myHobby.length() == 0) { // ��̸� üũ���� ���� ���
            myHobby.append("����");
         }else { // �ϳ� �̻� üũ�� ���
            // myHobby.delete(myHobby.length()-1, myHobby.length());
            myHobby.deleteCharAt(myHobby.length()-1);
         }
         
         taInfo.setText("\n\t���������� �����Ǿ����ϴ�.");
         myCustomer.setPhone(tel.toString());
         myCustomer.setHobby(myHobby.toString());
         
         try {
            Thread.sleep(500); // 0.5�ʰ� ���α׷� ����
         } catch(InterruptedException ir) { }
         
         setButton(true);
         setForm(true);
         cls();
         return;
      } // end ����
      
      // ���� ��ư
      if(e.getSource() == btDelete) {
         int index = listCustomer.getSelectedIndex();
         
         taInfo.setText("\n\t���������� ���� �Ǿ����ϴ�.");
         
         listCustomer.remove(index);
         data.remove(index);
         
         try {
            Thread.sleep(500); // 0.5�ʰ� ���α׷� ����
         } catch(InterruptedException ir) { }
         
         setForm(true);
         setButton(true);
         cls();
         return;
      } // end ����
      
      // �ʱ�ȭ ��ư
      if(e.getSource() == btInit) {
         setForm(true);
         setButton(true);
         cls();
         return;
      } // end �ʱ�ȭ
      
      // ���� ���� (���̾�α�)
      if(e.getSource() == versionInfo) { 
         Point pt = getLocation(); // ���� â ������ (x,y)��ǥ
         Dimension my = getSize();
         Dimension dsize = dialog.getSize();
         
         dialog.setLocation((int)pt.getX() + my.width/2-dsize.width/2, (int)pt.getY() + my.height/2-dsize.height/2); // ���� â ����� ���̾�α� â ����
         dialog.setVisible(true);
      } // end ���� ����
      
      // ���� �޴�
      if(e.getSource() == closeFile) { 
         System.exit(0);
      } // end ���� �޴�
      
      // ���̾�α� �� Ȯ�� ��ư
      if(e.getSource() == btConfirm) { 
         dialog.setVisible(false);
      } // end ���̾�α� �� Ȯ�� ��ư
      
      // ������
      if(e.getSource() == newFile) { 
         listCustomer.removeAll();
         data.clear();
         myFile = null;
         setButton(true);
         setForm(true);
         cls();
      } // end ������
      
      // �ҷ�����
      if(e.getSource() == openFile) {
         fileDialog = new FileDialog(this, "�ҷ�����", FileDialog.LOAD);
         fileDialog.setVisible(true);
         String fileName = fileDialog.getFile();
         String directory = fileDialog.getDirectory();
         if(fileName == null || directory == null) {
            return;
         }
         myFile = new File(directory, fileName);
         // dataLoad(); : �ϳ��ϳ� �о �ҷ�����
         loadData(); // ������ȭ : ��ü �ҷ�����
      } // end �ҷ�����
      
      // �����ϱ�
      if(e.getSource() == saveFile) {
         if(myFile == null) {
            fileDialog = new FileDialog(this, "�� �̸����� �����ϱ�", FileDialog.SAVE);
            fileDialog.setVisible(true);
            String fileName = fileDialog.getFile();
            String directory = fileDialog.getDirectory();         
            if(fileName == null || directory == null) {
               return;
            }
            myFile = new File(directory, fileName);
         }
         // dataSave(); : �ϳ��ϳ� �����ϱ� 
         saveData(); // ����ȭ : ��ü�� �����ϱ�
      } // end �����ϱ�
      
      // ���̸����� �����ϱ�
      if(e.getSource() == saveasFile) { 
         fileDialog = new FileDialog(this, "�� �̸����� �����ϱ�", FileDialog.SAVE);
         fileDialog.setVisible(true);
         String fileName = fileDialog.getFile();
         String directory = fileDialog.getDirectory();
         if(fileName == null || directory == null) {
            return;
         }
         myFile = new File(directory, fileName);
         // dataSave();
         saveData();
      } // end ���̸����� �����ϱ�
   }
   
   // ������ȭ : ��ü �ҷ�����
   public void loadData() {
	   FileInputStream fis = null;
	   ObjectInputStream ois = null;
      
      listCustomer.removeAll();
      data.clear();
      
      try {
         fis = new FileInputStream(myFile);
         ois = new ObjectInputStream(fis);
         
         Customer myCustomer = null;
         while((myCustomer = (Customer)ois.readObject()) != null) {
            listCustomer.add(myCustomer.toString());
            data.add(myCustomer);
         }
      } catch(EOFException eofe) {
         taInfo.setText("\n\t���������� �����͸� �ε��Ͽ����ϴ�.");
      } catch(ClassNotFoundException cnfe) {
         System.err.println("Customer Ŭ������ ã�� �� �����ϴ�.");
      } catch(FileNotFoundException fnfe) {
         System.err.println(myFile.getName() + " ������ �������� �ʽ��ϴ�.");
      } catch(IOException ioe) {
         ioe.printStackTrace();
      } finally {
         try { if(ois != null) ois.close(); }catch(IOException ioe) {}
         try { if(fis != null) fis.close(); }catch(IOException ioe) {}
      }
      
      try {
         Thread.sleep(500); // 0.5�ʰ� ���α׷� ����
      }catch(InterruptedException ir) {}
      
      setButton(true);
      setForm(true);
      cls();
   }
   
   // ����ȭ : ��ü�� �����ϱ�
   public void saveData() { 
      FileOutputStream fos = null;
      ObjectOutputStream oos = null;
      
      try {
         fos = new FileOutputStream(myFile);
         oos = new ObjectOutputStream(fos);
         
         for(int i=0; i<data.size(); i++) {
            Customer myCustomer = data.get(i);
            oos.writeObject(myCustomer);
         }
         taInfo.setText("\n\t���������� ����Ǿ����ϴ�");
      } catch(FileNotFoundException fnfe) {
         System.err.println(myFile.getName() + " ������ �������� �ʽ��ϴ�.");
      } catch(IOException ioe) {
         ioe.printStackTrace();
      } finally {
         try { if(oos != null) oos.close(); }catch(IOException ioe) {}
         try { if(fos != null) fos.close(); }catch(IOException ioe) {}
      }
      
      try {
         Thread.sleep(500); // 0.5�ʰ� ���α׷� ����
      } catch(InterruptedException ir) {}
      
      setButton(true);
      setForm(true);
      cls();
   }
   
   public void dataLoad() {
      FileReader fr = null;
      BufferedReader br = null;
      
      listCustomer.removeAll();
      data.clear();
      
      try {
         fr = new FileReader(myFile);
         br = new BufferedReader(fr);
         
         String readData = "";
         while((readData = br.readLine()) != null) {
            String[] mydata = readData.split("/");
            boolean gender = false;
            if(mydata[3].equals("����")) gender = true;
            Customer myCustomer = new Customer(mydata[0], mydata[1], mydata[2], gender, mydata[4]);
            listCustomer.add(myCustomer.toString());
            data.add(myCustomer);
         }
         taInfo.setText("\n\t���������� �����͸� �ε��Ͽ����ϴ�.");
      } catch(FileNotFoundException fnfe) {
         System.err.println(myFile.getName() + " ������ ã�� �� �����ϴ�.");
      } catch(IOException ioe) {
         ioe.printStackTrace();
      } finally {
         try { if(br != null) br.close(); }catch(IOException ioe) {}
         try { if(fr != null) fr.close(); }catch(IOException ioe) {}
      }
      
      try {
         Thread.sleep(500); // 0.5�ʰ� ���α׷� ����
      } catch(InterruptedException ir) {}
      
      setForm(true);
      setButton(true);
      cls();
   }
   
   public void dataSave() {
      FileWriter fw = null;
      BufferedWriter bw = null;
      PrintWriter pw = null;
      
      try {
         fw = new FileWriter(myFile);
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
         taInfo.setText("\n\t���������� ����Ǿ����ϴ�");
      } catch(FileNotFoundException fnfe) {
         System.err.println(myFile.getName() + " ������ ã�� �� �����ϴ�.");
      } catch(IOException ioe) {
         ioe.printStackTrace();
      } finally {
         if(pw != null) pw.close();
         try { if(bw != null) bw.close(); }catch(IOException ioe) {}
         try { if(fw != null) fw.close(); }catch(IOException ioe) {}
      }
      
      try {
         Thread.sleep(500); // 0.5�ʰ� ���α׷� ����
      } catch(InterruptedException ir) {}
      
      setButton(true);
      setForm(true);
      cls();
   }
   
   
   @Override
   public void itemStateChanged(ItemEvent e) {
      if(e.getSource() == chPhone) {
         tfPhoneFront.requestFocus();
         return;
      }
      
      // ��Ͽ��� ����
      if(e.getSource() == listCustomer)  { 
         int index = listCustomer.getSelectedIndex();
         
         Customer myCustomer = data.get(index);
         
         tfName.setText(myCustomer.getName());
         tfIdNumFront.setText(myCustomer.getIdNum().split("-")[0]);
         tfIdNumRear.setText(myCustomer.getIdNum().split("-")[1]);
         chPhone.select(myCustomer.getPhone().split("-")[0]);
         tfPhoneFront.setText(myCustomer.getPhone().split("-")[1]);
         tfPhoneRear.setText(myCustomer.getPhone().split("-")[2]);
         chMan.setState(myCustomer.isSex());
         chWoman.setState(!myCustomer.isSex());
         
         for(int i=0; i<chHobby.length; i++)
            chHobby[i].setState(false);
         
         String[] myHobby = myCustomer.getHobby().split("-");
         for(int i=0; i<myHobby.length; i++) {
            for(int j=0; j<chHobby.length; j++) {
               if(myHobby[i].equals(chHobby[j].getLabel())) {
                  chHobby[j].setState(true);
                  break;
               }
            }
         }
   
         setForm(false);
         setButton(false);
         chPhone.requestFocus();
      }
   }
   
   @Override
   public void keyTyped(KeyEvent e) {}

   @Override
   public void keyPressed(KeyEvent e) {}

   @Override
   public void keyReleased(KeyEvent e) {
      if(e.getSource() == tfIdNumFront) {
         if(tfIdNumFront.getText().trim().length() == 6) {
            tfIdNumRear.requestFocus();
            return;
         }
      }
      if(e.getSource() == tfIdNumRear) {
         if(tfIdNumRear.getText().trim().length() == 7) {
            chPhone.requestFocus();
            return;
         }
      }
   }
   
   // ���̾�α� ����
   private void setDialog() {
      dialog.setLayout(new BorderLayout(3,3));
      labVersion.setFont(new Font("Serif", Font.BOLD, 15));
      dialog.add("Center", labVersion);
      dialog.add("South", btConfirm);
      dialog.setSize(200, 150);
   }
   
   // �޴� ����
   private void setMenu() {
      setMenuBar(menuBar);
      
      menuBar.add(menuFile);
      menuFile.add(newFile);
      menuFile.addSeparator();
      menuFile.add(openFile);
      menuFile.add(saveFile);
      menuFile.add(saveasFile);
      menuFile.addSeparator();
      menuFile.add(closeFile);
      
      menuBar.add(menuHelp);
      menuHelp.add(versionInfo);
   }
   
   // ȭ�� ����
   private void buildGUI() {
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
               csPanel.add(btAdd);
               csPanel.add(btAnalysis);
               csPanel.add(btUpdate);
               csPanel.add(btDelete);
               csPanel.add(btInit);
            centerPanel.add("South", csPanel);
            
            Panel ccPanel = new Panel(new GridLayout(5,1,5,5));
               Panel p1 = new Panel(new FlowLayout(FlowLayout.LEFT));
                  p1.add(tfName);
               ccPanel.add(p1);
               
               Panel p2 = new Panel(new FlowLayout(FlowLayout.LEFT));
                  p2.add(tfIdNumFront);
                  p2.add(new Label("-", Label.CENTER));
                  p2.add(tfIdNumRear);
               ccPanel.add(p2);
               
               Panel p3 = new Panel(new FlowLayout(FlowLayout.LEFT));
                  for(int i=0; i<strPhone.length; i++)
                     chPhone.add(strPhone[i]);
                  p3.add(chPhone);
                  p3.add(new Label("-", Label.CENTER));
                  p3.add(tfPhoneFront);
                  p3.add(new Label("-", Label.CENTER));
                  p3.add(tfPhoneRear);
               ccPanel.add(p3);
               
               Panel p4 = new Panel(new FlowLayout(FlowLayout.LEFT));
                  p4.add(chMan);
                  p4.add(chWoman);
               ccPanel.add(p4);
               
               Panel p5 = new Panel(new FlowLayout(FlowLayout.LEFT));
                  for(int i=0; i<strHobby.length; i++) {
                     chHobby[i] = new Checkbox(strHobby[i]);
                     p5.add(chHobby[i]);
                  }
               ccPanel.add(p5);
            centerPanel.add("Center", ccPanel);
         mainPanel.add("Center", centerPanel);
         
         Panel eastPanel = new Panel(new BorderLayout(5,5));
            eastPanel.add("North", new Label("�� ü �� ��", Label.CENTER));
            eastPanel.add("Center", listCustomer);
         mainPanel.add("East", eastPanel);
         
         Panel southPanel = new Panel(new BorderLayout(5,5));
            southPanel.add("North", new Label("�� �� �� �� �� �� �� �� �� �� ��", Label.CENTER));
            southPanel.add("Center", taInfo);
         mainPanel.add("South", southPanel);
      add("Center", mainPanel);
      
      pack();
      
      // ȭ�� �߾ӿ� ���α׷� ���� 
      Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension my = getSize();
      setLocation(scr.width/2 - my.width/2, scr.height/2 - my.height/2);
      
      setForm(true);
      setButton(true);
      tfName.requestFocus();
      
      setResizable(false);
      setVisible(true);
   }

   // ���� 
   public static void main(String[] args) {
      new CustomerManager();
   }
}