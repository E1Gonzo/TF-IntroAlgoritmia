package tiendaceramicos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MantenimientoConsultarCeramicos extends JDialog implements ActionListener{

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MantenimientoConsultarCeramicos dialog = new MantenimientoConsultarCeramicos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MantenimientoConsultarCeramicos() {
		setTitle("Consultar Cermico");
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
			txtPrecio.setEditable(false);
			txtPrecio.setBounds(96, 43, 200, 20);
			contentPanel.add(txtPrecio);
			txtPrecio.setColumns(10);
			
			txtAncho = new JTextField();
			txtAncho.setEditable(false);
			txtAncho.setBounds(96, 68, 200, 20);
			contentPanel.add(txtAncho);
			txtAncho.setColumns(10);
			
			txtLargo = new JTextField();
			txtLargo.setEditable(false);
			txtLargo.setBounds(96, 93, 200, 20);
			contentPanel.add(txtLargo);
			txtLargo.setColumns(10);
			
			txtEspesor = new JTextField();
			txtEspesor.setEditable(false);
			txtEspesor.setBounds(96, 118, 200, 20);
			contentPanel.add(txtEspesor);
			txtEspesor.setColumns(10);
			
			txtContenido = new JTextField();
			txtContenido.setEditable(false);
			txtContenido.setBounds(96, 143, 200, 20);
			contentPanel.add(txtContenido);
			txtContenido.setColumns(10);
			
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(325, 17, 89, 23);
			contentPanel.add(btnCerrar);
			
			cmbModelo.setSelectedIndex(0);
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
}