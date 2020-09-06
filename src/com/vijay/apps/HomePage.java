package com.vijay.apps;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;

public class HomePage extends JFrame {

	private JPanel contentPane;
private static List<Question> questions;
int currentQuestion;
private Timer timer;
private Dimension screenSize;
private long duration = 15000;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage()  throws NullPointerException,IndexOutOfBoundsException{
		
		 questions=new ArrayList<Question>() ;
			questions.add(new Question("How to kill an activity in Android?",3 ,"finish()","finishActivity(int requestCode)","A & B" ,"kill()"));
			
			questions.add(	new Question("What is android view group?",1 ,"Collection of views and other child views","Base class of building blocks ","Layouts" ,"None of the Above ")
				);
			questions.add(new Question("How many threads are there in asyncTask in android?",1 ,"Only one" , "two","AsyncTask doesn't have tread" ,"None")
					);
			questions.add(new Question("What is the use of content provider in android?",3 ,"A - To send the data from an application to another application", "To store the data in a database","C - To share the data between applications" ,"None of the Above "));
			questions.add(new Question("How to get current location in android?",3 ,"Using with GPRS", "Using location provider ","A & B" ,"SQlite"));
			
			currentQuestion=0;
			
			 GraphicsEnvironment graphics =
				      GraphicsEnvironment.getLocalGraphicsEnvironment();
				      GraphicsDevice device = graphics.getDefaultScreenDevice();
				       screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				    
			this.setSize(screenSize.width, screenSize.height);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setSize(screenSize.width, screenSize.height);
		setContentPane(contentPane);
	
	
		ButtonGroup btngrp=new ButtonGroup(); 
		contentPane.setLayout(null);
		
	
		JPanel panel = new JPanel();		
		panel.setLocation(20, 10);
		panel.setSize(screenSize.width-40, screenSize.height/10);
		panel.setBorder(new LineBorder(new Color(0, 0, 139), 2, true));
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel question = new JLabel("",JLabel.CENTER);
		question.setBounds(12, 7, 1856, 88);
		question.setFont(new Font("Segoe UI", Font.PLAIN, 40));
		question.setText(questions.get(currentQuestion).getQuestion());
		panel.add(question);
		
		JPanel options = new JPanel();
		options.setLocation(20, 128);
		options.setSize(screenSize.width-40, (screenSize.height/10)*7);
		options.setBorder(new LineBorder(new Color(0, 0, 139), 2, true));
		options.setBackground(new Color(255, 255, 255));
		contentPane.add(options);
		options.setLayout(null);
		
		JRadioButton op1 = new JRadioButton("");
		op1.setBounds(8, 9, 1864, 189);
		op1.setFont(new Font("Segoe UI", Font.PLAIN, 40));
		op1.setBackground(new Color(255, 255, 255));
		op1.setText(questions.get(currentQuestion).get1());
		options.add(op1);
		
		JRadioButton op2 = new JRadioButton("");
		op2.setBounds(8, 170, 1864, 189);
		op2.setFont(new Font("Segoe UI", Font.PLAIN, 40));
		op2.setBackground(Color.WHITE);
		op2.setText(questions.get(currentQuestion).get2());
		options.add(op2);
		
		JRadioButton op3 = new JRadioButton("");
		op3.setBounds(8, 364, 1864, 189);
		op3.setFont(new Font("Segoe UI", Font.PLAIN, 40));
		op3.setBackground(Color.WHITE);
		op3.setText(questions.get(currentQuestion).get3());
		options.add(op3);
		
		JRadioButton op4 = new JRadioButton("");
		op4.setBounds(8, 558, 1864, 189);
		op4.setFont(new Font("Segoe UI", Font.PLAIN, 40));
		op4.setBackground(Color.WHITE);
		op4.setText(questions.get(currentQuestion).get4());
		options.add(op4);
		
		btngrp.add(op1);
		btngrp.add(op2);
		btngrp.add(op3);
		btngrp.add(op4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setLocation(1640, 894);
		panel_2.setSize(300-40, 100);
		panel_2.setBorder(new MatteBorder(1, 4, 4, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.textHighlight);
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(op1.isSelected()) {
					questions.get(currentQuestion).setSelectedAnswer(1);					
				}else if(op2.isSelected()) {					
					questions.get(currentQuestion).setSelectedAnswer(2);
				}else if (op3.isSelected()) {
					questions.get(currentQuestion).setSelectedAnswer(3);
				}else if(op4.isSelected()) {
					questions.get(currentQuestion).setSelectedAnswer(4);
				}
				currentQuestion++;
				btngrp.clearSelection();
				if(currentQuestion==questions.size()) {
					timer.stop();
					showResult();
return;
					
				}
				question.setText(questions.get(currentQuestion).getQuestion());
				op1.setText(questions.get(currentQuestion).get1());
				op2.setText(questions.get(currentQuestion).get2());
				op3.setText(questions.get(currentQuestion).get3());
				op4.setText(questions.get(currentQuestion).get4());
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panel_2.setBackground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(SystemColor.textHighlight);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panel_2.setBackground(Color.GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panel_2.setBackground(SystemColor.textHighlight);

			}
		});
		contentPane.add(panel_2);
		panel_2.setLayout(null);
	
	
		
		JLabel next = new JLabel("Next",JLabel.CENTER);
		next.setBounds(12, 7, 236, 80);
		next.setForeground(new Color(255, 255, 255));
		next.setFont(new Font("Tahoma", Font.BOLD, 45));
		panel_2.add(next);
		
		 
          
          JPanel panel_1 = new JPanel();
          panel_1.setBorder(new MatteBorder(1, 4, 4, 1, (Color) new Color(0, 0, 0)));
          panel_1.setBackground(Color.YELLOW);
          panel_1.setBounds(20, 901, 260, 100);
          contentPane.add(panel_1);
          panel_1.setLayout(null);
          
          JLabel lblNewLabel = new JLabel("New label");
          lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 40));
          lblNewLabel.setBounds(12, 13, 236, 74);
          panel_1.add(lblNewLabel);
          lblNewLabel.setBackground(Color.YELLOW);
          lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
          lblNewLabel.setText(duration/1000+" seconds");
          timer = new Timer(1000, new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {  
            	  duration-=1000;
                  lblNewLabel.setText(duration/1000+" seconds");
                  if(duration==0) {
                	  showResult();

                  }
            	  
              }
          });
          if (!timer.isRunning()) {
              timer.start();
          }

          setUndecorated(true);

		setResizable(false);

	   
	}
	void showResult(){
		int c=0,w=0,t=0,u=0;
		for(Question q : questions) {
			t++;
			if(q.getResult()==1)
				c++;
			else if (q.getResult()==0)
				w++;
			else 
				u++;	
		}

		setContentPane(panel(c,w,u ));
        repaint();
        revalidate();
	}
	public JPanel panel(int c,int w,int u) {

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 444, 271);
        panel.setBackground(new Color(255, 255, 255));
        getContentPane().add(panel);
        panel.setSize(screenSize.width, screenSize.height);
        panel.setLayout(null);
        
        JLabel correct = new JLabel();
        correct.setHorizontalAlignment(SwingConstants.CENTER);
        correct.setVerticalAlignment(SwingConstants.TOP);
        correct.setFont(new Font("Segoe UI", Font.PLAIN, 45));
        correct.setBounds(0, 300, 1920, 97);
        correct.setText("Correct : "+c);
        panel.add(correct);
        
        JLabel wrong = new JLabel();
        wrong.setVerticalAlignment(SwingConstants.TOP);
        wrong.setHorizontalAlignment(SwingConstants.CENTER);
        wrong.setFont(new Font("Segoe UI", Font.PLAIN, 45));
        wrong.setBounds(0, 422, 1920, 97);
        wrong.setText("Wrong : "+w);
        panel.add(wrong);
        
        JLabel unanswered = new JLabel();
        unanswered.setVerticalAlignment(SwingConstants.TOP);
        unanswered.setHorizontalAlignment(SwingConstants.CENTER);
        unanswered.setFont(new Font("Segoe UI", Font.PLAIN, 45));
        unanswered.setBounds(0, 532, 1920, 97);
        unanswered.setText("Unanswered : "+u);
        panel.add(unanswered);
        
        JButton btnNewButton = new JButton("Exit");
        btnNewButton.setBackground(new Color(255, 140, 0));
        btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 45));
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		HomePage.this.dispose();
        	}
        });
        btnNewButton.setBounds((screenSize.width/2)-150, 666, 300, 100);
        panel.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("Thank You !!");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Script MT Bold", Font.PLAIN, 85));
        lblNewLabel_1.setBounds(658, 13, 618, 274);
        panel.add(lblNewLabel_1);

        return panel;

    }
}
