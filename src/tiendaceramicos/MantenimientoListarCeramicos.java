package tiendaceramicos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class MantenimientoListarCeramicos extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnListar;
	private JButton btnCerrar;
	private JScrollPane scpResultado;
	private JTextArea txtAreaResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MantenimientoListarCeramicos dialog = new MantenimientoListarCeramicos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MantenimientoListarCeramicos() {
		setTitle("Listar de Ceramicos");
		setBounds(100, 100, 527, 381);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(144, 307, 89, 23);
			contentPanel.add(btnCerrar);
			
			btnListar = new JButton("Listar");
			btnListar.addActionListener(this);
			btnListar.setBounds(274, 307, 89, 23);
			contentPanel.add(btnListar);
			
			scpResultado = new JScrollPane();
			scpResultado.setBounds(10, 11, 491, 285);
			contentPanel.add(scpResultado);
			
			txtAreaResultado = new JTextArea();
			txtAreaResultado.setFont(new Font("Monospaced",Font.PLAIN,13));
			scpResultado.setViewportView(txtAreaResultado);
		}
	}
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnCerrar) {
				actionPerformedBtnCerrar(e);
			}
			if(e.getSource() == btnListar) {
				actionPerformedBtnListar(e);
			}
	}
	
	public void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
		
	public void actionPerformedBtnListar(ActionEvent e) {
			txtAreaResultado.append("LISTADO DE CERÁMICOS" + "\n" + "\n");
			txtAreaResultado.append("Modelo          :  " + Tienda.modelo0 + "\n");
			txtAreaResultado.append("Precio          :  " + Tienda.precio0 + "\n");
			txtAreaResultado.append("Ancho (cm)      :  " + Tienda.ancho0 + "\n");
			txtAreaResultado.append("Largo (cm)      :  " + Tienda.largo0 + "\n");
			txtAreaResultado.append("Espesor (mm)    :  " + Tienda.espesor0 + "\n");
			txtAreaResultado.append("Contenido       :  " + Tienda.contenido0 + "\n" + "\n");
			
			txtAreaResultado.append("Modelo          :  " + Tienda.modelo1 + "\n");
			txtAreaResultado.append("Precio          :  " + Tienda.precio1 + "\n");
			txtAreaResultado.append("Ancho (cm)      :  " + Tienda.ancho1 + "\n");
			txtAreaResultado.append("Largo (cm)      :  " + Tienda.largo1 + "\n");
			txtAreaResultado.append("Espesor (mm)    :  " + Tienda.espesor1 + "\n");
			txtAreaResultado.append("Contenido       :  " + Tienda.contenido1 + "\n" + "\n");
			
			txtAreaResultado.append("Modelo          :  " + Tienda.modelo2 + "\n");
			txtAreaResultado.append("Precio          :  " + Tienda.precio2 + "\n");
			txtAreaResultado.append("Ancho (cm)      :  " + Tienda.ancho2 + "\n");
			txtAreaResultado.append("Largo (cm)      :  " + Tienda.largo2 + "\n");
			txtAreaResultado.append("Espesor (mm)    :  " + Tienda.espesor2 + "\n");
			txtAreaResultado.append("Contenido       :  " + Tienda.contenido2 + "\n" + "\n");
			
			txtAreaResultado.append("Modelo          :  " + Tienda.modelo3 + "\n");
			txtAreaResultado.append("Precio          :  " + Tienda.precio3 + "\n");
			txtAreaResultado.append("Ancho (cm)      :  " + Tienda.ancho3 + "\n");
			txtAreaResultado.append("Largo (cm)      :  " + Tienda.largo3 + "\n");
			txtAreaResultado.append("Espesor (mm)    :  " + Tienda.espesor3 + "\n");
			txtAreaResultado.append("Contenido       :  " + Tienda.contenido3 + "\n" + "\n");
			
			txtAreaResultado.append("Modelo          :  " + Tienda.modelo4 + "\n");
			txtAreaResultado.append("Precio          :  " + Tienda.precio4 + "\n");
			txtAreaResultado.append("Ancho (cm)      :  " + Tienda.ancho4 + "\n");
			txtAreaResultado.append("Largo (cm)      :  " + Tienda.largo4 + "\n");
			txtAreaResultado.append("Espesor (mm)    :  " + Tienda.espesor4 + "\n");
			txtAreaResultado.append("Contenido       :  " + Tienda.contenido4);
	}
}
