package _9_Tres_En_Raya;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.JSeparator;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class VentanaComenzarDeNuevo extends JDialog {
	private JButton btnUser1;
	private JButton btnUser2; 
	int x=0;
	int y=0;
	public ActionListener accionDeEscucha=new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String texto1=VentanaInicial.txtUser1.getText();
			String texto2=VentanaInicial.txtUser2.getText();
			if(e.getSource()==btnUser1) {
			
			}else if(e.getSource()==btnUser2) {
				VentanaInicial.cambio=(VentanaInicial.cambio==false)?true:false;
				VentanaInicial.txtUser1.setText(texto2);
				VentanaInicial.txtUser2.setText(texto1);
			}
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					VentanaJuego.botones[i][j].setIcon(null);
					VentanaJuego.botones[i][j].setName(" "+i+" "+j);
					VentanaJuego.botones[i][j].removeActionListener(VentanaJuego.selected);//YA QUE ALGUNOS BOTONES NO SE ACTIVAN Y NO ELIMINAN SU EVENTO EN EL JFRAME, AQUI ELIMINAREMOS A TODOS SU METODO
					VentanaJuego.botones[i][j].addActionListener(VentanaJuego.selected);//Y LUEGO AÑADIREMOS A TODOS EL METODO PARA EVITAR BOTONES CON UN DUPLICADO DEL MISMO METODO
				}
			}
			dispose();
		}
		
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaComenzarDeNuevo dialog = new VentanaComenzarDeNuevo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaComenzarDeNuevo() {
		setUndecorated(true);
		setSize(550,250);
		setLocationRelativeTo(null);
		
		
		getContentPane().setBackground(new Color(242,242,242));
		getContentPane().setLayout(null);
		
		JLabel lblExit = new JLabel();
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblExit.setIcon(new ImageIcon(VentanaComenzarDeNuevo.class.getResource("/_9_Tres_En_Raya/Imagenes/exit30px.png")));
		lblExit.setBounds(510, 10, 30, 30);
		getContentPane().add(lblExit);
		
		JLabel lblQuienJuegaPrimero = new JLabel("Quien");
		lblQuienJuegaPrimero.setBounds(10, 15, 514, 50);
		lblQuienJuegaPrimero.setFont(new Font("Segoe Script", Font.PLAIN, 40));
		lblQuienJuegaPrimero.setForeground(new Color(176, 196, 222));
		getContentPane().add(lblQuienJuegaPrimero);
		
		btnUser1 = new JButton(VentanaInicial.txtUser1.getText());
		btnUser1.setForeground(Color.WHITE);
		btnUser1.setContentAreaFilled(false);
		btnUser1.setBorder(null);
		btnUser1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUser1.setFocusPainted(false);
		btnUser1.setBounds(30, 204, 200, 35);
		btnUser1.setFont(new Font("Segoe Script", Font.PLAIN, 25));
		getContentPane().add(btnUser1);
		btnUser1.addActionListener(accionDeEscucha);
		
		btnUser2 = new JButton(VentanaInicial.txtUser2.getText());
		btnUser2.setForeground(Color.WHITE);
		btnUser2.setContentAreaFilled(false);
		btnUser2.setBorder(null);
		btnUser2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUser2.setFocusPainted(false);
		btnUser2.setBounds(340, 204, 200,35);
		btnUser2.setFont(new Font("Segoe Script", Font.PLAIN, 25));
		getContentPane().add(btnUser2);
		btnUser2.addActionListener(accionDeEscucha);

		
		JLabel lblPrimero = new JLabel("Primero??");
		lblPrimero.setForeground(new Color(176, 196, 222));
		lblPrimero.setFont(new Font("Segoe Script", Font.PLAIN, 40));
		lblPrimero.setBounds(197, 118, 259, 50);
		getContentPane().add(lblPrimero);
		
		JLabel lblJuega = new JLabel("juega");
		lblJuega.setForeground(Color.WHITE);
		lblJuega.setFont(new Font("Segoe Script", Font.PLAIN, 40));
		lblJuega.setBounds(121, 57, 133, 50);
		getContentPane().add(lblJuega);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(176, 196, 222));
		separator.setForeground(new Color(176, 196, 222));
		separator.setBounds(30, 237, 200, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(176, 196, 222));
		separator_1.setForeground(new Color(176, 196, 222));
		separator_1.setBounds(342, 237, 198, 2);
		getContentPane().add(separator_1);
		
		JLabel lblImagen = new JLabel();
		lblImagen.setForeground(new Color(230, 230, 250));
		lblImagen.setBounds(5, 5, 540, 240);
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon icono=new ImageIcon(getClass().getResource("/_9_Tres_En_Raya/Imagenes/wargames.gif"));
		
		
		lblImagen.setIcon(new ImageIcon(icono.getImage().getScaledInstance(240, 240, Image.SCALE_DEFAULT)));
		getContentPane().add(lblImagen);
		
		JLabel lblBackground = new JLabel();
		lblBackground.setBounds(5, 5, 540, 240);
		lblBackground.setOpaque(true);
		lblBackground.setBackground(new Color(5,8,17));
		getContentPane().add(lblBackground);
		
		lblImagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x=e.getX();
				y=e.getY();
			}
		});
		
		
		lblImagen.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				int xScreen=e.getXOnScreen();
				int yScreen=e.getYOnScreen();
				
				setLocation(xScreen-x, yScreen-y);
			}
		});
	}
}
