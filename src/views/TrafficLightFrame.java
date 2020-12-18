package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import components.RoundedPanel;

import java.awt.Color;
import java.awt.Panel;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class TrafficLightFrame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public TrafficLightFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 10, 250, 82);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 3));
		
		JPanel redPanel = new RoundedPanel(200);
		redPanel.setBackground(Color.RED);;
		redPanel.setOpaque(false);
		panel.add(redPanel);
		
		JPanel yellowPanel = new RoundedPanel(200);
		yellowPanel.setBackground(Color.YELLOW);
		yellowPanel.setOpaque(false);
		panel.add(yellowPanel);
		
		JPanel greenPanel = new RoundedPanel(200);
		greenPanel.setBackground(Color.GREEN);
		greenPanel.setOpaque(false);
		panel.add(greenPanel);
		

	}
}
