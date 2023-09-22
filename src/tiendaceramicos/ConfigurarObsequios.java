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

public class ConfigurarObsequios extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtObsequioCantidad1;
	private JTextField txtObsequioCantidad2;
	private JTextField txtObsequioCantidad3;
	private JLabel lblTipoObsequio;
	private JTextField txtTipoObsequio;
	private JLabel lblObsequioCantidad1;
	private JLabel lblObsequioCantidad2;
	private JLabel lblObsequioCantidad3;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigurarObsequios dialog = new ConfigurarObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarObsequios() {
		setTitle("Configurar obsequios");
		setBounds(100, 100, 423, 181);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblTipoObsequio = new JLabel("Tipo de obsequio");
			lblTipoObsequio.setBounds(10, 11, 101, 26);
			contentPanel.add(lblTipoObsequio);
			
			lblObsequioCantidad1 = new JLabel("1 a 5 unidades");
			lblObsequioCantidad1.setBounds(10, 46, 101, 20);
			contentPanel.add(lblObsequioCantidad1);
			
			lblObsequioCantidad2 = new JLabel("6 a10 unidades ");
			lblObsequioCantidad2.setBounds(10, 80, 101, 14);
			contentPanel.add(lblObsequioCantidad2);
			
			lblObsequioCantidad3 = new JLabel("11 a m\u00E1s unidades");
			lblObsequioCantidad3.setBounds(10, 114, 119, 14);
			contentPanel.add(lblObsequioCantidad3);
			
			txtTipoObsequio = new JTextField();
			txtTipoObsequio.setText(Tienda.tipoObsequio);
			txtTipoObsequio.setBounds(139, 14, 86, 20);
			contentPanel.add(txtTipoObsequio);
			txtTipoObsequio.setColumns(10);

			txtObsequioCantidad1 = new JTextField();
			txtObsequioCantidad1.setText(Integer.toString(Tienda.obsequioCantidad1));
			txtObsequioCantidad1.setBounds(139, 46, 86, 20);
			contentPanel.add(txtObsequioCantidad1);
			txtObsequioCantidad1.setColumns(10);
			
			txtObsequioCantidad2 = new JTextField();
			txtObsequioCantidad2.setText(Integer.toString(Tienda.obsequioCantidad2));
			txtObsequioCantidad2.setBounds(139, 77, 86, 20);
			contentPanel.add(txtObsequioCantidad2);
			txtObsequioCantidad2.setColumns(10);
			
			txtObsequioCantidad3 = new JTextField();
			txtObsequioCantidad3.setText(Integer.toString(Tienda.obsequioCantidad3));
			txtObsequioCantidad3.setBounds(139, 111, 86, 20);
			contentPanel.add(txtObsequioCantidad3);
			txtObsequioCantidad3.setColumns(10);
			
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
	
	public void actionPerformed (ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	
	public void actionPerformedBtnAceptar (ActionEvent e) {
		String nuevoTipoObsequio;
		int nuevoObsequioCantidad1, nuevoObsequioCantidad2, nuevoObsequioCantidad3;
		
		nuevoTipoObsequio = txtTipoObsequio.getText();
		nuevoObsequioCantidad1 = Integer.parseInt(txtObsequioCantidad1.getText());
		nuevoObsequioCantidad2 = Integer.parseInt(txtObsequioCantidad2.getText());
		nuevoObsequioCantidad3 = Integer.parseInt(txtObsequioCantidad3.getText());
		
		if (nuevoTipoObsequio.equals("")) {
			JOptionPane.showMessageDialog(this, "¡Casilla vacía!" + "\n" +"Por favor ingrese un tipo de obsequio válido", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else if (nuevoObsequioCantidad1<0) {
			JOptionPane.showMessageDialog(this, "Por favor ingrese una cantidad de obsequios válida dentro de la segunda casilla", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else if (nuevoObsequioCantidad2<0) {
			JOptionPane.showMessageDialog(this, "Por favor ingrese una cantidad de obsequios válida dentro de la tercera casilla", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else if (nuevoObsequioCantidad3<0) {
			JOptionPane.showMessageDialog(this, "Por favor ingrese una cantidad de obsequios válida dentro de la cuarta casilla", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else {
			Tienda.tipoObsequio = nuevoTipoObsequio;
			Tienda.obsequioCantidad1 = nuevoObsequioCantidad1;
			Tienda.obsequioCantidad2 = nuevoObsequioCantidad2;
			Tienda.obsequioCantidad3 = nuevoObsequioCantidad3;
			dispose();
		}
	}
	
	public void actionPerformedBtnCancelar (ActionEvent e) {
		dispose();
	}
}
