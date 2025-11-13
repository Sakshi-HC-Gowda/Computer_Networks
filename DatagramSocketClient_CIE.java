import java.net.*;
import java.util.Scanner;
public class DatagramSocketClient_CIE {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");

        byte[] sendData;
        byte[] receiveData = new byte[1024];

        System.out.println("*****Client Side*****");

        while (true) {
            System.out.print("Enter a number to cube (or type 'exit' to quit): ");
            String input = in.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting client.");
                break;
            }

            sendData = input.getBytes();

            // Send number to server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9000);
            clientSocket.send(sendPacket);

            // Receive response from server
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server response: " + response);
        }

        clientSocket.close();
        in.close();
    }
}
