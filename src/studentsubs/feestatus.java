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

import accountant.*;
import connect.connect;
public class feestatus extends JFrame implements ActionListener
{
	JPanel jp=new JPanel(null);
	JLabel fee=new JLabel("Fee :-");
	
	JLabel studid=new JLabel("Student Id");
	JTextField studidf=new JTextField();
	JLabel add=new JLabel("Admission Fee:- ");
	JTextField addf=new JTextField();
	JLabel tution=new JLabel("Tution Fee:- ");
	JTextField tutionf=new JTextField();
	JLabel hostel=new JLabel("Hostel Fee:- ");
	JTextField hostelf=new JTextField();
	JLabel develop=new JLabel("Devlopment Fee:- ");
	JTextField developf=new JTextField();
	JLabel amal=new JLabel("Amalgamated fund:- ");
	JTextField amalf=new JTextField();
	JLabel cons=new JLabel("Counselling Fee:- ");
	JTextField consf=new JTextField();
	JLabel exam=new JLabel("Examination Fee");
	JTextField examf=new JTextField();
	JLabel late=new JLabel("Late Fee:- ");
	JTextField latef=new JTextField();
	JLabel total=new JLabel("Total Fees");
	JTextField totalf=new JTextField();
	JLabel feep=new JLabel("Fees Paid");
	JTextField feepf=new JTextField();	
	
	
	
	JRadioButton yes=new JRadioButton("Yes");
	JRadioButton no=new JRadioButton("No");
	JButton done=new JButton("Done");
	
	String hosteler,id,branch;
	
	Connection con;
	PreparedStatement stat;
	ResultSet set;
	
	int totalfees;
	
	
	public feestatus(String id,String branch)
	{
		this.id=id;
		this.branch=branch+"fee";
		
		System.out.println(this.branch);
		setSize(410,550);
		setTitle("FEE MANAGEMENT SYSTEM");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocation(450,100);
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
		
		jp.add(done);
		jp.add(yes);
		jp.add(no);
		ButtonGroup br=new ButtonGroup();
		br.add(yes);
		br.add(no);
		
		yes.addActionListener(this);
		no.addActionListener(this);
		studid.setBounds (30, 10, 100, 30);
		studidf.setBounds (160, 10, 150, 30);
		studidf.setText(id);
		studidf.setEditable(false);
		add.setBounds(50, 50, 120, 30);
		tution.setBounds(50, 90, 120, 30);
		hostel.setBounds(50, 130, 120, 30);
		develop.setBounds(50,170,120,30);
		amal.setBounds(50, 210, 120, 30);
		cons.setBounds(50, 250, 120, 30);
		exam.setBounds(50, 290, 120, 30);
		late.setBounds(50, 330, 120, 30);
		total.setBounds(50, 370, 120, 30);
		feep.setBounds(50, 410, 120, 30);
		
		
		addf.setBounds(180, 50, 100, 30);
		addf.setEditable(false);
		tutionf.setBounds(180, 90, 100, 30);
		tutionf.setEditable(false);
		yes.setBounds(180, 130, 60, 30);
		no.setBounds(260, 130, 60, 30);
		hostelf.setEditable(false);	
		developf.setBounds(180, 170, 100, 30);
		developf.setEditable(false);
		amalf.setBounds(180, 210, 100, 30);
		amalf.setEditable(false);
		consf.setBounds(180, 250, 100, 30);
		consf.setEditable(false);
		examf.setBounds(180, 290, 100, 30);
		examf.setEditable(false);
		latef.setBounds(180, 330, 100, 30);
		latef.setEditable(false);
		totalf.setBounds(180, 370, 100, 30);
		totalf.setEditable(false);
		feepf.setBounds(180, 410, 100, 30);

				addf.setText("2900");
				tutionf.setText("500");
				developf.setText("100");
				amalf.setText("1000");
				consf.setText("300");
				examf.setText("700");
				latef.setText("100");
		
		done.setBounds(130,450,100,30);		
		
		done.addActionListener(this);
	}
	
