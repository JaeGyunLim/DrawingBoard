package test;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame{

	public MyFrame(){
		this.setTitle("±×¸²ÆÇ");
		this.setSize(500,300);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Test.class.getResource("/test/Palette-icon.png")));
		MyPanel mp = new MyPanel();
		this.add(mp);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
