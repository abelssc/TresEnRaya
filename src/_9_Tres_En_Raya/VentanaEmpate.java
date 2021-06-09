package _9_Tres_En_Raya;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Cursor;
import java.awt.ComponentOrientation;

public class VentanaEmpate extends JDialog {
	int x = 0;
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
			VentanaEmpate dialog = new VentanaEmpate();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaEmpate() {
		
		setUndecorated(true);
		getContentPane().setBackground(new Color(176, 196, 222));
		setSize(550,350);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
			
			
				JLabel lblEmpate = new JLabel("Empate");
				lblEmpate.setForeground(new Color(176, 196, 222));
				lblEmpate.setHorizontalAlignment(SwingConstants.CENTER);
				lblEmpate.setBounds(10, 20, 524, 80);
				lblEmpate.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 50));
				getContentPane().add(lblEmpate);
	
			JButton btnJugarDeNuevo = new JButton("Jugar De Nuevo");
			btnJugarDeNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnJugarDeNuevo.setForeground(new Color(176, 196, 222));
			btnJugarDeNuevo.setContentAreaFilled(false);
			btnJugarDeNuevo.setBorder(null);
			btnJugarDeNuevo.setFont(new Font("Segoe Script", Font.PLAIN, 20));
			btnJugarDeNuevo.setFocusPainted(false);
			btnJugarDeNuevo.setBounds(50, 282, 210, 35);
			getContentPane().add(btnJugarDeNuevo);
			btnJugarDeNuevo.addActionListener(accionEscucha);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.setContentAreaFilled(false);
			btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnSalir.setForeground(new Color(176, 196, 222));
			btnSalir.setBorder(null);
			btnSalir.setFont(new Font("Segoe Script", Font.PLAIN, 20));
			btnSalir.setFocusPainted(false);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			
			JSeparator separator = new JSeparator();
			separator.setBounds(49, 315, 211, 2);
			getContentPane().add(separator);
			btnSalir.setBounds(433, 282, 101, 35);
			getContentPane().add(btnSalir);
					
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(433, 315, 101, 2);
			getContentPane().add(separator_1);
			
			JLabel ImagenEmpate = new JLabel();
			ImagenEmpate.setBounds(5, 5, 540, 340);
			ImagenEmpate.setOpaque(true);
			ImagenEmpate.setBackground(Color.BLACK);
			ImageIcon icono=new ImageIcon(getClass().getResource("/_9_Tres_En_Raya/Imagenes/tres2.png"));
			ImagenEmpate.setIcon(icono);
			getContentPane().add(ImagenEmpate);
			

			
			
			ImagenEmpate.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					x=e.getX();//DEVUELVE POS DEL MOUSE RESPECTO A SU EVENTO
					y=e.getY();
				}
			});
			ImagenEmpate.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
					int xScreen=e.getXOnScreen();//DEVUELVE POS DEL MOUSE RESPECTO AAL SCREEN
					int yScreen=e.getYOnScreen();
					setLocation(xScreen-x,yScreen-y);
					
				}
			});
		
	}

}
