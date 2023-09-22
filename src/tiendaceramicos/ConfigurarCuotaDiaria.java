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

public class ConfigurarCuotaDiaria extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantidadDiariaEsperada;
	private JLabel lblCantidadDiariaEsperada;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigurarCuotaDiaria dialog = new ConfigurarCuotaDiaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarCuotaDiaria() {
		setTitle("Configurar cuota diaria");
		setBounds(100, 100, 450, 116);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblCantidadDiariaEsperada = new JLabel("Cuota diaria esperada (S/.)");
			lblCantidadDiariaEsperada.setBounds(10, 11, 167, 28);
			contentPanel.add(lblCantidadDiariaEsperada);
			
			txtCantidadDiariaEsperada = new JTextField();
			txtCantidadDiariaEsperada.setText(Double.toString(Tienda.cuotaDiaria));
			txtCantidadDiariaEsperada.setBounds(187, 15, 96, 20);
			contentPanel.add(txtCantidadDiariaEsperada);
			txtCantidadDiariaEsperada.setColumns(10);
			
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(335, 14, 89, 23);
			contentPanel.add(btnAceptar);
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(335, 43, 89, 23);
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
		double nuevaCuotaDiaria;
		
		nuevaCuotaDiaria = Double.parseDouble(txtCantidadDiariaEsperada.getText());
		
		if (nuevaCuotaDiaria<0.5) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese una cuota diaria mayor o igual a 0.5", "Alerta", JOptionPane.WARNING_MESSAGE);
		} else {
			Tienda.cuotaDiaria = nuevaCuotaDiaria;
			dispose();
		}
	}
	
	public void actionPerformedBtnCancelar (ActionEvent e) {
		dispose();
	}
}
