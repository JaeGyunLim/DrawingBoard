package test;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame{

	public MyFrame(){
		this.setTitle("aa");
		this.setSize(300,250);
		
		MyPanel mp = new MyPanel();
		this.add(mp);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
