package admin;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import connect.connect;
import login.*;
import subs.reply;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;

public class homeadmin extends JFrame implements ActionListener, MouseListener 
{
	JPanel mainP=new JPanel(null);
	JPanel headP=new JPanel(null);
	JPanel sideP=new JPanel(null);
	JLabel clgname=new JLabel("<html><center>Chandigarh College of<br>"+"<center>Engineering and Technology");
	JLabel clgimg=new JLabel();
	JButton home=new JButton("Home");
	JButton dashboard=new JButton("DashBoard");
	JButton managestud=new JButton ("Manage Students");
	JButton manageacc=new JButton("Manage Accountants");
	JButton logout=new JButton("LogOut");
	
	JLabel acct=new JLabel("Total Number of Accountants:-  ");
	JTextField acctf=new JTextField();
	JLabel stud=new JLabel("Total Number of Students:-  ");
	JTextField studf=new JTextField();
	
	Font fontm=new Font("Times New Roman",Font.PLAIN,20);
	JLabel dateh=new JLabel();
	JLabel query=new JLabel("NEW MESSAGE QUERY FROM STUDENT");
	JLabel queryacc=new JLabel("NEW MESSAGE QUERY FROM ACCOUNTANT");
	
	Connection con;
	PreparedStatement stat;
	ResultSet set;
	
	Font font=new Font("Times New Roman", Font.BOLD,16);
	public homeadmin()
	{
		
		getContentPane().add(mainP);
		getContentPane().add(headP);
		getContentPane().add(sideP);
		
		setSize(860,680);
		setTitle("ADMIN");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(220,20);
		setResizable(false);
		
		headP.setBounds(0, 0, 860, 160);
	    sideP.setBounds(0, 160, 195, 500);
	    mainP.setBounds(195, 160, 660, 500);
	 
	    mainP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Admin Home", TitledBorder.CENTER, TitledBorder.TOP, new Font("Times New Roman",Font.BOLD,22), new Color(20, 75, 75)));
		headP.setBorder(new LineBorder(Color.black,1));
		sideP.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
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
		sideP.add(logout);
		
		home.setBounds(10,185 ,175 ,40 );
		dashboard.setBounds(10,245 ,175 ,40 );
		managestud.setBounds(10,305 ,175 ,40 );
		manageacc.setBounds(10,365 ,180 ,40 );
		
		logout.setBounds(10,585 ,175 ,40 );

		home.setFont(font);
		dashboard.setFont(font);
		home.setForeground(Color.red);
		managestud.setFont(font);
		manageacc.setFont(font);
		logout.setFont(font);

		
		mainP.add(dateh);
		java.util.Date date=new java.util.Date();  
		dateh.setText(date.toString());
		dateh.setFont(new Font("Times New Roman", Font.BOLD,18));
		dateh.setBounds(400,450 ,240 ,30 );
		
		mainP.add(acct);
		mainP.add(stud);
		mainP.add(acctf);
		mainP.add(studf);
		mainP.add(query);
		
		mainP.add(queryacc);
		
		acct.setBounds(100,50,270,40);
		acct.setFont(fontm);
		acctf.setBounds(380,50,100,40);
		acctf.setFont(fontm);
		queryacc.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Reply Accountant", TitledBorder.TRAILING, TitledBorder.TOP, fontm, new Color(0, 139, 139)));
		queryacc.setBounds(70,280,500,60);
		queryacc.setFont(new Font("Times New Roman", Font.BOLD,22));
		query.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Reply Student", TitledBorder.TRAILING, TitledBorder.TOP, fontm, new Color(0, 128, 128)));
		query.setBounds(70,360,500,60);
		query.setFont(new Font("Times New Roman", Font.BOLD,22));
		
		try{
			con=connect.connection();
			stat=con.prepareStatement("select * from studentreview where status='0' UNION ALL "+"select * from studentfeedback where status='0'");
			set=stat.executeQuery();
			if(set.next())
			{
				if(set.getString(1)!=null)
				{
					query.setForeground(Color.red);
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		try{
			con=connect.connection();
			stat=con.prepareStatement("select * from accountantreview where status='0' UNION ALL "+"select * from accountantfeedback where status='0'");
			set=stat.executeQuery();
			if(set.next())
			{
				if(set.getString(1)!=null)
				{
					queryacc.setForeground(Color.red);
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		try{
			int cse=0;
			
			con=connect.connection();
			stat=con.prepareStatement("select MAX(sno) from accountant ");
			set =stat.executeQuery();
			while(set.next())
			{
				acctf.setText(""+ (set.getString(1)));
			}
			stat=con.prepareStatement("select MAX(sno) from cse ");
			set =stat.executeQuery();
			while(set.next())
			{
				cse=set.getInt(1);
			}
			stat=con.prepareStatement("select MAX(sno) from ece ");
			set =stat.executeQuery();
			while(set.next())
			{
				cse=cse+set.getInt(1);
			}
			stat=con.prepareStatement("select MAX(sno) from architecture ");
			set =stat.executeQuery();
			while(set.next())
			{
				cse=cse+set.getInt(1);
			}
			stat=con.prepareStatement("select MAX(sno) from production ");
			set =stat.executeQuery();
			while(set.next())
			{
				cse=cse+set.getInt(1);
			}
			stat=con.prepareStatement("select MAX(sno) from civil ");
			set =stat.executeQuery();
			while(set.next())
			{
				cse=cse+set.getInt(1);
			}
			stat=con.prepareStatement("select MAX(sno) from mechanical ");
			set =stat.executeQuery();
			while(set.next())
			{
				cse=cse+set.getInt(1);
			}
			stat=con.prepareStatement("select MAX(sno) from electrical ");
			set =stat.executeQuery();
			while(set.next())
			{
				cse=cse+set.getInt(1);
			}
			studf.setText(""+cse);
			
			
		}catch( SQLException e)
		{
			e.printStackTrace();
		}
		acctf.setEditable(false);
		stud.setBounds(100,150,270,40);
		stud.setFont(fontm);
		studf.setBounds(380,150,100,40);
		studf.setFont(fontm);
		studf.setEditable(false);
		
		//Action Listeners
		home.addActionListener(this);
		dashboard.addActionListener(this);
		managestud.addActionListener(this);
		manageacc.addActionListener(this);
		logout.addActionListener(this);
		query.addMouseListener(this);
		queryacc.addMouseListener(this);
	}
	
	public static void main(String[] args)
	{
		new homeadmin();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String ch=e.getActionCommand();
		
		if(ch.equals("DashBoard"))
		{
			new dashboardadmin("");
			this.dispose();
		}
		if(ch.equals("Manage Students"))
		{
			new managestud();
			this.dispose();
		}
		if(ch.equals("Manage Accountants"))
		{
			new manageacct();
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(query))
		{
			new studentsubs.replystud();
		}
		if(e.getSource().equals(queryacc))
		{
			new reply();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
