package client;

import common.DatasConnectionsbyProtocolUDP;
import common.NetWrapper;
import common.TrafficLightState;
import client.view.ViewTrafficLight;
import java.io.*;
import java.net.*;

/**
 *
 * @author Roque Matheus Gomes Costa
 */
public class ClientNetworkByProtocolUDP {

    private byte[] receiveData = new byte[1024];
    private NetWrapper netWrapper = new NetWrapper(TrafficLightState.ON);

    public void ClientByProtocolUDP() {

        try {

            RunViewTrafficLight runViewTrafficLight = new RunViewTrafficLight();

            while (true) {

                InetAddress IPAddress = InetAddress.getByName(DatasConnectionsbyProtocolUDP.DATASCONNECTIONSUDP.getHostname());
                DatagramSocket datagramClientSocket = new DatagramSocket();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(netWrapper);
                byte[] sendData = byteArrayOutputStream.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, DatasConnectionsbyProtocolUDP.DATASCONNECTIONSUDP.getPort());
                datagramClientSocket.send(sendPacket);
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                datagramClientSocket.receive(receivePacket);
                byte[] data = receivePacket.getData();
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                netWrapper = (NetWrapper) objectInputStream.readObject();
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
