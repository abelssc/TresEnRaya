package _9_Tres_En_Raya;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Insets;
import java.awt.Point;

public class VentanaJuego extends JFrame {

	private JPanel contentPane;
	private int mousePosX,mousePosY;//DEVUELVE LA POSICION DEL MOUSE RESPECTO A SU CONTENEDOR
	private void  dragg(MouseEvent event) {
		int x=event.getXOnScreen();//DEVUELVE LA POSICION DEL MOUSE RESPECTO AL WINDOWS
		int y=event.getYOnScreen();
		
		this.setLocation(x-mousePosX, y-mousePosY);
	}
	public static boolean booleanIcono;
	public static JButton[][] botones;//STATIC PARA ACCEDER A LOS VALORES SIN NECESIDAD DE CREAR OTRA INSTANCIA
	public static int intentos;
	
	private static ImageIcon iconoX=new ImageIcon(VentanaJuego.class.getResource("/_9_Tres_En_Raya/Imagenes/equis.png"));
	private static ImageIcon iconoO=new ImageIcon(VentanaJuego.class.getResource("/_9_Tres_En_Raya/Imagenes/circulo.png"));
	public static ActionListener selected=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean hayganador=false;
			String iconoGanador = null;
			
			if(booleanIcono==true) {
				((JButton) e.getSource()).setIcon(iconoX);
				((JButton) e.getSource()).setName("iconoX");
				booleanIcono=false;
			}else if(booleanIcono==false) {
				((JButton) e.getSource()).setIcon(iconoO);
				((JButton) e.getSource()).setName("iconoO");
				booleanIcono=true;
			}
			((JButton) e.getSource()).removeActionListener(selected);
			
			if(botones[0][0].getName().equals(botones[0][1].getName())) {
				if(botones[0][0].getName().equals(botones[0][2].getName())) {
					hayganador=true;
					iconoGanador=botones[0][0].getName();
				}
			}
			if(botones[0][0].getName().equals(botones[1][0].getName())) {
				if(botones[0][0].getName().equals(botones[2][0].getName())) {
					hayganador=true;
					iconoGanador=botones[0][0].getName();
				}
			}
			if(botones[0][0].getName().equals(botones[1][1].getName())) {
				if(botones[0][0].getName().equals(botones[2][2].getName())) {
					hayganador=true;
					iconoGanador=botones[0][0].getName();
				}
			}
			
			if(botones[0][1].getName().equals(botones[1][1].getName())) {
				if(botones[0][1].getName().equals(botones[2][1].getName())) {
					hayganador=true;
					iconoGanador=botones[0][1].getName();
				}
			}
			if(botones[0][2].getName().equals(botones[1][2].getName())) {
				if(botones[0][2].getName().equals(botones[2][2].getName())) {
					hayganador=true;
					iconoGanador=botones[0][2].getName();
				}
			}
			if(botones[0][2].getName().equals(botones[1][1].getName())) {
				if(botones[0][2].getName().equals(botones[2][0].getName())) {
					hayganador=true;
					iconoGanador=botones[0][2].getName();
				}
			}
		
