package liujianchun;

import java.net.MalformedURLException;
import java.net.URL;

public class TestURL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//����һ��URL��ʵ��
		try {
			URL imooc=new URL("http://www.imooc.com");
			//�����Ѿ����˵�URL�����µ�URL
			//?�����ʾ����  #��ʾê��
			URL url=new URL(imooc, "/index.html?username=tom#test");
			System.out.println("Э�飺"+url.getProtocol());
			System.out.println("�˿�"+url.getPort());
			//��δָ���˿ںţ���ʹ��Ĭ�ϵĶ˿ںţ���ʱ��getPort()�����ķ���ֵΪ-1
			System.out.println("������"+url.getHost());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
