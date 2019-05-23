package LP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.EBController;
import DTO.VueloDTO;
import LN.Usuario;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class frVisa extends JFrame implements ActionListener
{

	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtNumTarjeta;
	private JTextField txtFechCaducMes;
	private JTextField txtFechCaducAno;
	private JTextField txtCvv;
	private EBController controller;
	private Usuario usuario;
	private VueloDTO vuelo;
	private int codPago;

	/**
	 * Create the application.
	 */
	public frVisa(EBController controller, Usuario usuario, VueloDTO vuelo) 
	{
		this.controller=controller;
		this.usuario=usuario;
		this.vuelo=vuelo;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(15, 27, 69, 20);
		contentPane.add(lblNombre);
		
		JLabel lblNumTarjeta = new JLabel("N\u00BA Tarjeta:");
		lblNumTarjeta.setBounds(15, 73, 89, 20);
		contentPane.add(lblNumTarjeta);
		
		JLabel lblFechaCaducidad = new JLabel("Fecha caducidad:");
		lblFechaCaducidad.setBounds(15, 123, 129, 20);
		contentPane.add(lblFechaCaducidad);
		
		JLabel lblCvv = new JLabel("CVV:");
		lblCvv.setBounds(15, 176, 69, 20);
		contentPane.add(lblCvv);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(145, 24, 282, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtNumTarjeta = new JTextField();
		txtNumTarjeta.setBounds(145, 73, 282, 26);
		contentPane.add(txtNumTarjeta);
		txtNumTarjeta.setColumns(10);
		
		txtFechCaducMes = new JTextField();
		txtFechCaducMes.setBounds(145, 120, 89, 26);
		contentPane.add(txtFechCaducMes);
		txtFechCaducMes.setColumns(10);
		
		JLabel lblBarra = new JLabel("/");
		lblBarra.setBounds(243, 123, 19, 20);
		contentPane.add(lblBarra);
		
		txtFechCaducAno = new JTextField();
		txtFechCaducAno.setBounds(262, 120, 82, 26);
		contentPane.add(txtFechCaducAno);
		txtFechCaducAno.setColumns(10);
		
		txtCvv = new JTextField();
		txtCvv.setBounds(145, 173, 89, 26);
		contentPane.add(txtCvv);
		txtCvv.setColumns(10);
		
		JLabel lblAyudaCvv = new JLabel("New label");
		lblAyudaCvv.setToolTipText("Los 3 ultimos digitos de la parte trasera de la tarjeta");
		lblAyudaCvv.setBounds(253, 168, 33, 37);
		contentPane.add(lblAyudaCvv);
		Image imgCvv= new ImageIcon("image/CVV.png").getImage();
		ImageIcon imgCvv2=new ImageIcon(imgCvv.getScaledInstance(33, 37, Image.SCALE_SMOOTH));
		lblAyudaCvv.setIcon(imgCvv2);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBounds(312, 218, 115, 29);
		contentPane.add(btnPagar);
		btnPagar.addActionListener(this);
		btnPagar.setActionCommand("Pagar");
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(15, 231, 69, 29);
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
				String nombre=txtNombre.getText();
				int numTarj=Integer.valueOf(txtNumTarjeta.getText());
				int mes=Integer.valueOf(txtFechCaducMes.getText());
				int ano=Integer.valueOf(txtFechCaducAno.getText());
				int cvv= Integer.valueOf(txtCvv.getText());
				
				String user = txtNumTarjeta.getText();
				String password= mes + "#" + ano + "#" + cvv;
				String sistema_pago =  usuario.getPago();
				double precio = vuelo.getPrecio();
				
				codPago= controller.pagar(user, password, precio, sistema_pago);
				if (codPago==0)
				{
					
					JOptionPane.showMessageDialog(this, "Los datos introducidos no son los correctos");
				}
				else
				{
					controller.reservar(vuelo.getNumero(), codPago);
					frBusqueda ventana =new frBusqueda(controller, usuario);
					ventana.setVisible(true);
					this.dispose();
					JOptionPane.showConfirmDialog(this, "Se ha realizado el pago correctamente");
				}
				
				break;
				
			case "Atras":
				frBusqueda busq =new frBusqueda(controller, usuario);
				busq.setVisible(true);
				this.dispose();
				
				break;
			
		}
		
	}
}