			if(botones[1][0].getName().equals(botones[1][1].getName())) {
				if(botones[1][0].getName().equals(botones[1][2].getName())) {
					hayganador=true;
					iconoGanador=botones[1][0].getName();
				}
			}
			if(botones[2][0].getName().equals(botones[2][1].getName())) {
				if(botones[2][0].getName().equals(botones[2][2].getName())) {
					hayganador=true;
					iconoGanador=botones[2][0].getName();
				}
			}
			intentos++;
			if(hayganador) {
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						botones[i][j].removeActionListener(selected);
					}
				}
				intentos=0;
				booleanIcono=true;
				VentanaGanaste ventanaGanaste=new VentanaGanaste();
				ventanaGanaste.setModal(true);//SET MODAL DEBE IR ANTES DE HACERSE VISIBLE
				if(iconoGanador.equals("iconoX")) {
					ventanaGanaste.lblTitulo.setText(VentanaInicial.txtUser1.getText()+" Felicidades...!!");
					if(VentanaInicial.cambio==false) {
						VentanaInicial.winUser1++;
					}else if(VentanaInicial.cambio) {
						VentanaInicial.winUser2++;
					}
				}else if(iconoGanador.equals("iconoO")) {
					ventanaGanaste.lblTitulo.setText(VentanaInicial.txtUser2.getText()+" Felicidades...!!");
					if(VentanaInicial.cambio==false) {
						VentanaInicial.winUser2++;
					}else if(VentanaInicial.cambio) {
						VentanaInicial.winUser1++;
					}
				}
				ventanaGanaste.setVisible(true);
				
			}else if(hayganador==false && intentos==9) {
				VentanaInicial.empates++;
				intentos=0;
				booleanIcono=true;
				VentanaEmpate ventanaEmpate=new VentanaEmpate();
				ventanaEmpate.setModal(true);
				ventanaEmpate.setVisible(true);
				
			}
			
		
		}
	};
	
	///////////MOSTRAR TABLA
	public ActionListener mostrarTabla=new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			VentanaMostrarResultados ventanaResultados=new VentanaMostrarResultados();
			ventanaResultados.setModal(true);
			ventanaResultados.setVisible(true);
		}
		
	
	};
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuego frame = new VentanaJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaJuego() {
		booleanIcono=true;
		intentos=0;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(620,650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(240,240,240));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExit = new JLabel();
		lblExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblExit.setIcon(new ImageIcon(new ImageIcon(VentanaJuego.class.getResource("/_9_Tres_En_Raya/Imagenes/exit2.png")).getImage().getScaledInstance(20, 20,Image.SCALE_SMOOTH)));
		lblExit.setBounds(580,4,20,20);
		contentPane.add(lblExit);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		menuBar.setBackground(new Color(71,71,71));
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mousePosX=e.getX();
				mousePosY=e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				dragg(e);
			}
			
		});
		
		JSeparator separatorTitle = new JSeparator();
		separatorTitle.setBackground(new Color(100, 149, 237));
		separatorTitle.setBounds(0, 28, 620, 2);
		contentPane.add(separatorTitle);
		
		menuBar.setBounds(0, 0, 620, 30);
		contentPane.add(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		mnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnMenu.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		mnMenu.setForeground(new Color(240,240,240));
		menuBar.add(mnMenu);
		
		JMenuItem mntmComenzarDeNuevo = new JMenuItem("Comenzar de Nuevo");
		mntmComenzarDeNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmComenzarDeNuevo.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		mntmComenzarDeNuevo.setIcon(new ImageIcon(VentanaJuego.class.getResource("/_9_Tres_En_Raya/Imagenes/refresh2.png")));
		mnMenu.add(mntmComenzarDeNuevo);
		mntmComenzarDeNuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicial.winUser1=0;
				VentanaInicial.winUser2=0;
				VentanaInicial.empates=0;
				VentanaComenzarDeNuevo ventanaComenzar=new VentanaComenzarDeNuevo();
				ventanaComenzar.setModal(true);
				ventanaComenzar.setVisible(true);
			}	
		});
		
		JMenuItem mntmTabla = new JMenuItem("Mostrar Tabla de Resultados");
		mntmTabla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmTabla.setIcon(new ImageIcon(VentanaJuego.class.getResource("/_9_Tres_En_Raya/Imagenes/table2.png")));
		mntmTabla.setFont(new Font("Lucida Sans", Font.PLAIN, 15));
		mnMenu.add(mntmTabla);
		mntmTabla.addActionListener(mostrarTabla);
		
		JSeparator separator = new JSeparator();
		mnMenu.add(separator);
		
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmSalir.setIcon(new ImageIcon(VentanaJuego.class.getResource("/_9_Tres_En_Raya/Imagenes/exit2.png")));
		mntmSalir.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
		mnMenu.add(mntmSalir);
		mntmSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
			
		});
		
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnAyuda.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		mnAyuda.setForeground(new Color(240,240,240));
		menuBar.add(mnAyuda);
		mnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Runtime.getRuntime().exec("C:\\Windows\\System32\\cmd.exe /K start https://ocio.uncomo.com/articulo/como-jugar-al-tres-en-raya-2442.html");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
		
		JButton btn1 = new JButton();
		
		JButton btn2 = new JButton();
		
		JButton btn3 = new JButton();

		JButton btn4 = new JButton();
		
		JButton btn5 = new JButton();
		
		JButton btn6 = new JButton();
	
		JButton btn7 = new JButton();
		
		JButton btn8 = new JButton();
		
		JButton btn9 = new JButton();
		
		botones= new JButton[][]{{btn1,btn2,btn3},{btn4,btn5,btn6},{btn7,btn8,btn9}};
		int x=0,y=30,cuadrado=200;
		for(int i=0;i<3;i++) {
			x=0;	
			for(int j=0;j<3;j++) {
				botones[i][j].setBounds(x, y, cuadrado, cuadrado);
				botones[i][j].setFocusPainted(false);
				botones[i][j].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				botones[i][j].setBorderPainted(false);
				botones[i][j].setBackground(new Color(51,51,51));
				
				botones[i][j].setName(""+i+""+j);
				contentPane.add(botones[i][j]);
				botones[i][j].addActionListener(selected);
				x+=210;
				
			}
			y+=210;
		}
	}
	
	
	
}
