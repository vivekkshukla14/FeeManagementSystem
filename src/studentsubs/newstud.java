package studentsubs;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import connect.connect;

public class newstud extends JFrame implements ActionListener, KeyListener
{
	JPanel jp=new JPanel(null);
	JLabel head=new JLabel("ADD NEW STUDENT");
	
	JLabel name=new JLabel("Name:- ");
	JTextField namef=new JTextField();
	JLabel Id=new JLabel("Student Id:- ");
	JTextField Idf=new JTextField();
	JLabel trade=new JLabel("Trade:- ");
	JComboBox<String> tradef=new JComboBox<String>();
	JLabel dob=new JLabel("D.O.B:- ");
	JTextField dobf=new JTextField();
	JLabel gender=new JLabel("Gender:- ");
	JCheckBox male=new JCheckBox("Male");
	JCheckBox female=new JCheckBox("Female");
	JCheckBox trans=new JCheckBox("Transgender");
	JLabel fname=new JLabel("Father's Name:- ");
	JTextField fnamef=new JTextField();
	JLabel mname=new JLabel("Mother's Name:- ");
	JTextField mnamef=new JTextField();
	JLabel contact=new JLabel("Contact No.:- ");
	JTextField contactf=new JTextField();
	JLabel add=new JLabel("Address:- ");
	JTextField addf=new JTextField();
	JLabel email=new JLabel("Email Id:- ");
	JTextField emailf=new JTextField();
	JLabel quali=new JLabel("Qualification:- ");
	JComboBox<String> qualif=new JComboBox<String>();
	JLabel totalfee=new JLabel("Total Fees:- ");
	JTextField totalfeef=new JTextField();
	JLabel feep=new JLabel("Fee Paid:- ");
	JTextField feepf=new JTextField();
	JLabel feel=new JLabel("Fee Left:- ");
	JTextField feelf=new JTextField();
	
	JButton submit=new JButton("Add Student");
	
	ButtonGroup br=new ButtonGroup();
	Font font=new Font("Times New Roman", Font.PLAIN,16);
	
	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN ="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	
	Connection con;
	PreparedStatement stat;
	
	JLabel alert= new JLabel();
	String id;
	
