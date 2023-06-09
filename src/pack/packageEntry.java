package pack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pack.mySQLQueries;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import pack.mySQLQueries;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.Font;



public class packageEntry extends JDialog {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			packageEntry dialog = new packageEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private JLabel lblid;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnClose;
	private JTextField txtstart;
	private JLabel lblNewLabel_2;
	private JTextField txtend;



	/**
	 * Create the dialog.
	 * @throws ClassNotFoundException 
	 */
	public packageEntry() throws ClassNotFoundException {
		setTitle("Package Entry");
		setBounds(100, 100, 587, 447);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Package Info:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 553, 294);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Package ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 30, 85, 27);
		panel.add(lblNewLabel);
		
		lblid = new JLabel("");
		lblid.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblid.setBounds(202, 21, 302, 44);
		panel.add(lblid);
		
		JLabel lblNewLabel_1 = new JLabel("Start Date:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(20, 112, 100, 27);
		panel.add(lblNewLabel_1);
		
		txtstart = new JTextField();
		txtstart.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtstart.setBounds(202, 106, 302, 40);
		panel.add(txtstart);
		txtstart.setColumns(10);
		
		lblNewLabel_2 = new JLabel("End Date:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(21, 195, 84, 40);
		panel.add(lblNewLabel_2);
		
		txtend = new JTextField();
		txtend.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtend.setBounds(201, 195, 303, 40);
		panel.add(txtend);
		txtend.setColumns(10);
		
		
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st[] = new String[2];
		        if(Checking.IsNull(txtstart.getText()))//true
		        {
		            JOptionPane.showMessageDialog(null, "First you must enter Start Time.");
		            txtstart.requestFocus();
		            txtstart.selectAll();
		        }
		        else if(Checking.IsNull(txtend.getText()))
		        {
		        	JOptionPane.showMessageDialog(null, "First you must enter End Time.");
		            txtend.requestFocus();
		            txtend.selectAll();
		        }
		        else{
		            st[0] = (String)txtstart.getText();
		            st[1]=(String)txtend.getText();
		            boolean ee = mySQLQueries.isduplicate("package", st);//true
		            if(!ee)//false
		            {
		                JOptionPane.showMessageDialog(null, "Duplicate Record!");
		                txtstart.requestFocus();
		                txtstart.selectAll();
		            }
		            else
		            {
		                String []str = new String [3];
		                str[0]= lblid.getText();
		                str[1]=txtstart.getText();
		                str[2]=txtend.getText();
		                boolean save = mySQLQueries.insertData("package", str);
		                if(save)
		                {
		                    JOptionPane.showMessageDialog(null, "Successfully saved record!","Save Record.",JOptionPane.INFORMATION_MESSAGE);
		                    try {
								AutoID();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		                    txtstart.setText("");
		                    txtstart.requestFocus();
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
		btnSave.setBounds(10, 342, 118, 33);
		getContentPane().add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnCancel.setBounds(232, 342, 110, 33);
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
		btnClose.setBounds(439, 342, 124, 33);
		getContentPane().add(btnClose);
		AutoID();
		
	}
	//mySQLQueries mysql=new mySQLQueries();

	public void AutoID() throws ClassNotFoundException
    {
        lblid.setText((String.valueOf(mySQLQueries.getAutoid("packageid", "package", "P-"))));
    }


    public void clear()
    {
    	txtstart.setText(null);
    	txtend.setText(null);
    }
}
