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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class t extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("±×¸²ÆÇ");
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MenuOption = new JMenu("\uC635\uC158");
		menuBar.add(MenuOption);
		
		JMenuItem MItemGet = new JMenuItem("\uBD88\uB7EC\uC624\uAE30");
		MenuOption.add(MItemGet);
		
		JMenuItem MItemSave = new JMenuItem("\uC800\uC7A5");
		MenuOption.add(MItemSave);
		MItemSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		JMenuItem MItemExit = new JMenuItem("\uB05D\uB0B4\uAE30");
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
		
		JButton btnPen = new JButton("\uD39C");
		toolBar.add(btnPen);
		
		JButton btnTextBox = new JButton("\uD14D\uC2A4\uD2B8\uC0C1\uC790");
		toolBar.add(btnTextBox);
		
		JPanel FigurePanel = new JPanel();
		OptionPanel.add(FigurePanel);
		
		JToolBar toolBar_1 = new JToolBar();
		FigurePanel.add(toolBar_1);
		
		JButton btnLine = new JButton("\uC120");
		toolBar_1.add(btnLine);
		
		JPanel SizePanel = new JPanel();
		OptionPanel.add(SizePanel);
		
		JToolBar toolBar_2 = new JToolBar();
		SizePanel.add(toolBar_2);
		
		JMenuBar menuBar_1 = new JMenuBar();
		toolBar_2.add(menuBar_1);
		
		JMenu SizeMenu = new JMenu("\uD06C\uAE30");
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
		
		JButton btnORANGE = new JButton("");
		btnORANGE.setBackground(Color.ORANGE);
		toolBar_3.add(btnORANGE);
		
		JButton btnYELLOW = new JButton("");
		btnYELLOW.setBackground(Color.YELLOW);
		toolBar_3.add(btnYELLOW);
		
		JButton btnGREEN = new JButton("");
		btnGREEN.setBackground(Color.GREEN);
		toolBar_3.add(btnGREEN);
		
		JButton btnBLUE = new JButton("");
		btnBLUE.setBackground(Color.BLUE);
		toolBar_3.add(btnBLUE);
		
		JButton btnPINK = new JButton("");
		btnPINK.setBackground(Color.PINK);
		toolBar_3.add(btnPINK);
		
		DrawPanel DrawPanel = new DrawPanel();
		contentPane.add(DrawPanel, BorderLayout.CENTER);
	}
	
	class DrawPanel extends JPanel{
		Point start;
		Point end;
		public DrawPanel(){
			this.addMouseListener(new DrawMouseListener());
		}
		class DrawMouseListener implements MouseListener{
			public void mousePressed(MouseEvent e){
				start = e.getPoint(); 
			}
			public void mouseReleased(MouseEvent e){
				end = e.getPoint(); 
				Graphics g = getGraphics();
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