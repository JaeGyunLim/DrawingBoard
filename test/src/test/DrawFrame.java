package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class DrawFrame extends JFrame {

	private JPanel contentPane;
	Color color;	//�� ����
	DrawPoint bold;
	int btnSelect = 0; // ���� �׸��� ��ư ����
	private JTextField TextField; //���� ����
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawFrame frame = new DrawFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DrawFrame() {
		setTitle("�׸���");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DrawFrame.class.getResource("/test/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new DrawPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MenuOption = new JMenu("�ɼ�");
		menuBar.add(MenuOption);
		
		JMenuItem MItemColor = new JMenuItem("����");
		MenuOption.add(MItemColor);
		
		//�ɼ� - ����
		MItemColor.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String cmd = e.getActionCommand();
				if(cmd.equals("����"))
				{
					color = JColorChooser.showDialog(null, "Color", Color.BLACK);
				}
			}
		});
		
		JMenuItem MItemGet = new JMenuItem("�ҷ�����");
		MenuOption.add(MItemGet);
		
		JMenuItem MItemSave = new JMenuItem("����");
		MenuOption.add(MItemSave);
		
		JMenuItem MItemExit = new JMenuItem("������");
		MenuOption.add(MItemExit);
		
		//�ɼ� - ����� ���� ��� ����
		MItemExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		JPanel OptionPanel = new JPanel();
		contentPane.add(OptionPanel, BorderLayout.NORTH);
		
		JPanel ToolPanel = new JPanel();
		OptionPanel.add(ToolPanel);
		
		JToolBar toolBar = new JToolBar();
		ToolPanel.add(toolBar);
		
		JButton btnTextBox = new JButton("�ؽ�Ʈ����");
		toolBar.add(btnTextBox);
		
		JPanel FigurePanel = new JPanel();
		OptionPanel.add(FigurePanel);
		
		JToolBar toolBar_1 = new JToolBar();
		FigurePanel.add(toolBar_1);
		
		JButton btnPen = new JButton("��");
		toolBar_1.add(btnPen);
		
		JButton btnLine = new JButton("����");
		toolBar_1.add(btnLine);
		
		JButton btnOval = new JButton("��");
		toolBar_1.add(btnOval);
		
		JPanel SizePanel = new JPanel();
		OptionPanel.add(SizePanel);
		
		JToolBar toolBar_2 = new JToolBar();
		SizePanel.add(toolBar_2);
		
		TextField = new JTextField();
		toolBar_2.add(TextField);
		TextField.setColumns(2);
		
		JButton BtnSizeChange = new JButton("����");
		SizePanel.add(BtnSizeChange);
		
		BtnSizeChange.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//bold = (Integer.parseInt(TextField.getText().trim()));
			}
		});
		
		JPanel ColorPanel = new JPanel();
		OptionPanel.add(ColorPanel);
		
		JToolBar toolBar_3 = new JToolBar();
		ColorPanel.add(toolBar_3);
		
		
	}
}
