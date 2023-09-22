package tiendaceramicos;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentasGenerarReportes extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTipoReporte;
	private JComboBox<String> cmbTipoReporte;
	private JButton btnCerrar;
	private JScrollPane scpResultado;
	private JTextArea txtAreaResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentasGenerarReportes dialog = new VentasGenerarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentasGenerarReportes() {
		setTitle("Generar Reportes");
		setBounds(100, 100, 576, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblTipoReporte = new JLabel("Tipo de reporte");
			lblTipoReporte.setBounds(10, 11, 89, 14);
			contentPanel.add(lblTipoReporte);
			
			cmbTipoReporte = new JComboBox<String>();
			cmbTipoReporte.addActionListener(this);
			cmbTipoReporte.setModel(new DefaultComboBoxModel<String>(new String[] {"Ventas por modelo", "Comparaci\u00F3n de precios con el precio promedio", "Comparaci\u00F3n de cajas vendidas con la cantidad \u00F3ptima", "Estad\u00EDstica sobre el precio"}));
			cmbTipoReporte.setBounds(111, 7, 326, 22);
			contentPanel.add(cmbTipoReporte);
			
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(461, 7, 89, 23);
			contentPanel.add(btnCerrar);
			
			scpResultado = new JScrollPane();
			scpResultado.setBounds(10, 36, 540, 214);
			contentPanel.add(scpResultado);
			
			txtAreaResultado = new JTextArea();
			txtAreaResultado.setFont(new Font("Monospaced",Font.PLAIN,13));
			scpResultado.setViewportView(txtAreaResultado);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cmbTipoReporte) {
			actionPerformedTipoReporte(e);
		}
		if(e.getSource()==btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	public void actionPerformedTipoReporte(ActionEvent e) {
		int indiceCmb;
		double precioPromedio, precioMayor=0, precioMenor=0;
		double diferenciaPrecio0, diferenciaPrecio1, diferenciaPrecio2, diferenciaPrecio3, diferenciaPrecio4;
		double diferenciaVentas0, diferenciaVentas1, diferenciaVentas2, diferenciaVentas3, diferenciaVentas4;
		String comparacionPrecio0, comparacionPrecio1, comparacionPrecio2, comparacionPrecio3, comparacionPrecio4;
		String comparacionVenta0, comparacionVenta1, comparacionVenta2, comparacionVenta3, comparacionVenta4;
		
		indiceCmb = cmbTipoReporte.getSelectedIndex();
		
		precioPromedio = ((double)Math.round(((Tienda.precio0+Tienda.precio1+Tienda.precio2+Tienda.precio3+Tienda.precio4)/4)*100)/100);
		
		diferenciaPrecio0 = Tienda.precio0-precioPromedio;
		diferenciaPrecio1 = Tienda.precio1-precioPromedio;
		diferenciaPrecio2 = Tienda.precio2-precioPromedio;
		diferenciaPrecio3 = Tienda.precio3-precioPromedio;
		diferenciaPrecio4 = Tienda.precio4-precioPromedio;
		
		//Comparación precios
		if (diferenciaPrecio0<0) {//Precio0
			comparacionPrecio0 = ((double)Math.round(Math.abs(diferenciaPrecio0*100)/100)) + " menos que el promedio";
		} else if (diferenciaPrecio0==0) {
			comparacionPrecio0 = " igual que el promedio";
		} else {
			comparacionPrecio0 = ((double)Math.round(Math.abs(diferenciaPrecio0*100)/100)) + " más que el promedio";
		}
		if (diferenciaPrecio1<0) {//Precio1
			comparacionPrecio1 = ((double)Math.round(Math.abs(diferenciaPrecio1*100)/100)) + " menos que el promedio";
		} else if (diferenciaPrecio1==0) {
			comparacionPrecio1 = " igual que el promedio";
		} else {
			comparacionPrecio1 = ((double)Math.round(Math.abs(diferenciaPrecio1*100)/100)) + " más que el promedio";
		}
		if (diferenciaPrecio2<0) {//Precio2
			comparacionPrecio2 = ((double)Math.round(Math.abs(diferenciaPrecio2*100)/100)) + " menos que el promedio";
		} else if (diferenciaPrecio2==0) {
			comparacionPrecio2 = " igual que el promedio";
		} else {
			comparacionPrecio2 = ((double)Math.round(Math.abs(diferenciaPrecio2*100)/100)) + " más que el promedio";
		}
		if (diferenciaPrecio3<0) {//Precio3
			comparacionPrecio3 = ((double)Math.round(Math.abs(diferenciaPrecio3*100)/100)) + " menos que el promedio";
		} else if (diferenciaPrecio3==0) {
			comparacionPrecio3 = " igual que el promedio";
		} else {
			comparacionPrecio3 = ((double)Math.round(Math.abs(diferenciaPrecio3*100)/100)) + " más que el promedio";
		}
		if (diferenciaPrecio4<0) {//Precio4
			comparacionPrecio4 = ((double)Math.round(Math.abs(diferenciaPrecio4*100)/100)) + " menos que el promedio";
		} else if (diferenciaPrecio4==0) {
			comparacionPrecio4 = " igual que el promedio";
		} else {
			comparacionPrecio4 = ((double)Math.round(Math.abs(diferenciaPrecio4*100)/100)) + " más que el promedio";
		}
		
		diferenciaVentas0 = Tienda.cantidadUnidadesVendidas0-Tienda.cantidadOptima;
		diferenciaVentas1 = Tienda.cantidadUnidadesVendidas1-Tienda.cantidadOptima;
		diferenciaVentas2 = Tienda.cantidadUnidadesVendidas2-Tienda.cantidadOptima;
		diferenciaVentas3 = Tienda.cantidadUnidadesVendidas3-Tienda.cantidadOptima;
		diferenciaVentas4 = Tienda.cantidadUnidadesVendidas4-Tienda.cantidadOptima;
		
		//Comparación ventas
		if (diferenciaVentas0<0) {//Ventas0
			comparacionVenta0 = ((double)Math.round(Math.abs(diferenciaVentas0))) + " menos que la cantidad óptima";
		} else if (diferenciaVentas0==0) {
			comparacionVenta0 =  "igual que la cantidad óptima";
		} else {
			comparacionVenta0 = ((double)Math.round(Math.abs(diferenciaVentas0))) + " más que la cantidad óptima";
		}
		if (diferenciaVentas1<0) {//Ventas1
			comparacionVenta1 = ((double)Math.round(Math.abs(diferenciaVentas1))) + " menos que la cantidad óptima";
		} else if (diferenciaVentas1==0) {
			comparacionVenta1 =  "igual que la cantidad óptima";
		} else {
			comparacionVenta1 = ((double)Math.round(Math.abs(diferenciaVentas1))) + " más que la cantidad óptima";
		}
		if (diferenciaVentas2<0) {//Ventas2
			comparacionVenta2 = ((double)Math.round(Math.abs(diferenciaVentas2))) + " menos que la cantidad óptima";
		} else if (diferenciaVentas2==0) {
			comparacionVenta2 =  "igual que la cantidad óptima";
		} else {
			comparacionVenta2 = ((double)Math.round(Math.abs(diferenciaVentas2))) + " más que la cantidad óptima";
		}
		if (diferenciaVentas3<0) {//Ventas3
			comparacionVenta3 = ((double)Math.round(Math.abs(diferenciaVentas3))) + " menos que la cantidad óptima";
		} else if (diferenciaVentas3==0) {
			comparacionVenta3 =  "igual que la cantidad óptima";
		} else {
			comparacionVenta3 = ((double)Math.round(Math.abs(diferenciaVentas4))) + " más que la cantidad óptima";
		}
		if (diferenciaVentas4<0) {//Ventas4
			comparacionVenta4 = ((double)Math.round(Math.abs(diferenciaVentas4))) + " menos que la cantidad óptima";
		} else if (diferenciaVentas4==0) {
			comparacionVenta4 =  "igual que la cantidad óptima";
		} else {
			comparacionVenta4 = ((double)Math.round(Math.abs(diferenciaVentas4))) + " más que la cantidad óptima";
		}
		
		precioMayor = Math.max(Math.max(Math.max(Math.max(Tienda.precio0, Tienda.precio1), Tienda.precio2), Tienda.precio3), Tienda.precio4);
		
		precioMenor = Math.min(Math.min(Math.min(Math.min(Tienda.precio0, Tienda.precio1), Tienda.precio2), Tienda.precio3), Tienda.precio4);
		
		switch (indiceCmb) {
			case 0: //Ventas por modelo
				txtAreaResultado.setText("VENTAS POR MODELO" + "\n" + "\n");
				txtAreaResultado.append("Modelo                        : " + Tienda.modelo0 + "\n");
				txtAreaResultado.append("Cantidad de ventas            : " + Tienda.cantidadVentas0 + "\n");
				txtAreaResultado.append("Cantidad de unidades vendidas : " + Tienda.cantidadUnidadesVendidas0 + "\n");
				txtAreaResultado.append("Importe total vendido         : " + "S/. " +  Math.round(Tienda.importeTotal0 * 100)/100 + "\n");
				txtAreaResultado.append("Aporte a la cuota diaria      : " + Math.round(Tienda.importeTotal0 /Tienda.cuotaDiaria * 100 ) + "%" + "\n" + "\n");
	
				txtAreaResultado.append("Modelo                        : " + Tienda.modelo1 + "\n");
				txtAreaResultado.append("Cantidad de ventas            : " + Tienda.cantidadVentas1 + "\n");
				txtAreaResultado.append("Cantidad de unidades vendidas : " + Tienda.cantidadUnidadesVendidas1 + "\n");
				txtAreaResultado.append("Importe total vendido         : " + "S/. " +  Math.round(Tienda.importeTotal1 * 100)/100 + "\n");
				txtAreaResultado.append("Aporte a la cuota diaria      : " + Math.round(Tienda.importeTotal1 /Tienda.cuotaDiaria * 100 )+ "%" + "\n" + "\n");
	
				txtAreaResultado.append("Modelo                        : " + Tienda.modelo2 + "\n");
				txtAreaResultado.append("Cantidad de ventas            : " + Tienda.cantidadVentas2 + "\n");
				txtAreaResultado.append("Cantidad de unidades vendidas : " + Tienda.cantidadUnidadesVendidas2 + "\n");
				txtAreaResultado.append("Importe total vendido         : " + "S/. " +  Math.round(Tienda.importeTotal2 * 100)/100 + "\n");
				txtAreaResultado.append("Aporte a la cuota diaria      : " + Math.round(Tienda.importeTotal2 /Tienda.cuotaDiaria * 100 )+ "%" + "\n" + "\n");
	
				txtAreaResultado.append("Modelo                        : " + Tienda.modelo3 + "\n");
				txtAreaResultado.append("Cantidad de ventas            : " + Tienda.cantidadVentas3 + "\n");
				txtAreaResultado.append("Cantidad de unidades vendidas : " + Tienda.cantidadUnidadesVendidas3 + "\n");
				txtAreaResultado.append("Importe total vendido         : " + "S/. " +  Math.round(Tienda.importeTotal3 * 100)/100 + "\n");
				txtAreaResultado.append("Aporte a la cuota diaria      : " +  Math.round(Tienda.importeTotal3 /Tienda.cuotaDiaria * 100 )+ "%" + "\n" + "\n");
	
				txtAreaResultado.append("Modelo                        : " + Tienda.modelo4 + "\n");
				txtAreaResultado.append("Cantidad de ventas            : " + Tienda.cantidadVentas4 + "\n");
				txtAreaResultado.append("Cantidad de unidades vendidas : " + Tienda.cantidadUnidadesVendidas4 + "\n");
				txtAreaResultado.append("Importe total vendido         : " + "S/. " +  Math.round(Tienda.importeTotal4 * 100)/100 + "\n");
				txtAreaResultado.append("Aporte a la cuota diaria      : " +  Math.round(Tienda.importeTotal4 /Tienda.cuotaDiaria * 100 )+ "%");
				break;
			case 1: //Comparación de precios con el precio promedio
				txtAreaResultado.setText("COMPARACIÓN DE PRECIOS CON EL PRECIO PROMEDIO" + "\n" + "\n");
				txtAreaResultado.append("Modelo          : " + Tienda.modelo0 + "\n");
				txtAreaResultado.append("Precio          : " + Tienda.precio0 + "\n");
				txtAreaResultado.append("Precio promedio : " + precioPromedio + "\n");
				txtAreaResultado.append("Comparación     : " + comparacionPrecio0 + "\n" + "\n");
				
				txtAreaResultado.append("Modelo          : " + Tienda.modelo1 + "\n");
				txtAreaResultado.append("Precio          : " + Tienda.precio1 + "\n");
				txtAreaResultado.append("Precio promedio : " + precioPromedio + "\n");
				txtAreaResultado.append("Comparación     : " + comparacionPrecio1 + "\n" + "\n");
				
				txtAreaResultado.append("Modelo          : " + Tienda.modelo2 + "\n");
				txtAreaResultado.append("Precio          : " + Tienda.precio2 + "\n");
				txtAreaResultado.append("Precio promedio : " + precioPromedio + "\n");
				txtAreaResultado.append("Comparación     : " + comparacionPrecio2 +"\n" + "\n");
				
				txtAreaResultado.append("Modelo          : " + Tienda.modelo3 + "\n");
				txtAreaResultado.append("Precio          : " + Tienda.precio3 + "\n");
				txtAreaResultado.append("Precio promedio : " + precioPromedio + "\n");
				txtAreaResultado.append("Comparación     : " + comparacionPrecio3 + "\n" + "\n");
				
				txtAreaResultado.append("Modelo          : " + Tienda.modelo4 + "\n");
				txtAreaResultado.append("Precio          : " + Tienda.precio4 + "\n");
				txtAreaResultado.append("Precio promedio : " + precioPromedio + "\n");
				txtAreaResultado.append("Comparación     : " + comparacionPrecio4);
				break;
			case 2: //Comparación de cajas vendidas con la cantidad óptima
				txtAreaResultado.setText("COMPARACIÓN DE CAJAS VENDIDAS CON LA CANTIDAD ÓPTIMA" + "\n" + "\n");
				txtAreaResultado.append("Modelo                     : " + Tienda.modelo0 + "\n");
				txtAreaResultado.append("Cantidad de cajas vendidas : " + Tienda.cantidadUnidadesVendidas0 + "\n");
				txtAreaResultado.append("Cantidad Óptima            : " + Tienda.cantidadOptima + "\n");
				txtAreaResultado.append("Comparación                : " + comparacionVenta0 + "\n" + "\n");
				
				txtAreaResultado.append("Modelo                     : " + Tienda.modelo1 + "\n");
				txtAreaResultado.append("Cantidad de cajas vendidas : " + Tienda.cantidadUnidadesVendidas1 + "\n");
				txtAreaResultado.append("Cantidad Óptima            : " + Tienda.cantidadOptima + "\n");
				txtAreaResultado.append("Comparación                : " + comparacionVenta1 + "\n" + "\n");
				
				txtAreaResultado.append("Modelo                     : " + Tienda.modelo2 + "\n");
				txtAreaResultado.append("Cantidad de cajas vendidas : " + Tienda.cantidadUnidadesVendidas2 + "\n");
				txtAreaResultado.append("Cantidad Óptima            : " + Tienda.cantidadOptima + "\n");
				txtAreaResultado.append("Comparación                : " + comparacionVenta2 +  "\n" + "\n");
				
				txtAreaResultado.append("Modelo                     : " + Tienda.modelo3 + "\n");
				txtAreaResultado.append("Cantidad de cajas vendidas : " + Tienda.cantidadUnidadesVendidas3 + "\n");
				txtAreaResultado.append("Cantidad Óptima            : " + Tienda.cantidadOptima + "\n");
				txtAreaResultado.append("Comparación                : " + comparacionVenta3 + "\n" + "\n");
				
				txtAreaResultado.append("Modelo                     : " + Tienda.modelo4 + "\n");
				txtAreaResultado.append("Cantidad de cajas vendidas : " + Tienda.cantidadUnidadesVendidas4 + "\n");
				txtAreaResultado.append("Cantidad Óptima            : " + Tienda.cantidadOptima + "\n");
				txtAreaResultado.append("Comparación                : " + comparacionVenta4);
				break;
			default: //Estadística sobre el precio
				txtAreaResultado.setText("ESTADÍSTICA SOBRE EL PRECIO" + "\n" + "\n");
				txtAreaResultado.append("Precio promedio : S/. " + ((double)Math.round(precioPromedio*100)/100) + "\n");
				txtAreaResultado.append("Precio mayor    : S/. " + precioMayor + "\n");
				txtAreaResultado.append("Precio menor    : S/. " + precioMenor);
		}
	}
	
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
