package win_project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Win_Gallery extends JDialog {

	private final JPanel contentPanel = new JPanel();
	int number = 1;
	JLabel lblPicture;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Win_Gallery dialog = new Win_Gallery();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Win_Gallery() {
		setTitle("Gallery");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			
			ImageIcon image = new ImageIcon("images/jeju"+number+".jpg");
			lblPicture = new JLabel(image);
			contentPanel.add(lblPicture);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNewButton = new JButton("previous");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						number--;
						if(number < 1) {
							number = 15;
						}
						ImageIcon image = new ImageIcon("images/jeju"+number+".jpg");
						lblPicture.setIcon(image);
					}
				});
				buttonPane.add(btnNewButton);
			}
			{
				JButton btnNewButton_1 = new JButton("next");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						number++;
						if(number > 15) {
							number = 1;
						}
						
						ImageIcon image = new ImageIcon("images/jeju"+number+".jpg");
						lblPicture.setIcon(image);
					}
				});
				{
					JButton btnNewButton_2 = new JButton("random");
					btnNewButton_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							number = (int)(Math.random()*15+1);
							ImageIcon image = new ImageIcon("images/jeju"+number+".jpg");
							lblPicture.setIcon(image);
						}
					});
					buttonPane.add(btnNewButton_2);
				}
				buttonPane.add(btnNewButton_1);
			}
		}
	}

}
