/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import common.TrafficLightState;

/**
 *
 * @author Roque Matheus Gomes Costa
 */
public class JDrawingTrafficLight extends JPanel {

    private final Graphics g;
    private final int thickness = 3;

    public JDrawingTrafficLight(Graphics g) {

        this.g = g;
        BorderTrafficLight();

    }

    public void ColorTrafficLight(TrafficLightState state) {

        if (state != null) {

            switch (state) {

                case RED:
                    g.setColor(Color.decode("#cc1d00"));
                    g.fillOval(107 + thickness, 160 + thickness, 90 - 2 * thickness, 90 - 2 * thickness);
                    break;

                case YELLOW:
                    g.setColor(Color.decode("#fde910"));
                    g.fillOval(207 + thickness, 160 + thickness, 90 - 2 * thickness, 90 - 2 * thickness);
                    break;

                case GREEN:
                    g.setColor(Color.decode("#00a000"));
                    g.fillOval(307 + thickness, 160 + thickness, 90 - 2 * thickness, 90 - 2 * thickness);
                    break;

                default:
                    break;

            }

        }

    }

    public final void BorderTrafficLight() {

        g.setColor(Color.decode("#cc1d00"));
        g.drawOval(107, 160, 90, 90);
        g.drawOval(107 + thickness, 160 + thickness, 90 - 2 * thickness, 90 - 2 * thickness);

        g.setColor(Color.decode("#fde910"));
        g.drawOval(207, 160, 90, 90);
        g.drawOval(207 + thickness, 160 + thickness, 90 - 2 * thickness, 90 - 2 * thickness);

        g.setColor(Color.decode("#00a000"));
        g.drawOval(307, 160, 90, 90);
        g.drawOval(307 + thickness, 160 + thickness, 90 - 2 * thickness, 90 - 2 * thickness);

    }

}