	public newstud()
	{
		setTitle("FEE MANAGEMENT SYSYTEM");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(860,680);
		setBounds(416,206,663,493);
		setResizable(false);

		add(jp);
		jp.setBackground(Color.WHITE);
		
		jp.add(head);
		jp.add(name);
		jp.add(namef);
		jp.add(Id);
		jp.add(Idf);
		jp.add(add);
		jp.add(addf);
		jp.add(contact);
		jp.add(contactf);
		jp.add(dob);
		jp.add(dobf);
		jp.add(email);
		jp.add(emailf);
		jp.add(feel);
		jp.add(feelf);
		jp.add(feep);
		jp.add(feepf);
		jp.add(fname);
		jp.add(fnamef);
		jp.add(mname);
		jp.add(mnamef);
		jp.add(gender);
		jp.add(male);
		jp.add(female);
		jp.add(trans);
		jp.add(quali);
		jp.add(qualif);
		jp.add(totalfee);
		jp.add(totalfeef);
		jp.add(trade);
		jp.add(tradef);
		jp.add(alert);
		jp.add(submit);
		
		head.setBounds(150,10 ,450 ,40);
		head.setFont(new Font("Times New Roman", Font.BOLD,30));
		
		name.setBounds(20,90 ,110 ,30);
		name.setFont(font);
		namef.setBounds(120,90 ,180 ,30);
		fname.setBounds(20,140 ,110 ,30);
		fname.setFont(font);
		fnamef.setBounds(120,140 ,180 ,30);
		trade.setBounds(20,190 ,110 ,30);
		trade.setFont(font);
		tradef.setBounds(120,190 ,180 ,30);
		dob.setBounds(20,240 ,110 ,30);
		dob.setFont(font);
		dobf.setBounds(120,240 ,180 ,30);
		contact.setBounds(20,290 ,110 ,30);
		contact.setFont(font);
		contactf.setBounds(120,290 ,180 ,30);
		add.setBounds(20,340 ,110 ,30);
		add.setFont(font);
		addf.setBounds(120,340 ,180 ,30);
		
		Id.setBounds(320,90 ,110 ,30);
		Id.setFont(font);
		Idf.setBounds(440,90 ,180 ,30);
		mname.setBounds(320,140 ,110 ,30);
		mname.setFont(font);
		mnamef.setBounds(440,140 ,180 ,30);
		gender.setBounds(320,190 ,110 ,30);
		gender.setFont(font);
		male.setBounds(410,190 ,60 ,30);
		male.setFont(font);
		female.setBounds(470,190 ,70 ,30);
		female.setFont(font);
		trans.setBounds(540,190 ,110 ,30);
		trans.setFont(font);
		email.setBounds(320,240 ,110 ,30);
		email.setFont(font);
		emailf.setBounds(440,240 ,180 ,30);
		quali.setBounds(320,290 ,110 ,30);
		quali.setFont(font);
		qualif.setBounds(440,290 ,180 ,30);
		
		
		alert.setBounds(400,330,300,30);
		alert.setForeground(Color.red);
		alert.setFont(new Font("Times New Roman",Font.BOLD,18));
		//totalfee  fee paid feel left 
		tradef.addItem("");
		tradef.addItem("CSE");
		tradef.addItem("ECE");
		tradef.addItem("Civil Engg.");
		tradef.addItem("Electrical Engg.");
		tradef.addItem("Architecture Engg.");
		tradef.addItem("Production Engg.");
		tradef.addItem("Mechanical Engg.");
		tradef.setFont(font);
		qualif.addItem("");
		qualif.addItem("10th Pass");
		qualif.addItem("ITI Pass");
		qualif.addItem("+2 Pass");
		
		dobf.setToolTipText("dd-mm-yyyy");
		
		submit.setBounds(280,410 ,150 ,40);
		submit.setFont(new Font("Times New Roman", Font.BOLD,18));
		br.add(male);
		br.add(female);
		br.add(trans);
		
		
		submit.addActionListener(this);
		namef.addKeyListener(this);
		fnamef.addKeyListener(this);
		mnamef.addKeyListener(this);
		Idf.addKeyListener(this);
		emailf.addKeyListener(this);
		qualif.addKeyListener(this);
		contactf.addKeyListener(this);
		addf.addKeyListener(this);
		dobf.addKeyListener(this);
		male.addActionListener(this);
		female.addActionListener(this);
		trans.addActionListener(this);
	}
	
