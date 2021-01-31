package por.ayf.eng.gp.view.comp;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import por.ayf.eng.gp.util.Util;
import por.ayf.eng.gp.view.ViewMainWindow;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

/**
 *  JDialog generate a new password with different settings.
 * 
 *  @author: Ángel Yagüe Flor.
 *  @version: 1.0.
 */

public class ComponentViewGenerate extends JDialog {
	private static final long serialVersionUID = 1L; 	

	private JPasswordField pfPassword;
	private final JPanel contentPanel = new JPanel(); 	
	
	private JLabel lblOptionsText;							
	private JCheckBox cbMayus;
	private JCheckBox cbSpecial;
	private JCheckBox cbNumber;
	private JLabel lblNumber;
	private JTextField tfNumber;
	private JButton btnGenerate;
	
	private String characters = "abcdefghijklmnopqrstuvwxyz";
	private String mayusCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String numberCharacters = "0123456789";
	private String specialCharacters = "@%+!#$^?:.(){}[]~-_`";
	
	public ComponentViewGenerate(ViewMainWindow ventana, boolean modal, JPasswordField pfPassword) {
		super(ventana, modal);
		this.pfPassword = pfPassword;
		initComponents();
	}
	
	private void generate() {
		int size = 0;
		
		try {
			size = Integer.parseInt(tfNumber.getText());
			
			if(size >= 50) {
				size = 50;
			}
		} catch(NumberFormatException e) {
			Util.showMessage(ComponentViewGenerate.class, "Ha ocurrido un error. Debe introducir un número para el tamaño de la contraseña.", JOptionPane.ERROR_MESSAGE, e);
			return;
		}
		
		manageSettings();
		buildPassword(size);
	}
	
	private void manageSettings() {
		if(cbMayus.isSelected()) {
			characters += mayusCharacters;
		}
		
		if(cbSpecial.isSelected()) {
			characters += specialCharacters;
		}
		
		if(cbNumber.isSelected()) {
			characters += numberCharacters;
		}
	}
	
	private void buildPassword(int size) {
		String password = "";
		Random randomGenerator = new Random();
		
		for(int i = 0; i < size; i++) {
			int numberRandom = randomGenerator.nextInt(characters.length());
			password += characters.charAt(numberRandom);
		}
		
		pfPassword.setText(password);
	}
	
	private void initComponents() {
		setTitle("Generar contraseña");
		setBounds(100, 100, 250, 250);
		setLocationRelativeTo(null); 		// Center the view.
		setResizable(false); 				// Cannot Resizable.
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	
		lblOptionsText = new JLabel("Opciones de generación");
		lblOptionsText.setBounds(11, 11, 222, 19);
		lblOptionsText.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblOptionsText);
		
		cbMayus = new JCheckBox("Mayúsculas");
		cbMayus.setBounds(11, 40, 222, 23);
		cbMayus.setHorizontalAlignment(SwingConstants.LEFT);
		contentPanel.add(cbMayus);
		
		cbSpecial = new JCheckBox("Caracteres especiales");
		cbSpecial.setBounds(11, 66, 222, 23);
		cbSpecial.setHorizontalAlignment(SwingConstants.LEFT);
		contentPanel.add(cbSpecial);
		
		cbNumber = new JCheckBox("Números");
		cbNumber.setBounds(11, 92, 222, 23);
		cbNumber.setHorizontalAlignment(SwingConstants.LEFT);
		contentPanel.add(cbNumber);
		
		lblNumber = new JLabel("Número de caracteres:");
		lblNumber.setBounds(11, 122, 222, 14);
		contentPanel.add(lblNumber);

		tfNumber = new JTextField();
		tfNumber.setBounds(11, 147, 222, 20);
		tfNumber.setColumns(10);
		contentPanel.add(tfNumber);
		
		btnGenerate = new JButton("Generar");
		btnGenerate.setBounds(11, 187, 222, 23);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generate();
				dispose();
			}
		});
		contentPanel.add(btnGenerate);	
	}
}
