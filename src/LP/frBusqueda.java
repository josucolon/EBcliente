package LP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class frBusqueda extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton SelectorIda = new JRadioButton("Ida");
		SelectorIda.setBounds(69, 12, 65, 29);
		contentPane.add(SelectorIda);
		
		JRadioButton SelectorIdaVuelta = new JRadioButton("Ida y Vuelta");
		SelectorIdaVuelta.setBounds(232, 12, 155, 29);
		contentPane.add(SelectorIdaVuelta);
	}
}
