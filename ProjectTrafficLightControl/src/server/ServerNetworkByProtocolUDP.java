package server;

import Enums.DatasConnectionsbyProtocolUDP;
import Enums.NetWrapper;
import Enums.TrafficLightState;
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
    private int contador = 0;
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

                        ByteArrayInputStream input = new ByteArrayInputStream(sendData);
                        ObjectInputStream objectInput = new ObjectInputStream(input);

                        netWrapper = (NetWrapper) objectInput.readObject();

                        currentStatus = netWrapper.getState();

                        if (netWrapper.getState() == TrafficLightState.OFF) {

                            TrafficLightState t = TrafficLightState.nextState(TrafficLightState.ON);
                            netWrapper = new NetWrapper(t);
                            contador = 1;

                        }

                        Thread.sleep(DatasConnectionsbyProtocolUDP.DATASCONNECTIONSUDP.getTime());

                        if (contador != 1) {

                            netWrapper.setState(TrafficLightState.nextState(netWrapper.getState()));

                        }

                        contador = 0;

                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                        ObjectOutputStream os = new ObjectOutputStream(outputStream);
                        os.writeObject(netWrapper);
                        byte[] dataOut = outputStream.toByteArray();
                        DatagramPacket sendPacket = new DatagramPacket(dataOut, dataOut.length, IPAddress, port);
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
