package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class t extends JFrame {

	private JPanel contentPane;
	Color color;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					t frame = new t();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public t() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(t.class.getResource("/test/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("그림판");
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MenuOption = new JMenu("옵션");
		menuBar.add(MenuOption);
		
		JMenuItem MItemColor = new JMenuItem("색상");
		MenuOption.add(MItemColor);		
		
		MItemColor.addActionListener(new ActionListener()
		{
			JColorChooser chooser = new JColorChooser();
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String cmd = e.getActionCommand();
				if(cmd.equals("색상"))
				{
					color = chooser.showDialog(null, "Color", Color.BLACK);
				}
			}
		});
		JMenuItem MItemGet = new JMenuItem("불러오기");
		MenuOption.add(MItemGet);
		
		JMenuItem MItemSave = new JMenuItem("저장");
		MenuOption.add(MItemSave);
		MItemSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenuItem MItemExit = new JMenuItem("나가기");
		MenuOption.add(MItemExit);
		MItemExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel OptionPanel = new JPanel();
		contentPane.add(OptionPanel, BorderLayout.NORTH);
		OptionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel ToolPanel = new JPanel();
		OptionPanel.add(ToolPanel);
		
		JToolBar toolBar = new JToolBar();
		ToolPanel.add(toolBar);
		
		JButton btnPen = new JButton("펜");
		toolBar.add(btnPen);
		
		JButton btnTextBox = new JButton("텍스트상자");
		toolBar.add(btnTextBox);
		
		JPanel FigurePanel = new JPanel();
		OptionPanel.add(FigurePanel);
		
		JToolBar toolBar_1 = new JToolBar();
		FigurePanel.add(toolBar_1);
		
		JButton btnLine = new JButton("선");
		toolBar_1.add(btnLine);
		
		JPanel SizePanel = new JPanel();
		OptionPanel.add(SizePanel);
		
		JToolBar toolBar_2 = new JToolBar();
		SizePanel.add(toolBar_2);
		
		JMenuBar menuBar_1 = new JMenuBar();
		toolBar_2.add(menuBar_1);
		
		JMenu SizeMenu = new JMenu("크기");
		menuBar_1.add(SizeMenu);
		
		JMenuItem MItemSize_1px = new JMenuItem("1px");
		SizeMenu.add(MItemSize_1px);
		
		JMenuItem MItemSize_2px = new JMenuItem("2px");
		SizeMenu.add(MItemSize_2px);
		
		JMenuItem MItemSize_3px = new JMenuItem("3px");
		SizeMenu.add(MItemSize_3px);
		
		JPanel ColorPanel = new JPanel();
		OptionPanel.add(ColorPanel);
		
		JToolBar toolBar_3 = new JToolBar();
		ColorPanel.add(toolBar_3);
		
		JButton btnRED = new JButton("");
		btnRED.setBackground(Color.RED);
		toolBar_3.add(btnRED);
		btnRED.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.RED;
			}
		});
		
		JButton btnORANGE = new JButton("");
		btnORANGE.setBackground(Color.ORANGE);
		toolBar_3.add(btnORANGE);
		
		btnORANGE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.ORANGE;
			}
		});
		
		JButton btnYELLOW = new JButton("");
		btnYELLOW.setBackground(Color.YELLOW);
		toolBar_3.add(btnYELLOW);
		
		btnYELLOW.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.YELLOW;
			}
		});
		
		JButton btnGREEN = new JButton("");
		btnGREEN.setBackground(Color.GREEN);
		toolBar_3.add(btnGREEN);
		
		btnGREEN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.GREEN;
			}
		});
		JButton btnBLUE = new JButton("");
		btnBLUE.setBackground(Color.BLUE);
		toolBar_3.add(btnBLUE);
		
		btnBLUE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.BLUE;
			}
		});
		JButton btnPINK = new JButton("");
		btnPINK.setBackground(Color.PINK);
		toolBar_3.add(btnPINK);
		
		btnPINK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.PINK;
			}
		});

		JButton btnBLACK = new JButton("");
		btnBLACK.setBackground(Color.BLACK);
		toolBar_3.add(btnBLACK);
		
		btnBLACK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.BLACK;
			}
		});
		
		JButton btnLIGHT_GRAY = new JButton("");
		btnLIGHT_GRAY.setBackground(Color.LIGHT_GRAY);
		toolBar_3.add(btnLIGHT_GRAY);
		
		btnLIGHT_GRAY.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.LIGHT_GRAY;
			}
		});
		
		JButton btnWHITE = new JButton("");
		btnWHITE.setBackground(Color.WHITE);
		toolBar_3.add(btnWHITE);
		
		btnWHITE.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				color = Color.WHITE;
			}
		});
		
		DrawPanel DrawPanel = new DrawPanel();
		contentPane.add(DrawPanel, BorderLayout.CENTER);
	}
	
	class DrawPanel extends JPanel{
		Point start;
		Point end;
		public DrawPanel(){
			this.addMouseListener(new DrawMouseListener());
			this.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
		class DrawMouseListener implements MouseListener{
			public void mousePressed(MouseEvent e){
				start = e.getPoint(); 
			}
			public void mouseReleased(MouseEvent e){
				end = e.getPoint(); 
				Graphics g = getGraphics();
				g.setColor(color);
				g.drawLine(start.x, start.y, end.x, end.y);
			}
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		}
	}
	
	

}