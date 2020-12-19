package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import components.RoundedPanel;

@SuppressWarnings("serial")
public class TrafficLightFrame extends JFrame {

	private JPanel contentPane;
    private JPanel trafficLightsPanel;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ArrayList<JPanel> trafficLightsList = new ArrayList<>();

	/**
	 * Create the frame.
	 */
	public TrafficLightFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Traffic Lights");
	    setSize(screenSize.width, screenSize.height);
	    contentPane = new JPanel();
	    contentPane.setBackground(Color.WHITE);
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[]{3.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0};
		contentPane.setLayout(gbl_contentPane);
		setContentPane(contentPane);
		
		trafficLightsPanel = new JPanel();
		trafficLightsPanel.setBackground(Color.LIGHT_GRAY);
		GridBagLayout gblLightsPanel = new GridBagLayout();
		gblLightsPanel.columnWeights = new double[]{};
		gblLightsPanel.rowWeights = new double[]{};
		trafficLightsPanel.setLayout(gblLightsPanel);
		
		GridBagConstraints gbcLightsPanel = new GridBagConstraints();
		gbcLightsPanel.insets = new Insets(5, 5, 10, 5);
		gbcLightsPanel.fill = GridBagConstraints.BOTH;
		gbcLightsPanel.gridx = 0;
		gbcLightsPanel.gridy = 0;
		contentPane.add(trafficLightsPanel, gbcLightsPanel);
		
		JPanel actionsPanel = new JPanel();
		actionsPanel.setLayout(null);
		actionsPanel.setPreferredSize(new Dimension(300, 800));
		GridBagConstraints gbcActionsPanel = new GridBagConstraints();
		gbcActionsPanel.insets = new Insets(5, 5, 10, 5);
		gbcActionsPanel.fill = GridBagConstraints.BOTH;
		gbcActionsPanel.gridx = 1;
		gbcActionsPanel.gridy = 0;
		contentPane.add(actionsPanel, gbcActionsPanel);
		
		JLabel lblInstruction = new JLabel("Traffic Light Controller");
		lblInstruction.setBounds(10, 25, 300, 15);
		actionsPanel.add(lblInstruction);
		
		JButton btnAddTrafficLight = new JButton("ADD ONE");
		btnAddTrafficLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generateTrafficLight(1);

				trafficLightsPanel.revalidate();
				trafficLightsPanel.repaint();
			}
		});
		btnAddTrafficLight.setBounds(15, 75, 150, 40);
		actionsPanel.add(btnAddTrafficLight);
		
		JButton btnRemoveTrafficLight = new JButton("REMOVE ONE");
		btnRemoveTrafficLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JPanel trafficLight = trafficLightsList.get(trafficLightsList.size() - 1);
				trafficLightsList.remove(trafficLightsList.size() - 1);
				
				trafficLightsPanel.remove(trafficLight);
				
				trafficLightsPanel.revalidate();
				trafficLightsPanel.repaint();
			}
		});
		btnRemoveTrafficLight.setBounds(15, 125, 150, 40);
		actionsPanel.add(btnRemoveTrafficLight);
	}
	
	public void generateTrafficLight(int quantity) {
		int trafficLightsQuantity = trafficLightsList.size();
		
		for(int i =  trafficLightsQuantity; i < quantity + trafficLightsQuantity; i++) {
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setLayout(new GridLayout(1, 3));
			panel.setPreferredSize(new Dimension(300, 80));
			GridBagConstraints gbcTrafficLight = new GridBagConstraints();
			gbcTrafficLight.insets = new Insets(3, 3, 3, 3);
			System.out.println(trafficLightsList.size());
			if(i < 3) { 
				// Fill the first row
				gbcTrafficLight.gridx = i;
				gbcTrafficLight.gridy = 0;
			} else {
				// Fill the second row
				gbcTrafficLight.gridx = i-3;
				gbcTrafficLight.gridy = 1;
			}
	
			trafficLightsPanel.add(panel, gbcTrafficLight);
			
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
			
			JButton btnCloseTrafficLight = new JButton("X");
			panel.add(btnCloseTrafficLight);
			
			trafficLightsList.add(panel);
		}
	}
}
