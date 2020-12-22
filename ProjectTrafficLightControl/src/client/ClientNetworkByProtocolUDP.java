package client;

import Enums.DatasConnectionsbyProtocolUDP;
import Enums.NetWrapper;
import Enums.TrafficLightState;
import client.view.ViewTrafficLight;
import java.io.*;
import java.net.*;

/**
 *
 * @author Lucas Alkimim Chaves
 */
public class ClientNetworkByProtocolUDP {

    private byte[] inputData = new byte[1024];
    private NetWrapper netWrapper;

    public void ClientByProtocolUDP() {

        try {

            RunViewTrafficLight runViewTrafficLight = new RunViewTrafficLight();

            while (true) {

                if (netWrapper == null) {

                    TrafficLightState t = TrafficLightState.nextState(TrafficLightState.OFF);
                    netWrapper = new NetWrapper(t);

                }

                InetAddress IPAddress = InetAddress.getByName(DatasConnectionsbyProtocolUDP.DATASCONNECTIONSUDP.getHostname());
                DatagramSocket datagramClientSocket = new DatagramSocket();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(outputStream);
                os.writeObject(netWrapper);
                byte[] sendData = outputStream.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, DatasConnectionsbyProtocolUDP.DATASCONNECTIONSUDP.getPort());
                datagramClientSocket.send(sendPacket);
                DatagramPacket incomingPacket = new DatagramPacket(inputData, inputData.length);
                datagramClientSocket.receive(incomingPacket);
                byte[] dataIncoming = incomingPacket.getData();
                ByteArrayInputStream input = new ByteArrayInputStream(dataIncoming);
                ObjectInputStream objectInput = new ObjectInputStream(input);
                netWrapper = (NetWrapper) objectInput.readObject();
                netWrapper.setState(netWrapper.getState());
                datagramClientSocket.close();
                ChangeColorTrafficLight(runViewTrafficLight);

            }

        } catch (IOException | ClassNotFoundException e) {

            System.out.println(e);

        }

    }

    public void ChangeColorTrafficLight(RunViewTrafficLight view) {

        ViewTrafficLight viewTrafficLight = view.returnInterface();
        viewTrafficLight.setState(netWrapper.getState());
        viewTrafficLight.repaint();

    }

}
