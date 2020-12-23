/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import server.view.ViewTrafficLightStateConnections;

/**
 * starts the ViewTrafficLightStateConnections graphical interface, which will
 * show the interactions between the server and the clients (traffic lights).
 *
 * @author Lucas Alkimim Chaves
 */
public class RunViewTrafficLightStateConnections {

    private ViewTrafficLightStateConnections mostra;

    /**
     * Constructor of the class
     *
     */
    public RunViewTrafficLightStateConnections() {

        mostra = new ViewTrafficLightStateConnections();
        mostra.setVisible(true);

    }

    /**
     * Return interface method
     *
     * @return ViewTrafficLightStateConnections - mostra
     */
    public ViewTrafficLightStateConnections returnInterface() {

        return mostra;

    }

}
