/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author PC
 */
public class MainServer {

    public static void main(String[] args) {

        ServerNetworkByProtocolUDP call = new ServerNetworkByProtocolUDP();
        call.ServerByProtocolUDP();

    }

}
