package subs;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connect.connect;

public class viewacclist extends JFrame
{
	JPanel jp= new JPanel(null);
	Connection connection;
	PreparedStatement statement;
	ResultSet  set;
	
	public viewacclist()
	{
			Vector<String> v1=new Vector<String>();
			Vector v2=new Vector();
		
			v1.add("Sno");
			v1.add("Employee_id");
			v1.add("Name");
			v1.add("Contactno");
			v1.add("Salary");
			
			int Sno;
			String Employee_id,Name,Contactno;
			float Salary;
		
		try
		{
			connection=connect.connection();
			statement = connection.prepareStatement("select * from accountant a "+" ORDER by a.sno asc");
			set=statement.executeQuery();
			while(set.next())
			{
				Vector v3=new Vector();
				Sno=set.getInt("Sno");
				Employee_id=set.getString("employeeid");
				Name=set.getString("Name");
				Contactno=set.getString("contactno");
				Salary=set.getFloat("salary");
				
				v3.add(Sno);
				v3.add(Employee_id);
				v3.add(Name);
				v3.add(Contactno);
				v3.add(Salary);
				
				v2.add(v3);
			}
		
		}catch(SQLException sq)
		{
			sq.printStackTrace();
		}	
		
		JTable table= new JTable(v2,v1);
		JScrollPane sp=new JScrollPane(table);
		
			add(sp);
				
		//table.setBounds(10,10 ,450 , 450);
		//sp.setBounds(10,10 ,450 ,850 );
			setLocation(415,180);
			setBounds(216, 206, 869, 494);
			setTitle("View Student List");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		new viewacclist();
	}

}
