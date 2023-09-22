package tiendaceramicos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Tienda extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar mnBarTienda;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConsultarCeramico;
	private JMenuItem mntmModificarCeramico;
	private JMenuItem mntmListarCeramico;
	private JMenu mnVentas;
	private JMenuItem mntmVentas;
	private JMenuItem mntmGenerarReporte;
	private JMenu mnConfiguracion;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmConfigurarCantidadOptima;
	private JMenuItem mntmConfigurarCuotaDiaria;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaTienda;
	
	
	// Datos mínimos del primer producto
	public static String modelo0 = "Cinza Plus";
	public static double precio0 = 92.56;
	public static double ancho0 = 62.0;
	public static double largo0 = 62.0;
	public static double espesor0 = 8;
	public static int contenido0 = 6;
	// Datos mínimos del segundo producto
	public static String modelo1 = "Luxury";
	public static double precio1 = 42.77;
	public static double ancho1 = 60;
	public static double largo1 = 60;
	public static double espesor1 = 8.5;
	public static int contenido1 = 4;
	// Datos mínimos del tercer producto
	public static String modelo2 = "Austria";
	public static double precio2 = 52.45;
	public static double ancho2 = 45;
	public static double largo2 = 45;
	public static double espesor2 = 6.5;
	public static int contenido2 = 12;
	// Datos mínimos del cuarto producto
	public static String modelo3 = "Yungay Mix";
	public static double precio3 = 55.89;
	public static double ancho3 = 80;
	public static double largo3 = 120;
	public static double espesor3 = 6.8;
	public static int contenido3 = 9;
	// Datos mínimos del quinto producto
	public static String modelo4 = "Thalía";
	public static double precio4 = 45;
	public static double ancho4 = 45;
	public static double largo4 = 11.8;
	public static double espesor4 = 7.2;
	public static int contenido4 = 10;
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	// Obsequio
	public static String tipoObsequio = "Lapicero";
	public static int obsequioCantidad1 = 2;
	public static int obsequioCantidad2 = 3;
	public static int obsequioCantidad3 = 4;
	// Cantidad óptima de unidades vendidas por día
	public static int cantidadOptima = 10;
	// Cuota diaria
	public static double cuotaDiaria = 30000;
	// Contador ventas
	public static int contador=0;
	/*Datos mínimos para generar reportes*/
	public static int cantidadUnidadesVendidas0=0, cantidadVentas0;
	public static int cantidadUnidadesVendidas1=0, cantidadVentas1;
	public static int cantidadUnidadesVendidas2=0, cantidadVentas2;
	public static int cantidadUnidadesVendidas3=0, cantidadVentas3;
	public static int cantidadUnidadesVendidas4=0, cantidadVentas4;
	public static double importeTotal0=0;
	public static double importeTotal1=0;
	public static double importeTotal2=0;
	public static double importeTotal3=0;
	public static double importeTotal4=0;
	//Datos mínimos para generar el Jdialog en Vender
	public static double importeAcumulado=0;
	public static double porcentajeCuota;
	public static double porcentajeCuotaAcumulado=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
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
	public Tienda() {
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 460);
		
		mnBarTienda = new JMenuBar();
		setJMenuBar(mnBarTienda);
		
		mnArchivo = new JMenu("Archivo");
		mnBarTienda.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnBarTienda.add(mnMantenimiento);
		
		mntmConsultarCeramico = new JMenuItem("Consultar ceramico");
		mntmConsultarCeramico.addActionListener(this);
		mnMantenimiento.add(mntmConsultarCeramico);
		
		mntmModificarCeramico = new JMenuItem("Modificar ceramico");
		mntmModificarCeramico.addActionListener(this);
		mnMantenimiento.add(mntmModificarCeramico);
		
		mntmListarCeramico = new JMenuItem("Listar ceramico");
		mntmListarCeramico.addActionListener(this);
		mnMantenimiento.add(mntmListarCeramico);
		
		mnVentas = new JMenu("Ventas");
		mnBarTienda.add(mnVentas);
		
		mntmVentas = new JMenuItem("Vender");
		mntmVentas.addActionListener(this);
		mnVentas.add(mntmVentas);
		
		mntmGenerarReporte = new JMenuItem("Generar reporte ");
		mntmGenerarReporte.addActionListener(this);
		mnVentas.add(mntmGenerarReporte);
		
		mnConfiguracion = new JMenu("Configuracion");
		mnBarTienda.add(mnConfiguracion);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mntmConfigurarObsequios.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarObsequios);
		
		mntmConfigurarCantidadOptima = new JMenuItem("Configurar cantidad optima");
		mntmConfigurarCantidadOptima.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCantidadOptima);
		
		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mntmConfigurarCuotaDiaria.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCuotaDiaria);
		
		mnAyuda = new JMenu("Ayuda");
		mnBarTienda.add(mnAyuda);
		
		mntmAcercaTienda = new JMenuItem("Acerca de tienda");
		mntmAcercaTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

	public void  actionPerformed(ActionEvent e) {
		if(e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		if (e.getSource() ==mntmConsultarCeramico) {
			actionPerformedMntmConsultarCeramico(e);
		}
		if (e.getSource() == mntmModificarCeramico) {
			actionPerformedMntmModificarCeramico(e);	
		}
		if (e.getSource() == mntmListarCeramico) {
			actionPerformedMntmListarCeramicos(e);	
		}
		if(e.getSource() == mntmVentas) {
			actionperformedMntmVentas(e);
		}
		if(e.getSource() == mntmGenerarReporte) {
			actionperformedMntmGenerarReporte(e);
		}
		if(e.getSource() == mntmConfigurarDescuentos) {
			actionPerformedMntmConfigurarDescuentos(e);
		}
		if(e.getSource() == mntmConfigurarObsequios) {
			actionPerformedMntmConfigurarObsequios(e);
		}
		if(e.getSource() == mntmConfigurarCantidadOptima) {
			actionPerformedMntmConfigurarCantidadOptima(e);
		}
		if(e.getSource() == mntmConfigurarCuotaDiaria ) {
			actionPerformedMntmConfigurarCuotaDiaria(e);
		}
		if(e.getSource() == mntmAcercaTienda) {
			actionPerformedMntmAcercaTienda(e);
		}
	}

			
	public void actionPerformedMntmAcercaTienda(ActionEvent e) {
		AyudaAcercaTienda Ventana = new AyudaAcercaTienda();
		Ventana.setVisible(true);
	}

	public void actionPerformedMntmConfigurarCuotaDiaria(ActionEvent e) {
		ConfigurarCuotaDiaria Ventana = new ConfigurarCuotaDiaria();
		Ventana.setVisible(true);
	}

	public void actionPerformedMntmConfigurarCantidadOptima(ActionEvent e) {
		ConfigurarCantidadOptima Ventana = new ConfigurarCantidadOptima();
		Ventana.setVisible(true);
	}

	public void actionPerformedMntmConfigurarObsequios(ActionEvent e) {
		ConfigurarObsequios Ventana = new ConfigurarObsequios();
		Ventana.setVisible(true);
	}

	public void actionPerformedMntmConfigurarDescuentos(ActionEvent e) {
		ConfigurarDescuentos Ventana = new ConfigurarDescuentos();
		Ventana.setVisible(true);
	}

	public void actionperformedMntmGenerarReporte(ActionEvent e) {
		VentasGenerarReportes Ventana = new VentasGenerarReportes();
		Ventana.setVisible(true);
	}

	public void actionperformedMntmVentas(ActionEvent e) {
		VentasVender Ventana = new VentasVender();
		Ventana.setVisible(true);
	}

	public void actionPerformedMntmListarCeramicos(ActionEvent e) {
		MantenimientoListarCeramicos Ventana = new MantenimientoListarCeramicos();
		Ventana.setVisible(true);
	}
	
	public void actionPerformedMntmModificarCeramico(ActionEvent e) {
		MantenimientoModificarCeramicos Ventana = new MantenimientoModificarCeramicos();
		Ventana.setVisible(true);
	}
	
	public void actionPerformedMntmConsultarCeramico(ActionEvent e) {
		MantenimientoConsultarCeramicos Ventana = new MantenimientoConsultarCeramicos();
		Ventana.setVisible(true);
	}
	
	public void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
}
