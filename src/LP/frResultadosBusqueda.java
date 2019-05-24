package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.EBController;
import DTO.VueloDTO;
import LN.Usuario;

//import LN.clsGestor;
//import LN.itfProperty;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import LN.itfProperty;
import java.io.IOException;
import javax.swing.JButton;

public class frResultadosBusqueda extends JFrame implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LinkedList<VueloDTO> vuelosIda, vuelosVuelta;
	private DefaultListModel<VueloDTO> listModel;
	private JList listaVuelos;	
	private JList<VueloDTO> list = new JList<VueloDTO>();
	private EBController controller;
	private Usuario usuario;
	private JButton btnPago ;
	private JLabel lblSelect;
	private VueloDTO vueloSelect;
//	public frResultadosBusqueda(ArrayList<Vuelo> listaVuelosIda, ArrayList<Vuelo> listaVuelosVuelta) {
//		// TODO Auto-generated constructor stub
//		vuelosIda = listaVuelosIda;
//		vuelosVuelta = listaVuelosVuelta;
//		
//	}
//
//	public frResultadosBusqueda() {
//		// TODO Auto-generated constructor stub
//	}

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frResultadosBusqueda frame = new frResultadosBusqueda();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	

	

	/**
	 * Create the frame.
	 */
	public frResultadosBusqueda(LinkedList<VueloDTO> listaVuelosIda, LinkedList<VueloDTO> listaVuelosVuelta, EBController controller, Usuario usuario) throws IOException {
		this.controller = controller;
		this.usuario = usuario;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVuelosIda = new JLabel("VUELOS");
		lblVuelosIda.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblVuelosIda.setBounds(352, 16, 134, 20);
		contentPane.add(lblVuelosIda);
		
		
		list.setBounds(383, 101, 1, 1);
		contentPane.add(list);
		
		btnPago = new JButton("PAGAR");
		btnPago.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnPago.setBounds(352, 303, 115, 29);
		contentPane.add(btnPago);
		
		lblSelect = new JLabel("SELECCIONA UN VUELO");
		lblSelect.setBounds(309, 310, 193, 20);
		contentPane.add(lblSelect);
		
		listModel = new DefaultListModel<VueloDTO>();
		
		vuelosIda = listaVuelosIda;
		vuelosVuelta = listaVuelosVuelta;
		
		for (VueloDTO a: vuelosIda)
		{
			listModel.addElement(a);
		}
		
		for (VueloDTO a: vuelosVuelta)
		{
			listModel.addElement(a);
		}
		
		list = new JList<VueloDTO>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	switch (e.getActionCommand())
	{
		case "PAGAR":
			vueloSelect = list.getSelectedValue();
			if (usuario.getPago() == "VISA")
			{
				frVisa ventana = new frVisa(this.controller, this.usuario, vueloSelect);
				ventana.setVisible(true);
				dispose();
			}
			if (usuario.getPago() == "PAYPAL")
			{
				frPayPal ventana = new frPayPal(this.controller, this.usuario, vueloSelect);
				ventana.setVisible(true);
				dispose();
			}
			break;
	}
	
}
	
	public void valueChanged(ListSelectionEvent arg0) 
	{
		if (arg0.getValueIsAdjusting() == false)
		{
			if (list.getSelectedIndex()==-1)
			{
				btnPago.setEnabled(false);
				lblSelect.setEnabled(true);
			}
			else
			{
				btnPago.setEnabled(true);
				lblSelect.setEnabled(false);
			}
		}
	}
}
