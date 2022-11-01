package win_project1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Win_Weight extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Win_Weight dialog = new Win_Weight();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Win_Weight() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setText("100");
			textField.setHorizontalAlignment(SwingConstants.RIGHT);
			textField.setColumns(10);
			textField.setBounds(67, 28, 116, 21);
			contentPanel.add(textField);
		}
		{
			JLabel lblNewLabel = new JLabel("을(를)");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(156, 66, 75, 18);
			contentPanel.add(lblNewLabel);
		}
		{
			JComboBox cbUnit2 = new JComboBox();
			cbUnit2.setModel(new DefaultComboBoxModel(new String[] {"mg", "g", "kg", "t"}));
			cbUnit2.setBounds(148, 94, 96, 23);
			contentPanel.add(cbUnit2);
		}
		{
			JLabel lblresult = new JLabel("결과");
			lblresult.setHorizontalAlignment(SwingConstants.CENTER);
			lblresult.setBounds(161, 170, 109, 15);
			contentPanel.add(lblresult);
		}
		{
			JComboBox cbUnit1 = new JComboBox();
			cbUnit1.setModel(new DefaultComboBoxModel(new String[] {"mg", "g", "kg", "t"}));
			cbUnit1.setBounds(209, 27, 96, 23);
			contentPanel.add(cbUnit1);
		}
		{
			JButton btnNewButton = new JButton("변환");
			btnNewButton.setBounds(158, 127, 65, 23);
			contentPanel.add(btnNewButton);
		}
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
