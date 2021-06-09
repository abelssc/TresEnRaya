package _9_Tres_En_Raya;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SpringLayout.Constraints;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;

public class VentanaGanaste extends JDialog {
	public JLabel lblTitulo;
	int x=0;
	int y=0;
	
	private ActionListener accionEscucha=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			VentanaComenzarDeNuevo ventanaComenzarDeNuevo=new VentanaComenzarDeNuevo();
			ventanaComenzarDeNuevo.setModal(true);//TODAS LAS PROPIEDADES DEL OBJETO DEBEN IR SIEMPRE ANTES DEL MODAL
			ventanaComenzarDeNuevo.setVisible(true);//ESTO EVITA QUE EL CUADRO QUE GENERA EL JDIALOG SEA INTOCABLE HASTA CERRAR EL JDIALOG GENERADO
			dispose();//ESTA LINEA SE EJECUTARA SOLO CUANDO EL JDIALOG vemtamaComenzardeNuevoSUPERIOR TERMINE DE EJEECUTARSE O SE CIERRE(HAGA UN DISPOSE)
		}
	};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaGanaste dialog = new VentanaGanaste();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaGanaste() {
		
		
		setUndecorated(true);
		setSize(550, 350);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		lblTitulo = new JLabel();
		lblTitulo.setForeground(new Color(211, 211, 211));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe Script", Font.PLAIN, 40));
		lblTitulo.setBounds(10, 90, 530, 45);
		getContentPane().add(lblTitulo);
		
		JLabel lblGanaste = new JLabel("GANASTEE!!!");
		lblGanaste.setBounds(10, 30, 530, 45);
		lblGanaste.setFont(new Font("Segoe Script", Font.PLAIN, 40));
		lblGanaste.setForeground(Color.WHITE);
		getContentPane().add(lblGanaste);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorder(null);
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setFocusPainted(false);
		btnSalir.setBounds(340, 300, 200, 30);
		btnSalir.setFont(new Font("Segoe Script", Font.BOLD, 20));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.BLACK);
		getContentPane().add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		
		JButton btnJugarDeNuevo = new JButton("Jugar De Nuevo");
		btnJugarDeNuevo.setContentAreaFilled(false);
		btnJugarDeNuevo.setBorder(null);
		btnJugarDeNuevo.addActionListener(accionEscucha);
		btnJugarDeNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJugarDeNuevo.setFocusPainted(false);
		btnJugarDeNuevo.setBounds(340, 250, 200, 30);
		btnJugarDeNuevo.setFont(new Font("Segoe Script", Font.BOLD, 20));
		btnJugarDeNuevo.setForeground(Color.WHITE);
		btnJugarDeNuevo.setBackground(Color.BLACK);
		getContentPane().add(btnJugarDeNuevo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(357, 277, 171, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(400, 328, 84, 2);
		getContentPane().add(separator_1);
		
		JLabel imagen = new JLabel();
		imagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x=e.getX();
				y=e.getY();
			}
		});
		imagen.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xScreen=e.getXOnScreen();
				int yScreen=e.getYOnScreen();
				
				setLocation(xScreen-x, yScreen-y);
			}
		});
		imagen.setBounds(5, 5, 540, 340);
		ImageIcon icono=new ImageIcon(getClass().getResource("/_9_Tres_En_Raya/Imagenes/ganador.gif"));
		
	
		imagen.setIcon(new ImageIcon(icono.getImage().getScaledInstance(540, 340, Image.SCALE_DEFAULT)));//SCALE SMOOT NO FUNCIONA EN GIFTS
		getContentPane().add(imagen);
	}

}
