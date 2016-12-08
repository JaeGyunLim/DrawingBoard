package test;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MyPanel extends JPanel  implements ActionListener,MouseListener,MouseMotionListener { 

	public JButton freebtn;
	public JButton linebtn;
	public JButton nemobtn;
	public JButton onebtn;
		
	public int selector = 0;//선택 값


	public Vector<Point> freelines = new Vector<Point>();//자유 도형 그리기 x,y좌표 저장
	
	public Vector<Point> lineStart = new Vector<Point>();//직선
	public Vector<Point> lineEnd = new Vector<Point>();//직선
	public Vector<Point> squareStart = new Vector<Point>();//직선
	public Vector<Point> squareEnd = new Vector<Point>();//직선
	public Vector<Point> circleStart = new Vector<Point>();//직선
	public Vector<Point> circleEnd = new Vector<Point>();//직선
	
	public Vector<Point> start = new Vector<Point>();
	public Vector<Point> end = new Vector<Point>();
	
	
	public MyPanel(){
		freebtn = new JButton("자유선");
		linebtn = new JButton("직선");
		nemobtn = new JButton("네모");
		onebtn = new JButton("원");
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		freebtn.addActionListener(this);
		linebtn.addActionListener(this);
		nemobtn.addActionListener(this);
		onebtn.addActionListener(this);
		
			
		this.add(freebtn);
		this.add(linebtn);
		this.add(nemobtn);
		this.add(onebtn);
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
		freelines.add(e.getPoint());//자유선
		else if(selector == 1)
		lineStart.add(e.getPoint()); //직선
		else if(selector == 2)
		squareStart.add(e.getPoint());//네모
		else if(selector == 3)
		circleStart.add(e.getPoint());//동그라미
		
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
	}
	
	public void paintComponent(Graphics g){
		int sx,sy,ex,ey,tx,ty;
		super.paintComponent(g);
		
		if(selector == 0){//자유
			
		}
		else if(selector == 1){//직선		
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
		else if(selector == 2){//네모
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
		else if(selector == 3){//원
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
		
		}//원
	}
}
	

		

