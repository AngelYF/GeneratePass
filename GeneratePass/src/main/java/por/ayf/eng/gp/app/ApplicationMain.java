package por.ayf.eng.gp.app;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import por.ayf.eng.gp.util.Util;
import por.ayf.eng.gp.view.ViewMainWindow;

/**
 *  Main class will execute the application.
 * 
 *  @author: Ángel Yagüe Flor.
 *  @version: 2.1.
 */

public class ApplicationMain {
	public static void main(String[] args) {
		try { // This try-catch will change the regular aparence of JFrame of Java.
//	        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 				// Other type of view.
//	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  		// Other.
//	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  	// Other.
//	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");  		// Other.
			
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 				// By defect.
	        new ViewMainWindow(); 
        } catch (Exception e) {
			Util.showMessage(ViewMainWindow.class, "Ha ocurrido un error al iniciar la aplicación.", JOptionPane.ERROR_MESSAGE, e);
        } 
	}
}
