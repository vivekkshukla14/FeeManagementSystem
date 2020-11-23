package accountant;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import connect.connect;
import login.login;

public class contactadmin extends JFrame implements ActionListener 
{
	JPanel mainP=new JPanel(null);
	JPanel headP=new JPanel(null);
	JPanel sideP=new JPanel(null);
	JLabel clgname=new JLabel("<html>Chandigarh College of<br>"+"Engineering and Technology");
	JLabel clgimg=new JLabel();
	JButton home=new JButton("Home");
	JButton dashboard=new JButton("DashBoard");
	JButton managestud=new JButton ("<html>Manage Students<br>"+"Details");
	JButton manageacc=new JButton("Manage Accounts");
	JButton contactus=new JButton("Contact Admin");
	JButton logout=new JButton("LogOut");
	
	JLabel name =new JLabel("Name:- ");
	JTextField namef=new JTextField();
	JLabel empid=new JLabel("Employee Id:- ");
	JTextField empidf=new JTextField();
	JComboBox<String> query=new JComboBox<String>();
	JTextArea querya=new JTextArea();
	JButton submit=new JButton("Submit");
	Font main=new Font("Times New Roman",Font.BOLD,16);
	
	Connection con;
	PreparedStatement stat;
	
	Font fontb=new Font("Times New Roman", Font.BOLD,16);
	
