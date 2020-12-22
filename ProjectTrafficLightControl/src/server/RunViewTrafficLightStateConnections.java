/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import server.view.ViewTrafficLightStateConnections;

/**
 *
 * @author Lucas Alkimim Chaves
 */

public class RunViewTrafficLightStateConnections {

    private ViewTrafficLightStateConnections mostra;

    public RunViewTrafficLightStateConnections() {

        mostra = new ViewTrafficLightStateConnections();
        mostra.setVisible(true);

    }

    public ViewTrafficLightStateConnections returnInterface() {
        
        return mostra;
        
    }

}
