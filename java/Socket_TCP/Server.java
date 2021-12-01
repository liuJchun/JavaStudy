package liujianchun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
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
			//2.����accept()������ʼ�������ȴ��ͻ��˵����ӡ�
			System.out.println("***�����������������ȴ��ͻ�������***");
			Socket socket=serverSocket.accept();
			//3.��ȡһ��������������ȡ�ͻ�����Ϣ
			InputStream is=socket.getInputStream();//�ֽ�������
			InputStreamReader isr=new InputStreamReader(is);//���ֽ�����װ���ַ���
			BufferedReader br=new BufferedReader(isr);//Ϊ��������ӻ���
			String info=null;
			while((info=br.readLine())!=null) {//ѭ����ȡ�ͻ��˵���Ϣ
				System.out.println("���Ƿ��������ͻ���˵��"+info);
			}
			socket.shutdownInput();//�ر�������
			
			//4.��ȡ������������ͻ��˵�����
			OutputStream os=socket.getOutputStream();//��ȡ�����u
			PrintWriter pw=new PrintWriter(os);//���������װ�ɴ�ӡ��
			pw.write("��ӭ�㣡");
			pw.flush();//ˢ�»������flush()�������������
			socket.shutdownOutput();//�ر������
			
			
			//5.�ر���Դ
			br.close();
			is.close();
			isr.close();
			socket.close();
			serverSocket.close();
			
			pw.close();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
