package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LinkedList<VueloDTO> vuelosIda, vuelosVuelta;
	private DefaultListModel listModel;
	private JList list;
	private JButton btnPago ;
	private JLabel lblSelect;
	private VueloDTO vueloSelect;
	private JScrollPane scrollLista;
	private EBController controller;
	private Usuario usuario;

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
		
		
		btnPago = new JButton("PAGAR");
		btnPago.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnPago.setBounds(341, 342, 115, 29);
		contentPane.add(btnPago);
		btnPago.setVisible(false);
		
		lblSelect = new JLabel("SELECCIONA UN VUELO");
		lblSelect.setBounds(310, 320, 193, 20);
		contentPane.add(lblSelect);
		lblSelect.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 52, 808, 235);
		contentPane.add(panel);
		
		listModel = new DefaultListModel();
		vuelosIda = listaVuelosIda;
		vuelosVuelta = listaVuelosVuelta;
		
		for (VueloDTO a: vuelosVuelta)
	    {
	    	vuelosIda.add(a);
	    }
		for (VueloDTO a: vuelosIda)
		{
			listModel.addElement(a.toString());
		}
		
		
		
		list = new JList(listModel);
//		list.setBounds(383, 101, 1, 1);
//		contentPane.add(list);
		scrollLista = new JScrollPane(list);
		panel.add(scrollLista);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	switch (e.getActionCommand())
	{
		case "PAGAR":
			vueloSelect = (VueloDTO) list.getSelectedValue();
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
				btnPago.setVisible(false);
				lblSelect.setVisible(true);
			}
			else
			{
				btnPago.setVisible(true);
				lblSelect.setVisible(false);
			}
		}
	}
}
