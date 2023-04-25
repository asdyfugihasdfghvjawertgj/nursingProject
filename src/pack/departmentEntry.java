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



public class departmentEntry extends JDialog {
	private JTextField txtName;
	private JButton btnClose;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			departmentEntry	 dialog = new departmentEntry();
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
	public departmentEntry() throws ClassNotFoundException {
		setTitle("Brand Entry");
		setBounds(100, 100, 536, 307);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Department Info:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 491, 162);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dep ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 21, 95, 35);
		panel.add(lblNewLabel);
		
		JLabel lblBrandName = new JLabel("Dep  Name:");
		lblBrandName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBrandName.setBounds(10, 66, 85, 46);
		panel.add(lblBrandName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtName.setBounds(167, 66, 280, 46);
		panel.add(txtName);
		txtName.setColumns(10);
		
		lblid = new JLabel("");
		lblid.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblid.setBounds(167, 21, 280, 35);
		panel.add(lblid);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st[] = new String[1];
		        if(Checking.IsNull(txtName.getText()))//true
		        {
		            JOptionPane.showMessageDialog(null, "First you must enter valid Brand name.");
		            txtName.requestFocus();
		            txtName.selectAll();
		        }
		        else{
		            st[0] = (String)txtName.getText();
		            boolean ee = mySQLQueries.isduplicate("department", st);//true
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
		                boolean save = mySQLQueries.insertData("department", str);
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
		                    clear();
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
		btnSave.setBounds(10, 192, 111, 33);
		getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnCancel.setBounds(200, 192, 111, 33);
		getContentPane().add(btnCancel);
		
		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{	
					dispose();
				}
			}
		});
		btnClose.setBounds(388, 192, 113, 33);
		getContentPane().add(btnClose);
		AutoID();
		
	}
	//mySQLQueries mysql=new mySQLQueries();

	public void AutoID() throws ClassNotFoundException
    {
        lblid.setText((String.valueOf(mySQLQueries.getAutoid("departmentid", "department", "DE-"))));
    }


    public void clear()
    {
    	txtName.setText("");
    	txtName.requestFocus();
    	
    }

}
