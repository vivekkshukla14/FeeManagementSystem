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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import admin.*;
import connect.connect;

public class adminlogin extends JFrame  implements ActionListener, KeyListener
{
	JPanel mainP=new JPanel(null);
	JPanel headP=new JPanel(null);
	JLabel clgname=new JLabel("<html>Chandigarh College of<br>"+"Engineering and Technology");
	JLabel clgimg=new JLabel();
	
	JLabel headl=new JLabel("Admin Login");
	JLabel id=new JLabel("ID");
	JTextField idf=new JTextField();
	JLabel password=new JLabel("Password");
	JPasswordField passwordf=new JPasswordField();
	
	JButton login=new JButton("Login");
	JButton back=new JButton("<<<");
	
	JLabel l1=new JLabel();
	
	Font main=new Font("Times New Roman", Font.BOLD,20);

	Connection con;
	PreparedStatement stat;
	ResultSet rs;

	public static String  idtxt;
	public adminlogin()
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
		mainP.add(l1);
		
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
		id.setBounds(280,185,80,30);
		id.setForeground(Color.LIGHT_GRAY);
		id.setFont(main);
		idf.setBounds(366,185,200,30);
		idf.setBackground(Color.darkGray);
		idf.setForeground(Color.white);
		password.setBounds(280,235,80,30);
		password.setFont(main);
		password.setForeground(Color.LIGHT_GRAY);
		passwordf.setBounds(366,235,200,30);
		passwordf.setBackground(Color.darkGray);
		passwordf.setForeground(Color.white);
		login.setBounds(290,285,120,35);
		login.setFont(main);
		back.setBounds(440,285,100,35);
		
		login.addActionListener(this);
		back.addActionListener(this);
		idf.addKeyListener(this);
		passwordf.addKeyListener(this);
		
	}

	public static void main(String[] args)
	{
		new adminlogin();
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
		idtxt=idf.getText();
		@SuppressWarnings("deprecation")
		String pass=passwordf.getText();
		try{
			String pwdDB;
			
			con=connect.connection();
			System.out.println("Connection created");
			stat=con.prepareStatement("select * from admin where id=(?)");
			stat.setString(1, idtxt);
			rs= stat.executeQuery();
			if(rs.next())
				{
				pwdDB=	rs.getString("password");
					if(pwdDB.equals(pass))
					{	
						new dashboardadmin(idtxt).setVisible(false);
						new homeadmin();
						this.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(this, "You have entered the wrong Password", "Login Error", JOptionPane.WARNING_MESSAGE);
						passwordf.setText("");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "You have entered the wrong Login Id", "Login Error", JOptionPane.WARNING_MESSAGE);
					idf.setText("");
					passwordf.setText("");
				}
			
		}catch(SQLException sqle)
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
