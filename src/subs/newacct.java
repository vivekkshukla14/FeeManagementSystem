package subs;


import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import admin.*;
import connect.connect;

public class newacct extends JFrame implements ActionListener
{
	JPanel jp=new JPanel(null);
	JLabel head=new JLabel("ADD NEW ACCOUNTANT");
	
	JLabel name=new JLabel("Name:- ");
	JTextField namef=new JTextField();
	JLabel Id=new JLabel("Employee Id:- ");
	JTextField Idf=new JTextField();
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
	
	JButton submit=new JButton("Add Accountant");
	ButtonGroup br=new ButtonGroup();
	
	Font font=new Font("Times New Roman", Font.PLAIN,16);
	private Pattern pattern;
	private Matcher matcher;

	Connection con;
	PreparedStatement stat;
	
	private static final String EMAIL_PATTERN ="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	
	String id;
	public newacct()
	{
		setSize(700,500);
		setTitle("NEW ACCOUNTANT");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(416,206,663,493);
		setResizable(false);

		add(jp);
		jp.setBackground(Color.white);
		
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
		jp.add(fname);
		jp.add(fnamef);
		jp.add(mname);
		jp.add(mnamef);
		jp.add(gender);
		jp.add(male);
		jp.add(female);
		jp.add(trans);
		
		
		jp.add(submit);
		
		head.setBounds(80,10 ,500 ,60);
		head.setFont(new Font("Times New Roman", Font.BOLD,30));
		
		name.setBounds(15,90 ,120 ,30);
		name.setFont(font);
		namef.setBounds(130,90 ,180 ,30);
		fname.setBounds(15,140 ,120 ,30);
		fname.setFont(font);
		fnamef.setBounds(130,140 ,180 ,30);
		dob.setBounds(15,190 ,120 ,30);
		dob.setFont(font);
		dobf.setBounds(130,190 ,180 ,30);
		contact.setBounds(15,240 ,120 ,30);
		contact.setFont(font);
		contactf.setBounds(130,240 ,180 ,30);
		add.setBounds(15,290 ,120 ,30);
		add.setFont(font);
		addf.setBounds(130,290 ,180 ,30);
		
		Id.setBounds(330,90 ,120 ,30);
		Id.setFont(font);
		Idf.setBounds(450,90 ,180 ,30);
		mname.setBounds(330,140 ,120 ,30);
		mname.setFont(font);
		mnamef.setBounds(450,140 ,180 ,30);
		gender.setBounds(330,190 ,120 ,30);
		gender.setFont(font);
		male.setBounds(410,190 ,60 ,30);
		male.setFont(font);
		female.setBounds(470,190 ,70 ,30);
		female.setFont(font);
		trans.setBounds(540,190 ,120 ,30);
		trans.setFont(font);
		email.setBounds(330,240 ,120 ,30);
		email.setFont(font);
		emailf.setBounds(450,240 ,180 ,30);
		
		submit.setBounds(260,360 ,180 ,40);
		submit.setFont(new Font("Times New Roman", Font.BOLD,18));
		
		br.add(trans);
		br.add(female);
		br.add(male);
		
		submit.addActionListener(this);
		
	}
	
	
	public static void main(String[] args)
	{
		new newacct();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String ch=e.getActionCommand();
		if(ch.equals("Add Accountant"))
		{
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
			if(namef.getText()!=null||fnamef.getText()!=null||mnamef.getText()!=null||Idf.getText()!=null
					||emailf.getText()!=null||contactf.getText()!=null||dobf.getText()!=null||addf.getText()!=null)
			{
				
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
					stat=con.prepareStatement("insert into accountant (employeeid, name, gender, fathername, mothername, password, doj , dob, contactno, emailid, address) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
					stat.setString(1, Idf.getText());
					stat.setString(2, namef.getText());
					stat.setString(3, g);
					stat.setString(4, fnamef.getText());
					stat.setString(5, mnamef.getText());
					
					stat.setString(6, Idf.getText());
					stat.setDate(7,currentdate);
					stat.setDate(8, sql);
					stat.setString(9, contactf.getText());
					stat.setString(10, emailf.getText());
					stat.setString(11, addf.getText());
					
					
					int i=stat.executeUpdate();
					
					if(i>0)
					{
						JOptionPane.showMessageDialog(this, "New Accountant has been succesfully Added");
						this.dispose();
					}
				}catch( SQLException sqle){
					sqle.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Error" ,"Detailed entered not correct" ,JOptionPane.ERROR_MESSAGE);
			}
	        }
	        else
	        {
	        	JOptionPane.showMessageDialog(this,"Email Id Entered is not correct" ,"ERROR" ,JOptionPane.ERROR_MESSAGE);
	        }
			
			
			
		
		}
	}
	
}
