package bankingApplication;

import javax.swing.JPanel;

import bankingApplication.agent.Agent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bankingApplication.client.Client;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modifyClientForm extends JPanel {
	private JTextField emailField;
	private JPasswordField passwordField;
	private JTextField idField;

	/**
	 * Create the panel.
	 */
	public modifyClientForm(Agent agent) {
		setLayout(null);
		setBounds(100, 100, 517, 460);
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 504, 446);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblEmail = new JLabel("New Email :");
		lblEmail.setFont(new Font("Courier New", Font.BOLD, 17));
		lblEmail.setBounds(10, 183, 135, 13);
		panel.add(lblEmail);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Courier New", Font.PLAIN, 20));
		emailField.setColumns(10);
		emailField.setBounds(158, 177, 212, 22);
		panel.add(emailField);
		
		JLabel lblPassword = new JLabel("New Password :");
		lblPassword.setFont(new Font("Courier New", Font.BOLD, 17));
		lblPassword.setBounds(10, 228, 146, 13);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Courier New", Font.PLAIN, 20));
		passwordField.setBounds(158, 225, 212, 22);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Modify Client");
		btnNewButton.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnNewButton.setBounds(206, 280, 164, 29);
		panel.add(btnNewButton);
		
		idField = new JTextField();
		idField.setFont(new Font("Courier New", Font.PLAIN, 20));
		idField.setColumns(10);
		idField.setBounds(158, 132, 212, 22);
		panel.add(idField);
		
		JLabel lblClientId = new JLabel("client ID:");
		lblClientId.setFont(new Font("Courier New", Font.BOLD, 17));
		lblClientId.setBounds(10, 138, 135, 13);
		panel.add(lblClientId);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Client newClient = agent.getClient(Integer.parseInt(idField.getText()));
					newClient.setEmail(emailField.getText());
					newClient.setPassword(passwordField.getText());
					agent.modifyClient(newClient);
		            JOptionPane.showMessageDialog(null, "Client details has been changed.");
		            idField.setText("");
		            emailField.setText("");
		            passwordField.setText("");

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
