package com.kadet.kadetBroker.to;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.rmi.UnknownHostException;
import java.util.Random;

/**
 * Date: 01.06.14
 * Time: 15:51
 *
 * @author SarokaA
 */
public class MacSystemTO implements SystemTO {


        /*InetAddress ip;
        try {

            ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            byte[] mac = network.getHardwareAddress();

            System.out.print("Current MAC address : ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }

            return sb.toString();


        } catch (SocketException e) {

            e.printStackTrace();

        } catch (java.net.UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
*/


    @Override
    public String getMacAddress() {


        return "123.123.123.123";
    }

}
