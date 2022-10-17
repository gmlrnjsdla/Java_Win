import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WinCalendar extends JFrame {

	private JPanel contentPane;
	private JTextField tf_year;
	private JTextField tf_month;
	private JPanel calendar_panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinCalendar frame = new WinCalendar();
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
	public WinCalendar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lbl_year = new JLabel("년도");
		panel.add(lbl_year);
		
		tf_year = new JTextField();
		tf_year.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_year.setText("2022");
		panel.add(tf_year);
		tf_year.setColumns(10);
		
		JLabel lbl_Month = new JLabel("월");
		panel.add(lbl_Month);
		
		tf_month = new JTextField();
		tf_month.setText("10");
		tf_month.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(tf_month);
		tf_month.setColumns(10);
		
		JButton btnNewButton = new JButton("달력보기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int month = Integer.parseInt(tf_month.getText());
				int day[] = {31,28,31,30,31,30,31,31,30,31,30,31};
				int lastday = day[month-1];
				int year = Integer.parseInt(tf_year.getText());
				
				
				
				for(int i=1; i<=lastday; i++) {
					JButton btn = new JButton(Integer.toString(i)); 		
					calendar_panel.add(btn); 
				}
				calendar_panel.revalidate();
				
			}
		});
		panel.add(btnNewButton);
		
		calendar_panel = new JPanel();
		contentPane.add(calendar_panel, BorderLayout.CENTER);
		calendar_panel.setLayout(new GridLayout(0, 7, 0, 0));
		
	}

}
