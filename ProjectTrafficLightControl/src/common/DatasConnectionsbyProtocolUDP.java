/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 * enumeration that holds a set of constants, that is, fixed data used in the
 * client relationship (semaphore) with the server via UDP protocol. Among some
 * of these data we have the constant attributes “port”, “hostname” and "time".
 *
 * @author Lucas Alkimim Chaves
 */
public enum DatasConnectionsbyProtocolUDP {

    DATASCONNECTIONSUDP(9876, 3000, "localhost");

    private final int port;
    private final int time;
    private final String hostname;

    /**
     * Constructor of the class enum
     *
     * @param port
     * @param time
     * @param hostname
     *
     */
    private DatasConnectionsbyProtocolUDP(int port, int time, String hostname) {

        this.port = port;
        this.time = time;
        this.hostname = hostname;

    }

    /**
     * Return port method
     *
     * @return int - Number of the port
     */
    public int getPort() {

        return port;

    }

    /**
     * Return time method
     *
     * @return int - Number of the time
     */
    public int getTime() {

        return time;

    }

    /**
     * Return hostname method
     *
     * @return String - Name of the hostname
     */
    public String getHostname() {

        return hostname;

    }

}
