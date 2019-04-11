package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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

import javax.swing.JLabel;
import javax.swing.JButton;

public class frBusqueda extends JFrame implements ChangeListener, ActionListener{

	private JRadioButton SelectorIda,SelectorIdaVuelta;
	private ButtonGroup bg;
	private JPanel contentPane;
	private JTextField Salida;
	private JTextField Llegada;
	private JTextField FechaIda;
	private JTextField FechaVuelta;
	private JLabel IdaFecha;
	private JLabel VueltaFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frBusqueda frame = new frBusqueda();
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
	public frBusqueda() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
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
		
		Salida = new JTextField();
		Salida.setToolTipText("Origen");
		Salida.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Salida.setBounds(281, 102, 246, 43);
		contentPane.add(Salida);
		Salida.setColumns(10);
		
		
		Llegada= new JTextField();
		Llegada.setToolTipText("Destino");
		Llegada.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Llegada.setBounds(281, 190, 246, 43);
		contentPane.add(Llegada);
		Llegada.setColumns(10);
		
		JLabel AOrigen = new JLabel("AEROPUERTO ORIGEN");
		AOrigen.setFont(new Font("Tahoma", Font.PLAIN, 22));
		AOrigen.setBounds(30, 113, 223, 20);
		contentPane.add(AOrigen);
		
		JLabel ADestino = new JLabel("AEROPUERTO DESTINO");
		ADestino.setFont(new Font("Tahoma", Font.PLAIN, 22));
		ADestino.setBounds(30, 201, 236, 20);
		contentPane.add(ADestino);
		
		FechaIda = new JTextField();
		FechaIda.setBounds(702, 102, 177, 43);
		contentPane.add(FechaIda);
		FechaIda.setColumns(10);
		
		FechaVuelta = new JTextField();
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
		
		JButton Buscar = new JButton("BUSCAR");
		Buscar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Buscar.setBounds(400, 271, 135, 48);
		contentPane.add(Buscar);
		Buscar.addActionListener(this);
		
		
		
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
		
	}
}
