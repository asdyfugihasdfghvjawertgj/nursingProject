package pack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pack.mySQLQueries;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import pack.mySQLQueries;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;



public class dutyEntry extends JDialog {
	private JTextField txtName;
	private JButton btnClose;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dutyEntry dialog = new dutyEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private JLabel lblid;



	/**
	 * Create the dialog.
	 * @throws ClassNotFoundException 
	 */
	public dutyEntry() throws ClassNotFoundException {
		setTitle("Duty Entry");
		setBounds(100, 100, 490, 337);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Duty Info:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 425, 193);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Duty ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 43, 85, 29);
		panel.add(lblNewLabel);
		
		JLabel lblBrandName = new JLabel("Duty  Name:");
		lblBrandName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBrandName.setBounds(20, 107, 100, 29);
		panel.add(lblBrandName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtName.setBounds(194, 105, 197, 33);
		panel.add(txtName);
		txtName.setColumns(10);
		
		lblid = new JLabel("");
		lblid.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblid.setBounds(200, 35, 191, 29);
		panel.add(lblid);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st[] = new String[1];
		        if(Checking.IsNull(txtName.getText()))//true
		        {
		            JOptionPane.showMessageDialog(null, "First you must enter duty.");
		            txtName.requestFocus();
		            txtName.selectAll();
		        }
		        else{
		            st[0] = (String)txtName.getText();
		            boolean ee = mySQLQueries.isduplicate("duty", st);//true
		            if(!ee)//false
		            {
		                JOptionPane.showMessageDialog(null, "Duplicate Record!");
		                txtName.requestFocus();
		                txtName.selectAll();
		            }
		            else
		            {
		                String []str = new String [2];
		                str[0]= lblid.getText();
		                str[1]=txtName.getText();
		                boolean save = mySQLQueries.insertData("duty", str);
		                if(save)
		                {
		                    JOptionPane.showMessageDialog(null, "Successfully saved record!","Save Record.",JOptionPane.INFORMATION_MESSAGE);
		                    try {
								AutoID();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		                    txtName.setText("");
		                    txtName.requestFocus();
		                }
		                else
		                {
		                    JOptionPane.showMessageDialog(null, "Failed to save new record","Cannot Saved.",JOptionPane.INFORMATION_MESSAGE);
		                  
								try {
									AutoID();
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							
								
							
		                }
		            }
		        }

			}
		});
		btnSave.setBounds(22, 237, 114, 31);
		getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnCancel.setBounds(188, 237, 105, 31);
		getContentPane().add(btnCancel);
		
		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{	
					dispose();
				}
			}
		});
		btnClose.setBounds(339, 237, 96, 27);
		getContentPane().add(btnClose);
		AutoID();
		
	}
	//mySQLQueries mysql=new mySQLQueries();

	public void AutoID() throws ClassNotFoundException
    {
        lblid.setText((String.valueOf(mySQLQueries.getAutoid("dutyid", "duty", "DU-"))));
    }
    public void clear()
    {
    	txtName.setText("");
    	txtName.requestFocus();
    	
    }

}
