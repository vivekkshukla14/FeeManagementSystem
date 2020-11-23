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
import studentsubs.*;

public class managestud extends JFrame implements ActionListener 
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
	
	JButton newstud=new JButton("Add New Student");
	JButton removestud=new JButton("Remove Student");
	JButton updatestud=new JButton("Update Student Details");
	JButton liststud=new JButton("View List of Students");
	JButton viewstud=new JButton("View Student");

	
	JLabel studid= new JLabel("Enter the Id of the Student: - ");
	JTextField studidf=new JTextField();
	JLabel trade= new JLabel("Select The Stream of the Student: - ");
	
	JButton enter=new JButton("Remove");	
	JButton show=new JButton("Show Details");	
	JButton update=new JButton("Update");	
	
	JComboBox<String> tradef=new JComboBox<String>();
	public static String text,text2,table;
	
	Font fontb=new Font("Times New Roman", Font.BOLD,16);
	Connection con;
	PreparedStatement stat;
	
	public managestud()
	{
		add(mainP);
		add(headP);
		add(sideP);
		
		setSize(860,680);
		setTitle("ACCOUNTANT");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(220,20);
		setResizable(false);
		
		headP.setBounds(0, 0, 860, 160);
	    sideP.setBounds(0, 160, 195, 500);
	    mainP.setBounds(195, 160, 660, 500);
	 
	    mainP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Manage Students", TitledBorder.CENTER, TitledBorder.TOP, new Font("Times New Roman",Font.BOLD,22), new Color(20, 75, 75)));
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
		managestud.setForeground(Color.red);
		managestud.setFont(fontb);
		manageacc.setFont(fontb);
		contactus.setFont(fontb);
		logout.setFont(fontb);
		
		mainP.add(newstud);
		mainP.add(removestud);
		mainP.add(updatestud);
		mainP.add(liststud);
		mainP.add(viewstud);
		
		newstud.setBounds(100, 100, 200,60);
		removestud.setBounds(340, 100, 200,60);
		updatestud.setBounds(100, 190, 200,60);
		liststud.setBounds(340, 190, 200,60);
		viewstud.setBounds(220,280 ,200 ,60 );
		
		mainP.add(studid);
		mainP.add(studidf);
		mainP.add(trade);
		mainP.add(tradef);
		mainP.add(enter);
		mainP.add(show);
		mainP.add(update);
		
		studid.setFont(new Font("Times New Roman",Font.BOLD,20));
		trade.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		
		tradef.addItem("");
		tradef.addItem("CSE");
		tradef.addItem("ECE");
		tradef.addItem("Civil Engg.");
		tradef.addItem("Electrical Engg.");
		tradef.addItem("Architecture Engg.");
		tradef.addItem("Production Engg.");
		tradef.addItem("Mechanical Engg.");
		
		home.addActionListener(this);
		dashboard.addActionListener(this);
		managestud.addActionListener(this);
		manageacc.addActionListener(this);
		contactus.addActionListener(this);
		logout.addActionListener(this);
		newstud.addActionListener(this);
		removestud.addActionListener(this);
		updatestud.addActionListener(this);
		liststud.addActionListener(this);
		viewstud.addActionListener(this);
		enter.addActionListener(this);
		show.addActionListener(this);
		update.addActionListener(this);
	}
	
	public static void main(String[] args)
	{
		new managestud();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String ch=e.getActionCommand();
		if(ch.equals("Add New Student"))
		{
			new newstud();
		}
		if(ch.equals("Remove Student"))
		{
			newstud.setVisible(false);
			removestud.setVisible(false);
			updatestud.setVisible(false);
			liststud.setVisible(false);
			viewstud.setVisible(false);

			studid.setVisible(true);
			studidf.setVisible(true);
			trade.setVisible(true);
			tradef.setVisible(true);
			enter.setVisible(true);
			studid.setBounds(100,50 ,300 ,40 );
			studidf.setBounds(140,100 ,250 ,30 );
			trade.setBounds(100,150 ,200 ,40 );
			tradef.setBounds(140,200 ,250 ,30 );
			enter.setBounds(120,250,150,40);
		
		}
					if(ch.equals("Remove"))
					{
						
						if(tradef.getSelectedIndex()==1)
						{
							table="cse";
						}
						if(tradef.getSelectedIndex()==2)
						{
							table="ece";
						}
						if(tradef.getSelectedIndex()==3)
						{
							table="civil";
						}
						if(tradef.getSelectedIndex()==4)
						{
							table="electrical";
						}
						if(tradef.getSelectedIndex()==5)
						{
							table="architecture";
						}
						if(tradef.getSelectedIndex()==6)
						{
							table="production";
						}
						if(tradef.getSelectedIndex()==7)
						{
							table="mechanical";
						}
						
						try{
						
							String ids=studidf.getText();
							con=connect.connection();
							stat=con.prepareStatement("delete from "+ table +" where studentid=? ");
							stat.setString(1, ids);
							
							int i=stat.executeUpdate();
							if(i>0)
							{
								JOptionPane.showMessageDialog(this, "Student has been removed... May God Bless him/her", "Removed", JOptionPane.INFORMATION_MESSAGE);
								studidf.setText("");
								tradef.setSelectedItem(0);
							}
							else
							{
								JOptionPane.showMessageDialog(this, "Please Check all the Deatils you have entered", "Not Removed", JOptionPane.ERROR_MESSAGE);	
							}
							
						}catch(Exception  cnf){
							cnf.printStackTrace();
						} 
					}
		
		if(ch.equals("Update Student Details"))
		{
			newstud.setVisible(false);
			removestud.setVisible(false);
			updatestud.setVisible(false);
			liststud.setVisible(false);
			viewstud.setVisible(false);

			studid.setVisible(true);
			studidf.setVisible(true);
			update.setVisible(true);
			trade.setVisible(true);
			tradef.setVisible(true);
			studid.setBounds(100,50 ,300 ,40 );
			studidf.setBounds(150,100 ,250 ,30 );
			trade.setBounds(100,150,300,40);
			tradef.setBounds(150,200,200,30);
			update.setBounds(130,250,150,40);
		}
				if(ch.equals("Update"))
				{
					text2=studidf.getText();
					if(text2.isEmpty())
					{
						JOptionPane.showMessageDialog(this,"Enter the Student ID","Blank !!!", JOptionPane.WARNING_MESSAGE);
					}
					else
					{
					if(tradef.getSelectedIndex()==1)
					{
						table="cse";
					}
					if(tradef.getSelectedIndex()==2)
					{
						table="ece";
					}
					if(tradef.getSelectedIndex()==3)
					{
						table="civil";
					}
					if(tradef.getSelectedIndex()==4)
					{
						table="electrical";
					}
					if(tradef.getSelectedIndex()==5)
					{
						table="architecture";
					}
					if(tradef.getSelectedIndex()==6)
					{
						table="production";
					}
					if(tradef.getSelectedIndex()==7)
					{
						table="mechanical";
					}
					
					try{
					
						String ids=studidf.getText();
						Class.forName("com.mysql.jdbc.Driver");
						con= DriverManager.getConnection("jdbc:mysql://localhost:3306/fms", "root","");
						stat=con.prepareStatement("select * from "+ table +" where studentid=? ");
						stat.setString(1, ids);
											
							ResultSet set =stat.executeQuery();
							if(set.next())
							{
								new updatestud();
								this.dispose();
								studidf.setText("");
								tradef.setSelectedIndex(0);
							}
							else
							{
								JOptionPane.showMessageDialog(this, "Please Check Student ID ", "Error", JOptionPane.OK_OPTION);
								studidf.setText("");
							}
				
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			
		if(ch.equals("View List of Students"))
		{
			new viewstudlist();
		}
	
		if(ch.equals("View Student"))
		{
			newstud.setVisible(false);
			removestud.setVisible(false);
			updatestud.setVisible(false);
			liststud.setVisible(false);
			viewstud.setVisible(false);

			studid.setVisible(true);
			studidf.setVisible(true);
			show.setVisible(true);
			trade.setVisible(true);
			tradef.setVisible(true);
			studid.setBounds(100,50 ,300 ,40 );
			studidf.setBounds(150,100 ,250 ,30 );
			trade.setBounds(100,150,300,40);
			tradef.setBounds(150,200,200,30);
			show.setBounds(130,250,150,40);
		
		}
					if(ch.equals("Show Details"))
					{
					 text=studidf.getText();
						if(text.isEmpty())
						{
							JOptionPane.showMessageDialog(this,"Enter the Student ID","Blank !!!", JOptionPane.WARNING_MESSAGE);
						}
						else
						{
						if(tradef.getSelectedIndex()==1)
						{
							table="cse";
						}
						if(tradef.getSelectedIndex()==2)
						{
							table="ece";
						}
						if(tradef.getSelectedIndex()==3)
						{
							table="civil";
						}
						if(tradef.getSelectedIndex()==4)
						{
							table="electrical";
						}
						if(tradef.getSelectedIndex()==5)
						{
							table="architecture";
						}
						if(tradef.getSelectedIndex()==6)
						{
							table="production";
						}
						if(tradef.getSelectedIndex()==7)
						{
							table="mechanical";
						}
						
						try{
						
							String ids=studidf.getText();
							con=connect.connection();
							stat=con.prepareStatement("select * from "+ table +" where studentid=? ");
							stat.setString(1, ids);
												
								ResultSet set =stat.executeQuery();
								if(set.next())
								{
									new viewstud();
									this.dispose();
									studidf.setText("");
									tradef.setSelectedIndex(0);
								}
								else
								{
									JOptionPane.showMessageDialog(this, "Please Check Student ID ", "Error", JOptionPane.OK_OPTION);
									studidf.setText("");
								}
					
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					}
						
		if(ch.equals("Home"))
		{
			new home();
			this.dispose();
		}
		if(ch.equals("Contact Admin"))
		{
			new contactadmin();
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
