import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WinTest01 extends JFrame {

	private JPanel contentPane;
	private JTextField tf_id;
	private JTextField tf_pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinTest01 frame = new WinTest01();
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
	public WinTest01() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 327, 192);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(35, 35, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("패스워드");
		lblNewLabel_1.setBounds(35, 66, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		tf_id = new JTextField();
		tf_id.setBounds(104, 32, 159, 21);
		contentPane.add(tf_id);
		tf_id.setColumns(10);
		
		tf_pw = new JTextField();
		tf_pw.setBounds(104, 63, 159, 21);
		contentPane.add(tf_pw);
		tf_pw.setColumns(10);
		
		JButton btn_login = new JButton("로그인");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = tf_id.getText();
				String PW = tf_pw.getText();
				if(ID.equals("test") && PW.equals("1234")) {
					System.out.println("로그인 성공했습니다.");
					WinSuccess dlg = new WinSuccess();
					dlg.setVisible(true);
				}
				else {
					System.out.println("로그인 실패!");
					WinFail dlg1 = new WinFail();
					dlg1.setVisible(true);
				}
			}
		});
		btn_login.setBounds(166, 104, 97, 23);
		contentPane.add(btn_login);
	}

}
