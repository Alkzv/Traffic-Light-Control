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
				
				removeTrafficLight(trafficLight);
			}
		});
		btnRemoveTrafficLight.setBounds(15, 125, 150, 40);
		actionsPanel.add(btnRemoveTrafficLight);
	}
	
	public void generateTrafficLight(int quantity) {
		int trafficLightsQuantity = trafficLightsList.size();
		
		for(int i = trafficLightsQuantity; i < quantity + trafficLightsQuantity; i++) {
			JPanel trafficLightPanel = new JPanel();
			trafficLightPanel.setBackground(Color.BLACK);
			GridBagLayout gblTrafficLightPanel = new GridBagLayout();
			gblTrafficLightPanel.columnWeights = new double[]{1.0, 1.0, 1.0};
			gblTrafficLightPanel.rowWeights = new double[]{1.0};
			trafficLightPanel.setLayout(gblTrafficLightPanel);
			trafficLightPanel.setPreferredSize(new Dimension(300, 80));
			GridBagConstraints gbcTrafficLight = new GridBagConstraints();
			gbcTrafficLight.insets = new Insets(3, 3, 3, 3);
			
			gbcTrafficLight.gridx = i % 3;
			gbcTrafficLight.gridy = i / 3;
			
			trafficLightsPanel.add(trafficLightPanel, gbcTrafficLight);
			
			JPanel redPanel = new RoundedPanel(200);
			redPanel.setBackground(Color.RED);;
			redPanel.setOpaque(false);
			GridBagConstraints gbcRedPanel = new GridBagConstraints();
			gbcRedPanel.insets = new Insets(10, 10, 10, 10);
			gbcRedPanel.fill = GridBagConstraints.BOTH;
			gbcRedPanel.gridx = 0;
			gbcRedPanel.gridy = 0;
			trafficLightPanel.add(redPanel, gbcRedPanel);
			
			JPanel yellowPanel = new RoundedPanel(200);
			yellowPanel.setBackground(Color.YELLOW);
			yellowPanel.setOpaque(false);
			GridBagConstraints gbcYellowPanel = new GridBagConstraints();
			gbcYellowPanel.insets = new Insets(10, 10, 10, 10);
			gbcYellowPanel.fill = GridBagConstraints.BOTH;
			gbcYellowPanel.gridx = 1;
			gbcYellowPanel.gridy = 0;
			trafficLightPanel.add(yellowPanel, gbcYellowPanel);
			
			JPanel greenPanel = new RoundedPanel(200);
			greenPanel.setBackground(Color.GREEN);
			greenPanel.setOpaque(false);
			GridBagConstraints gbcGreenPanel = new GridBagConstraints();
			gbcGreenPanel.insets = new Insets(10, 10, 10, 10);
			gbcGreenPanel.fill = GridBagConstraints.BOTH;
			gbcGreenPanel.gridx = 2;
			gbcGreenPanel.gridy = 0;
			trafficLightPanel.add(greenPanel, gbcGreenPanel);
			
			JButton btnCloseTrafficLight = new JButton("X");
			btnCloseTrafficLight.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					removeTrafficLight(trafficLightPanel);
				}
			});
			GridBagConstraints gbcCloseButton = new GridBagConstraints();
			gbcCloseButton.insets = new Insets(3, 3, 3, 3);
			gbcCloseButton.gridx = 3;
			gbcCloseButton.gridy = 0;
			trafficLightPanel.add(btnCloseTrafficLight, gbcCloseButton);
			
			trafficLightsList.add(trafficLightPanel);
		}
	}
	
	public void removeTrafficLight(JPanel trafficLight) {
		// Remove trafficLight from List
		trafficLightsList.remove(trafficLight);
		// Remove trafficLight from Panel
		trafficLightsPanel.remove(trafficLight);
		
		// Update the Panel
		trafficLightsPanel.revalidate();
		trafficLightsPanel.repaint();
	}
}
