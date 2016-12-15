package test;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyFrame extends JFrame{

	public MyFrame(){
		this.setTitle("그림판");
		this.setSize(500,300);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Test.class.getResource("/test/Palette-icon.png")));
		MyPanel mp = new MyPanel();
		this.add(mp);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		mp.setBackground(Color.WHITE);
		JLabel labela = new JLabel(); 
		JButton savebtn = new JButton("");
		JButton loadbtn = new JButton("불러오기");
		
		JToolBar saveBar = new JToolBar();
		saveBar.add(savebtn);
		saveBar.add(loadbtn);
		savebtn.setIcon(new ImageIcon(Test.class.getResource("/test/save-icon.png")));
		
		mp.add(saveBar);
		
		loadbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FileDialog fileDialog = new FileDialog(MyFrame.this, "파일 열기",FileDialog.LOAD);
				fileDialog.setVisible(true);
				String path = fileDialog.getDirectory() + fileDialog.getFile();
				System.out.println(path);
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Image image = toolkit.getImage(path);
				JLabel label = new JLabel(new ImageIcon(image));
				mp.add(label);
			}
		});
		
		
		savebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JFileChooser fileChooser = new JFileChooser();
				   fileChooser.setFileFilter(new FileNameExtensionFilter("PNG File","png"));
				   if (fileChooser.showSaveDialog(MyFrame.this) == JFileChooser.APPROVE_OPTION)
				   {
					   File file = fileChooser.getSelectedFile();				
					   BufferedImage image = new BufferedImage(mp.getWidth(), mp.getHeight()-30,BufferedImage.TYPE_INT_RGB);			
					   Graphics2D g2=(Graphics2D)image.getGraphics();

					   mp.paint(g2);

					   try {			   
						   ImageIO.write(image, "png", file);					
					   } catch (Exception ex) {

					   }
				   }
			}
		});
	}

}
