package studentsubs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import accountant.managestud;
import connect.connect;


public class accdetails extends JFrame implements ActionListener
{
	JPanel jp=new JPanel(null);
	JLabel fee=new JLabel("Fee :-");
	
	JLabel studid=new JLabel("Student Id");
	JTextField studidf=new JTextField();
	JLabel add=new JLabel("Admission Fee: -");
	JTextField addf=new JTextField();
	JLabel tution=new JLabel("Tution Fee: -");
	JTextField tutionf=new JTextField();
	JLabel hostel=new JLabel("Hostel Fee: -");
	JTextField hostelf=new JTextField();
	JLabel develop=new JLabel("Devlopment Fee: -");
	JTextField developf=new JTextField();
	JLabel amal=new JLabel("Amalgamated fund: -");
	JTextField amalf=new JTextField();
	JLabel cons=new JLabel("Counselling Fee: -");
	JTextField consf=new JTextField();
	JLabel exam=new JLabel("Examination Fee: -");
	JTextField examf=new JTextField();
	JLabel late=new JLabel("Late Fee: -");
	JTextField latef=new JTextField();
	JLabel total=new JLabel("Total Fees");
	JTextField totalf=new JTextField();
	JLabel feep=new JLabel("Fees Paid: -");
	JTextField feepf=new JTextField();	
	JLabel feel=new JLabel("Fees Pending: -");
	JTextField feelf=new JTextField();
	JLabel feen=new JLabel("Fees Recently Paid: -");
	JTextField feenf=new JTextField();
	
	
	JButton done=new JButton("Done");
	
	Connection con;
	PreparedStatement stat;
	ResultSet set;
	
	
	String hosteler,id,branch;
	int totalfees;
	
	public accdetails(String id,String branch)
	{
		this.id=id;
		this.branch=branch+"fee";
		
		System.out.println(this.branch);
		setSize(380,600);
		setTitle("FEE MANAGEMENT SYSTEM");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocation(450,50);
		setResizable(false);
		
		add(jp);
		jp.setBackground(Color.WHITE);
		jp.add(fee);
		jp.add(studid);
		jp.add(studidf);
		jp.add(exam);
		jp.add(examf);
		jp.add(feep);
		jp.add(feepf);
		jp.add(hostel);
		jp.add(hostelf);
		jp.add(add);
		jp.add(addf);
		jp.add(amal);
		jp.add(amalf);
		jp.add(total);
		jp.add(totalf);
		jp.add(tution);
		jp.add(tutionf);
		jp.add(done);
		jp.add(develop);
		jp.add(developf);
		jp.add(late);
		jp.add(latef);
		jp.add(cons);
		jp.add(consf);
		jp.add(feel);
		jp.add(feelf);
		jp.add(feen);
		jp.add(feenf);
		jp.add(done);
		
		
		studid.setBounds (30, 10, 100, 30);
		studidf.setBounds (160, 10, 180, 30);
		studidf.setText(id+", "+branch);
		studidf.setEditable(false);
		add.setBounds(50, 50, 150, 30);
		tution.setBounds(50, 90, 150, 30);
		hostel.setBounds(50, 130, 150, 30);
		develop.setBounds(50,170,150,30);
		amal.setBounds(50, 210, 150, 30);
		cons.setBounds(50, 250, 150, 30);
		exam.setBounds(50, 290, 150, 30);
		late.setBounds(50, 330, 150, 30);
		total.setBounds(50, 370, 150, 30);
		feep.setBounds(50, 410, 150, 30);
		feel.setBounds(50,450,150,30);
		feen.setBounds(50,490,150,30);
		
		addf.setBounds(210, 50, 100, 30);
		addf.setEditable(false);
		tutionf.setBounds(210, 90, 100, 30);
		tutionf.setEditable(false);
		hostelf.setBounds(210, 130, 100, 30);
		hostelf.setEditable(false);	
		developf.setBounds(210, 170, 100, 30);
		developf.setEditable(false);
		amalf.setBounds(210, 210, 100, 30);
		amalf.setEditable(false);
		consf.setBounds(210, 250, 100, 30);
		consf.setEditable(false);
		examf.setBounds(210, 290, 100, 30);
		examf.setEditable(false);
		latef.setBounds(210, 330, 100, 30);
		latef.setEditable(false);
		totalf.setBounds(210, 370, 100, 30);
		totalf.setEditable(false);
		feepf.setBounds(210, 410, 100, 30);
		feepf.setEditable(false);
		feelf.setBounds(210,450,100,30);
		feelf.setEditable(false);
		feenf.setBounds(210,490,100,30);
		
		done.setBounds(130,540,100,30);		
		done.addActionListener(this);

		try{
			con=connect.connection();
			stat=con.prepareStatement("select * from "+ this.branch + " where studentid=? ");
			stat.setString(1, id);
			set =stat.executeQuery();
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
				totalf.setText(""+set.getInt("Amount"));
				feepf.setText(""+set.getInt("feepaid"));
				consf.setText(""+set.getInt("CounselingFee"));
				feelf.setText(""+set.getInt("balance"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
		public static void main(String[] args)
	{
		new accdetails("","");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{

		if(e.getActionCommand().equals("Done"))
		{
			
			if(studidf.getText()!=null && feepf.getText()!= null)
			{
				int feepaid= Integer.parseInt(feepf.getText()) + Integer.parseInt(feenf.getText());
				int feeleft= Integer.parseInt(totalf.getText()) - feepaid;
				try{
					connect.connection();
					stat= con.prepareStatement("update " + this.branch + " set feepaid=?, balance=?  where studentid=?");
					stat.setInt(1, feepaid);
					stat.setInt(2, feeleft);
					stat.setString(3, this.id);
					int i=stat.executeUpdate();
					if(i>0)
					{
						JOptionPane.showMessageDialog(this,"Student fees Updated\n Total Fees"+totalf.getText()+"\n Fee Paid: "+feepaid +"\nFee Left:- "+feeleft,"Succesful",JOptionPane.PLAIN_MESSAGE);
						this.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Fees Not Updated", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}catch(SQLException sqle)
				{
					sqle.printStackTrace();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Correction.. ?","Check the details Carefully",JOptionPane.ERROR_MESSAGE);
			}
				
			
			
		}
		
	}
}

