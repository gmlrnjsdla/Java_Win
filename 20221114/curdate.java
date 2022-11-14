package win_project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class curdate extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfToday;
	private JTextField tfYear;
	private JTextField tfMonth;
	private JTextField tfDay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			curdate dialog = new curdate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public curdate() {
		setBounds(100, 100, 340, 282);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("오늘날짜");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(37, 55, 57, 15);
		contentPanel.add(lblNewLabel);
		
		tfToday = new JTextField();
		tfToday.setBounds(110, 52, 116, 21);
		contentPanel.add(tfToday);
		tfToday.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("년도");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(37, 122, 57, 15);
		contentPanel.add(lblNewLabel_1);
		
		tfYear = new JTextField();
		tfYear.setColumns(10);
		tfYear.setBounds(110, 119, 116, 21);
		contentPanel.add(tfYear);
		
		JLabel lblNewLabel_2 = new JLabel("월");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(37, 150, 57, 15);
		contentPanel.add(lblNewLabel_2);
		
		tfMonth = new JTextField();
		tfMonth.setColumns(10);
		tfMonth.setBounds(110, 147, 116, 21);
		contentPanel.add(tfMonth);
		
		JLabel lblNewLabel_3 = new JLabel("일");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(37, 178, 57, 15);
		contentPanel.add(lblNewLabel_3);
		
		tfDay = new JTextField();
		tfDay.setColumns(10);
		tfDay.setBounds(110, 175, 116, 21);
		contentPanel.add(tfDay);
		
		JLabel lblDiff = new JLabel("diff");
		lblDiff.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiff.setBounds(37, 27, 57, 15);
		contentPanel.add(lblDiff);
		
		JSpinner tfDiff = new JSpinner();
		tfDiff.setModel(new SpinnerNumberModel(Integer.valueOf(100), null, null, Integer.valueOf(10)));
		tfDiff.setBounds(110, 20, 116, 22);
		contentPanel.add(tfDiff);
		
		
		JButton btnNewButton = new JButton("Run");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection
							("jdbc:mysql://localhost:3306/sqldb", "root","1234");
					
					String diff = tfDiff.getValue().toString();
					String sql = "SELECT curdate(), ADDDATE(curdate(), INTERVAL "+diff+" DAY)";
					
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						String date = rs.getString(1);
						String date2 = rs.getString(2);
						tfToday.setText(date);
						
						tfYear.setText(date2.substring(0, 4)+"년");
						tfMonth.setText(date2.substring(5, 7)+"월");
						tfDay.setText(date2.substring(8, 10)+"일");
						
						
					}
					
					
					} catch (Exception e1) {
					e1.printStackTrace();
					}
			}
			
		});
		btnNewButton.setBounds(236, 52, 60, 21);
		contentPanel.add(btnNewButton);
		
		
		JLabel lblNewLabel_4 = new JLabel("▼");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(134, 90, 57, 15);
		contentPanel.add(lblNewLabel_4);
		
		
	}
}
