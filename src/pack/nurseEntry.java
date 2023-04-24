package pack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Choice;
import javax.swing.JTextArea;

public class nurseEntry extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblnurseid;
	private JComboBox cbodepid;
	private JComboBox cbodutyid;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnClose;
	//private JTextField txtname;
	private JTextField txtexp;
	private JTextField txtph;
	private JTextField txtaddress;
	private String gender;
	private JRadioButton rdoFemale;
	private JRadioButton rdoMale;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_2;
	private JTextArea txtname1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			nurseEntry dialog = new nurseEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws ClassNotFoundException 
	 */
	public nurseEntry() throws ClassNotFoundException {
		setBounds(100, 100, 709, 669);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nurse ID:");
		lblNewLabel.setBounds(10, 25, 97, 37);
		contentPanel.add(lblNewLabel);
		
		lblnurseid = new JLabel("");
		lblnurseid.setBounds(162, 28, 253, 34);
		contentPanel.add(lblnurseid);
		
		lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setBounds(10, 72, 45, 13);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Dep ID:");
		lblNewLabel_1.setBounds(10, 112, 97, 34);
		contentPanel.add(lblNewLabel_1);
		
		cbodepid = new JComboBox();
		cbodepid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fillBrand();
			}
		});
		cbodepid.setBounds(162, 111, 273, 29);
		contentPanel.add(cbodepid);
		
		cbodutyid = new JComboBox();
		cbodutyid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cbodutyid.setBounds(162, 156, 273, 29);
		contentPanel.add(cbodutyid);
		
		JLabel lblNewLabel_3 = new JLabel("Gender:");
		lblNewLabel_3.setBounds(10, 219, 45, 13);
		contentPanel.add(lblNewLabel_3);
		
		rdoMale = new JRadioButton("Male");
		rdoMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoMale.isSelected()) {
					rdoFemale.setSelected(false);
					gender="male";
				}
			}
		});
		rdoMale.setBounds(158, 215, 103, 21);
		contentPanel.add(rdoMale);
		
		rdoFemale = new JRadioButton("Female");
		rdoFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoFemale.isSelected()) {
					rdoMale.setSelected(false);
					gender="female";
				}
			}
		});
		rdoFemale.setBounds(276, 215, 103, 21);
		contentPanel.add(rdoFemale);
		
		JLabel lblNewLabel_4 = new JLabel("Experience:");
		lblNewLabel_4.setBounds(10, 260, 64, 13);
		contentPanel.add(lblNewLabel_4);
		
		txtexp = new JTextField();
		txtexp.setBounds(165, 252, 270, 29);
		contentPanel.add(txtexp);
		txtexp.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Phone:");
		lblNewLabel_6.setBounds(10, 305, 45, 13);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address:");
		lblNewLabel_7.setBounds(10, 338, 45, 13);
		contentPanel.add(lblNewLabel_7);
		
		txtph = new JTextField();
		txtph.setBounds(165, 292, 270, 29);
		contentPanel.add(txtph);
		txtph.setColumns(10);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(165, 335, 270, 28);
		contentPanel.add(txtaddress);
		txtaddress.setColumns(10);
		
		
		btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		         if(!Checking.IsValidName(txtname1.getText()))
		         {
		            JOptionPane.showMessageDialog(null, "Please enter VALID Name.");
		            txtname1.requestFocus();
		            txtname1.selectAll();
		         }
				else if(cbodepid.getSelectedIndex()==0)
			            JOptionPane.showMessageDialog(null,"Please choose department id!");
				else if(cbodutyid.getSelectedIndex()==0)
			            JOptionPane.showMessageDialog(null,"Please choose duty id!");
		       else if(gender==null || gender.equals(""))
			     {
			        	JOptionPane.showMessageDialog(null,"Please choose gender");
			     }
		       else if(Integer.parseInt(txtexp.getText())>60) 
		        {
		            JOptionPane.showMessageDialog(null, "Please enter valid experience year.");
		            txtexp.requestFocus();
		            txtexp.selectAll();
		        }else if(!Checking.IsAllDigit(txtexp.getText().trim())) 
		        {
		            JOptionPane.showMessageDialog(null, "Please enter valid Experience.");
		            txtexp.requestFocus();
		            txtexp.selectAll();
		        }
				else if(Checking.IsNull(txtexp.getText()))
			     {
			            JOptionPane.showMessageDialog(null, "Please enter Experience.");
			            txtexp.requestFocus();
			            txtexp.selectAll();
	             }
			      else if(!Checking.IsAllDigit(txtph.getText()))
			        {
			            JOptionPane.showMessageDialog(null,"Please enter valid Phone Number.");
			            txtph.requestFocus();
			            txtph.selectAll();
			        }
			        else if(Checking.IsNull(txtaddress.getText()))
			        {
			            JOptionPane.showMessageDialog(null,"Please enter Address.");;
			            txtaddress.requestFocus();
			            txtaddress.selectAll();
			        }
			        else if(!mySQLQueries.isPhoneNoValid((String)txtph.getText())) {
	                	JOptionPane.showMessageDialog(null,"Phone no invalid");
			        }
			        
			        else
			        {
		            String st[]=new String[9];
		            st[0] = (String)txtname1.getText();
					st[1] = (String)cbodepid.getSelectedItem();
					st[2] = (String)cbodutyid.getSelectedItem();
					st[3] = gender;
		            st[4]=(String)txtexp.getText();
		            st[5]=(String)txtph.getText();
		            st[6]=(String)txtaddress.getText();
		            boolean br=(mySQLQueries.isduplicate("nurse",st));
		            if(!br)
		                JOptionPane.showMessageDialog(null,"Duplicate Record!");
		            else
		            {
		                String[] str=new String[8];
		                str[0]=lblnurseid.getText();
		                str[1]=txtname1.getText();
		                str[2]=(String)cbodepid.getSelectedItem();
		                str[3]=(String)cbodutyid.getSelectedItem();
		                str[4]=gender;
		                str[5]=(String)txtexp.getText();
			            str[6]=(String)txtph.getText();
			            str[7]=(String)txtaddress.getText();
		                boolean save=(mySQLQueries.insertData("nurse",str));
		                if(save)
		                    JOptionPane.showMessageDialog(null,"Successfully save record!","Save Record",JOptionPane.INFORMATION_MESSAGE);
		                else
		                    JOptionPane.showMessageDialog(null,"Failed to save record!","Save Failed",JOptionPane.INFORMATION_MESSAGE);
		            }
		            try {
						AutoID();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            clear();
		            cbodepid.requestFocus();
		        }
			}
		});
		btnSave.setBounds(24, 542, 119, 21);
		contentPanel.add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnCancel.setBounds(162, 542, 125, 21);
		contentPanel.add(btnCancel);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
				{	
					dispose();
				}
			}
		});
		btnClose.setBounds(315, 542, 119, 21);
		contentPanel.add(btnClose);
		
		JLabel lblNewLabel_5 = new JLabel("Duty ID:");
		lblNewLabel_5.setBounds(10, 164, 45, 13);
		contentPanel.add(lblNewLabel_5);
		
		txtname1 = new JTextArea();
		txtname1.setBounds(162, 65, 273, 29);
		contentPanel.add(txtname1);
		//
		AutoID();
		//super(parent,modal);
		fillDep();
		fillDuty();
		clear();
		//getRootPane();setDefaultButton(btnsave);
	}
	public void AutoID() throws ClassNotFoundException
    {
		lblnurseid.setText((String.valueOf(mySQLQueries.getAutoid("nurseid","nurse","NU-"))));
    }

//fill brand  method call in constructor
public void fillDep()
    {
        String str[] = null;
		try {
			str = mySQLQueries.getIDForChoice("department");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cbodepid.addItem("-Select-");
        for(int i=0;i<str.length;i++)
            cbodepid.addItem(str[i].toString());
    }

public void fillDuty()
    {
        String str[]=mySQLQueries.getIDForChoice("duty");
        cbodutyid.addItem("-Select-");
        for(int i=0;i<str.length;i++)
            cbodutyid.addItem(str[i].toString());
    }
  
public void clear()
    {
		txtname1.setText(null);
        cbodepid.setSelectedIndex(0);
        cbodutyid.setSelectedIndex(0);
        rdoMale.isSelected();
        rdoFemale.isSelected();
        txtexp.setText("");
        txtph.setText("");
        txtaddress.setText(""); 
    }
}
