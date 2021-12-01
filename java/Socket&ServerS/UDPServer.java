package liujianchun;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * �������ˣ�ʵ�ֻ���UDP���û���½
 * @author Administrator
 *
 */
public class UDPServer {
	public static void main(String[] args) throws IOException {
		/**
		 * ���տͻ�������
		 */
		//1.�����������˵�DatagramSocket��ָ���˿ں�
		DatagramSocket socket=new DatagramSocket(8525);
		//2.����DatagramPacket(���ݱ�)�����ڽ��ܿͻ��˷��͵�����
		byte[] data=new byte[1024];
		DatagramPacket packet=new DatagramPacket(data, 0, data.length);
		
		//3.���տͻ��˷��͵�����
		System.out.println("***���������Ѿ��������ȴ��ͻ��˷�������***");
		socket.receive(packet);
		//4.��ȡ����
		String info=new String(data, 0, packet.getLength());
		System.out.println("���Ƿ��������ͻ���˵��"+info);
		
		/**
		 * ��Ӧ�ͻ�������
		 */
		//1.����ͻ��˵ĵ�ַ���˿ڣ�����
		InetAddress adress=packet.getAddress();
		int port=packet.getPort();
		byte[] newData="��ӭ�㣡".getBytes();
		//2.�������ݱ� ������Ӧ��������Ϣ
		DatagramPacket newPacket=new DatagramPacket(newData, 0, newData.length, adress, port);
		//3.��Ӧ�ͻ��ˣ�����DatagramStocket��send()�������͡�
		socket.send(newPacket);

		//�ر���Դ
		socket.close();
	}
}