	public contactadmin()
	{
		
		add(mainP);
		add(headP);
		add(sideP);
		
		setSize(860,680);
		setTitle("ACCOUNTANT");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(220,20);
		setResizable(false);
		
		headP.setBounds(0, 0, 860, 160);
	    sideP.setBounds(0, 160, 195, 500);
	    mainP.setBounds(195, 160, 660, 500);
	 
	    mainP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contact Admin", TitledBorder.CENTER, TitledBorder.TOP, new Font("Times New Roman",Font.BOLD,22), new Color(20, 75, 75)));
		headP.setBorder(new LineBorder(Color.black,1));
		sideP.setBorder(new LineBorder(Color.black,1));
		mainP.setBackground(Color.WHITE);
		sideP.setBackground(Color.white);
		headP.setBackground(Color.LIGHT_GRAY);
		
		headP.add(clgname);
		headP.add(clgimg);
		
		clgimg.setBounds(0,0 ,860 ,160 );
		try{
			Image img=ImageIO.read(getClass().getResource("/DSC_0003.JPG"));
			clgimg.setIcon(new ImageIcon(img));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		clgname.setBounds(100,10 ,700 ,100 );
		clgname.setFont(new Font("Times New Roman",Font.BOLD,40));
		clgname.setForeground(Color.getHSBColor(88,70 , 89));
		
		
		sideP.add(home);
		sideP.add(dashboard);
		sideP.add(managestud);
		sideP.add(manageacc);
		sideP.add(contactus);
		sideP.add(logout);
		
		home.setBounds(15,185 ,165 ,40 );
		dashboard.setBounds(15,245 ,165 ,40 );
		managestud.setBounds(15,305 ,165 ,40 );
		manageacc.setBounds(15,365 ,165 ,40 );
		contactus.setBounds(15,425 ,165 ,40 );
		logout.setBounds(15,585 ,165 ,40 );

		home.setFont(fontb);
		dashboard.setFont(fontb);
		contactus.setForeground(Color.red);
		managestud.setFont(fontb);
		manageacc.setFont(fontb);
		contactus.setFont(fontb);
		logout.setFont(fontb);
		
		mainP.add(name);
		mainP.add(namef);
		mainP.add(empid);
		mainP.add(empidf);
		mainP.add(query);
		mainP.add(querya);
		mainP.add(submit);
		
		query.addItem("Query");
		query.addItem("FeedBack");
		
		name.setBounds(110,50 ,120 ,40 );
		name.setFont(main);
		namef.setText(dashboardacc.accname);
		namef.setBounds(240,50 ,200 ,40 );
		namef.setEditable(false);
		empid.setBounds(110,120 ,120 ,40 );
		empid.setFont(main);
		empidf.setText(dashboardacc.idf.getText());
		empidf.setBounds(240,120 ,200 ,40 );
		empidf.setEditable(false);
		query.setBounds(110,190,120,30 );
		query.setFont(main);
		querya.setBounds(240,190 ,250 ,200 );
		querya.setBorder(new LineBorder(Color.black));
		submit.setBounds(200,430,100,40);
		submit.setFont(main);
		
		home.addActionListener(this);
		dashboard.addActionListener(this);
		managestud.addActionListener(this);
		manageacc.addActionListener(this);
		contactus.addActionListener(this);
		logout.addActionListener(this);
		submit.addActionListener(this);
	}
	
	public static void main(String[] args)
	{
		new contactadmin();
	}

	String naam,id,queery;
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String ch=e.getActionCommand();
		if(ch.equals("Submit"))
		{
			
			try{
				con=connect.connection();
				stat = con.prepareStatement("select * from accountantreview where employeeid= ?");
				stat.setString(1, empidf.getText());
				ResultSet set = stat.executeQuery();
				if(set.next())
				{
					if(query.getSelectedItem()=="Query")
					{	
							java.util.Date cdate=new java.util.Date();
							java.sql.Timestamp timestamp=new java.sql.Timestamp(cdate.getTime());
							System.out.println("Time Stamp= "+timestamp);
					
							stat = con.prepareStatement("Insert into accountantreview(employeeid, query, querytime) values(?,?,?)");
							stat.setString(1, empidf.getText());
							stat.setString(2, querya.getText());
							stat.setTimestamp(3, timestamp);
							int i= stat.executeUpdate();
							System.out.println("Details Updated ");
							if(i>0)
							{
								JOptionPane.showMessageDialog(this, "Query Sent succesfully", "Successfull", JOptionPane.INFORMATION_MESSAGE);
								querya.setText("");
							}
							else
							{
								JOptionPane.showMessageDialog(this, "Query details not sent", "Unsuccesfull", JOptionPane.ERROR_MESSAGE);
							}
						
					}
					else if(query.getSelectedItem()=="FeedBack")
					{
						
						java.util.Date cdate=new java.util.Date();
						java.sql.Timestamp timestamp=new java.sql.Timestamp(cdate.getTime());
						System.out.println("Time Stamp= "+timestamp);
						stat = con.prepareStatement("Update accountantfeedback set feedback=?, feedbacktime=? where employeeid=?");
						stat.setString(1, querya.getText());
						stat.setTimestamp(2, timestamp);
						stat.setString(3, empidf.getText());
						int i= stat.executeUpdate();
						if(i>0)
						{
							JOptionPane.showMessageDialog(this, "FeedBack sent successfully", "Successfull", JOptionPane.INFORMATION_MESSAGE);
							querya.setText("");
						}
						else
						{
							JOptionPane.showMessageDialog(this, "Feedback not sent succesfully", "Unsuccesfull", JOptionPane.ERROR_MESSAGE);
						}
						
					}
				}
				else
				{
					if(query.getSelectedItem()=="Query")
					{	
							java.util.Date cdate=new java.util.Date();
							java.sql.Timestamp timestamp=new java.sql.Timestamp(cdate.getTime());
							System.out.println("Time Stamp= "+timestamp);
					
							stat = con.prepareStatement("INSERT into accountantreview(employeeid, query, querytime) values(?,?, ?) ");
							stat.setString(1, empidf.getText());
							stat.setString(2, querya.getText());
							stat.setTimestamp(3, timestamp);
							int i= stat.executeUpdate();
							System.out.println("Details Updated ");
							if(i>0)
							{
								JOptionPane.showMessageDialog(this, "Query Sent succesfully", "Successfull", JOptionPane.INFORMATION_MESSAGE);
								querya.setText("");
							}
							else
							{
								JOptionPane.showMessageDialog(this, "Query details not sent", "Unsuccesfull", JOptionPane.ERROR_MESSAGE);
							}
						
					}
					else if(query.getSelectedItem()=="FeedBack")
					{
						
						java.util.Date cdate=new java.util.Date();
						java.sql.Timestamp timestamp=new java.sql.Timestamp(cdate.getTime());
						System.out.println("Time Stamp= "+timestamp);
						stat = con.prepareStatement("INSERT into accountantfeedback(employeeid, feedback, feedbacktime) values(?,?, ?) ");
						stat.setString(1, empidf.getText());
						stat.setString(2, querya.getText());
						stat.setTimestamp(3, timestamp);
						int i= stat.executeUpdate();
						if(i>0)
						{
							JOptionPane.showMessageDialog(this, "FeedBack sent successfully", "Successfull", JOptionPane.INFORMATION_MESSAGE);
							querya.setText("");
						}
						else
						{
							JOptionPane.showMessageDialog(this, "Feedback not sent succesfully", "Unsuccesfull", JOptionPane.ERROR_MESSAGE);
						}
						
					}
				}
			}catch(Exception exp)
			{
				exp.printStackTrace();
			}
		
		}
		if(ch.equals("Home"))
		{
			new home();
			this.dispose();
		}
		if(ch.equals("DashBoard"))
		{
			new dashboardacc("");
			this.dispose();
		}
		if(ch.equals("<html>Manage Students<br>"+"Details"))
		{
			new managestud();
			this.dispose();
		}
		if(ch.equals("Manage Accounts"))
		{
			new manageacc();
			this.dispose();
		}
		if(ch.equals("LogOut"))
		{
			int i=JOptionPane.showConfirmDialog(this, "Are You SURE you want to Logout. ?", "Logout.?", JOptionPane.YES_NO_OPTION);
			if(i==0)
			{
				new login();
				this.dispose();
			}
			
		}
	
	}

	}
	
	

