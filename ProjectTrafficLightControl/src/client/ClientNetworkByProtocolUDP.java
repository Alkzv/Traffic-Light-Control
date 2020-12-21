package client;

import Enums.DatasConnectionsbyProtocolUDP;
import Enums.NetWrapper;
import Enums.TrafficLightState;
import client.view.ViewTrafficLight;
import java.io.*;
import java.net.*;

public class ClientNetworkByProtocolUDP {

    private byte[] inputData = new byte[1024];
    private NetWrapper params;

    public void ClientByProtocolUDP() {

        try {

            RunViewTrafficLight runViewTrafficLight = new RunViewTrafficLight();

            while (true) {

                if (params == null) {

                    TrafficLightState t = TrafficLightState.nextState(TrafficLightState.OFF);
                    params = new NetWrapper(t);

                } 

                System.out.println("--- CLIENT ---");

                InetAddress IPAddress = InetAddress.getByName(DatasConnectionsbyProtocolUDP.DATASCONNECTIONSUDP.getHostname());
                System.out.println(IPAddress);
                DatagramSocket datagramClientSocket = new DatagramSocket();

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(outputStream);
                os.writeObject(params);

                byte[] sendData = outputStream.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, DatasConnectionsbyProtocolUDP.DATASCONNECTIONSUDP.getPort());

                datagramClientSocket.send(sendPacket);

                System.out.println("Datagram send to server: " + sendPacket);
                System.out.println("State send: " + params.getState());

                DatagramPacket incomingPacket = new DatagramPacket(inputData, inputData.length);
                datagramClientSocket.receive(incomingPacket);

                byte[] dataIncoming = incomingPacket.getData();
                ByteArrayInputStream input = new ByteArrayInputStream(dataIncoming);
                ObjectInputStream objectInput = new ObjectInputStream(input);

                NetWrapper receivedObject = (NetWrapper) objectInput.readObject();
                System.out.println("Datagram received from server: " + receivedObject);
                System.out.println("State received: " + receivedObject.getState());

                datagramClientSocket.close();
                params.setState(receivedObject.getState());
                changeColorTrafficLight(runViewTrafficLight);

            }

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public void changeColorTrafficLight(RunViewTrafficLight view) {
        
        ViewTrafficLight viewTrafficLight = view.getPanelClient();
        viewTrafficLight.State(params.getState());
        viewTrafficLight.repaint();

    }

}
