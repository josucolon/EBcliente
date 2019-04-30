package LP;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class frPrincipal extends JFrame implements ActionListener
{
	
	private JPanel contentPane;

	
	public frPrincipal() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblEasybooking = new JLabel("EasyBooking");
		lblEasybooking.setForeground(Color.ORANGE);
		lblEasybooking.setFont(new Font("Brush Script MT", Font.BOLD, 56));
		lblEasybooking.setBounds(97, 27, 292, 56);
		contentPane.add(lblEasybooking);
		
		JButton btnRegistro = new JButton("REGISTRO");
		btnRegistro.setBounds(173, 99, 129, 57);
		contentPane.add(btnRegistro);
		btnRegistro.addActionListener(this);
		btnRegistro.setActionCommand("Registro");
		
		JLabel lblO = new JLabel("O");
		lblO.setBounds(229, 174, 36, 20);
		contentPane.add(lblO);
		
		JLabel lblIniciaSesion = new JLabel("Inicia sesion con:");
		lblIniciaSesion.setBounds(117, 226, 136, 20);
		contentPane.add(lblIniciaSesion);
		
		JButton btnFacebook = new JButton("FaceBook");
		btnFacebook.setBounds(117, 251, 260, 56);
		contentPane.add(btnFacebook);
		btnFacebook.addActionListener(this);
		btnFacebook.setActionCommand("Facebook");
		
		JButton btnGoogle = new JButton("Google");
		btnGoogle.setBounds(117, 332, 260, 62);
		contentPane.add(btnGoogle);
		btnGoogle.addActionListener(this);
		btnGoogle.setActionCommand("Google");
		
		JLabel lblFBimage = new JLabel("New label");
		lblFBimage.setBounds(26, 251, 69, 56);
		contentPane.add(lblFBimage);
		//lblFBimage.setIcon(new ImageIcon("image/Facebook.png"));
		Image imgFB= new ImageIcon("image/Facebook.png").getImage();
		ImageIcon imgFB2=new ImageIcon(imgFB.getScaledInstance(69, 56, Image.SCALE_SMOOTH));
		lblFBimage.setIcon(imgFB2);
		
		JLabel lblGgImage = new JLabel("New label");
		lblGgImage.setBounds(26, 333, 69, 56);
		contentPane.add(lblGgImage);
		Image imgGg= new ImageIcon("image/Google.png").getImage();
		ImageIcon imgGg2=new ImageIcon(imgGg.getScaledInstance(69, 56, Image.SCALE_SMOOTH));
		lblGgImage.setIcon(imgGg2);
	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch (e.getActionCommand())
		{
			case "Registro":
				break;
			case "Facebook":
				frInicioSesion Face =new frInicioSesion();
				Face.setVisible(true);
				break;
			case "Google":
				frInicioSesion Goog =new frInicioSesion();
				Goog.setVisible(true);
				break;
		}
		
	}
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		frPrincipal ventana =new frPrincipal();
		ventana.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
