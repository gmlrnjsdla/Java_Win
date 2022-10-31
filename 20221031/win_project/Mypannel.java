package win_project;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;

public class Mypannel extends JPanel {
	private JTextField textField;
	public Mypannel() {
		setBackground(new Color(255, 255, 0));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(54, 45, 57, 15);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(123, 42, 116, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(54, 111, 57, 15);
		add(lblAge);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboBox.setBounds(123, 107, 72, 23);
		add(comboBox);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBounds(49, 160, 97, 23);
		add(btnNewButton);
	}
}
