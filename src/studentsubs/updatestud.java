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
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import accountant.managestud;
import admin.*;

public class updatestud extends JFrame implements ActionListener,  KeyListener
{

	JPanel jp=new JPanel(null);
	JLabel head=new JLabel("<html><b><u>UPDATE STUDENT DEATILS</u>");
	
	JLabel name=new JLabel("Name:- ");
	JTextField namef=new JTextField();
	JLabel Id=new JLabel("Student Id:- ");
	JTextField Idf=new JTextField();
	JLabel trade=new JLabel("Trade:- ");
	JTextField tradef=new JTextField();
	JLabel rollno=new JLabel("Roll No:- ");
	JTextField rollnof=new JTextField();
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
	JLabel quali=new JLabel("Qualification:- ");
	JTextField qualif=new JTextField();
	JLabel doa=new JLabel("Date of Admission:- ");
	JTextField doaf=new JTextField();
	JLabel totalfee=new JLabel("Total Fees:- ");
	JTextField totalfeef=new JTextField();
	JLabel feep=new JLabel("Fee Paid:- ");
	JTextField feepf=new JTextField();
	JLabel feel=new JLabel("Fee Left:- ");
	JTextField feelf=new JTextField();
	
	JButton done=new JButton("Done");
	Connection con;
	PreparedStatement stat;
	ResultSet set;
	
	static String pass;
	static String branch;
	public updatestud()
	{
		pass=managestud.text2;
		branch=managestud.table;
		add(jp);
		setSize(860,680);
		setTitle("FEE MANAGEMENT SYSYTEM");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(220,20);
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
		jp.add(doa);
		jp.add(doaf);
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
		jp.add(genderf);
		jp.add(quali);
		jp.add(qualif);
		jp.add(rollno);
		jp.add(rollnof);
		jp.add(totalfee);
		jp.add(totalfeef);
		jp.add(trade);
		jp.add(tradef);
		
		jp.add(done);
		
		head.setBounds(200,10 ,450 ,40);
		head.setFont(new Font("Californian FB", Font.BOLD,30));
		
		name.setBounds(20,90 ,130 ,30);
		namef.setBounds(160,90 ,180 ,30);
		namef.setEditable(false);
		fname.setBounds(20,140 ,130 ,30);
		fnamef.setBounds(160,140 ,180 ,30);
		fnamef.setEditable(false);
		trade.setBounds(20,190 ,130 ,30);
		tradef.setBounds(160,190 ,180 ,30);
		tradef.setEditable(false);
		dob.setBounds(20,240 ,130 ,30);
		dobf.setBounds(160,240 ,180 ,30);
		dobf.setEditable(false);
		contact.setBounds(20,290 ,130 ,30);
		contactf.setBounds(160,290 ,180 ,30);
		add.setBounds(20,340 ,130 ,30);
		addf.setBounds(160,340 ,180 ,30);
		doa.setBounds(20,390 ,130 ,30);
		doaf.setBounds(160,390 ,180 ,30);
		doaf.setEditable(false);
		
		Id.setBounds(460,90 ,130 ,30);
		Idf.setBounds(600,90 ,180 ,30);
		Idf.setText(pass);
		Idf.setEditable(false);
		mname.setBounds(460,140 ,130 ,30);
		mnamef.setBounds(600,140 ,180 ,30);
		mnamef.setEditable(false);
		rollno.setBounds(460,190 ,130 ,30);
		rollnof.setBounds(600,190 ,180 ,30);
		rollnof.setEditable(false);
		gender.setBounds(460,240 ,130 ,30);
		genderf.setBounds(600,240 ,180 ,30);
		genderf.setEditable(false);
		email.setBounds(460,290 ,130 ,30);
		emailf.setBounds(600,290 ,180 ,30);
		quali.setBounds(460,340 ,130 ,30);
		qualif.setBounds(600,340 ,180 ,30);
		qualif.setEditable(false);
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/fms", "root","");
			stat=con.prepareStatement("select * from "+ branch +" where studentid=(?)");
			stat.setString(1, pass);
			
			set= stat.executeQuery();
			while(set.next())
			{
				namef.setText(""+(set.getString("name")));
				fnamef.setText("" +(set.getString("fathername")));
				mnamef.setText(""+ (set.getString("mothername")));
				tradef.setText(""+(set.getString("branch")));
				rollnof.setText(""+ (set.getString("studentid")));
				genderf.setText(""+(set.getString("gender")));
				emailf.setText(""+ (set.getString("email")));
				qualif.setText(""+ (set.getString("qualification")));
				dobf.setText(""+ (set.getString("dob")));
				doaf.setText(""+ (set.getString("doa")));
				contactf.setText(""+(set.getString("contactno")));
				addf.setText(""+(set.getString("address")));
			}
			
		}catch(ClassNotFoundException | SQLException exc){
			exc.printStackTrace();
		}
		
		//buttons
		done.setBounds(300,550 ,150 ,40);
		done.grabFocus();
				
		//ActionListener
		done.addActionListener(this);
		done.addKeyListener(this);
	}
	
	
	public static void main(String[] args)
	{
		new updatestud();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Done"))
		{int i;
			try{
				
				Class.forName("com.mysql.jdbc.Driver");
				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/fms", "root","");
				stat=con.prepareStatement("Update "+ branch +" Set contactno=(?), email=(?), address=(?) where studentid= ? ");
				stat.setString(1, contactf.getText());
				stat.setString(2, emailf.getText());
				stat.setString(3, addf.getText());
				stat.setString(4, Idf.getText());
				i= stat.executeUpdate();
				
				if(i>0)
				{
					JOptionPane.showMessageDialog(this, "Student Details Updated", "Successfull", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}catch(ClassNotFoundException | SQLException sqle)
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
