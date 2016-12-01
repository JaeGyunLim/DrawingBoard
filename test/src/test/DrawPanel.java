package test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;


public class DrawPanel extends JPanel {
	
	private Vector<DrawPoint> vecStartPoint;
	private Vector<DrawPoint> vecEndPoint;	
	private DrawPoint startPoint;
	private DrawPoint endPoint;

	Point start = null;
	Point end = null;
	Color color;	//색 지정
	float bold = 3; //굵기
	int btnSelect = 0; //버튼 선택 < 초기는 펜으로 설정
	
	public DrawPanel()
	{
		vecStartPoint = new Vector<DrawPoint>();
		vecEndPoint = new Vector<DrawPoint>();
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub	
				end = e.getPoint();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub	
				end = e.getPoint();
				repaint();				
			}
		});
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y = e.getY();
				
				endPoint = new DrawPoint();
				endPoint.setX(x);
				endPoint.setY(y);
				
				vecStartPoint.add(startPoint);
				vecEndPoint.add(endPoint);
				repaint();											 
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				start = e.getPoint();
				int x = e.getX();
				int y = e.getY();
				
				startPoint = new DrawPoint();
				startPoint.setX(x);
				startPoint.setY(y);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		
		Graphics gr = getGraphics();
		g.setColor(color);
		Graphics2D g2d = (Graphics2D)gr;
		g2d.setStroke(new BasicStroke(bold));
		
		
		if(btnSelect == 0) // 펜으로 그리기
		{
			if(start != null)
			{
				g.drawLine(start.x, start.y, end.x, end.y);
			}
			for(int i = 0; i < vecStartPoint.size() ; i++)
			{
				
				int x1 = vecStartPoint.get(i).getX();
				int y1 = vecStartPoint.get(i).getY();
				int x2 = vecEndPoint.get(i).getX();
				int y2 = vecEndPoint.get(i).getY();		
				g.drawLine(x1, y1, x2, y2);
			}			
		}
		
		else if(btnSelect == 1) // 직선 그리기
		{
			
		}
		
		else if(btnSelect == 2) // 원 그리기
		{
			
		}
		
	}
}
