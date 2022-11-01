package win_project1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class WinMain extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WinMain dialog = new WinMain();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WinMain() {
		setBounds(100, 100, 660, 557);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("����", new UnitLength());
			tabbedPane.addTab("����", new UnitWeight());
			contentPanel.add(tabbedPane, BorderLayout.CENTER);
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
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				JMenu mnUnit = new JMenu("\uB2E8\uC704\uBCC0\uD658\uAE30");
				menuBar.add(mnUnit);
				{
					JMenuItem mnLength = new JMenuItem("\uAE38\uC774\uBCC0\uD658...");
					mnLength.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							WinUnitConv dlg = new WinUnitConv();
							dlg.setModal(true);
							dlg.setVisible(true);
						}
					});
					mnUnit.add(mnLength);
				}
				{
					JMenuItem mnWeight = new JMenuItem("\uBB34\uAC8C\uBCC0\uD658...");
					mnWeight.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							WinWeightConv dlg = new WinWeightConv();
							dlg.setModal(true);
							dlg.setVisible(true);
						}
					});
					mnUnit.add(mnWeight);
				}
			}
			
			JMenu mnLotto = new JMenu("Lotto");
			menuBar.add(mnLotto);
		}
	}
}
