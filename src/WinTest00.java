import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WinTest00 extends JFrame {

	private JPanel contentPane;
	private JTextField txt2;
	private JTextField txt1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinTest00 frame = new WinTest00();
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
	public WinTest00() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 192);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		txt1 = new JTextField();
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		JButton btnNewButton = new JButton("실행");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int first = Integer.parseInt(txt1.getText());
				int last = Integer.parseInt(txt2.getText());
				int i, sum = 0;
				for(i=first; i<=last; i++) {
					sum=sum+i;
				}
				System.out.println("합은 "+sum+"입니다.");
			}
		});
		contentPane.add(btnNewButton);
	}

}
