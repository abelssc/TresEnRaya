package _9_Tres_En_Raya;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class VentanaMostrarResultados extends JDialog {
	private JTable table;
	private int x;
	private int y;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaMostrarResultados dialog = new VentanaMostrarResultados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaMostrarResultados() {
		setUndecorated(true);
		setSize(640,290);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(255,255,255));
		getContentPane().setLayout(null);
		
		JLabel lblVentanaDeResultados = new JLabel("Ventana de resultados");
		lblVentanaDeResultados.setBounds(10, 20, 624, 40);
		lblVentanaDeResultados.setForeground(new Color(255, 99, 71));
		lblVentanaDeResultados.setFont(new Font("Segoe Script", Font.PLAIN, 36));
		lblVentanaDeResultados.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblVentanaDeResultados);
		
		/*---------------------------TABLA--------------------------------------*/
		JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBorder(null);NO FUNCIONA
		scrollPane.setBounds(10, 88, 620, 150);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());//ESTE SI
		getContentPane().add(scrollPane);
		
		DefaultTableModel modelo=new DefaultTableModel();
		if(VentanaInicial.cambio) {
			modelo.addColumn("<html><body>N° de Victorias de <br>"+VentanaInicial.txtUser2.getText()+"</body></html>");
			modelo.addColumn("<html><body>N° de victorias de <br>"+VentanaInicial.txtUser1.getText()+"</body></html>");
		}else if(VentanaInicial.cambio==false) {
			modelo.addColumn("<html><body>N° de victorias de <br>"+VentanaInicial.txtUser1.getText()+"</body></html>");
			modelo.addColumn("<html><body>N° de Victorias de <br>"+VentanaInicial.txtUser2.getText()+"</body></html>");
		}	
		modelo.addColumn("N° de Empates");
		modelo.addRow(new String[] {""+VentanaInicial.winUser1,""+VentanaInicial.winUser2,""+VentanaInicial.empates});
	
		
		table = new JTable(modelo) {
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		};
		table.isCellEditable(0, 0);
		table.isCellEditable(0, 1);
		table.isCellEditable(0, 2);

		table.setCellSelectionEnabled(true);//permite que solo una celda sea seleccionada a la vez
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionForeground(new Color(240, 248, 255));
		table.setForeground(new Color(232, 232, 232));
		table.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 20));
		//table.setOpaque(false);
		table.setBackground(new Color(0,0,0,.6f));
		table.setRowHeight(60);
		table.setEnabled(false);
		
		table.setShowGrid(false);
		
	//	table.getTableHeader().setBorder(null); *NOT FUNK
		table.getTableHeader().setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(255,255,255,60)));
		
		//table.getTableHeader().setBorder(BorderFactory.createMatteBorder(top, left, bottom, right, color));
		//table.getTableHeader().setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		//table.getTableHeader().setBorder(BorderFactory.createEmptyBorder(2,2,1,2));
		table.getTableHeader().setEnabled(false);
		table.getTableHeader().setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 15));
		table.getTableHeader().setForeground(new Color(255, 99, 71));
		table.getTableHeader().setBackground(new Color(0,0,0,.6f));//ELIINAR EL BACKGROUND Y PONER UNA MANTA OSCURA
		//table.getTableHeader().setBackground(new Color(0,true));//ELIMINAR EL BACKGROUDN
	
		//table.getTableHeader().setOpaque(false);
		table.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 80));//ALTO AL  HEADER DEL JTABLE
		

		
		DefaultTableCellRenderer cellStyles =new DefaultTableCellRenderer();
		cellStyles.setHorizontalAlignment(SwingConstants.CENTER);
		//cellStyles.setBorder(null);
		cellStyles.setOpaque(false);
	
		table.getTableHeader().setDefaultRenderer(cellStyles);//SE LE APLICA LAS PROPIEDADES DE CELLSTYLES
		
		//table.getColumn("<html><body>N° de Victorias de <br>asdasdasdas</body></html>").setCellRenderer(cellStyles);
		//table.getColumn("N° de victorias de ").setCellRenderer(cellStyles);
		table.getColumn("N° de Empates").setCellRenderer(cellStyles);//get column busca la collumna con el nombre indicado
		table.getColumnModel().getColumn(0).setCellRenderer(cellStyles);//getcolumn model me devuelve el vector de la columna
		table.getColumnModel().getColumn(1).setCellRenderer(cellStyles);//getcolumn+getcolumn me devuelve la columna con la pos indicada
		
		
		
		scrollPane.setViewportView(table);
		
		/*--------------------------------------------END TABLA--------------------------------*/
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setForeground(new Color(240, 255, 240));
		btnRegresar.setBorder(null);
		btnRegresar.setContentAreaFilled(false);
		btnRegresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegresar.setFont(new Font("Segoe Script", Font.PLAIN, 20));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnRegresar.setFocusPainted(false);
		btnRegresar.setBounds(480, 240, 150, 30);
		getContentPane().add(btnRegresar);
		btnRegresar.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegresar.setForeground(new Color(255,99,71));
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnRegresar.setForeground(new Color(240, 255, 240));
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(176, 196, 222));
		separator.setBounds(480, 268, 150, 2);
		getContentPane().add(separator);
		
		JLabel lblBackground = new JLabel();
		lblBackground.setIcon(new ImageIcon(VentanaMostrarResultados.class.getResource("/_9_Tres_En_Raya/Imagenes/tictactoe.jpg")));
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x=e.getX();
				y=e.getY();
			}
		});
		lblBackground.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xScreen=e.getXOnScreen();
				int yScreen=e.getYOnScreen();
				setLocation(xScreen-x,yScreen-y);
			}
		});
		
		lblBackground.setOpaque(true);
		lblBackground.setBackground(new Color(19,21,25));
		lblBackground.setBounds(5, 5, 630, 280);
		getContentPane().add(lblBackground);
	}

}
