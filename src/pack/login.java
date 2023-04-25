package pack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtname;
	private JPasswordField passwordField;
	private JButton btncancel;
	private JButton btnlogin;
	private JCheckBox chckbxNewCheckBox;
	public String loginname[];
	//public String patientname;
	Vector v=new Vector();
	//register r=new register();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			login dialog = new login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public login() {
		setTitle("Nursing Home Calling System");
		setBounds(0, 0, 1550, 1000);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		panel.setBounds(490, 152, 633, 435);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("User Login");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_2.setBounds(242, 10, 191, 41);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setBounds(44, 61, 147, 43);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		txtname = new JTextField();
		txtname.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtname.setBounds(44, 118, 508, 42);
		panel.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(44, 172, 115, 36);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		passwordField.setBounds(44, 218, 506, 42);
		panel.add(passwordField);
		
		chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.setBounds(44, 280, 126, 21);
		chckbxNewCheckBox.setBackground(new Color(255, 99, 71));
		panel.add(chckbxNewCheckBox);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected())
				{
					passwordField.setEchoChar((char)0);
					
				}
				else
					passwordField.setEchoChar('*');
			}
		});
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnlogin = new JButton("Login");
		btnlogin.setBounds(44, 344, 126, 36);
		panel.add(btnlogin);
		btnlogin.setForeground(new Color(0, 0, 0));
		btnlogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String psw=passwordField.getText().toString();
					String name=txtname.getText();
					loginname=mySQLQueries.getPassword(psw,name);
					if(!Checking.IsValidName(txtname.getText()))
			        {
			            JOptionPane.showMessageDialog(null, "Please enter VALID Name.");
			            txtname.requestFocus();
			            txtname.selectAll();  
			            
			        }
					
					else if(txtname.getText().equals("admin")&&passwordField.getText().equals("admin"))
					{
						Admin A=new Admin();
						A.show();
						dispose();
					}
					else if(Checking.IsNull(passwordField.getText()))
			        {
						
			            JOptionPane.showMessageDialog(null, "Please enter password!");
			            passwordField.requestFocus();
			            passwordField.selectAll();
			        }
					else if(loginname==null)
					{
						JOptionPane.showMessageDialog(null, "Your Password don't match!");
						passwordField.requestFocus();
					}
					
					
					else {
						 dispose();
						 frontEntry f=new frontEntry();
						 register r=new register();
						 //f.panel_3.hide();
						 f.show();
						 //f.panel_1.show();
						 f.lbluser.setText(loginname[1]);
						 //System.out.println(loginname[0]);
						 
						
					}
						
				}
			});
		btnlogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		btncancel = new JButton("cancel");
		btncancel.setBounds(201, 344, 115, 36);
		panel.add(btncancel);
		btncancel.setForeground(new Color(0, 0, 0));
		btncancel.setFont(new Font("Times New Roman", Font.BOLD, 20));
	}
}