package por.ayf.eng.gp.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import por.ayf.eng.gp.view.comp.ComponentViewCreator;
import javax.swing.JCheckBox;

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
	private JMenu jmHelp;									
	private JMenuItem mntmAbout;					
	private JButton btnGenerate;							
	private JButton btnCopy;																
	private JPasswordField pfPassword;
	private JCheckBox cbShow;
	
	public ViewMainWindow() {
		initComponents();
	}
	
	private void creator() {
		new ComponentViewCreator(this, true).setVisible(true);
	}
	
	private void generatePassword() {
		new ComponentViewCreator(this, true).setVisible(true);
	}
	
	private void copyPassword() {
		if(!(pfPassword.getPassword().length == 0)) {
			StringSelection text = new StringSelection(new String(pfPassword.getPassword()));
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(text, null);
		}
	}
	
	private void showPassword() {
		if(pfPassword.getEchoChar() == (char) 0) { // If is hide.
			pfPassword.setEchoChar('*');
			cbShow.setText("Mostrar");
		} else {									
			pfPassword.setEchoChar((char) 0);
			cbShow.setText("Ocultar");
		}
	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/images/icon.png"));
		setTitle("GeneratePass");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 150);
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
		
		btnGenerate = new JButton("Generar");
		btnGenerate.setBounds(10, 87, 130, 23);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		contentPane.add(btnGenerate);
		
		btnCopy = new JButton("Copiar");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				copyPassword();
			}
		});
		btnCopy.setBounds(154, 87, 130, 23);
		contentPane.add(btnCopy);
		
		pfPassword = new JPasswordField();
		pfPassword.setText("Prueba");
		pfPassword.setEchoChar('*');
		pfPassword.setEnabled(false);
		pfPassword.setBounds(10, 32, 274, 20);
		contentPane.add(pfPassword);
		pfPassword.setColumns(10);
		
		cbShow = new JCheckBox("Mostrar");
		cbShow.setBounds(10, 59, 274, 23);
		cbShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPassword();
			}
		});
		contentPane.add(cbShow);
		
		// See the content:
		setVisible(true);			 
	}
}