	public static void main(String[] args)
	{
		new newstud();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String ch=e.getActionCommand();
		if(ch.equals("Add Student"))
		{
			System.out.println("BUTTON WORKING");
			String table=null;
			if(tradef.getSelectedIndex()==1)
			{
				table="cse";
			}
			if(tradef.getSelectedIndex()==2)
			{
				table="ece";
			}
			if(tradef.getSelectedIndex()==3)
			{
				table="civil";
			}
			if(tradef.getSelectedIndex()==4)
			{
				table="electrical";
			}
			if(tradef.getSelectedIndex()==5)
			{
				table="architecture";
			}
			if(tradef.getSelectedIndex()==6)
			{
				table="production";
			}
			if(tradef.getSelectedIndex()==7)
			{
				table="mechanical";
			}
			System.out.println(table);

			String g=null;
			if(br.getSelection()==null)
			{
				JOptionPane.showMessageDialog(this, "select the Gender","Error",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if(male.isSelected())
				{
					g="m";
				}
				else if(female.isSelected())
				{
					g="f";
				}
				else if(trans.isSelected())
				{
					g="o";
				}	
			}
			
			pattern = Pattern.compile(EMAIL_PATTERN);
	        if(emailf.getText().matches(EMAIL_PATTERN))
	        {
	           System.out.println("valid");
	        	
			if(namef.getText()!=null||fnamef.getText()!=null||mnamef.getText()!=null||Idf.getText()!=null||
						tradef.getSelectedItem()!=null||emailf.getText()!=null||contactf.getText()!=null
						||qualif.getSelectedItem()!=null||dobf.getText()!=null||addf.getText()!=null)
				{int sem = 3;
					if(qualif.getSelectedItem().equals("10th Pass"))
					{
						sem=1;
					}
					else if(qualif.getSelectedItem().equals("ITI Pass"))
					{
						sem=3;
					}
					else if(qualif.getSelectedItem().equals("+2 Pass"))
					{
						sem=3;
					}
					
					try{
						id=Idf.getText();
						SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
						java.util.Date parsed = format.parse(dobf.getText());
						java.sql.Date sql = new java.sql.Date(parsed.getTime());
						System.out.println("SQL date is= "+sql);
						
						java.util.Date cdate=new java.util.Date();
						java.sql.Date currentdate=new java.sql.Date(cdate.getTime());
						System.out.println("current date is= "+currentdate);
						
						con=connect.connection();
						stat=con.prepareStatement("insert into "+ table + "(studentid, name, gender, fathername, mothername, branch, semester, password, doa, dob, contactno, email, address, qualification) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
						stat.setString(1, Idf.getText());
						stat.setString(2, namef.getText());
						stat.setString(3, g);
						stat.setString(4, fnamef.getText());
						stat.setString(5, mnamef.getText());
						stat.setString(6, (String) tradef.getSelectedItem());
						stat.setInt(7, sem);
						stat.setString(8, Idf.getText());
						stat.setDate(9,currentdate);
						stat.setDate(10, sql);
						stat.setString(11, contactf.getText());
						stat.setString(12, emailf.getText());
						stat.setString(13, addf.getText());
						stat.setString(14, (String) qualif.getSelectedItem());
						
						int i= stat.executeUpdate();
						if(i>0)
						{
							JOptionPane.showMessageDialog(this, "Details Entered");
							new feestatus(Idf.getText(),table);
							this.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(this, "Details Not Entered");
						}
						
					}catch(SQLException sqle){
						sqle.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e1.getMessage(),"ERROR",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Error" ,"Detailed entered not correct" ,JOptionPane.ERROR_MESSAGE);
				}
	        }
	        else
	        {
	            JOptionPane.showMessageDialog(this, "not done", "change", WIDTH, null);
	        }
		}
	        
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==namef)
		{
				if(e.getKeyCode()>=65 && e.getKeyCode()<=90|| e.getKeyCode()==96 && e.getKeyCode()==122 || e.getKeyChar()==KeyEvent.VK_SPACE|| e.getKeyChar()==KeyEvent.VK_BACK_SPACE)
		        {
		            namef.setEditable(true);
		            alert.setText("");
		        }
		        else
		        {
		            namef.setEditable(false);
		            alert.setText(" *Enter only characters (a-z)");
		        }
		}
		if(e.getSource()==fnamef)
		{
				if(e.getKeyCode()>=65 && e.getKeyCode()<=90|| e.getKeyCode()==96 && e.getKeyCode()==122 || e.getKeyChar()==KeyEvent.VK_SPACE|| e.getKeyChar()==KeyEvent.VK_BACK_SPACE)
		        {
		            fnamef.setEditable(true);
		            alert.setText("");
		        }
		        else
		        {
		            fnamef.setEditable(false);
		            alert.setText(" *Enter only characters (a-z)");
		        }
		}
		if(e.getSource()==mnamef)
		{
				if(e.getKeyCode()>=65 && e.getKeyCode()<=90|| e.getKeyCode()==96 && e.getKeyCode()==122 || e.getKeyChar()==KeyEvent.VK_SPACE|| e.getKeyChar()==KeyEvent.VK_BACK_SPACE)
		        {
		            mnamef.setEditable(true);
		            alert.setText("");
		        }
		        else
		        {
		            mnamef.setEditable(false);
		            alert.setText(" *Enter only characters (a-z)");
		        }
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
