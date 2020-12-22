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

    private ViewTrafficLight call;

    public RunViewTrafficLight() {

        call = new ViewTrafficLight();
        call.setVisible(true);

    }

    public ViewTrafficLight returnInterface() {

        return call;

    }

}
