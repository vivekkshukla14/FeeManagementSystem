package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import accountant.*;
import connect.connect;

public class password extends JFrame implements ActionListener 
{
	JPanel jp=new JPanel(null);
	JLabel cpass=new JLabel("Current password");
	JTextField cpassf=new JTextField();
	JLabel newpass=new JLabel("New password");
	JPasswordField newpassf=new JPasswordField();
	JLabel confirmpass=new JLabel("New password");
	JPasswordField confirmpassf=new JPasswordField();
	JButton submit=new JButton("Submit");
	static String a,b,c,table;
	String password;
	
	Connection con;
	PreparedStatement stat;
	ResultSet set;
	
	static String studid,cons;
	public password(String id)
	{
		studid=id;
		
		add(jp);
		jp.add(cpass);
		jp.add(cpassf);
		jp.add(newpass);
		jp.add(newpassf);
		jp.add(confirmpass);
		jp.add(confirmpassf);
		jp.add(submit);
		
		if(studid.contains("acc"))
		{
			table="accountant";
			cons="employeeid";
		}
		else if(studid.contains("admin"))
		{
			table="admin";
			cons="employeeid";
		}
		else if(studid.contains("cse"))
		{
			table="cse";
			cons="studentid";
		}
		else if(studid.contains("civil"))
		{
			table="civil";
			cons="studentid";
		}
		else if(studid.contains("mec"))
		{
			table="mechanical";
			cons="studentid";
		}
		else if(studid.contains("ece"))
		{
			table="ece";
			cons="studentid";
		}
		else if(studid.contains("aa"))
		{
			table="architecture";
			cons="studentid";
		}
		else if(studid.contains("prod"))
		{
			table="production";
			cons="studentid";
		}
		else if(studid.contains("elec"))
		{
			table="electrical";
			cons="studentid";
		}
		  
		
		cpass.setBounds(10,5,150,30);
		cpassf.setBounds(170,5,220,30);
		newpass.setBounds(10,45,150,30);
		newpassf.setBounds(170,45,220,30);
		confirmpass.setBounds(10,85,150,30);
		confirmpassf.setBounds(170,85,220,30);
		submit.setBounds(150,135,100,30);
		
		submit.addActionListener(this);
		setSize(400,200);
		setTitle("Password Manager");
		setResizable(false);
		setVisible(true);
		setLocation(417,206);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}


	public static void main(String[] args)
	{
		new password(studid);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Submit"))
		{
			System.out.println("button");
			System.out.println(studid);
			System.out.println(table);
			a=cpassf.getText();
			b=newpassf.getText();
			c=confirmpassf.getText();
			
			try{
				con=connect.connection();
				stat=con.prepareStatement("select password from "+ table +" where "+ cons +"=?");
				stat.setString(1, studid);
				set=stat.executeQuery();
			if(set.next())
			{
				System.out.println("CUREENT PASSWORD MATCH");
				password=set.getString(1);
				if(a.equals(password))
				{
					if(b.equals(c))
					{
						System.out.println("PASSWORD MATCH");
						stat=con.prepareStatement("Update "+ table +" set password=? where "+ cons +"=?");
						stat.setString(1, c);
						stat.setString(2, studid);
						int i=stat.executeUpdate();
						if(i>0)
						{
							JOptionPane.showMessageDialog(this, "Password Succesfully Changed", "Changed!!!",JOptionPane.INFORMATION_MESSAGE);
							this.dispose();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(this, "New Password do not Match","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Current Password Do Not Match","Error!!",JOptionPane.ERROR_MESSAGE);
				}
			}
			
			}catch(Exception exp)
			{
			exp.printStackTrace();;
			}
		}
	}
}
	


