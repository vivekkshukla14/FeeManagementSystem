package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class login extends JFrame implements ActionListener, MouseListener 
{

	JPanel mainP=new JPanel(null);
	JPanel headP=new JPanel(null);
	JLabel clgname=new JLabel("<html>Chandigarh College of<br>"+"Engineering and Technology");
	JLabel clgimg=new JLabel();
	JLabel login=new JLabel("Welcome to Fee Management System");
	JButton admin=new JButton("<html>Login as<br>"+"Admin Panel");
	JLabel adminlogo=new JLabel();
	JButton acc=new JButton("<html>Login as<br>"+"Accountant Panel");
	JLabel acclogo=new JLabel();
	JButton stud=new JButton("<html>Login as<br>"+"Student Panel");
	JLabel studlogo=new JLabel();
	JButton next=new JButton("Next");
	JLabel clgimg2=new JLabel();
	JButton exit = new JButton("Exit");
	
	Font main=new Font("Times New Roman", Font.BOLD,20);
	
	public login()
	{
		try{
		    UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		getContentPane().add(mainP);
		getContentPane().add(headP);
		
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
		
		mainP.add(login);
		mainP.add(admin);
		mainP.add(acc);
		mainP.add(stud);
		mainP.add(adminlogo);
		mainP.add(acclogo);
		mainP.add(studlogo);
		mainP.add(next);
		mainP.add(exit);
		
		exit.setBounds(710, 450, 100, 30);
		clgimg2.setBounds(0, 0, 860, 500);
		mainP.add(clgimg2);
		try{
			Image img=ImageIO.read(getClass().getResource("/contact.png"));
			clgimg2.setIcon(new ImageIcon(img));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		login.setBounds(200,30,500,40);
		login.setForeground(Color.white);
		login.setFont(new Font("Times New Roman", Font.BOLD,30));
		
		admin.setBounds(40,330,200,50);
		adminlogo.setBounds(30,100,230,200);
		try{
			Image img=ImageIO.read(getClass().getResource("/AdminLogo.png"));
			adminlogo.setIcon(new ImageIcon(img));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		//admin.setBounds(90,120,150,40);
		admin.setFont(main);
		
		acc.setBounds(300,330,200,50);
		acclogo.setBounds(300,100,230,200);
		try{
			Image img=ImageIO.read(getClass().getResource("/accountant.png"));
			acclogo.setIcon(new ImageIcon(img));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		acc.setFont(main);
		
		stud.setBounds(590,330,200,50);
		stud.setFont(main);
		studlogo.setBounds(570,100,230,200);
		try{
			Image img=ImageIO.read(getClass().getResource("/student.jpg"));
			studlogo.setIcon(new ImageIcon(img));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		admin.addActionListener(this);
		acc.addActionListener(this);
		stud.addActionListener(this);
		next.addActionListener(this);
		studlogo.addMouseListener(this);
		adminlogo.addMouseListener(this);
		acclogo.addMouseListener(this);
		exit.addActionListener(this);
	}

	
	public static void main(String args[])
	{
		new login();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	String ch=e.getActionCommand();
	if(ch.equals("<html>Login as<br>"+"Admin Panel"))
	{
		new adminlogin();
		this.dispose();
	}
	if(ch.equals("<html>Login as<br>"+"Accountant Panel"))
	{
		new accountantlogin();
		this.dispose();
	}
	if(ch.equals("<html>Login as<br>"+"Student Panel"))
	{
		new studentlogin();
		this.dispose();
	}
	if(ch.equals("Exit"))
	{
		int i=JOptionPane.showConfirmDialog(this, "Are You Sure you want to Ezit.. ?", "Exit.. ?",JOptionPane.YES_NO_OPTION);
		if(i==0)
		{
			this.dispose();
		}
	}

}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(adminlogo))
		{
			new adminlogin();
			this.dispose();
		}
		else if(e.getSource().equals(acclogo))
		{
			new accountantlogin();
			this.dispose();
		}
		else if(e.getSource().equals(studlogo))
		{
			new studentlogin();
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

