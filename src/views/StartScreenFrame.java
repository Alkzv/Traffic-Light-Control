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
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
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
				TrafficLightFrame trafficLightFrame = new TrafficLightFrame();
				int selectedNumber = Integer.valueOf((Integer)cmbInstancesSelect.getSelectedItem());
				trafficLightFrame.generateTrafficLight(selectedNumber);
				
				// Open new TrafficLightFrame
				trafficLightFrame.setVisible(true);
			}
		});
		btnStartInstaces.setBounds(173, 226, 117, 25);
		contentPane.add(btnStartInstaces);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
