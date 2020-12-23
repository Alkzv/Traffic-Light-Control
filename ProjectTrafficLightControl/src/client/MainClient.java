/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 * calls and executes the class “ClientNetworkByProtocolUDP” that will do all the network treatment for the client module.
 * @author Lucas Alkimim Chaves
 */
public class MainClient {
/**
 * 
 * @param args 
 */
    public static void main(String[] args) {

        ClientNetworkByProtocolUDP call = new ClientNetworkByProtocolUDP();
        call.ClientByProtocolUDP();

    }

}
