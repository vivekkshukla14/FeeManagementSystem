package student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import connect.connect;

public class studreply extends JFrame implements ActionListener
{
	 JButton  back = new JButton("Previous");
     JButton  backf = new JButton("Previous");
     JLabel   feedback = new JLabel("Your FeedBack's");
     JTextArea  feedbacka = new JTextArea();
     JPanel jPanel1 = new JPanel(null);
     JPanel jPanel2 = new JPanel(null);
     JScrollPane jScrollPane1 = new JScrollPane();
     JScrollPane   jScrollPane2 = new JScrollPane();
     JScrollPane jScrollPane3 = new JScrollPane();
     JTabbedPane jTabbedPane1= new JTabbedPane();;
     JButton   next = new JButton("Next");
     JButton nextf = new JButton("Next");
     JLabel query = new JLabel("Query");
     JTextArea  querya = new JTextArea();
     JButton  queryagain = new JButton("Query Again");
     JLabel reply = new JLabel("Reply");
     JTextArea replya = new JTextArea();
     JButton satisfy = new JButton("Satisfied..?");
    
     
     Connection con;
     PreparedStatement stat;
     ResultSet set;
     JLabel feedbackt = new JLabel("");
     JLabel FeedbackTime = new JLabel("Feedback time:- ");
     
