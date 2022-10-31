package win_project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Win_Test extends JDialog {

	private final JPanel contentPanel = new JPanel();

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
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
							JOptionPane.showMessageDialog(null, "열기 대화상자");
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
			}
		}
	}

}
