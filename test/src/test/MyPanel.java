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
	public int selector = 0;//���� ��
	public int bold = 1; 
	public String imagePath;
	BufferedImage image;
	
	public Vector<Point> freelines = new Vector<Point>();//���� ���� �׸��� x,y��ǥ ����
	
	public Vector<Point> lineStart = new Vector<Point>();//����
	public Vector<Point> lineEnd = new Vector<Point>();//����
	public Vector<Point> squareStart = new Vector<Point>();//����
	public Vector<Point> squareEnd = new Vector<Point>();//����
	public Vector<Point> circleStart = new Vector<Point>();//����
	public Vector<Point> circleEnd = new Vector<Point>();//����
	
	public Vector<Point> start = new Vector<Point>();
	public Vector<Point> end = new Vector<Point>();
	
	
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
		boldbtn = new JButton("����");
		eraSelBtn = new JButton("�κ� �����");
		
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
		freelines.add(e.getPoint());
		repaint();
		
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
		start.add(e.getPoint());
		
		if(selector == 0)
		freelines.add(e.getPoint());//������
		else if(selector == 1)
		lineStart.add(e.getPoint()); //����
		else if(selector == 2)
		squareStart.add(e.getPoint());//�׸�
		else if(selector == 3)
		circleStart.add(e.getPoint());//���׶��
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		end.add(e.getPoint());
		
		if(selector == 1)
		lineEnd.add(e.getPoint());
		else if(selector == 2)
		squareEnd.add(e.getPoint());
		else if(selector == 3)
		circleEnd.add(e.getPoint());
		
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
		int sx,sy,ex,ey,tx,ty;
		super.paintComponent(g);
		
		g.setColor(color);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(bold));
		
		if(selector == 0){//����
			
		}
		else if(selector == 1){//����		
			for(int i = 0; i < lineEnd.size();i++)
			{		
				Point start1 = lineStart.elementAt(i);
				Point end2 = lineEnd.elementAt(i);
				g.drawLine((int)start1.getX(), (int)start1.getY(), (int)end2.getX(), (int)end2.getY());
			}
			for(int i = 0; i < squareEnd.size();i++){
				
				if(i < squareStart.size()){
			
					Point start = squareStart.elementAt(i);
					Point end = squareEnd.elementAt(i);
					sx = (int) start.getX();
					sy = (int) start.getY();
					ex = (int) end.getX();
					ey = (int) end.getY();
					tx = ex - sx;
					ty = ey - ey;
					g.drawRect(sx, sy, ex - sx,ey - sy);

				}
			}
			for(int i = 0; i < circleEnd.size();i++)
			{
				if(i < circleStart.size()){
					Point start = circleStart.elementAt(i);
					Point end = circleEnd.elementAt(i);
					sx = (int) start.getX();
					sy = (int) start.getY();
					ex = (int) end.getX();
					ey = (int) end.getY();
					tx = ex - sx;
					ty = ey - ey;
					g.drawOval(sx, sy, ex - sx,ey - sy);
				}
			}
		}
		else if(selector == 2){//�׸�
			if(squareStart != null && squareEnd != null){
			
				for(int i = 0; i < lineEnd.size();i++)
				{		
					Point start1 = lineStart.elementAt(i);
					Point end2 = lineEnd.elementAt(i);
					g.drawLine((int)start1.getX(), (int)start1.getY(), (int)end2.getX(), (int)end2.getY());
				}
				for(int i = 0; i < squareEnd.size();i++){
				
					if(i < squareStart.size()){
				
						Point start = squareStart.elementAt(i);
						Point end = squareEnd.elementAt(i);
						sx = (int) start.getX();
						sy = (int) start.getY();
						ex = (int) end.getX();
						ey = (int) end.getY();
						tx = ex - sx;
						ty = ey - ey;
						g.drawRect(sx, sy, ex - sx,ey - sy);

					}
				}
				for(int i = 0; i < circleEnd.size();i++)
				{
					if(i < circleStart.size()){
						Point start = circleStart.elementAt(i);
						Point end = circleEnd.elementAt(i);
						sx = (int) start.getX();
						sy = (int) start.getY();
						ex = (int) end.getX();
						ey = (int) end.getY();
						tx = ex - sx;
						ty = ey - ey;
						g.drawOval(sx, sy, ex - sx,ey - sy);
					}
				}
			}
		}
		else if(selector == 3){//��
			if(circleStart != null && circleEnd != null)
			{
				for(int i = 0; i < lineEnd.size();i++)
				{		
					Point start1 = lineStart.elementAt(i);
					Point end2 = lineEnd.elementAt(i);
					g.drawLine((int)start1.getX(), (int)start1.getY(), (int)end2.getX(), (int)end2.getY());
				}
				for(int i = 0; i < squareEnd.size();i++){
					
					if(i < squareStart.size()){
				
						Point start = squareStart.elementAt(i);
						Point end = squareEnd.elementAt(i);
						sx = (int) start.getX();
						sy = (int) start.getY();
						ex = (int) end.getX();
						ey = (int) end.getY();
						tx = ex - sx;
						ty = ey - ey;
						g.drawRect(sx, sy, ex - sx,ey - sy);

					}
				}
				for(int i = 0; i < circleEnd.size();i++)
				{
					if(i < circleStart.size()){
						Point start = circleStart.elementAt(i);
						Point end = circleEnd.elementAt(i);
						sx = (int) start.getX();
						sy = (int) start.getY();
						ex = (int) end.getX();
						ey = (int) end.getY();
						tx = ex - sx;
						ty = ey - ey;
						g.drawOval(sx, sy, ex - sx,ey - sy);
					}
				}		
		
			}			
		
		}//��
		else if(selector == 4) //�ʱ�ȭ
		{
			g.clearRect(0, 0, 500, 300);
			freelines.clear();
	        lineStart.clear();
	        lineEnd.clear();
	        squareStart.clear();
	        squareEnd.clear();
	        circleStart.clear();
	        circleEnd.clear();
		}

	}
}
	

		

