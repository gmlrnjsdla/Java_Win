package win_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Win_Test extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Win_Test dialog = new Win_Test();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Win_Test() {
		setTitle("Image_Viewer");
		setBounds(100, 100, 450, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JToolBar toolBar = new JToolBar();
			toolBar.setFloatable(false);
			toolBar.setBounds(0, 0, 434, 27);
			contentPanel.add(toolBar);
			
			ToolTipManager m = ToolTipManager.sharedInstance();
			m.setEnabled(true);
			m.setInitialDelay(1000);	// ms 
			m.setDismissDelay(10000);
			
			textField = new JTextField();
			textField.setToolTipText("상품명을 입력하세요");
			toolBar.add(textField);
			textField.setColumns(10);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setToolTipText("종류를 선택하세요");
			comboBox.addItem("컴퓨터");
			comboBox.addItem("비디오");
			comboBox.addItem("스피커");
			toolBar.add(comboBox);
		}
		
		JLabel lblPicture = new JLabel("");
		lblPicture.setHorizontalAlignment(SwingConstants.CENTER);
		lblPicture.setBounds(10, 37, 93, 90);
		contentPanel.add(lblPicture);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(115, 37, 295, 259);
		contentPanel.add(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				JMenu mnuFile = new JMenu("File");
				mnuFile.setMnemonic('F');
				menuBar.add(mnuFile);
				{
					JMenuItem mnuOpen = new JMenuItem("Open");
					mnuOpen.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
//							JOptionPane.showMessageDialog(null, "열기 대화상자");
							
							JFileChooser chooser = new JFileChooser();
							FileNameExtensionFilter filter = new FileNameExtensionFilter("그림파일", "png","gif","jpg");
							chooser.setFileFilter(filter);
							
							FileNameExtensionFilter filter2 = new FileNameExtensionFilter("텍스트","txt");
							chooser.addChoosableFileFilter(filter2);
							chooser.setCurrentDirectory(new File("C:/"));
							
							int ret = chooser.showOpenDialog(null);
							if(ret == JFileChooser.APPROVE_OPTION) {								
								String fileName = chooser.getSelectedFile().getPath();
//								JOptionPane.showMessageDialog(null, fileName);
								ImageIcon image = new ImageIcon(fileName);
								Image pic = image.getImage();
								pic = pic.getScaledInstance(lblPicture.getWidth(),
										lblPicture.getHeight(), Image.SCALE_SMOOTH);
								ImageIcon image1 = new ImageIcon(pic);
								lblPicture.setIcon(image1);
							}
							else if (ret == JFileChooser.CANCEL_OPTION) {
								JOptionPane.showMessageDialog(null, "취소 버튼");
							}
							else {
								JOptionPane.showMessageDialog(null, "버튼");
							}
						}
					});
					mnuOpen.setMnemonic('O');
					mnuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
					mnuFile.add(mnuOpen);
				}
				{
					JMenuItem mnuSave = new JMenuItem("Save...");
					mnuSave.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(null, "저장 대화상자");
						}
					});
					mnuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
					mnuSave.setMnemonic('S');
					mnuFile.add(mnuSave);
				}
				mnuFile.addSeparator();
				{
					JMenuItem mnuExit = new JMenuItem("Exit");
					mnuExit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
						}
					});
					mnuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
					mnuExit.setMnemonic('X');
					mnuFile.add(mnuExit);
				}
			}
			{
				JMenu mnuColor = new JMenu("Color");
				mnuColor.setMnemonic('C');
				menuBar.add(mnuColor);
				{
					JMenuItem mnuRed = new JMenuItem("RED");
					mnuRed.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
					mnuRed.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							contentPanel.setBackground(Color.red);
						}
					});
					mnuColor.add(mnuRed);
				}
				{
					JMenuItem mnuGreen = new JMenuItem("GREEN");
					mnuGreen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
					mnuGreen.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							contentPanel.setBackground(Color.green);
						}
					});
					mnuColor.add(mnuGreen);
				}
				{
					JMenuItem mnuBlue = new JMenuItem("BLUE");
					mnuBlue.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
					mnuBlue.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							contentPanel.setBackground(Color.blue);
						}
					});
					mnuColor.add(mnuBlue);
				}
				{
					JCheckBoxMenuItem ckmnuRed = new JCheckBoxMenuItem("Red");
					ckmnuRed.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(ckmnuRed.isSelected()) {
								contentPanel.setBackground(Color.red);
							}
							else {
								contentPanel.setBackground(Color.white);
							}
						}
					});
					mnuColor.add(ckmnuRed);
				}
			}
			
			JMenu mnuText = new JMenu("Text");
			menuBar.add(mnuText);
			
			JMenuItem mntmNewMenuItem = new JMenuItem("텍스트 열기...");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser chooser = new JFileChooser();
					
					FileNameExtensionFilter filter = new FileNameExtensionFilter("텍스트","txt");
					chooser.setFileFilter(filter);
					chooser.setCurrentDirectory(new File("C:/"));
					
					int ret = chooser.showOpenDialog(null);
					
					if(ret == JFileChooser.APPROVE_OPTION) {								
						//File 읽기
						String fileName = chooser.getSelectedFile().getPath();
						try {
							FileReader fr = new FileReader(fileName);
							int c;
							String temp = null;
							while((c=fr.read()) != -1) {
								temp = temp + (char)c;
							}
							textArea.setText(temp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					else if (ret == JFileChooser.CANCEL_OPTION) {
						JOptionPane.showMessageDialog(null, "취소 버튼");
					}
					else {
						JOptionPane.showMessageDialog(null, "버튼");
					}
				}
			});
			mnuText.add(mntmNewMenuItem);
		}
	}
}
