package win_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Win_TextArea extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private boolean bTurn = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win_TextArea frame = new Win_TextArea();
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
	public Win_TextArea() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				textField.setFocusable(true);
				textField.requestFocus();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		textField = new JTextField();
		textField.setText("채팅");
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String text = textField.getText();
				
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(bTurn) {
						textArea.append("[길동] : "+text+"\n");
//						bTurn = false;
					}
					else {
						textArea.append("[길순] : "+text+"\n");
//						bTurn = true;
					}
					bTurn = !bTurn;
					textField.setText("");
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("입력 후 <ENTER>");
		panel_1.add(lblNewLabel);
		panel_1.add(textField);
		textField.setColumns(25);
	}

}
