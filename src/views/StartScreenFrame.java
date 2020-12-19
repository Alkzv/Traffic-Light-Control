package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HelpDialog helpDialog = new HelpDialog();
				
				helpDialog.setVisible(true);
			}
		});
		mnHelp.add(mntmHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutDialog aboutDialog = new AboutDialog();
				
				aboutDialog.setVisible(true);
			}
		});
		menuBar.add(mntmAbout);

		
		JLabel lblInstancesQuestion = new JLabel("How  many instances of traffic light do you want");
		lblInstancesQuestion.setBounds(60, 106, 378, 15);
		contentPane.add(lblInstancesQuestion);
		
		JComboBox<Integer> cmbInstancesSelect = new JComboBox<Integer>();
		cmbInstancesSelect.setBounds(60, 144, 87, 24);
		// Add numbers to comboBox
		for (int i = 1; i <= 10; i++) {
			cmbInstancesSelect.addItem(i);
		}
		contentPane.add(cmbInstancesSelect);
		
		JButton btnStartInstaces = new JButton("START");
		btnStartInstaces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Close StartScreenFrame				
				dispose();
				TrafficLightFrame trafficLightFrame = new TrafficLightFrame();
				int selectedNumber = Integer.valueOf((Integer)cmbInstancesSelect.getSelectedItem());
				trafficLightFrame.generateTrafficLight(selectedNumber);
				
				// Open new TrafficLightFrame
				trafficLightFrame.setVisible(true);
			}
		});
		btnStartInstaces.setBounds(250, 144, 117, 25);
		contentPane.add(btnStartInstaces);
	}
}
