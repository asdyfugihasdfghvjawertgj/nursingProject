package pack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Label;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import com.mysql.jdbc.exceptions.jdbc4.MySQLDataException;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class frontEntry extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtexp;
	private JComboBox cbodepid;
	private JComboBox cbodutyid;
	private JRadioButton rdomale;
	private JRadioButton rdofemale;
	private JButton btnsearch;
	private JButton btncancel;
	private String gender;
	DefaultTableModel dtm=new DefaultTableModel();	
	private JPanel panel_1;
	private JButton btnback;
	private JButton btncall;
	private JButton btnview;
	private JComboBox cbonurse;
	private JTable table;/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			frontEntry dialog = new frontEntry();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public frontEntry() {
		setBounds(100, 100, 1131, 861);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setToolTipText("");
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 47, 373, 349);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		cbodepid = new JComboBox();
		cbodepid.setBounds(31, 74, 270, 25);
		panel.add(cbodepid);
		
		cbodutyid = new JComboBox();
		cbodutyid.setBounds(31, 128, 270, 25);
		panel.add(cbodutyid);
		
		btnsearch = new JButton("Search");
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 	if(cbodepid.getSelectedIndex()==0)
		            JOptionPane.showMessageDialog(null,"Please choose department id!");
			    else if(cbodutyid.getSelectedIndex()==0)
		            JOptionPane.showMessageDialog(null,"Please choose duty id!");
			    else if(gender==null || gender.equals(""))
		        {
		        	JOptionPane.showMessageDialog(null,"Please choose gender");
		        }
			    else if(Checking.IsNull(txtexp.getText()))
		        {
		            JOptionPane.showMessageDialog(null, "Please enter Experience you want.");
		            txtexp.requestFocus();
		            txtexp.selectAll();
		        }
		        else
		        {
	                String str[]=new String[4];
	                String did=new String();
	                String duid=new String();
	                did=mySQLQueries.getDepid(cbodepid.getSelectedItem().toString());
	                duid=mySQLQueries.getDutyid(cbodutyid.getSelectedItem().toString());
	                str[0]=did;
	                str[1]=duid;
	                str[2]=(String)txtexp.getText();
	                str[3]=gender;
	                try {
	                String[] search=mySQLQueries.serachData("nurse",str);
	                //System.out.print(search[0]);
	                //System.out.print(search[1]);
	                cbonurse.addItem("-Select-");
	                for(int i=0;i<search.length;i++)
	                    cbonurse.addItem(search[i].toString());
	        		} catch (Exception e1) {
	        			// TODO Auto-generated catch block
	        			e1.printStackTrace();
	        		}
	                panel_1.setVisible(true);
	                
	            clear();
	            cbodepid.requestFocus();
	        }
			}
		});
		btnsearch.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		btnsearch.setBounds(34, 291, 105, 29);
		panel.add(btnsearch);
		
		btncancel = new JButton("Cancel");
		btncancel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		btncancel.setBounds(149, 291, 91, 29);
		panel.add(btncancel);
		
		Label label = new Label("please select to be best");
		label.setFont(new Font("Arial", Font.PLAIN, 13));
		label.setBackground(Color.WHITE);
		label.setBounds(31, 10, 247, 21);
		panel.add(label);
		
		rdomale = new JRadioButton("Male");
		rdomale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdomale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdomale.isSelected()) {
					rdofemale.setSelected(false);
					gender="male";
				}
			}
		});
		rdomale.setBounds(31, 224, 89, 21);
		panel.add(rdomale);
		
		rdofemale = new JRadioButton("Female");
		rdofemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdofemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdofemale.isSelected()) {
					rdomale.setSelected(false);
					gender="female";
				}
			}
		});
		rdofemale.setBounds(135, 224, 105, 21);
		panel.add(rdofemale);
		
		txtexp = new JTextField();
		txtexp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtexp.setText("");
			}
		});
		txtexp.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 10));
		txtexp.setText("eg:2 years");
		txtexp.setBounds(31, 186, 270, 25);
		panel.add(txtexp);
		txtexp.setColumns(10);
		
		Label label_2 = new Label("3.Please enter Experience you want");
		label_2.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		label_2.setBounds(31, 159, 270, 21);
		panel.add(label_2);
		
		Label label_3 = new Label("2.Please select Duty!");
		label_3.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		label_3.setBounds(31, 101, 176, 21);
		panel.add(label_3);
		
		Label label_4 = new Label("1.Please select Department.");
		label_4.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		label_4.setBounds(31, 47, 247, 21);
		panel.add(label_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 402, 1097, 412);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		Label label_1 = new Label("Welcome To Health & Safe World");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_1.setBounds(350, 10, 424, 31);
		contentPanel.add(label_1);
		
		panel_1 = new JPanel();
		panel_1.setBounds(393, 47, 714, 349);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		
		cbonurse = new JComboBox();
		cbonurse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	                String nid=mySQLQueries.getNurseid(cbonurse.getSelectedItem().toString());
	                String[] pac=mySQLQueries.serachPackage(nid);//packageid
	                for(int a=1;a<pac.length;a++)
	                {
	                	System.out.println(pac[a]);
	                }
	                
	                String[] pacdate=mySQLQueries.searchPackdate(pac);//startdate
	                System.out.println(pacdate);
	                dtm.addRow(pacdate);	
					
					
				
			}
		});
		cbonurse.setBounds(154, 21, 305, 33);
		panel_1.add(cbonurse);
		
		btncall = new JButton("Call");
		btncall.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btncall.setBounds(372, 281, 109, 28);
		panel_1.add(btncall);
		
		btnback = new JButton("Back");
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnback.setBounds(505, 281, 109, 28);
		panel_1.add(btnback);
		
		btnview = new JButton("View More");
		btnview.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnview.setBounds(219, 279, 130, 33);
		panel_1.add(btnview);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(154, 64, 550, 194);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		fillDep();
		fillDuty();
		createtable();
	}
	public void fillDep()
    {
        String str[] = null;
		try {
			str = mySQLQueries.getNameForChoice("department");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cbodepid.addItem("-Select-");
        for(int i=0;i<str.length;i++)
            cbodepid.addItem(str[i].toString());
    }
	private void setColumnWidth() {
		// TODO Auto-generated method stub
		
	}

public void fillDuty()
    {
        String str[]=mySQLQueries.getNameForChoice("duty");
        cbodutyid.addItem("-Select-");
        for(int i=0;i<str.length;i++)
            cbodutyid.addItem(str[i].toString());
    }
public void clear()
    {
        cbodepid.setSelectedIndex(0);
        cbodutyid.setSelectedIndex(0);
        rdomale.setSelected(false);
        rdofemale.setSelected(false);
        txtexp.setText("eg:2 years");
        
    }
public void setColumnWidth(int index , int width)
{
    DefaultTableColumnModel tcm = (DefaultTableColumnModel)table.getColumnModel();
    TableColumn tc = tcm.getColumn(index);
    tc.setPreferredWidth(width);
}
 public void createtable()
 {
     dtm.addColumn("Package No");
     dtm.addColumn("Start Date");
     dtm.addColumn("End Date");
     dtm.addColumn("Price");
     dtm.addColumn("Action");
     table.setModel(dtm);
     setColumnWidth(0,60);
      setColumnWidth(1,60);
      setColumnWidth(2,60);
      setColumnWidth(3,60);
      setColumnWidth(4,250);
 }
}
