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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import connect.connect;
import login.login;
import studentsubs.accdetails;


public class manageacc extends JFrame implements ActionListener 
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
	
	JLabel studid= new JLabel("Enter the Id of the Studnet:- ");
	JTextField studidf=new JTextField();
	JLabel branch= new JLabel("Choose the Branch: -");
	JComboBox<String> trade=new JComboBox<String>();
	JButton enter=new JButton("Enter");
	
	Font fontb=new Font("Times New Roman", Font.BOLD,16);
	Connection con;
	PreparedStatement stat;
	ResultSet set;
	
	String id;
	public manageacc()
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
	 
	    mainP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Manage Student Fee", TitledBorder.CENTER, TitledBorder.TOP, new Font("Times New Roman",Font.BOLD,22), new Color(20, 75, 75)));
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
		manageacc.setForeground(Color.red);
		managestud.setFont(fontb);
		manageacc.setFont(fontb);
		contactus.setFont(fontb);
		logout.setFont(fontb);
		
		mainP.add(studid);
		mainP.add(studidf);
		mainP.add(branch);
		mainP.add(trade);
		mainP.add(enter);
		
		studid.setBounds(160,50 ,200 ,30 );
		studidf.setBounds(210,105 ,200 ,30 );
		branch.setBounds(160,170,200,30);
		trade.setBounds(210,230,200,30);
		enter.setBounds(240,300,150,40);
	
		trade.addItem("");
		trade.addItem("CSE");
		trade.addItem("ECE");
		trade.addItem("Civil Engg.");
		trade.addItem("Electrical Engg.");
		trade.addItem("Architecture Engg.");
		trade.addItem("Production Engg.");
		trade.addItem("Mechanical Engg.");
		
		home.addActionListener(this);
		dashboard.addActionListener(this);
		managestud.addActionListener(this);
		manageacc.addActionListener(this);
		contactus.addActionListener(this);
		logout.addActionListener(this);
		enter.addActionListener(this);
	}
	
	public static void main(String[] args)
	{
		new manageacc();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	
		String ch=e.getActionCommand();
		if(ch.equals("Enter"))
		{
			id=studidf.getText();
			try{
				String tradef= trade.getSelectedItem().toString();
				con=connect.connection();
				stat= con.prepareStatement("select * from "+ tradef + " where studentid=? ");
				stat.setString(1, studidf.getText());
			
				set =stat.executeQuery();
				
				if(set.next())
				{
					new accdetails(id,tradef);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Please Enter Valid Student Id", "Error", JOptionPane.ERROR_MESSAGE);
					studidf.setText("");
				}
					
			}catch(SQLException sqle)
			{
				sqle.printStackTrace();
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
		if(ch.equals("Contact Admin"))
		{
			new contactadmin();
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
