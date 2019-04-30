package LP;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class frInicioSesion extends JFrame implements ActionListener
{

	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	

	/**
	 * Create the application.
	 */
	public frInicioSesion() 
	{
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(15, 66, 69, 20);
		contentPane.add(lblCorreo);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(15, 126, 85, 20);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(117, 63, 292, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 123, 294, 26);
		contentPane.add(passwordField);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(294, 181, 115, 29);
		contentPane.add(btnEnter);
		btnEnter.addActionListener(this);
		btnEnter.setActionCommand("Enter");
		
		JLabel lblPasswordIncorrecta = new JLabel("Usuario y/o contrase\u00F1a incorrectas");
		lblPasswordIncorrecta.setBounds(117, 155, 292, 20);
		contentPane.add(lblPasswordIncorrecta);
		lblPasswordIncorrecta.setVisible(false);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
	}
}
