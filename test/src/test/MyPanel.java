package test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class MyPanel extends JPanel  implements ActionListener,MouseListener,MouseMotionListener { 
	
	public JButton freebtn;
	public JButton linebtn;
	public JButton nemobtn;
	public JButton onebtn;
	public JButton colorbtn;
	public JButton eraserbtn;
	public JButton boldbtn;
	public JButton eraSelBtn;
	
	public JToolBar drawBar;
	public JToolBar toolBar;
	public JToolBar boldBar;
	
	public JTextField boldText;
	
	public Color color;
	public int selector = 0;//선택 값
	public int bold = 1; 
	public String imagePath;
	BufferedImage image;
	
	public Vector<FreeLine> fLine = new Vector<FreeLine>();
	public FreeLine freeLine;//자유선(펜)
	
	public Vector<RightLine> rLine = new Vector<RightLine>();
	public RightLine rightLine;//직선
	
	public Vector<Square> squares = new Vector<Square>();
	public Square square;//사각형
	
	public Vector<Circle> circles = new Vector<Circle>();
	public Circle circle;//원
	
	public MyPanel(){
		drawBar = new JToolBar();
		toolBar = new JToolBar();
		boldBar = new JToolBar();
		
		freebtn = new JButton("");
		linebtn = new JButton("");
		nemobtn = new JButton("");
		onebtn = new JButton("");
		colorbtn = new JButton("");
		eraserbtn = new JButton("");
		boldbtn = new JButton("변경");
		eraSelBtn = new JButton("전체 지우기");
		
		boldText = new JTextField();
		boldText.setText(bold + "");
		boldText.setColumns(2);
		freebtn.setIcon(new ImageIcon(Test.class.getResource("/test/Pen-icon.png")));
		linebtn.setIcon(new ImageIcon(Test.class.getResource("/test/line-icon.png")));
		nemobtn.setIcon(new ImageIcon(Test.class.getResource("/test/square-icon.png")));
		onebtn.setIcon(new ImageIcon(Test.class.getResource("/test/oval-icon.png")));
		colorbtn.setIcon(new ImageIcon(Test.class.getResource("/test/Color-icon.png")));
		eraserbtn.setIcon(new ImageIcon(Test.class.getResource("/test/Eraser-icon.png")));
		
		drawBar.add(freebtn);
		drawBar.add(linebtn);
		drawBar.add(nemobtn);
		drawBar.add(onebtn);
		toolBar.add(colorbtn);
		toolBar.add(eraserbtn);
		boldBar.add(boldText);
		boldBar.add(boldbtn);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		freebtn.addActionListener(this);
		linebtn.addActionListener(this);
		nemobtn.addActionListener(this);
		onebtn.addActionListener(this);
		colorbtn.addActionListener(this);
		eraserbtn.addActionListener(this);
		boldbtn.addActionListener(this);
		eraSelBtn.addActionListener(this);
		
		this.add(drawBar);
		this.add(toolBar);
		this.add(boldBar);
		this.add(eraSelBtn);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(selector == 0){
			freeLine.addPoint(e.getX(),e.getY(),color,bold);
			repaint();
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(selector == 0){//자유선
			freeLine = new FreeLine();
			fLine.add(freeLine);
			freeLine.addPoint(e.getX(),e.getY(),color,bold);
		}
		else if(selector == 1){//직선
			rightLine = new RightLine();
			rLine.add(rightLine);
			rightLine.addPoint(e.getX(), e.getY(),color,bold);
		}
		else if(selector == 2){//사각형
			square = new Square();
			squares.add(square);
			square.addPoint(e.getX(), e.getY(),color,bold);
		}
		else if(selector == 3){//원
			circle = new Circle();
			circles.add(circle);
			circle.addPoint(e.getX(), e.getY(),color,bold);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(selector == 1){
			rightLine.addPoint(e.getX(), e.getY(),color,bold);
		}
		else if(selector == 2){
			square.addPoint(e.getX(), e.getY(),color,bold);
		}
		else if(selector == 3){
			circle.addPoint(e.getX(), e.getY(),color,bold);
		}
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton selectbtn = (JButton)e.getSource();
			
		if(selectbtn == freebtn){
			selector = 0;
		}
		else if(selectbtn == linebtn){
			selector = 1;
			
		}
		else if(selectbtn == nemobtn){
			selector = 2;
			
		}
		else if(selectbtn == onebtn){
			selector = 3;		
		}		
		else if(selectbtn == colorbtn){
			color = JColorChooser.showDialog(null, "Color", Color.BLACK);
		}		
		else if(selectbtn == eraserbtn){
			selector = 4;
		}
		else if(selectbtn == boldbtn)
		{
			bold = (Integer.parseInt(boldText.getText().trim()));
		}		
		else if(selectbtn == eraSelBtn)
		{
			selector = 5;
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		
		for (FreeLine fLines : fLine) {
        	if(fLines != null)
        		fLines.drawFreeLine(g);
        }
        for(RightLine rLines : rLine){
        	if(rLines != null)
        		rLines.drawRightLine(g);
        }
        for(Square squ : squares){
        	if(squ != null)
        		squ.drawSquare(g);
        }
        for(Circle cir : circles){
        	if(cir != null)
        		cir.drawCircle(g);
        }
		

	}
}
	

		

