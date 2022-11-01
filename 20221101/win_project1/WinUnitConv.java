package win_project1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WinUnitConv extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfValue;
	JLabel lblResult;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WinUnitConv dialog = new WinUnitConv();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WinUnitConv() {
		setTitle("\uB2E8\uC704\uBCC0\uD658\uAE30(\uAE38\uC774)");
		setBounds(100, 100, 552, 231);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		tfValue = new JTextField();
		tfValue.setFont(new Font("����", Font.BOLD, 20));
		tfValue.setHorizontalAlignment(SwingConstants.RIGHT);
		tfValue.setBounds(12, 47, 116, 21);
		contentPanel.add(tfValue);
		tfValue.setColumns(10);
		
		JComboBox cbUnit1 = new JComboBox();
		cbUnit1.setModel(new DefaultComboBoxModel(new String[] {"cm", "km", "yard", "mile"}));
		cbUnit1.setFont(new Font("����", Font.BOLD, 20));
		cbUnit1.setBounds(140, 49, 79, 23);
		contentPanel.add(cbUnit1);
		
		JComboBox cbUnit2 = new JComboBox();
		cbUnit2.setModel(new DefaultComboBoxModel(new String[] {"cm", "km", "yard", "mile"}));
		cbUnit2.setFont(new Font("����", Font.BOLD, 20));
		cbUnit2.setBounds(278, 49, 79, 23);
		contentPanel.add(cbUnit2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = cbUnit1.getSelectedIndex();
				int j = cbUnit2.getSelectedIndex();				
				
				cbUnit1.setSelectedIndex(j);
				cbUnit2.setSelectedIndex(i);
			}
		});
		lblNewLabel.setIcon(new ImageIcon("C:\\FileIO\\images\\switch.png"));
		lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel.setBounds(220, 33, 50, 50);
		contentPanel.add(lblNewLabel);
		
		JButton btnConvert = new JButton("��ȯ");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = Integer.parseInt(tfValue.getText());
				String unit1 = cbUnit1.getSelectedItem().toString();
				String unit2 = cbUnit2.getSelectedItem().toString();
				double Unit[][] ={ 
						{1, 0.00001, 0.010936,0.000006},
						{100000, 1, 1093.6133,0.621371},
						{0.000568, 0.000914, 1,0.000568},
						{160934.4, 1.609344, 1760,1}				
				}; 
				double result = 0;
				
				result = (double)value*Unit[cbUnit1.getSelectedIndex()][cbUnit2.getSelectedIndex()];
				
				lblResult.setText(result + unit2);
			}
		});
		btnConvert.setFont(new Font("����", Font.BOLD, 20));
		btnConvert.setBounds(374, 49, 97, 23);
		contentPanel.add(btnConvert);
		
		lblResult = new JLabel("���:");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("����", Font.BOLD, 20));
		lblResult.setBounds(140, 103, 219, 39);
		contentPanel.add(lblResult);
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
