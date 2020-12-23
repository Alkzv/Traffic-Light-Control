/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.view.ViewTrafficLight;

/**
 * starts the graphical interface “ViewTrafficLight”, which will show the client
 * (traffic light).
 *
 * @author Lucas Alkimim Chaves
 */
public class RunViewTrafficLight {

    private ViewTrafficLight call;

    /**
     * Constructor of the class
     *
     */
    public RunViewTrafficLight() {

        call = new ViewTrafficLight();
        call.setVisible(true);

    }

    /**
     * Return interface method
     *
     * @return ViewTrafficLight - call
     */
    public ViewTrafficLight returnInterface() {

        return call;

    }

}