		public static void main(String[] args)
	{
		new feestatus("","");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(yes.isSelected())
		{
			hosteler=yes.getText();
			
			develop.setBounds(50,210,120,30);
			amal.setBounds(50, 250, 120, 30);
			cons.setBounds(50, 290, 120, 30);
			exam.setBounds(50, 330, 120, 30);
			late.setBounds(50, 370, 120, 30);
			total.setBounds(50, 410, 120, 30);
			feep.setBounds(50, 450, 120, 30);
			hostelf.setVisible(true);
			hostelf.setBounds(180, 170, 100, 30);
			hostelf.setText("5100");
			developf.setBounds(180, 210, 100, 30);
			amalf.setBounds(180, 250, 100, 30);
			consf.setBounds(180, 290, 100, 30);
			examf.setBounds(180, 330, 100, 30);
			latef.setBounds(180, 370, 100, 30);
			totalf.setBounds(180, 410, 100, 30);
			feepf.setBounds(180, 450, 100, 30);
			totalfees= Integer.parseInt(addf.getText())+Integer.parseInt(tutionf.getText())+Integer.parseInt(hostelf.getText())+
					Integer.parseInt(developf.getText())+Integer.parseInt(amalf.getText())+Integer.parseInt(consf.getText())+Integer.parseInt(examf.getText())+
					Integer.parseInt(latef.getText());
			totalf.setText(""+totalfees);
			done.setBounds(130, 490, 100, 30);
		}else if(no.isSelected())
		{
			hosteler=no.getText();
			
			hostelf.setText("0");
			hostelf.setVisible(false);
			develop.setBounds(50,170,120,30);
			amal.setBounds(50, 210, 120, 30);
			cons.setBounds(50, 250, 120, 30);
			exam.setBounds(50, 290, 120, 30);
			late.setBounds(50, 330, 120, 30);
			total.setBounds(50, 370, 120, 30);
			feep.setBounds(50, 410, 120, 30);	
			
			developf.setBounds(180, 170, 100, 30);
			amalf.setBounds(180, 210, 100, 30);
			consf.setBounds(180, 250, 100, 30);
			examf.setBounds(180, 290, 100, 30);
			latef.setBounds(180, 330, 100, 30);
			totalf.setBounds(180, 370, 100, 30);
			totalfees= Integer.parseInt(addf.getText())+Integer.parseInt(tutionf.getText())+Integer.parseInt(developf.getText())+
					Integer.parseInt(amalf.getText())+Integer.parseInt(consf.getText())+Integer.parseInt(examf.getText())+
					Integer.parseInt(latef.getText());
			totalf.setText(""+totalfees);
			
			feepf.setBounds(180, 410, 100, 30);
		}
		
		
		if(e.getActionCommand().equals("Done"))
		{
			
			if(studidf.getText()!=null && feepf.getText()!= null)
			{
				int left= totalfees-Integer.parseInt(feepf.getText());
				System.out.println(totalfees);
				try{
					
					con=connect.connection();
					stat= con.prepareStatement("insert into "+ branch + "(studentid, Hosteler, AdmissionFee, TuitionFee, HostelFee, DevelopmentFee, AmalgamatedFunds, CounselingFee, ExamFee, LateFee, amount, feepaid, balance) Values(?,?,?,?,?,?,?,?,?,?,?,?,?) ");
					stat.setString(1, studidf.getText());
					stat.setString(2, hosteler);
					stat.setInt(3, Integer.parseInt(addf.getText()));
					stat.setInt(4, Integer.parseInt(tutionf.getText()));  
					stat.setInt(5, Integer.parseInt(hostelf.getText()));
					stat.setInt(6, Integer.parseInt(developf.getText()));
					stat.setInt(7, Integer.parseInt(amalf.getText()));
					stat.setInt(8, Integer.parseInt(consf.getText()));
					stat.setInt(9, Integer.parseInt(examf.getText()));
					stat.setInt(10, Integer.parseInt(latef.getText()));
					stat.setInt(11, Integer.parseInt(totalf.getText()));
					stat.setInt(12, Integer.parseInt(feepf.getText()));
					stat.setInt(13, left);
				
					int i=stat.executeUpdate();
					if(i>0)
					{
						JOptionPane.showMessageDialog(this,"Student fees Updated\n Total Fees"+totalf.getText()+"\n Fee Paid: "+feepf.getText() +"\nFee Left:- "+left,"Succesful",JOptionPane.PLAIN_MESSAGE);
						this.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Student Fees not Updated");
					}
				}catch(SQLException  sqle)
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

