/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.view.ViewTrafficLight;

/**
 *
 * @author PC
 */
public class RunViewTrafficLight {

    private ViewTrafficLight clientWindow;

    public RunViewTrafficLight() {
       

            this.clientWindow = new ViewTrafficLight();
            clientWindow.start();
            
           // ViewTrafficLight mostra = new ViewTrafficLight();
            //mostra.setVisible(true);
            
    }
    
    public ViewTrafficLight getPanelClient()
    {
        return clientWindow;
    }

}
