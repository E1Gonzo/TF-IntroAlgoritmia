package tiendaceramicos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConfigurarCantidadOptima extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantidadOptima;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblCantidadOptima;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigurarCantidadOptima dialog = new ConfigurarCantidadOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarCantidadOptima() {
		setTitle("Configurar cantidad \u00F3ptima");
		setBounds(100, 100, 450, 116);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblCantidadOptima = new JLabel("Cantidad Optima de unidades vendidas ");
			lblCantidadOptima.setBounds(10, 11, 225, 28);
			contentPanel.add(lblCantidadOptima);
			
			txtCantidadOptima = new JTextField();
			txtCantidadOptima.setText("10");
			txtCantidadOptima.setBounds(244, 15, 55, 20);
			contentPanel.add(txtCantidadOptima);
			txtCantidadOptima.setColumns(10);
			
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(335, 14, 89, 23);
			contentPanel.add(btnAceptar);
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(335, 43, 89, 23);
			contentPanel.add(btnCancelar);
			
			txtCantidadOptima.setText(""+Tienda.cantidadOptima);
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
		int nuevaCantidadOptima;
		
		nuevaCantidadOptima = Integer.parseInt(txtCantidadOptima.getText());
		
		if (nuevaCantidadOptima<1) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese una cuota diaria mayor o igual a 1", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else {
			Tienda.cantidadOptima = nuevaCantidadOptima;
			dispose();
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		 dispose();
	}
}
