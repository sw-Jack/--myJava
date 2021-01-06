package lee.java.exam04;
//추가 : 배경색 바꾸기
import java.awt.*;
import java.awt.event.*;
import java.util.*;//vector
import java.io.*;//저장
class preparingPaintBox implements Serializable
{
	private int x; private int y; private int w; private int h; 
	private int rrw; private int rrh;
	private int flag; private int fill; private Color color; 
	public preparingPaintBox(){}
	public preparingPaintBox(int flag, int fill, Color color,  int x, int y, int w, int h){
		this.x=x;		this.y=y;		this.w=w;		this.h=h;		this.flag = flag;	this.fill = fill;	this.color = color;
	}
	public preparingPaintBox(int flag, int fill, Color color, int x, int y, int w, int h, int rrw, int rrh){
		this.x=x;		this.y=y;		this.w=w;		this.h=h;		this.flag = flag; 	this.fill = fill;	this.color = color;
		this.rrw = rrw;		this.rrh = rrh;
	}
	
	public int getX(){return x;}
	public int getY(){return y;}
	public int getW(){return w;}
	public int getH(){return h;}
	public int getRrw(){return rrw;}
	public int getRrh(){return rrh;}
	public int getFlag(){return flag;}
	public int getFill(){return fill;}
	public Color getColor(){return color;}
	
	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	public void setW(int w){this.w = w;}
	public void setH(int h){this.h = h;}
	public void setRrw(int rrw){this.rrw = rrw;}
	public void setRrh(int rrh){this.rrh = rrh;}
	public void setFlag(int flag){this.flag = flag;}
	public void setFill(int fill){this.fill = fill;};
	public void setColor(Color color){this.color = color;}
}
