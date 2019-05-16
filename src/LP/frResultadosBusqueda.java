package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LN.Vuelo;
import LN.VueloController;
//import LN.itfProperty;

public class frResultadosBusqueda extends JFrame {

	private JPanel contentPane;
	private ArrayList<Vuelo> vuelosIda, vuelosVuelta;
	private DefaultListModel<Vuelo> listModel;
	private JList listaIda;	
	private JList listaVuelta;
	


	public frResultadosBusqueda(ArrayList<Vuelo> listaVuelosIda, ArrayList<Vuelo> listaVuelosVuelta) {
		// TODO Auto-generated constructor stub
		vuelosIda = listaVuelosIda;
		vuelosVuelta = listaVuelosVuelta;
		
	}

	public frResultadosBusqueda() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frResultadosBusqueda frame = new frResultadosBusqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void frResultadosBusqueda() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
	}


}
