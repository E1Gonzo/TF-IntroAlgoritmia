package tiendaceramicos;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarDescuentos extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDescuento2;
	private JTextField txtDescuento3;
	private JTextField txtDescuento4;
	private JLabel lblUnidades1Rango;
	private JTextField txtDescuento1;
	private JLabel lblPorcentaje1;
	private JLabel lblUnidades2Rango;
	private JLabel lblPorcentaje2;
	private JLabel lblUnidades3Rango;
	private JLabel lblPorcentaje3;
	private JLabel lblUnidades4Rango;
	private JLabel lblPorcentaje4;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigurarDescuentos dialog = new ConfigurarDescuentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarDescuentos() {
		setTitle("Configurar porcentajes de descuento");
		setBounds(100, 100, 423, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblUnidades1Rango = new JLabel("1 a 5 unidades");
			lblUnidades1Rango.setBounds(10, 11, 101, 26);
			contentPanel.add(lblUnidades1Rango);
			
			lblUnidades2Rango = new JLabel("6 a  10  unidades");
			lblUnidades2Rango.setBounds(10, 46, 101, 20);
			contentPanel.add(lblUnidades2Rango);
			
			lblUnidades3Rango = new JLabel("11 a 5 unidades ");
			lblUnidades3Rango.setBounds(10, 80, 101, 14);
			contentPanel.add(lblUnidades3Rango);
			
			lblUnidades4Rango = new JLabel("Mas de 15 unidades");
			lblUnidades4Rango.setBounds(10, 114, 119, 14);
			contentPanel.add(lblUnidades4Rango);
			
			txtDescuento1 = new JTextField();
			txtDescuento1.setText(""+Tienda.porcentaje1);
			txtDescuento1.setBounds(140, 14, 86, 20);
			contentPanel.add(txtDescuento1);
			txtDescuento1.setColumns(10);
			
			txtDescuento2 = new JTextField();
			txtDescuento2.setText(""+Tienda.porcentaje2);
			txtDescuento2.setBounds(140, 46, 86, 20);
			contentPanel.add(txtDescuento2);
			txtDescuento2.setColumns(10);
			
			txtDescuento3 = new JTextField();
			txtDescuento3.setText(""+Tienda.porcentaje3);
			txtDescuento3.setBounds(140, 77, 86, 20);
			contentPanel.add(txtDescuento3);
			txtDescuento3.setColumns(10);
			
			txtDescuento4 = new JTextField();
			txtDescuento4.setText(""+Tienda.porcentaje4);
			txtDescuento4.setBounds(140, 111, 86, 20);
			contentPanel.add(txtDescuento4);
			txtDescuento4.setColumns(10);
			
			lblPorcentaje1 = new JLabel("%");
			lblPorcentaje1.setBounds(236, 17, 46, 14);
			contentPanel.add(lblPorcentaje1);
			
			lblPorcentaje2 = new JLabel("%");
			lblPorcentaje2.setBounds(236, 49, 46, 14);
			contentPanel.add(lblPorcentaje2);
			
			lblPorcentaje3 = new JLabel("%");
			lblPorcentaje3.setBounds(236, 80, 46, 14);
			contentPanel.add(lblPorcentaje3);
			
			lblPorcentaje4 = new JLabel("%");
			lblPorcentaje4.setBounds(236, 114, 46, 14);
			contentPanel.add(lblPorcentaje4);
			
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(308, 13, 89, 23);
			contentPanel.add(btnAceptar);
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(308, 45, 89, 23);
			contentPanel.add(btnCancelar);
		}
	}
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == btnAceptar) {
		 actionPerformedBtnAceptar(e);
		 }
		 if (e.getSource() == btnCancelar) {
		 actionPerformedBtnCancelar(e);
		 }
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		double nuevoPorcentaje1, nuevoPorcentaje2, nuevoPorcentaje3, nuevoPorcentaje4;
		
		nuevoPorcentaje1 = Double.parseDouble(txtDescuento1.getText());
		nuevoPorcentaje2 = Double.parseDouble(txtDescuento2.getText());
		nuevoPorcentaje3 = Double.parseDouble(txtDescuento3.getText());
		nuevoPorcentaje4 = Double.parseDouble(txtDescuento4.getText());
		
		if (nuevoPorcentaje1<0) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese una cuota diaria mayor o igual a 0 dentro de la primera casilla", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else if (nuevoPorcentaje2<0) {
			JOptionPane.showMessageDialog(this, "Por favor, Ingrese una cuota diaria mayor o igual a 0 dentro de la segunda casilla", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else if (nuevoPorcentaje3<0) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese una cuota diaria mayor o igual a 0 dentro de la tercera casilla", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else if (nuevoPorcentaje4<0) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese una cuota diaria mayor o igual a 0 dentro de la cuarta casilla", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else {
			Tienda.porcentaje1 = nuevoPorcentaje1;
			Tienda.porcentaje2 = nuevoPorcentaje2;
			Tienda.porcentaje3 = nuevoPorcentaje3;
			Tienda.porcentaje4 = nuevoPorcentaje4;
			dispose();
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		 dispose();
	}
}
