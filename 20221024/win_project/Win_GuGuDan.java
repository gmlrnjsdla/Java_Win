package win_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import java.awt.Color;

public class Win_GuGuDan extends JFrame {

	private JPanel contentPane;
	private JTextField txtILoveSchool;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win_GuGuDan frame = new Win_GuGuDan();
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
	public Win_GuGuDan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 15));
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("구구단 시작");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i =1 ; i<=9; i++) {
					for(int j=1; j<=9; j++) {
						textArea.append(i+" x "+j+" = "+(i*j)+"\n");	
					}
				}
				txtILoveSchool.requestFocus();
				txtILoveSchool.setSelectionStart(0 );
				txtILoveSchool.setSelectionEnd(txtILoveSchool.getText().length());
			}
		});
		panel.add(btnNewButton);
		
		txtILoveSchool = new JTextField();
		txtILoveSchool.setText("I LOVE SCHOOL");
		txtILoveSchool.setBackground(new Color(255, 255, 0));
		contentPane.add(txtILoveSchool, BorderLayout.SOUTH);
		txtILoveSchool.setColumns(10);
		
		
		
		
	}

}
