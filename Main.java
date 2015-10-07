package denntaku;

import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



class MyLabel extends JLabel {
	public MyLabel(){
		super("0",RIGHT);
	}
	public ActionListener getActionListener(){
		return (event)->setText(event.getActionCommand());
	}
}
interface FrameConstant {
	int WIDTH = 300;
	int HEIGHT = 400;
	String TITLE = "http://www.2ch.net/";
}
class MyFrame extends JFrame {
	public void setCloseActionListener(ActionListener a){
		closeActionList.add(a);
	}
	private final LinkedList<ActionListener> closeActionList
	= new LinkedList<ActionListener>();
	class MyWindowListener extends WindowAdapter {
		@Override
		public void windowClosed(WindowEvent e){
			for(ActionListener listener : closeActionList){
				listener.actionPerformed(
						new ActionEvent(
								this,ActionEvent.ACTION_PERFORMED,"close"));
			}
		}
	}
	public MyFrame(){
		super();    
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new MyWindowListener());
		setSize(FrameConstant.WIDTH,FrameConstant.HEIGHT);
		setTitle(FrameConstant.TITLE);
	}
}

class Main {
	public static void main(String[] arg)   {
		final MyFrame frame = new MyFrame();
		final Keyboard keyboard = new Keyboard();
		frame.setCloseActionListener(keyboard.getCloseAction());
		final Container container = frame.getContentPane();
		container.add(keyboard.getPanel(), BorderLayout.CENTER);
		final MyLabel label = new MyLabel();
		label.setPreferredSize(new Dimension(100,50 ));
		label.setFont(new Font("Smudger LET", Font.PLAIN, 26));
		container.add(label,BorderLayout.NORTH);
		frame.setVisible(true);
		Parser parser = new Parser(keyboard);
		parser.setActionListener(label.getActionListener());
	}
    while(true){
    try{
    parser.start();
   }
 catch(Exception e){
 label.setText("ERROR");15
 parser = new Parser(keyboard);
 parser.setActionListener(label.getActionListener());
 }
catch(Error e){
label.setText("ERROR");
parser = new Parser(keyboard);
parser.setActionListener(label.getActionListener());
   }
  }
 }
}

