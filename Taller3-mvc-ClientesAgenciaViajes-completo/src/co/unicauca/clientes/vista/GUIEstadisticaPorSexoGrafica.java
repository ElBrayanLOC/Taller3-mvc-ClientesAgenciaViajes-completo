package co.unicauca.clientes.vista;

import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;

import co.unicauca.clientes.modelo.ClientesDB;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUIEstadisticaPorSexoGrafica extends javax.swing.JFrame implements
java.util.Observer{

	private JFrame frame;
	private JTextField txtPromedioHombre;
	private JTextField txtPromedioMujeres;
	private JTextField txtGraficaHombres;
	private JTextField txtGraficaMujeres;

	public GUIEstadisticaPorSexoGrafica(int h, int v) {
		initComponents();
        setSize(247, 415);
        setLocation(h, v);
        setVisible(true);
        //inicializarTabla();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIEstadisticaPorSexoGrafica window = new GUIEstadisticaPorSexoGrafica(100,100);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @return 
	 */
	
	private void initComponents() {
		getContentPane().setLayout(null);
		
		JPanel Hombres = new JPanel();
		Hombres.setBackground(Color.WHITE);
		Hombres.setBounds(10, 39, 100, 300);
		getContentPane().add(Hombres);
		Hombres.setLayout(null);
		
		txtGraficaHombres = new JTextField();
		txtGraficaHombres.setBackground(Color.RED);
		txtGraficaHombres.setHorizontalAlignment(SwingConstants.CENTER);
		txtGraficaHombres.setEnabled(false);
		txtGraficaHombres.setColumns(10);
		txtGraficaHombres.setBounds(10, 300, 80, 0);
		Hombres.add(txtGraficaHombres);
		
		JPanel Mujeres = new JPanel();
		Mujeres.setBackground(Color.WHITE);
		Mujeres.setBounds(121, 39, 100, 300);
		getContentPane().add(Mujeres);
		Mujeres.setLayout(null);
		
		txtGraficaMujeres = new JTextField();
		txtGraficaMujeres.setBounds(10, 300, 80, 0);
		txtGraficaMujeres.setHorizontalAlignment(SwingConstants.CENTER);
		txtGraficaMujeres.setEnabled(false);
		txtGraficaMujeres.setColumns(10);
		txtGraficaMujeres.setBackground(Color.RED);
		Mujeres.add(txtGraficaMujeres);
		
		JTextPane txtpnHombres = new JTextPane();
		txtpnHombres.setEditable(false);
		txtpnHombres.setText("Hombres");
		txtpnHombres.setBounds(10, 345, 100, 20);
		getContentPane().add(txtpnHombres);
		
		JTextPane txtpnMujeres = new JTextPane();
		txtpnMujeres.setText("Mujeres");
		txtpnMujeres.setEditable(false);
		txtpnMujeres.setBounds(121, 345, 100, 20);
		getContentPane().add(txtpnMujeres);
		
		txtPromedioHombre = new JTextField();
		txtPromedioHombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtPromedioHombre.setEnabled(false);
		txtPromedioHombre.setBounds(10, 8, 100, 20);
		getContentPane().add(txtPromedioHombre);
		txtPromedioHombre.setColumns(10);
		
		txtPromedioMujeres = new JTextField();
		txtPromedioMujeres.setHorizontalAlignment(SwingConstants.CENTER);
		txtPromedioMujeres.setEnabled(false);
		txtPromedioMujeres.setColumns(10);
		txtPromedioMujeres.setBounds(121, 8, 100, 20);
		getContentPane().add(txtPromedioMujeres);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void graficar(int h, int m) {
		int promHombres = (h*100)/(h+m);
		int promMujeres = (m*100)/(h+m);
		
		txtPromedioHombre.setText(promHombres+"%");
		txtPromedioMujeres.setText(promMujeres+"%");
	
		txtGraficaHombres.setBounds(10, 300-((300*promHombres)/100), 80, (300*promHombres)/100);
		txtGraficaMujeres.setBounds(10, 300-((300*promMujeres)/100), 80, (300*promMujeres)/100);
	}
	

	@Override
	public void update(Observable obs, Object arg) {
		ClientesDB cliDB = (ClientesDB) obs;
		this.setTitle("Profesión: " + cliDB.getProfesion());
		graficar(cliDB.getTotalHombres(), cliDB.getTotalMujeres());
		
	}
}
