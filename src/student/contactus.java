package student;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

public class contactus extends JFrame implements ActionListener 
{
	JPanel mainP=new JPanel(null);
	JPanel headP=new JPanel(null);
	JPanel sideP=new JPanel(null);
	JLabel clgname=new JLabel("<html>Chandigarh College of<br>"+"Engineering and Technology");
	JLabel clgimg=new JLabel();
	JButton home=new JButton("Home");
	JButton dashboard=new JButton("DashBoard");
	JButton feedetails=new JButton ("Check Fee Details");
	JButton feestatus=new JButton("Check Fee Status");
	JButton contactus=new JButton("Contact Head's");
	JButton logout=new JButton("LogOut");
	
	JLabel name =new JLabel("Name:- ");
	JTextField namef=new JTextField();
	JLabel studid=new JLabel("Student Id:- ");
	JTextField studidf=new JTextField();
	JComboBox<String> query=new JComboBox<String>();
	JTextArea querya=new JTextArea();
	JButton submit=new JButton("Submit");
	Font main=new Font("Times New Roman",Font.BOLD,16);
	Font fontb=new Font("Times New Roman", Font.BOLD,16);
	
	Connection con;
	PreparedStatement stat;
	
	public contactus()
	{
		add(mainP);
		add(headP);
		add(sideP);
		
		setSize(860,680);
		setTitle("STUDENT");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(220,20);
		setResizable(false);
		
		headP.setBounds(0, 0, 860, 160);
	    sideP.setBounds(0, 160, 195, 500);
	    mainP.setBounds(195, 160, 660, 500);
	 
	    mainP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contact Admin/Accountant", TitledBorder.CENTER, TitledBorder.TOP, new Font("Times New Roman",Font.BOLD,22), new Color(20, 75, 75)));
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
		sideP.add(feedetails);
		sideP.add(feestatus);
		sideP.add(contactus);
		sideP.add(logout);
		
		home.setBounds(15,185 ,165 ,40 );
		dashboard.setBounds(15,245 ,165 ,40 );
		feedetails.setBounds(15,305 ,165 ,40 );
		feestatus.setBounds(15,365 ,165 ,40 );
		contactus.setBounds(15,425 ,165 ,40 );
		logout.setBounds(15,585 ,165 ,40 );

		home.setFont(fontb);
		dashboard.setFont(fontb);
		contactus.setForeground(Color.red);
		feedetails.setFont(fontb);
		feestatus.setFont(fontb);
		contactus.setFont(fontb);
		logout.setFont(fontb);
		
		mainP.add(name);
		mainP.add(namef);
		mainP.add(studid);
		mainP.add(studidf);
		mainP.add(query);
		mainP.add(querya);
		mainP.add(submit);
		
		query.addItem("Query");
		query.addItem("FeedBack");
		
		name.setBounds(110,50 ,120 ,40 );
		name.setFont(main);
		namef.setBounds(240,50 ,200 ,40 );
		namef.setText(dashboardstud.namef.getText());
		namef.setEditable(false);
		studid.setBounds(110,120 ,120 ,40 );
		studid.setFont(main);
		studidf.setBounds(240,120 ,200 ,40 );
		studidf.setText(dashboardstud.idf.getText());
		studidf.setEditable(false);
		query.setBounds(110,190,120,30 );
		query.setFont(main);
		querya.setBounds(240,190 ,250 ,200 );
		querya.setBorder(new LineBorder(Color.black));
		submit.setBounds(200,430,100,40);
		submit.setFont(main);
		
		home.addActionListener(this);
		dashboard.addActionListener(this);
		feedetails.addActionListener(this);
		feestatus.addActionListener(this);
		contactus.addActionListener(this);
		logout.addActionListener(this);
		submit.addActionListener(this);
	}
	
	public static void main(String[] args)
	{
		new contactus();
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
				
					if(query.getSelectedItem()=="Query")
					{	
							java.util.Date cdate=new java.util.Date();
							java.sql.Timestamp timestamp=new java.sql.Timestamp(cdate.getTime());
							System.out.println("Time Stamp= "+timestamp);
					
							stat = con.prepareStatement("INSERT into studentreview(studentid, query, querytime) values(?,?, ?) ");
							stat.setString(1, studidf.getText());
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
						stat = con.prepareStatement("INSERT into studentfeedback(studentid, feedback, feedbacktime) values(?,?, ?) ");
						stat.setString(1, studidf.getText());
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
				
			}catch(Exception exp)
			{
				exp.printStackTrace();
			}
		}
		if(ch.equals("Home"))
		{
			new homestud();
			this.dispose();
		}
		if(ch.equals("DashBoard"))
		{
			new dashboardstud("","");
			this.dispose();
		}
		if(ch.equals("Check Fee Details"))
		{
			new feedetails();
			this.dispose();
		}
		if(ch.equals("Check Fee Status"))
		{
			new FeeStatus("","");
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
	
	

