package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JDialogUPTC extends JDialog {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public JDialogUPTC(JFrame parent) {
	        super(parent, "Diálogo Personalizado", true);
	        setLayout(new BorderLayout());
	        
	        JPanel panel = new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                Graphics2D g2d = (Graphics2D) g;
	                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	                
	                // Dibujar un círculo
	                int circleDiameter = 100;
	                int x = (getWidth() - circleDiameter) / 2;
	                int y = (getHeight() - circleDiameter) / 2;
	                Ellipse2D.Double circle = new Ellipse2D.Double(x, y, circleDiameter, circleDiameter);
	                g2d.setColor(Color.BLUE);
	                g2d.fill(circle);
	            }
	        };
	        
	        panel.setPreferredSize(new Dimension(300, 200));
	        add(panel, BorderLayout.CENTER);
	        
	        JButton closeButton = new JButton("Cerrar");
	        closeButton.addActionListener(e -> dispose());
	        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        buttonPanel.add(closeButton);
	        add(buttonPanel, BorderLayout.SOUTH);
	        
	        pack();
	        setLocationRelativeTo(parent);
	        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    }
	

	public static void main(String[] args) {
		
	
	        SwingUtilities.invokeLater(() -> {
	            JFrame frame = new JFrame("Ejemplo de JDialog");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setSize(400, 300);
	            frame.setLocationRelativeTo(null);

	            JButton showDialogButton = new JButton("Mostrar Diálogo");
	            showDialogButton.addActionListener(e -> {
	            	JDialogUPTC dialog = new JDialogUPTC(frame);
	                dialog.setVisible(true);
	            });

	            frame.add(showDialogButton, BorderLayout.CENTER);
	            frame.setVisible(true);
	        });
	    }

}
