package tiendaceramicos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MantenimientoModificarCeramicos extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> cmbModelo;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblLargo;
	private JLabel lblEspesor;
	private JLabel lblContenido;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtLargo;
	private JTextField txtEspesor;
	private JTextField txtContenido;
	private JButton btnCerrar;
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MantenimientoModificarCeramicos dialog = new MantenimientoModificarCeramicos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MantenimientoModificarCeramicos() {
		setTitle("Modificar Cer\u00E1mico");
		setBounds(100, 100, 450, 211);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblModelo = new JLabel("Modelo");
			lblModelo.setBounds(10, 21, 76, 14);
			contentPanel.add(lblModelo);
			
			lblPrecio = new JLabel("Precio (S/)");
			lblPrecio.setBounds(10, 46, 76, 14);
			contentPanel.add(lblPrecio);
			
			lblAncho = new JLabel("Ancho (cm)");
			lblAncho.setBounds(10, 71, 76, 14);
			contentPanel.add(lblAncho);
			
			lblLargo = new JLabel("Largo (cm)");
			lblLargo.setBounds(10, 96, 76, 14);
			contentPanel.add(lblLargo);
			
			lblEspesor = new JLabel("Espesor (mm)");
			lblEspesor.setBounds(10, 121, 82, 14);
			contentPanel.add(lblEspesor);
			
			lblContenido = new JLabel("Contenido");
			lblContenido.setBounds(10, 146, 76, 14);
			contentPanel.add(lblContenido);
			
			cmbModelo = new JComboBox<String>();
			cmbModelo.addActionListener(this);
			cmbModelo.setModel(new DefaultComboBoxModel<String>(new String[] {"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thalia"}));
			cmbModelo.setBounds(96, 17, 200, 22);
			contentPanel.add(cmbModelo);
			
			txtPrecio = new JTextField();
			txtPrecio.setBounds(96, 43, 200, 20);
			contentPanel.add(txtPrecio);
			txtPrecio.setColumns(10);
			
			txtAncho = new JTextField();
			txtAncho.setBounds(96, 68, 200, 20);
			contentPanel.add(txtAncho);
			txtAncho.setColumns(10);
			
			txtLargo = new JTextField();
			txtLargo.setBounds(96, 93, 200, 20);
			contentPanel.add(txtLargo);
			txtLargo.setColumns(10);
			
			txtEspesor = new JTextField();
			txtEspesor.setBounds(96, 118, 200, 20);
			contentPanel.add(txtEspesor);
			txtEspesor.setColumns(10);
			
			txtContenido = new JTextField();
			txtContenido.setBounds(96, 143, 200, 20);
			contentPanel.add(txtContenido);
			txtContenido.setColumns(10);
			
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(325, 17, 89, 23);
			contentPanel.add(btnCerrar);
			
			btnGrabar = new JButton("Grabar");
			btnGrabar.addActionListener(this);
			btnGrabar.setBounds(325, 42, 89, 23);
			contentPanel.add(btnGrabar);
			
			cmbModelo.setToolTipText(Tienda.modelo0);
			txtPrecio.setText(""+Tienda.precio0);
			txtAncho.setText(""+Tienda.ancho0);
			txtLargo.setText(""+Tienda.largo0);
			txtEspesor.setText(""+Tienda.espesor0);
			txtContenido.setText(""+Tienda.contenido0);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cmbModelo) {
			actionPerformedCmbModelo(e);
		} 
		if(e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if(e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
	}
	public void actionPerformedCmbModelo(ActionEvent e) {
		if(cmbModelo.getSelectedItem().equals("Cinza Plus")) {
			txtPrecio.setText(String.valueOf(Tienda.precio0));
			txtAncho.setText(String.valueOf(Tienda.ancho0));
			txtLargo.setText(String.valueOf(Tienda.largo0));
			txtEspesor.setText(String.valueOf(Tienda.espesor0));
			txtContenido.setText(String.valueOf(Tienda.contenido0));
		}
		if(cmbModelo.getSelectedItem().equals("Luxury")) {
			txtPrecio.setText(String.valueOf(Tienda.precio1));
			txtAncho.setText(String.valueOf(Tienda.ancho1));
			txtLargo.setText(String.valueOf(Tienda.largo1));
			txtEspesor.setText(String.valueOf(Tienda.espesor1));
			txtContenido.setText(String.valueOf(Tienda.contenido1));
		}
		if(cmbModelo.getSelectedItem().equals("Austria")) {
			txtPrecio.setText(String.valueOf(Tienda.precio2));
			txtAncho.setText(String.valueOf(Tienda.ancho2));
			txtLargo.setText(String.valueOf(Tienda.largo2));
			txtEspesor.setText(String.valueOf(Tienda.espesor2));
			txtContenido.setText(String.valueOf(Tienda.contenido2));
		}
		if(cmbModelo.getSelectedItem().equals("Yungay Mix")) {
			txtPrecio.setText(String.valueOf(Tienda.precio3));
			txtAncho.setText(String.valueOf(Tienda.ancho3));
			txtLargo.setText(String.valueOf(Tienda.largo3));
			txtEspesor.setText(String.valueOf(Tienda.espesor3));
			txtContenido.setText(String.valueOf(Tienda.contenido3));
		}
		if(cmbModelo.getSelectedItem().equals("Thalia")) {
			txtPrecio.setText(String.valueOf(Tienda.precio4));
			txtAncho.setText(String.valueOf(Tienda.ancho4));
			txtLargo.setText(String.valueOf(Tienda.largo4));
			txtEspesor.setText(String.valueOf(Tienda.espesor4));
			txtContenido.setText(String.valueOf(Tienda.contenido4));
		}
	}
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
		
	public void actionPerformedBtnGrabar(ActionEvent e) {
		double nuevoPrecio, nuevoAncho, nuevoLargo, nuevoEspesor;
		int nuevoContenido;
		
		nuevoPrecio = Double.parseDouble(txtPrecio.getText());
		nuevoAncho = Double.parseDouble(txtAncho.getText());
		nuevoLargo = Double.parseDouble(txtLargo.getText());
		nuevoEspesor = Double.parseDouble(txtEspesor.getText());
		nuevoContenido = Integer.parseInt(txtContenido.getText());
		
		if (nuevoPrecio<1) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese un precio mayor o igual a 1", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else if (nuevoAncho<1) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese un ancho mayor o igual a 1", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else if (nuevoLargo<1) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese un largo mayor o igual a 1", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else if (nuevoEspesor<1) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese un espesor mayor o igual a 1", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else if (nuevoContenido<1) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese un contenido mayor o igual a 1", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else  {
			if(cmbModelo.getSelectedItem().equals("Cinza Plus")) {
		 		Tienda.precio0 = nuevoPrecio;
				Tienda.ancho0  = nuevoAncho;
				Tienda.largo0  = nuevoLargo;
				Tienda.espesor0  = nuevoEspesor;
				Tienda.contenido0  = nuevoContenido;
			}
			if(cmbModelo.getSelectedItem().equals("Luxury")) {
		 		Tienda.precio1 = nuevoPrecio;
				Tienda.ancho1  = nuevoAncho;
				Tienda.largo1  = nuevoLargo;
				Tienda.espesor1  = nuevoEspesor;
				Tienda.contenido1  = nuevoContenido;
			}
			if(cmbModelo.getSelectedItem().equals("Austria")) {
		 		Tienda.precio2 = nuevoPrecio;
				Tienda.ancho2  = nuevoAncho;
				Tienda.largo2  = nuevoLargo;
				Tienda.espesor2  = nuevoEspesor;
				Tienda.contenido2  = nuevoContenido;
			}
			if(cmbModelo.getSelectedItem().equals("Yungay Mix")) {
		 		Tienda.precio3 = nuevoPrecio;
				Tienda.ancho3  = nuevoAncho;
				Tienda.largo3  = nuevoLargo;
				Tienda.espesor3  = nuevoEspesor;
				Tienda.contenido3  = nuevoContenido;
			}
			if(cmbModelo.getSelectedItem().equals("Thalia")) {
		 		Tienda.precio4 = nuevoPrecio;
				Tienda.ancho4  = nuevoAncho;
				Tienda.largo4  = nuevoLargo;
				Tienda.espesor4  = nuevoEspesor;
				Tienda.contenido4  = nuevoContenido;
			}
			dispose();
		}
			
	}
}