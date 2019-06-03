package LP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.EBController;
import DTO.VueloDTO;
import LN.Usuario;


//import COMUN.clsActividadRepetida;
//import LN.clsGestor;

import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class frBusqueda extends JFrame implements ChangeListener, ActionListener{

	private JRadioButton SelectorIda,SelectorIdaVuelta;
	private ButtonGroup bg;
	private JPanel contentPane;
	private JTextField FechaIda;
	private JTextField FechaVuelta;
	private JLabel IdaFecha;
	private JLabel VueltaFecha;
	private JButton Buscar;
	private JComboBox<String> AerOrigen, AerDestino;
	private JLabel ADestino, AOrigen;
	private String Origen, Destino, fechaS, fechaL;
	private boolean ida, vuelta;
	private LinkedList<VueloDTO> listaVuelosIda;
	private LinkedList<VueloDTO> listaVuelosVuelta;
	private EBController controller;
	private Usuario usuario;
	
	

	/**
	 * Create the frame.
	 */
	public frBusqueda(EBController controller, Usuario usuario) {
		this.controller = controller;
		this.usuario = usuario;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bg=new ButtonGroup();
		
		SelectorIda = new JRadioButton("Ida");
		SelectorIda.setFont(new Font("Tahoma", Font.PLAIN, 22));
		SelectorIda.setBounds(330, 12, 65, 29);
		SelectorIda.addChangeListener(this);
		getContentPane().add(SelectorIda);
		bg.add(SelectorIda);
		
		SelectorIdaVuelta = new JRadioButton("Ida y Vuelta");
		SelectorIdaVuelta.setFont(new Font("Tahoma", Font.PLAIN, 22));
		SelectorIdaVuelta.setBounds(515, 12, 186, 29);
		SelectorIdaVuelta.addChangeListener(this);
		getContentPane().add(SelectorIdaVuelta);
		bg.add(SelectorIdaVuelta);
		
		AOrigen = new JLabel("AEROPUERTO ORIGEN");
		AOrigen.setFont(new Font("Tahoma", Font.PLAIN, 22));
		AOrigen.setBounds(30, 113, 223, 20);
		contentPane.add(AOrigen);
		
		ADestino = new JLabel("AEROPUERTO DESTINO");
		ADestino.setFont(new Font("Tahoma", Font.PLAIN, 22));
		ADestino.setBounds(30, 201, 236, 20);
		contentPane.add(ADestino);
		
		FechaIda = new JTextField();
		FechaIda.setFont(new Font("Tahoma", Font.PLAIN, 22));
		FechaIda.setBounds(702, 102, 177, 43);
		contentPane.add(FechaIda);
		FechaIda.setColumns(10);
		
		FechaVuelta = new JTextField();
		FechaVuelta.setFont(new Font("Tahoma", Font.PLAIN, 22));
		FechaVuelta.setBounds(702, 190, 177, 43);
		contentPane.add(FechaVuelta);
		FechaVuelta.setColumns(10);
		
		IdaFecha = new JLabel("FECHA IDA");
		IdaFecha.setFont(new Font("Tahoma", Font.PLAIN, 22));
		IdaFecha.setBounds(542, 102, 127, 43);
		contentPane.add(IdaFecha);
		
		VueltaFecha = new JLabel("FECHA VUELTA");
		VueltaFecha.setFont(new Font("Tahoma", Font.PLAIN, 22));
		VueltaFecha.setBounds(542, 190, 159, 43);
		contentPane.add(VueltaFecha);
		
		Buscar = new JButton("BUSCAR");
		Buscar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Buscar.setBounds(400, 271, 135, 48);
		contentPane.add(Buscar);
		Buscar.addActionListener(this);
		
		AerOrigen = new JComboBox<String>();
		AerOrigen.setFont(new Font("Tahoma", Font.PLAIN, 22));
		AerOrigen.setBounds(281, 102, 246, 41);
		contentPane.add(AerOrigen);
		AerOrigen.addItem("New York");
		AerOrigen.addItem("Madrid");
		AerOrigen.addItem("Roma");
		
		
		AerDestino = new JComboBox<String>();
		AerDestino.setFont(new Font("Tahoma", Font.PLAIN, 22));
		AerDestino.setBounds(281, 190, 246, 41);
		contentPane.add(AerDestino);
		AerDestino.addItem("Paris");
		AerDestino.addItem("Bilbao");
		AerDestino.addItem("Bruselas");
		
		
		
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
		if (SelectorIda.isSelected()) 
		{
			FechaVuelta.hide();
			VueltaFecha.hide();
        }
		if (SelectorIdaVuelta.isSelected()) 
		{
			FechaVuelta.show();
			VueltaFecha.show();
        }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand())
		{
			case "BUSCAR":
				try
				{
					System.out.println("hola");
					vuelta = true;
					fechaL = null;
//					listaVuelosVuelta = null;
					fechaS = FechaIda.getText();
					ida = validarFecha(fechaS);
					Origen = (String) AerOrigen.getSelectedItem();
					Destino = (String) AerDestino.getSelectedItem();
					listaVuelosIda = controller.getVuelos(Origen, Destino, fechaS, null);

					
					if (SelectorIdaVuelta.isSelected()) 
					{
						fechaL = FechaVuelta.getText();
						vuelta = validarFecha(fechaL);
						listaVuelosVuelta = controller.getVuelos(Destino, Origen, fechaL, null);

			        }
					
					if (vuelta == true && ida == true)
					{
						JOptionPane.showMessageDialog(this, "¡BÚSQUEDA REALIZADA!");
						frResultadosBusqueda ventana = new frResultadosBusqueda(listaVuelosIda, listaVuelosVuelta, controller, usuario);
						ventana.setVisible(true);
						dispose();
					}
					else
						JOptionPane.showMessageDialog(this, "¡FECHA INCORRECTA!");
				}
//				catch (clsActividadRepetida a)
//				{
//					JOptionPane.showMessageDialog(this, a.getMessage());
//				}
				catch (Exception b)
				{
//					System.out.println(b.toString());
					JOptionPane.showMessageDialog(this, "Error en la introducción de algún dato");
				}
				break;
		
	}
	}
	public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

}
