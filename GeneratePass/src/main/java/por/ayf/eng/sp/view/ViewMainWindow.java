package por.ayf.eng.sp.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

import por.ayf.eng.sp.util.Util;
import por.ayf.eng.sp.view.comp.ComponentViewCreator;

/**
 *  Class will contain the JFrame of the main window.
 * 
 *  @author: Ángel Yagüe Flor.
 *  @version: 2.0.
 */

public class ViewMainWindow extends JFrame {
	private static final long serialVersionUID = 1L;	
	
	private JPanel contentPane;								
	private JMenuBar menuBar;								
	private JMenu jmFile;								
	private JMenuItem jmiNew;								
	private JMenuItem jmiLoad;							
	private JMenuItem jmiExit;								
	private JMenu jmHelp;									
	private JMenuItem mntmAbout;					
	private JButton newPass;								
	private JButton editPass;								
	private JButton consultPass;							
	private JButton deletePass;								
	private JScrollPane scrollPane;							
	private JList<String> list;								
	private static DefaultListModel<String> model;			
	
	private String url = null;											
	private boolean load = false;						
	
	public ViewMainWindow() {
		initComponents();
	}
	
	private void creator() {
		new ComponentViewCreator(this, true).setVisible(true);
	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/images/icon.png"));
		setTitle("SafePass");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 270);
		setLocationRelativeTo(null); // Center the view.
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Menu:
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 722, 21);
		contentPane.add(menuBar);
		
		jmHelp = new JMenu("Ayuda");
		menuBar.add(jmHelp);
		
		mntmAbout = new JMenuItem("Acerca de GeneratePass          ");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creator();
			}
		});
		mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		jmHelp.add(mntmAbout);
		
		// Buttons:
		
		newPass = new JButton("Crear");
		newPass.setBounds(420, 32, 119, 23);
		newPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		contentPane.add(newPass);
		
		editPass = new JButton("Editar");
		editPass.setBounds(420, 66, 119, 23);
		editPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		contentPane.add(editPass);
		
		consultPass = new JButton("Ver");
		consultPass.setBounds(420, 100, 119, 23);
		consultPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		contentPane.add(consultPass);
		
		deletePass = new JButton("Eliminar");
		deletePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		deletePass.setBounds(420, 134, 119, 23);
		contentPane.add(deletePass);
		
		// List:
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 400, 200);
		contentPane.add(scrollPane);
		
		model = new DefaultListModel<String>(); 
		list = new JList<String>(model);
		scrollPane.setViewportView(list);
		
		// See the content:
		setVisible(true);			 
	}
}

