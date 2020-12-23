/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.Serializable;

/**
 * packages the commands, which refer to the state of the client (semaphore), on
 * an object transferred over the network.
 *
 * @author Lucas Alkimim Chaves
 */
public class NetWrapper implements Serializable {

    private TrafficLightState state;

    /**
     * Constructor of the class
     *
     * @param state
     *
     */
    public NetWrapper(TrafficLightState state) {

        super();
        this.state = state;

    }

    /**
     * Return state method
     *
     * @return TrafficLightState - state
     */
    public final TrafficLightState getState() {
        return state;
    }

    /**
     * Method for setting state value
     *
     * @param state
     */
    public final void setState(TrafficLightState state) {

        this.state = state;

    }

}
