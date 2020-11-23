package subs;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import accountant.dashboardacc;
import connect.connect;

public class reply extends JFrame implements ActionListener
{
	JPanel jp=new JPanel(null);
	JPanel jp2=new JPanel(null);
	
	JComboBox<String> queries=new JComboBox<String>();
	JLabel query=new JLabel("QUERY: -");
	JLabel reply=new JLabel("Reply: -");
	JTextArea querya=new JTextArea();
	JTextArea replya=new JTextArea();
	JScrollPane sp=new JScrollPane();
	
	JButton send=new JButton("Reply");
	JButton ignore=new JButton("Ignore");
	JButton delete=new JButton("DELETE");
	JButton remain=new JButton("REMAIN");
	JButton next=new JButton("NEXT");
	JButton back=new JButton("PREVIOUS");
	
	Connection con;
	PreparedStatement stat;
	ResultSet id,set;
	int i;
	
	JLabel emp=new JLabel();
	
	ArrayList<String> emplist=new ArrayList<String>();
	
	java.util.Date date=new java.util.Date();
	Timestamp cdate=new java.sql.Timestamp(date.getTime());
	
	public reply()
	{
		setSize(650,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(300,100);
		setResizable(false);
		
		getContentPane().add(jp);
		getContentPane().add(jp2);
		jp.setBounds(0,0,150,400);
		jp.setBackground(Color.white);
		jp.setBorder(new LineBorder(Color.black,1));
				
		jp2.setBounds(150,0,450,400);
		jp2.setBackground(Color.white);
		jp2.setBorder(new LineBorder(Color.black,1));
		
		jp.add(sp);
		jp.add(queries);
		jp.add(emp);
		queries.addItem("Queries");
		queries.addItem("FeedBack");
		queries.setBounds(5,10,140,30);
		
		
		jp2.add(querya);
		jp2.add(reply);
		jp2.add(query);
		jp2.add(replya);
		jp2.add(send);
		jp2.add(ignore);
		jp2.add(delete);
		jp2.add(remain);
		jp2.add(next);
		jp2.add(back);
		
		querya.setBorder(new LineBorder(Color.black,2));
		querya.setBackground(Color.getHSBColor(11, 22, 22));
		querya.setBounds(250,10,380,120);
		querya.setEditable(false);
		query.setBounds(160,10,80,120);
		replya.setBorder(new LineBorder(Color.black,2));
		replya.setBounds(250,145,380,120);
		reply.setBounds(160,145,80,120);
		send.setBounds(240,320,120,30);
		ignore.setBounds(420,320,120,30);
		delete.setBounds(240,320,120,30);
		remain.setBounds(420,320,120,30);
		next.setBounds(490,280,120,30);
		back.setBounds(180,280,120,30);
		
		query();
		send.addActionListener(this);
		ignore.addActionListener(this);
		queries.addActionListener(this);
		next.addActionListener(this);
		back.addActionListener(this);
	}

	
	public void query()
	{
		setTitle("ACCOUNTANT QUERY BOX");
		query.setText("QUERY: -");
		replya.setVisible(true);
		reply.setVisible(true);
		send.setVisible(true);
		ignore.setVisible(true);
		delete.setVisible(false);
		remain.setVisible(false);
		emplist.clear();
		try{
			
			con=connect.connection();
			stat=con.prepareStatement("select * from accountantreview where status='0'");
			id=stat.executeQuery();
			if(id.next())
			{
				emp.setText(""+id.getString(2));
				emp.setBounds(5,100,140,30);
				querya.setText(""+id.getString(3));
			}
			else
			{
				emp.setText("NO NEW QUERY");
				emp.setBounds(5,150,140,30);
				querya.setText("");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	public void feedback()
	{
		setTitle("ACCOUNTANT FEEDBACK BOX");
		
		query.setText("FEEDBACK:- ");
		reply.setVisible(false);
		replya.setVisible(false);
		send.setVisible(false);
		ignore.setVisible(false);
		delete.setVisible(true);
		remain.setVisible(true);
		
		try{
			con=connect.connection();
			stat=con.prepareStatement("select * from accountantfeedback where status='0'");
			id=stat.executeQuery();
			if(id.next())
			{
				emp.setText(""+id.getString(2));
				emp.setBounds(5,100,140,30);
				querya.setText(""+id.getString(3));
			}
			else
			{
				emp.setText("NO NEW FEEDBACK");
				emp.setBounds(5,150,140,30);
				querya.setText("");
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		new reply();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//SELECTION OF HEADINGS
		if(e.getSource().equals(queries))
		{
			if(queries.getSelectedItem()=="Queries")
			{
				System.out.println("QUERY");
				query();
			}
			
			if(queries.getSelectedItem()=="FeedBack")
			{
				System.out.println("FEEDBACK");
				feedback();
			}
		}
		
		// SEND REPLY from QUERIES
		if(e.getSource().equals(send))
		{
			String message=querya.getText();
			String replytext=replya.getText();
			if(message.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Write a Message First", "Blank !!!", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				
				System.out.println("Time="+cdate);
				try{
					con=connect.connection();
					stat=con.prepareStatement("Insert into studentreviewreply(query, reply, replytime, studentid) values(?,?,?,?)");
					stat.setString(1, message);
					stat.setString(2, replytext);
					stat.setTimestamp(3, cdate);
					stat.setString(4, emp.getText());
					int i=stat.executeUpdate();
					if(i>0)
					{
						JOptionPane.showMessageDialog(this, "REPLY HAS BEEN SENT","SENT", JOptionPane.INFORMATION_MESSAGE);
						replya.setText("");
						next();
					}
					else
					{
						JOptionPane.showMessageDialog(this, "REPLY NOT SENT","ERROR",JOptionPane.ERROR);
					}
				}catch(Exception exp)
				{
					exp.printStackTrace();
				}
			}
		}
		
		
		//IGNORE from QUERIES
		if(e.getSource().equals(ignore))
		{
			int i=JOptionPane.showConfirmDialog(this, "Are you Sure You Want to Ignore. ?","Confirm!!", JOptionPane.YES_NO_CANCEL_OPTION);
			if(i==0)
			{
				try{
					con=connect.connection();
					stat=con.prepareStatement("Update accountantreview Set status=1 where employeeid=?");
					stat.setString(1, emp.getText());
					int a=stat.executeUpdate();
					if(a>0)
					{
						next();
					}
				}catch(Exception exp)
				{
					exp.printStackTrace();
				}
			}
		
		}
		
		// DELETE from FEEDBACK
		if(e.getSource().equals(delete))
		{
			String id=emp.getText();
			try{
				con=connect.connection();
				stat=con.prepareStatement("delete * from accountantreview where studentid=?");
				stat.setString(1, emp.getText());
				int a=stat.executeUpdate();
				{
					JOptionPane.showMessageDialog(this, "FEEDBACK DELETED SUCCESFULLY", "DELETED", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("DELETED SUCCESFULLY");
					next();
				}
			}catch(Exception exp)
			{
				exp.printStackTrace();
			}
		}
		
		// REMAIN FROM (FEEDBACK)
		if(e.getSource().equals(remain))
		{
			try{
				con=connect.connection();
				stat=con.prepareStatement("Update accountantfeedback set status='1' where employeeid=? ");
				stat.setString(1, emp.getText());
				int a=stat.executeUpdate();
				if(a>0)
				{
					JOptionPane.showMessageDialog(this, "FEEDBACK REMAINED", "SAVED", JOptionPane.INFORMATION_MESSAGE);
					System.out.println("REMAINED SUCCESFULLY");
					next();
				}
			}catch(Exception exp)
			{
				exp.printStackTrace();
			}
		}
		
		
		// NEXT BUTTON
		if(e.getSource().equals(next))
		{	
			next();
		}
		
		
		// PREVIOUS BUTTON
		if(e.getSource().equals(back))
		{
			String idf = emp.getText();
			String table=null;
			if(queries.getSelectedItem()=="Queries")
			{
				table="accountantreview";
			}
			if(queries.getSelectedItem()=="FeedBack")
			{
				table="accountantfeedback";
			}
			int sno = 0;
			try {
				con=connect.connection();
				stat=con.prepareStatement("select * from "+ table +" where employeeid=?");
				stat.setString(1, idf);
				id=stat.executeQuery();
				if(id.next())
				{
					sno=id.getInt("sno");
				}
				System.out.println(sno);
				stat=con.prepareStatement("select * from "+ table +" where sno=? & status='0'");
				stat.setInt(1, --sno);
				set=stat.executeQuery();
				if(set.next())
				{
					emp.setText(""+set.getString(2));
					querya.setText(""+set.getString(3));
				}
				else
				{
					JOptionPane.showMessageDialog(this, "NO MORE PREVIOUS DATE IS THERE", "THE END!!", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		}
	}
	
	
	// NEXT BUTTON QUERY OR FEEDBACK CODING
	public void next()
	{
		String idf = emp.getText();
		int sno = 0;
		String table=null;
		if(queries.getSelectedItem()=="Queries")
		{
			table="accountantreview";
		}
		if(queries.getSelectedItem()=="FeedBack")
		{
			table="accountantfeedback";
		}
		try {
			con=connect.connection();
			stat=con.prepareStatement("select * from "+ table +" where employeeid=? ");
			stat.setString(1, idf);
			id=stat.executeQuery();
			if(id.next())
			{
				sno=id.getInt("sno");
			}
			stat=con.prepareStatement("select * from "+ table +" where sno=?");
			stat.setInt(1, ++sno);
			set=stat.executeQuery();
			if(set.next())
			{
				System.out.println(""+set.getInt(1));
				emp.setText(""+set.getString(2));
				querya.setText(""+set.getString(3));
			}
			else
			{
				JOptionPane.showMessageDialog(this, "NO MORE DATA IS THERE", "THE END!!", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}