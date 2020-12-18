package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Panel;
import java.awt.GridLayout;
import javax.swing.JButton;

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
		panel.setBounds(28, 10, 136, 243);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 1));
		
		Panel panel_2 = new Panel();
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnRedLight = new JButton("New button");
		btnRedLight.setBounds(12, 44, 117, 25);
		btnRedLight.setBorder(new RoundedBorder(10));
		panel_2.add(btnRedLight);
		
		Panel panel_3 = new Panel();
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnYellowLight = new JButton("New button");
		btnYellowLight.setBounds(12, 44, 117, 25);
		panel_3.add(btnYellowLight);
		
		Panel panel_1 = new Panel();
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnGreenLight = new JButton("New button");
		btnGreenLight.setBounds(12, 30, 117, 25);
		panel_1.add(btnGreenLight);
	}
}
