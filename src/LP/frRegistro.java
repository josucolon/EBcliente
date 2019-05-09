package LP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class frRegistro extends JFrame implements ActionListener
{

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido1;
	private JTextField txtApellido2;
	private JTextField txtDni;
	private JTextField txtCorreo;
	private JPasswordField passwordField;
	private ButtonGroup bgPago;
	private ButtonGroup bgInicioSesion;
	

	/**
	 * Create the application.
	 */
	public frRegistro()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(15, 35, 69, 20);
		contentPane.add(lblNombre);
		
		JLabel lblApellido1 = new JLabel("Apellido 1:");
		lblApellido1.setBounds(15, 71, 87, 20);
		contentPane.add(lblApellido1);
		
		JLabel lblApellido2 = new JLabel("Apellido 2:");
		lblApellido2.setBounds(15, 107, 87, 20);
		contentPane.add(lblApellido2);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(15, 143, 69, 20);
		contentPane.add(lblDni);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(15, 179, 69, 20);
		contentPane.add(lblCorreo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(119, 32, 311, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido1 = new JTextField();
		txtApellido1.setBounds(117, 68, 313, 26);
		contentPane.add(txtApellido1);
		txtApellido1.setColumns(10);
		
		txtApellido2 = new JTextField();
		txtApellido2.setBounds(117, 104, 313, 26);
		contentPane.add(txtApellido2);
		txtApellido2.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(119, 140, 311, 26);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setText("");
		txtCorreo.setBounds(119, 176, 311, 26);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblAeropuertoPorDefecto = new JLabel("Aeropuerto por defecto:");
		lblAeropuertoPorDefecto.setBounds(15, 223, 178, 20);
		contentPane.add(lblAeropuertoPorDefecto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(208, 220, 222, 26);
		contentPane.add(comboBox);
		
		JLabel lblPago = new JLabel("Pago:");
		lblPago.setBounds(15, 277, 47, 20);
		contentPane.add(lblPago);
		
		JRadioButton rdbtnPaypal = new JRadioButton("PayPal");
		rdbtnPaypal.setBounds(119, 273, 107, 29);
		contentPane.add(rdbtnPaypal);
		
		JRadioButton rdbtnVisa = new JRadioButton("Visa");
		rdbtnVisa.setBounds(249, 273, 87, 29);
		contentPane.add(rdbtnVisa);
		
		bgPago = new ButtonGroup();
		bgPago.add(rdbtnVisa);
		bgPago.add(rdbtnPaypal);
		
		JLabel lblInicioSesion = new JLabel("Inicio sesion:");
		lblInicioSesion.setBounds(15, 327, 94, 20);
		contentPane.add(lblInicioSesion);
		
		JRadioButton rdbtnFacebook = new JRadioButton("FaceBook");
		rdbtnFacebook.setBounds(119, 323, 107, 29);
		contentPane.add(rdbtnFacebook);
		
		JRadioButton rdbtnGoogle = new JRadioButton("Google");
		rdbtnGoogle.setBounds(249, 323, 155, 29);
		contentPane.add(rdbtnGoogle);
		
		bgInicioSesion = new ButtonGroup();
		bgInicioSesion.add(rdbtnGoogle);
		bgInicioSesion.add(rdbtnFacebook);
		
		
		JLabel lblContrsena = new JLabel("Contrsena:");
		lblContrsena.setBounds(15, 382, 87, 20);
		contentPane.add(lblContrsena);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(119, 382, 311, 26);
		contentPane.add(passwordField);
		
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(315, 424, 115, 29);
		contentPane.add(btnRegistrarse);
		btnRegistrarse.addActionListener(this);
		btnRegistrarse.setActionCommand("Registro");
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(15, 424, 69, 29);
		contentPane.add(btnAtras);
		btnAtras.addActionListener(this);
		btnAtras.setActionCommand("Atras");
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch (e.getActionCommand())
		{
			case "Registro":
				frVisa ventana =new frVisa();
				ventana.setVisible(true);
				this.dispose();
				break;
				
			case "Atras":
				frPrincipal princ =new frPrincipal();
				princ.setVisible(true);
				this.dispose();
				
				break;
			
		}
		
	}
}
