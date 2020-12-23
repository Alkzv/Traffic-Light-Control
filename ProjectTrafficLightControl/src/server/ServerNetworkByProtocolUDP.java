package server;

import common.DatasConnectionsbyProtocolUDP;
import common.NetWrapper;
import common.TrafficLightState;
import java.io.*;
import java.net.*;
import java.util.Timer;
import java.util.TimerTask;
import server.view.ViewTrafficLightStateConnections;

/**
 *
 * @author Lucas Alkimim Chaves
 */
public class ServerNetworkByProtocolUDP {

    private String messagesCompactedtoViewTrafficLightStateConnections;
    private TrafficLightState currentStatus;
    private byte[] receiveData = new byte[1024];
    private NetWrapper netWrapper;
    byte[] sendData = new byte[1024];
    DatagramSocket serverSocket;
    RunViewTrafficLightStateConnections runViewTrafficLightStateConnections = new RunViewTrafficLightStateConnections();

    public ServerNetworkByProtocolUDP() {

        try {

            this.serverSocket = new DatagramSocket(DatasConnectionsbyProtocolUDP.DATASCONNECTIONSUDP.getPort());

        } catch (SocketException e) {

            System.out.println(e);

        }
    }

    public void ServerByProtocolUDP() {

        TimerTask task = new TimerTask() {

            @Override
            public void run() {

                try {

                    while (true) {

                        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                        serverSocket.receive(receivePacket);
                        sendData = receivePacket.getData();
                        InetAddress IPAddress = receivePacket.getAddress();
                        int port = receivePacket.getPort();
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(sendData);
                        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                        netWrapper = (NetWrapper) objectInputStream.readObject();
                        currentStatus = netWrapper.getState();
                        Thread.sleep(DatasConnectionsbyProtocolUDP.DATASCONNECTIONSUDP.getTime());
                        netWrapper.setState(TrafficLightState.nextState(netWrapper.getState()));
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        objectOutputStream.writeObject(netWrapper);
                        byte[] data = byteArrayOutputStream.toByteArray();
                        DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, port);
                        serverSocket.send(sendPacket);
                        MessagescompactedtoViewTrafficLightStateConnections(runViewTrafficLightStateConnections, IPAddress, port);

                    }

                } catch (IOException | ClassNotFoundException | InterruptedException e) {

                    System.out.println(e);

                }

            }

        };

        Timer timer = new Timer("Timer");

        timer.schedule(task, DatasConnectionsbyProtocolUDP.DATASCONNECTIONSUDP.getTime(), DatasConnectionsbyProtocolUDP.DATASCONNECTIONSUDP.getTime());

    }

    public void MessagescompactedtoViewTrafficLightStateConnections(RunViewTrafficLightStateConnections view, InetAddress IPAddress, int port) {

        messagesCompactedtoViewTrafficLightStateConnections = "***" + IPAddress + ":" + port + "\n" + "Old/previous status: " + currentStatus + "\n" + "New status: " + netWrapper.getState() + "\n\n";
        ViewTrafficLightStateConnections viewTrafficLightStateConnections = view.returnInterface();
        viewTrafficLightStateConnections.SetMessagesLogsInJPanelOfTheInterface(messagesCompactedtoViewTrafficLightStateConnections);

    }

}
