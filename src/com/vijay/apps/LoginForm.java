package com.vijay.apps;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JPanel panel;
	private JLabel loginBtn;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() throws NullPointerException {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(SystemColor.textHighlight, 2, true));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(135, 206, 250));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel closeBtn = new JLabel("X");
		closeBtn.setHorizontalAlignment(SwingConstants.CENTER);
		closeBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		closeBtn.setForeground(new Color(255, 255, 255));
		closeBtn.setBounds(398, 13, 40, 40);
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				LoginForm.this.dispose();
			}
			public void mouseEntered(MouseEvent arg0) {
				closeBtn.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent arg0) {
				closeBtn.setForeground(Color.WHITE);
			}
		});
		contentPane.add(closeBtn);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(LoginForm.class.getResource("/res/user-male.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		lblNewLabel_1.setBounds(130, 96, 200, 200);
		contentPane.add(lblNewLabel_1);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(30, 144, 255), 2, true));
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(130, 441, 200, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		loginBtn = new JLabel("Login");
		loginBtn.setForeground(new Color(255, 255, 255));
		loginBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		loginBtn.setHorizontalAlignment(SwingConstants.CENTER);
		loginBtn.setBounds(0, 0, 200, 40);
		loginBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(txtUsername.getText().equals("admin") && pwdPassword.getText().equals("admin")) {
					message.setText("Login successful");
					HomePage hm=new HomePage();
				hm.setVisible(true);
					LoginForm.this.dispose();
					
				}else {
					message.setText("Login failed");
				}
			}
			public void mouseEntered(MouseEvent arg0) {
						}
			public void mouseExited(MouseEvent arg0) {
				
			}
		});
		panel.add(loginBtn);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(30, 144, 255), 2, true));
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(130, 323, 200, 40);
		contentPane.add(panel_1);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setBounds(1, 1, 198, 38);
		panel_1.add(txtUsername);
		txtUsername.setText("Username");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setColumns(10);
		txtUsername.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				message.setText("");

				if(txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
				}else {
					txtUsername.selectAll();
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("")) {
					txtUsername.setText("Username");
				}
			}
		});
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(30, 144, 255), 2, true));
		panel_2.setBackground(SystemColor.textHighlight);
		panel_2.setBounds(130, 376, 200, 40);
		contentPane.add(panel_2);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBorder(null);
		pwdPassword.setBounds(1, 1, 198, 38);
		panel_2.add(pwdPassword);
		pwdPassword.setHorizontalAlignment(SwingConstants.CENTER);
		pwdPassword.setText("Password");
		pwdPassword.setEchoChar((char)0);
		
		message = new JLabel("");
		message.setForeground(new Color(255, 0, 0));
		message.setBounds(130, 416, 200, 16);
		contentPane.add(message);
		pwdPassword.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				message.setText("");

				if(pwdPassword.getText().equals("Password")) {
					pwdPassword.setEchoChar('●');
					pwdPassword.setText("");
				}else {
					pwdPassword.selectAll();
				}	
				
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdPassword.getText().equals("")) {
					pwdPassword.setText("Password");
					pwdPassword.setEchoChar((char)0);
					
				}
			}
		});
		setUndecorated(true);
	setLocationRelativeTo(null);
	}
}
