package admin;

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
import subs.*;

public class manageacct extends JFrame implements ActionListener 
{

	JPanel mainP=new JPanel(null);
	JPanel headP=new JPanel(null);
	JPanel sideP=new JPanel(null);
	JLabel clgname=new JLabel("<html>Chandigarh College of<br>"+"Engineering and Technology");
	JLabel clgimg=new JLabel();
	JButton home=new JButton("Home");
	JButton dashboard=new JButton("DashBoard");
	JButton managestud=new JButton ("Manage Students");
	JButton manageacc=new JButton("Manage Accountants");
	JButton logout=new JButton("LogOut");
	
	JButton newacc=new JButton("Add New Accountant");
	JButton removeacc=new JButton("Remove Accountant");
	JButton updateacc=new JButton("<html>Update Accountant<br> Details");
	JButton listacc=new JButton("View List of Accountant");
	JButton viewacc=new JButton("View Accountant");

	
	JLabel accid= new JLabel("Enter the Employee Id of the Accountant:- ");
	JTextField accidf=new JTextField();
	JLabel accname= new JLabel("Name of the Accountant:- ");
	JTextField accnamef=new JTextField();
	JButton enter=new JButton("Remove");	
	JButton show=new JButton("Show Details");	
	JButton update=new JButton("Update");	
	
	
	public static String text, text2;
	
	Connection con;
	PreparedStatement stat;
	
	Font font=new Font("Times New Roman", Font.BOLD,16);
	
	public manageacct()
	{
		add(mainP);
		add(headP);
		add(sideP);
		
		setTitle("ADMIN");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(860,680);
		setLocation(220,20);
		setResizable(false);
		
		headP.setBounds(0, 0, 860, 160);
	    sideP.setBounds(0, 160, 195, 500);
	    mainP.setBounds(195, 160, 660, 500);
	 
	    mainP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Manage Accountant", TitledBorder.CENTER, TitledBorder.TOP, new Font("Times New Roman",Font.BOLD,22), new Color(20, 75, 75)));
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
		sideP.add(logout);
		
		home.setBounds(10,185 ,175 ,40 );
		dashboard.setBounds(10,245 ,175 ,40 );
		managestud.setBounds(10,305 ,175 ,40 );
		manageacc.setBounds(10,365 ,180 ,40 );
		
		logout.setBounds(10,585 ,175 ,40 );

		home.setFont(font);
		dashboard.setFont(font);
		manageacc.setForeground(Color.red);
		managestud.setFont(font);
		manageacc.setFont(font);
		logout.setFont(font);
		
		mainP.add(newacc);
		mainP.add(removeacc);
		mainP.add(updateacc);
		mainP.add(listacc);
		mainP.add(viewacc);
		
		newacc.setBounds(100, 100, 200,60);
		removeacc.setBounds(340, 100, 200,60);
		updateacc.setBounds(100, 190, 200,60);
		listacc.setBounds(340, 190, 200,60);
		viewacc.setBounds(200,280 ,200 ,60 );
		
		mainP.add(accid);
		mainP.add(accidf);
		mainP.add(accname);
		mainP.add(accnamef);
		mainP.add(enter);
		mainP.add(show);
		mainP.add(update);
		
		accid.setFont(new Font("Times New Roman",Font.BOLD,20));
		accname.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		home.addActionListener(this);
		dashboard.addActionListener(this);
		managestud.addActionListener(this);
		manageacc.addActionListener(this);
		logout.addActionListener(this);
		newacc.addActionListener(this);
		removeacc.addActionListener(this);
		updateacc.addActionListener(this);
		listacc.addActionListener(this);
		viewacc.addActionListener(this);
		enter.addActionListener(this);
		show.addActionListener(this);
		update.addActionListener(this);
	}
	
