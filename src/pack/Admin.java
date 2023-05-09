package pack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	private JButton btnNewButton_3_2;
	private JButton btnNewButton_3_1;
	private JButton btnNewButton_3_1_3;
	private JButton btnNewButton_3_1_1_1;
	private JButton btnNewButton_3_1_1;
	private JButton btnNewButton_3_1_2;
	private JButton btnNewButton_3_1_2_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Pictures\\Screenshots\\esms\\Screenshot (2).png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1499, 838);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		panel.setBounds(0, 10, 1537, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nursing Admin Panel");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 11, 275, 26);
		panel.add(lblNewLabel);
		
		btnNewButton = new JButton("LOG OUT");
		btnNewButton.setBounds(1389, 10, 105, 23);
		btnNewButton.setBackground(SystemColor.info);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstpage fp=new firstpage();
				fp.show();
			}
		});
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		//btnNewButton.setForeground(new Color(255, 255, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 160, 122));
		panel_1.setBorder(new TitledBorder((Border) new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Department", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(172, 129, 506, 123);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnNewButton_1 = new JButton("Department Entry");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				departmentEntry de = null;
				try {
					de = new departmentEntry();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				de.show();
			}
		});
		btnNewButton_1.setBackground(SystemColor.info);
		btnNewButton_1.setBounds(166, 49, 165, 23);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nurse", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBackground(new Color(255, 160, 122));
		panel_1_1.setBounds(782, 129, 506, 123);
		contentPane.add(panel_1_1);
		
		btnNewButton_3_1 = new JButton("Nurse Entry");
		btnNewButton_3_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nurseEntry ne = null;
				try {
					ne = new nurseEntry();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ne.show();
			}

			private nurseEntry nurseEntry() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnNewButton_3_1.setBackground(SystemColor.info);
		btnNewButton_3_1.setBounds(40, 50, 164, 23);
		panel_1_1.add(btnNewButton_3_1);
		
		btnNewButton_3_1_3 = new JButton("Nurse Update");
		btnNewButton_3_1_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nurseUpdate nU =new nurseUpdate();
				nU.show();
			}
		});
		btnNewButton_3_1_3.setBackground(SystemColor.info);
		btnNewButton_3_1_3.setBounds(296, 50, 172, 23);
		panel_1_1.add(btnNewButton_3_1_3);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "User", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2.setBackground(new Color(255, 160, 122));
		panel_1_2.setBounds(172, 325, 506, 123);
		contentPane.add(panel_1_2);
		
		btnNewButton_3 = new JButton("User Details");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontEntry fE=new frontEntry();
				fE.show();
			}
		});
		btnNewButton_3.setBackground(SystemColor.info);
		btnNewButton_3.setBounds(166, 50, 172, 23);
		panel_1_2.add(btnNewButton_3);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Package", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1_1.setBackground(new Color(255, 160, 122));
		panel_1_1_1.setBounds(782, 325, 506, 123);
		contentPane.add(panel_1_1_1);
		
		btnNewButton_3_1_1 = new JButton("Package Entry");
		btnNewButton_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				packageEntry pE = null;
				try {
					pE = new packageEntry();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pE.show();
			}
		});
		btnNewButton_3_1_1.setBackground(SystemColor.info);
		btnNewButton_3_1_1.setBounds(40, 50, 165, 23);
		panel_1_1_1.add(btnNewButton_3_1_1);
		
		btnNewButton_3_1_1_1 = new JButton("Package Update");
		btnNewButton_3_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				packageUpdate pU = null;
				try {
					pU = new packageUpdate();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pU.show();
			}
		});
		btnNewButton_3_1_1_1.setBackground(SystemColor.info);
		btnNewButton_3_1_1_1.setBounds(288, 50, 183, 23);
		panel_1_1_1.add(btnNewButton_3_1_1_1);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Patient", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_3.setBackground(new Color(255, 160, 122));
		panel_1_3.setBounds(172, 504, 506, 123);
		contentPane.add(panel_1_3);
		
		btnNewButton_3_2 = new JButton("Patient Update");
		btnNewButton_3_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patientUpdate paU =new patientUpdate();
				paU.show();
			}
		});
		btnNewButton_3_2.setBackground(SystemColor.info);
		btnNewButton_3_2.setBounds(168, 50, 167, 23);
		panel_1_3.add(btnNewButton_3_2);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Package Detail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1_2.setBackground(new Color(255, 160, 122));
		panel_1_1_2.setBounds(782, 504, 506, 123);
		contentPane.add(panel_1_1_2);
		
		btnNewButton_3_1_2 = new JButton("Package Price");
		btnNewButton_3_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				packagedetailEntry pdE =new packagedetailEntry();
				pdE.show();
			}
			
		});
		btnNewButton_3_1_2.setBackground(SystemColor.info);
		btnNewButton_3_1_2.setBounds(40, 50, 174, 23);
		panel_1_1_2.add(btnNewButton_3_1_2);
		
		btnNewButton_3_1_2_1 = new JButton("Package Price Update");
		btnNewButton_3_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PackageDetailUpdate PDU =new PackageDetailUpdate();
				PDU.show();
			}
		});
		btnNewButton_3_1_2_1.setBackground(SystemColor.info);
		btnNewButton_3_1_2_1.setBounds(286, 50, 190, 23);
		panel_1_1_2.add(btnNewButton_3_1_2_1);
	}

	protected PackageDetailUpdate PackageDetailUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	protected packagedetailEntry packagedetailEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	protected packageEntry packageEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	protected frontEntry frontEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	protected nurseUpdate nurseUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

}
