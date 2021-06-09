package _9_Tres_En_Raya;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VentanaInicial extends JFrame {

	private JPanel contentPane;
	public static JTextField txtUser1;
	public static JTextField txtUser2;
	public static int winUser1=0;
	public static int winUser2=0;
	public static int empates=0;
	public static boolean cambio=false;
	private JLabel lblTextoForUser1;
	private JLabel lblTextoForUser2;
	private JButton btnComenzarJuego;
	private int xLbl;
	private int yLbl;
	
	private MouseListener click=new MouseAdapter() {
		public void mousePressed(MouseEvent e) {
			xLbl=e.getX();
			yLbl=e.getY();
			//System.out.println(xLbl+","+yLbl);
		}
	};
	
	private MouseMotionListener dragg=new MouseMotionAdapter() {
		@Override
		public void mouseDragged(MouseEvent event) {
			int xScreen=event.getXOnScreen();
			int yScreen=event.getYOnScreen();
			//System.out.println(xScreen+","+yScreen);
			
			setLocation(xScreen-xLbl, yScreen-yLbl);
			
		}
	};


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicial frame = new VentanaInicial();
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
	public VentanaInicial() {
		setUndecorated(true);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExit = new JLabel("");
		lblExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblExit.setIcon(new ImageIcon(VentanaInicial.class.getResource("/_9_Tres_En_Raya/Imagenes/exit30px.png")));
		lblExit.setBounds(450, 15, 30, 30);
		contentPane.add(lblExit);
		
		
		JLabel lblTitulo = new JLabel("3 En Raya");
		lblTitulo.setBackground(Color.DARK_GRAY);
		lblTitulo.setForeground(new Color(30, 30, 30));
		lblTitulo.setFont(new Font("Segoe Script", Font.BOLD, 70));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 50, 480, 80);
		contentPane.add(lblTitulo);
		
		JLabel lblUser1 = new JLabel("Usuario 1:");
		lblUser1.setForeground(new Color(30, 30, 30));
		lblUser1.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser1.setBounds(40, 156, 120, 30);
		lblUser1.setFont(new Font("Lucida Sans", Font.ITALIC, 20));
		contentPane.add(lblUser1);
		
		JLabel lblUser2 = new JLabel("Usuario 2:");
		lblUser2.setForeground(new Color(30, 30, 30));
		lblUser2.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser2.setBounds(40, 209, 120, 30);
		lblUser2.setFont(new Font("Lucida Sans", Font.ITALIC, 20));
		contentPane.add(lblUser2);
		
		txtUser1 = new JTextField();
		txtUser1.setForeground(new Color(255, 99, 71));
		txtUser1.setBorder(null);
		txtUser1.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser1.setBounds(170, 146, 280, 30);
		txtUser1.setFont(new Font("Malgun Gothic", 0, 20));
		txtUser1.setOpaque(false);
		//txtUser1.setBackground(new Color(250,250,250));
		contentPane.add(txtUser1);
		txtUser1.setColumns(10);
		
		txtUser2 = new JTextField();
		txtUser2.setForeground(new Color(120, 151, 205));
		txtUser2.setBorder(null);
		txtUser2.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser2.setBounds(170, 196, 280, 30);
		txtUser2.setFont(new Font("Malgun Gothic", 0, 20));
		txtUser2.setOpaque(false);
		//txtUser2.setBackground(null);
		contentPane.add(txtUser2);
		txtUser2.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(120, 151, 205));
		separator_2.setBounds(38, 288, 100, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(new Color(120, 151, 205));
		separator_4.setBounds(38, 260, 100, 2);
		contentPane.add(separator_4);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.WHITE);
		separator_3.setBounds(50, 478, 180, 2);
		contentPane.add(separator_3);
		
	
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBackground(Color.WHITE);
		separator_5.setBounds(50, 450, 180, 2);
		contentPane.add(separator_5);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFocusPainted(false);
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setForeground(new Color(255, 99, 71));
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setRolloverEnabled(false);
		btnGuardar.setRequestFocusEnabled(false);
		btnGuardar.setOpaque(false);
		btnGuardar.setBackground(null);
		btnGuardar.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblTextoForUser1.setText("Primer Movimiento: "+txtUser1.getText());
				lblTextoForUser2.setText("Segundo Movimiento: "+txtUser2.getText());
				btnComenzarJuego.setEnabled(true);
				
				btnGuardar.setForeground(new Color(255, 255, 255));
				separator_2.setBackground(new Color(255, 255, 255));
				separator_4.setBackground(new Color(255, 255, 255));
				
				btnComenzarJuego.setForeground(new Color(255, 99, 71));
				separator_3.setBackground(new Color(120,151,205));
				separator_5.setBackground(new Color(120,151,205));

			}
		});
		
		
		btnGuardar.setBounds(10, 260, 160, 30);
		contentPane.add(btnGuardar);
		
		btnComenzarJuego = new JButton("Comenzar Juego");
		btnComenzarJuego.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnComenzarJuego.setForeground(new Color(255, 255, 255));
		btnComenzarJuego.setBorderPainted(false);
		btnComenzarJuego.setContentAreaFilled(false);
		btnComenzarJuego.setOpaque(false);
		btnComenzarJuego.setBackground(null);
		btnComenzarJuego.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		btnComenzarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaJuego ventanaJuego=new VentanaJuego();
				ventanaJuego.setVisible(true);
				setVisible(false);//this=(VENTANA INICIAL)
			}
		});
		btnComenzarJuego.setBounds(30, 450, 224, 30);
		btnComenzarJuego.setEnabled(false);
		contentPane.add(btnComenzarJuego);
		
		lblTextoForUser1 = new JLabel();
		lblTextoForUser1.setForeground(new Color(255, 99, 71));
		lblTextoForUser1.setBounds(40, 337, 364, 25);
		lblTextoForUser1.setFont(new Font("Lucida Sans", Font.ITALIC, 22));
		contentPane.add(lblTextoForUser1);
		
		lblTextoForUser2 = new JLabel();
		lblTextoForUser2.setForeground(new Color(120, 151, 205));
		lblTextoForUser2.setBounds(40, 383, 364, 25);
		lblTextoForUser2.setFont(new Font("Lucida Sans", Font.ITALIC, 22));
		contentPane.add(lblTextoForUser2);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 255, 255));
		separator.setBounds(170, 174, 280, 55);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 255, 255));
		separator_1.setBounds(170, 227, 280, 2);
		contentPane.add(separator_1);
		
		JLabel lblOpacity = new JLabel();
		lblOpacity.setBounds(175, 146, 270, 30);
		lblOpacity.setOpaque(true);
		lblOpacity.setBackground(new Color(255,255,255,20));
		contentPane.add(lblOpacity);
		
		JLabel lblOpacity2 = new JLabel();
		lblOpacity2.setOpaque(true);
		lblOpacity2.setBackground(new Color(255,255,255,20));
		lblOpacity2.setBounds(175, 196, 270, 30);
		contentPane.add(lblOpacity2);
		
		
		
	
		
		JLabel imagen = new JLabel();
		imagen.setForeground(new Color(248, 248, 255));
		imagen.setOpaque(true);
		imagen.setBackground(new Color(230, 230, 230));
		imagen.setBounds(5, 5, 490, 590);
		imagen.setIcon(new ImageIcon(new ImageIcon(VentanaInicial.class.getResource("/_9_Tres_En_Raya/Imagenes/tres2.png")).getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(imagen);
		imagen.addMouseListener(click);
		imagen.addMouseMotionListener(dragg);
		
	}
}
