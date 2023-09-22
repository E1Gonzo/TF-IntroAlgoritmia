package tiendaceramicos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AyudaAcercaTienda extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTienda1;
	private JLabel lblAutores;
	private JLabel lblJoseAcuno;
	private JLabel lblGonzaloYanez;
	private JLabel lblRosaAguilar;
	private JLabel lblCristianParedes;
	private JButton btnCerrar;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AyudaAcercaTienda dialog = new AyudaAcercaTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AyudaAcercaTienda() {
		setTitle("Acerca de tienda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblTienda1 = new JLabel("Tienda 1.0");
			lblTienda1.setHorizontalAlignment(SwingConstants.CENTER);
			lblTienda1.setFont(new Font("Tahoma", Font.BOLD, 27));
			lblTienda1.setForeground(new Color(0, 0, 0));
			lblTienda1.setBounds(133, 11, 158, 43);
			contentPanel.add(lblTienda1);
			
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(169, 227, 89, 23);
			contentPanel.add(btnCerrar);
			
			lblAutores = new JLabel("Autores");
			lblAutores.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
			lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
			lblAutores.setBounds(145, 65, 136, 27);
			contentPanel.add(lblAutores);
			
			lblGonzaloYanez = new JLabel("Gonzalo Ya\u00F1ez");
			lblGonzaloYanez.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblGonzaloYanez.setHorizontalAlignment(SwingConstants.CENTER);
			lblGonzaloYanez.setBounds(169, 178, 89, 14);
			contentPanel.add(lblGonzaloYanez);
			
			lblJoseAcuno = new JLabel("Jose Acu\u00F1a");
			lblJoseAcuno.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblJoseAcuno.setHorizontalAlignment(SwingConstants.CENTER);
			lblJoseAcuno.setBounds(169, 103, 89, 14);
			contentPanel.add(lblJoseAcuno);
			
			lblCristianParedes = new JLabel("Cristian Paredes");
			lblCristianParedes.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCristianParedes.setHorizontalAlignment(SwingConstants.CENTER);
			lblCristianParedes.setBounds(145, 128, 136, 14);
			contentPanel.add(lblCristianParedes);
			
			lblRosaAguilar = new JLabel("Rosa Aguilar");
			lblRosaAguilar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblRosaAguilar.setHorizontalAlignment(SwingConstants.CENTER);
			lblRosaAguilar.setBounds(169, 153, 89, 14);
			contentPanel.add(lblRosaAguilar);
			
			separator = new JSeparator();
			separator.setBounds(10, 52, 414, 2);
			contentPanel.add(separator);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			dispose();
		}
	}
}
