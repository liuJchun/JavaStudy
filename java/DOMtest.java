/**
 * problem:������������ html ����html���ĵ��У����а��� ĳЩ����ǩ�����ܱ�ʶ���������
 */
package liujianchun;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		//����һ��DocumentBuilder����
		try {
			DocumentBuilder db=dbf.newDocumentBuilder();
			//ͨ��DocumentBuilder��parse�ķ������� xml �ļ�
			Document document=db.parse("test.xml");
			//��ȡ����div�Ľڵ�ļ���
			NodeList divlist=document.getElementsByTagName("div");
			System.out.println("div�ĳ��ȣ�"+divlist.getLength());
			//����ÿһ��div�ļ��Ͻڵ�
			for(int i=0;i<divlist.getLength();i++) {
				//ͨ��item(i)��������ȡһ��div�ڵ㣬nodeList������ֵ��0��ʼ
				Node div=divlist.item(i);
				//����div������
				//��ȡdiv �ı�ǩ���Եļ���
				NamedNodeMap attri=div.getAttributes();
				//����attribute�ļ���
				
				//��ȡ
				System.out.println("��"+(i+1)+"��div"+attri.getLength());
				for(int j=0;j<attri.getLength();j++) {
					//��ȡ����
					Node attr=attri.item(j);
					//��ȡ������
					System.out.println("��������"+attr.getNodeName());
					//��ȡ����ֵ
					System.out.println("----------------����ֵ��"+attr.getNodeValue());
					
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
