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

public class feedetails extends JFrame implements ActionListener 
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
	JButton contactus=new JButton("Contact Us");
	JButton logout=new JButton("LogOut");
	
	JLabel fee=new JLabel("Fee Details of Student Id: -");
	static JLabel studid=new JLabel();
	JTextField studidf=new JTextField();
	JLabel add=new JLabel("Admission Fee:- ");
	static JTextField addf=new JTextField();
	JLabel tution=new JLabel("Tution Fee:- ");
	static JTextField tutionf=new JTextField();
	JLabel hostel=new JLabel("Hostel Fee:- ");
	static JTextField hostelf=new JTextField();
	JLabel develop=new JLabel("Devlopment Fee:- ");
	static JTextField developf=new JTextField();
	JLabel amal=new JLabel("Amalgamated fund:- ");
	static JTextField amalf=new JTextField();
	JLabel cons=new JLabel("Counselling Fee:- ");
	static JTextField consf=new JTextField();
	JLabel exam=new JLabel("Examination Fee");
	static JTextField examf=new JTextField();
	JLabel late=new JLabel("Late Fee:- ");
	static JTextField latef=new JTextField();
	
	
	JButton done=new JButton("Done");
	Font main=new Font("Times New Roman",Font.BOLD,22);
	Font fontb=new Font("Times New Roman", Font.BOLD,16);

	Connection con;
	PreparedStatement stat;
	ResultSet set;
	
	static String studentid,table;
	String hosteler;
	public feedetails()
	{
		
		add(mainP);
		add(headP);
		add(sideP);
		
		studentid=dashboardstud.idf.getText();
		table=FeeStatus.table;
		
		setSize(860,680);
		setTitle("STUDENT");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(220,20);
		setResizable(false);
		
		headP.setBounds(0, 0, 860, 160);
	    sideP.setBounds(0, 160, 195, 500);
	    mainP.setBounds(195, 160, 660, 500);
	 
	    mainP.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Different Fee Details", TitledBorder.CENTER, TitledBorder.TOP, new Font("Times New Roman",Font.BOLD,22), new Color(20, 75, 75)));
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
		feedetails.setForeground(Color.red);
		feedetails.setFont(fontb);
		feestatus.setFont(fontb);
		contactus.setFont(fontb);
		logout.setFont(fontb);

		mainP.add(fee);
		mainP.add(studid);
		mainP.add(studidf);
		mainP.add(exam);
		mainP.add(examf);
		mainP.add(hostel);
		mainP.add(hostelf);
		mainP.add(add);
		mainP.add(addf);
		mainP.add(amal);
		mainP.add(amalf);
		mainP.add(tution);
		mainP.add(tutionf);
		mainP.add(done);
		mainP.add(develop);
		mainP.add(developf);
		mainP.add(late);
		mainP.add(latef);
		mainP.add(cons);
		mainP.add(consf);
		
		fee.setBounds(100,40,300,30);
		fee.setFont(main);
		studid.setBounds(420,40,100,30);
		studid.setText(studentid);
		studid.setFont(main);
		
		add.setBounds(100, 80, 150, 30);
		addf.setBounds(260, 80, 100, 30);
		addf.setEditable(false);
		
		tution.setBounds(100, 130, 150, 30);
		tutionf.setBounds(260, 130, 100, 30);
		tutionf.setEditable(false);
		
		hostel.setBounds(100, 180, 150, 30);
		hostelf.setBounds(260, 180, 100, 30);
		hostelf.setEditable(false);
		
		develop.setBounds(100,230,150,30);
		developf.setBounds(260, 230, 100, 30);
		developf.setEditable(false);
		
		amal.setBounds(100, 280, 150, 30);
		amalf.setBounds(260, 280, 100, 30);
		amalf.setEditable(false);
		
		cons.setBounds(100, 330, 150, 30);
		consf.setBounds(260, 330, 100, 30);
		consf.setEditable(false);
		
		exam.setBounds(100, 380, 150, 30);
		examf.setBounds(260, 380, 100, 30);
		examf.setEditable(false);
		
		late.setBounds(100, 430, 150, 30);
		latef.setBounds(260, 430, 100, 30);
		latef.setEditable(false);

		try{
			con=connect.connection();
			stat= con.prepareStatement("select * from "+ table +" where studentid = ? ");
			stat.setString(1,studentid);
			set= stat.executeQuery();
			while(set.next())
			{
				addf.setText(""+set.getInt("AdmissionFee"));
				tutionf.setText(""+set.getInt("TuitionFee"));
				hostelf.setText(""+set.getString("Hosteler")+", "+set.getInt("HostelFee"));
				developf.setText(""+set.getInt("DevelopmentFee"));
				amalf.setText(""+set.getInt("AmalgamatedFunds"));
				consf.setText(""+set.getInt("CounselingFee"));
				examf.setText(""+set.getInt("ExamFee"));
				latef.setText(""+set.getInt("LateFee"));
				consf.setText(""+set.getInt("CounselingFee"));
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
		home.addActionListener(this);
		dashboard.addActionListener(this);
		feedetails.addActionListener(this);
		feestatus.addActionListener(this);
		contactus.addActionListener(this);
		logout.addActionListener(this);
		done.addActionListener(this);
	}
	
	public static void main(String[] args)
	{
		new feedetails();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String ch=e.getActionCommand();
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
