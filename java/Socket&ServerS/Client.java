package liujianchun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ���
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//1.�����ͻ���Socket��ָ���������˵�ַ�Ͷ˿�
			Socket socket=new Socket(InetAddress.getLocalHost(), 8848);
			//2.��ȡ���������������˷�����Ϣ
			OutputStream os=socket.getOutputStream();//�ֽ������
			
			/**
			 * �ģ�ʹ��TCPͨ�Ŵ������һ�㲻���ַ������� ��һ���ö��������в���
					ObjectOutputStream oos=new ObjectOutputStream(os);
					User user=new User("admi","123");
					oos.writeObject(user);
			*/
			PrintWriter pw=new PrintWriter(os);//���������װ�ɴ�ӡ��
			pw.write("�û�����admin�����룺123");
			pw.flush();
			socket.shutdownOutput();//�ر������
			//3.��ȡһ�������� ����ȡ����������Ϣ
			InputStream is=socket.getInputStream();//��ȡ�ֽ�������
			InputStreamReader isr=new InputStreamReader(is);//�����ֽ�������ת�����ַ���
			BufferedReader br=new BufferedReader(isr);//Ϊ��������ӻ���
			String info=null;
			while((info=br.readLine())!=null) {
				System.out.println("���ǿͻ��ˣ�������˵��"+info);
			}
			socket.shutdownInput();//�ر�������
			
			//4..�ر���Դ
			pw.close();
			os.close();
			socket.close();
			br.close();
			isr.close();
			is.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
