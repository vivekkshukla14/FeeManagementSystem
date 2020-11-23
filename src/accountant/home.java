package accountant;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import connect.connect;
import login.*;
import studentsubs.replystud;

public class home extends JFrame implements ActionListener, MouseListener
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
	
	JLabel stud=new JLabel("Total Number of Students:-  ");
	JTextField studf=new JTextField();
	JLabel total=new JLabel("Total Fee's:-  ");
	JTextField totalf=new JTextField();
	JLabel feepaid=new JLabel("Total Fee's Paid:-  ");
	JTextField feepaidf=new JTextField();
	JLabel feep=new JLabel("Total Fee's Pending:-  ");
	JTextField feepf=new JTextField();
	
	JLabel dateh=new JLabel();
	
	JLabel query=new JLabel("New Message QUERY arrived from student");
	Font font=new Font("Times New Roman",Font.PLAIN,20);
	Font fontb=new Font("Times New Roman", Font.BOLD,16);
	
	Connection con;
	PreparedStatement stat;
	ResultSet set;
	
	public home()
	{
		
		add(mainP);
		add(headP);
		add(sideP);
		
		setSize(860,680);
		setTitle("Accountant");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(220,20);
		setResizable(false);
		
		headP.setBounds(0, 0, 860, 160);
	    sideP.setBounds(0, 160, 195, 500);
	    mainP.setBounds(195, 160, 660, 500);
	 
	    mainP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Accountant Home", TitledBorder.CENTER, TitledBorder.TOP, new Font("Times New Roman",Font.BOLD,22), new Color(20, 75, 75)));
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
		home.setForeground(Color.red);
		managestud.setFont(fontb);
		manageacc.setFont(fontb);
		contactus.setFont(fontb);
		logout.setFont(fontb);
		
		mainP.add(dateh);
		mainP.add(query);
		mainP.add(stud);
		mainP.add(studf);
		mainP.add(total);
		mainP.add(totalf);
		mainP.add(feep);
		mainP.add(feepf);
		mainP.add(feepaid);
		mainP.add(feepaidf);
		
		java.util.Date date=new java.util.Date();  
		dateh.setText(date.toString());
		dateh.setFont(new Font("Times New Roman", Font.BOLD,18));
		dateh.setBounds(400,450 ,240 ,30 );
		query.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Reply Student", TitledBorder.TRAILING, TitledBorder.TOP, font, new Color(0, 128, 128)));		
		query.setBounds(50,340,500,60);
		query.setFont(new Font("Times New Roman", Font.BOLD,25));
		
		// TOTAL NUMBER OF STUDENTS
			try{
				int cse=0;
				
				con=connect.connection();
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
				
			}catch(SQLException e)
			{
				e.printStackTrace();
			}

			// TOTAL FEES OF ALL THE STUDENTS
				try{
					int total=0;
					
					con=connect.connection();
					stat=con.prepareStatement("select amount from csefee");
					set =stat.executeQuery();
					while(set.next())
					{
						total=set.getInt(1);
					}
					stat=con.prepareStatement("select amount from ecefee ");
					set =stat.executeQuery();
					while(set.next())
					{
						total=total+set.getInt(1);
					}
					stat=con.prepareStatement("select amount from architecturefee ");
					set =stat.executeQuery();
					while(set.next())
					{
						total=total+set.getInt(1);
					}
					stat=con.prepareStatement("select amount from productionfee ");
					set =stat.executeQuery();
					while(set.next())
					{
						total=total+set.getInt(1);
					}
					stat=con.prepareStatement("select amount from civilfee ");
					set =stat.executeQuery();
					while(set.next())
					{
						total=total+set.getInt(1);
					}
					stat=con.prepareStatement("select amount from mechanicalfee ");
					set =stat.executeQuery();
					while(set.next())
					{
						total=total+set.getInt(1);
					}
					stat=con.prepareStatement("select amount from electricalfee ");
					set =stat.executeQuery();
					while(set.next())
					{
						total=total+set.getInt(1);
					}
					totalf.setText(""+total);
					
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
				
				// TOTAL FEEE PENDING
				try{
					int pending=0;
					
					con=connect.connection();
					stat=con.prepareStatement("select balance from csefee");
					set =stat.executeQuery();
					while(set.next())
					{
						pending=set.getInt(1);
					}
					stat=con.prepareStatement("select balance from ecefee ");
					set =stat.executeQuery();
					while(set.next())
					{
						pending=pending+set.getInt(1);
					}
					stat=con.prepareStatement("select balance from architecturefee ");
					set =stat.executeQuery();
					while(set.next())
					{
						pending=pending+set.getInt(1);
					}
					stat=con.prepareStatement("select balance from productionfee ");
					set =stat.executeQuery();
					while(set.next())
					{
						pending=pending+set.getInt(1);
					}
					stat=con.prepareStatement("select balance from civilfee ");
					set =stat.executeQuery();
					while(set.next())
					{
						pending=pending+set.getInt(1);
					}
					stat=con.prepareStatement("select balance from mechanicalfee ");
					set =stat.executeQuery();
					while(set.next())
					{
						pending=pending+set.getInt(1);
					}
					stat=con.prepareStatement("select balance from electricalfee ");
					set =stat.executeQuery();
					while(set.next())
					{
						pending=pending+set.getInt(1);
					}
					feepf.setText(""+pending);
					
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
				
				// TOTAL FEE PAID
				try{
					int paid=0;
					
					con=connect.connection();
					stat=con.prepareStatement("select feepaid from csefee");
					set =stat.executeQuery();
					while(set.next())
					{
						paid=set.getInt(1);
					}
					stat=con.prepareStatement("select feepaid from ecefee ");
					set =stat.executeQuery();
					while(set.next())
					{
						paid=paid+set.getInt(1);
					}
					stat=con.prepareStatement("select feepaid from architecturefee ");
					set =stat.executeQuery();
					while(set.next())
					{
						paid=paid+set.getInt(1);
					}
					stat=con.prepareStatement("select feepaid from productionfee ");
					set =stat.executeQuery();
					while(set.next())
					{
						paid=paid+set.getInt(1);
					}
					stat=con.prepareStatement("select feepaid from civilfee ");
					set =stat.executeQuery();
					while(set.next())
					{
						paid=paid+set.getInt(1);
					}
					stat=con.prepareStatement("select feepaid from mechanicalfee ");
					set =stat.executeQuery();
					while(set.next())
					{
						paid=paid+set.getInt(1);
					}
					stat=con.prepareStatement("select feepaid from electricalfee ");
					set =stat.executeQuery();
					while(set.next())
					{
						paid=paid+set.getInt(1);
					}
					feepaidf.setText(""+paid);
					
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
				
		stud.setBounds(100,50,270,40);
		stud.setFont(font);
		studf.setBounds(380,50,100,40);
		studf.setFont(font);
		studf.setEditable(false);
		total.setBounds(100,120,270,40);
		total.setFont(font);
		totalf.setBounds(380,120,100,40);
		totalf.setFont(font);
		totalf.setEditable(false);
		feepaid.setBounds(100,190,270,40);
		feepaid.setFont(font);
		feepaidf.setBounds(380,190,100,40);
		feepaidf.setFont(font);
		feepaidf.setEditable(false);
		feep.setBounds(100,260,270,40);
		feep.setFont(font);
		feepf.setBounds(380,260,100,40);
		feepf.setFont(font);
		feepf.setEditable(false);
		
		home.addActionListener(this);
		dashboard.addActionListener(this);
		managestud.addActionListener(this);
		manageacc.addActionListener(this);
		contactus.addActionListener(this);
		logout.addActionListener(this);
		query.addMouseListener(this);
		
		
	}
	
	public static void main(String[] args)
	{
		new home();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String ch=e.getActionCommand();
		
		if(ch.equals("DashBoard"))
		{
			new dashboardacc("");
			this.dispose();
		}
		if(ch.equals("Contact Admin"))
		{
			new contactadmin();
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(query))
		{
			new replystud();
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
