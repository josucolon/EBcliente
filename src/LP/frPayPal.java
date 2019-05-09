package LP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class frPayPal extends JFrame implements ActionListener
{

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JLabel lblPasswordIncorrecta;
	private String usuario;
	private String password;
	private JButton btnAtras;
	/**
	 * Create the application.
	 */
	public frPayPal() 
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(15, 66, 69, 20);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(15, 126, 85, 20);
		contentPane.add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(117, 63, 292, 26);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 123, 294, 26);
		contentPane.add(passwordField);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBounds(294, 181, 115, 29);
		contentPane.add(btnPagar);
		btnPagar.addActionListener(this);
		btnPagar.setActionCommand("Pagar");
		
		lblPasswordIncorrecta = new JLabel("Usuario y/o contrase\u00F1a incorrectas");
		lblPasswordIncorrecta.setForeground(Color.RED);
		lblPasswordIncorrecta.setBounds(117, 155, 292, 20);
		contentPane.add(lblPasswordIncorrecta);
		lblPasswordIncorrecta.setVisible(false);
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(15, 196, 69, 29);
		contentPane.add(btnAtras);	
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand("Atras");
		
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand())
		{
			case "Pagar":
				usuario= txtUsuario.getText();
				password= passwordField.getText();
				
				if(true)//usuario y contraseņa correcta
				{
					lblPasswordIncorrecta.setForeground(Color.green);
					lblPasswordIncorrecta.setVisible(true);
					
					//frBusqueda busqueda =new frBusqueda();
					//busqueda.setVisible(true);
				}
				// usuario y/o contrasena incorrectas
				lblPasswordIncorrecta.setVisible(true);
				break;
				
			case "Atras":
				frBusqueda ventana =new frBusqueda();
				ventana.setVisible(true);
				this.dispose();
				
				break;
			
		}
		
	}
	
}




