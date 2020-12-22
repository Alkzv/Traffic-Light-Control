/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

import java.io.Serializable;

/**
 *
 * @author Lucas Alkimim Chaves
 */
public class NetWrapper implements Serializable {

    private TrafficLightState state;

    public NetWrapper(TrafficLightState state) {

        super();
        this.state = state;

    }

    public final TrafficLightState getState() {
        return state;
    }

    public final void setState(TrafficLightState state) {

        this.state = state;

    }

}
