package win_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Win_Menu extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Win_Menu dialog = new Win_Menu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Win_Menu() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNewLabel = new JLabel("홍길동");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 10));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(152, 34, 104, 70);
			contentPanel.add(lblNewLabel);
		}
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				JMenu mnu_File = new JMenu("File");
				mnu_File.setMnemonic('F');
				menuBar.add(mnu_File);
				{
					JMenuItem mnu_Open = new JMenuItem("Open...");
					mnu_Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
					mnu_File.add(mnu_Open);
				}
				{
					JMenuItem mnu_Save = new JMenuItem("Save...");
					mnu_Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
					mnu_File.add(mnu_Save);
					
					mnu_File.addSeparator();
				}
				
				{
					JMenuItem mnu_Exit = new JMenuItem("Exit");
					mnu_File.add(mnu_Exit);
				}
			}
			{
				JMenu mnu_Edit = new JMenu("Edit");
				mnu_Edit.setMnemonic('E');
				menuBar.add(mnu_Edit);
				{
					JMenuItem mnu_Copy = new JMenuItem("Copy");
					mnu_Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
					mnu_Edit.add(mnu_Copy);
				}
				{
					JMenuItem mnu_Cut = new JMenuItem("Cut");
					mnu_Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
					mnu_Edit.add(mnu_Cut);
				}
				{
					JMenuItem mnu_Paste = new JMenuItem("Paste");
					mnu_Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
					mnu_Edit.add(mnu_Paste);
				}
			}
			{
				JMenu mnu_Color = new JMenu("Color");
				mnu_Color.setMnemonic('C');
				menuBar.add(mnu_Color);
				{
					JMenuItem mnu_Red = new JMenuItem("Red");
					mnu_Red.setMnemonic('r');
					mnu_Red.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							contentPanel.setBackground(Color.red);
						}
					});
					mnu_Red.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
					mnu_Color.add(mnu_Red);
				}
				{
					JMenuItem mnu_Green = new JMenuItem("Green");
					mnu_Green.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							contentPanel.setBackground(Color.green);
						}
					});
					mnu_Green.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
					mnu_Color.add(mnu_Green);
				}
				{
					JMenuItem mnu_Blue = new JMenuItem("Blue");
					mnu_Blue.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							contentPanel.setBackground(Color.blue);
						}
					});
					mnu_Blue.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
					mnu_Color.add(mnu_Blue);
				}
			}
			{
				JMenu mnu_Font = new JMenu("Font");
				mnu_Font.setMnemonic('O');
				menuBar.add(mnu_Font);
				{
					JMenu mnu_FontSize = new JMenu("Font Size");
					mnu_Font.add(mnu_FontSize);
					{
						JMenuItem mnu_FontSize_10 = new JMenuItem("10");
						mnu_FontSize_10.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 10));
							}
						});
						mnu_FontSize.add(mnu_FontSize_10);
					}
					{
						JMenuItem mnu_FontSize_20 = new JMenuItem("20");
						mnu_FontSize_20.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
							}
						});
						mnu_FontSize.add(mnu_FontSize_20);
					}
					{
						JMenuItem mntmNewMenuItem_3 = new JMenuItem("30");
						mntmNewMenuItem_3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
							}
						});
						mnu_FontSize.add(mntmNewMenuItem_3);
					}
				}
			}
		}
	}

}
