/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 * enumeration that holds a set of constants in relation to the customer's states (traffic light).
 * @author Lucas Alkimim Chaves
 */
public enum TrafficLightState {

    RED,
    YELLOW,
    GREEN,
    OFF,
    ON;

    public static TrafficLightState nextState(TrafficLightState current) {

        TrafficLightState newState = TrafficLightState.OFF;

        switch (current) {

            case GREEN:

                newState = TrafficLightState.YELLOW;
                break;

            case OFF:

                newState = TrafficLightState.OFF;
                break;

            case ON:
                newState = TrafficLightState.RED;
                break;

            case RED:
                newState = TrafficLightState.GREEN;
                break;

            case YELLOW:
                newState = TrafficLightState.RED;
                break;

            default:
                newState = TrafficLightState.OFF;
                break;
        }

        return newState;

    }

}
