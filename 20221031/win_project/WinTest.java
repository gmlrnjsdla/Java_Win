package win_project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ToolTipManager;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

public class WinTest extends JDialog {

   private final JPanel contentPanel = new JPanel();
   private JTextField textField;
   JLabel lblPicture;
   JTextArea textArea;
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      try {
         WinTest dialog = new WinTest();
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Create the dialog.
    */
   public WinTest() {
      setTitle("Image Viewer");
      setBounds(100, 100, 536, 490);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(null);
      
      JMenuBar menuBar = new JMenuBar();
      menuBar.setBounds(0, 0, 520, 23);
      contentPanel.add(menuBar);
      
      JMenu mnuFile = new JMenu("File");
      mnuFile.setMnemonic('F');
      menuBar.add(mnuFile);
      
      JMenuItem mnuOpen = new JMenuItem("Open...");
      mnuOpen.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null, "열기 대화상자");
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = 
                  new FileNameExtensionFilter("그림파일", "png","gif","jpg");
            chooser.setFileFilter(filter);
            
            FileNameExtensionFilter filter2 =
                  new FileNameExtensionFilter("텍스트", "txt");
            chooser.addChoosableFileFilter(filter2);
            chooser.setCurrentDirectory(new File("D:/"));            
            
            chooser.setMultiSelectionEnabled(true);
            
            int ret = chooser.showOpenDialog(null);
            if(ret == JFileChooser.APPROVE_OPTION) {               
               String fileName = chooser.getSelectedFile().getPath();
               //chooser.getSelectedFiles();
               JOptionPane.showMessageDialog(null, fileName);
               ImageIcon image = new ImageIcon(fileName);
               Image pic = image.getImage();
               pic = pic.getScaledInstance(lblPicture.getWidth(),
                     lblPicture.getHeight(), Image.SCALE_SMOOTH);
               ImageIcon image1 = new ImageIcon(pic);
               lblPicture.setIcon(image1);
               
            }else if(ret == JFileChooser.CANCEL_OPTION)
               JOptionPane.showMessageDialog(null, "취소 버튼");
            else
               JOptionPane.showMessageDialog(null, "버튼");
         }
      });
      mnuOpen.setMnemonic('O');
      mnuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
      mnuFile.add(mnuOpen);
      
      JMenuItem mnuSave = new JMenuItem("Save...");
      mnuSave.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(null, "저장 대화상자");
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = 
                  new FileNameExtensionFilter("텍스트","txt");
            chooser.setFileFilter(filter);
            int ret = chooser.showSaveDialog(null);
         }
      });
      mnuSave.setMnemonic('S');
      mnuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
      mnuFile.add(mnuSave);
      
      mnuFile.addSeparator();
      
      JMenuItem mnuExit = new JMenuItem("Exit");
      mnuExit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });
      mnuExit.setMnemonic('x');
      mnuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
      mnuFile.add(mnuExit);
      
      JMenu mnuColor = new JMenu("Color");
      mnuColor.setMnemonic('C');
      menuBar.add(mnuColor);
      
      JMenuItem mnuRed = new JMenuItem("Red");
      mnuRed.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            contentPanel.setBackground(Color.red);            
         }
      });
      mnuRed.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
      mnuColor.add(mnuRed);
      
      JMenuItem mnuGreen = new JMenuItem("Green");
      mnuGreen.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            contentPanel.setBackground(Color.green);
         }
      });
      mnuGreen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
      mnuColor.add(mnuGreen);
      
      JMenuItem mnuBlue = new JMenuItem("Blue");
      mnuBlue.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            contentPanel.setBackground(Color.blue);
         }
      });
      mnuBlue.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
      mnuColor.add(mnuBlue);
      
      JCheckBoxMenuItem ckDialog = new JCheckBoxMenuItem("Color Dialog...");
      ckDialog.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
