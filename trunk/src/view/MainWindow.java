package view;

import model.image.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Point;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JPanelWithFilters jContentPane = null;
	private JTextField jTextFieldFoto = null;
	private JLabel jLabelFoto = null;
	private JButton jButtonAbrir = null;
	private JButton jButtonFiltro1 = null;
	private JButton jButtonFiltro2 = null;
	private JButton jButtonFiltro3 = null;
	private JButton jButtonDeshacer = null;
	private JButton jButtonAlmacenar = null;
	private JButton jButtonSimilar = null;
	private JButton jButtonBinarizar = null;
	private JButton jButtonDarken = null;

	public static void main(	String[] args	){
		
		//Create the frame.
		MainWindow frame = new MainWindow();
		
		//What happens when it closes
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		//Show it
		frame.setVisible(true);
	
	}

	public MainWindow(){
		
		super();
		initialize();
	
	}

	
	private void initialize(){
		
		this.setSize(1000, 750);
		
		this.setContentPane(getJContentPane());
		
		this.setTitle("Ey ey fierita ete e el proyecto toson");
	
	}

	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			
			jLabelFoto = new JLabel();
			jLabelFoto.setBounds(new Rectangle(41, 21, 228, 22));
			jLabelFoto.setText("Ingrese la foto en jpg a procesar sin la extension");
			jContentPane = new JPanelWithFilters();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextFieldFoto(), null);
			jContentPane.add(jLabelFoto, null);
			jContentPane.add(getJButtonAbrir(), null);
			jContentPane.add(getJButtonFiltro1(), null);
			jContentPane.add(getJButtonFiltro2(), null);
			jContentPane.add(getJButtonFiltro3(), null);
			jContentPane.add(getJButtonDeshacer(), null);
			jContentPane.add(getJButtonAlmacenar(), null);
			jContentPane.add(getJButtonSimilar(), null);
			jContentPane.add(getJButtonBinarizar(), null);
			jContentPane.add(getJButtonDarken(), null);
			
			// Initialize with a img
			jContentPane.loadImage( "duchenne1.jpg" );
			
		}
		
		return jContentPane;

	}

	
	private JTextField getJTextFieldFoto() {
		if (jTextFieldFoto == null) {
			jTextFieldFoto = new JTextField();
			jTextFieldFoto.setBounds(new Rectangle(39, 54, 230, 28));
		}
		return jTextFieldFoto;
	}

	
	private JButton getJButtonAbrir() {
		if (jButtonAbrir == null) {
			jButtonAbrir = new JButton();
			jButtonAbrir.setBounds(new Rectangle(284, 57, 152, 25));
			jButtonAbrir.setText("Abrir");
			jButtonAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
				
					String foto=jTextFieldFoto.getText();
					
					jContentPane.loadImage( foto + ".jpg" ); //TODO no funca esto todavia
					
					jContentPane.repaint();
				
				}
			});
		}
		return jButtonAbrir;
	}

	
	private JButton getJButtonFiltro1() {
		if (jButtonFiltro1 == null) {
			jButtonFiltro1 = new JButton();
			jButtonFiltro1.setText("Sharpen");
			jButtonFiltro1.setLocation(new Point(789, 165));
			jButtonFiltro1.setSize(new Dimension(120, 26));
			jButtonFiltro1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					
					jContentPane.sharpen();
					jContentPane.applyFilter();
					jContentPane.repaint();
					
					System.out.println("mouseClicked() on Sharpen"); 
				
				}
			});
		}
		return jButtonFiltro1;
	}

	
	private JButton getJButtonFiltro2() {
		if (jButtonFiltro2 == null) {
			jButtonFiltro2 = new JButton();
			jButtonFiltro2.setText("Low Filter");
			jButtonFiltro2.setSize(new Dimension(120, 26));
			jButtonFiltro2.setLocation(new Point(789, 301));
			jButtonFiltro2.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					
					jContentPane.lowFilter();
					jContentPane.applyFilter();
					jContentPane.repaint();
					
					System.out.println("mouseClicked() on Low Filter"); 
				}
			});
		}
		return jButtonFiltro2;
	}

	private JButton getJButtonFiltro3() {
		if (jButtonFiltro3 == null) {
			jButtonFiltro3 = new JButton();
			jButtonFiltro3.setText("Smooth");
			jButtonFiltro3.setSize(new Dimension(120, 26));
			jButtonFiltro3.setLocation(new Point(789, 441));
			jButtonFiltro3.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					
					jContentPane.smooth();
					jContentPane.applyFilter();
					jContentPane.repaint();
					
					System.out.println("mouseClicked() on Smooth"); 
				}
			});
		}
		return jButtonFiltro3;
	}

	private JButton getJButtonDarken() {
		if (jButtonDarken == null) {
			jButtonDarken = new JButton();
			jButtonDarken.setText("Darken");
			jButtonDarken.setSize(new Dimension(120, 26));
			jButtonDarken.setLocation(new Point(789, 561));
			jButtonDarken.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
										
					jContentPane.darkenLUT();
					jContentPane.applyFilterWithLookUpTable();
					jContentPane.repaint();
					
					System.out.println("mouseClicked() on Darken"); 
				}
			});
		}
		return jButtonDarken;
	}

	
	private JButton getJButtonDeshacer() {
		if (jButtonDeshacer == null) {
			jButtonDeshacer = new JButton();
			jButtonDeshacer.setText("Deshacer");
			jButtonDeshacer.setSize(new Dimension(152, 25));
			jButtonDeshacer.setLocation(new Point(585, 57));
			jButtonDeshacer.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					
					jContentPane.reset();
					jContentPane.repaint();
					
					System.out.println("mouseClicked() on deshacer"); 
				
				}
			});
		}
		return jButtonDeshacer;
	}
	
	private JButton getJButtonBinarizar() {
		if (jButtonBinarizar == null) {
			jButtonBinarizar = new JButton();
			jButtonBinarizar.setText("Binarizar");
			jButtonBinarizar.setSize(new Dimension(152, 25));
			jButtonBinarizar.setLocation(new Point(785, 57));
			jButtonBinarizar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					
					jContentPane.binarizeLUT();
					jContentPane.applyFilterWithLookUpTable();
					jContentPane.repaint();
					
					System.out.println("mouseClicked() on binarizar"); 
				
				}
			});
		}
		return jButtonBinarizar;
	}


	
	private JButton getJButtonAlmacenar() {
		if (jButtonAlmacenar == null) {
			jButtonAlmacenar = new JButton();
			jButtonAlmacenar.setText("Almacenar");
			jButtonAlmacenar.setLocation(new Point(97, 677));
			jButtonAlmacenar.setSize(new Dimension(184, 28));
			jButtonAlmacenar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.out.println("mouseClicked()"); 
				}
			});
		}
		return jButtonAlmacenar;
	}


	private JButton getJButtonSimilar() {
		if (jButtonSimilar == null) {
			jButtonSimilar = new JButton();
			jButtonSimilar.setText("Similar");
			jButtonSimilar.setSize(new Dimension(184, 28));
			jButtonSimilar.setLocation(new Point(397, 677));
			jButtonSimilar.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.out.println("mouseClicked()"); 
				}
			});
		}
		return jButtonSimilar;
	}
	
	

}  