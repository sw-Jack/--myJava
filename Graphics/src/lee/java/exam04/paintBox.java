package lee.java.exam04;
import java.awt.*;
import java.awt.event.*;
import java.util.*;//vector
import java.io.*;//저장

// <그림판>
public class paintBox extends Frame implements ActionListener, ItemListener, MouseListener, MouseMotionListener, 
																	   KeyListener, WindowListener
{
	Image bufferImage;
	Graphics bufferGraphics;
	private CheckboxGroup cg = new CheckboxGroup();
	private Checkbox draw = new Checkbox("draw",cg,true);
	private Checkbox line = new Checkbox("Line", cg, false);
	private Checkbox  rect = new Checkbox("Rect",cg,false);
	private Checkbox roundRect = new Checkbox("roundRect",cg,false);
	private Checkbox oval = new Checkbox("Oval",cg,false);

	private Vector<preparingPaintBox> data = new Vector<preparingPaintBox>();

	private int x; private int y; private int w; private int h;
	private int iii;

	Font font;
	
	/*레이아웃*/
	private int rrw=50, rrh=50;
	private int flag;//draw, line, rect, roundrect, oval 선택
	private Color color;	private int r; private int g; private int b; //색상
	private int fill;//채우기 효과
	
	/*메뉴바*/
	private MenuBar mb =new MenuBar();
	private Menu mfile = new Menu("파일");
	private MenuItem mclear = new MenuItem("초기화");
	private MenuItem mopen = new MenuItem("열기");
	private MenuItem msave = new MenuItem("저장");
	private MenuItem mexit = new MenuItem("종료");
	private Menu mbg = new Menu("배경");
	private CheckboxMenuItem m_green =  new CheckboxMenuItem("green",false);
	private CheckboxMenuItem m_yellow =  new CheckboxMenuItem("yellow",false);
	private CheckboxMenuItem m_pink =  new CheckboxMenuItem("pink",true);
	private CheckboxMenuItem m_sky =  new CheckboxMenuItem("sky-blue",false);

	private Color back_color = new Color(255,110,180);

	/*dialog*/
	private Dialog mclear_dia = new Dialog(this, "초기화 선택", false);
	private Button mclear_yes = new Button("확인");
	private Button mclear_no = new Button("취소");
		
	/*sidebar*/
	private Button[] bt_c = {new Button("  "), new Button("  "), new Button("  "), new Button("  "),new Button("  "), 
													new Button("  "),new Button("  "), new Button("  "),new Button("  "), new Button("  ")};//색 넣어서 놓기.
	private TextField r_col = new TextField("0", 3);
	private TextField g_col = new TextField("0", 3);
	private TextField b_col = new TextField("0", 3);
	private Button bt = new Button("선택");

	private CheckboxGroup cg_clear = new CheckboxGroup();
	private Checkbox clear = new Checkbox("작은지우개",cg_clear,true);
	private Checkbox clear1 = new Checkbox("큰지우개",cg_clear,false);

	private int cc;//지우개 flag
	private int cc_select;//지우개 두깨 선택
	
	private CheckboxGroup cg_fill = new CheckboxGroup();
	private Checkbox c_fill = new Checkbox("채우기",cg_fill,false);
	private Checkbox c_nofill = new Checkbox("채우기해제",cg_fill,true);
	
	/*up*/
	private Label lb_x = new Label("          ");
	private Label lb_y = new Label("          ");

	/*저장*/
	private FileDialog fd = null;
	private File f = null;
	private Label lb_rgb = new Label();

	/*배경*/
	//패널 - 사이드바
	Panel p_cg;
	Panel up;
	Panel p_side;
	Panel p_sidebar;
	Panel p_c_allbt;
	Panel p_c_bt;
	//패널 - 지우개, 채우기
	Panel p_sidebar2;
	Panel p_side_fill;
	//패널 - RGB;
	Panel p_sidebar3;
	Panel p_side_rgb;
	Panel p_rgb_all;
	Panel p_rgb_text;
	Panel p_flow1;
	Panel p_flow2;
	Panel p_flow3;

	//레이블
	private Label lb[] = {new Label(""),new Label(""),new Label(""),new Label(""),new Label(""),new Label(""),new Label(""),new Label(""),new Label(""),new Label(""),
		                                new Label(""),new Label(""),new Label(""),new Label(""),new Label(""),new Label(""),new Label(""),new Label(""),new Label(""),new Label("")};
	private Label lb_xx = new Label("x : ");
	private Label lb_yy = new Label("y : ");
	private Label lb_select = new Label("색상선택");
	private Label lb_clear = new Label("지우개");
	private Label lb_fill = new Label("채우기");
	private Label lb_s_rgb = new Label("rgb 선택");
	public paintBox(){
		super("그림판"); 
		setSize(1000,700);
		Dimension my = getSize();//setSize아래에 두어야 한다
		Dimension src = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(src.width/2 - my.width/2, src.height/2 - my.height/2);
		setResizable(false);
		setEvent();
		setDialog();
		setForm();
		color = new Color(r,g,b);
		setVisible(true);
	}

	//레이블 색상 표현
	public void keyPressed(KeyEvent e){}
	public void keyReleased(KeyEvent e){
		if(e.getSource() == r_col){
			try{
				r = Integer.parseInt(r_col.getText());
				if(r<0) r=0;
				if(r>255) r=255;
				lb_rgb.setBackground(new Color(r,g,b));//레이블 배경 업로드
				color = new Color(r,g,b);
			}catch(NumberFormatException nfe){}
		}
		if(e.getSource() == g_col){
			try{
				g = Integer.parseInt(g_col.getText());
				if(g<0) g=0;
				if(g>255) g=255;
				lb_rgb.setBackground(new Color(r,g,b));
				color = new Color(r,g,b);
			}catch(NumberFormatException nfe){}
		}
		if(e.getSource() == b_col){
			try{
				b = Integer.parseInt(b_col.getText());
				if(b<0) b=0;
				if(b>255) b=255;
				lb_rgb.setBackground(new Color(r,g,b));
				color = new Color(r,g,b);
			}catch(NumberFormatException nfe){}
		}
	}
	public void keyTyped(KeyEvent e){}
	
	public void itemStateChanged(ItemEvent e){		
		if(e.getSource() == mclear_no){
			mclear_dia.setVisible(false);
		}
		if(e.getSource()==m_green){
			back_color = new Color(169,212,109);//0,250,80
			m_yellow.setState(false);
			m_pink.setState(false);
			m_sky.setState(false);
			bg_color();
		}
		if(e.getSource()==m_yellow){
			back_color = new Color(255,250,124);
			m_pink.setState(false);
			m_sky.setState(false);
			m_green.setState(false);
			bg_color();
		}
		if(e.getSource()==m_pink){
			back_color = new Color(255,110,180);
			m_yellow.setState(false);
			m_sky.setState(false);
			m_green.setState(false);
			bg_color();
		}
		if(e.getSource()==m_sky){
			back_color = new Color(80,200,230);
			m_yellow.setState(false);
			m_pink.setState(false);
			m_green.setState(false);
			bg_color();
		}
	}

	public void bg_color(){
		/*배경*/
		//패널 - 사이드바
		p_cg.setBackground(back_color);
		up.setBackground(back_color);
		p_side.setBackground(back_color);
		p_sidebar.setBackground(back_color);
		p_c_allbt.setBackground(back_color);
		p_c_bt.setBackground(back_color);
		//패널 - 지우개, 채우기
		p_sidebar2.setBackground(back_color);
		p_side_fill.setBackground(back_color);
		//패널 - RGB;
		p_sidebar3.setBackground(back_color);
		p_side_rgb.setBackground(back_color);
		p_rgb_all.setBackground(back_color);
		p_rgb_text.setBackground(back_color);
		p_flow1.setBackground(back_color);
		p_flow2.setBackground(back_color);
		p_flow3.setBackground(back_color);

		//레이블
		for(int i = 0; i < lb.length; i++){
			lb[i].setBackground(back_color);
		}
		lb_xx.setBackground(back_color);
		lb_yy.setBackground(back_color);
		lb_select.setBackground(back_color);
		lb_clear.setBackground(back_color);
		lb_fill.setBackground(back_color);
		lb_s_rgb.setBackground(back_color);
		clear.setBackground(back_color);
		clear1.setBackground(back_color);
		c_fill.setBackground(back_color);
		c_nofill.setBackground(back_color);

		draw.setBackground(back_color);
		line.setBackground(back_color);
		rect.setBackground(back_color);
		roundRect.setBackground(back_color);
		oval.setBackground(back_color);
 	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == mexit){
			System.exit(0);
		}

		if(e.getSource() == mclear){
			mclear_dia.setVisible(true);
		}
		if(e.getSource() == mopen){
			fd = new FileDialog(this,"파일열기", FileDialog.LOAD);
			fd.setVisible(true);
			String file = fd.getFile();
			String path = fd.getDirectory();
			if(path == null || file == null){
				return;
			}
			f = new File(path, file);
			data.clear();
			iii=1;
			if(iii==1){
				x=0; y=0; w=0; h=0; flag = 0; color=Color.white; rrw = 0; rrh=0; fill = 0;
				repaint();
			}
			iii=0;
			x=0; y=0; w=0; h=0; flag = 0; color=Color.black; rrw = 0; rrh=0; fill = 0;
			repaint();
			draw.setState(true);
			loadData(f);
		}

		if(e.getSource() == msave){
			fd = new FileDialog(this,"파일저장",FileDialog.SAVE);
			fd.setVisible(true);
			String path = fd.getDirectory();
			String file = fd.getFile();
			if(path == null || file == null){
				return;
			}
			f = new File(path,file);
			saveData(f);
		}			
		
		if(e.getSource() == bt_c[0]){
			color = new Color(255,255,255);
		}
		if(e.getSource() == bt_c[1]){
			color = new Color(0,0,0);
		}
		if(e.getSource() == bt_c[2]){
			color = new Color(200,255,0);
		}
		if(e.getSource() == bt_c[3]){
			color = new Color(150,30,0);
		}
		if(e.getSource() == bt_c[4]){
			color = new Color(255,0,0);
		}
		if(e.getSource() == bt_c[5]){
			color = new Color(170,37,243);
		}
		if(e.getSource() == bt_c[6]){
			color = new Color(0,170,0);
		}
		if(e.getSource() == bt_c[7]){
			color = new Color(0,0,255);
		}
		if(e.getSource() == bt_c[8]){
			color = new Color(0,255,0);
		}
		if(e.getSource() == bt_c[9]){
			color = new Color(0,255,234);
		}
		if(e.getSource() == mclear_yes){
			data.clear();
			x=0;y=0;w=0;h=0;  flag=0; //color= Color.black;
			repaint();
			draw.setState(true);
			mclear_dia.setVisible(false);
			
		}
		if(e.getSource() == mclear_no){
			mclear_dia.setVisible(false);
		}
	}

	public void loadData(File file){		
		ObjectInputStream ois = null;
		try{
			ois = new ObjectInputStream(new FileInputStream(file));
			x=0;y=0;//문서열 기존 x,y값 때문에 점찍힘. 방지
			while(true){
				preparingPaintBox jum = (preparingPaintBox)ois.readObject();
				data.add(jum);
			}
		}catch(NullPointerException e){
			System.out.println(e);
		}catch(EOFException e){
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{if(ois != null)ois.close();}catch(IOException e){}
		}
	}
		

	public void saveData(File file){
		ObjectOutputStream oos = null;
		try{
			oos = new ObjectOutputStream(new FileOutputStream(file));
			for(int i=0;i<data.size();i++){
				preparingPaintBox jum = data.elementAt(i);
				oos.writeObject(jum);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{if(oos != null)oos.close();}catch(IOException e){}
		}
	}
	
	public void mouseClicked(MouseEvent e){	}
	public void mousePressed(MouseEvent e){
		if(e.getSource() == draw){
			flag=0;
			cc=0;//지우개 초기화
		}
		if(e.getSource() == line){
			flag= 1;
			cc=0;
		}
		if(e.getSource() == rect){		
			flag = 2;
			cc=0;
		}
		if(e.getSource() == roundRect){
			flag=3;
			cc=0;
		}
		if(e.getSource() == oval){		
			flag=4;
			cc=0;
		}
		if(e.getSource() == this){
			x = e.getX(); y=e.getY();
		}
		if(e.getSource() == clear){
			x=0;y=0;
			cc=1;//지우개 선택해라.
			cc_select = 10;
			flag=0;
			repaint();//다시그리자!!
		}
		if(e.getSource() == clear1){//큰지우개
			x=0;y=0;
			cc=1;//지우개 선택해라.
			cc_select = 30;
			flag=0;
			repaint();//다시그리자!!
		}
		if(e.getSource() == c_fill){//채우기
			fill = 1;
		}

		if(e.getSource() == c_nofill){
			fill = 0;
		}
	}
	public void mouseReleased(MouseEvent e){
		if(e.getSource() == this){
			w = e.getX(); h=e.getY();
			repaint();

			if(flag==1){
			preparingPaintBox jum = new preparingPaintBox(flag,fill,color,x,y,w,h);
			data.add(jum);
			}
			if(flag == 2){//사각형
				if(w>x && h>y){ preparingPaintBox jum = new preparingPaintBox(flag,fill,color,x,y,w-x,h-y); data.add(jum);}
				else if(w>x&& y>h){ preparingPaintBox jum = new preparingPaintBox(flag,fill,color,x,h,w-x,y-h); data.add(jum);}
				else if(x>w && y>h){ preparingPaintBox jum = new preparingPaintBox(flag,fill,color,w,h,x-w,y-h); data.add(jum);}
				else{ preparingPaintBox jum = new preparingPaintBox(flag,fill,color,w,y,x-w,h-y); data.add(jum);}
			}
			if(flag == 3){//둥근사각형
				if(w>x && h>y){	preparingPaintBox jum = new preparingPaintBox(flag,fill,color,x,y,w-x,h-y,rrw,rrh); data.add(jum);}
				else if(w>x&& y>h){preparingPaintBox jum = new preparingPaintBox(flag,fill,color,x,h,w-x,y-h,rrw,rrh); data.add(jum);}
				else if(x>w && y>h) {preparingPaintBox jum = new preparingPaintBox(flag,fill,color,w,h,x-w,y-h,rrw,rrh); data.add(jum);}
				else {preparingPaintBox jum = new preparingPaintBox(flag,fill,color,w,y,x-w,h-y,rrw,rrh); data.add(jum);}
			}
			if(flag == 4){//동그라미
				if(w>x && h>y)	{preparingPaintBox jum = new preparingPaintBox(flag,fill,color,x,y,w-x,h-y); data.add(jum);}
				else if(w>x&& y>h) {preparingPaintBox jum = new preparingPaintBox(flag,fill,color,x,h,w-x,y-h); data.add(jum);}
				else if(x>w && y>h){ preparingPaintBox jum = new preparingPaintBox(flag,fill,color,w,h,x-w,y-h); data.add(jum);}
				else {preparingPaintBox jum = new preparingPaintBox(flag,fill,color,w,y,x-w,h-y); data.add(jum);}
			}
		}
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseMoved(MouseEvent e){
		lb_x.setText(String.valueOf(e.getX()));
		lb_y.setText(String.valueOf(e.getY()));
	}
	public void mouseDragged(MouseEvent e){
		if(e.getSource() == this){
			w = e.getX();
			h = e.getY();
			repaint();
		}
		if(flag==0){
			if(cc==0){
				preparingPaintBox jum = new preparingPaintBox(flag,fill,color,w,h,5,5);
				data.add(jum);
			}else{
				preparingPaintBox jum = new preparingPaintBox(flag,fill,Color.white,w,h,cc_select,cc_select);//지우개 색상
				data.add(jum);
			}
		}
	}

	public void update(Graphics g){
		Dimension d = getSize();
		if(bufferGraphics == null){
			bufferImage = createImage(d.width, d.height);
			bufferGraphics = bufferImage.getGraphics();
		}
		bufferGraphics.setColor(getBackground());
		bufferGraphics.fillRect(0,0,d.width,d.height);
		
		vector(g);
		if(flag==1){//선인가
			bufferGraphics.setColor(color);
			bufferGraphics.drawLine(x,y,w,h);
		}else if(flag == 2){//사각형인가
			bufferGraphics.setColor(color);
			if(fill==0){
				if(w>x && h>y)	bufferGraphics.drawRect(x,y,w-x,h-y);
				else if(w>x&& y>h) bufferGraphics.drawRect(x,h,w-x,y-h);
				else if(x>w && y>h) bufferGraphics.drawRect(w,h,x-w,y-h);
				else bufferGraphics.drawRect(w,y,x-w,h-y);
			}else{
				if(w>x && h>y)	bufferGraphics.fillRect(x,y,w-x,h-y);
				else if(w>x&& y>h) bufferGraphics.fillRect(x,h,w-x,y-h);
				else if(x>w && y>h) bufferGraphics.fillRect(w,h,x-w,y-h);
				else bufferGraphics.fillRect(w,y,x-w,h-y);
			}
		}else if(flag == 3){//라운드 사각형인가
			bufferGraphics.setColor(color);
			if(fill==0){
				if(w>x && h>y)	bufferGraphics.drawRoundRect(x,y,w-x,h-y,rrw,rrh);
				else if(w>x&& y>h) bufferGraphics.drawRoundRect(x,h,w-x,y-h,rrw,rrh);
				else if(x>w && y>h) bufferGraphics.drawRoundRect(w,h,x-w,y-h,rrw,rrh);
				else bufferGraphics.drawRoundRect(w,y,x-w,h-y,rrw,rrh);
			}else{
				if(w>x && h>y)	bufferGraphics.fillRoundRect(x,y,w-x,h-y,rrw,rrh);
				else if(w>x&& y>h) bufferGraphics.fillRoundRect(x,h,w-x,y-h,rrw,rrh);
				else if(x>w && y>h) bufferGraphics.fillRoundRect(w,h,x-w,y-h,rrw,rrh);
				else bufferGraphics.fillRoundRect(w,y,x-w,h-y,rrw,rrh);
			}
		}else if(flag == 4){//동그라미 인가
			bufferGraphics.setColor(color);
			if(fill==0){
				if(w>x && h>y)	bufferGraphics.drawOval(x,y,w-x,h-y);
				else if(w>x&& y>h) bufferGraphics.drawOval(x,h,w-x,y-h);
				else if(x>w && y>h) bufferGraphics.drawOval(w,h,x-w,y-h);
				else bufferGraphics.drawOval(w,y,x-w,h-y);
			}else{
				if(w>x && h>y)	bufferGraphics.fillOval(x,y,w-x,h-y);
				else if(w>x&& y>h) bufferGraphics.fillOval(x,h,w-x,y-h);
				else if(x>w && y>h) bufferGraphics.fillOval(w,h,x-w,y-h);
				else bufferGraphics.fillOval(w,y,x-w,h-y);
			}
		}else{//선인가
			if(cc==0){
				bufferGraphics.setColor(color);
				bufferGraphics.fillOval(x,y,5,5);
			}else{
				bufferGraphics.setColor(Color.white);
				bufferGraphics.fillOval(x,y,cc_select,cc_select);
			}
		}
		paint(g);
	}
	/*그리자*/
	public void paint(Graphics g){
		if(bufferImage != null){
			g.drawImage(bufferImage,0,0,this);
		}
	}

	public void setEvent(){//check box - > mouseListener : 체크된 상태에서 한번더 체크해도 수행되게하기 위함
		// 그림 그리는 수단 선택
		draw.addMouseListener(this);
		line.addMouseListener(this);
		rect.addMouseListener(this);
		roundRect.addMouseListener(this);
		oval.addMouseListener(this);
		
		// 좌표얻기
		addMouseListener(this);
		addMouseMotionListener(this);
		
		// 메뉴
		mclear.addActionListener(this);
		mopen.addActionListener(this);
		msave.addActionListener(this);
		mexit.addActionListener(this);

		m_green.addItemListener(this);//클릭해서 -> 체크해제 (actionListener 사용안됨)
		m_yellow.addItemListener(this);
		m_pink.addItemListener(this);
		m_sky.addItemListener(this);


		// 다이얼로그(초기화)
		mclear_dia.addWindowListener(this);
		mclear_yes.addActionListener(this);
		mclear_no.addActionListener(this);
		
		// rgb text
		r_col.addKeyListener(this);//키 입력시마다 레이블 색 변화
		g_col.addKeyListener(this);
		b_col.addKeyListener(this);

		addWindowListener(this);
		// 색상 버튼
		for(int i=0;i<10;i++){
			bt_c[i].addActionListener(this);
		}
		// 지우개
		clear.addMouseListener(this);
		clear1.addMouseListener(this);
		// 채우기
		c_fill.addMouseListener(this);
		c_nofill.addMouseListener(this);
	}
	public void vector(Graphics g){
		for(int i = 0 ; i<data.size(); i++){
			preparingPaintBox jum = data.elementAt(i);
			if(jum.getFlag() == 1){//선
				bufferGraphics.setColor(jum.getColor());
				bufferGraphics.drawLine(jum.getX(),jum.getY(),jum.getW(),jum.getH());
			
			}else if(jum.getFlag() ==2){//사각형
				bufferGraphics.setColor(jum.getColor());
				if(jum.getFill() == 1){
					bufferGraphics.fillRect(jum.getX(),jum.getY(),jum.getW(),jum.getH());
				}else{
					bufferGraphics.drawRect(jum.getX(),jum.getY(),jum.getW(),jum.getH());
				}
			}else if(jum.getFlag() ==3){//둥근사각형
				bufferGraphics.setColor(jum.getColor());
				if(jum.getFill() == 1){
					bufferGraphics.fillRoundRect(jum.getX(),jum.getY(),jum.getW(),jum.getH(),jum.getRrw(),jum.getRrh());
				}else{
					bufferGraphics.drawRoundRect(jum.getX(),jum.getY(),jum.getW(),jum.getH(),jum.getRrw(),jum.getRrh());
				}
			}else if(jum.getFlag() ==4){//동그라미
				bufferGraphics.setColor(jum.getColor());
				if(jum.getFill() == 1){
					bufferGraphics.fillOval(jum.getX(),jum.getY(),jum.getW(),jum.getH());
				}else{
					bufferGraphics.drawOval(jum.getX(),jum.getY(),jum.getW(),jum.getH());
				}
			}else{//점
				bufferGraphics.setColor(jum.getColor());
				bufferGraphics.fillOval(jum.getX(),jum.getY(),jum.getW(),jum.getH());
			}
		}
	}
	
	/*레이아웃*/
	public void setForm(){
		//menuBar
		setMenuBar(mb);
		mb.add(mfile);
		mfile.add(mclear); mfile.addSeparator();
		mfile.add(mopen); mfile.add(msave);
		mfile.addSeparator();  mfile.add(mexit);
		mb.add(mbg);
		mbg.add(m_pink); mbg.add(m_green); mbg.add(m_yellow); mbg.add(m_sky);
		
		//layout
		font = new Font("굴림체",Font.BOLD,12);
		setBackground(Color.white);	
		p_cg = new Panel(new FlowLayout());
			p_cg.add(draw).setBackground(back_color);
			p_cg.add(line).setBackground(back_color);
			p_cg.add(rect).setBackground(back_color);
			p_cg.add(roundRect).setBackground(back_color);
			p_cg.add(oval).setBackground(back_color);		
		add("South",p_cg).setBackground(back_color);

		up = new Panel(new FlowLayout(FlowLayout.RIGHT));
			up.add(lb_xx).setBackground(back_color);
			up.add(lb_x).setBackground(Color.white);
			up.add(lb[0]).setBackground(back_color);
			up.add(lb_yy).setBackground(back_color);
			up.add(lb_y).setBackground(Color.white);
			up.add(lb[1]).setBackground(back_color);
			up.add(lb[2]).setBackground(back_color);
			up.add(lb[3]).setBackground(back_color);
		add("North",up).setBackground(back_color);
		add("East",lb[4]).setBackground(back_color);

		p_side = new Panel(new GridLayout(3,1));//sidebar -> up : 색상선택 , center - > 지우개 채우기 , footer -> RGB
			p_sidebar = new Panel(new BorderLayout());//side_no1 : 테두리
				p_sidebar.add("West",lb[5]); p_sidebar.add("East", lb[6]); p_sidebar.add("North", lb[7]); p_sidebar.add("South", lb[8]);
					p_c_allbt = new Panel(new BorderLayout(3,3));// up_botton 색상선택
						p_c_bt = new Panel(new GridLayout(5,2,5,5));
							p_c_bt.add(bt_c[0]).setBackground(new Color(255,255,255));
							p_c_bt.add(bt_c[1]).setBackground(new Color(0,0,0));
							p_c_bt.add(bt_c[2]).setBackground(new Color(200,255,0));
							p_c_bt.add(bt_c[3]).setBackground(new Color(150,30,0));
							p_c_bt.add(bt_c[4]).setBackground(new Color(255,0,0));
							p_c_bt.add(bt_c[5]).setBackground(new Color(170,37,243));
							p_c_bt.add(bt_c[6]).setBackground(new Color(0,170,0));
							p_c_bt.add(bt_c[7]).setBackground(new Color(0,0,255));
							p_c_bt.add(bt_c[8]).setBackground(new Color(0,250,0));
							p_c_bt.add(bt_c[9]).setBackground(new Color(0,255,234));
						p_c_allbt.add("North",lb_select).setFont(font);
						p_c_allbt.add("Center", p_c_bt);
				p_sidebar.add("Center", p_c_allbt);
			p_side.add(p_sidebar).setBackground(back_color);
			
			//지우개, 채우기
			p_sidebar2 = new Panel(new BorderLayout());
				p_sidebar2.add("West",lb[9]); p_sidebar2.add("East",lb[10]); p_sidebar2.add("North",lb[11]); p_sidebar2.add("South",lb[12]);
					p_side_fill = new Panel(new GridLayout(7,1,5,5));
						p_side_fill.add(lb_clear).setFont(font);
						p_side_fill.add(clear);
						p_side_fill.add(clear1);
						p_side_fill.add(lb[13]);
						p_side_fill.add(lb_fill).setFont(font);
						p_side_fill.add(c_fill);
						p_side_fill.add(c_nofill);
				p_sidebar2.add("Center",p_side_fill);
			p_side.add(p_sidebar2).setBackground(back_color);

			//RGB
			p_sidebar3 = new Panel(new BorderLayout());//side_no2 : 테두리
				p_sidebar3.add("West",lb[14]); p_sidebar3.add("East", lb[15]); p_sidebar3.add("North", lb[16]); p_sidebar3.add("South", lb[17]);
				p_side_rgb = new Panel(new BorderLayout());//center -> rgb
					p_side_rgb.add("North",lb_s_rgb).setFont(font);;
						p_rgb_all = new Panel(new GridLayout(2,1,5,5));
							p_rgb_text = new Panel(new GridLayout(3,1,3,3));
								p_flow1 = new Panel(new FlowLayout(FlowLayout.LEFT));
									p_flow1.add(r_col);
								p_rgb_text.add(p_flow1);
								p_flow2 = new Panel(new FlowLayout(FlowLayout.LEFT));
									p_flow2.add(g_col);
								p_rgb_text.add(p_flow2);
								p_flow3 = new Panel(new FlowLayout(FlowLayout.LEFT));
									p_flow3.add(b_col);
								p_rgb_text.add(p_flow3);
							p_rgb_all.add(p_rgb_text);
							p_rgb_all.add(lb_rgb).setBackground(Color.black);
					p_side_rgb.add("Center", p_rgb_all);//RGB
				p_sidebar3.add("Center",p_side_rgb);
			p_side.add(p_sidebar3).setBackground(back_color);
		add("West",p_side).setBackground(back_color);
	}

	public void setDialog(){
		mclear_dia.setLayout(new BorderLayout());
		mclear_dia.add("Center",new Label("정말로 초기화하시겠습니까?",Label.CENTER)).setBackground(Color.white);
		Panel p_dia = new Panel(new GridLayout(1,2));
			p_dia.add(mclear_yes);
			p_dia.add(mclear_no);
		mclear_dia.add("South",p_dia);
		mclear_dia.setSize(200,100);
		Dimension dia_src = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dia_my = mclear_dia.getSize();
		mclear_dia.setLocation(dia_src.width/2 - dia_my.width/2,dia_src.height/2 - dia_my.height/2);
	}
	
	public static void main(String[] ar){
		new paintBox();
	}

	public void windowOpened(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		if(e.getSource() == mclear_dia){
			mclear_dia.setVisible(false);
		}else{
			System.exit(0);
		}
	}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
}