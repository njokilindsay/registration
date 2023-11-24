package registrationGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Register {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JTextField textFieldConfirm;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 582, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Form");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 23));
		lblNewLabel.setBounds(20, 24, 169, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(104, 90, 62, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(79, 143, 85, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3.setBounds(79, 202, 85, 21);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password :");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_4.setBounds(20, 256, 153, 21);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address :");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5.setBounds(81, 394, 85, 26);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone :");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_6.setBounds(93, 351, 85, 21);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Email :");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_7.setBounds(104, 310, 67, 21);
		frame.getContentPane().add(lblNewLabel_7);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","honeyskin");
					String sql="INSERT INTO REGISTRATION(NAME,USERNAME,PASSWORD,EMAIL,PHONE,ADDRESS) VALUES (?,?,?,?,?,?)";
                    PreparedStatement pr=con.prepareStatement(sql);	
		            pr.setString(1, textFieldName.getText());
		            pr.setString(2, textFieldUsername.getText());
		            
		            pr.setString(3, textFieldPassword.getText());
		            pr.setString(4, textFieldEmail.getText());
		            pr.setString(5, textFieldPhone.getText());
		            pr.setString(6, textFieldAddress.getText());
		            int count=pr.executeUpdate();
		            if(count==1)
		            {
		            	JOptionPane.showMessageDialog(null,"Record added");
		            	con.close();
		            }else {
		            	JOptionPane.showMessageDialog(null,"Record not added");
		            	con.close();
		            }
				}
				catch(Exception v) {
					
				}
			}
		});
		btnSubmit.setFont(new Font("Arial", Font.PLAIN, 13));
		btnSubmit.setBounds(193, 469, 85, 26);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldName.setText("");
		        textFieldUsername.setText("");
		        textFieldPassword.setText("");
		        textFieldConfirm.setText("");
		        textFieldEmail.setText("");
		        textFieldPhone.setText("");
		        textFieldAddress.setText("");
			}
		});
		btnReset.setFont(new Font("Arial", Font.PLAIN, 13));
		btnReset.setBounds(325, 469, 85, 26);
		frame.getContentPane().add(btnReset);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		btnClose.setFont(new Font("Arial", Font.PLAIN, 13));
		btnClose.setBounds(453, 469, 85, 26);
		frame.getContentPane().add(btnClose);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(193, 92, 345, 26);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(193, 138, 345, 26);
		frame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(193, 196, 345, 27);
		frame.getContentPane().add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		textFieldConfirm = new JTextField();
		textFieldConfirm.setBounds(193, 251, 345, 26);
		frame.getContentPane().add(textFieldConfirm);
		textFieldConfirm.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(193, 305, 345, 26);
		frame.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(193, 350, 345, 26);
		frame.getContentPane().add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(193, 396, 345, 26);
		frame.getContentPane().add(textFieldAddress);
		textFieldAddress.setColumns(10);
	}
}
