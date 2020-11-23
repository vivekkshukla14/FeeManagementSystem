package studentsubs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class viewstudlist extends JFrame implements ActionListener 
{

	Connection connection;
	ResultSet set;
	JPanel jp=new JPanel(null);
	
	JLabel trade=new JLabel("Choose the Trade:- ");
	JComboBox<String> choose=new JComboBox<String>();
	JButton search=new JButton("Search");
	
	public viewstudlist()
	{	add(jp);
		
	jp.add(choose);
	jp.add(trade);
	jp.add(search);
	
	trade.setBounds(20,10,200,30);
	choose.setBounds(200,10,200,30);
	search.setBounds(410,10,100,30);
	
	choose.setOpaque(true);
	
	choose.addItem("All");
	choose.addItem("CSE");
	choose.addItem("ECE");
	choose.addItem("Civil Engg.");
	choose.addItem("Electrical Engg.");
	choose.addItem("Architecture Engg.");
	choose.addItem("Production Engg.");
	choose.addItem("Mechanical Engg.");
	
	
	search.addActionListener(this);
	
			
			
		//table.setBounds(0,40 ,450 , 450);
		//sp.setBounds(10,40 ,450 ,850 );
		setLocation(415,180);
		setBounds(216, 206, 869, 494);
	
		setTitle("View Student List");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
			
	}

	public static void main(String args[]) 
	{
		new viewstudlist();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String query = null;
		if(e.getActionCommand().equals("Search"))
		{
			
			if(choose.getSelectedItem().equals("All"))
			{
				query="select * from cse, csefee where cse.studentid=csefee.studentid UNION ALL"+" Select * from ece e, ecefee ee where e.studentid = ee.studentid UNION ALL "+
						"Select * from civil s, civilfee f where f.studentid = s.studentid UNION ALL"+" Select * from mechanical s, mechanicalfee f where f.studentid = s.studentid UNION ALL "+
						"Select * from architecture s, architecturefee f where f.studentid = s.studentid UNION ALL"+" Select * from production s, productionfee f where f.studentid = s.studentid UNION ALL "+
						"Select * from electrical s, electricalfee f where f.studentid = s.studentid";	
			}
			if(choose.getSelectedItem().equals("CSE"))
			{
				query="Select * from cse s, csefee f "+"where f.studentid = s.studentid"+" ORDER by s.sno asc";
			}
			if(choose.getSelectedItem().equals("ECE"))
			{
				query="Select * from ece s, ecefee f "+"where f.studentid = s.studentid"+"  ORDER by s.sno asc";
			}
			if(choose.getSelectedItem().equals("Civil Engg."))
			{
				query="Select * from civil s, civilfee f "+"where f.studentid = s.studentid"+"  ORDER by s.sno asc";
			}
			if(choose.getSelectedItem().equals("Mechanical Engg."))
			{
				query="Select * from mechanical s, mechanicalfee f "+"where f.studentid = s.studentid"+"  ORDER by s.sno asc";
			}
			if(choose.getSelectedItem().equals("Architecture Engg."))
			{
				query="Select * from architecture s, architecturefee f "+"where f.studentid = s.studentid"+"  ORDER by s.sno asc";
			}
			if(choose.getSelectedItem().equals("Production Engg."))
			{
				query="Select * from production s, productionfee f "+"where f.studentid = s.studentid"+"  ORDER by s.sno asc";
			}
			if(choose.getSelectedItem().equals("Electrical Engg."))
			{
				query="Select * from electrical s, electricalfee f "+"where f.studentid = s.studentid"+"  ORDER by s.sno asc";
			}
		
			Vector<String> v1=new Vector<String>();
			
			Vector<Vector> v2=new Vector<Vector>();
			
			v1.add("SNO");
			v1.add("Name");
			v1.add("Student_ID");
			v1.add("Trade");
			v1.add("Total_Fee");
			v1.add("Fee_Paid");
			v1.add("Fee_Pending");
			int SNO;
			String Name, Student_ID, Trade;
			float Total_Fee, Fee_Paid, Fee_Pending;
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver Loaded");
				connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/fms","root","");
				System.out.println("connection created");
			
			Statement stmt;
			stmt= connection.createStatement();
			System.out.println("Query= "+query);
			set= stmt.executeQuery(query);
			while(set.next())
			{	
				Vector v3=new Vector();	
				SNO=set.getInt("sno");
				Name=set.getString("name");
				Student_ID=set.getString("studentid");
				Trade=set.getString("branch");
				Total_Fee=set.getFloat("amount");
				Fee_Paid=set.getFloat("feepaid");
				Fee_Pending=set.getFloat("balance");
				v3.add(SNO);
				v3.add(Name);
				v3.add(Student_ID);
				v3.add(Trade);
				
				v3.add(Total_Fee);
				v3.add(Fee_Paid);
				v3.add(Fee_Pending);
			
				v2.add(v3);
			}
			
			}catch(ClassNotFoundException cnf)
			{
			cnf.printStackTrace();	
			}catch(SQLException sq)
			{
				sq.printStackTrace();
			}
			JTable table= new JTable(v2,v1);
			table.setBackground(Color.WHITE);
			JScrollPane sp=new JScrollPane(table);
			jp.add(sp);
			sp.setBounds(10,50 ,835 ,600 );

		}
	}

}
