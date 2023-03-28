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

public class login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtname;
	private JPasswordField passwordField;
	private JButton btncancel;
	private JButton btnlogin;
	private JCheckBox chckbxNewCheckBox;
	public String loginname;
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
		setBounds(100, 100, 602, 493);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtname = new JTextField();
		txtname.setBounds(160, 41, 380, 42);
		contentPanel.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 38, 147, 43);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(21, 162, 115, 36);
		contentPanel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 162, 380, 42);
		contentPanel.add(passwordField);
		
		chckbxNewCheckBox = new JCheckBox("Show Password");
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
		chckbxNewCheckBox.setBounds(160, 242, 126, 21);
		contentPanel.add(chckbxNewCheckBox);
		
		btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Checking.IsValidName(txtname.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter VALID Name.");
		            txtname.requestFocus();
		            txtname.selectAll();  
		            
		        }
				else if(Checking.IsNull(passwordField.getText()))
		        {
					
		            JOptionPane.showMessageDialog(null, "Please enter password!");
		            passwordField.requestFocus();
		            passwordField.selectAll();
		        }
				String psw=passwordField.getText().toString();
				String name=txtname.getText();
				loginname=mySQLQueries.getPassword(psw,name);
				if(loginname==null)
				{
					JOptionPane.showMessageDialog(null, "Your Password don't match!");
					passwordField.requestFocus();
				}
				else {
					 dispose();
					 frontEntry f=new frontEntry();
					 register r=new register();
					 r.btnregister.setVisible(false);
					 f.show();
					 f.lbluser.setText(loginname);
					 
					 
				}
					
			}
		});
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnlogin.setBounds(160, 343, 126, 36);
		contentPanel.add(btnlogin);
		
		btncancel = new JButton("cancel");
		btncancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btncancel.setBounds(342, 343, 115, 36);
		contentPanel.add(btncancel);
	}
}
