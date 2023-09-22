package tiendaceramicos;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentasVender extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecioSoles;
	private JTextField txtCantidad;
	private JComboBox<String> cmbModelo;
	private JLabel lblModelo;
	private JLabel lblPrecioSoles;
	private JLabel lblCantidad;
	private JButton btnVender;
	private JButton btnCerrar;
	private JScrollPane scpResultado;
	private JTextArea txtAreaResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentasVender dialog = new VentasVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentasVender() {
		setTitle("Vender");
		setBounds(100, 100, 450, 336);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblModelo = new JLabel("Modelo");
			lblModelo.setBounds(10, 11, 46, 14);
			contentPanel.add(lblModelo);
			
			lblPrecioSoles = new JLabel("Precio (S/)");
			lblPrecioSoles.setBounds(10, 36, 67, 14);
			contentPanel.add(lblPrecioSoles);
			
			lblCantidad = new JLabel("Cantidad");
			lblCantidad.setBounds(10, 61, 67, 14);
			contentPanel.add(lblCantidad);
			
			cmbModelo = new JComboBox<String>();
			cmbModelo.addActionListener(this);
			cmbModelo.setModel(new DefaultComboBoxModel<String>(new String[] {"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalia"}));
			cmbModelo.setBounds(87, 7, 143, 22);
			contentPanel.add(cmbModelo);
			
			txtPrecioSoles = new JTextField();
			txtPrecioSoles.setText(Double.toString(Tienda.precio0));
			txtPrecioSoles.setEditable(false);
			txtPrecioSoles.setBounds(87, 33, 143, 20);
			contentPanel.add(txtPrecioSoles);
			txtPrecioSoles.setColumns(10);
			
			txtCantidad = new JTextField();
			txtCantidad.setBounds(87, 58, 143, 20);
			contentPanel.add(txtCantidad);
			txtCantidad.setColumns(10);
			
			btnVender = new JButton("Vender");
			btnVender.addActionListener(this);
			btnVender.setBounds(335, 11, 89, 23);
			contentPanel.add(btnVender);
			
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(335, 36, 89, 23);
			contentPanel.add(btnCerrar);
			
			scpResultado = new JScrollPane();
			scpResultado.setBounds(10, 86, 414, 200);
			contentPanel.add(scpResultado);
			
			txtAreaResultado = new JTextArea();
			txtAreaResultado.setFont(new Font("Monospaced",Font.PLAIN,13));
			scpResultado.setViewportView(txtAreaResultado);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== cmbModelo) {
			actionPerformedVentasVender(e);
		}
		if(e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		} 
		if(e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	
	public void actionPerformedVentasVender(ActionEvent e) {
		int indiceCmb=0;
		
		indiceCmb = cmbModelo.getSelectedIndex();
		
		switch(indiceCmb) {
			case 0:
				txtPrecioSoles.setText(String.valueOf(Tienda.precio0));
				break;
			case 1:
				txtPrecioSoles.setText(String.valueOf(Tienda.precio1));
				break;
			case 2:
				txtPrecioSoles.setText(String.valueOf(Tienda.precio2));
				break;
			case 3:
				txtPrecioSoles.setText(String.valueOf(Tienda.precio3));
				break;
			default:
				txtPrecioSoles.setText(String.valueOf(Tienda.precio4));
		}
	}
	
	
	public void actionPerformedBtnVender(ActionEvent e) {
		int cantidadModelo;
		
		cantidadModelo = Integer.parseInt(txtCantidad.getText());
		
		if (cantidadModelo<=0) {
			JOptionPane.showMessageDialog(this, "¡Cantidad inválida!" + "\n" + "Por favor, inténtelo de nuevo", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else {
			int 	indiceCmb=0, cantidadObsequio;
			double 	precioModelo, importeCompra=0, importeDescuento=0, importePagar=0;
			String	modeloCeramico;
	
			indiceCmb = cmbModelo.getSelectedIndex();
			modeloCeramico 	= (String)cmbModelo.getSelectedItem().toString();
			precioModelo 	= Double.parseDouble(txtPrecioSoles.getText());
			
			Tienda.contador++;
			
			importeCompra = precioModelo*cantidadModelo;
			
			if (1<=cantidadModelo && cantidadModelo<=5) {
				importeDescuento = (importeCompra*Tienda.porcentaje1)/100;
				cantidadObsequio = Tienda.obsequioCantidad1;
			} else if (6<=cantidadModelo && cantidadModelo<=10) {
				importeDescuento = (importeCompra*Tienda.porcentaje2)/100;
				cantidadObsequio = Tienda.obsequioCantidad2;
			} else if (11<=cantidadModelo && cantidadModelo<=15) {
				importeDescuento = (importeCompra*Tienda.porcentaje3)/100;
				cantidadObsequio = Tienda.obsequioCantidad3;
			} else {
				importeDescuento = (importeCompra*Tienda.porcentaje4)/100;
				cantidadObsequio = Tienda.obsequioCantidad3;
			}
			
			importePagar = importeCompra - importeDescuento;
			
			Tienda.importeAcumulado 		= Tienda.importeAcumulado + importePagar;
			Tienda.porcentajeCuota 			= (importePagar / Tienda.cuotaDiaria) * 100;
			Tienda.porcentajeCuotaAcumulado = Tienda.porcentajeCuotaAcumulado + Tienda.porcentajeCuota;
			
			while (Tienda.contador % 5 == 0) {
				JOptionPane.showMessageDialog(this, "Venta Nro." + Tienda.contador + "\n" + "Importe total general acumulado : S/. " + 
					Math.round(Tienda.importeAcumulado) + "\n" + "Porcentaje de la cuota diaria : " + 
					Math.round(Tienda.porcentajeCuotaAcumulado) + " %","Avance de ventas", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
			
			txtAreaResultado.setText("BOLETA DE VENTA" + "\n" + "\n");
			txtAreaResultado.append("Modelo               :  "		+ modeloCeramico 								+ "\n");
			txtAreaResultado.append("Precio               :  S/. "	+ precioModelo									+ "\n");
			txtAreaResultado.append("Cantidad adquirida   :  "		+ cantidadModelo 								+ "\n");
			txtAreaResultado.append("Importe compra       :  S/. "	+ ((double)Math.round(importeCompra*100)/100)	+ "\n");
			txtAreaResultado.append("Importe descuento    :  S/. "	+ ((double)Math.round(importeDescuento*100)/100)+ "\n");
			txtAreaResultado.append("Importe pagar        :  S/. "	+ ((double)Math.round(importePagar*100)/100)	+ "\n");
			txtAreaResultado.append("Tipo de obsequio     :  " 		+ Tienda.tipoObsequio							+ "\n");
			txtAreaResultado.append("Unidades obsequiadas :  " 		+ cantidadObsequio);
			
			switch (indiceCmb) {
				case 0:
					Tienda.cantidadUnidadesVendidas0 = Tienda.cantidadUnidadesVendidas0 + cantidadModelo;
					Tienda.importeTotal0 = Tienda.importeTotal0 + importePagar;
					Tienda.cantidadVentas0++;
					break;
				case 1:
					Tienda.cantidadUnidadesVendidas1 = Tienda.cantidadUnidadesVendidas1 + cantidadModelo;
					Tienda.importeTotal1 = Tienda.importeTotal1 + importePagar;
					Tienda.cantidadVentas1++;
					break;
				case 2:
					Tienda.cantidadUnidadesVendidas2 = Tienda.cantidadUnidadesVendidas2 + cantidadModelo;
					Tienda.importeTotal2 = Tienda.importeTotal2 + importePagar;
					Tienda.cantidadVentas2++;
					break;
				case 3:
					Tienda.cantidadUnidadesVendidas3 = Tienda.cantidadUnidadesVendidas3 + cantidadModelo;
					Tienda.importeTotal3 = Tienda.importeTotal3 + importePagar;
					Tienda.cantidadVentas3++;
					break;
				default:
					Tienda.cantidadUnidadesVendidas1 = Tienda.cantidadUnidadesVendidas4 + cantidadModelo;
					Tienda.importeTotal4 = Tienda.importeTotal4 + importePagar;
					Tienda.cantidadVentas4++;
			}
		}
	}
	
	
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