//            if(ckDialog.isSelected())
//               contentPanel.setBackground(Color.red);
//            else
//               contentPanel.setBackground(Color.gray);
            Color color = 
                  JColorChooser.showDialog(null, "Color", Color.yellow);
            textArea.setForeground(color);
         }
      });
      mnuColor.add(ckDialog);
      
      JMenu mnText = new JMenu("Text");
      menuBar.add(mnText);
      
      JMenuItem mnTextOpen = new JMenuItem("텍스트 열기...");
      mnTextOpen.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = 
                  new FileNameExtensionFilter("텍스트","txt");
            chooser.setFileFilter(filter);
            int ret = chooser.showOpenDialog(null);
            if(JFileChooser.APPROVE_OPTION == ret) {
               // File 읽기
               String fileName = chooser.getSelectedFile().getPath();
               try {
                  FileReader fr = new FileReader(fileName);
                  int c;
                  String temp = null;
                  while((c=fr.read()) != -1) {
                     temp = temp + (char)c;
                  }
                  textArea.setText(temp);
               } catch (FileNotFoundException e1) {
                  // TODO Auto-generated catch block
                  e1.printStackTrace();
               } catch (IOException e1) {
                  // TODO Auto-generated catch block
                  e1.printStackTrace();
               }
            }                  
         }
      });
      mnText.add(mnTextOpen);
      
      JToolBar toolBar = new JToolBar();
      toolBar.setFloatable(false);
      toolBar.setBounds(0, 23, 520, 34);
      contentPanel.add(toolBar);
      
      JLabel lblRed = new JLabel("");
      lblRed.setIcon(new ImageIcon("images/red.png"));
      lblRed.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if(e.getButton()==MouseEvent.BUTTON1)
               contentPanel.setBackground(Color.red);
         }
      });
      lblRed.setBackground(new Color(255, 0, 0));
      lblRed.setOpaque(true);
      toolBar.add(lblRed);
      
      JLabel lblGreen = new JLabel("");
      lblGreen.setIcon(new ImageIcon("images/green.png"));
      lblGreen.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if(e.getButton()==MouseEvent.BUTTON1)
               contentPanel.setBackground(Color.green);
         }
      });
      
      
      lblGreen.setBackground(new Color(0, 128, 0));
      lblGreen.setOpaque(true);
      toolBar.add(lblGreen);
      
      JLabel lblBlue = new JLabel("");
      lblBlue.setIcon(new ImageIcon("images/blue.png"));
      lblBlue.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if(e.getButton()==MouseEvent.BUTTON1)
               contentPanel.setBackground(Color.blue);
         }
      });
      lblBlue.setBackground(new Color(0, 0, 255));
      lblBlue.setOpaque(true);
      toolBar.add(lblBlue);
      
      ToolTipManager m = ToolTipManager.sharedInstance();
      m.setEnabled(true);
      m.setInitialDelay(100);  // ms
      m.setDismissDelay(10000);
      textField = new JTextField();
      textField.setToolTipText("상품명을 입력하시오.");
      toolBar.add(textField);
      textField.setColumns(10);
      
      
      
      lblPicture = new JLabel("");
      lblPicture.setHorizontalAlignment(SwingConstants.CENTER);
      lblPicture.setBounds(10, 67, 99, 83);
      contentPanel.add(lblPicture);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      scrollPane.setBounds(147, 67, 361, 341);
      contentPanel.add(scrollPane);
      
      textArea = new JTextArea();
      textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));      
      textArea.setForeground(new Color(0, 0, 255));
      textArea.setLineWrap(true);
      scrollPane.setViewportView(textArea);
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
      JComboBox cbFontSize = new JComboBox();
      cbFontSize.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
//      	JOptionPane.showMessageDialog(null, cbFontSize.getSelectedItem());
      		int size = Integer.parseInt(cbFontSize.getSelectedItem().toString());
      		textArea.setFont(new Font("Monospaced", Font.PLAIN, size));
      	}
      });
      cbFontSize.setToolTipText("타입을 선택하시오");
      for(int i =10; i<=50;i++) {
    	  cbFontSize.addItem(i);
      }
      toolBar.add(cbFontSize);
   }
}