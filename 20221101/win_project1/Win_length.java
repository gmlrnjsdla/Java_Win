package win_project1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Win_length extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Win_length dialog = new Win_length();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Win_length() {
		setBounds(100, 100, 324, 269);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		tfValue = new JTextField();
		tfValue.setHorizontalAlignment(SwingConstants.RIGHT);
		tfValue.setText("100");
		tfValue.setBounds(30, 30, 116, 21);
		contentPanel.add(tfValue);
		tfValue.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("을(를)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(119, 68, 75, 18);
		contentPanel.add(lblNewLabel);
		
		JComboBox cbUnit2 = new JComboBox();
		cbUnit2.setModel(new DefaultComboBoxModel(new String[] {"단위선택", "밀리미터(mm)", "센티미터(cm)", "미터(m)", "킬로미터(km)"}));
		cbUnit2.setBounds(111, 96, 96, 23);
		contentPanel.add(cbUnit2);
		
		JLabel lblresult = new JLabel("결과");
		lblresult.setHorizontalAlignment(SwingConstants.CENTER);
		lblresult.setBounds(124, 172, 109, 15);
		contentPanel.add(lblresult);
		
		JComboBox cbUnit1 = new JComboBox();
		
		cbUnit1.setModel(new DefaultComboBoxModel(new String[] {"단위선택", "밀리미터(mm)", "센티미터(cm)", "미터(m)", "킬로미터(km)"}));
		cbUnit1.setBounds(172, 29, 96, 23);
		contentPanel.add(cbUnit1);
		
		JButton btnNewButton = new JButton("변환");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String unit1 = cbUnit1.getSelectedItem().toString();
				String unit2 = cbUnit2.getSelectedItem().toString();
				int user = Integer.parseInt(tfValue.getText());
				double result = 0;
				if(unit1.equals("밀리미터(mm)") && unit2.equals("센티미터(cm)")) {
					
					result = (double)user / 10;
					lblresult.setText(result+unit2);
							
					
				}
			}
		});
		btnNewButton.setBounds(121, 129, 65, 23);
		contentPanel.add(btnNewButton);
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
	}
}
