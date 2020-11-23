package student;

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

public class FeeStatus extends JFrame implements ActionListener, MouseListener
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
	
	JLabel totalfee = new JLabel("Total Fee's:- ");
	static JTextField totalfeef=new JTextField();
	JLabel feepaid = new JLabel("Paid Fee's:- ");
	static JTextField feepaidf=new JTextField();
	JLabel feeleft = new JLabel("Pending Fee's:- ");
	static JTextField feeleftf=new JTextField();
	
	JLabel imptips=new JLabel("<html><b><u>Important:- ");
	JLabel one=new JLabel("1. You Should upgrade your Fee Status by contacting the Accountant.");
	JLabel two=new JLabel("2. If you have any Query Please contact Accountant or Call.");
	JLabel three=new JLabel("<html><b>3. For checking Fee Details Click Here");
	Font tips=new Font("Times New Roman", Font.PLAIN,18);
	
	Font font=new Font("Times New Roman",Font.BOLD,22);
	Font fontb=new Font("Times New Roman", Font.BOLD,16);
	
	Connection con;
	PreparedStatement stat;
	ResultSet set;
	
	static String studid, table;
	
	public FeeStatus(String ID, String trade) 
	{
		studid=ID;
		table=trade+"fee";
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
	 
	    mainP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cuurent Fee Status", TitledBorder.CENTER, TitledBorder.TOP, new Font("Times New Roman",Font.BOLD,22), new Color(20, 75, 75)));
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
		sideP.add(feestatus);
		sideP.add(feedetails);
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
		feestatus.setForeground(Color.red);
		feedetails.setFont(fontb);
		feestatus.setFont(fontb);
		contactus.setFont(fontb);
		logout.setFont(fontb);
		
		mainP.add(feeleft);
		mainP.add(feeleftf);
		mainP.add(feepaid);
		mainP.add(feepaidf);
		mainP.add(totalfee);
		mainP.add(totalfeef);
		mainP.add(imptips);
		mainP.add(one);
		mainP.add(two);
		mainP.add(three);
		
		totalfee.setBounds(70,50,170,40);
		totalfee.setFont(font);
		totalfeef.setBounds(250,50,100,40);
		totalfeef.setEditable(false);
		feepaid.setBounds(70,110,170,40);
		feepaid.setFont(font);
		feepaidf.setBounds(250,110,100,40);
		feepaidf.setEditable(false);
		feeleft.setBounds(70,170,170,40);
		feeleft.setFont(font);
		feeleftf.setBounds(250,170,100,40);
		feeleftf.setEditable(false);
		
		try{
			
		con=	connect.connection();
			stat= con.prepareStatement("select * from "+ table +" where studentid= ?");
			stat.setString(1, studid);
			set= stat.executeQuery();
			while(set.next())
			{
				totalfeef.setText(""+(set.getString("amount")));
				feepaidf.setText(""+(set.getString("feepaid")));
				feeleftf.setText(""+(set.getString("balance")));
			}
		}catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		
		imptips.setBounds(50,330,200,40);
		imptips.setFont(font);
		one.setBounds(50,390,520,30);
		one.setFont(tips);
		two.setBounds(50,420,520,30);
		two.setFont(tips);
		three.setBounds(50,450,520,30);
		three.setFont(tips);
		three.setForeground(Color.BLUE);
		
		
		home.addActionListener(this);
		dashboard.addActionListener(this);
		feedetails.addActionListener(this);
		feestatus.addActionListener(this);
		contactus.addActionListener(this);
		logout.addActionListener(this);
		three.addMouseListener(this);
		
	}
	
	public static void main(String[] args)
	{
	
		new FeeStatus(studid, table );
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String ch=e.getActionCommand();
		
		if(ch.equals("DashBoard"))
		{
			new dashboardstud("","");;
			this.dispose();
		}
		if(ch.equals("Contact Head's"))
		{
			new contactus();
			this.dispose();
		}
		if(ch.equals("Home"))
		{
			new homestud();
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
		if(e.getSource().equals(three))
		{
			new feedetails();
			this.dispose();
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