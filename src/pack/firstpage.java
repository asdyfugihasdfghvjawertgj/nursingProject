package pack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Label;
import javax.swing.JTextPane;
import java.awt.TextArea;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class firstpage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnlogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			firstpage dialog = new firstpage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public firstpage() {
		setBounds(0, 0, 1550, 1000);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Health & Safe World");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel.setBounds(561, 24, 553, 33);
		contentPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(10, 185, 1516, 532);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		btnlogin = new JButton("LOGIN");
		btnlogin.setBounds(788, 232, 126, 29);
		panel.add(btnlogin);
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login l=new login();
				l.show();
				dispose();
			}
		});
		btnlogin.setBackground(Color.ORANGE);
		btnlogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JButton btnregister = new JButton("REGISTER");
		btnregister.setBounds(609, 231, 141, 29);
		panel.add(btnregister);
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register r=new register();
				r.show();
			}
		});
		btnregister.setBackground(Color.ORANGE);
		btnregister.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(377, 10, 743, 522);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Pictures\\Saved Pictures\\dementia-care-keeping-home-with-asset-protection-planning-Cleveland.jpg"));
		btnregister.requestDefaultFocus();
		
	}
}
