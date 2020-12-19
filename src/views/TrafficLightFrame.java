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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
		gbl_contentPane.columnWeights = new double[]{5.0, 1.0};
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
		JScrollPane scrollPane = new JScrollPane(trafficLightsPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    contentPane.add(scrollPane, gbcLightsPanel);
		
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
				
				// Get trafficLight from list
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
			GridLayout layout = new GridLayout(1, 4);
			layout.setHgap(7);
			trafficLightPanel.setLayout(layout);
			trafficLightPanel.setPreferredSize(new Dimension(335, 80));
			GridBagConstraints gbcTrafficLight = new GridBagConstraints();
			gbcTrafficLight.insets = new Insets(3, 3, 3, 3);
			
			gbcTrafficLight.gridx = i % 3;
			gbcTrafficLight.gridy = i / 3;
			
			trafficLightsPanel.add(trafficLightPanel, gbcTrafficLight);
			
			JPanel redPanel = new RoundedPanel(200);
			redPanel.setBackground(Color.RED);;
			redPanel.setOpaque(false);
			redPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			trafficLightPanel.add(redPanel);
			
			JPanel yellowPanel = new RoundedPanel(200);
			yellowPanel.setBackground(Color.YELLOW);
			yellowPanel.setOpaque(false);
			trafficLightPanel.add(yellowPanel);
			
			JPanel greenPanel = new RoundedPanel(200);
			greenPanel.setBackground(Color.GREEN);
			greenPanel.setOpaque(false);
			trafficLightPanel.add(greenPanel);
			
			JButton btnCloseTrafficLight = new JButton("X");
			btnCloseTrafficLight.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					removeTrafficLight(trafficLightPanel);
				}
			});
			trafficLightPanel.add(btnCloseTrafficLight);
			
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
