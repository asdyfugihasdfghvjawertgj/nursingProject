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
		setBounds(100, 100, 1363, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 128, 114));
		panel.setBounds(0, 0, 1548, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nursing Admin Panel");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 170, 26);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 160, 122));
		panel_1.setBorder(new TitledBorder((Border) new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Department", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(150, 93, 506, 123);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Department Entry");
		btnNewButton_3.addActionListener(new ActionListener() {
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
		btnNewButton_3.setBackground(SystemColor.info);
		btnNewButton_3.setBounds(40, 50, 139, 23);
		panel_1.add(btnNewButton_3);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nurse", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBackground(new Color(255, 160, 122));
		panel_1_1.setBounds(726, 93, 506, 123);
		contentPane.add(panel_1_1);
		
		JButton btnNewButton_3_1 = new JButton("Nurse Entry");
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
		btnNewButton_3_1.setBounds(40, 50, 106, 23);
		panel_1_1.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_1_3 = new JButton("Nurse Update");
		btnNewButton_3_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nurseUpdate nU =new nurseUpdate();
				nU.show();
			}
		});
		btnNewButton_3_1_3.setBackground(SystemColor.info);
		btnNewButton_3_1_3.setBounds(166, 50, 129, 23);
		panel_1_1.add(btnNewButton_3_1_3);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Front", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2.setBackground(new Color(255, 160, 122));
		panel_1_2.setBounds(150, 254, 506, 123);
		contentPane.add(panel_1_2);
		
		JButton btnNewButton_3_2 = new JButton("Front Entry");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontEntry fE=new frontEntry();
				fE.show();
			}
		});
		btnNewButton_3_2.setBackground(SystemColor.info);
		btnNewButton_3_2.setBounds(40, 50, 106, 23);
		panel_1_2.add(btnNewButton_3_2);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Package", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1_1.setBackground(new Color(255, 160, 122));
		panel_1_1_1.setBounds(726, 254, 506, 123);
		contentPane.add(panel_1_1_1);
		
		JButton btnNewButton_3_1_1 = new JButton("Package Entry");
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
		btnNewButton_3_1_1.setBounds(40, 50, 143, 23);
		panel_1_1_1.add(btnNewButton_3_1_1);
		
		JButton btnNewButton_3_1_1_1 = new JButton("Package Update");
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
		btnNewButton_3_1_1_1.setBounds(202, 50, 143, 23);
		panel_1_1_1.add(btnNewButton_3_1_1_1);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Patient", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_3.setBackground(new Color(255, 160, 122));
		panel_1_3.setBounds(150, 415, 506, 123);
		contentPane.add(panel_1_3);
		
		JButton btnNewButton_3_3 = new JButton("Patient Update");
		btnNewButton_3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patientUpdate paU =new patientUpdate();
				paU.show();
			}
		});
		btnNewButton_3_3.setBackground(SystemColor.info);
		btnNewButton_3_3.setBounds(40, 50, 127, 23);
		panel_1_3.add(btnNewButton_3_3);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Package Detail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1_2.setBackground(new Color(255, 160, 122));
		panel_1_1_2.setBounds(726, 415, 506, 123);
		contentPane.add(panel_1_1_2);
		
		JButton btnNewButton_3_1_2 = new JButton("Package Price");
		btnNewButton_3_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				packagedetailEntry pdE =new packagedetailEntry();
				pdE.show();
			}
			
		});
		btnNewButton_3_1_2.setBackground(SystemColor.info);
		btnNewButton_3_1_2.setBounds(40, 50, 174, 23);
		panel_1_1_2.add(btnNewButton_3_1_2);
		
		JButton btnNewButton_3_1_2_1 = new JButton("Package Price Update");
		btnNewButton_3_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PackageDetailUpdate PDU =new PackageDetailUpdate();
				PDU.show();
			}
		});
		btnNewButton_3_1_2_1.setBackground(SystemColor.info);
		btnNewButton_3_1_2_1.setBounds(238, 50, 189, 23);
		panel_1_1_2.add(btnNewButton_3_1_2_1);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(255, 160, 122));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(150, 603, 89, 23);
		contentPane.add(btnNewButton);
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
