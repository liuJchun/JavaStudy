
/**
 * 1.ע����̵߳����ȼ�
 * 2.ע���Ƿ�ر��������������(����ͬһ��Socket,����ر������������������������SocketҲ�ᱻ�رգ�
 * 	  ����һ�㲻�ùر�����ֱ�ӹر�Socket����)
 */
package liujianchun;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ʵ�ֻ���TCPЭ���Socketͨ�ţ�ʵ���û���¼
 * ��������
 * @author Administrator
 *
 */
public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//1.����һ���������˿�Socket����ServerSocket��ָ���󶨶˿ڣ��������ö˿ڡ�
			ServerSocket serverSocket=new ServerSocket(8848);
			Socket socket=null;
			//��¼���ӿͻ��˵�����
			int count=0;
			System.out.println("***�����������������ȴ��ͻ�������***");
			//ѭ������ ���ȴ��ͻ��˵�����
			while(true) {
				//2.����accept()������ʼ�������ȴ��ͻ��˵����ӡ�
				socket=serverSocket.accept();
				//����һ���µ��߳�
				ServerThread serverThread=new ServerThread(socket);
				serverThread.setPriority(4);//�����߳����ȼ�����ΧΪ[1,10],Ĭ��Ϊ5
				//�����߳�
				serverThread.start();//�����߳�
				count++;//ͳ�ƿͻ��˵�����
				System.out.println("���Ƿ����������ӵĵ�"+count+"���ͻ���");
				InetAddress address=socket.getInetAddress();
				System.out.println("��ǰ�ͻ��˵�IP��ַΪ��"+address.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
