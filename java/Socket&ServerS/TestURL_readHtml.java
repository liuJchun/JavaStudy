package liujianchun;

/**
 * URL��ȡwww.baidu.com��HTML��Ϣ
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TestURL_readHtml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url=new URL("https://www.baidu.com");
			//ͨ��URL��openStream()������ȡURL��ʾ��Դ���ֽ�������
			InputStream is=url.openStream();
			//���ֽ�������ת��Ϊ�ַ�������
			InputStreamReader isr=new InputStreamReader(is,"utf-8");
			//Ϊ�ַ���������ӻ��壬����ַ�����Ч��
			BufferedReader br=new BufferedReader(isr);
			String data=br.readLine();//��ȡ����
			while(data!=null) {//ѭ����ȡ����
				System.out.println(data);//�����ȡ������
				data=br.readLine();//��ȡ��һ��
				System.out.println();
			}
			//�ر������
			is.close();
			isr.close();
			br.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
