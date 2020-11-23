package login;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import connect.connect;
import student.*;

public class studentlogin extends JFrame  implements ActionListener, KeyListener
{
	JPanel mainP=new JPanel(null);
	JPanel headP=new JPanel(null);
	JLabel clgname=new JLabel("<html>Chandigarh College of<br>"+"Engineering and Technology");
	JLabel clgimg=new JLabel();
	
	JLabel headl=new JLabel("Studnent Login");
	JLabel id=new JLabel("ID");
	public JTextField idf=new JTextField();
	JLabel password=new JLabel("Password");
	JPasswordField passwordf=new JPasswordField();
	
	JButton login=new JButton("Login");
	JButton back=new JButton("<<<");
	
	JLabel trade=new JLabel("Trade:- ");
	public JComboBox<String> tradef=new JComboBox<String>();
	Font main=new Font("Times New Roman", Font.BOLD,20);
	Font text=new Font("Times New Roman", Font.PLAIN,16);
	JLabel l1=new JLabel();
	
	Connection con;
	PreparedStatement stat;
	ResultSet rs,set;

	String pwdDB;
	public static String idtext, table;
	
	public studentlogin()
	{
		add(mainP);
		add(headP);
		
		setSize(860,680);
		setTitle("FEE MANAGEMENT SYSYTEM");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(220,20);
		setResizable(false);
		
		headP.setBounds(0, 0, 860, 160);
	    mainP.setBounds(0, 160, 860, 500);
	 
	    mainP.setBorder(new LineBorder(Color.black,1));
		headP.setBorder(new LineBorder(Color.black,1));
		mainP.setBackground(Color.WHITE);
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
		
		mainP.add(headl);
		mainP.add(id);
		mainP.add(idf);
		mainP.add(password);
		mainP.add(passwordf);
		mainP.add(login);
		mainP.add(back);
		mainP.add(trade);
		mainP.add(tradef);
		mainP.add(l1);
		
		tradef.addItem("");
		tradef.addItem("CSE");
		tradef.addItem("ECE");
		tradef.addItem("Civil Engg.");
		tradef.addItem("Electrical Engg.");
		tradef.addItem("Architecture Engg.");
		tradef.addItem("Production Engg.");
		tradef.addItem("Mechanical Engg.");
		
		l1.setBounds(0,0,860,500);
		try{
			Image img=ImageIO.read(getClass().getResource("/new.jpg"));
			l1.setIcon(new ImageIcon(img));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		headl.setBounds(300,130,300,35);
		headl.setForeground(Color.WHITE);
		headl.setFont(new Font("Times New Roman",  Font.BOLD, 32));
		trade.setBounds(280,175,80,30);
		trade.setForeground(Color.LIGHT_GRAY);
		trade.setFont(main);
		tradef.setBounds(366,175,200,30);
		tradef.setBackground(Color.WHITE);
		tradef.setForeground(Color.black);
		tradef.setFont(text);
		id.setBounds(280,215,80,30);
		id.setForeground(Color.LIGHT_GRAY);
		id.setFont(main);
		idf.setBounds(366,215,200,30);
		idf.setBackground(Color.darkGray);
		idf.setForeground(Color.white);
		idf.setFont(text);
		password.setBounds(280,255,80,30);
		password.setFont(main);
		password.setForeground(Color.LIGHT_GRAY);
		passwordf.setBounds(366,255,200,30);
		passwordf.setBackground(Color.darkGray);
		passwordf.setForeground(Color.white);
		passwordf.setFont(text);
		login.setBounds(290,295,120,30);
		login.setFont(main);
		back.setBounds(440,295,100,30);
		
		login.addActionListener(this);
		back.addActionListener(this);
		idf.addKeyListener(this);
		passwordf.addKeyListener(this);
	}

	public static void main(String[] args)
	{
		new studentlogin();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String ch=e.getActionCommand();
		if(ch.equals("Login"))
		{
		login();	
		this.dispose();
		}
	
		if(ch.equals("<<<"))
		{
			new login();
			this.dispose();
		}
		
	}

	public void login()
	{
		idtext=idf.getText();
		@SuppressWarnings("deprecation")
		String pass=passwordf.getText();
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
			con=connect.connection();
			stat=con.prepareStatement("select password from "+ table +" where studentid=? ");
			stat.setString(1, idtext);
			rs= stat.executeQuery();
			if(rs.next())
				{
			pwdDB = rs.getString("password");
					if(pwdDB.equals(pass))
					{	
						new homestud();
						new dashboardstud(idf.getText(),table).setVisible(false);
						new FeeStatus(idf.getText(),table).setVisible(false);
						this.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(this, "You have entered the wrong Password", "Think about it", JOptionPane.WARNING_MESSAGE);
						passwordf.setText("");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "You have entered the wrong Login Id", "Login Error", JOptionPane.WARNING_MESSAGE);
					idf.setText("");
					passwordf.setText("");
				}
			
		}catch(SQLException  sqle)
		{
			sqle.printStackTrace();
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		 if (e.getKeyCode()==KeyEvent.VK_ENTER){
	          login();
	     }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
