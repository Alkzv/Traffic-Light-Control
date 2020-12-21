package server;

import Enums.DatasConnectionsbyProtocolUDP;
import Enums.NetWrapper;
import Enums.TrafficLightState;
import java.io.*;
import java.net.*;
import java.util.Timer;
import java.util.TimerTask;

public class ServerNetworkByProtocolUDP {

    private byte[] receiveData = new byte[1024];
    private int contador = 0;
    byte[] sendData = new byte[1024];
    DatagramSocket serverSocket;

    public ServerNetworkByProtocolUDP() {
        try {
            new RunViewTrafficLightStateConnections();
            this.serverSocket = new DatagramSocket(DatasConnectionsbyProtocolUDP.DATASCONNECTIONSUDP.getPort());

        } catch (SocketException e) {

            System.out.println(e);

        }
    }

    public void execute() {
        System.out.println("Execute");
        Timer timer = null;
        if (timer == null) {
            timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    try {
                        ServerByProtocolUDP();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            };
            timer.schedule(task, DatasConnectionsbyProtocolUDP.DATASCONNECTIONSUDP.getTime(), DatasConnectionsbyProtocolUDP.DATASCONNECTIONSUDP.getTime());
        }
    }

    public void ServerByProtocolUDP() {
        NetWrapper params;
        try {

            while (true) {
                System.out.println("--- SERVER ---");
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                sendData = receivePacket.getData();
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                ByteArrayInputStream input = new ByteArrayInputStream(sendData);
                ObjectInputStream objectInput = new ObjectInputStream(input);

                params = (NetWrapper) objectInput.readObject();
                System.out.println("Received from client: " + params);
                System.out.println("Current state: " + params.getState());

                if (params.getState() == TrafficLightState.OFF) {
           
                    TrafficLightState t = TrafficLightState.nextState(TrafficLightState.ON);
                    params = new NetWrapper(t);
                    System.out.println("New state: " + params.getState());
                    contador = 1;
                    
                }

                //params.setOnline();
                Thread.sleep(DatasConnectionsbyProtocolUDP.DATASCONNECTIONSUDP.getTime());

                if (contador != 1) {

                    params.setState(TrafficLightState.nextState(params.getState()));// ------------------------------------------
                    System.out.println("New state: " + params.getState());

                }
                
                contador = 0;
                
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(outputStream);
                os.writeObject(params);

                byte[] dataOut = outputStream.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(dataOut, dataOut.length, IPAddress, port);
                serverSocket.send(sendPacket);
                System.out.println("Send to client: " + dataOut);
                //DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, port);

            }

        } catch (Exception e) {

            System.out.println(e);

        }
    }

}
