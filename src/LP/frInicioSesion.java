package LP;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.EBController;
import LN.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class frInicioSesion extends JFrame implements ActionListener
{

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtCorreo;
	private JPasswordField passwordField;
	
	private String correo;
	private String password;
	private JLabel lblPasswordIncorrecta;
	private EBController controller;
	private Usuario usuario;
	private String FoG;

	/**
	 * Create the application.
	 */
	public frInicioSesion(EBController controller, String GoF) 
	{
		this.controller = controller;
		FoG=GoF;
		
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
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(117, 63, 292, 26);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(115, 123, 294, 26);
		contentPane.add(passwordField);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(294, 181, 115, 29);
		contentPane.add(btnEnter);
		btnEnter.addActionListener(this);
		btnEnter.setActionCommand("Enter");
		
		lblPasswordIncorrecta = new JLabel("Usuario y/o contrase\u00F1a incorrectas");
		lblPasswordIncorrecta.setForeground(Color.RED);
		lblPasswordIncorrecta.setBounds(117, 155, 292, 20);
		contentPane.add(lblPasswordIncorrecta);
		lblPasswordIncorrecta.setVisible(false);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(15, 191, 69, 29);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand("Atras");
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand())
		{
			case "Enter":
				correo= txtCorreo.getText();
				password= passwordField.getText();
				
				if(FoG == "GOOGLE")
				{
					try 
					{
						usuario = controller.InicioSesionG(correo, password);
						lblPasswordIncorrecta.setForeground(Color.green);
						lblPasswordIncorrecta.setVisible(true);
						
						frBusqueda busqueda =new frBusqueda(controller, usuario);
						busqueda.setVisible(true);
						this.dispose();
					} 
					catch (RemoteException e1) 
					{
						lblPasswordIncorrecta.setVisible(true);
						lblPasswordIncorrecta.setForeground(Color.red);
						e1.printStackTrace();
					}
				}
				
				if(FoG == "FACEBOOK")
				{
					try 
					{
						usuario = controller.InicioSesionF(correo, password);
						lblPasswordIncorrecta.setForeground(Color.green);
						lblPasswordIncorrecta.setVisible(true);
						
						frBusqueda busqueda =new frBusqueda(controller, usuario);
						busqueda.setVisible(true);
						this.dispose();
					} 
					catch (RemoteException e1) 
					{
						lblPasswordIncorrecta.setVisible(true);
						lblPasswordIncorrecta.setForeground(Color.red);
						e1.printStackTrace();
					}
				}
				
			
				
				break;
				
			case "Atras":
				frPrincipal ventana =new frPrincipal(controller);
				ventana.setVisible(true);
				this.dispose();
				
				break;
			
		}
		
		
	}
}
