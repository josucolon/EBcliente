package LP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.EBController;
import LN.Usuario;
import LN.Vuelo;

public class frPayPal extends JFrame implements ActionListener
{

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JLabel lblPasswordIncorrecta;
	private String usu;
	private String password;
	private JButton btnAtras;
	private EBController controller;
	private Usuario usuario; 
	private Vuelo vuelo;
	private boolean aceptado;
	/**
	 * Create the application.
	 */
	public frPayPal(EBController controller,Usuario usuario, Vuelo vuelo) 
	{
		this.controller=controller;
		this.usuario=usuario;
		this.vuelo=vuelo;
		
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
				
				usu= txtUsuario.getText();
				password= passwordField.getText();
				double precio= 1;
				String sistema_pago= usuario.getPago();
	
				aceptado= controller.pagar(usu, password, precio, sistema_pago);
				if (aceptado==true)
				{
					lblPasswordIncorrecta.setForeground(Color.green);
					lblPasswordIncorrecta.setVisible(true);
					frBusqueda ventana =new frBusqueda(controller, usuario);
					ventana.setVisible(true);
					this.dispose();
					JOptionPane.showConfirmDialog(this, "Se ha realizado el pago correctamente");
				}
				else
				{
					lblPasswordIncorrecta.setForeground(Color.red);
					lblPasswordIncorrecta.setVisible(true);
					JOptionPane.showMessageDialog(this, "Los datos introducidos no son los correctos");
				}
			
				break;
				
			case "Atras":
				frBusqueda ventana =new frBusqueda(controller, usuario);
				ventana.setVisible(true);
				this.dispose();
				
				break;
			
		}
		
	}
	
}




