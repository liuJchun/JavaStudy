package liujianchun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * �������̴߳�����
 * @author Administrator
 *
 */
public class ServerThread extends Thread {
	//���߳���ص�Socket
	Socket socket=null;
	public ServerThread(Socket socket) {
		this.socket=socket;
	}
	
	//�߳�ִ�в�������Ӧ�ͻ��˵�����
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			//��ȡһ��������������ȡ�ͻ�����Ϣ
			InputStream is=socket.getInputStream();//�ֽ�������
			InputStreamReader isr=new InputStreamReader(is);//���ֽ�����װ���ַ���
			BufferedReader br=new BufferedReader(isr);//Ϊ��������ӻ���
			String info=null;
			while((info=br.readLine())!=null) {//ѭ����ȡ�ͻ��˵���Ϣ
				System.out.println("���Ƿ��������ͻ���˵��"+info);
			}
			socket.shutdownInput();//�ر�������
			
			//��ȡ������������ͻ��˵�����
			OutputStream os=socket.getOutputStream();//��ȡ�����u
			PrintWriter pw=new PrintWriter(os);//���������װ�ɴ�ӡ��
			pw.write("��ӭ�㣡");
			pw.flush();//ˢ�»������flush()�������������
			socket.shutdownOutput();//�ر������
			
			
			//�ر���Դ
			br.close();
			is.close();
			isr.close();
			pw.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
