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

public class frResultadosBusqueda extends JFrame implements ActionListener, ListSelectionListener {

	private JPanel contentPane;
	private LinkedList<VueloDTO> vuelosIda, vuelosVuelta;
	private DefaultListModel<VueloDTO> listModel;
	private JList listaIda;	
	private JList listaVuelta;
	private EBController controller;
	private Usuario usuario;
	private JTextField textField;
	private JTextField txtXvsd;
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
		
		JLabel lblVuelosIda = new JLabel("VUELOS IDA");
		lblVuelosIda.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblVuelosIda.setBounds(324, 16, 134, 20);
		contentPane.add(lblVuelosIda);
		
		listModel = new DefaultListModel<VueloDTO>();
		
		vuelosIda = listaVuelosIda;
		
		for (VueloDTO a: vuelosIda)
		{
			listModel.addElement(a);
		}
		
		listaIda = new JList(listModel);
		listaIda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaIda.addListSelectionListener(this);
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
	
	public void valueChanged(ListSelectionEvent arg0) 
	{
		if (arg0.getValueIsAdjusting() == false)
		{
			if (listaIda.getSelectedIndex()==-1)
			{
//				btnModificar.setEnabled(false);
			}
			else
			{
//				btnModificar.setEnabled(true);
			}
		}
	}
}
