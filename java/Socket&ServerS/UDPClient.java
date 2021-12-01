package liujianchun;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	public static void main(String[] args) throws IOException {
		//1.����������ĵ�ַ���˿ںţ�����
		InetAddress address=InetAddress.getByName("localhost");
		int port=8525;
		byte[] data="�û�����admin;���룺123".getBytes();
		//2.�������ݱ����������͵�������Ϣ
		DatagramPacket packet=new DatagramPacket(data, data.length, address, port);
		//3.����DatagramSocket����
		DatagramSocket socket=new DatagramSocket();
		//4.��������������ݱ�
		socket.send(packet);
		
		/**
		 * ���շ���������Ӧ������
		 */
		//1.�������ݱ������ڽ��շ������˷��͵�����
		byte[] newData=new byte[1024];//��������������������
		DatagramPacket newPacket=new DatagramPacket
				(newData, newData.length, packet.getAddress(), packet.getPort());
		//2.���ܷ���������Ӧ������
		socket.receive(newPacket);
		//3.��ȡ����
		String reply=new String(newData, 0, newPacket.getLength());
		System.out.println("���ǿͻ��ˣ�������˵��"+reply);
		
		//5.�ر���Դ
		socket.close();
	}
}
