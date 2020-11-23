package student;

import java.awt.Color;


import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import connect.connect;
import login.*;

public class homestud extends JFrame implements ActionListener, MouseListener 
{
	JPanel mainP=new JPanel(null);
	JPanel headP=new JPanel(null);
	JPanel sideP=new JPanel(null);
	JLabel clgname=new JLabel("<html>Chandigarh College of<br>"+"Engineering and Technology");
	JLabel clgimg=new JLabel();
	JButton home=new JButton("Home");
	JButton dashboard=new JButton("DashBoard");
	JButton feedetail=new JButton ("Check Fee Details");
	JButton feestatus=new JButton("Check Fee Status");
	JButton contactus=new JButton("Contact Head's");
	JButton logout=new JButton("LogOut");
	
	JLabel open=new JLabel("See your QUERIES and FEEDBACKS");
	JLabel dateh=new JLabel();
	JLabel welcome=new JLabel();
	
	Font fontb=new Font("Times New Roman", Font.BOLD,16);
	
	public homestud()
	{	
	
		getContentPane().add(mainP);
		getContentPane().add(headP);
		getContentPane().add(sideP);
		
		setSize(860,680);
		setTitle("STUDENT");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(220,20);
		setResizable(false);
		
	    
		headP.setBounds(0, 0, 860, 160);
	    sideP.setBounds(0, 160, 195, 500);
	    mainP.setBounds(195, 160, 660, 500);
	    
	    mainP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Student's Home", TitledBorder.CENTER, TitledBorder.TOP, new Font("Times New Roman",Font.BOLD,22), new Color(20, 75, 75)));
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
		sideP.add(feedetail);
		sideP.add(feestatus);
		sideP.add(contactus);
		sideP.add(logout);
		
		home.setBounds(15,185 ,165 ,40 );
		dashboard.setBounds(15,245 ,165 ,40 );
		feedetail.setBounds(15,305 ,165 ,40 );
		feestatus.setBounds(15,365 ,165 ,40 );
		contactus.setBounds(15,425 ,165 ,40 );
		logout.setBounds(15,585 ,165 ,40 );

		home.setFont(fontb);
		dashboard.setFont(fontb);
		home.setForeground(Color.red);
		feedetail.setFont(fontb);
		feestatus.setFont(fontb);
		contactus.setFont(fontb);
		logout.setFont(fontb);
		
		mainP.add(dateh);
		mainP.add(open);
		mainP.add(welcome);
		
		welcome.setBounds(100,80 ,500 ,40 );
		welcome.setFont(new Font("Times New Roman", Font.BOLD,35));
		welcome.setForeground(new Color(0, 128, 128));
		welcome.setText("Welcome Dear Student");
		
		open.setBounds(100,320 ,500 ,60 );
		open.setFont(new Font("Times New Roman", Font.BOLD,25));
		open.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "See Query Reply/ FeedBack's", TitledBorder.TRAILING, TitledBorder.TOP, new Font("Times New Roman",Font.PLAIN,20), new Color(0, 128, 128)));
		java.util.Date date=new java.util.Date();  
		dateh.setText(date.toString());
		dateh.setFont(new Font("Times New Roman", Font.BOLD,18));
		dateh.setBounds(400,450 ,240 ,30 );
		
		home.addActionListener(this);
		dashboard.addActionListener(this);
        feedetail.addActionListener(this);
		feestatus.addActionListener(this);
		contactus.addActionListener(this);
		logout.addActionListener(this);
		open.addMouseListener(this);
	}
	
	public static void main(String[] args)
	{
		new homestud();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String ch=e.getActionCommand();
		
		if(ch.equals("DashBoard"))
		{
			new dashboardstud("","");
			this.dispose();
		}
		if(ch.equals("Contact Head's"))
		{
			new contactus();
			this.dispose();
		}
		if(ch.equals("Check Fee Status"))
		{
			new FeeStatus("","");
			this.dispose();
		}
		if(ch.equals("Check Fee Details"))
		{
			new feedetails();
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
		if(e.getSource().equals(open))
		{
		
			new studreply();
		
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