	public static void main(String[] args)
	{
		new manageacct();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String ch=e.getActionCommand();
		if(ch.equals("Add New Accountant"))
		{
			new newacct();
		}
		if(ch.equals("Remove Accountant"))
		{
			newacc.setVisible(false);
			removeacc.setVisible(false);
			updateacc.setVisible(false);
			listacc.setVisible(false);
			viewacc.setVisible(false);

			accid.setVisible(true);
			accidf.setVisible(true);
			accname.setVisible(true);
			accnamef.setVisible(true);
			enter.setVisible(true);
			accid.setBounds(100,50 ,350 ,40 );
			accidf.setBounds(140,100 ,250 ,30 );
			accname.setBounds(100,150 ,200 ,40 );
			accnamef.setBounds(140,200 ,250 ,30 );
			enter.setBounds(120,250,150,40);
		
		}
					if(ch.equals("Remove"))
					{
						try{
											
							con=connect.connection();
							stat=con.prepareStatement("delete from accountant where employeeid=(?)");
							stat.setString(1, accidf.getText());
							
							int i=stat.executeUpdate();
							if(i>0)
							{
								JOptionPane.showMessageDialog(this, "Accountant has been removed... May God Bless him/her", "Removed", JOptionPane.OK_OPTION);
								accidf.setText("");
								accnamef.setText("");
							}
							else
							{
								JOptionPane.showMessageDialog(this, "Please Check all the Deatils you have entered", "Not Removed", JOptionPane.OK_OPTION);	
							}
							
						}catch(SQLException  cnf){
							cnf.printStackTrace();
						} 
					}
		
		if(ch.equals("<html>Update Accountant<br> Details"))
		{
			newacc.setVisible(false);
			removeacc.setVisible(false);
			updateacc.setVisible(false);
			listacc.setVisible(false);
			viewacc.setVisible(false);

			accid.setVisible(true);
			accidf.setVisible(true);
			update.setVisible(true);
			accid.setBounds(100,100 ,400 ,40 );
			accidf.setBounds(150,170 ,250 ,30 );
			update.setBounds(130,220,150,40);
		}
			if(ch.equals("Update"))
			{
				text2=accidf.getText();
				if(text2.isEmpty())
				{
					JOptionPane.showMessageDialog(this,"Enter the Accountant ID","Blank !!!", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					try {
						con=connect.connection();
						stat=con.prepareStatement("select * from accountant where employeeid=(?)");
						stat.setString(1, text2);
										
						ResultSet set =stat.executeQuery();
						if(set.next())
						{
							new updatedetails();
							accidf.setText("");
						}
						else
						{
							JOptionPane.showMessageDialog(this, "Please Check Accountant ID ", "Error", JOptionPane.OK_OPTION);
							accidf.setText("");
						}
			
					} catch ( SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
			
		if(ch.equals("View List of Accountant"))
		{
			new viewacclist();
		}
	
		if(ch.equals("View Accountant"))
		{
			newacc.setVisible(false);
			removeacc.setVisible(false);
			updateacc.setVisible(false);
			listacc.setVisible(false);
			viewacc.setVisible(false);

			accid.setVisible(true);
			accidf.setVisible(true);
			show.setVisible(true);
			accid.setBounds(100,100 ,400 ,40 );
			accidf.setBounds(150,170 ,250 ,30 );
			show.setBounds(130,220,150,40);
		
		}
					if(ch.equals("Show Details"))
					{
					 text=accidf.getText();
						if(text.isEmpty())
						{
							JOptionPane.showMessageDialog(this,"Enter the Employee ID","Blank !!!", JOptionPane.WARNING_MESSAGE);
						}
						else
						{
							try {
								con=connect.connection();
								stat=con.prepareStatement("select * from accountant where employeeid=(?)");
								stat.setString(1, text);
												
								ResultSet set =stat.executeQuery();
								if(set.next())
								{
									new viewacc();
									this.dispose();
									accidf.setText("");
								}
								else
								{
									JOptionPane.showMessageDialog(this, "Please Check Accountant ID ", "Error", JOptionPane.OK_OPTION);
									accidf.setText("");
								}
					
							} catch ( SQLException e1) {
								e1.printStackTrace();
							}
						}
					}
			if(ch.equals("DashBoard"))
			{
				new dashboardadmin("");
				this.dispose();
			}
			if(ch.equals("Home"))
			{
				new homeadmin();
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
	
}
