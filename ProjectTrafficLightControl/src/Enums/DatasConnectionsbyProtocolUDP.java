/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author Lucas Alkimim Chaves
 */

public enum DatasConnectionsbyProtocolUDP {

    DATASCONNECTIONSUDP(9876, 4000, "localhost");

    private final int port;
    private final int time;
    private final String hostname;

    private DatasConnectionsbyProtocolUDP(int port, int time, String hostname) {

        this.port = port;
        this.time = time;
        this.hostname = hostname;

    }

    public int getPort() {

        return port;

    }

    public int getTime() {

        return time;

    }

    public String getHostname() {

        return hostname;

    }

}
