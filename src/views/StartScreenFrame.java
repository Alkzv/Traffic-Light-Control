package views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import views.TrafficLightFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StartScreenFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreenFrame frame = new StartScreenFrame();
					frame.setLocationRelativeTo(null);
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
	public StartScreenFrame() {
		setTitle("Start");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInstancesQuestion = new JLabel("How  many instances of traffic light do you want");
		lblInstancesQuestion.setBounds(60, 106, 378, 15);
		contentPane.add(lblInstancesQuestion);
		
		JComboBox<Integer> cmbInstancesSelect = new JComboBox<Integer>();
		cmbInstancesSelect.setBounds(60, 144, 87, 24);
		// Add numbers to select in comboBox
		for (int i = 1; i <= 6; i++) {
			cmbInstancesSelect.addItem(i);
		}
		contentPane.add(cmbInstancesSelect);
		
		JButton btnStartInstaces = new JButton("START");
		btnStartInstaces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Close StartScreenFrame				
				dispose();
				
				// Repeat n times based on selected number by the user
				for(int i = 0; i < Integer.valueOf((Integer)cmbInstancesSelect.getSelectedItem()); i++) {

					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					int dividedScreenWidth = (int) screenSize.getWidth() / 3;
					int dividedScreenHeight = (int) screenSize.getHeight() / 2;
					
					TrafficLightFrame trafficLightFrame = new TrafficLightFrame();
					trafficLightFrame.setTitle("Traffic Light " + (i + 1));
					if(i < 3) {
						trafficLightFrame.setBounds(
								(dividedScreenWidth * i)+100, dividedScreenHeight - 300, 250, 300);
					} else {
						trafficLightFrame.setBounds(
								(dividedScreenWidth * (i-3))+100, dividedScreenHeight + 20, 250, 300);
					}

					// Open new TrafficLightFrame
					trafficLightFrame.setVisible(true);
				}

			}
		});
		btnStartInstaces.setBounds(173, 226, 117, 25);
		contentPane.add(btnStartInstaces);
	}
}
