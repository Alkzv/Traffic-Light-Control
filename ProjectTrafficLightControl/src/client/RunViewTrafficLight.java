/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.view.ViewTrafficLight;

/**
 *
 * @author Lucas Alkimim Chaves
 */

public class RunViewTrafficLight {

    private ViewTrafficLight mostra;

    public RunViewTrafficLight() {
      
            mostra = new ViewTrafficLight();
            mostra.setVisible(true);
            
    }
    
    public ViewTrafficLight returnInterface()
    {
        return mostra;
    }

}
