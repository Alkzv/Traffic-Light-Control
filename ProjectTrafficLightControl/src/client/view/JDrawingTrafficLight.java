/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import Enums.TrafficLightState;

/**
 *
 * @author PC
 */
public class JDrawingTrafficLight extends JPanel {

    private final Graphics g;
    private final int thickness = 10;

    public JDrawingTrafficLight(Graphics g) {

        this.g = g;
        BorderTrafficLight();
        //ColorTrafficLight();
    }

    public void ColorTrafficLight(TrafficLightState state) {

        if (state != null) {
            switch (state) {
                //Semáforo cor vermelha
                case RED:
                    g.setColor(Color.decode("#cc1d00"));
                    g.fillOval(165 + thickness, 160 + thickness, 90 - 2 * thickness, 90 - 2 * thickness);
                    break;
                //Semáforo cor amarela
                case YELLOW:
                    g.setColor(Color.decode("#fde910"));
                    g.fillOval(265 + thickness, 160 + thickness, 90 - 2 * thickness, 90 - 2 * thickness);
                    break;
                //Semáforo cor verde
                case GREEN:
                    g.setColor(Color.decode("#00a000"));
                    g.fillOval(365 + thickness, 160 + thickness, 90 - 2 * thickness, 90 - 2 * thickness);
                    break;
                default:
                    break;
            }
        }

    }

    public void BorderTrafficLight() {

        //BORDA Semáforo cor vermelha
        g.setColor(Color.decode("#cc1d00"));
        g.drawOval(165, 160, 90, 90);
        g.drawOval(165 + thickness, 160 + thickness, 90 - 2 * thickness, 90 - 2 * thickness);

        //BORDA Semáforo cor amarela
        g.setColor(Color.decode("#fde910"));
        g.drawOval(265, 160, 90, 90);
        g.drawOval(265 + thickness, 160 + thickness, 90 - 2 * thickness, 90 - 2 * thickness);

        //BORDA Semáforo cor verde
        g.setColor(Color.decode("#00a000"));
        g.drawOval(365, 160, 90, 90);
        g.drawOval(365 + thickness, 160 + thickness, 90 - 2 * thickness, 90 - 2 * thickness);

    }
}