     public  studreply() {
    	 setBounds(195, 160, 580, 380);
    	 setTitle("Your Queries And FeedBack's");
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         tab1();
         
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         layout.setHorizontalGroup(
         	layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(layout.createSequentialGroup()
         			.addContainerGap()
         			.addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
         			.addContainerGap(33, Short.MAX_VALUE))
         );
         layout.setVerticalGroup(
         	layout.createParallelGroup(Alignment.LEADING)
         		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
         			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         			.addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
         );
         getContentPane().setLayout(layout);
         tab2();
         jPanel1.setBackground(Color.WHITE);
           
           querya.setColumns(20);
           querya.setRows(5);
           jScrollPane1.setViewportView(querya);
           
            replya.setColumns(20);
            replya.setRows(5);
            jScrollPane2.setViewportView(replya);
            replya.setEditable(false);
            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(query, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                        .addComponent(reply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                        .addComponent(jScrollPane2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(satisfy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(queryagain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(satisfy, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(queryagain, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(25, 25, 25))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(query, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addComponent(reply, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(17, 17, 17)))))
                    .addContainerGap(13, Short.MAX_VALUE))
            );
            
                     jTabbedPane1.addTab("Your Queries", jPanel1);
                     
                          querya.setEditable(false);
                          jPanel2.setBackground(Color.WHITE);
                          feedback.setText("<html><center>Your FeedBack's");
                          feedback.setFont(new Font("Times New Roman",Font.BOLD, 30));
                          feedbacka.setEditable(false);
                          feedbacka.setColumns(20);
                          feedbacka.setRows(5);
                          jScrollPane3.setViewportView(feedbacka);
                          

                          javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                          jPanel2Layout.setHorizontalGroup(
                          	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
                          		.addGroup(jPanel2Layout.createSequentialGroup()
                          			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                          				.addGroup(jPanel2Layout.createSequentialGroup()
                          					.addGap(58)
                          					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                          						.addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                          						.addComponent(feedback, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                          						.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                          							.addComponent(FeedbackTime, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                          							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                          							.addComponent(feedbackt, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))))
                          				.addGroup(jPanel2Layout.createSequentialGroup()
                          					.addGap(100)
                          					.addComponent(backf, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                          					.addGap(35)
                          					.addComponent(nextf, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
                          			.addGap(45))
                          );
                          jPanel2Layout.setVerticalGroup(
                          	jPanel2Layout.createParallelGroup(Alignment.LEADING)
                          		.addGroup(jPanel2Layout.createSequentialGroup()
                          			.addContainerGap()
                          			.addComponent(feedback, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                          			.addGap(18)
                          			.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                          			.addGap(19)
                          			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
                          				.addComponent(backf, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                          				.addComponent(nextf, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                          			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
                          				.addGroup(jPanel2Layout.createSequentialGroup()
                          					.addGap(14)
                          					.addComponent(feedbackt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                          				.addGroup(jPanel2Layout.createSequentialGroup()
                          					.addPreferredGap(ComponentPlacement.UNRELATED)
                          					.addComponent(FeedbackTime, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
                          			.addContainerGap())
                          );
                          jPanel2.setLayout(jPanel2Layout);
                          
                                   jTabbedPane1.addTab("Your FeedBack's", jPanel2);
         nextf.addActionListener(this);
         backf.addActionListener(this);
         next.addActionListener(this);
         back.addActionListener(this);
         satisfy.addActionListener(this);
         queryagain.addActionListener(this);
         
     }
     
     
     public void tab1()
     {
    	 try{
    		 	con=connect.connection();
    			stat=con.prepareStatement("select * from studentreviewreply where studentid=?");
    			stat.setString(1, dashboardstud.idf.getText());
    			set=stat.executeQuery();
    			if(set.next())
    			{
    				querya.setText(""+set.getString("query"));
    				replya.setText(""+set.getString("reply"));
    				
    			}
    			else
    			{
    				querya.setText("NO NEW Query");
    				querya.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));
    			}
    		 
    		 
    	 }catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
     }


     public void tab2()
     {
    	 try{
    		 	con=connect.connection();
    			stat=con.prepareStatement("select * from studentfeedback where studentid=?");
    			stat.setString(1, dashboardstud.idf.getText());
    			set=stat.executeQuery();
    			if(set.next())
    			{
    				feedbacka.setText(""+set.getString("feedback"));
    				feedbackt.setText(""+set.getTimestamp("feedbacktime"));
    			}
    			else
    			{
    				feedbacka.setText("NO FeedBack Sent by YOU !!!");
    				feedbacka.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,24));
    			}
    		 
    		 
    	 }catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
     }
     
     
    public static void main(String args[]) {

                new studreply().setVisible(true);
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String ch=e.getActionCommand();
	
		if(ch.equals(backf))
		{
			int sno=0;
			try{
				con=connect.connection();
    			stat=con.prepareStatement("select * from studentfeedback where studentid=?");
    			stat.setString(1, dashboardstud.idf.getText());
    			set=stat.executeQuery();
    			if(set.next())
    			{
    				sno=set.getInt(1);
    			}
    			stat=con.prepareStatement("select * from studentfeedback where sno=? & studentid=?");
    			stat.setInt(1, --sno);
    			stat.setString(2, dashboardstud.idf.getText());
    			set=stat.executeQuery();
    			if(set.next())
    			{
    				feedbacka.setText(""+set.getString("feedback"));
    				feedbackt.setText(""+set.getTimestamp("feedbacktime"));
    			}
    			else
    			{
    				JOptionPane.showMessageDialog(this, "No Previous FeedBack. !","Back!!", JOptionPane.INFORMATION_MESSAGE);
    			}
    			
    		 
    	 }catch(Exception exp)
    	 {
    		 exp.printStackTrace();
    	 }
		}
		
		if(ch.equals(nextf))
		{
			int sno=0;
			try{
				con=connect.connection();
    			stat=con.prepareStatement("select * from studentfeedback where studentid=?");
    			stat.setString(1, dashboardstud.idf.getText());
    			set=stat.executeQuery();
    			if(set.next())
    			{
    				sno=set.getInt(1);
    			}
    			stat=con.prepareStatement("select * from studentfeedback where sno=? & studentid=?");
    			stat.setInt(1, ++sno);
    			stat.setString(2, dashboardstud.idf.getText());
    			set=stat.executeQuery();
    			if(set.next())
    			{
    				feedbacka.setText(""+set.getString("feedback"));
    				feedbackt.setText(""+set.getTimestamp("feedbacktime"));
    			}
    			else
    			{
    				JOptionPane.showMessageDialog(this, "No Next FeedBack !","Back!!", JOptionPane.INFORMATION_MESSAGE);
    			}
    			
    		 
    	 }catch(Exception exp)
    	 {
    		 exp.printStackTrace();
    	 }
		}
		
		
		if(ch.equals(back))
		{
			int sno=0;
			try{
				con=connect.connection();
    			stat=con.prepareStatement("select * from studentreviewreply where studentid=?");
    			stat.setString(1, dashboardstud.idf.getText());
    			set=stat.executeQuery();
    			if(set.next())
    			{
    				sno=set.getInt(1);
    			}
    			stat=con.prepareStatement("select * from studentreviewreply where sno=? & studentid=?");
    			stat.setInt(1, --sno);
    			stat.setString(2, dashboardstud.idf.getText());
    			set=stat.executeQuery();
    			if(set.next())
    			{
    				querya.setText(""+set.getString("query"));
    				replya.setText(""+set.getString("reply"));
    			}
    			else
    			{
    				JOptionPane.showMessageDialog(this, "No Previous Query.. !","Back!!", JOptionPane.INFORMATION_MESSAGE);
    			}
    			
    		 
    	 }catch(Exception exp)
    	 {
    		 exp.printStackTrace();
    	 }
		}
		
		if(ch.equals(next))
		{
			int sno=0;
				try{
					con=connect.connection();
				stat=con.prepareStatement("select * from studentreviewreply where studentid=?");
				stat.setString(1, dashboardstud.idf.getText());
				set=stat.executeQuery();
				if(set.next())
				{
					sno=set.getInt(1);
				}
				stat=con.prepareStatement("select * from studentfeedback where sno=? & studentid=?");
				stat.setInt(1, ++sno);
				stat.setString(2, dashboardstud.idf.getText());
				set=stat.executeQuery();
				if(set.next())
				{
					querya.setText(""+set.getString("query"));
					replya.setText(""+set.getString("reply"));
				}
				else
				{
					JOptionPane.showMessageDialog(this, "No Next Query.. !","Back!!", JOptionPane.INFORMATION_MESSAGE);
				}
				
	    		 
	    	 }catch(Exception exp)
	    	 {
	    		 exp.printStackTrace();
	    	 }
		}
		
		if(e.getSource().equals(queryagain))
		{
			new contactus();
			this.dispose();
		}
		
		if(ch.equals(satisfy))
		{
			try{
				con=connect.connection();
				stat=con.prepareStatement("Update studentreviewreply SET status='1' where studentid=? && query=?");
				stat.setString(1, dashboardstud.idf.getText());
				stat.setString(2, querya.getText());
				set=stat.executeQuery();
				if(set.next())
				{
					JOptionPane.showMessageDialog(this, "Thank You!! For your Response", "Satisfied..! :) ",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "No Next Query.. !","Back!!", JOptionPane.INFORMATION_MESSAGE);
				}
				
	    		 
	    	 }catch(Exception exp)
	    	 {
	    		 exp.printStackTrace();
	    	 }
		}
	}
}
