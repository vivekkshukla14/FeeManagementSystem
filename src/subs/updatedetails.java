package subs;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import admin.manageacct;
import connect.connect;

public class updatedetails extends JFrame implements ActionListener,  KeyListener
{

	JPanel jp=new JPanel(null);
	JLabel head=new JLabel("<html><b><u>UPDATE STUDENT DEATILS</u>");
	
	JLabel name=new JLabel("Name:- ");
	JTextField namef=new JTextField();
	JLabel Id=new JLabel("Employee Id:- ");
	JTextField Idf=new JTextField();
	JLabel dob=new JLabel("D.O.B:- ");
	JTextField dobf=new JTextField();
	JLabel gender=new JLabel("Gender:- ");
	JTextField genderf=new JTextField();
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
	JLabel doj=new JLabel("Date of Joining:- ");
	JTextField dojf=new JTextField();
	
	JButton done=new JButton("Done");
	Connection con;
	PreparedStatement stat;
	ResultSet set;
	
	static String pass;
	
	public updatedetails()
	{
		pass=manageacct.text2;
		
		add(jp);
		
		setTitle("FEE MANAGEMENT SYSYTEM");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(860,680);
		setBounds(416,206,663,493);
		setResizable(false);

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
		jp.add(doj);
		jp.add(dojf);
		jp.add(dob);
		jp.add(dobf);
		jp.add(email);
		jp.add(emailf);
		jp.add(fname);
		jp.add(fnamef);
		jp.add(mname);
		jp.add(mnamef);
		jp.add(gender);
		jp.add(genderf);
		
		
		jp.add(done);
		
		head.setBounds(130,10 ,450 ,40);
		head.setFont(new Font("Californian FB", Font.BOLD,30));
		
		name.setBounds(20,90 ,130 ,30);
		namef.setBounds(120,90 ,180 ,30);
		namef.setEditable(false);
		fname.setBounds(20,140 ,130 ,30);
		fnamef.setBounds(120,140 ,180 ,30);
		fnamef.setEditable(false);
		dob.setBounds(20,190 ,130 ,30);
		dobf.setBounds(120,190 ,180 ,30);
		dobf.setEditable(false);
		contact.setBounds(20,240 ,130 ,30);
		contactf.setBounds(120,240 ,180 ,30);
		add.setBounds(20,290 ,130 ,30);
		addf.setBounds(120,290 ,180 ,30);
		
		Id.setBounds(320,90 ,130 ,30);
		Idf.setBounds(420,90 ,180 ,30);
		Idf.setText(pass);
		Idf.setEditable(false);
		mname.setBounds(320,140 ,130 ,30);
		mnamef.setBounds(420,140 ,180 ,30);
		mnamef.setEditable(false);
		gender.setBounds(320,190 ,130 ,30);
		genderf.setBounds(420,190 ,180 ,30);
		genderf.setEditable(false);
		email.setBounds(320,240 ,130 ,30);
		emailf.setBounds(420,240 ,180 ,30);
		doj.setBounds(320,290 ,130 ,30);
		dojf.setBounds(420,290 ,180 ,30);
		dojf.setEditable(false);
	
			
		try{
			con=connect.connection();
			stat=con.prepareStatement("select * from accountant where employeeid=(?)");
			stat.setString(1, pass);
			
			set= stat.executeQuery();
			while(set.next())
			{
				namef.setText(""+(set.getString("name")));
				fnamef.setText("" +(set.getString("fathername")));
				mnamef.setText(""+ (set.getString("mothername")));
				genderf.setText(""+(set.getString("gender")));
				emailf.setText(""+ (set.getString("emailid")));
				dobf.setText(""+ (set.getString("dob")));
				dojf.setText(""+ (set.getString("doj")));
				contactf.setText(""+(set.getString("contactno")));
				addf.setText(""+(set.getString("address")));
			}
			
		}catch(SQLException exc){
			exc.printStackTrace();
		}
		
		//buttons
		done.setBounds(270,350 ,150 ,40);
		done.grabFocus();
				
		//ActionListener
		done.addActionListener(this);
		done.addKeyListener(this);
	}
	
	
	public static void main(String[] args)
	{
		new updatedetails();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Done"))
		{int i;
			try{
				
				con=connect.connection();
				stat=con.prepareStatement("Update accountant Set contactno=(?), emailid=(?), address=(?) where employeeid= ? ");
				stat.setString(1, contactf.getText());
				stat.setString(2, emailf.getText());
				stat.setString(3, addf.getText());
				stat.setString(4, Idf.getText());
				
				i= stat.executeUpdate();
				System.out.println("Details Updated ");
				if(i>0)
				{
					JOptionPane.showMessageDialog(this, "Accountant Details Updated", "Successfull", JOptionPane.INFORMATION_MESSAGE);
					this.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Accountant Details Not Updated Updated", "Unsuccesfull", JOptionPane.ERROR_MESSAGE);
				}
				
			}catch( SQLException sqle)
			{
				sqle.printStackTrace();
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
		if(e.getKeyChar()==KeyEvent.VK_ENTER)
		{
			this.dispose();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
