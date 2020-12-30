package lee.java.exam11;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonCatch extends Frame implements MouseListener {

   private static final long serialVersionUID = 1L;
   private Button bt = new Button("메롱~");
   
   public ButtonCatch() {
      super("스토커^^");
      setLayout(new FlowLayout());
      add(bt);
      // addMouseListener(this);
      bt.addMouseListener(this);
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
      setSize(600, 500);
      setVisible(true);
   }

   @Override
   public void mouseClicked(MouseEvent e) { }

   @Override
   public void mousePressed(MouseEvent e) { 
//      if(e.getSource() == this) {
//         bt.setLocation(e.getX(), e.getY());
//      }
   }

   @Override
   public void mouseReleased(MouseEvent e) { }

   @Override
   public void mouseEntered(MouseEvent e) { 
      if(e.getSource() == bt) {
         int x = (int)(Math.random() * 534) + 8;
         int y = (int)(Math.random() * 424) + 31;
         bt.setLocation(x, y);
      }
   }

   @Override
   public void mouseExited(MouseEvent e) {   }

   public static void main(String[] args) {
      new ButtonCatch();
   }
}

/*
 * 화면 가운데 띄우기 
Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
   Dimension my = getSize();
   setLocation(scr.width/2-my.width/2, scr.height/2-my.height/2);
*/ 
   
   
   
   