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
import javax.swing.table.TableModel;
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
import java.awt.SystemColor;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.exceptions.jdbc4.MySQLDataException;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import pack.login;
import pack.register;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import javax.swing.JSlider;
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
	DefaultTableModel dtm1=new DefaultTableModel();
	DefaultTableModel dtm2=new DefaultTableModel();
	private JPanel panel_1;
	private JButton btnback;
	private JButton btncall;
	private JButton btnview;
	private JComboBox cbonurse;
	Vector v=new Vector();
	Vector p=new Vector();
	String strdataitem[]=new String[5];
	private JTable table2;/**
	 * Launch the application.
	 */
	date d=new date();
	register r=new register();
	login l=new login();
	public JLabel lbluser;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	private JLabel date;
	private JLabel cusname;
	private JPanel panel_2;
	Vector vid=new Vector();
	private JLabel t2;
	private JLabel t1;
	private JLabel total;
	private int r1;
	String price[]=new String[1];
	String confirmData[]=new String[5];
	String packid[]=new String[1];
	private JMenuBar menuBar;
	private JMenu mnMore;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JButton btnConfirm;
	private JButton btnCancel;
	private JTable table;
	
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JScrollPane scrollPane_2;
	Connection con;
	clsDBConnection C = new clsDBConnection();
	public class date {
	    private Date today;

	    public date() {
	        this.today = new Date();
	    }

	    public String getMySQLDateFormat() {
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        return formatter.format(this.today);
	    }
	}
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
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1550, 1000);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 160, 122));
		panel.setToolTipText("");
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 58, 538, 401);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		cbodepid = new JComboBox();
		cbodepid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbodepid.setBackground(Color.LIGHT_GRAY);
		cbodepid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cbonurse.setSelectedIndex(0);
				while(dtm.getRowCount()>0)
		            dtm.removeRow(0);
				while(dtm1.getRowCount()>0)
		            dtm1.removeRow(0);
				while(dtm2.getRowCount()>0)
		            dtm2.removeRow(0);
				if(cbonurse.getSelectedIndex()>0)
				{
					cbonurse.removeAllItems();
					hideNursepack();
				}
				
				
				
			}
		});
		cbodepid.setBounds(31, 87, 388, 38);
		panel.add(cbodepid);
		
		cbodutyid = new JComboBox();
		cbodutyid.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbodutyid.setBackground(Color.LIGHT_GRAY);
		cbodutyid.setBounds(31, 171, 388, 37);
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
			    else if(!Checking.IsAllDigit(txtexp.getText().trim()))
			    {
			    	JOptionPane.showMessageDialog(null, "Please enter digit for experience.");
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
	                showNursepack(); 
	            clear();
	            cbodepid.requestFocus();
	        }
			}
		});
		btnsearch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnsearch.setBounds(31, 351, 105, 29);
		panel.add(btnsearch);
		btnsearch.setBackground(SystemColor.info);
		
		btncancel = new JButton("Cancel");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btncancel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btncancel.setBounds(187, 351, 123, 41);
		btncancel.setBackground(SystemColor.info);
		panel.add(btncancel);
		
		Label label = new Label("please select to be best");
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		label.setBackground(new Color(255, 160, 122));
		label.setBounds(31, 10, 388, 28);
		panel.add(label);
		
		rdomale = new JRadioButton("Male");
		rdomale.setBackground(new Color(255, 160, 122));
		rdomale.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdomale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdomale.isSelected()) {
					rdofemale.setSelected(false);
					gender="male";
				}
			}
		});
		rdomale.setBounds(31, 304, 89, 29);
		panel.add(rdomale);
		
		rdofemale = new JRadioButton("Female");
		rdofemale.setBackground(new Color(255, 160, 122));
		rdofemale.setFont(new Font("Times New Roman", Font.BOLD, 15));
		rdofemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdofemale.isSelected()) {
					rdomale.setSelected(false);
					gender="female";
				}
			}
		});
		rdofemale.setBounds(173, 304, 105, 29);
		panel.add(rdofemale);
		
		txtexp = new JTextField();
		txtexp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtexp.setBackground(Color.LIGHT_GRAY);
		txtexp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtexp.setText("");
			}
		});
		txtexp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtexp.setText("eg:2");
		txtexp.setBounds(31, 249, 203, 37);
		panel.add(txtexp);
		txtexp.setColumns(10);
		
		Label label_2 = new Label("3.Please enter Experience you want");
		label_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		label_2.setBounds(31, 214, 388, 29);
		panel.add(label_2);
		
		Label label_3 = new Label("2.Please select Duty!");
		label_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		label_3.setBounds(31, 131, 203, 34);
		panel.add(label_3);
		
		Label label_4 = new Label("1.Please select Department.");
		label_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		label_4.setBounds(31, 44, 247, 29);
		panel.add(label_4);
		
		JLabel lblNewLabel_1 = new JLabel("Years");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setBounds(244, 249, 69, 37);
		panel.add(lblNewLabel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 160, 122));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 469, 1516, 345);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		t2 = new JLabel("Customer Name");
		t2.setBounds(67, 33, 154, 25);
		
		panel_2.add(t2);
		t2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		cusname = new JLabel("");
		cusname.setBounds(57, 68, 124, 24);
		
		panel_2.add(cusname);
		cusname.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		t1 = new JLabel("Date:");
		t1.setBounds(1301, 32, 43, 27);
		
		panel_2.add(t1);
		t1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		date = new JLabel("");
		date.setBounds(1354, 29, 115, 33);
		
		panel_2.add(date);
		date.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		date.setText(d.getMySQLDateFormat());
		
		total = new JLabel("");
		total.setBounds(821, 257, 232, 25);
		panel_2.add(total);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0 ; i<vid.size() ; i++)
                {
					String nid=(String)mySQLQueries.getNurseid(table.getValueAt(i, 0).toString());
					//System.out.println(nid);
					String pid=mySQLQueries.getPacid(table.getValueAt(i, 1).toString(),table.getValueAt(i, 2).toString());
					//System.out.println(pid);
					packid[0]="0";
					int cid=mySQLQueries.getCusid(cusname.getText().toString());
					//System.out.println(cid);
                    boolean save=mySQLQueries.insertConfirmData("calling", pid,nid,cid,date.getText(),table.getValueAt(i,3 ).toString());
                    if(save)
			        {
			            JOptionPane.showMessageDialog(null, "All records are successfully SAVED!");
			            clear();
			            while(dtm.getRowCount()>0)
				            dtm.removeRow(0);
			            hideCall();
			            vid.removeAllElements();
			            mySQLQueries.afterupdateRecord("packagedetail", pid,nid, packid);
			            //cbonurse.setSelectedIndex(0);
			        }
			        else
			        {
			            JOptionPane.showMessageDialog(null, "Records cannot be saved because of some ERROR!");
			            clear();
			        }
                 
                }
			}
		});
		btnConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnConfirm.setBounds(812, 292, 123, 41);
		btnConfirm.setBackground(SystemColor.info);
		panel_2.add(btnConfirm);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(dtm1.getRowCount()>0)
		            dtm1.removeRow(0);
				hideCall();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCancel.setBounds(946, 292,  123, 41);
		btnCancel.setBackground(SystemColor.info);
		panel_2.add(btnCancel);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(57, 94, 1412, 135);
		panel_2.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(67, 57, 1390, 212);
		scrollPane_2.setVisible(false);
		panel_2.add(scrollPane_2);
		
		table_1 = new JTable();
		scrollPane_2.setViewportView(table_1);
		
		Label label_1 = new Label("Welcome To Health & Safe World");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		label_1.setBounds(537, 10, 626, 42);
		contentPanel.add(label_1);
		
		lbluser = new JLabel("");
		lbluser.setBounds(1350, 10, 115, 21);
		contentPanel.add(lbluser);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(1450, 10, 50, 22);
		contentPanel.add(menuBar);
		
		mnMore = new JMenu("MORE:.");
		menuBar.add(mnMore);
		
		mntmNewMenuItem = new JMenuItem("Log Out");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        firstpage fp=new firstpage();
	        fp.show();
	        dispose();
				
			}
		});
		mnMore.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("View History");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//while(dtm2.getRowCount()>0)
		            //dtm2.removeRow(0);
	            if(dtm1.getRowCount()>0)
	            {
	            	JOptionPane.showMessageDialog(null, "Please Click 'Confirm' or 'Cancel'");
	            	btnConfirm.requestFocus();
	            }
	            else
	            {   
	            	scrollPane_2.setVisible(true);
	            	//int cusid=mySQLQueries.getCusid(lbluser.getText().toString());
	            	//String view[]=mySQLQueries.getViewHistory(cusid);
	            	
	            	
	            	fillItem();
	            	
	            }
				
			}
		});
		mnMore.add(mntmNewMenuItem_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(551, 58, 975, 401);
		contentPanel.add(lblNewLabel);
		
		panel_3 = new JPanel();
		panel_3.setBounds(551, 58, 975, 402);
		contentPanel.add(panel_3);
		panel_3.setBackground(new Color(233, 150, 122));
		panel_3.setLayout(null);
		
		
		cbonurse = new JComboBox();
		cbonurse.setBounds(30, 24, 457, 33);
		panel_3.add(cbonurse);
		
		btncall = new JButton("Call");
		btncall.setBounds(396, 269, 141, 44);
		btncall.setBackground(SystemColor.info);
		btncall.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_3.add(btncall);
		btncall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table2.getSelectedRow()<0)
                {
                    JOptionPane.showMessageDialog(null, "Please select row to call");
                }
				else {
					r1=table2.getSelectedRow();
					if(table2.getValueAt(r1, 4)=="Unavailable")
					{
						JOptionPane.showMessageDialog(null, "You can't get this package");
					}
					else {
					showCall();
					scrollPane_2.setVisible(false);
					
					vid.addElement(r1);
					login l=new login();
					cusname.setText(lbluser.getText());
					itemaddmethod();
					Object call[]= {cbonurse.getSelectedItem().toString(),table2.getValueAt(r1, 1),table2.getValueAt(r1, 2),table2.getValueAt(r1, 3)};
					v.addElement(call[3]);
					dtm1.addRow(call);
					total.setText("Total Amount:"+Checking.Sumamount(v,1)+"Kyats");
					}
				}
				
			}
		});
		btnsearch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnsearch.setBounds(31, 351,  141, 41);
		
		btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				hideNursepack();
				
					cbonurse.removeAllItems();
					hideCall();
					scrollPane_1.setVisible(false);
				
			}
		});
		btnback.setBounds(618, 271, 141, 41);
		btnback.setBackground(SystemColor.info);
		panel_3.add(btnback);
		btnback.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_3.setBackground(new Color(255, 160, 122));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 160, 122));
		panel_1.setBounds(0, 0, 975, 402);
		panel_3.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 64, 931, 194);
		panel_1.add(scrollPane);
		
		table2 = new JTable();
		scrollPane.setViewportView(table2);
		scrollPane.setVisible(false);
		cbonurse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(dtm.getRowCount()>0)
				{
					dtm.removeRow(0);
				}
				if(cbonurse.getSelectedIndex() >0) {
					 String nid=mySQLQueries.getNurseid(cbonurse.getSelectedItem().toString());
		                String[] pac=mySQLQueries.serachPackage(nid);//packageid
		                String action="";
		                for(int i=0;i<pac.length;i++)
		                {
		                	
		                	String[] pacdate=mySQLQueries.searchPackdate(pac[i]);
		                	String[] price=mySQLQueries.serachPrice(pac[i],nid);
		                	System.out.print(price[1]);
			                if(price[1].equals("1"))
			                {
			                	action="Available";
			                }
			                else
			                {
			                	action="Unavailable";
			                }
		                	Object []dataRow= {i+1,pacdate[0],pacdate[1],price[0],action};
		                	dtm.addRow(dataRow);
		               	
		                }
				}
	               
				
			}
		});
		//cbouser.setSelectedItem(l.patientname);
		fillDep();
		fillDuty();
		createtable();
		createtable_1();
		createtable_view();
		hideCall();
		hideNursepack();
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
    DefaultTableColumnModel tcm = (DefaultTableColumnModel)table2.getColumnModel();
    TableColumn tc = tcm.getColumn(index);
    tc.setPreferredWidth(width);
}
public void setColumnWidth_1(int index , int width)
{
	DefaultTableColumnModel tcm_1 = (DefaultTableColumnModel)table.getColumnModel();
    TableColumn tc_1 = tcm_1.getColumn(index);
    tc_1.setPreferredWidth(width);
}
public void setColumnWidth_2(int index , int width)
{
	DefaultTableColumnModel tcm_2 = (DefaultTableColumnModel)table_1.getColumnModel();
    TableColumn tc_2 = tcm_2.getColumn(index);
    tc_2.setPreferredWidth(width);
}
 public void createtable()
 {
     dtm.addColumn("Package No");
     dtm.addColumn("Start Date");
     dtm.addColumn("End Date");
     dtm.addColumn("Price");
     dtm.addColumn("On Call");
     //dtm.addColumn("Action");
     table2.setModel(dtm);
     setColumnWidth(0,50);
      setColumnWidth(1,100);
      setColumnWidth(2,100);
      setColumnWidth(3,100);
      setColumnWidth(4,100);
      //setColumnWidth(5,100);
 }
 public void createtable_1()
 {
	 dtm1.addColumn("Nurse Name");
     dtm1.addColumn("Start Date");
     dtm1.addColumn("End Date");
     dtm1.addColumn("Price");
     table.setModel(dtm1);
     setColumnWidth_1(0,200);
      setColumnWidth_1(1,100);
      setColumnWidth_1(2,100);
      setColumnWidth_1(3,100);
 }
 public void createtable_view()
 {
	 dtm2.addColumn("Nurse Name");
     dtm2.addColumn("Package's Start Date");
     dtm2.addColumn("Package's End Date");
     dtm2.addColumn("Called Date");
     dtm2.addColumn("Price");
     table_1.setModel(dtm2);
     setColumnWidth_2(0,200);
      setColumnWidth_2(1,100);
      setColumnWidth_2(2,100);
      setColumnWidth_2(3,100);
      setColumnWidth_2(4,100);
 }
 
 public void hideCall()
 {
	 scrollPane_1.setVisible(false);
	 t2.setVisible(false);////////
	 cusname.setVisible(false);///////
	 t1.setVisible(false);
	 date.setVisible(false);
	 total.setVisible(false);
	 btnConfirm.setVisible(false);
	 btnCancel.setVisible(false);
 }
 public void showCall()
 {
	 t2.setVisible(true);////////
	 cusname.setVisible(true);///////
	 t1.setVisible(true);
	 date.setVisible(true);
	 scrollPane_1.setVisible(true);
	 total.setVisible(true);
	 btnConfirm.setVisible(true);
	 btnCancel.setVisible(true);
 }
 public void showNursepack()
 {
	 panel_1.setVisible(true);
     scrollPane.setVisible(true);
     btncall.setVisible(true);
     btnback.setVisible(true);
     cbonurse.setVisible(true);
 }
 public void hideNursepack()
 {
     scrollPane.setVisible(false);
     btncall.setVisible(false);
     btnback.setVisible(false);
     cbonurse.setVisible(false);
 }
 public void itemaddmethod()
 {
	 
 }
 public void fillItem()
 {
     String strdataitem[]=new String[5];
     String strquery[]=new String[2];
     String strnurse[]=new String[4];
     try{
    	 con = C.getConnection();
         Statement ste = (Statement) con.createStatement();
         String str = "select * from calling";
         ResultSet rs = ste.executeQuery(str);
         while(rs.next())
         {
        	 strnurse=mySQLQueries.getnurseData(rs.getString(3));
        	 strdataitem[0]=strnurse[0];
             strquery = mySQLQueries.searchPackdate(rs.getString(2));//start//end
             strdataitem[1]=strquery[0];
            strdataitem[2]=strquery[1];
            //System.out.print(rs.getString(3));
            strdataitem[3]=rs.getString(5);
            strdataitem[4]=rs.getString(6);
            dtm2.addRow(strdataitem);
         }
         table_1.setModel(dtm2);
     }
     catch(SQLException sqle)
     {
         System.out.println(sqle);
     }
 }

}