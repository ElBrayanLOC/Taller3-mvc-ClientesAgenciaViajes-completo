package co.unicauca.clientes.vista;

import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import co.unicauca.clientes.modelo.ClientesDB;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextPane;

public class GUIEstadisticaPorSexo extends javax.swing.JFrame implements Observer{

	private JFrame frame;
	private JTextField txtHombres;
	private JTextField txtMujeres;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIEstadisticaPorSexo window = new GUIEstadisticaPorSexo(100, 100);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public GUIEstadisticaPorSexo(int h, int v) {
        initComponents();
        setSize(228, 107);
        setLocation(h, v);
        setVisible(true);
        //inicializarTabla();
    }
	
	
	public void initComponents() {
		getContentPane().setLayout(null);
		
		txtHombres = new JTextField();
		txtHombres.setBounds(91, 11, 110, 20);
		getContentPane().add(txtHombres);
		txtHombres.setColumns(10);
		
		txtMujeres = new JTextField();
		txtMujeres.setBounds(91, 38, 110, 20);
		getContentPane().add(txtMujeres);
		txtMujeres.setColumns(10);
		
		JTextPane txtpnHombres = new JTextPane();
		txtpnHombres.setEditable(false);
		txtpnHombres.setText("Hombres");
		txtpnHombres.setBounds(10, 11, 71, 20);
		getContentPane().add(txtpnHombres);
		
		JTextPane txtpnMujeres = new JTextPane();
		txtpnMujeres.setEditable(false);
		txtpnMujeres.setText("Mujeres");
		txtpnMujeres.setBounds(10, 38, 71, 20);
		getContentPane().add(txtpnMujeres);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void update(Observable obs, Object arg) {
		ClientesDB cliDB = (ClientesDB)obs;
		txtHombres.setText("" + cliDB.getTotalHombres());
		txtMujeres.setText("" + cliDB.getTotalMujeres());
		this.setTitle("Estadísticas por sexo. Profesión: " + cliDB.getProfesion());
	}
}
